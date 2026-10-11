/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AstFile;
import org.oolang.ast.Identifier;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.statement.ConstructorCodeBlock;
import org.oolang.symbol.table.BaseSymbol.Function;
import org.oolang.symbol.table.BaseSymbol.Function.Parameter;
import org.oolang.symbol.table.BaseSymbol.Property;

import java.lang.constant.ConstantDescs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.oolang.ast.element.RealElement.ElementType.CONSTRUCTOR;
import static org.oolang.ast.element.RealElement.ElementType.PARAMETER;

public final class SymbolTableBuilder {
    // un-instantiable
    private SymbolTableBuilder() {
    }

    /// @return a virtual [class][OolangKlass] representing the symbol table of the given [AstFile].
    public static @NonNull OolangKlass build(final @NonNull AstFile ast,
                                             final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert ast != null;
        assert imports != null;

        final var symbolTable = OolangKlass.createRoot(ast.packageHeader.raw(), imports);
        for (final var element : ast.rootElements) {
            switch (element.elementType) {
                case CLASS -> visitClass(element,
                        symbolTable.addKlass(baseSymbol(element, true, true), false));
                case INTERFACE -> throw new UnsupportedOperationException("interface");
            }
        }
        return symbolTable;
    }

    private static void visitClass(final @NonNull RealElement classElement,
                                   final @NonNull OolangKlass klass) {
        assert classElement != null;
        assert klass != null;

        for (final var child : classElement.children) {
            if (child instanceof ClassBody classBody) {
                visitClassBody(classBody.children, klass);
            }
        }
    }

    private static void visitClassBody(final @NonNull List<@NonNull RealElement> children,
                                       final @NonNull OolangKlass klass) {
        assert children != null;
        assert klass != null;

        var hasConstructor = false;
        var hasInstanceFunOrProp = false;
        for (final var child : children) {
            switch (child.elementType) {
                case CONSTRUCTOR -> {
                    hasConstructor = true;
                    visitFunction(child, klass, true);
                }
                case FUN -> {
                    final var function = visitFunction(child, klass, false);
                    if (!function.isStatic) {
                        hasInstanceFunOrProp = true;
                    }
                }
                case VAR, VAL -> {
                    final var property = visitProperty(child, klass);
                    if (!property.isStatic) {
                        hasInstanceFunOrProp = true;
                    }
                }
                case CLASS -> visitClass(child,
                        klass.addKlass(baseSymbol(child, true, true), false));
                case INTERFACE -> throw new UnsupportedOperationException("interface");
                default -> throw new IllegalStateException("Unknown element: " + child.elementType);
            }
        }

        // if no explicit constructor was found, add a public empty default constructor and visit it
        if (!hasConstructor && hasInstanceFunOrProp) {
            final var defaultConstructor = new RealElement(CONSTRUCTOR);
            defaultConstructor.identifier = new Identifier.SimpleIdentifier(ConstantDescs.INIT_NAME);
            defaultConstructor.children.add(new ConstructorCodeBlock());
            children.add(defaultConstructor);
            visitFunction(defaultConstructor, klass, true);
        }
    }

    private static @NonNull Function visitFunction(final @NonNull RealElement funElement,
                                                   final @NonNull OolangKlass klass,
                                                   final boolean isConstructor) {
        assert funElement != null;
        assert klass != null;

        final var parameters = new ArrayList<@NonNull Parameter>();
        for (final var child : funElement.children) {
            if (child instanceof RealElement element && element.elementType == PARAMETER) {
                assert element.identifier != null;
                final var paramName = element.identifier.identifier; // a function parameter has a simple identifier
                assert element.type != null;
                parameters.add(new Parameter(paramName, new LazyType(element.type, klass)));
            }
        }

        final var function = new Function(
                klass,
                baseSymbol(funElement, false, true),
                isConstructor ? null : new LazyType(funElement.type, klass),
                parameters);
        klass.functions.add(function);
        return function;
    }

    private static @NonNull Property visitProperty(final @NonNull RealElement propertyElement,
                                                   final @NonNull OolangKlass klass) {
        assert propertyElement != null;
        assert klass != null;

        final var baseSymbol = baseSymbol(propertyElement, false,
                propertyElement.elementType == RealElement.ElementType.VAL);

        // type can be explicit or will be inferred by the expression type during semantic analysis
        final LazyType propType = (propertyElement.type != null)
                ? new LazyType(propertyElement.type, klass)
                : null;
        final var property = new Property(klass, baseSymbol, propType);
        klass.properties().put(baseSymbol.name, property);
        return property;
    }

    private static @NonNull BaseSymbol baseSymbol(final @NonNull RealElement element,
                                                  final boolean defaultStatic,
                                                  final boolean defaultFinal) {
        assert element != null;

        assert element.identifier != null;
        final var name = element.identifier.identifier; // a function, property or class has a simple identifier

        Visibility visibility = null;
        var isStatic = defaultStatic; // a class is static by default
        var isAbstract = false;
        var isFinal = defaultFinal;
        for (final var modifier : element.modifiers) {
            switch (modifier.modifier) {
                case "private" -> visibility = Visibility.PRIVATE;
                case "static" -> isStatic = true;
                case "abstract" -> isAbstract = true;
                case "protected" -> visibility = Visibility.OOLANG_PROTECTED;
                case "open" -> isFinal = false;
                case "inner" -> isStatic = false;
                case "public" -> visibility = Visibility.PUBLIC;
                case "final" -> isFinal = true;
            }
        }

        return new BaseSymbol(
                name, (visibility != null) ? visibility : Visibility.PUBLIC, isStatic, isAbstract, isFinal);
    }
}
