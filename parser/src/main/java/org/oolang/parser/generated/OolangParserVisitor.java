// Generated from OolangParser.g4 by ANTLR 4.13.2
package org.oolang.parser.generated;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link OolangParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface OolangParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link OolangParser#oolangFile}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOolangFile(OolangParser.OolangFileContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#packageHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPackageHeader(OolangParser.PackageHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#importList}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportList(OolangParser.ImportListContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#importHeader}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportHeader(OolangParser.ImportHeaderContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#importAlias}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImportAlias(OolangParser.ImportAliasContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#declaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(OolangParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#classDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassDeclaration(OolangParser.ClassDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#primaryConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrimaryConstructor(OolangParser.PrimaryConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#classParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParameters(OolangParser.ClassParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#classParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassParameter(OolangParser.ClassParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#delegationSpecifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelegationSpecifiers(OolangParser.DelegationSpecifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#annotatedDelegationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotatedDelegationSpecifier(OolangParser.AnnotatedDelegationSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#delegationSpecifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDelegationSpecifier(OolangParser.DelegationSpecifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#constructorInvocation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorInvocation(OolangParser.ConstructorInvocationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#explicitDelegation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExplicitDelegation(OolangParser.ExplicitDelegationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#classBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassBody(OolangParser.ClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameters(OolangParser.TypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameter(OolangParser.TypeParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeConstraints}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstraints(OolangParser.TypeConstraintsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeConstraint}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeConstraint(OolangParser.TypeConstraintContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#classMemberDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassMemberDeclaration(OolangParser.ClassMemberDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#anonymousInitializer}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousInitializer(OolangParser.AnonymousInitializerContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#secondaryConstructor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSecondaryConstructor(OolangParser.SecondaryConstructorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#constructorDelegationCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConstructorDelegationCall(OolangParser.ConstructorDelegationCallContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDeclaration(OolangParser.FunctionDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionValueParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionValueParameters(OolangParser.FunctionValueParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionValueParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionValueParameter(OolangParser.FunctionValueParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionBody(OolangParser.FunctionBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#propertyDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPropertyDeclaration(OolangParser.PropertyDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#variableDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariableDeclaration(OolangParser.VariableDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#getter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGetter(OolangParser.GetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#setter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSetter(OolangParser.SetterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parametersWithOptionalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParametersWithOptionalType(OolangParser.ParametersWithOptionalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionValueParameterWithOptionalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionValueParameterWithOptionalType(OolangParser.FunctionValueParameterWithOptionalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parameterWithOptionalType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterWithOptionalType(OolangParser.ParameterWithOptionalTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameter(OolangParser.ParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#enumClassBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumClassBody(OolangParser.EnumClassBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#enumEntries}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntries(OolangParser.EnumEntriesContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#enumEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEnumEntry(OolangParser.EnumEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#type}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitType(OolangParser.TypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#nullableType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNullableType(OolangParser.NullableTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#quest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuest(OolangParser.QuestContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#userType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUserType(OolangParser.UserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#simpleUserType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleUserType(OolangParser.SimpleUserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeProjection}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeProjection(OolangParser.TypeProjectionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeProjectionModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeProjectionModifiers(OolangParser.TypeProjectionModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeProjectionModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeProjectionModifier(OolangParser.TypeProjectionModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionType(OolangParser.FunctionTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionTypeParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionTypeParameters(OolangParser.FunctionTypeParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parenthesizedType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedType(OolangParser.ParenthesizedTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#receiverType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitReceiverType(OolangParser.ReceiverTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parenthesizedUserType}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedUserType(OolangParser.ParenthesizedUserTypeContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#statements}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatements(OolangParser.StatementsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#statement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStatement(OolangParser.StatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#blockLevelExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockLevelExpression(OolangParser.BlockLevelExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#blockLevelDeclaration}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockLevelDeclaration(OolangParser.BlockLevelDeclarationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#label}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLabel(OolangParser.LabelContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#assignment}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(OolangParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#loopStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLoopStatement(OolangParser.LoopStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#forStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitForStatement(OolangParser.ForStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#whileStatement}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileStatement(OolangParser.WhileStatementContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#controlStructureBody}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitControlStructureBody(OolangParser.ControlStructureBodyContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#block}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(OolangParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(OolangParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#disjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDisjunction(OolangParser.DisjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#conjunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitConjunction(OolangParser.ConjunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#equality}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEquality(OolangParser.EqualityContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#comparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparison(OolangParser.ComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#genericCallLikeComparison}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGenericCallLikeComparison(OolangParser.GenericCallLikeComparisonContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#isExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsExpression(OolangParser.IsExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#elvisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElvisExpression(OolangParser.ElvisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#elvis}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitElvis(OolangParser.ElvisContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#additiveExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveExpression(OolangParser.AdditiveExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#multiplicativeExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeExpression(OolangParser.MultiplicativeExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeRHS}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeRHS(OolangParser.TypeRHSContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#prefixUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixUnaryExpression(OolangParser.PrefixUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#unaryPrefix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnaryPrefix(OolangParser.UnaryPrefixContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#postfixUnaryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixUnaryExpression(OolangParser.PostfixUnaryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#atomicExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomicExpression(OolangParser.AtomicExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parenthesizedExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedExpression(OolangParser.ParenthesizedExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#collectionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCollectionLiteral(OolangParser.CollectionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#literalConstant}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralConstant(OolangParser.LiteralConstantContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#stringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitStringLiteral(OolangParser.StringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#lineStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringLiteral(OolangParser.LineStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#multiLineStringLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLineStringLiteral(OolangParser.MultiLineStringLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#lineStringContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringContent(OolangParser.LineStringContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#lineStringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLineStringExpression(OolangParser.LineStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#multiLineStringContent}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLineStringContent(OolangParser.MultiLineStringContentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#multiLineStringExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiLineStringExpression(OolangParser.MultiLineStringExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#lambdaLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaLiteral(OolangParser.LambdaLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#lambdaParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLambdaParameters(OolangParser.LambdaParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#anonymousFunction}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnonymousFunction(OolangParser.AnonymousFunctionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#functionLiteral}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionLiteral(OolangParser.FunctionLiteralContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#thisExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitThisExpression(OolangParser.ThisExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#superExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSuperExpression(OolangParser.SuperExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#ifExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfExpression(OolangParser.IfExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#whenSubject}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenSubject(OolangParser.WhenSubjectContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#whenExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenExpression(OolangParser.WhenExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#whenEntry}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenEntry(OolangParser.WhenEntryContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#whenCondition}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhenCondition(OolangParser.WhenConditionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeTest}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeTest(OolangParser.TypeTestContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#tryExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTryExpression(OolangParser.TryExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#catchBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCatchBlock(OolangParser.CatchBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#finallyBlock}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFinallyBlock(OolangParser.FinallyBlockContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#jumpExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitJumpExpression(OolangParser.JumpExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#callableReference}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallableReference(OolangParser.CallableReferenceContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#postfixUnarySuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixUnarySuffix(OolangParser.PostfixUnarySuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#directlyAssignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDirectlyAssignableExpression(OolangParser.DirectlyAssignableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parenthesizedDirectlyAssignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedDirectlyAssignableExpression(OolangParser.ParenthesizedDirectlyAssignableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#assignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableExpression(OolangParser.AssignableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parenthesizedAssignableExpression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParenthesizedAssignableExpression(OolangParser.ParenthesizedAssignableExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#assignableSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignableSuffix(OolangParser.AssignableSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#indexingSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIndexingSuffix(OolangParser.IndexingSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#navigationSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNavigationSuffix(OolangParser.NavigationSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#callSuffix}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallSuffix(OolangParser.CallSuffixContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#annotatedLambda}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotatedLambda(OolangParser.AnnotatedLambdaContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeArguments(OolangParser.TypeArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#valueArguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArguments(OolangParser.ValueArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#valueArgument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitValueArgument(OolangParser.ValueArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#assignmentAndOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignmentAndOperator(OolangParser.AssignmentAndOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#equalityOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityOperator(OolangParser.EqualityOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#comparisonOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitComparisonOperator(OolangParser.ComparisonOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#isOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIsOperator(OolangParser.IsOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#additiveOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAdditiveOperator(OolangParser.AdditiveOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#multiplicativeOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiplicativeOperator(OolangParser.MultiplicativeOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeOperation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeOperation(OolangParser.TypeOperationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#prefixUnaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPrefixUnaryOperator(OolangParser.PrefixUnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#postfixUnaryOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPostfixUnaryOperator(OolangParser.PostfixUnaryOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#excl}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExcl(OolangParser.ExclContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#memberAccessOperator}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberAccessOperator(OolangParser.MemberAccessOperatorContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#safeNav}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSafeNav(OolangParser.SafeNavContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#modifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifiers(OolangParser.ModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#parameterModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameterModifiers(OolangParser.ParameterModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#modifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitModifier(OolangParser.ModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#classModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitClassModifier(OolangParser.ClassModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#memberModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMemberModifier(OolangParser.MemberModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#visibilityModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVisibilityModifier(OolangParser.VisibilityModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#varianceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVarianceModifier(OolangParser.VarianceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeParameterModifiers}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifiers(OolangParser.TypeParameterModifiersContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#typeParameterModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTypeParameterModifier(OolangParser.TypeParameterModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#inheritanceModifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInheritanceModifier(OolangParser.InheritanceModifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#annotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotation(OolangParser.AnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#singleAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingleAnnotation(OolangParser.SingleAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#multiAnnotations}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMultiAnnotations(OolangParser.MultiAnnotationsContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#annotationUseSiteTarget}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnnotationUseSiteTarget(OolangParser.AnnotationUseSiteTargetContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#unescapedAnnotation}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitUnescapedAnnotation(OolangParser.UnescapedAnnotationContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#simpleIdentifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSimpleIdentifier(OolangParser.SimpleIdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#identifier}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIdentifier(OolangParser.IdentifierContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#semi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSemi(OolangParser.SemiContext ctx);
	/**
	 * Visit a parse tree produced by {@link OolangParser#anysemi}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAnysemi(OolangParser.AnysemiContext ctx);
}