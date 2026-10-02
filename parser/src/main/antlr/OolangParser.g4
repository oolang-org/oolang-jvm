/**
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 *
 * This Oolang parser grammar in ANTLR4 notation is derived from this Apache 2 file
 * https://github.com/kotlinx/ast/blob/master/grammar-kotlin-parser-common/src/commonAntlr/antlr/OolangParser.g4
 */

parser grammar OolangParser;

options { tokenVocab = OolangLexer; }

// SECTION: general

oolangFile
    : packageHeader? importList anysemi* classDeclaration (anysemi+ classDeclaration?)* EOF
    ;

packageHeader
    : PACKAGE identifier semi?
    ;

importList
    : importHeader*
    ;

importHeader
    : IMPORT identifier importAlias? semi?
    ;

importAlias
    : AS simpleIdentifier
    ;

declaration
    : classDeclaration
    | functionDeclaration
    | propertyDeclaration
    ;

// SECTION: classes

classDeclaration
    : modifiers? (CLASS | (FUN NL*)? INTERFACE) NL* simpleIdentifier
      (NL* typeParameters)? (NL* primaryConstructor)?
      (NL* COLON NL* delegationSpecifiers)? (NL* typeConstraints)?
      (NL* classBody | NL* enumClassBody)?
    ;

primaryConstructor
    : modifiers? (CONSTRUCTOR NL*)? classParameters
    ;

classParameters
    : LPAREN NL* (classParameter (NL* COMMA NL* classParameter)* (NL* COMMA)?)? NL* RPAREN
    ;

classParameter
    : modifiers? (VAL | VAR)? NL* simpleIdentifier COLON NL* type (NL* ASSIGNMENT NL* expression)?
    ;

delegationSpecifiers
    : annotatedDelegationSpecifier (NL* COMMA NL* annotatedDelegationSpecifier)*
    ;

annotatedDelegationSpecifier
    : singleAnnotation* NL* delegationSpecifier
    ;

delegationSpecifier
    : constructorInvocation
    | explicitDelegation
    | userType
    | functionType
    ;

constructorInvocation
    : userType NL* callSuffix
    ;

explicitDelegation
    : (userType | functionType) NL* BY NL* expression
    ;

classBody
    : LCURL NL* classMemberDeclaration* NL* RCURL
    ;

typeParameters
    : LANGLE NL* typeParameter (NL* COMMA NL* typeParameter)* (NL* COMMA)? NL* RANGLE
    ;

typeParameter
    : typeParameterModifiers? NL* (simpleIdentifier | MULT) (NL* COLON NL* type)?
    ;

typeConstraints
    : WHERE NL* typeConstraint (NL* COMMA NL* typeConstraint)*
    ;

typeConstraint
    : singleAnnotation* simpleIdentifier NL* COLON NL* type
    ;

// SECTION: classMembers

classMemberDeclaration
    : (
        declaration
        | anonymousInitializer
        | secondaryConstructor
    ) anysemi+
    ;

anonymousInitializer
    : INIT NL* block
    ;

secondaryConstructor
    : modifiers? CONSTRUCTOR NL* functionValueParameters (NL* COLON NL* constructorDelegationCall)? NL* block?
    ;

constructorDelegationCall
    : (THIS | SUPER) NL* valueArguments
    ;

functionDeclaration
    : modifiers? FUN (NL* typeParameters)? (NL* receiverType NL* DOT)? NL* simpleIdentifier
      NL* functionValueParameters (NL* COLON NL* type)? (NL* typeConstraints)? (NL* functionBody)?
    ;

functionValueParameters
    : LPAREN NL* (functionValueParameter (NL* COMMA NL* functionValueParameter)* (NL* COMMA)?)? NL* RPAREN
    ;

functionValueParameter
    : parameterModifiers? parameter (NL* ASSIGNMENT NL* expression)?
    ;

functionBody
    : block
    | ASSIGNMENT NL* expression
    ;

propertyDeclaration
    : modifiers? (VAL | VAR) (NL* typeParameters)? (NL* receiverType NL* DOT)?
      (NL* /*(multiVariableDeclaration | variableDeclaration)*/ variableDeclaration)
      (NL* typeConstraints)? (NL* (BY | ASSIGNMENT) NL* expression)?
      (NL* SEMICOLON)? NL* (getter (NL* semi? setter)? | setter (NL* semi? getter))?
    ;

variableDeclaration
    : singleAnnotation* NL* simpleIdentifier (NL* COLON NL* type)?
    ;

getter
    : modifiers? GET
      (NL* LPAREN NL* RPAREN (NL* COLON NL* type)? NL* functionBody)?
    ;

setter
    : modifiers? SET
      (NL* LPAREN NL* functionValueParameterWithOptionalType (NL* COMMA)? NL* RPAREN NL* functionBody)?
    ;

parametersWithOptionalType
    : LPAREN NL* (functionValueParameterWithOptionalType (NL* COMMA NL* functionValueParameterWithOptionalType)* (NL* COMMA)?)? NL* RPAREN
    ;

functionValueParameterWithOptionalType
    : parameterModifiers? parameterWithOptionalType (NL* ASSIGNMENT NL* expression)?
    ;

parameterWithOptionalType
    : simpleIdentifier NL* (COLON NL* type)?
    ;

parameter
    : simpleIdentifier NL* COLON NL* type
    ;

// SECTION: enumClasses

enumClassBody
    : LCURL NL* enumEntries? (NL* SEMICOLON NL* classMemberDeclaration*)? NL* RCURL
    ;

enumEntries
    : enumEntry+ SEMICOLON?
    ;

enumEntry
    : (modifiers NL*)? simpleIdentifier (NL* valueArguments)? (NL* classBody)? (NL* COMMA)?
    ;

// SECTION: types

type
    : annotation* (functionType | parenthesizedType | nullableType | userType)
    ;

nullableType
    : (userType | parenthesizedType) NL* quest+
    ;

quest
    : QUEST_NO_WS
    | QUEST_WS
    ;

userType
    : simpleUserType (NL* DOT NL* simpleUserType)*
    ;

simpleUserType
    : simpleIdentifier (NL* typeArguments)?
    ;

typeProjection
    : typeProjectionModifiers? type
    | MULT
    ;

typeProjectionModifiers
    : typeProjectionModifier+
    ;

typeProjectionModifier
    : varianceModifier NL*
    | singleAnnotation
    ;

functionType
    : (receiverType NL* DOT NL*)? functionTypeParameters NL* ARROW NL* type
    ;

functionTypeParameters
    : LPAREN NL* (parameter | type)? (NL* COMMA NL* (parameter | type))* (NL* COMMA)? NL* RPAREN
    ;

parenthesizedType
    : LPAREN NL* type NL* RPAREN
    ;

receiverType
    : annotation? (parenthesizedType | nullableType | userType)
    ;

parenthesizedUserType
    : LPAREN NL* (userType | parenthesizedUserType) NL* RPAREN
    ;

// SECTION: statements

statements
    : anysemi* (statement (anysemi+ statement?)*)?
    ;

statement
    : blockLevelExpression
    | blockLevelDeclaration
    ;

blockLevelExpression
    : annotation* NL* expression
    ;

blockLevelDeclaration
    : label* ( declaration | assignment | loopStatement)
    ;

label
    : simpleIdentifier (AT_NO_WS | AT_POST_WS) NL*
    ;

assignment
    : (directlyAssignableExpression ASSIGNMENT | assignableExpression assignmentAndOperator) NL* expression
    ;

loopStatement
    : forStatement
    | whileStatement
    ;

forStatement
    : FOR NL* LPAREN singleAnnotation* variableDeclaration
      COLON expression RPAREN NL* controlStructureBody?
    ;

whileStatement
    : WHILE NL* LPAREN expression RPAREN NL* (controlStructureBody | SEMICOLON)
    ;

controlStructureBody
    : block
    | statement
    ;

block
    : LCURL NL* statements NL* RCURL
    ;

// SECTION: expressions

expression
    : disjunction
    ;

disjunction
    : conjunction (NL* DISJ NL* conjunction)*
    ;

conjunction
    : equality (NL* CONJ NL* equality)*
    ;

equality
    : comparison (equalityOperator NL* comparison)*
    ;

comparison
    : genericCallLikeComparison (comparisonOperator NL* genericCallLikeComparison)*
    ;

genericCallLikeComparison
    : isExpression callSuffix*
    ;

isExpression
    : elvisExpression (isOperator NL* type)?
    ;

elvisExpression
    : additiveExpression (NL* elvis NL* additiveExpression)*
    ;

elvis
    : QUEST_NO_WS COLON
    ;

additiveExpression
    : multiplicativeExpression (additiveOperator NL* multiplicativeExpression)*
    ;

multiplicativeExpression
    : typeRHS (multiplicativeOperator NL* typeRHS)*
    ;

typeRHS
    : prefixUnaryExpression (NL* typeOperation prefixUnaryExpression)*
    ;

prefixUnaryExpression
    : unaryPrefix* postfixUnaryExpression
    ;

unaryPrefix
    : prefixUnaryOperator NL*
    | singleAnnotation
    | label
    ;

postfixUnaryExpression
    : atomicExpression postfixUnarySuffix*
    ;

atomicExpression
    : parenthesizedExpression
    | collectionLiteral
    | simpleIdentifier
    | literalConstant
    | stringLiteral
    | callableReference
    | functionLiteral
    | thisExpression
    | superExpression
    | ifExpression
    | whenExpression
    | tryExpression
    | jumpExpression
    ;

parenthesizedExpression
    : LPAREN NL* expression NL* RPAREN
    ;

collectionLiteral
    : LSQUARE NL* (expression (NL* COMMA NL* expression)* (NL* COMMA)? NL*)? RSQUARE
    ;

literalConstant
    : BooleanLiteral
    | IntegerLiteral
    | HexLiteral
    | BinLiteral
    | CharacterLiteral
    | RealLiteral
    | NullLiteral
    | LongLiteral
    ;

stringLiteral
    : lineStringLiteral
    | multiLineStringLiteral
    ;

lineStringLiteral
    : QUOTE_OPEN (lineStringContent | lineStringExpression)* QUOTE_CLOSE
    ;

multiLineStringLiteral
    : TRIPLE_QUOTE_OPEN (multiLineStringContent | multiLineStringExpression | MultiLineStringQuote)* TRIPLE_QUOTE_CLOSE
    ;

lineStringContent
    : LineStrText
    | LineStrEscapedChar
    | LineStrRef
    ;

lineStringExpression
    : LineStrExprStart NL* expression NL* RCURL
    ;

multiLineStringContent
    : MultiLineStrText
    | MultiLineStringQuote
    | MultiLineStrRef
    ;

multiLineStringExpression
    : MultiLineStrExprStart NL* expression NL* RCURL
    ;

lambdaLiteral
    : LCURL NL* (lambdaParameters? NL* ARROW NL*)? statements NL* RCURL
    ;

lambdaParameters
    : variableDeclaration (NL* COMMA NL* variableDeclaration)* (NL* COMMA)?
    ;

anonymousFunction
    : FUN
      (NL* type NL* DOT)? NL* parametersWithOptionalType (NL* COLON NL* type)?
      (NL* typeConstraints)? (NL* functionBody)?
    ;

functionLiteral
    : lambdaLiteral
    | anonymousFunction
    ;

thisExpression
    : THIS
//    | THIS_AT
    ;

superExpression
    : SUPER (LANGLE NL* type NL* RANGLE)? /* (AT_NO_WS simpleIdentifier)?
    | SUPER_AT */
    ;

ifExpression
    : IF NL* LPAREN NL* expression NL* RPAREN NL*
      ( controlStructureBody
      | controlStructureBody? NL* SEMICOLON? NL* ELSE NL* (controlStructureBody | SEMICOLON)
      | SEMICOLON)
    ;

whenSubject
    : LPAREN (singleAnnotation* NL* VAL NL* variableDeclaration NL* ASSIGNMENT NL*)? expression RPAREN
    ;

whenExpression
    : WHEN NL* whenSubject? NL* LCURL NL* (whenEntry NL*)* NL* RCURL
    ;

whenEntry
    : whenCondition (NL* COMMA NL* whenCondition)* (NL* COMMA)? NL* ARROW NL* controlStructureBody semi?
    | ELSE NL* ARROW NL* controlStructureBody semi?
    ;

whenCondition
    : expression
    | typeTest
    ;

typeTest
    : isOperator NL* type
    ;

tryExpression
    : TRY NL* block ((NL* catchBlock)+ (NL* finallyBlock)? | NL* finallyBlock)
    ;

catchBlock
    : CATCH NL* LPAREN singleAnnotation* simpleIdentifier COLON type (NL* COMMA)? RPAREN NL* block
    ;

finallyBlock
    : FINALLY NL* block
    ;

jumpExpression
    : THROW NL* expression
    | /* (RETURN | RETURN_AT) */ RETURN expression?
    | CONTINUE
/*    | CONTINUE_AT
    | BREAK
    | BREAK_AT */
    ;

callableReference
    : receiverType? COLONCOLON NL* (simpleIdentifier | CLASS)
    ;

postfixUnarySuffix
    : postfixUnaryOperator
    | typeArguments
    | callSuffix
    | indexingSuffix
    | navigationSuffix
    ;

directlyAssignableExpression
    : postfixUnaryExpression assignableSuffix
    | simpleIdentifier
    | parenthesizedDirectlyAssignableExpression
    ;

parenthesizedDirectlyAssignableExpression
    : LPAREN NL* directlyAssignableExpression NL* RPAREN
    ;

assignableExpression
    : prefixUnaryExpression
    | parenthesizedAssignableExpression
    ;

parenthesizedAssignableExpression
    : LPAREN NL* assignableExpression NL* RPAREN
    ;

assignableSuffix
    : typeArguments
    | indexingSuffix
    | navigationSuffix
    ;

indexingSuffix
    : LSQUARE NL* expression (NL* COMMA NL* expression)* (NL* COMMA)? NL* RSQUARE
    ;

navigationSuffix
    : memberAccessOperator NL* (simpleIdentifier | parenthesizedExpression | CLASS)
    ;

callSuffix
    : typeArguments? (valueArguments? annotatedLambda | valueArguments)
    ;

annotatedLambda
    : singleAnnotation* label? NL* lambdaLiteral
    ;

typeArguments
    : LANGLE NL* typeProjection (NL* COMMA NL* typeProjection)* (NL* COMMA)? NL* RANGLE
    ;

valueArguments
    : LPAREN NL* (valueArgument (NL* COMMA NL* valueArgument)* (NL* COMMA)? NL*)? RPAREN
    ;

valueArgument
    : (simpleIdentifier NL* ASSIGNMENT NL*)? MULT? NL* expression
    ;

assignmentAndOperator
    : ADD_ASSIGNMENT
    | SUB_ASSIGNMENT
    | MULT_ASSIGNMENT
    | DIV_ASSIGNMENT
    | MOD_ASSIGNMENT
    ;

equalityOperator
    : EXCL_EQ
    | EXCL_EQEQ
    | EQEQ
    | EQEQEQ
    ;

comparisonOperator
    : LANGLE
    | RANGLE
    | LE
    | GE
    ;

isOperator
    : IS
    | NOT_IS
    ;

additiveOperator
    : ADD
    | SUB
    ;

multiplicativeOperator
    : MULT
    | DIV
    | MOD
    ;

typeOperation
    : AS
    | AS_SAFE
    | COLON
    ;

prefixUnaryOperator
    : INCR
    | DECR
    | SUB
    | ADD
    | excl
    ;

postfixUnaryOperator
    : INCR
    | DECR
    | EXCL_NO_WS excl
    ;

excl
    : EXCL_NO_WS
    | EXCL_WS
    ;

memberAccessOperator
    : NL* DOT
    | NL* safeNav
    | COLONCOLON
    ;

safeNav
    : QUEST_NO_WS DOT
    ;

// SECTION: modifiers

modifiers
    : (annotation | modifier)+
    ;

parameterModifiers
    : annotation+ VARARG? /*(annotation | parameterModifier)+*/
    ;

modifier
    : (classModifier
    | memberModifier
    | visibilityModifier
    | inheritanceModifier
    | VARARG ) NL*
    ;

classModifier
    : ENUM
    | SEALED
    | ANNOTATION
    | RECORD
    | INNER
    | VALUE
    ;

memberModifier
    : OVERRIDE
    | STATIC // oolang addition
//    | LATEINIT
    ;

visibilityModifier
    : PUBLIC
    | PRIVATE
    | PROTECTED
    ;

varianceModifier
    : IN
    | OUT
    ;

typeParameterModifiers
    : typeParameterModifier+
    ;

typeParameterModifier
    : varianceModifier NL*
    | singleAnnotation
    ;

inheritanceModifier
    : ABSTRACT
    | FINAL
    | OPEN
    ;

// SECTION: annotations

annotation
    : (singleAnnotation | multiAnnotations) NL*
    ;

singleAnnotation
    : annotationUseSiteTarget NL* COLON NL* unescapedAnnotation
    | (AT_NO_WS | AT_PRE_WS) unescapedAnnotation
    ;

multiAnnotations
    : annotationUseSiteTarget COLON LSQUARE unescapedAnnotation+ RSQUARE
    | (AT_NO_WS | AT_PRE_WS) LSQUARE unescapedAnnotation+ RSQUARE
    ;

annotationUseSiteTarget
    : FIELD_SITE
    | PROPERTY_SITE
    | GET_SITE
    | SET_SITE
//    | RECEIVER_SITE
    | PARAM_SITE
    | SETPARAM_SITE
    | DELEGATE_SITE
    ;

unescapedAnnotation
    : constructorInvocation
    | userType
    ;

// SECTION: identifiers

simpleIdentifier
    : Identifier
    //soft keywords:
    | ABSTRACT
    | ANNOTATION
    | BY
    | CATCH
    | CONSTRUCTOR
    | RECORD
    | ENUM
    | FIELD
    | FINAL
    | FINALLY
    | GET
    | IMPORT
    | INIT
    | INNER
    | OPEN
    | OUT
    | OVERRIDE
    | PRIVATE
    | PROTECTED
    | PUBLIC
    | SEALED
    | SET
    | STATIC // oolang addition
//  | TAILREC
    | VARARG
    | WHERE
    ;

identifier
    : simpleIdentifier (NL* DOT simpleIdentifier)*
    ;

semi
    : NL+
    | NL* SEMICOLON NL*
    ;

anysemi
    : NL
    | SEMICOLON
    ;