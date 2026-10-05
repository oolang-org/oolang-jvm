/*
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 */

package org.oolang.parser;

import org.antlr.v4.runtime.ParserRuleContext;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;
import org.oolang.ast.*;
import org.oolang.ast.Identifier.MultipleIdentifier;
import org.oolang.ast.Identifier.SimpleIdentifier;
import org.oolang.ast.element.ClassBody;
import org.oolang.ast.element.ElementModifier;
import org.oolang.ast.element.RealElement;
import org.oolang.ast.expression.ConstantExpression;
import org.oolang.ast.expression.Expression;
import org.oolang.ast.expression.RealExpression;
import org.oolang.ast.expression.RealExpression.ExpressionType;
import org.oolang.ast.statement.CodeBlock;
import org.oolang.ast.statement.RealStatement;
import org.oolang.ast.statement.Statement;
import org.oolang.parser.generated.OolangParser.*;
import org.oolang.parser.generated.OolangParserBaseVisitor;

import java.lang.constant.ConstantDesc;
import java.lang.constant.ConstantDescs;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Objects;

import static org.oolang.ast.element.RealElement.ElementType.*;
import static org.oolang.ast.element.RealElement.ElementType.CLASS;
import static org.oolang.ast.element.RealElement.ElementType.CONSTRUCTOR;
import static org.oolang.ast.element.RealElement.ElementType.FUN;
import static org.oolang.ast.element.RealElement.ElementType.VAL;
import static org.oolang.ast.element.RealElement.ElementType.VAR;
import static org.oolang.ast.expression.RealExpression.ExpressionType.*;
import static org.oolang.ast.expression.RealExpression.ExpressionType.ADD;
import static org.oolang.ast.expression.RealExpression.ExpressionType.SUB;
import static org.oolang.ast.statement.RealStatement.StatementType.ASSIGNMENT;
import static org.oolang.ast.statement.RealStatement.StatementType.EXPRESSION;

public final class OolangAstVisitor extends OolangParserBaseVisitor<Ast> {
    @Override
    public @NonNull AstFile visitOolangFile(final @NonNull OolangFileContext ctx) {
        assert ctx != null;

        final var astFile = new AstFile();

        // package
        astFile.packageHeader = visitPackageHeader(ctx.packageHeader());

        // imports
        for (final var importHeaderCtx : ctx.importList().importHeader()) {
            astFile.imports.add(visitImportHeader(importHeaderCtx));
        }

        for (final var classDeclarationCtx : ctx.classDeclaration()) {
            astFile.rootElements.add(visitClassDeclaration(classDeclarationCtx));
        }

        return addAstInfo(astFile, ctx);
    }

    @Override
    public @NonNull PackageHeader visitPackageHeader(final @NonNull PackageHeaderContext ctx) {
        assert ctx != null;

        final var packageHeader = new PackageHeader();
        for (final var simpleIdentifierCtx : ctx.identifier().simpleIdentifier()) {
            packageHeader.identifiers.add(visitSimpleIdentifier(simpleIdentifierCtx));
        }
        return addAstInfo(packageHeader, ctx);
    }

    @Override
    public @NonNull Import visitImportHeader(final @NonNull ImportHeaderContext ctx) {
        assert ctx != null;

        final var importHeader = new Import();
        for (final var simpleIdentifierCtx : ctx.identifier().simpleIdentifier()) {
            importHeader.identifiers.add(visitSimpleIdentifier(simpleIdentifierCtx));
        }
        return addAstInfo(importHeader, ctx);
    }

    @Override
    public @NonNull RealElement visitClassDeclaration(final @NonNull ClassDeclarationContext ctx) {
        assert ctx != null;

        final var clazz = new RealElement(CLASS);

        clazz.identifier = visitSimpleIdentifier(ctx.simpleIdentifier());

        addModifiersAndAnnotations(ctx.modifiers(), clazz);

        if (ctx.primaryConstructor() != null) {
            clazz.children.add(visitPrimaryConstructor(ctx.primaryConstructor()));
        }

        if (ctx.classBody() != null) {
            clazz.children.add(visitClassBody(ctx.classBody()));
        }

        return addAstInfo(clazz, ctx);
    }

    @Override
    public @NonNull RealElement visitPrimaryConstructor(final @NonNull PrimaryConstructorContext ctx) {
        assert ctx != null;

        final var constructor = new RealElement(CONSTRUCTOR);
        addModifiersAndAnnotations(ctx.modifiers(), constructor);
        constructor.identifier = new Identifier.SimpleIdentifier(ConstantDescs.INIT_NAME);

        for (final var classParamCtx : ctx.classParameters().classParameter()) {
            constructor.children.add(visitClassParameter(classParamCtx));
        }

        return addAstInfo(constructor, ctx);
    }

    @Override
    public @NonNull RealElement visitClassParameter(final @NonNull ClassParameterContext ctx) {
        assert ctx != null;

        final RealElement classParam;
        if (ctx.VAL() != null) {
            classParam = new RealElement(VAL);
        } else if (ctx.VAR() != null) {
            classParam = new RealElement(VAR);
        } else {
            classParam = new RealElement(PARAMETER);
        }
        classParam.identifier = visitSimpleIdentifier(ctx.simpleIdentifier());

        classParam.type = visitType(ctx.type());
        addModifiersAndAnnotations(ctx.modifiers(), classParam);

        return addAstInfo(classParam, ctx);
    }

    @Override
    public @NonNull ClassBody visitClassBody(final @NonNull ClassBodyContext ctx) {
        assert ctx != null;

        final var classBody = new ClassBody();
        for (final var classMemberDeclarationCtx : ctx.classMemberDeclaration()) {
            classBody.children.add(visitClassMemberDeclaration(classMemberDeclarationCtx));
        }
        return addAstInfo(classBody, ctx);
    }

    @Override
    public @NonNull RealElement visitClassMemberDeclaration(final @NonNull ClassMemberDeclarationContext ctx) {
        assert ctx != null;

        if (ctx.declaration() != null) {
            return visitDeclaration(ctx.declaration());
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull RealElement visitDeclaration(final @NonNull DeclarationContext ctx) {
        assert ctx != null;

        if (ctx.functionDeclaration() != null) {
            return visitFunctionDeclaration(ctx.functionDeclaration());
        }
        if (ctx.propertyDeclaration() != null) {
            return visitPropertyDeclaration(ctx.propertyDeclaration());
        }
        if (ctx.classDeclaration() != null) {
            return visitClassDeclaration(ctx.classDeclaration());
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull RealElement visitPropertyDeclaration(final @NonNull PropertyDeclarationContext ctx) {
        assert ctx != null;

        final RealElement property;
        if (ctx.VAL() != null) {
            property = new RealElement(VAL);
        } else {
            property = new RealElement(VAR);
        }
        final var variableDeclarationCtx = ctx.variableDeclaration();
        final var simpleIdentifierCtx = variableDeclarationCtx.simpleIdentifier();
        property.identifier = visitSimpleIdentifier(simpleIdentifierCtx);

        // type is optional, it may be inferred
        final var typeCtx = variableDeclarationCtx.type();
        if (typeCtx != null) {
            property.type = visitType(typeCtx);
        }

        final var expression = ctx.expression();
        if (expression != null) {
            final var propertyInitializer = new RealElement(PROPERTY_INITIALIZER);
            final var propertyExpression = visitExpression(expression);
            propertyInitializer.children.add(propertyExpression);
            property.children.add(addAstInfo(propertyInitializer, expression));
        } else if (typeCtx == null) {
            throw new OolangSyntaxException("Variable '" + simpleIdentifierCtx.getText() +
                    "' without explicit type nor expression to infer its type");
        }

        addModifiersAndAnnotations(ctx.modifiers(), property);

        return addAstInfo(property, ctx);
    }

    @Override
    public @NonNull RealElement visitFunctionDeclaration(final @NonNull FunctionDeclarationContext ctx) {
        assert ctx != null;

        final var function = new RealElement(FUN);
        function.identifier = visitSimpleIdentifier(ctx.simpleIdentifier());
        // type is optional, it may be inferred or Void by default
        final var typeCtx = ctx.type();
        if (typeCtx != null) {
            function.type = visitType(typeCtx);
        }
        addModifiersAndAnnotations(ctx.modifiers(), function);

        for (final var funParamCtx : ctx.functionValueParameters().functionValueParameter()) {
            function.children.add(visitFunctionValueParameter(funParamCtx));
        }

        function.children.add(visitFunctionBody(ctx.functionBody()));

        return addAstInfo(function, ctx);
    }

    @Override
    public @NonNull RealElement visitFunctionValueParameter(final @NonNull FunctionValueParameterContext ctx) {
        assert ctx != null;

        var funParam = new RealElement(PARAMETER);
        final var parameterCtx = ctx.parameter();
        funParam.identifier = visitSimpleIdentifier(parameterCtx.simpleIdentifier());
        funParam.type = visitType(parameterCtx.type());

        if (ctx.parameterModifiers() != null) {
            if (ctx.parameterModifiers().VARARG() != null) {
                funParam.modifiers.add(new ElementModifier(ElementModifier.ModifierType.PARAMETER, "vararg"));
            }
            funParam.annotations = visitAnnotations(ctx.parameterModifiers().annotation());
        }

        return addAstInfo(funParam, ctx);
    }

    @Override
    public @NonNull CodeBlock visitFunctionBody(final @NonNull FunctionBodyContext ctx) {
        assert ctx != null;

        final var functionBody = new CodeBlock();
        if (ctx.block() != null) {
            for (final var statementCtx : ctx.block().statements().statement()) {
                functionBody.statements.add(visitStatement(statementCtx));
            }
        } else {
            Objects.requireNonNull(ctx.expression());
            throw new UnsupportedOperationException();
        }
        return addAstInfo(functionBody, ctx);
    }

    @Override
    public @NonNull Statement visitStatement(final @NonNull StatementContext ctx) {
        assert ctx != null;

        final var blockLevelExpressionCtx = ctx.blockLevelExpression();
        if (blockLevelExpressionCtx != null) {
            return addAstInfo(visitBlockLevelExpression(blockLevelExpressionCtx), ctx);
        }

        final var blockLevelDeclarationCtx = ctx.blockLevelDeclaration();
        assert blockLevelDeclarationCtx != null;
        return addAstInfo(visitBlockLevelDeclaration(blockLevelDeclarationCtx), ctx);
    }

    @Override
    public @NonNull Statement visitBlockLevelExpression(final @NonNull BlockLevelExpressionContext ctx) {
        assert ctx != null;

        final var statement = new RealStatement(EXPRESSION);
        statement.children.add(visitExpression(ctx.expression()));
        statement.annotations = visitAnnotations(ctx.annotation());
        return statement;
    }

    @Override
    public @NonNull RealStatement visitBlockLevelDeclaration(final @NonNull BlockLevelDeclarationContext ctx) {
        assert ctx != null;

        final RealStatement statement;
        final var assignmentCtx = ctx.assignment();
        if (assignmentCtx != null) {
            statement = visitAssignment(assignmentCtx);
        } else {
            throw new UnsupportedOperationException("Non assignment declaration statement not supported yet");
        }

        if (!ctx.label().isEmpty()) {
            throw new UnsupportedOperationException("Label in declaration statement not supported yet");
        }

        return statement;
    }

    @Override
    public @NonNull RealStatement visitAssignment(final @NonNull AssignmentContext ctx) {
        assert ctx != null;

        final var statement = new RealStatement(ASSIGNMENT);

        // normal assignment '='
        final var directlyAssignableExpressionCtx = ctx.directlyAssignableExpression();
        if (directlyAssignableExpressionCtx != null) {
            statement.children.add(visitDirectlyAssignableExpression(directlyAssignableExpressionCtx));
        } else {
            throw new UnsupportedOperationException("Assignment statement with operator not supported yet");
        }

        statement.children.add(visitExpression(ctx.expression()));

        return statement;
    }

    /// ```
    /// : postfixUnaryExpression assignableSuffix
    /// | simpleIdentifier
    /// ```
    @Override
    public @NonNull Expression visitDirectlyAssignableExpression(
            final @NonNull DirectlyAssignableExpressionContext ctx
    ) {
        assert ctx != null;

        final var simpleIdentifierCtx = ctx.simpleIdentifier();
        if (simpleIdentifierCtx != null) {
            final var expression = new RealExpression(VARIABLE_OR_PROP_ACCESS);
            expression.identifiers.add(visitSimpleIdentifier(simpleIdentifierCtx));
            return addAstInfo(expression, ctx);
        }

        final var postfixUnaryExpressionCtx = ctx.postfixUnaryExpression();
        assert postfixUnaryExpressionCtx != null;
        assert ctx.assignableSuffix() != null;
        // visitPostfixUnaryExpression(postfixUnaryExpressionCtx); // + todo handle assignableSuffix
        throw new UnsupportedOperationException("postfixUnaryExpression assignableSuffix");
    }

    @Override
    public @NonNull Expression visitExpression(final @NonNull ExpressionContext ctx) {
        assert ctx != null;

        for (final var conjunctionCtx : ctx.disjunction().conjunction()) {
            for (final var equalityCtx : conjunctionCtx.equality()) {
                for (final var comparisonCtx : equalityCtx.comparison()) {
                    for (final var genericCallLikeComparisonCtx : comparisonCtx.genericCallLikeComparison()) {
                        final var isExpressionCtx = genericCallLikeComparisonCtx.isExpression();
                        final var elvisExpressionCtx = isExpressionCtx.elvisExpression();
                        for (final var additiveExpressionCtx : elvisExpressionCtx.additiveExpression()) {
                            return visitAdditiveExpression(additiveExpressionCtx);
                        }
                    }
                }
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull Expression visitAdditiveExpression(final @NonNull AdditiveExpressionContext ctx) {
        assert ctx != null;

        final var additiveOperators = ctx.additiveOperator();
        final var multiplicativeExpressions = ctx.multiplicativeExpression();
        // note that: multiplicativeExpressions.size() == additiveOperators.size() + 1

        // fast-path for non-additive expression
        if (additiveOperators.isEmpty()) {
            return visitMultiplicativeExpression(multiplicativeExpressions.getFirst());
        }

        // additive expressions support chaining, so we can have a simple ADD expression with all children
        // "a + b + c" -> ADD(a, b, c)
        // "a - b + c" -> ADD(SUB(a, b), c)
        var i = 0;
        var expression = visitMultiplicativeExpression(multiplicativeExpressions.get(i));
        ExpressionType lastExpressionType = null;
        while (i < additiveOperators.size()) {
            final var expressionType = (additiveOperators.get(i).ADD() != null) ? ADD : SUB;
            final var nextExpression = visitMultiplicativeExpression(multiplicativeExpressions.get(++i));
            if (expressionType != lastExpressionType || expressionType == SUB) {
                final var additiveExpression = new RealExpression(expressionType);
                additiveExpression.children.add(expression);
                additiveExpression.children.add(nextExpression);
                expression = additiveExpression;
            } else {
                ((RealExpression) expression).children.add(nextExpression);
            }
            lastExpressionType = expressionType;
        }

        return addAstInfo(expression, ctx);
    }

    @Override
    public @NonNull Expression visitMultiplicativeExpression(final @NonNull MultiplicativeExpressionContext ctx) {
        for (final var typeRhsCtx : ctx.typeRHS()) {
            for (final var prefixUnaryExpressionCtx : typeRhsCtx.prefixUnaryExpression()) {
                return visitPostfixUnaryExpression(prefixUnaryExpressionCtx.postfixUnaryExpression());
            }
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull Expression visitPostfixUnaryExpression(final @NonNull PostfixUnaryExpressionContext ctx) {
        assert ctx != null;

        final var atomicExpressionCtx = ctx.atomicExpression();
        final var postfixUnarySuffixesCtx = ctx.postfixUnarySuffix();

        Expression expression;
        var mustCompleteExpression = false;
        if (atomicExpressionCtx.literalConstant() != null) {
            expression = visitLiteralConstant(atomicExpressionCtx.literalConstant());

        } else if (atomicExpressionCtx.stringLiteral() != null) {
            expression = visitStringLiteral(atomicExpressionCtx.stringLiteral());

        } else if (atomicExpressionCtx.simpleIdentifier() != null) {
            final var realExpression = new RealExpression();
            realExpression.identifiers.add(visitSimpleIdentifier(atomicExpressionCtx.simpleIdentifier()));
            if (postfixUnarySuffixesCtx.isEmpty()) {
                realExpression.expressionType = VARIABLE_OR_PROP_ACCESS;
                // Always add a chainable expression as parent to the variable or property access,
                // so we can clean it in the semantic analysis phase
                final var chainableExpression = new RealExpression(CHAINABLE);
                addExpressionToChain(chainableExpression, realExpression);
                expression = addAstInfo(chainableExpression, ctx);
            } else {
                expression = realExpression;
                mustCompleteExpression = true;
            }

        } else if (atomicExpressionCtx.constructorInvocation() != null) {
            final var constructorCallExpression = visitConstructorInvocation(atomicExpressionCtx.constructorInvocation());
            if (postfixUnarySuffixesCtx.isEmpty()) {
                // Always add a chainable expression as parent to the constructor call,
                // so we can complete it in the semantic analysis phase
                final var chainableExpression = new RealExpression(CHAINABLE);
                addExpressionToChain(chainableExpression, constructorCallExpression);
                expression = addAstInfo(chainableExpression, ctx);
            } else {
                expression = constructorCallExpression;
            }

        } else {
            throw new UnsupportedOperationException();
        }

        // add suffixes or/and chained expressions
        if (!postfixUnarySuffixesCtx.isEmpty()) {
            expression = addAstInfo(
                    visitPostfixUnarySuffixes(postfixUnarySuffixesCtx, expression, mustCompleteExpression),
                    ctx);
        }

        return expression;
    }

    @Override
    public @NonNull Expression visitLiteralConstant(final @NonNull LiteralConstantContext ctx) {
        assert ctx != null;

        final ConstantDesc value;
        if (ctx.IntegerLiteral() != null) {
            value = Integer.parseInt(ctx.getText());
        } else if (ctx.LongLiteral() != null) {
            value = Long.parseLong(ctx.getText());
        } else {
            throw new UnsupportedOperationException();
        }

        return addAstInfo(new ConstantExpression(value), ctx);
    }

    @Override
    public @NonNull Expression visitStringLiteral(final @NonNull StringLiteralContext ctx) {
        assert ctx != null;

        if (ctx.lineStringLiteral() != null) {
            return visitLineStringLiteral(ctx.lineStringLiteral());
        }
        Objects.requireNonNull(ctx.multiLineStringLiteral());
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull Expression visitLineStringLiteral(final @NonNull LineStringLiteralContext ctx) {
        assert ctx != null;

        // fast-path for single String content
        if (ctx.lineStringContent().size() == 1 && ctx.lineStringExpression().isEmpty()) {
            return addAstInfo(new ConstantExpression(ctx.lineStringContent().getFirst().getText()), ctx);
        }
        throw new UnsupportedOperationException();
    }

    @Override
    public @NonNull RealExpression visitConstructorInvocation(final @NonNull ConstructorInvocationContext ctx) {
        assert ctx != null;

        // constructor call is a function call
        final var constructorCall = new RealExpression(FUN_CALL);
        constructorCall.type = visitUserType(ctx.userType());
        constructorCall.identifiers.add(new SimpleIdentifier(ConstantDescs.INIT_NAME));
        // add function call parameters
        addFunCallParameters(constructorCall, ctx.callSuffix());

        return addAstInfo(constructorCall, ctx);
    }

    private @NonNull RealExpression visitPostfixUnarySuffixes(
            final @NonNull List<@NonNull PostfixUnarySuffixContext> postfixUnarySuffixesCtx,
            final @NonNull Expression expression,
            final boolean mustCompleteExpression
    ) {
        assert postfixUnarySuffixesCtx != null;
        assert !postfixUnarySuffixesCtx.isEmpty();
        assert expression != null;

        final var chainableExpression = new RealExpression(CHAINABLE);
        RealExpression currentExpression = (mustCompleteExpression) ? (RealExpression) expression : null;
        addExpressionToChain(chainableExpression, expression);

        for (final var postfixUnarySuffixCtx : postfixUnarySuffixesCtx) {
            if (currentExpression == null) {
                currentExpression = new RealExpression();
                addExpressionToChain(chainableExpression, currentExpression);
            }

            final var navSuffixCtx = postfixUnarySuffixCtx.navigationSuffix();
            if (navSuffixCtx != null) {
                if (navSuffixCtx.memberAccessOperator().DOT() != null) {
                    currentExpression.identifiers.add(visitSimpleIdentifier(navSuffixCtx.simpleIdentifier()));
                }
                continue;
            }

            final var typeArgumentsCtx = postfixUnarySuffixCtx.typeArguments();
            if (typeArgumentsCtx != null) {
                throw new UnsupportedOperationException("Type arguments are not supported yet: " +
                        typeArgumentsCtx.getText());
            }

            final var callSuffixCtx = postfixUnarySuffixCtx.callSuffix();
            if (callSuffixCtx != null) {
                currentExpression.expressionType = FUN_CALL;
                // add function call parameters
                addFunCallParameters(currentExpression, callSuffixCtx);
                addAstInfo(currentExpression, callSuffixCtx);
                currentExpression = null;
                continue;
            }

            // "args[index]"
            final var indexingSuffixCtx = postfixUnarySuffixCtx.indexingSuffix();
            if (indexingSuffixCtx != null) {
                currentExpression.expressionType = INDEXING;
                for (final var indexedExpressionCtx : indexingSuffixCtx.expression()) {
                    currentExpression.children.add(visitExpression(indexedExpressionCtx));
                }
                addAstInfo(currentExpression, indexingSuffixCtx);
                currentExpression = null;
            }
        }

        if (currentExpression != null) {
            // no expression type yet = variable or prop access
            currentExpression.expressionType = VARIABLE_OR_PROP_ACCESS;
        }

        return chainableExpression;
    }

    private static void addExpressionToChain(final @NonNull RealExpression chainableExpression,
                                             final @NonNull Expression childExpression) {
        assert chainableExpression != null;
        assert childExpression != null;

        if (childExpression instanceof RealExpression childRealExpression) {
            childRealExpression.parent = chainableExpression;
        }
        chainableExpression.children.add(childExpression);
    }

    private void addFunCallParameters(final @NonNull RealExpression expression,
                                      final @NonNull CallSuffixContext callSuffixCtx) {
        assert expression != null;
        assert callSuffixCtx != null;

        final var valueArgsCtx = callSuffixCtx.valueArguments();
        if (valueArgsCtx != null) {
            for (final var valueArgCtx : valueArgsCtx.valueArgument()) {
                final var callArgument = new RealExpression(FUN_CALL_PARAMETER);
                if (valueArgCtx.simpleIdentifier() != null) {
                    // for named argument
                    callArgument.identifiers.add(visitSimpleIdentifier(valueArgCtx.simpleIdentifier()));
                }
                callArgument.children.add(visitExpression(valueArgCtx.expression()));
                expression.children.add(addAstInfo(callArgument, valueArgCtx));
            }
        }
    }

    @Override
    public @NonNull AstType visitType(final @NonNull TypeContext ctx) {
        assert ctx != null;

        final AstType type;
        if (ctx.userType() != null) {
            type = visitUserType(ctx.userType());
        } else {
            throw new UnsupportedOperationException();
        }
        type.annotations = visitAnnotations(ctx.annotation());
        return type;
    }

    @Override
    public @NonNull AstType visitUserType(final @NonNull UserTypeContext ctx) {
        assert ctx != null;

        final var simpleUserTypes = ctx.simpleUserType();
        if (simpleUserTypes.size() == 1) {
            final var simpleUserTypeCtx = simpleUserTypes.getFirst();
            return new AstType(
                    visitSimpleIdentifier(simpleUserTypeCtx.simpleIdentifier()),
                    genericParameters(simpleUserTypeCtx) // add generic parameters
            );
        }

        // else multiple identifiers
        final var multipleIdentifier = new MultipleIdentifier();
        for (final var simpleUserTypeCtx : simpleUserTypes) {
            multipleIdentifier.identifiers.add(visitSimpleIdentifier(simpleUserTypeCtx.simpleIdentifier()));
        }
        return new AstType(
                multipleIdentifier,
                genericParameters(simpleUserTypes.getLast()) // the last item contains the generic parameters
        );
    }

    private @Nullable List<@NonNull AstType> genericParameters(final @NonNull SimpleUserTypeContext ctx) {
        assert ctx != null;

        if (ctx.typeArguments() == null) {
            return null;
        }

        final var parameters = new ArrayList<AstType>();
        for (final var typeProjectionCtx : ctx.typeArguments().typeProjection()) {
            parameters.add(visitTypeProjection(typeProjectionCtx));
        }
        return parameters;
    }

    @Override
    public @NonNull AstType visitTypeProjection(final @NonNull TypeProjectionContext ctx) {
        assert ctx != null;

        final var type = visitType(ctx.type());
        if (ctx.typeProjectionModifiers() != null) {
            throw new UnsupportedOperationException();
        }
        return addAstInfo(type, ctx);
    }

    @Override
    public @NonNull ElementModifier visitModifier(final @NonNull ModifierContext ctx) {
        assert ctx != null;

        final ElementModifier.ModifierType type;
        if (ctx.visibilityModifier() != null) {
            type = ElementModifier.ModifierType.VISIBILITY;
        } else if (ctx.classModifier() != null) {
            type = ElementModifier.ModifierType.CLASS;
        } else if (ctx.VARARG() != null) {
            type = ElementModifier.ModifierType.PARAMETER;
        } else if (ctx.inheritanceModifier() != null) {
            type = ElementModifier.ModifierType.INHERITANCE;
        } else if (ctx.memberModifier() != null) {
            type = ElementModifier.ModifierType.MEMBER;
        } else {
            throw new IllegalStateException("Unknown modifier: " + ctx.getText());
        }
        return addAstInfo(new ElementModifier(type, ctx.getText()), ctx, true);
    }

    private void addModifiersAndAnnotations(final @Nullable ModifiersContext ctx, final @NonNull RealElement element) {
        assert element != null;
        if (ctx == null) {
            return;
        }

        for (final var modifierCtx : ctx.modifier()) {
            element.modifiers.add(visitModifier(modifierCtx));
        }
        element.annotations = visitAnnotations(ctx.annotation());
    }

    private @Nullable List<@NonNull Annotation> visitAnnotations(
            final @NonNull List<@NonNull AnnotationContext> annotationsCtx) {
        assert annotationsCtx != null;

        if (annotationsCtx.isEmpty()) {
            return null;
        }

        final var annotations = new ArrayList<@NonNull Annotation>();
        for (final var annotationCtx : annotationsCtx) {
            final var singleAnnotationCtx = annotationCtx.singleAnnotation();
            if (singleAnnotationCtx != null) {
                annotations.add(visitAnnotation(singleAnnotationCtx.unescapedAnnotation(),
                        singleAnnotationCtx.annotationUseSiteTarget()));
            } else {
                final var multiAnnotationsCtx = annotationCtx.multiAnnotations();
                for (final var unescapedAnnotation : multiAnnotationsCtx.unescapedAnnotation()) {
                    annotations.add(visitAnnotation(unescapedAnnotation,
                            multiAnnotationsCtx.annotationUseSiteTarget()));
                }
            }
        }
        return annotations;
    }

    private @NonNull Annotation visitAnnotation(
            final @NonNull UnescapedAnnotationContext unescapedAnnotationCtx,
            final @Nullable AnnotationUseSiteTargetContext annotationUseSiteTargetCtx
    ) {
        assert unescapedAnnotationCtx != null;

        final var annotation = new Annotation(visitUserType(unescapedAnnotationCtx.userType()));
        if (annotationUseSiteTargetCtx != null) {
            final var useSiteTarget = annotationUseSiteTargetCtx.getText();
            annotation.useSiteTarget = toEnumUseSiteTarget(useSiteTarget);
        }
        return addAstInfo(annotation, unescapedAnnotationCtx);
    }

    private static Annotation.@NonNull UseSiteTarget toEnumUseSiteTarget(final @NonNull String useSiteTarget) {
        // A use-site target is like '@get', we want 'GET'
        final var cleaned = useSiteTarget.substring(1).toUpperCase(Locale.US);
        return Annotation.UseSiteTarget.valueOf(cleaned);
    }

    @Override
    public @NonNull SimpleIdentifier visitSimpleIdentifier(final @NonNull SimpleIdentifierContext ctx) {
        assert ctx != null;
        return addAstInfo(new SimpleIdentifier(ctx.getText()), ctx, true);
    }

    private <T extends Ast> T addAstInfo(final @NonNull T ast,
                                         final @NonNull ParserRuleContext ctx) {
        return addAstInfo(ast, ctx, false);
    }

    private <T extends Ast> T addAstInfo(final @NonNull T ast,
                                         final @NonNull ParserRuleContext ctx,
                                         final boolean excludeStopText) {
        final var start = new Position(
                ctx.start.getStartIndex(),
                ctx.start.getLine(),
                ctx.start.getCharPositionInLine() + 1
        );

        final var stopTextLength = excludeStopText ? ctx.stop.getText().length() : 0;
        final var stop = new Position(
                ctx.stop.getStopIndex() + 1,
                ctx.stop.getLine(),
                ctx.stop.getCharPositionInLine() + 1 + stopTextLength
        );

        ast.setInfo(new AstInfo(ctx.start.getTokenIndex(), start, stop));
        return ast;
    }
}
