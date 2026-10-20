/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.symbol.table;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstFile;
import org.oolang.ast.Identifier.SimpleIdentifier;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.ElementModifier;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.ConstructorCodeBlock;
import org.oolang.symbol.table.BaseSymbol.Function;
import org.oolang.symbol.table.BaseSymbol.Function.Parameter;
import org.oolang.symbol.table.BaseSymbol.Property;

import java.lang.constant.ConstantDescs;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.oolang.ast.element.ElementModifier.ModifierType.VISIBILITY;
import static org.oolang.ast.element.RealElement.ElementType.*;
import static org.oolang.ast.expression.ExpressionUtils.addExpressionToChain;
import static org.oolang.ast.expression.RealExpression.ExpressionType.CHAINABLE;
import static org.oolang.ast.expression.RealExpression.ExpressionType.VARIABLE_OR_PROP_ACCESS;

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
        // first iteration without properties
        for (final var child : children) {
            switch (child.elementType) {
                case CONSTRUCTOR -> {
                    hasConstructor = true;
                    visitFunction(child, klass, klass);
                }
                case FUN -> {
                    final var function = visitFunction(child, klass, null);
                    if (!function.isStatic) {
                        hasInstanceFunOrProp = true;
                    }
                }
                case CLASS -> visitClass(child,
                        klass.addKlass(baseSymbol(child, true, true), false));
                case INTERFACE -> throw new UnsupportedOperationException("interface");
            }
        }
        // second iteration for properties only on a copy of children, because this list may be updated with new
        // functions while iterating
        for (final var child : List.copyOf(children)) {
            switch (child.elementType) {
                case VAR, VAL -> {
                    final var property = visitProperty(child, children, klass);
                    if (!property.isStatic) {
                        hasInstanceFunOrProp = true;
                    }
                }
            }
        }

        // if no explicit constructor was found, add a public empty default constructor and visit it
        if (!hasConstructor && hasInstanceFunOrProp) {
            final var defaultConstructor = new RealElement(CONSTRUCTOR);
            defaultConstructor.identifier = new SimpleIdentifier(ConstantDescs.INIT_NAME);
            defaultConstructor.children.add(new ConstructorCodeBlock());
            children.add(defaultConstructor);
            visitFunction(defaultConstructor, klass, klass);
        }
    }

    private static @NonNull Function visitFunction(final @NonNull RealElement funElement,
                                                   final @NonNull OolangKlass klass,
                                                   final @Nullable Type returnType) {
        assert funElement != null;
        assert klass != null;

        final var parameters = new ArrayList<@NonNull Parameter>();
        for (final var child : funElement.children) {
            if (child instanceof RealElement element && element.elementType == PARAMETER) {
                assert element.identifier != null;
                final var paramName = element.identifier.identifier; // a function parameter has a simple identifier
                assert element.type != null;
                parameters.add(new Parameter(paramName, new Type.Lazy(element.type, klass)));
            }
        }

        final var function = new Function(
                klass,
                baseSymbol(funElement, false, true),
                (returnType != null) ? returnType : new Type.Lazy(funElement.type, klass),
                parameters);
        klass.functions.add(function);
        return function;
    }

    /// Visit a property, optionally adding functions for getter and setter
    ///
    /// @param propertyElement the element
    /// @param children        The child nodes of the current class, where we add the property and optional getter and
    ///                        setter functions.
    /// @param klass           the current class we are building
    /// @return the property
    private static @NonNull Property visitProperty(final @NonNull RealElement propertyElement,
                                                   final @NonNull List<@NonNull RealElement> children,
                                                   final @NonNull OolangKlass klass) {
        assert propertyElement != null;
        assert children != null;
        assert klass != null;

        final var baseSymbol = baseSymbol(propertyElement, false,
                propertyElement.elementType == RealElement.ElementType.VAL);

        final Type propType;
        // 1) type is explicit
        if (propertyElement.type != null) {
            propType = new Type.Lazy(propertyElement.type, klass);
        } else {
            // 2) type can be directly inferred for some cases, or it will have to be resolved during semantic analysis
            Klass klassOrNull = null;
            for (final var child : propertyElement.children) {
                if (child instanceof RealElement realElement && realElement.elementType == PROPERTY_INITIALIZER) {
                    klassOrNull = TypeResolver.inferKlass((Expression) realElement.children.getFirst());
                    break;
                }
            }
            if (klassOrNull != null) {
                propertyElement.setDescriptorString(klassOrNull.descriptorString());
                propType = klassOrNull;
            } else {
                propType = new Type.Lateinit();
            }
        }

        final var property = new Property(klass, baseSymbol, propType);

        // if not private, also add a getter function and visit it
        if (!property.isStatic && property.visibility != Visibility.PRIVATE) {
            final var getterFunction = buildAndVisitGetterFunction(propertyElement, klass, property, propType);
            children.add(getterFunction);
        }

        klass.properties().put(baseSymbol.name, property);
        return property;
    }

    private static @NonNull RealElement buildAndVisitGetterFunction(final @NonNull RealElement propertyElement,
                                                                    final @NonNull OolangKlass klass,
                                                                    final @NonNull Property property,
                                                                    final @NonNull Type propType) {


        final var getterFunction = new RealElement(FUN);
        getterFunction.identifier = new SimpleIdentifier(property.name);
        final var chainableExpression = new RealExpression(CHAINABLE);
        final var propAccessExpression = new RealExpression(VARIABLE_OR_PROP_ACCESS);
        propAccessExpression.identifiers.add(new SimpleIdentifier(property.name));
        addExpressionToChain(chainableExpression, propAccessExpression);
        getterFunction.children.add(chainableExpression);

        property.getter = visitFunction(getterFunction, klass, propType);

        // the AST property element becomes private
        var hasVisibility = false;
        for (final var modifier : propertyElement.modifiers) {
            if (modifier.type == VISIBILITY) {
                modifier.modifier = "private";
                hasVisibility = true;
            }
        }
        if (!hasVisibility) {
            propertyElement.modifiers.add(new ElementModifier(VISIBILITY, "private"));
        }

        return getterFunction;
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
