/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.oolang.ast.AstFile;
import org.oolang.ast.Identifier.SimpleIdentifier;
import org.oolang.ast.Import;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.LoadExpression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.symbol.table.BaseSymbol.Function;
import org.oolang.symbol.table.BaseSymbol.Property;
import org.oolang.symbol.table.*;
import org.oolang.symbol.table.Variable.SimpleVariable;

import java.util.*;

import static org.oolang.ast.element.RealElement.ElementType.PROPERTY_INITIALIZER;
import static org.oolang.ast.expression.JvmInvocationUtils.*;
import static org.oolang.ast.expression.RealExpression.ExpressionType.FUN_CALL_PARAMETER;
import static org.oolang.ast.expression.RealExpression.ExpressionType.PROP_ACCESS;
import static org.oolang.symbol.table.TypeResolver.*;
import static org.oolang.symbol.table.Visibility.PRIVATE;

public final class OolangSemanticAnalyzer {
    // un-instantiable
    private OolangSemanticAnalyzer() {
    }

    public static void semanticAnalysis(final @NonNull AstFile ast) {
        Objects.requireNonNull(ast);

        final var imports = buildImports(ast.imports);

        // build the symbol table
        final var symbolTable = SymbolTableBuilder.build(ast, imports);

        for (final var element : ast.rootElements) {
            final var scopes = new Scopes();
            switch (element.elementType) {
                case CLASS -> {
                    assert symbolTable.klasses != null;
                    visitClass(element, scopes, symbolTable.klasses.get(elementName(element)), imports);
                }
                case INTERFACE -> throw new UnsupportedOperationException("interface");
                default -> throw new IllegalStateException("Unknown element: " + element.elementType);
            }
        }
    }

    private static void visitClass(final @NonNull RealElement classElement,
                                   final @NonNull Scopes scopes,
                                   final @NonNull OolangKlass klass,
                                   final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert classElement != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        final Scopes effectiveScopes = (klass.isStatic)
                ? scopes.newScopes() // static class = start a new fresh Scopes
                : scopes;

        for (final var child : classElement.children) {
            if (child instanceof ClassBody classBody) {
                effectiveScopes.push();
                visitClassBody(classBody, scopes, klass, imports);
                effectiveScopes.pop();
            }
        }
    }

    private static void visitClassBody(final @NonNull ClassBody classBody,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass klass,
                                       final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert classBody != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        // first loop to resolve all properties and add them to the current scope
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case VAR, VAL -> visitProperty(child, scopes, klass, imports);
            }
        }

        // then loop for everything else
        var funIndex = 0;
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case CONSTRUCTOR, FUN -> visitFunction(child, scopes, klass, funIndex++, imports);
                case CLASS -> {
                    assert klass.klasses != null;
                    visitClass(child, scopes, klass.klasses.get(elementName(child)), imports);
                }
                case INTERFACE -> throw new UnsupportedOperationException("interface");
            }
        }
    }

    private static void visitProperty(final @NonNull RealElement propertyElement,
                                      final @NonNull Scopes scopes,
                                      final @NonNull OolangKlass klass,
                                      final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert propertyElement != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        final var property = klass.properties().get(elementName(propertyElement));
        final var typeOrNull = property.typeOrNull(); // resolve property type if explicit
        if (typeOrNull == null) { // else infer type from the property's expression
            assert propertyElement.children.size() == 1;
            assert propertyElement.children.getFirst() instanceof RealElement realElement
                    && realElement.elementType == PROPERTY_INITIALIZER;

            final var propertyInitializer = (RealElement) propertyElement.children.getFirst();
            final var propertyExpression = (Expression) propertyInitializer.children.getFirst();
            final var propertyType = visitExpression(propertyExpression, scopes, klass, imports);
            property.setType(propertyType);
            // also set the property's descriptor string
            propertyElement.setDescriptorString(TypeResolver.getKlassFromType(propertyType).descriptorString());
        }

        scopes.current.putProperty(property);
    }

    private static void visitFunction(final @NonNull RealElement funElement,
                                      final @NonNull Scopes scopes,
                                      final @NonNull OolangKlass klass,
                                      final int funIndex,
                                      final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert funElement != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        assert klass.functions != null;
        final var function = klass.functions.get(funIndex);
        //noinspection ResultOfMethodCallIgnored
        function.returnType(); // resolve function's return type

        final Scopes effectiveScopes = (function.isStatic)
                ? scopes.newScopes() // static function = start a new fresh Scopes
                : scopes;
        if (!function.isAbstract) {
            effectiveScopes.push();
        }

        for (final var parameter : function.parameters) {
            final var parameterType = parameter.type(); // resolve function param type
            if (!function.isAbstract) {
                effectiveScopes.current.putVariable(parameter.name, parameterType, true);
            }
        }

        if (!function.isAbstract) {
            // code block is the last child of a non-abstract function
            visitCodeBlock((CodeBlock) funElement.children.getLast(), effectiveScopes, klass, imports);
            effectiveScopes.pop();
        }
    }

    private static void visitCodeBlock(final @NonNull CodeBlock codeBlock,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass klass,
                                       final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert codeBlock != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        for (final var statement : codeBlock.statements) {
            switch (statement) {
                case RealStatement realStatement -> visitStatement(realStatement, scopes, klass, imports);
                default -> throw new UnsupportedOperationException("Unsupported statement: " + statement);
            }
        }
    }

    private static void visitStatement(final @NonNull RealStatement statement,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass klass,
                                       final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert statement != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        for (final var child : statement.children) {
            switch (child) {
                case Expression expression -> visitExpression(expression, scopes, klass, imports);
                default -> throw new UnsupportedOperationException("Unsupported statement child: " + child);
            }
        }
    }

    private static @NonNull Type visitExpression(final @NonNull Expression expression,
                                                 final @NonNull Scopes scopes,
                                                 final @NonNull OolangKlass klass,
                                                 final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert expression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        return switch (expression) {
            case RealExpression realExpression -> visitRealExpression(realExpression, scopes, klass, imports);
            case ConstantExpression constantExpression -> {
                final var constantKlass = TypeResolver.getKlassFromConstantDesc(constantExpression.value);
                constantExpression.setDescriptorString(constantKlass.descriptorString());
                yield constantKlass;
            }
            case LoadExpression _ -> throw new IllegalStateException("Unexpected load expression");
        };
    }

    private static @NonNull Type visitRealExpression(final @NonNull RealExpression realExpression,
                                                     final @NonNull Scopes scopes,
                                                     final @NonNull OolangKlass klass,
                                                     final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert realExpression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        return switch (realExpression.type) {
            case ADD -> visitAdditiveExpression(realExpression, scopes, klass, imports);
            case INDEXING -> visitIndexingExpression(realExpression, scopes, klass, imports);
            case FUN_CALL -> visitFunCallExpression(realExpression, scopes, klass, imports);
            case VARIABLE_OR_PROP_ACCESS -> visitVariableOrPropAccessExpression(realExpression, scopes, klass, imports);
            default -> throw new UnsupportedOperationException("Unsupported expression type: " + realExpression.type);
        };
    }

    private static @NonNull Type visitAdditiveExpression(final @NonNull RealExpression additiveExpression,
                                                         final @NonNull Scopes scopes,
                                                         final @NonNull OolangKlass klass,
                                                         final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert additiveExpression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        var isStringConcat = false;
        for (final var child : additiveExpression.children) {
            final var childType = visitExpression(child, scopes, klass, imports);
            if (childType == STRING_KLASS) {
                isStringConcat = true;
            }
        }

        if (isStringConcat) {
            additiveExpression.setDescriptorString(STRING_KLASS.descriptorString());
            return STRING_KLASS;
        }
        throw new UnsupportedOperationException("Unsupported non string additive expression");
    }

    private static @NonNull Type visitIndexingExpression(final @NonNull RealExpression indexingExpression,
                                                         final @NonNull Scopes scopes,
                                                         final @NonNull OolangKlass klass,
                                                         final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert indexingExpression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        final var callerType = resolveCaller(indexingExpression, scopes, klass, imports, true);
        final var indexType = visitExpression(indexingExpression.children.getLast(), scopes, klass, imports);

        final var caller = TypeResolver.getKlassFromType(callerType);
        if (caller.isArray()) {
            if (indexType != INT_KLASS) {
                throw new OolangSemanticException("Indexing expression must be of type Int");
            }
            // get the component type of this array
            final var componentType = caller.componentType();
            assert componentType != null;
            indexingExpression.setDescriptorString(TypeResolver.getKlassFromType(componentType).descriptorString());
            return componentType;
        }
        throw new UnsupportedOperationException("todo List / Map indexing operations");
    }

    private static @NonNull Type visitVariableOrPropAccessExpression(
            final @NonNull RealExpression variableOrPropAccessExpression,
            final @NonNull Scopes scopes,
            final @NonNull OolangKlass klass,
            final @NonNull Map<@NonNull String, @NonNull String> imports
    ) {
        assert variableOrPropAccessExpression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        return resolveCaller(variableOrPropAccessExpression, scopes, klass, imports, true);
    }

    private static @NonNull Type visitFunCallExpression(final @NonNull RealExpression funCallExpression,
                                                        final @NonNull Scopes scopes,
                                                        final @NonNull OolangKlass klass,
                                                        final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert funCallExpression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        final var callerType = (funCallExpression.identifiers.size() == 1) ? klass
                : resolveCaller(funCallExpression, scopes, klass, imports, false);

        // last step: resolve the function to call and its parameters
        final var funName = funCallExpression.identifiers.getFirst().identifier;
        final var funParameters = new ArrayList<@NonNull Type>();
        for (final var rawFunChild : funCallExpression.children) {
            if (rawFunChild instanceof RealExpression funChild && funChild.type == FUN_CALL_PARAMETER) {
                funParameters.add(visitFunParameter(funChild, scopes, klass, imports));
            }
        }

        final var caller = TypeResolver.getKlassFromType(callerType);
        var includeProtected = false;
        for (final var superType : klass.genericSuperKlasses()) {
            if (TypeResolver.getKlassFromType(superType).equals(caller)) {
                includeProtected = true;
                break;
            }
        }
        final var function = caller.accessibleFunction(funName, funParameters, includeProtected);
        if (function == null) {
            throw new OolangSemanticException("Could not resolve function '" + funName +
                    "' from class " + caller.descriptorString());
        }
        funCallExpression.invocation = functionInvocation(caller, function);
        funCallExpression.ownerDescriptorString = function.declaringKlass.descriptorString();
        funCallExpression.setDescriptorString(function.descriptorString());
        funCallExpression.typeDescriptorString = function.typeDescriptorString();
        return function.returnType();
    }

    private static @NonNull Type visitFunParameter(final @NonNull RealExpression funChild,
                                                   final @NonNull Scopes scopes,
                                                   final @NonNull OolangKlass klass,
                                                   final @NonNull Map<@NonNull String, @NonNull String> imports) {
        assert funChild != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        if (!funChild.identifiers.isEmpty()) {
            throw new UnsupportedOperationException("Resolution of variable as parameter not implemented");
        }
        // else there is an expression to resolve
        return visitExpression(funChild.children.getFirst(), scopes, klass, imports);
    }

    private static @NonNull String functionInvocation(final @NonNull Klass caller, final @NonNull Function function) {
        assert caller != null;
        assert function != null;

        if (function.isStatic) {
            return INVOKE_STATIC;
        }
        if (function.declaringKlass.isInterface()) {
            return INVOKE_INTERFACE;
        }
        if (function.visibility == PRIVATE
                || !caller.equals(function.declaringKlass)
                || function.name.equals(CONSTRUCTOR_NAME)) {
            return INVOKE_SPECIAL;
        }
        return INVOKE_VIRTUAL;
        // todo INVOKE_DYNAMIC
    }

    private static @NonNull Type resolveCaller(final @NonNull RealExpression expression,
                                               final @NonNull Scopes scopes,
                                               final @NonNull OolangKlass klass,
                                               final @NonNull Map<@NonNull String, @NonNull String> imports,
                                               final boolean untilLast) {
        assert expression != null;
        assert scopes != null;
        assert klass != null;
        assert imports != null;

        var idIndex = 0;
        // if untilLast is false, we must keep the last identifier for function name
        final var lastIdIndex = expression.identifiers.size() - (untilLast ? 0 : 1);

        var id = expression.identifiers.get(idIndex++);
        var identifier = id.identifier;
        var childIndex = 0;

        // 1) first identifier may refer to a property or variable from this class's scope
        var variableOrProperty = scopes.resolveVariable(identifier);

        if (variableOrProperty == null) {
            // 2) else, first identifier may refer to a property from a parent
            variableOrProperty = klass.accessibleProperty(identifier, false);
        }

        Klass caller;
        if (variableOrProperty != null) {
            final var variableOrPropertyExpression = switch (variableOrProperty) {
                case SimpleVariable variable -> loadExpression(variable, id);
                case Property property -> propAccessExpression(property, id);
            };
            // mutate AST to add variable or property access call expression upfront
            expression.children.add(childIndex++, variableOrPropertyExpression);

            // caller becomes variable or property's klass
            caller = getKlassFromType(variableOrProperty.type());

        } else {
            // 3) else, identifier is a static class access
            caller = resolveKlassFromSimpleName(identifier, imports);
            while (caller == null && idIndex < lastIdIndex) {
                identifier = identifier + "." + expression.identifiers.get(idIndex++).identifier;
                caller = getKlassFromName(identifier);
            }

            if (caller == null) {
                throw new OolangSemanticException("Could not resolve static klass from identifiers " + identifier);
            }
        }

        while (idIndex < lastIdIndex) { // chained properties until last identifier
            id = expression.identifiers.get(idIndex++);
            identifier = id.identifier;
            final var property = caller.accessibleProperty(identifier, true);
            if (property == null) {
                throw new OolangSemanticException("Could not resolve property " + identifier +
                        " from class " + caller.descriptorString());
            }
            // mutate AST to add property call expression upfront
            final var propAccessExpression = propAccessExpression(property, id);
            expression.children.add(childIndex++, propAccessExpression);
            // caller becomes property's klass
            caller = getKlassFromType(property.type());
        }

        // clean identifiers after property access
        expression.identifiers.subList(0, lastIdIndex).clear();

        return caller;
    }

    private static @NonNull LoadExpression loadExpression(final @NonNull SimpleVariable variable,
                                                          final @NonNull SimpleIdentifier id) {
        assert variable != null;
        assert id != null;

        return new LoadExpression(id,
                variable.slot(),
                TypeResolver.getKlassFromType(variable.type()).descriptorString());
    }

    private static @NonNull RealExpression propAccessExpression(final @NonNull Property property,
                                                                final @NonNull SimpleIdentifier id) {
        assert property != null;
        assert id != null;

        final var propAccessExpression = new RealExpression(PROP_ACCESS);
        propAccessExpression.identifiers.add(id);
        propAccessExpression.invocation = property.isStatic ? GET_STATIC : GET_FIELD;
        propAccessExpression.ownerDescriptorString = property.declaringKlass.descriptorString();
        propAccessExpression.setDescriptorString(property.descriptorString());
        // set AST info from the identifier
        propAccessExpression.setInfo(id.info());

        return propAccessExpression;
    }

    static @NonNull Map<@NonNull String, @NonNull String> buildImports(
            final @NonNull List<@NonNull Import> astImports
    ) {
        assert astImports != null;

        final var imports = new HashMap<@NonNull String, @NonNull String>(astImports.size());
        for (final var astImport : astImports) {
            // the key in the map is either the import alias or the last element of its identifiers
            imports.put(
                    (astImport.alias != null) ? astImport.alias.rawName() : astImport.identifiers.getLast().rawName(),
                    astImport.raw());
        }
        return imports;
    }

    private static @NonNull String elementName(final @NonNull RealElement element) {
        assert element != null;

        assert element.identifier != null;
        return element.identifier.identifier; // a function, property or class has a simple identifier
    }

    private static final @NonNull String CONSTRUCTOR_NAME = "<init>";
}
