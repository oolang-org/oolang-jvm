/**
 * Copyright (c) 2026-present, Oolang contributors. Use of this source code is governed by the Apache 2.0 license.
 *
 * This Oolang lexical grammar in ANTLR4 notation is derived from this Apache 2 file
 * https://github.com/kotlinx/ast/blob/master/grammar-kotlin-parser-common/src/commonAntlr/antlr/KotlinLexer.g4
 */

lexer grammar OolangLexer;

import UnicodeClasses;

// SECTION: lexicalGeneral

channels { COMMENT }

DelimitedComment
    : '/*' ( DelimitedComment | . )*? '*/'
      -> channel(COMMENT)
    ;

LineComment
    : '//' ~[\r\n]*
      -> channel(COMMENT)
    ;

WS
    : [\u0020\u0009\u000C]
      -> channel(HIDDEN)
    ;

NL: '\n' | '\r' '\n'?;

fragment Hidden: DelimitedComment | LineComment | WS;

// SECTION: separatorsAndOperations

RESERVED         : '...';
DOT              : '.';
COMMA            : ',';
LPAREN           : '(' -> pushMode(Inside);
RPAREN           : ')';
LSQUARE          : '[' -> pushMode(Inside);
RSQUARE          : ']';
LCURL            : '{';
RCURL            : '}';
MULT             : '*';
MOD              : '%';
DIV              : '/';
ADD              : '+';
SUB              : '-';
INCR             : '++';
DECR             : '--';
CONJ             : '&&';
DISJ             : '||';
EXCL_WS          : '!' Hidden;
EXCL_NO_WS       : '!';
COLON            : ':';
SEMICOLON        : ';';
ASSIGNMENT       : '=';
ADD_ASSIGNMENT   : '+=';
SUB_ASSIGNMENT   : '-=';
MULT_ASSIGNMENT  : '*=';
DIV_ASSIGNMENT   : '/=';
MOD_ASSIGNMENT   : '%=';
ARROW            : '->';
COLONCOLON       : '::';
AT_NO_WS         : '@';
AT_POST_WS       : '@' (Hidden | NL);
AT_PRE_WS        : (Hidden | NL) '@' ;
AT_BOTH_WS       : (Hidden | NL) '@' (Hidden | NL);
QUEST_WS         : '?' Hidden;
QUEST_NO_WS      : '?';
ELVIS_WS         : '?:' Hidden;
ELVIS_NO_WS      : '?:';
LANGLE           : '<';
RANGLE           : '>';
LE               : '<=';
GE               : '>=';
EXCL_EQ          : '!=';
EXCL_EQEQ        : '!==';
AS_SAFE          : 'as?';
EQEQ             : '==';
EQEQEQ           : '===';
SINGLE_QUOTE     : '\'';
AND              : '&';
OR               : '|';

// SECTION: keywords

/* RETURN_AT: 'return@' Identifier;
CONTINUE_AT: 'continue@' Identifier;
BREAK_AT: 'break@' Identifier;
THIS_AT: 'this@' Identifier;
SUPER_AT: 'super@' Identifier;

FILE_SITE        : '@file';*/
PACKAGE          : 'package';
IMPORT           : 'import';
CLASS            : 'class';
INTERFACE        : 'interface';
// CONTEXT       : 'context';
FUN              : 'fun';
VAL              : 'val';
VAR              : 'var';
CONSTRUCTOR      : 'constructor';
BY               : 'by';
INIT             : 'init';
THIS             : 'this';
SUPER            : 'super';
TYPEOF           : 'typeof';
WHERE            : 'where';
IF               : 'if';
ELSE             : 'else';
WHEN             : 'when';
TRY              : 'try';
CATCH            : 'catch';
FINALLY          : 'finally';
FOR              : 'for';
WHILE            : 'while';
THROW            : 'throw';
RETURN           : 'return';
CONTINUE         : 'continue';
YIELD            : 'yield';
AS               : 'as';
IS               : 'is';
NOT_IS           : '!is' (Hidden | NL);
IN               : 'in';
OUT              : 'out';
FIELD_SITE       : '@field';
FIELD            : 'field';
PROPERTY_SITE    : '@property';
GET_SITE         : '@get';
SET_SITE         : '@set';
GET              : 'get';
SET              : 'set';
// RECEIVER_SITE : '@receiver';
PARAM_SITE       : '@param';
SETPARAM_SITE    : '@setparam';
DELEGATE_SITE    : '@delegate';

// SECTION: lexical modifiers

PUBLIC      : 'public';
PRIVATE     : 'private';
PROTECTED   : 'protected';
ENUM        : 'enum';
SEALED      : 'sealed';
VALUE       : 'value';
RECORD      : 'record';
INNER       : 'inner';
ANNOTATION  : 'annotation';
OVERRIDE    : 'override';
ABSTRACT    : 'abstract';
FINAL       : 'final';
OPEN        : 'open';
STATIC      : 'static'; // oolang addition
// LATEINIT : 'lateinit';
VARARG      : 'vararg';

// SECTION: literals

fragment DecDigit: '0'..'9';
fragment DecDigitNoZero: '1'..'9';
fragment DecDigitOrSeparator: DecDigit | '_';

fragment DecDigits
    : DecDigitNoZero DecDigitOrSeparator* DecDigit
    | DecDigit
    ;

fragment DoubleExponent: [eE] [+-]? DecDigits;

RealLiteral
    : FloatLiteral
    | DoubleLiteral
    ;

FloatLiteral
    : DoubleLiteral [fF]
    | DecDigits [fF]
    ;

DoubleLiteral
    : DecDigits? '.' DecDigits DoubleExponent?
    | DecDigits DoubleExponent
    ;

IntegerLiteral
    : DecDigits
    ;

fragment HexDigit: [0-9a-fA-F];
fragment HexDigitOrSeparator: HexDigit | '_';

HexLiteral
    : '0' [xX] HexDigit HexDigitOrSeparator* HexDigit
    | '0' [xX] HexDigit
    ;

fragment BinDigit: [01];
fragment BinDigitOrSeparator: BinDigit | '_';

BinLiteral
    : '0' [bB] BinDigit BinDigitOrSeparator* BinDigit
    | '0' [bB] BinDigit
    ;

LongLiteral
    : (IntegerLiteral | HexLiteral | BinLiteral) [lL]
    ;

BooleanLiteral: 'true'| 'false';

NullLiteral: 'null';

CharacterLiteral
    : '\'' (EscapeSeq | ~[\n\r'\\]) '\''
    ;

// SECTION: lexicalIdentifiers

fragment UnicodeDigit: UNICODE_CLASS_ND;

Identifier
    : (Letter | '_') (Letter | '_' | UnicodeDigit)*
    | '`' ~([\r\n] | '`')+ '`'
    ;

FieldIdentifier: '$' Identifier;

fragment EscapeSeq
    : UniCharacterLiteral
    | EscapedIdentifier
    ;

fragment UniCharacterLiteral
    : '\\' 'u' HexDigit HexDigit HexDigit HexDigit
    ;

fragment EscapedIdentifier
    : '\\' ('t' | 'b' | 'r' | 'n' | '\'' | '"' | '\\' | '$')
    ;

// SECTION: characters

fragment Letter
    : UNICODE_CLASS_LU
    | UNICODE_CLASS_LL
    | UNICODE_CLASS_LT
    | UNICODE_CLASS_LM
    | UNICODE_CLASS_LO
    ;

// SECTION: strings

QUOTE_OPEN: '"' -> pushMode(LineString);

TRIPLE_QUOTE_OPEN: '"""' -> pushMode(MultiLineString);

mode LineString;

QUOTE_CLOSE
    : '"' -> popMode
    ;

LineStrRef
    : FieldIdentifier
    ;

LineStrText
    : ~('\\' | '"' /*| '$'*/)+ /*| '$'*/
    ;

LineStrEscapedChar
    : EscapedIdentifier
    | UniCharacterLiteral
    ;

LineStrExprStart
    : '${' -> pushMode(DEFAULT_MODE)
    ;

mode MultiLineString;

TRIPLE_QUOTE_CLOSE
    : MultiLineStringQuote? '"""' -> popMode
    ;

MultiLineStringQuote
    : '"'+
    ;

MultiLineStrRef
    : FieldIdentifier
    ;

MultiLineStrText
    :  ~('\\' | '"' | '$')+ | '$'
    ;

MultiLineStrEscapedChar: '\\' .;

MultiLineStrExprStart
    : '${' -> pushMode(DEFAULT_MODE)
    ;

MultiLineNL: NL -> skip;

// SECTION: inside

mode Inside;

Inside_RPAREN  : RPAREN -> popMode, type(RPAREN);
Inside_RSQUARE : RSQUARE -> popMode, type(RSQUARE);

Inside_LPAREN  : LPAREN -> pushMode(Inside), type(LPAREN);
Inside_LSQUARE : LSQUARE -> pushMode(Inside), type(LSQUARE);

Inside_LCURL              : LCURL              -> type(LCURL);
Inside_RCURL              : RCURL              -> type(RCURL);
Inside_DOT                : DOT                -> type(DOT);
Inside_COMMA              : COMMA              -> type(COMMA);
Inside_MULT               : MULT               -> type(MULT);
Inside_MOD                : MOD                -> type(MOD);
Inside_DIV                : DIV                -> type(DIV);
Inside_ADD                : ADD                -> type(ADD);
Inside_SUB                : SUB                -> type(SUB);
Inside_INCR               : INCR               -> type(INCR);
Inside_DECR               : DECR               -> type(DECR);
Inside_CONJ               : CONJ               -> type(CONJ);
Inside_DISJ               : DISJ               -> type(DISJ);
Inside_EXCL_WS            : '!' (Hidden|NL)    -> type(EXCL_WS);
Inside_EXCL_NO_WS         : EXCL_NO_WS         -> type(EXCL_NO_WS);
Inside_COLON              : COLON              -> type(COLON);
Inside_SEMICOLON          : SEMICOLON          -> type(SEMICOLON);
Inside_ASSIGNMENT         : ASSIGNMENT         -> type(ASSIGNMENT);
Inside_ADD_ASSIGNMENT     : ADD_ASSIGNMENT     -> type(ADD_ASSIGNMENT);
Inside_SUB_ASSIGNMENT     : SUB_ASSIGNMENT     -> type(SUB_ASSIGNMENT);
Inside_MULT_ASSIGNMENT    : MULT_ASSIGNMENT    -> type(MULT_ASSIGNMENT);
Inside_DIV_ASSIGNMENT     : DIV_ASSIGNMENT     -> type(DIV_ASSIGNMENT);
Inside_MOD_ASSIGNMENT     : MOD_ASSIGNMENT     -> type(MOD_ASSIGNMENT);
Inside_ARROW              : ARROW              -> type(ARROW);
Inside_RESERVED           : RESERVED           -> type(RESERVED);
Inside_COLONCOLON         : COLONCOLON         -> type(COLONCOLON);
Inside_AT_NO_WS           : AT_NO_WS           -> type(AT_NO_WS);
Inside_AT_POST_WS         : AT_POST_WS         -> type(AT_POST_WS);
Inside_AT_PRE_WS          : AT_PRE_WS          -> type(AT_PRE_WS);
Inside_AT_BOTH_WS         : AT_BOTH_WS         -> type(AT_BOTH_WS);
Inside_QUEST_WS           : '?' (Hidden | NL)  -> type(QUEST_WS);
Inside_QUEST_NO_WS        : QUEST_NO_WS        -> type(QUEST_NO_WS);
Inside_ELVIS_WS           : '?:' (Hidden | NL) -> type(ELVIS_WS);
Inside_ELVIS_NO_WS        : ELVIS_NO_WS        -> type(ELVIS_NO_WS);
Inside_LANGLE             : LANGLE             -> type(LANGLE);
Inside_RANGLE             : RANGLE             -> type(RANGLE);
Inside_LE                 : LE                 -> type(LE);
Inside_GE                 : GE                 -> type(GE);
Inside_EXCL_EQ            : EXCL_EQ            -> type(EXCL_EQ);
Inside_EXCL_EQEQ          : EXCL_EQEQ          -> type(EXCL_EQEQ);
Inside_IS                 : IS                 -> type(IS);
Inside_NOT_IS             : NOT_IS             -> type(NOT_IS);
Inside_AS                 : AS                 -> type(AS);
Inside_AS_SAFE            : AS_SAFE            -> type(AS_SAFE);
Inside_EQEQ               : EQEQ               -> type(EQEQ);
Inside_EQEQEQ             : EQEQEQ             -> type(EQEQEQ);
Inside_SINGLE_QUOTE       : SINGLE_QUOTE       -> type(SINGLE_QUOTE);
Inside_QUOTE_OPEN         : QUOTE_OPEN         -> pushMode(LineString), type(QUOTE_OPEN);
Inside_TRIPLE_QUOTE_OPEN  : TRIPLE_QUOTE_OPEN  -> pushMode(MultiLineString), type(TRIPLE_QUOTE_OPEN);
Inside_AND                : AND                -> type(AND);
Inside_OR                 : OR                 -> type(OR);

Inside_VAL         : VAL            -> type(VAL);
Inside_VAR         : VAR            -> type(VAR);
Inside_SUPER       : SUPER          -> type(SUPER);
Inside_IN          : IN             -> type(IN);
Inside_OUT         : OUT            -> type(OUT);
Inside_FIELD       : FIELD          -> type(FIELD);
Inside_PROPERTY    : PROPERTY_SITE  -> type(PROPERTY_SITE);
Inside_GET         : GET_SITE       -> type(GET_SITE);
Inside_SET         : SET_SITE       -> type(SET_SITE);
//Inside_RECEIVER    : RECEIVER_SITE  -> type(RECEIVER_SITE);
Inside_PARAM       : PARAM_SITE     -> type(PARAM_SITE);
Inside_SETPARAM    : SETPARAM_SITE  -> type(SETPARAM_SITE);
Inside_DELEGATE    : DELEGATE_SITE  -> type(DELEGATE_SITE);
Inside_THROW       : THROW          -> type(THROW);
Inside_RETURN      : RETURN         -> type(RETURN);
Inside_CONTINUE    : CONTINUE       -> type(CONTINUE);
Inside_YIELD       : YIELD          -> type(YIELD);
/*Inside_BREAK     : BREAK          -> type(BREAK);
Inside_RETURN_AT   : RETURN_AT      -> type(RETURN_AT);
Inside_CONTINUE_AT : CONTINUE_AT    -> type(CONTINUE_AT);
Inside_BREAK_AT    : BREAK_AT       -> type(BREAK_AT);*/
Inside_IF          : IF             -> type(IF);
Inside_ELSE        : ELSE           -> type(ELSE);
Inside_WHEN        : WHEN           -> type(WHEN);
Inside_TRY         : TRY            -> type(TRY);
Inside_CATCH       : CATCH          -> type(CATCH);
Inside_FINALLY     : FINALLY        -> type(FINALLY);
Inside_FOR         : FOR            -> type(FOR);
Inside_WHILE       : WHILE          -> type(WHILE);

Inside_PUBLIC      : PUBLIC      -> type(PUBLIC);
Inside_PRIVATE     : PRIVATE     -> type(PRIVATE);
Inside_PROTECTED   : PROTECTED   -> type(PROTECTED);
Inside_ENUM        : ENUM        -> type(ENUM);
Inside_SEALED      : SEALED      -> type(SEALED);
Inside_RECORD      : RECORD      -> type(RECORD);
Inside_INNER       : INNER       -> type(INNER);
Inside_ANNOTATION  : ANNOTATION  -> type(ANNOTATION);
Inside_OVERRIDE    : OVERRIDE    -> type(OVERRIDE);
Inside_ABSTRACT    : ABSTRACT    -> type(ABSTRACT);
Inside_FINAL       : FINAL       -> type(FINAL);
Inside_OPEN        : OPEN        -> type(OPEN);
// Inside_LATEINIT : LATEINIT    -> type(LATEINIT);
Inside_VARARG      : VARARG      -> type(VARARG);

Inside_BooleanLiteral   : BooleanLiteral   -> type(BooleanLiteral);
Inside_IntegerLiteral   : IntegerLiteral   -> type(IntegerLiteral);
Inside_LongLiteral      : LongLiteral      -> type(LongLiteral);
Inside_HexLiteral       : HexLiteral       -> type(HexLiteral);
Inside_BinLiteral       : BinLiteral       -> type(BinLiteral);
Inside_CharacterLiteral : CharacterLiteral -> type(CharacterLiteral);
Inside_RealLiteral      : RealLiteral      -> type(RealLiteral);
Inside_NullLiteral      : NullLiteral      -> type(NullLiteral);

Inside_Identifier      : Identifier                       -> type(Identifier);
Inside_Comment         : (LineComment | DelimitedComment) -> channel(COMMENT);
Inside_WS              : WS                               -> skip;
Inside_NL              : NL                               -> skip;

// fixme what is it for ?
mode DEFAULT_MODE;

ErrorCharacter: .;
