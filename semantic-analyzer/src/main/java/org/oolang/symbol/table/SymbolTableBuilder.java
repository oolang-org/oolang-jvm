/*
 * Copyright (c) 2026-present, Oolang contributors.
 * Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AstFile;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.RealElement;
import org.oolang.symbol.table.BaseSymbol.Function;
import org.oolang.symbol.table.BaseSymbol.Function.Parameter;
import org.oolang.symbol.table.BaseSymbol.Property;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.oolang.ast.element.RealElement.ElementType.PARAMETER;

public final class SymbolTableBuilder {
    // un-instantiable
    private SymbolTableBuilder() {
    }

    /**
     * @return a virtual {@linkplain OolangKlass class} representing the symbol table of the given {@link AstFile}.
     */
    public static @NonNull OolangKlass build(final @NonNull AstFile ast,
                                             final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert ast != null;

        final var symbolTable = OolangKlass.createRoot(ast.packageHeader.raw());
        for (final var element : ast.rootElements) {
            switch (element.elementType) {
                case CLASS -> visitClass(element,
                        symbolTable.addKlass(baseSymbol(element, true, true), false),
                        imports);
                case INTERFACE -> throw new UnsupportedOperationException("interface");
            }
        }
        return symbolTable;
    }

    private static void visitClass(final @NonNull RealElement classElement,
                                   final @NonNull OolangKlass klass,
                                   final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert classElement != null;
        assert klass != null;
        assert imports != null;

        for (final var child : classElement.children) {
            if (child instanceof ClassBody classBody) {
                visitClassBody(classBody.children, klass, imports);
            }
        }
    }

    private static void visitClassBody(final @NonNull List<@NonNull RealElement> children,
                                       final @NonNull OolangKlass klass,
                                       final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert children != null;
        assert klass != null;
        assert imports != null;

        for (final var child : children) {
            switch (child.elementType) {
                case FUN -> visitFunction(child, klass, imports);
                case VAR, VAL -> visitProperty(child, klass, imports);
                case CLASS -> visitClass(child,
                        klass.addKlass(baseSymbol(child, true, true), false),
                        imports);
                case INTERFACE, CONSTRUCTOR -> throw new UnsupportedOperationException();
                default -> throw new IllegalStateException("Unknown element: " + child.elementType);
            }
        }
    }

    private static void visitFunction(final @NonNull RealElement funElement,
                                      final @NonNull OolangKlass klass,
                                      final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert funElement != null;
        assert klass != null;
        assert imports != null;

        final var parameters = new ArrayList<@NonNull Parameter>();
        for (final var child : funElement.children) {
            if (child instanceof RealElement element && element.elementType == PARAMETER) {
                assert element.identifier != null;
                final var paramName = element.identifier.identifier; // a function parameter has a simple identifier
                assert element.type != null;
                parameters.add(new Parameter(paramName, new LazyType(element.type, imports)));
            }
        }

        klass.functions.add(new Function(
                klass,
                baseSymbol(funElement, false, true),
                new LazyType(funElement.type, imports),
                parameters));
    }

    private static void visitProperty(final @NonNull RealElement propertyElement,
                                      final @NonNull OolangKlass klass,
                                      final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert propertyElement != null;
        assert klass != null;
        assert imports != null;

        final var baseSymbol = baseSymbol(propertyElement, false,
                propertyElement.elementType == RealElement.ElementType.VAL);

        // type can be explicit or will be inferred by the expression type during semantic analysis
        final LazyType propType = (propertyElement.type != null)
                ? new LazyType(propertyElement.type, imports)
                : null;
        klass.properties()
                .put(baseSymbol.name, new Property(klass, baseSymbol, propType));
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
