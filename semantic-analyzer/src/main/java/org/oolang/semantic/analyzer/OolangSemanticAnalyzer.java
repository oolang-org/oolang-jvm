/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.semantic.analyzer;

import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.AstFile;
import org.oolang.ast.Identifier.SimpleIdentifier;
import org.oolang.ast.Import;
import org.oolang.ast.RealAstType;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.ElementModifier;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.DelegateExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.ConstructorCodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.symbol.table.*;

import java.lang.constant.ConstantDescs;
import java.util.*;

import static org.oolang.JvmInvocationUtils.*;
import static org.oolang.ast.element.ElementModifier.ModifierType.INHERITANCE;
import static org.oolang.ast.element.RealElement.ElementType.*;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;
import static org.oolang.ast.statement.RealStatement.StatementType.ASSIGNMENT;
import static org.oolang.ast.statement.RealStatement.StatementType.RETURN;
import static org.oolang.symbol.table.Klass.*;
import static org.oolang.symbol.table.SemanticAnalysisUtils.*;
import static org.oolang.symbol.table.TypeResolver.*;
import static org.oolang.symbol.table.Visibility.PRIVATE;

public final class OolangSemanticAnalyzer {
    private final @NonNull AstFile ast;
    private final @NonNull OolangKlass symbolTable;

    public OolangSemanticAnalyzer(final @NonNull AstFile ast) {
        this.ast = Objects.requireNonNull(ast);
        // build the symbol table
        this.symbolTable = SymbolTableBuilder.build(ast, buildImports(ast.imports));
    }

    public void semanticAnalysis() {
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

        final Scopes effectiveScopes = (currentKlass.isStatic())
                ? scopes.enterStatic() // static class = start a new fresh Scopes
                : scopes;

        if (classElement.children.isEmpty()) {
            return;
        }

        currentKlass.resolveAncestors(); // resolve all ancestors' lazy types
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
        RealElement primaryConstructor = null;
        // first loop: visit properties. Each can return a constructor assignment statement
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case PRIMARY_CONSTRUCTOR -> {
                    for (final var constructorChild : child.children) {
                        if (constructorChild instanceof RealElement realElement
                                && (realElement.elementType == VAL || realElement.elementType == VAR)) {
                            visitProperty(realElement, scopes, currentKlass);
                            initializedPropAssignments.add(propAssignment(elementName(realElement)));
                        }
                    }
                    primaryConstructor = child;
                }
                case VAL, VAR -> {
                    final var propAssignment = visitProperty(child, scopes, currentKlass);
                    if (propAssignment != null) {
                        initializedPropAssignments.add(propAssignment);
                    }
                }
            }
        }

        // complete primary constructor with property assignments
        if (primaryConstructor != null && !initializedPropAssignments.isEmpty()) {
            ((ConstructorCodeBlock) primaryConstructor.children.getLast())
                    .initBlock.statements.addAll(initializedPropAssignments);
            initializedPropAssignments.clear();
        }

        // then loop for everything else
        var funIndex = 0;
        for (final var child : classBody.children) {
            switch (child.elementType) {
                case PRIMARY_CONSTRUCTOR, CONSTRUCTOR ->
                        visitConstructor(child, scopes, currentKlass, funIndex++, initializedPropAssignments);
                case FUN -> visitFunction(child, scopes, currentKlass, funIndex++);
                case CLASS -> {
                    assert currentKlass.klasses != null;
                    visitClass(child, scopes, currentKlass.klasses.get(elementName(child)));
                }
                case INTERFACE -> throw new UnsupportedOperationException("interface");
            }
        }
    }

    /// If this property is not static (= instance) and has an initializer, return the inline assignment for
    /// constructors
    private static @Nullable RealStatement visitProperty(final @NonNull RealElement propertyElement,
                                                         final @NonNull Scopes scopes,
                                                         final @NonNull OolangKlass currentKlass) {
        assert propertyElement != null;
        assert scopes != null;
        assert currentKlass != null;

        final var property = currentKlass.rawProperties.get(elementName(propertyElement));

        Expression propertyValueExpression = null;
        try {
            for (final var child : propertyElement.children) {
                if (child instanceof RealElement realElement && realElement.elementType == PROPERTY_INITIALIZER) {
                    final var realPropValueExpression = (Expression) realElement.children.getFirst();
                    // visit the value expression and replace it with an already visited one
                    final var propertyType = visitExpression(realPropValueExpression, scopes, currentKlass,
                            null);

                    // only set the descriptor string if type was not explicit or inferred
                    final var lateinitType = property.lateinitTypeOrNull();
                    if (lateinitType != null) { // infer type from the property's expression
                        lateinitType.setType(propertyType);
                    }

                    // if property is not static (= instance), we must build and return the inline assignment to
                    // initialize this prop in constructors
                    if (!property.isStatic()) {
                        propertyValueExpression = new AlreadyVisitedExpression(realPropValueExpression, propertyType);
                    }
                    break;
                }
            }
        } finally {
            // always resolve the property's type
            final var type = property.type();
            propertyElement.descriptorString(getKlassFromType(type).descriptorString());
        }

        return (propertyValueExpression != null)
                ? propAssignment(elementName(propertyElement), propertyValueExpression)
                : null;
    }

    private static @NonNull RealExpression buildVariableStore(final @NonNull Expression variableExpression,
                                                              final @NonNull RealElement variableElement,
                                                              final int slot,
                                                              final @NonNull OolangKlass currentKlass) {
        assert variableExpression != null;
        assert variableElement != null;
        assert currentKlass != null;

        // build the assigned variable
        final var storeExpression = new RealExpression(CHAINABLE);
        // 1) resolve value to assign to the variable = the initializer expression
        storeExpression.children.add(variableExpression);
        // 2) assign variable to its value
        final var variableStoreExpression = new RealExpression(VARIABLE_STORE);
        variableStoreExpression.identifiers.add(new SimpleIdentifier(elementName(variableElement)));
        variableStoreExpression.slot = slot;
        final var variableDescriptorString = variableElement.descriptorString();
        assert variableDescriptorString != null;
        variableStoreExpression.descriptorString(variableDescriptorString);
        variableStoreExpression.parent = storeExpression;
        storeExpression.children.add(variableStoreExpression);

        return storeExpression;
    }

    private static void visitConstructor(final @NonNull RealElement constructorElement,
                                         final @NonNull Scopes scopes,
                                         final @NonNull OolangKlass currentKlass,
                                         final int funIndex,
                                         final @NonNull List<@NonNull RealStatement> initializedPropAssignments) {
        assert constructorElement != null;
        assert scopes != null;
        assert currentKlass != null;
        assert initializedPropAssignments != null;

        final var constructorFunction = currentKlass.rawFunctions.get(funIndex);
        assert !constructorFunction.isAbstract();
        assert !constructorFunction.isStatic();

        // add the "open" inheritance modifier, a constructor cannot be final
        constructorElement.modifiers.add(new ElementModifier(INHERITANCE, "open"));

        scopes.pushFunction(false, true);

        visitParameters(constructorFunction, scopes);

        final var constructorCodeBlock = ((ConstructorCodeBlock) constructorElement.children.getLast());
        // add initialized property assignments upfront in init phase, if any
        if (!initializedPropAssignments.isEmpty()) {
            constructorCodeBlock.initBlock.statements.addAll(initializedPropAssignments);
        }
        visitConstructorCodeBlock(constructorCodeBlock, scopes, currentKlass);

        constructorFunction.type(); // resolve the constructor's type
        constructorElement.descriptorString(currentKlass.descriptorString());

        scopes.popFunction(false);
    }

    private static void visitFunction(final @NonNull RealElement functionElement,
                                      final @NonNull Scopes scopes,
                                      final @NonNull OolangKlass currentKlass,
                                      final int funIndex) {
        assert functionElement != null;
        assert scopes != null;
        assert currentKlass != null;

        final var function = currentKlass.rawFunctions.get(funIndex);

        final Scopes effectiveScopes = (function.isStatic())
                ? scopes.enterStatic() // static function = start a new fresh Scopes
                : scopes;
        if (!function.isAbstract()) {
            effectiveScopes.pushFunction(function.isStatic(), false);
        }

        visitParameters(function, effectiveScopes);

        if (!function.isAbstract()) {
            // code block is the last child of a non-abstract function
            switch (functionElement.children.getLast()) {
                case CodeBlock codeBlock -> visitCodeBlock(codeBlock, effectiveScopes, currentKlass);
                case Expression expression -> {
                    // 1) visit the expression
                    final var functionReturnType =
                            visitExpression(expression, effectiveScopes, currentKlass, null);

                    // only set the descriptor string if type was not explicit or inferred
                    final var lateinitType = function.lateinitTypeOrNull();
                    if (lateinitType != null) { // infer type from the function's expression
                        lateinitType.setType(functionReturnType);
                    }

                    // 2) add a body function with a single return expression
                    final var codeBlock = new CodeBlock();
                    final var statement = new RealStatement(RETURN);
                    codeBlock.statements.add(statement);
                    statement.children.add(expression);
                    // replace the single expression with the new code block
                    functionElement.children.set(functionElement.children.size() - 1, codeBlock);
                }
                default -> throw new IllegalStateException("Unexpected value: " + functionElement.children.getLast());
            }
        }

        final var returnType = function.type(); // resolve the function's type
        functionElement.descriptorString(getKlassFromType(returnType).descriptorString());

        if (!function.isAbstract()) {
            effectiveScopes.popFunction(function.isStatic());
        }
    }

    private static void visitParameters(final @NonNull Function function, final @NonNull Scopes scopes) {
        assert function != null;
        assert scopes != null;

        for (final var parameter : function.parameters) {
            final var parameterType = parameter.type(); // resolve function param type
            if (!function.isAbstract()) {
                assert parameter.name != null;
                scopes.putVariable(parameter.name, parameterType,
                        /* isFinal */ true, function.isStatic(), /* noDuplicate */ false);
            }
        }
    }

    private static void visitCodeBlock(final @NonNull CodeBlock codeBlock,
                                       final @NonNull Scopes scopes,
                                       final @NonNull OolangKlass currentKlass) {
        assert codeBlock != null;
        assert scopes != null;
        assert currentKlass != null;

        for (final var statement : codeBlock.statements) {
            visitRealStatement(statement, scopes, currentKlass);
        }
    }

    private static void visitConstructorCodeBlock(ConstructorCodeBlock constructorCodeBlock,
                                                  final @NonNull Scopes scopes,
                                                  final @NonNull OolangKlass currentKlass) {
        assert constructorCodeBlock != null;
        assert scopes != null;
        assert currentKlass != null;

        for (final var initStatement : constructorCodeBlock.initBlock.statements) {
            visitRealStatement(initStatement, scopes, currentKlass);
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
            final var superType = currentKlass.allSuperKlasses().getFirst();
            implicitSuperConstructorCall.ownerDescriptorString = getKlassFromType(superType).descriptorString();
            implicitSuperConstructorCall.invocation = INVOKE_SPECIAL;
            implicitSuperConstructorCall.typeDescriptorString = "()V";
            chainableExpression.children.add(implicitSuperConstructorCall);

            constructorCodeBlock.initCall = chainableExpression;
        }

        for (final var postConstructStatement : constructorCodeBlock.postConstructBlock.statements) {
            visitRealStatement(postConstructStatement, scopes, currentKlass);
        }
    }

    private static void visitRealStatement(final @NonNull RealStatement realStatement,
                                           final @NonNull Scopes scopes,
                                           final @NonNull OolangKlass currentKlass) {
        assert realStatement != null;
        assert scopes != null;
        assert currentKlass != null;

        switch (realStatement.statementType) {
            case EXPRESSION, ASSIGNMENT -> {
                assert realStatement.children.size() == 1;
                visitExpression((Expression) realStatement.children.getFirst(), scopes, currentKlass, null);
            }
            case DECLARATION -> {
                // Note: a variable declaration does not translate in a bytecode operation, we just add this new
                // variable in the scope. It will be materialized when first stored, either now if there is an
                // initializer, or later in a subsequent expression.
                assert realStatement.children.size() == 1;

                final var realElement = (RealElement) realStatement.children.getFirst();
                assert realElement.elementType == VAL || realElement.elementType == VAR;
                final var variableStore = addVariable(realElement, scopes, currentKlass);
                if (variableStore != null) {
                    // transform declaration statement to an assignment.
                    realStatement.statementType = ASSIGNMENT;
                    // replace the property element child to a variable store expression
                    realStatement.children.set(0, variableStore);
                }
            }
            default -> throw new UnsupportedOperationException("statement type not yet supported: " +
                    realStatement.statementType);
        }
    }

    private static @Nullable RealExpression addVariable(final @NonNull RealElement variableElement,
                                                        final @NonNull Scopes scopes,
                                                        final @NonNull OolangKlass currentKlass) {
        assert variableElement != null;
        assert scopes != null;
        assert currentKlass != null;
        assert variableElement.identifier != null;

        Expression variableExpression = null;
        ActualType variableType = null;

        // type case (1) :  explicit type
        if (variableElement.type != null) {
            variableType = resolveType(variableElement.type, currentKlass, false);
            final var descriptorString = getKlassFromType(variableType).descriptorString();
            ((RealAstType) variableElement.type).descriptorString = descriptorString;
            variableElement.descriptorString(descriptorString);
        }

        // visit the variable initializer, if any
        for (final var child : variableElement.children) {
            if (child instanceof RealElement realElement && realElement.elementType == PROPERTY_INITIALIZER) {
                variableExpression = (Expression) realElement.children.getFirst();
                final var expressionType = visitExpression(variableExpression, scopes, currentKlass, null);

                // only use the inferred expression type if the variable type was not explicit
                if (variableType == null) {
                    // type case (2) :  type is inferred from the expression itself
                    variableType = expressionType;
                    final var descriptorString = getKlassFromType(variableType).descriptorString();
                    variableElement.descriptorString(descriptorString);
                }
                break;
            }
        }

        final var name = elementName(variableElement);
        if (variableType == null) {
            throw new OolangSemanticException("No explicit type nor initializer for variable " + name);
        }

        // add this new variable to the current scope
        final var slot = scopes.putVariable(
                name,
                variableType,
                /* isFinal */ variableElement.elementType == RealElement.ElementType.VAL,
                /* isStatic */ false,
                /* noDuplicate */ true);

        return (variableExpression != null)
                ? buildVariableStore(variableExpression, variableElement, slot, currentKlass)
                : null;
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
                constantExpression.descriptorString(constantKlass.descriptorString());
                yield constantKlass;
            }
            case DelegateExpression delegateExpression -> ((AlreadyVisitedExpression) delegateExpression).type;
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
            case VARIABLE_OR_PROP_ASSIGNMENT ->
                    visitVariableOrPropAssignment(realExpression, scopes, currentKlass, applicableKlass);
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
            chainableExpression.descriptorString(getKlassFromType(lastType).descriptorString());
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
            additiveExpression.descriptorString(STRING_KLASS.descriptorString());
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
                indexingExpression, scopes, currentKlass, applicableKlass, true).klass;
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
            indexingExpression.descriptorString(getKlassFromType(componentType).descriptorString());
            return componentType;
        }
        throw new UnsupportedOperationException("todo List / Map indexing operations");
    }

    private static @NonNull Klass visitVariableOrPropAccessExpression(
            final @NonNull RealExpression variableOrPropAccessExpression,
            final @NonNull Scopes scopes,
            final @NonNull OolangKlass currentKlass,
            final @Nullable Klass applicableKlass
    ) {
        assert variableOrPropAccessExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        final var caller = visitVariableOrPropAccessChain(
                variableOrPropAccessExpression, scopes, currentKlass, applicableKlass, true);
        if (caller.isStatic) {
            throw new OolangSemanticException("Expected a variable or property, had the " + caller.klass +
                    " static class");
        }
        return caller.klass;
    }

    private static @NonNull ActualType visitVariableOrPropAssignment(
            final @NonNull RealExpression variableOrPropAssignmentExpression,
            final @NonNull Scopes scopes,
            final @NonNull OolangKlass currentKlass,
            final @Nullable Klass applicableKlass
    ) {
        assert variableOrPropAssignmentExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        // resolve value for the assignment
        assert variableOrPropAssignmentExpression.children.size() == 1;
        // mutate AST to add variable access call expression upfront
        final var valueExpression = variableOrPropAssignmentExpression.children.getFirst();
        visitExpression(valueExpression, scopes, currentKlass, null);
        // todo verify that valueExpression type is compatible with the property's one
        variableOrPropAssignmentExpression.children.clear();

        Caller caller = null;
        if (variableOrPropAssignmentExpression.identifiers.size() > 1) {
            // a property assignment with prefix, like 'aClass.property = something'
            caller = visitVariableOrPropAccessChain(
                    variableOrPropAssignmentExpression, scopes, currentKlass, applicableKlass, false);
        } else if (applicableKlass != null) {
            caller = new Caller(applicableKlass, false /* fixme is it always non-static ?*/);
        }

        final var id = variableOrPropAssignmentExpression.identifiers.getFirst();
        final var identifier = id.identifier;

        ScopeElement scopeElement;
        if (caller == null) {
            // 1) first identifier may refer to a variable / property / function property from the current scope
            scopeElement = scopes.resolveVariableOrProperty(identifier, true);
            if (scopeElement == null) {
                // 2) else, first identifier may refer to a property / function property from a parent
                scopeElement = currentKlass.accessiblePropertyOrFunctionProperty(identifier,
                        /* includeProtected */  true,
                        /* includePrivate */ false,
                        /* setter */ true,
                        /* access */ ACCESS_BOTH);
            }
        } else {
            final var callerKlass = caller.klass;
            final var setter = caller.isStatic || !scopes.inConstructor();
            scopeElement = callerKlass.accessiblePropertyOrFunctionProperty(identifier,
                    /* includeProtected */  canAccessProtected(callerKlass, currentKlass),
                    /* includePrivate */ callerKlass == currentKlass,
                    /* setter */ setter,
                    /* access */ caller.isStatic ? ACCESS_STATIC : ACCESS_INSTANCE);
        }


        if (scopeElement == null) {
            throw new OolangSemanticException("Could not resolve variable or property: " + identifier);
        }

        return switch (scopeElement) {
            case Variable variable -> {
                final var variableStore = new RealExpression(VARIABLE_STORE);
                variableStore.identifiers.add(id);
                variableStore.slot = variable.slot();
                variableStore.descriptorString(variable.descriptorString());
                // mutate AST to add variable access call expression upfront
                addNewExpressionInAst(variableOrPropAssignmentExpression, variableStore);

                addNewExpressionInAst(variableStore, valueExpression);
                yield getKlassFromType(variable.type());
            }
            case Property property -> {
                final var propertyAssignment = new RealExpression(PROP_ASSIGNMENT);
                propertyAssignment.identifiers.add(id);
                propertyAssignment.invocation = property.isStatic() ? PUT_STATIC : PUT_FIELD;
                propertyAssignment.ownerDescriptorString = property.declaringKlass.descriptorString();
                propertyAssignment.descriptorString(property.descriptorString());
                // mutate AST to add variable access call expression upfront
                addNewExpressionInAst(variableOrPropAssignmentExpression, propertyAssignment);

                if (caller == null && !property.isStatic()) {
                    // must load current klass
                    loadThis(propertyAssignment, scopes);
                }
                addNewExpressionInAst(propertyAssignment, valueExpression);
                yield getKlassFromType(property.type());
            }
            case Function function -> {
                final var funCall = funCallExpression(function, id, currentKlass);
                // mutate AST to add variable access call expression upfront
                addNewExpressionInAst(variableOrPropAssignmentExpression, funCall);

                if (caller == null) {
                    // must load current klass
                    loadThis(funCall, scopes);
                }
                addNewExpressionInAst(funCall, valueExpression);
                yield getKlassFromType(function.type());
            }
        };
    }

    /// search in super classes for caller. If present, we can access its protected functions.
    private static boolean canAccessProtected(final @NonNull Klass caller, final @NonNull OolangKlass currentKlass) {
        assert caller != null;
        assert currentKlass != null;

        return currentKlass.descriptorString().equals(caller.descriptorString())
                || hasAssignableParent(currentKlass.allSuperKlasses(), caller);
    }

    private static @NonNull ActualType visitFunCallExpression(final @NonNull RealExpression funCallExpression,
                                                              final @NonNull Scopes scopes,
                                                              final @NonNull OolangKlass currentKlass,
                                                              final @Nullable Klass applicableKlass) {
        assert funCallExpression != null;
        assert scopes != null;
        assert currentKlass != null;

        Caller caller = null;
        if (funCallExpression.type != null) {
            // constructor call
            final var callerKlass = getKlassFromType(
                    TypeResolver.resolveType(funCallExpression.type, currentKlass, false));
            // NEW instruction to allocate memory
            final var newExpression = new RealExpression(NEW);
            newExpression.descriptorString(callerKlass.descriptorString());
            // mutate AST to add NEW expression upfront
            addNewExpressionInAst(funCallExpression, newExpression);
            caller = new Caller(callerKlass, false);
        } else if (funCallExpression.identifiers.size() == 1) {
            // a simple fun call without prefix
            if (applicableKlass != null) {
                caller = new Caller(applicableKlass, false /* fixme is it always non-static ?*/);
            }
        } else {
            // a fun call with prefix, like 'System.out.println'
            caller = visitVariableOrPropAccessChain(
                    funCallExpression, scopes, currentKlass, applicableKlass, false);
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

        final var funName = funCallExpression.identifiers.getFirst().identifier;
        final Klass callerKlass;
        Function function;

        if (caller == null) {
            callerKlass = currentKlass;

            // 1) first identifier may refer to a function from the current scope
            function = scopes.resolveFunction(funName, funParameters);
            if (function == null) {
                // 2) else, first identifier may refer to a function from a parent
                function = callerKlass.accessibleFunction(funName, funParameters,
                        /* includeProtected */ true,
                        /* includePrivate */ true,
                        /* access */ ACCESS_BOTH);
            }
            if (function != null && !function.isStatic()) {
                loadThis(funCallExpression, scopes);
            }
        } else {
            callerKlass = caller.klass;
            function = callerKlass.accessibleFunction(funName, funParameters,
                    /* includeProtected */ canAccessProtected(callerKlass, currentKlass),
                    /* includePrivate */ callerKlass == currentKlass,
                    /* access */ caller.isStatic ? ACCESS_STATIC : ACCESS_INSTANCE);
        }

        if (function == null) {
            throw new OolangSemanticException("Could not resolve function '" + funName +
                    "' from class " + callerKlass.descriptorString());
        }

        funCallExpression.invocation = functionInvocation(callerKlass, function);
        funCallExpression.ownerDescriptorString = function.declaringKlass.descriptorString();
        funCallExpression.descriptorString(function.descriptorString());
        funCallExpression.typeDescriptorString = function.typeDescriptorString();
        return function.type();
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

    private static @NonNull Caller visitVariableOrPropAccessChain(final @NonNull RealExpression expression,
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
                ? propOrFunPropAccess(expression, new Caller(applicableKlass, false), currentKlass, idIndex)
                : firstVariableOrPropAccessInCurrentKlass(expression, scopes, currentKlass, idIndex, lastIdIndex);

        while (idIndex.value < lastIdIndex) { // chained properties until last identifier
            caller = propOrFunPropAccess(expression, caller, currentKlass, idIndex);
        }

        // clean identifiers after property access(es)
        expression.identifiers.subList(0, lastIdIndex).clear();

        return caller;
    }

    private static @NonNull Caller propOrFunPropAccess(final @NonNull RealExpression expression,
                                                       final @NonNull Caller caller,
                                                       final @NonNull OolangKlass currentKlass,
                                                       final @NonNull IndexHolder idIndex) {
        assert expression != null;
        assert caller != null;
        assert idIndex != null;

        final var callerKlass = caller.klass;
        final var id = expression.identifiers.get(idIndex.value++);

        final var propOrFunProp = callerKlass.accessiblePropertyOrFunctionProperty(id.identifier,
                /* includeProtected */  canAccessProtected(callerKlass, currentKlass),
                /* includePrivate */ callerKlass == currentKlass,
                /* setter */ false,
                /* access */ caller.isStatic ? ACCESS_STATIC : ACCESS_INSTANCE);
        return switch (propOrFunProp) {
            case Property property -> {
                final var propAccessExpression = propAccessExpression(property, id);
                // mutate AST to add property call expression upfront
                addNewExpressionInAst(expression, propAccessExpression);
                // caller becomes property's klass
                yield new Caller(getKlassFromType(property.type()), false);
            }
            case Function functionProperty -> {
                final var funCallExpression = funCallExpression(functionProperty, id, callerKlass);
                // mutate AST to add function call expression upfront
                addNewExpressionInAst(expression, funCallExpression);
                // caller becomes function's return klass
                yield new Caller(getKlassFromType(functionProperty.type()), false);
            }
            case null -> throw new OolangSemanticException("Could not resolve property " + id.identifier +
                    " from class " + callerKlass.descriptorString());
        };
    }

    private static @NonNull Caller firstVariableOrPropAccessInCurrentKlass(final @NonNull RealExpression expression,
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

        // 1) first identifier may refer to a variable / property / function property from the current scope
        ScopeElement scopeElement = scopes.resolveVariableOrProperty(identifier, false);

        if (scopeElement == null) {
            // 2) else, first identifier may refer to a property / function property from a parent
            scopeElement = currentKlass
                    .accessiblePropertyOrFunctionProperty(identifier,
                            /* includeProtected */  true,
                            /* includePrivate */ false,
                            /* setter */ true,
                            /* access */ ACCESS_BOTH);
        }

        if (scopeElement != null) {
            return switch (scopeElement) {
                case Variable variable -> {
                    final var variableAccess = loadExpression(variable, id);
                    // mutate AST to add variable access call expression upfront
                    addNewExpressionInAst(expression, variableAccess);
                    yield new Caller(getKlassFromType(variable.type()), false);
                }
                case Property property -> {
                    final var propertyAccess = propAccessExpression(property, id);
                    // mutate AST to add variable access call expression upfront
                    addNewExpressionInAst(expression, propertyAccess);
                    if (!property.isStatic()) {
                        // must load current klass
                        loadThis(propertyAccess, scopes);
                    }
                    yield new Caller(getKlassFromType(property.type()), false);
                }
                case Function function -> {
                    final var funCall = funCallExpression(function, id, currentKlass);
                    // mutate AST to add variable access call expression upfront
                    addNewExpressionInAst(expression, funCall);
                    // must load current klass
                    loadThis(funCall, scopes);
                    yield new Caller(getKlassFromType(function.type()), false);
                }
            };
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
        return new Caller(caller, true);
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
        if (indexOfExpression == -1) {
            // add new expression after others
            expression.parent.children.add(newExpression);
        } else {
            // "expression" was at index X in the parent list.
            // Inserts "newExpression" at index X, pushing "expression" to X + 1
            expression.parent.children.add(indexOfExpression, newExpression);
            // also remove temporary VAR_OR_PROP_ACCESS or VARIABLE_OR_PROP_ASSIGNMENT if needed
            if (expression.expressionType == VARIABLE_OR_PROP_ACCESS
                    || expression.expressionType == VARIABLE_OR_PROP_ASSIGNMENT) {
                expression.parent.children.remove(indexOfExpression + 1);
            }
        }
    }

    private static @NonNull RealExpression loadExpression(final @NonNull Variable variable,
                                                          final @NonNull SimpleIdentifier id) {
        assert variable != null;
        assert id != null;

        final var loadExpression = new RealExpression(LOAD);
        loadExpression.identifiers.add(id);
        loadExpression.slot = variable.slot();
        loadExpression.descriptorString(variable.descriptorString());
        return loadExpression;
    }

    private static @NonNull RealExpression propAccessExpression(final @NonNull Property property,
                                                                final @NonNull SimpleIdentifier id) {
        assert property != null;
        assert id != null;

        final var propAccessExpression = new RealExpression(PROP_ACCESS);
        propAccessExpression.identifiers.add(id);
        propAccessExpression.invocation = property.isStatic() ? GET_STATIC : GET_FIELD;
        propAccessExpression.ownerDescriptorString = property.declaringKlass.descriptorString();
        propAccessExpression.descriptorString(property.descriptorString());
        // set AST info from the identifier, if any
        if (id.info() != null) {
            propAccessExpression.setInfo(id.info());
        }
        return propAccessExpression;
    }

    private static @NonNull RealExpression funCallExpression(final @NonNull Function function,
                                                             final @NonNull SimpleIdentifier id,
                                                             final @NonNull Klass caller) {
        assert function != null;
        assert id != null;
        assert caller != null;

        // change the identifier for old school getter/setter
        id.identifier = function.name();
        final var funCallExpression = new RealExpression(FUN_CALL);
        funCallExpression.identifiers.add(id);
        funCallExpression.invocation = functionInvocation(caller, function);
        funCallExpression.ownerDescriptorString = function.declaringKlass.descriptorString();
        funCallExpression.descriptorString(function.descriptorString());
        funCallExpression.typeDescriptorString = function.typeDescriptorString();
        // set AST info from the identifier, if any
        if (id.info() != null) {
            funCallExpression.setInfo(id.info());
        }
        return funCallExpression;
    }

    private static @NonNull String functionInvocation(final @NonNull Klass caller, final @NonNull Function function) {
        assert caller != null;
        assert function != null;

        if (function.isStatic()) {
            return INVOKE_STATIC;
        }
        if (function.declaringKlass.isInterface()) {
            return INVOKE_INTERFACE;
        }
        if (function.visibility() == PRIVATE // 1) calling a private method or constructor
                // 2) // calling an instance initialization method (<init>)
                || function.name().equals(ConstantDescs.INIT_NAME)
                // 3) calling a superclass method or constructor
                || hasAssignableParent(caller.allSuperKlasses(), function.declaringKlass)
        ) {
            return INVOKE_SPECIAL;
        }
        return INVOKE_VIRTUAL;
        // todo INVOKE_DYNAMIC
    }

    /// Add a load of the current klass in the provided expression if it is a `chainable`, else add it upfront.
    private static void loadThis(final @NonNull RealExpression expression, final @NonNull Scopes scopes) {
        assert expression != null;
        assert scopes != null;

        final var thisVariable = (Variable) scopes.resolveVariableOrProperty("this", false);
        assert thisVariable != null;
        final var loadThis = loadExpression(thisVariable, THIS_IDENTIFIER);
        if (expression.parent != null) {
            // add loadThis upfront
            addNewExpressionInAst(expression, loadThis);
        } else {
            assert expression.expressionType == CHAINABLE;
            expression.children.add(loadThis);
        }
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

    private record Caller(@NonNull Klass klass, boolean isStatic) {
    }
}
