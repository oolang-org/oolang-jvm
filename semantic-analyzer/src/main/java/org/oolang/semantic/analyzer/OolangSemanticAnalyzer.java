/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstFile;
import org.oolang.ast.Identifier.SimpleIdentifier;
import org.oolang.ast.Import;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.ElementModifier;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.LoadExpression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.ConstructorCodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.ast.statement.Statement;
import org.oolang.symbol.table.*;
import org.oolang.symbol.table.Variable.SimpleVariable;

import java.lang.constant.ConstantDescs;
import java.util.*;

import static org.oolang.JvmInvocationUtils.*;
import static org.oolang.ast.element.ElementModifier.ModifierType.INHERITANCE;
import static org.oolang.ast.element.RealElement.ElementType.PROPERTY_INITIALIZER;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;
import static org.oolang.ast.statement.RealStatement.StatementType.ASSIGNMENT;
import static org.oolang.ast.statement.RealStatement.StatementType.RETURN;
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
            assert symbolTable.klasses != null;
            final var klass = symbolTable.klasses.get(elementName(element));
            assert klass != null;
            if (klass.isInterface()) {
                throw new UnsupportedOperationException("interface");
            } else {
                visitClass(element, scopes, klass);
            }
        }
    }

    private static void visitClass(final @NonNull RealElement classElement,
                                   final @NonNull Scopes scopes,
                                   final @NonNull OolangKlass currentKlass) {
        assert classElement != null;
        assert scopes != null;
        assert currentKlass != null;

        final Scopes effectiveScopes = (currentKlass.isStatic)
                ? scopes.enterStatic() // static class = start a new fresh Scopes
                : scopes;

        for (final var child : classElement.children) {
            if (child instanceof ClassBody classBody) {
                effectiveScopes.pushKlass(currentKlass);
                visitClassBody(classBody, effectiveScopes, currentKlass);
                effectiveScopes.popKlass();
            }
        }
    }

    private static void visitClassBody(final @NonNull ClassBody classBody,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass currentKlass) {
        assert classBody != null;
        assert scopes != null;
        assert currentKlass != null;

        // the inline assignments for constructors
        final var initializedPropAssignments = new ArrayList<@NonNull RealStatement>();
        // first loop to resolve all properties and add them to the current scope
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case VAR, VAL -> {
                    final var propAssignment = visitProperty(child, scopes, currentKlass);
                    if (propAssignment != null) {
                        initializedPropAssignments.add(propAssignment);
                    }
                }
            }
        }

        // then loop for everything else
        var funIndex = 0;
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case CONSTRUCTOR, FUN ->
                        visitFunction(child, scopes, currentKlass, funIndex++, initializedPropAssignments);
                case CLASS -> {
                    assert currentKlass.klasses != null;
                    visitClass(child, scopes, currentKlass.klasses.get(elementName(child)));
                }
                case INTERFACE -> throw new UnsupportedOperationException("interface");
            }
        }
    }

    /// If this property is not static (= instance) and has an initializer, return the inline assignment for constructors
    private static @Nullable RealStatement visitProperty(final @NonNull RealElement propertyElement,
                                                         final @NonNull Scopes scopes,
                                                         final @NonNull OolangKlass currentKlass) {
        assert propertyElement != null;
        assert scopes != null;
        assert currentKlass != null;

        final var property = currentKlass.properties().get(elementName(propertyElement));
        scopes.putProperty(property);

        try {
            for (final var child : propertyElement.children) {
                if (child instanceof RealElement realElement && realElement.elementType == PROPERTY_INITIALIZER) {
                    final var propertyExpression = (Expression) realElement.children.getFirst();
                    final var propertyType = visitExpression(propertyExpression, scopes, currentKlass, null);

                    final var lateinitType = property.lateinitTypeOrNull();
                    if (lateinitType != null) { // infer type from the property's expression
                        lateinitType.setType(propertyType);
                        // also set the property's descriptor string
                        propertyElement.setDescriptorString(getKlassFromType(propertyType).descriptorString());
                    }

                    // if property is not static (= instance), build and return the inline assignment for constructors
                    if (!property.isStatic) {
                        return buildAssignmentForConstructor(propertyExpression, propertyElement, scopes, currentKlass);
                    }
                }
            }
        } finally {
            // always resolve the property's type
            property.type();
        }

        return null;
    }

    private static @NonNull RealStatement buildAssignmentForConstructor(final @NonNull Expression propertyExpression,
                                                                        final @NonNull RealElement propertyElement,
                                                                        final @NonNull Scopes scopes,
                                                                        final @NonNull OolangKlass currentKlass) {
        assert propertyExpression != null;
        assert propertyElement != null;
        assert scopes != null;
        assert currentKlass != null;

        // build the assigned property
        final var assignedPart = new RealExpression(CHAINABLE);
        // 1) load this
        loadThis(assignedPart, scopes);
        // 2) resolve value to assign to the property = the prop initializer expression
        assignedPart.children.add(propertyExpression);
        // 3) assign property to its value
        final var propAssignmentExpression = new RealExpression(PROP_ASSIGNMENT);
        propAssignmentExpression.identifiers.add(new SimpleIdentifier(elementName(propertyElement)));
        propAssignmentExpression.ownerDescriptorString = currentKlass.descriptorString();
        propAssignmentExpression.invocation = PUT_FIELD;
        final var propDescriptorString = propertyElement.descriptorString();
        assert propDescriptorString != null;
        propAssignmentExpression.setDescriptorString(propDescriptorString);
        propAssignmentExpression.parent = assignedPart;
        assignedPart.children.add(propAssignmentExpression);

        final var assignment = new RealStatement(ASSIGNMENT);
        assignment.children.add(assignedPart);
        return assignment;
    }

    private static void visitFunction(final @NonNull RealElement funElement,
                                      final @NonNull Scopes scopes,
                                      final @NonNull OolangKlass currentKlass,
                                      final int funIndex,
                                      final @NonNull List<@NonNull RealStatement> initializedPropAssignments) {
        assert funElement != null;
        assert scopes != null;
        assert currentKlass != null;
        assert initializedPropAssignments != null;

        assert currentKlass.functions != null;
        final var function = currentKlass.functions.get(funIndex);
        function.returnType(); // resolve function's return type

        final Scopes effectiveScopes = (function.isStatic)
                ? scopes.enterStatic() // static function = start a new fresh Scopes
                : scopes;

        if (!function.isAbstract) {
            effectiveScopes.pushFunction(function.isStatic);
        }

        for (final var parameter : function.parameters) {
            final var parameterType = parameter.type(); // resolve function param type
            if (!function.isAbstract) {
                effectiveScopes.putVariable(parameter.name, parameterType, true, function.isStatic);
            }
        }

        if (!function.isAbstract) {
            // code block is the last child of a non-abstract function
            switch (funElement.children.getLast()) {
                case CodeBlock codeBlock -> visitCodeBlock(codeBlock, effectiveScopes, currentKlass);
                case ConstructorCodeBlock constructorCodeBlock -> {
                    // add the "open" inheritance modifier, a constructor cannot be final
                    funElement.modifiers.add(new ElementModifier(INHERITANCE, "open"));
                    visitConstructorCodeBlock(constructorCodeBlock, effectiveScopes, currentKlass);
                    // add initialized property assignments upfront in early larval
                    constructorCodeBlock.earlyLarvalStatements.addAll(0, initializedPropAssignments);
                }
                case RealExpression realExpression -> {
                    // 1) visit the expression
                    final var expressionType = visitRealExpression(realExpression, effectiveScopes, currentKlass,
                            null);
                    funElement.setDescriptorString(getKlassFromType(expressionType).descriptorString());

                    // 2) add a body function with a single return expression
                    final var codeBlock = new CodeBlock();
                    final var statement = new RealStatement(RETURN);
                    codeBlock.statements.add(statement);
                    statement.children.add(realExpression);
                    // replace the single expression with the new code block
                    funElement.children.set(funElement.children.size() - 1, codeBlock);
                }
                default -> throw new IllegalStateException("Unexpected value: " + funElement.children.getLast());
            }
            effectiveScopes.popFunction(function.isStatic);
        }
    }

    private static void visitCodeBlock(final @NonNull CodeBlock codeBlock,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass currentKlass) {
        assert codeBlock != null;
        assert scopes != null;
        assert currentKlass != null;

        for (final var statement : codeBlock.statements) {
            visitStatement(statement, scopes, currentKlass);
        }
    }

    private static void visitConstructorCodeBlock(ConstructorCodeBlock constructorCodeBlock,
                                                  final @NonNull Scopes scopes,
                                                  final @NonNull OolangKlass currentKlass) {
        assert constructorCodeBlock != null;
        assert scopes != null;
        assert currentKlass != null;

        for (final var earlyLarvalStatement : constructorCodeBlock.earlyLarvalStatements) {
            visitStatement(earlyLarvalStatement, scopes, currentKlass);
        }

        if (constructorCodeBlock.initCall != null) {
            assert constructorCodeBlock.initCall.expressionType == FUN_CALL;
            visitFunCallExpression(constructorCodeBlock.initCall, scopes, currentKlass, null);
        } else {
            // Build an implicit call to no-arg super constructor
            final var chainableExpression = new RealExpression(CHAINABLE);
            loadThis(chainableExpression, scopes);

            final var implicitSuperConstructorCall = new RealExpression(FUN_CALL);
            implicitSuperConstructorCall.identifiers.add(new SimpleIdentifier(ConstantDescs.INIT_NAME));
            final var superType = currentKlass.genericSuperKlasses().getFirst();
            implicitSuperConstructorCall.ownerDescriptorString = getKlassFromType(superType).descriptorString();
            implicitSuperConstructorCall.invocation = INVOKE_SPECIAL;
            implicitSuperConstructorCall.typeDescriptorString = "()V";
            chainableExpression.children.add(implicitSuperConstructorCall);

            constructorCodeBlock.initCall = chainableExpression;
        }

        for (final var lateLarvalStatement : constructorCodeBlock.lateLarvalStatements) {
            visitStatement(lateLarvalStatement, scopes, currentKlass);
        }
    }

    /// Add a load of the current klass in the provided expression if it is a `chainable`, else add it upfront.
    private static void loadThis(final @NonNull RealExpression expression, final @NonNull Scopes scopes) {
        assert expression != null;
        assert scopes != null;

        final var thisVariable = (SimpleVariable) scopes.resolveVariable("this");
        assert thisVariable != null;
        final var loadThis = loadExpression(thisVariable, new SimpleIdentifier("this"));
        if (expression.parent != null) {
            // add loadThis upfront
            addNewExpressionInAst(expression, loadThis);
        } else {
            assert expression.expressionType == CHAINABLE;
            expression.children.add(loadThis);
        }
    }

    private static void visitStatement(final @NonNull Statement statement,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass currentKlass) {
        switch (statement) {
            case RealStatement realStatement -> visitRealStatement(realStatement, scopes, currentKlass);
            default -> throw new UnsupportedOperationException("Unsupported statement: " + statement);
        }
    }

    private static void visitRealStatement(final @NonNull RealStatement realStatement,
                                           final @NonNull Scopes scopes,
                                           final @NonNull OolangKlass currentKlass) {
        assert realStatement != null;
        assert scopes != null;
        assert currentKlass != null;

        for (final var childExpression : realStatement.children) {
            visitExpression(childExpression, scopes, currentKlass, null);
        }
    }

    /// @param applicableKlass the [Klass] this expression applies to. If null, the scope's current klass is used.
    private static @NonNull ActualType visitExpression(final @NonNull Expression expression,
                                                       final @NonNull Scopes scopes,
                                                       final @NonNull OolangKlass currentKlass,
                                                       final @Nullable Klass applicableKlass) {
        assert expression != null;
        assert scopes != null;
        assert currentKlass != null;

        return switch (expression) {
            case RealExpression realExpression ->
                    visitRealExpression(realExpression, scopes, currentKlass, applicableKlass);
            case ConstantExpression constantExpression -> {
                final var constantKlass = TypeResolver.getKlassFromConstantDesc(constantExpression.value);
                constantExpression.setDescriptorString(constantKlass.descriptorString());
                yield constantKlass;
            }
            case LoadExpression _ -> throw new IllegalStateException("Unexpected load expression");
        };
    }

    private static @NonNull ActualType visitRealExpression(final @NonNull RealExpression realExpression,
                                                           final @NonNull Scopes scopes,
                                                           final @NonNull OolangKlass currentKlass,
                                                           final @Nullable Klass applicableKlass) {
        assert realExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        return switch (realExpression.expressionType) {
            case CHAINABLE -> visitChainableExpression(realExpression, scopes, currentKlass);
            case ADD -> visitAdditiveExpression(realExpression, scopes, currentKlass);
            case INDEXING -> visitIndexingExpression(realExpression, scopes, currentKlass, applicableKlass);
            case VARIABLE_OR_PROP_ACCESS ->
                    visitVariableOrPropAccessExpression(realExpression, scopes, currentKlass, applicableKlass);
            case FUN_CALL -> visitFunCallExpression(realExpression, scopes, currentKlass, applicableKlass);
            default -> throw new UnsupportedOperationException("Unsupported expression type: " +
                    realExpression.expressionType);
        };
    }

    private static @NonNull ActualType visitChainableExpression(final @NonNull RealExpression chainableExpression,
                                                                final @NonNull Scopes scopes,
                                                                final @NonNull OolangKlass currentKlass) {
        assert chainableExpression != null;
        assert !chainableExpression.children.isEmpty();
        assert scopes != null;
        assert currentKlass != null;

        // iterate on a copy of chained expressions, because this chain may be updated while iterating
        ActualType lastType = null;
        for (final var child : List.copyOf(chainableExpression.children)) {
            lastType = visitExpression(
                    child,
                    scopes,
                    currentKlass,
                    (lastType != null) ? getKlassFromType(lastType) : null);
        }
        assert lastType != null;

        // if there is only one child after visiting, replace this chained expression with its only child
        if (chainableExpression.children.size() == 1
                && chainableExpression.children.getFirst() instanceof RealExpression onlyChild) {
            chainableExpression.replaceWith(onlyChild);
        } else {
            chainableExpression.setDescriptorString(getKlassFromType(lastType).descriptorString());
        }

        return lastType;
    }

    private static @NonNull ActualType visitAdditiveExpression(final @NonNull RealExpression additiveExpression,
                                                               final @NonNull Scopes scopes,
                                                               final @NonNull OolangKlass currentKlass) {
        assert additiveExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        var isStringConcat = false;
        for (final var child : additiveExpression.children) {
            final var childType = visitExpression(child, scopes, currentKlass, null);
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

    private static @NonNull ActualType visitIndexingExpression(final @NonNull RealExpression indexingExpression,
                                                               final @NonNull Scopes scopes,
                                                               final @NonNull OolangKlass currentKlass,
                                                               final @Nullable Klass applicableKlass) {
        assert indexingExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        final var callerType = visitVariableOrPropAccessChain(
                indexingExpression, scopes, currentKlass, applicableKlass, true);
        final var indexType = visitExpression(
                indexingExpression.children.getLast(), scopes, currentKlass, null);

        final var caller = getKlassFromType(callerType);
        if (caller.isArray()) {
            if (indexType != INT_PRIMITIVE_KLASS) {
                throw new OolangSemanticException("Indexing expression must be of type Int");
            }
            // get the component type of this array
            final var componentType = caller.componentType();
            assert componentType != null;
            indexingExpression.setDescriptorString(getKlassFromType(componentType).descriptorString());
            return componentType;
        }
        throw new UnsupportedOperationException("todo List / Map indexing operations");
    }

    private static @NonNull ActualType visitVariableOrPropAccessExpression(
            final @NonNull RealExpression variableOrPropAccessExpression,
            final @NonNull Scopes scopes,
            final @NonNull OolangKlass currentKlass,
            final @Nullable Klass applicableKlass
    ) {
        assert variableOrPropAccessExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        return visitVariableOrPropAccessChain(
                variableOrPropAccessExpression, scopes, currentKlass, applicableKlass, true);
    }

    private static @NonNull ActualType visitFunCallExpression(final @NonNull RealExpression funCallExpression,
                                                              final @NonNull Scopes scopes,
                                                              final @NonNull OolangKlass currentKlass,
                                                              final @Nullable Klass applicableKlass) {
        assert funCallExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        final Klass caller;
        if (funCallExpression.type != null) {
            // constructor call
            caller = getKlassFromType(TypeResolver.resolveType(funCallExpression.type, currentKlass, false));
            // NEW instruction to allocate memory
            final var newExpression = new RealExpression(NEW);
            newExpression.setDescriptorString(caller.descriptorString());
            // mutate AST to add NEW expression upfront
            addNewExpressionInAst(funCallExpression, newExpression);
        } else if (funCallExpression.identifiers.size() == 1) {
            // a simple fun call without prefix
            if (applicableKlass != null) {
                caller = applicableKlass;
            } else {
                loadThis(funCallExpression, scopes);
                caller = currentKlass;
            }
        } else {
            // a fun call with prefix, like 'System.out.println'
            caller = getKlassFromType(visitVariableOrPropAccessChain(
                    funCallExpression, scopes, currentKlass, applicableKlass, false));
        }

        // resolve the function to call and its parameters
        final var funParameters = new ArrayList<@NonNull ActualType>();
        for (final var rawFunChild : funCallExpression.children) {
            if (rawFunChild instanceof RealExpression funChild && funChild.expressionType == FUN_CALL_PARAMETER) {
                if (!funChild.identifiers.isEmpty()) {
                    throw new UnsupportedOperationException("Resolution of named parameter not implemented yet");
                }
                funParameters.add(visitFunCallParameter(funChild, scopes, currentKlass));
            }
        }

        // search super classes for caller. If present, we can access its protected functions
        var includeProtected = false;
        for (final var superType : currentKlass.genericSuperKlasses()) {
            if (getKlassFromType(superType).equals(caller)) {
                includeProtected = true;
                break;
            }
        }

        final var funName = funCallExpression.identifiers.getFirst().identifier;
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

    private static @NonNull ActualType visitFunCallParameter(final @NonNull RealExpression funChild,
                                                             final @NonNull Scopes scopes,
                                                             final @NonNull OolangKlass currentKlass) {
        assert funChild != null;
        assert scopes != null;
        assert currentKlass != null;

        // resolve fun parameter expression
        return visitExpression(funChild.children.getFirst(), scopes, currentKlass, null);
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
                || function.name.equals(ConstantDescs.INIT_NAME)) {
            return INVOKE_SPECIAL;
        }
        return INVOKE_VIRTUAL;
        // todo INVOKE_DYNAMIC
    }

    private static @NonNull ActualType visitVariableOrPropAccessChain(final @NonNull RealExpression expression,
                                                                      final @NonNull Scopes scopes,
                                                                      final @NonNull OolangKlass currentKlass,
                                                                      final @Nullable Klass applicableKlass,
                                                                      final boolean untilLast) {
        assert expression != null;
        assert scopes != null;
        assert currentKlass != null;


        var idIndex = new IndexHolder();
        // if untilLast is false, we must keep the last identifier for function name
        final var lastIdIndex = expression.identifiers.size() - (untilLast ? 0 : 1);

        var caller = (applicableKlass != null)
                ? getFirstPropAccessInApplicableKlass(expression, applicableKlass, idIndex)
                : firstVariableOrPropAccessInCurrentKlass(expression, scopes, currentKlass, idIndex, lastIdIndex);

        while (idIndex.value < lastIdIndex) { // chained properties until last identifier
            final var id = expression.identifiers.get(idIndex.value++);
            final var property = caller.accessibleProperty(id.identifier, true);
            if (property == null) {
                throw new OolangSemanticException("Could not resolve property " + id.identifier +
                        " from class " + caller.descriptorString());
            }
            final var propAccessExpression = propAccessExpression(property, id);
            // mutate AST to add property call expression upfront
            addNewExpressionInAst(expression, propAccessExpression);

            // caller becomes property's klass
            caller = getKlassFromType(property.type());
        }

        // clean identifiers after property access(es)
        expression.identifiers.subList(0, lastIdIndex).clear();

        return caller;
    }

    private static @NonNull Klass getFirstPropAccessInApplicableKlass(final @NonNull RealExpression expression,
                                                                      final @NonNull Klass applicableKlass,
                                                                      final @NonNull IndexHolder idIndex) {
        assert expression != null;
        assert applicableKlass != null;
        assert idIndex != null;

        final var id = expression.identifiers.get(idIndex.value++);
        final var identifier = id.identifier;

        final var property = applicableKlass.accessibleProperty(identifier, true);
        if (property == null) {
            throw new OolangSemanticException("Property '" + identifier + "' not found in class " +
                    applicableKlass.descriptorString());
        }

        final var propertyExpression = propAccessExpression(property, id);
        // mutate AST to add variable or property access call expression upfront
        addNewExpressionInAst(expression, propertyExpression);

        return getKlassFromType(property.type());
    }

    private static @NonNull Klass firstVariableOrPropAccessInCurrentKlass(final @NonNull RealExpression expression,
                                                                          final @NonNull Scopes scopes,
                                                                          final @NonNull OolangKlass currentKlass,
                                                                          final @NonNull IndexHolder idIndex,
                                                                          final int lastIdIndex) {
        assert expression != null;
        assert scopes != null;
        assert currentKlass != null;
        assert idIndex != null;

        final var id = expression.identifiers.get(idIndex.value++);
        var identifier = id.identifier;

        // 1) first identifier may refer to a property or variable from this class's scope
        var variableOrProperty = scopes.resolveVariable(identifier);

        if (variableOrProperty == null) {
            // 2) else, first identifier may refer to a property from a parent
            variableOrProperty = currentKlass.accessibleProperty(identifier, false);
        }

        if (variableOrProperty != null) {
            switch (variableOrProperty) {
                case SimpleVariable variable -> {
                    final var variableAccess = loadExpression(variable, id);
                    // mutate AST to add variable access call expression upfront
                    addNewExpressionInAst(expression, variableAccess);
                }
                case Property property -> {
                    final var propertyAccess = propAccessExpression(property, id);
                    // mutate AST to add variable access call expression upfront
                    addNewExpressionInAst(expression, propertyAccess);
                    if (!property.isStatic) {
                        // must load current klass
                        loadThis(propertyAccess, scopes);
                    }
                }
            }

            return getKlassFromType(variableOrProperty.type());
        }

        // 3) else, identifier is a static class access
        var caller = resolveKlassFromSimpleName(identifier, currentKlass);
        while (caller == null && idIndex.value < lastIdIndex) {
            identifier = identifier + "." + expression.identifiers.get(idIndex.value++).identifier;
            caller = getKlassFromName(identifier);
        }

        if (caller == null) {
            throw new OolangSemanticException("Could not resolve static klass from identifier " + identifier);
        }
        return caller;
    }

    private static void addNewExpressionInAst(final @NonNull RealExpression expression,
                                              final @NonNull Expression newExpression) {
        assert expression != null;
        assert expression.parent != null;
        assert expression.parent.expressionType == CHAINABLE;
        assert newExpression != null;

        if (newExpression instanceof RealExpression newRealExpression) {
            newRealExpression.parent = expression.parent;
        }

        final var indexOfExpression = expression.parent.children.indexOf(expression);
        // "expression" was at index X in the parent list.
        // Inserts "newExpression" at index X, pushing "expression" to X + 1
        expression.parent.children.add(indexOfExpression, newExpression);
        // also remove temporary VAR_OR_PROP_ACCESS
        if (expression.expressionType == VARIABLE_OR_PROP_ACCESS) {
            expression.parent.children.remove(indexOfExpression + 1);
        }
    }

    private static @NonNull LoadExpression loadExpression(final @NonNull SimpleVariable variable,
                                                          final @NonNull SimpleIdentifier id) {
        assert variable != null;
        assert id != null;

        return new LoadExpression(id,
                variable.slot(),
                getKlassFromType(variable.type()).descriptorString());
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
        // set AST info from the identifier, if any
        if (id.info() != null) {
            propAccessExpression.setInfo(id.info());
        }

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

    private static final class IndexHolder {
        private int value = 0;
    }
}
