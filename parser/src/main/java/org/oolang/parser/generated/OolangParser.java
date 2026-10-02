// Generated from OolangParser.g4 by ANTLR 4.13.2
package org.oolang.parser.generated;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class OolangParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		DelimitedComment=1, LineComment=2, WS=3, NL=4, RESERVED=5, DOT=6, COMMA=7, 
		LPAREN=8, RPAREN=9, LSQUARE=10, RSQUARE=11, LCURL=12, RCURL=13, MULT=14, 
		MOD=15, DIV=16, ADD=17, SUB=18, INCR=19, DECR=20, CONJ=21, DISJ=22, EXCL_WS=23, 
		EXCL_NO_WS=24, COLON=25, SEMICOLON=26, ASSIGNMENT=27, ADD_ASSIGNMENT=28, 
		SUB_ASSIGNMENT=29, MULT_ASSIGNMENT=30, DIV_ASSIGNMENT=31, MOD_ASSIGNMENT=32, 
		ARROW=33, COLONCOLON=34, AT_NO_WS=35, AT_POST_WS=36, AT_PRE_WS=37, AT_BOTH_WS=38, 
		QUEST_WS=39, QUEST_NO_WS=40, ELVIS_WS=41, ELVIS_NO_WS=42, LANGLE=43, RANGLE=44, 
		LE=45, GE=46, EXCL_EQ=47, EXCL_EQEQ=48, AS_SAFE=49, EQEQ=50, EQEQEQ=51, 
		SINGLE_QUOTE=52, AND=53, OR=54, PACKAGE=55, IMPORT=56, CLASS=57, INTERFACE=58, 
		FUN=59, VAL=60, VAR=61, CONSTRUCTOR=62, BY=63, INIT=64, THIS=65, SUPER=66, 
		TYPEOF=67, WHERE=68, IF=69, ELSE=70, WHEN=71, TRY=72, CATCH=73, FINALLY=74, 
		FOR=75, WHILE=76, THROW=77, RETURN=78, CONTINUE=79, YIELD=80, AS=81, IS=82, 
		NOT_IS=83, IN=84, OUT=85, FIELD_SITE=86, FIELD=87, PROPERTY_SITE=88, GET_SITE=89, 
		SET_SITE=90, GET=91, SET=92, PARAM_SITE=93, SETPARAM_SITE=94, DELEGATE_SITE=95, 
		PUBLIC=96, PRIVATE=97, PROTECTED=98, ENUM=99, SEALED=100, VALUE=101, RECORD=102, 
		INNER=103, ANNOTATION=104, OVERRIDE=105, ABSTRACT=106, FINAL=107, OPEN=108, 
		STATIC=109, VARARG=110, RealLiteral=111, FloatLiteral=112, DoubleLiteral=113, 
		IntegerLiteral=114, HexLiteral=115, BinLiteral=116, LongLiteral=117, BooleanLiteral=118, 
		NullLiteral=119, CharacterLiteral=120, Identifier=121, FieldIdentifier=122, 
		QUOTE_OPEN=123, TRIPLE_QUOTE_OPEN=124, UNICODE_CLASS_LL=125, UNICODE_CLASS_LM=126, 
		UNICODE_CLASS_LO=127, UNICODE_CLASS_LT=128, UNICODE_CLASS_LU=129, UNICODE_CLASS_ND=130, 
		UNICODE_CLASS_NL=131, QUOTE_CLOSE=132, LineStrRef=133, LineStrText=134, 
		LineStrEscapedChar=135, LineStrExprStart=136, TRIPLE_QUOTE_CLOSE=137, 
		MultiLineStringQuote=138, MultiLineStrRef=139, MultiLineStrText=140, MultiLineStrEscapedChar=141, 
		MultiLineStrExprStart=142, MultiLineNL=143, Inside_Comment=144, Inside_WS=145, 
		Inside_NL=146, ErrorCharacter=147;
	public static final int
		RULE_oolangFile = 0, RULE_packageHeader = 1, RULE_importList = 2, RULE_importHeader = 3, 
		RULE_importAlias = 4, RULE_declaration = 5, RULE_classDeclaration = 6, 
		RULE_primaryConstructor = 7, RULE_classParameters = 8, RULE_classParameter = 9, 
		RULE_delegationSpecifiers = 10, RULE_annotatedDelegationSpecifier = 11, 
		RULE_delegationSpecifier = 12, RULE_constructorInvocation = 13, RULE_explicitDelegation = 14, 
		RULE_classBody = 15, RULE_typeParameters = 16, RULE_typeParameter = 17, 
		RULE_typeConstraints = 18, RULE_typeConstraint = 19, RULE_classMemberDeclaration = 20, 
		RULE_anonymousInitializer = 21, RULE_secondaryConstructor = 22, RULE_constructorDelegationCall = 23, 
		RULE_functionDeclaration = 24, RULE_functionValueParameters = 25, RULE_functionValueParameter = 26, 
		RULE_functionBody = 27, RULE_propertyDeclaration = 28, RULE_variableDeclaration = 29, 
		RULE_getter = 30, RULE_setter = 31, RULE_parametersWithOptionalType = 32, 
		RULE_functionValueParameterWithOptionalType = 33, RULE_parameterWithOptionalType = 34, 
		RULE_parameter = 35, RULE_enumClassBody = 36, RULE_enumEntries = 37, RULE_enumEntry = 38, 
		RULE_type = 39, RULE_nullableType = 40, RULE_quest = 41, RULE_userType = 42, 
		RULE_simpleUserType = 43, RULE_typeProjection = 44, RULE_typeProjectionModifiers = 45, 
		RULE_typeProjectionModifier = 46, RULE_functionType = 47, RULE_functionTypeParameters = 48, 
		RULE_parenthesizedType = 49, RULE_receiverType = 50, RULE_parenthesizedUserType = 51, 
		RULE_statements = 52, RULE_statement = 53, RULE_blockLevelExpression = 54, 
		RULE_blockLevelDeclaration = 55, RULE_label = 56, RULE_assignment = 57, 
		RULE_loopStatement = 58, RULE_forStatement = 59, RULE_whileStatement = 60, 
		RULE_controlStructureBody = 61, RULE_block = 62, RULE_expression = 63, 
		RULE_disjunction = 64, RULE_conjunction = 65, RULE_equality = 66, RULE_comparison = 67, 
		RULE_genericCallLikeComparison = 68, RULE_isExpression = 69, RULE_elvisExpression = 70, 
		RULE_elvis = 71, RULE_additiveExpression = 72, RULE_multiplicativeExpression = 73, 
		RULE_typeRHS = 74, RULE_prefixUnaryExpression = 75, RULE_unaryPrefix = 76, 
		RULE_postfixUnaryExpression = 77, RULE_atomicExpression = 78, RULE_parenthesizedExpression = 79, 
		RULE_collectionLiteral = 80, RULE_literalConstant = 81, RULE_stringLiteral = 82, 
		RULE_lineStringLiteral = 83, RULE_multiLineStringLiteral = 84, RULE_lineStringContent = 85, 
		RULE_lineStringExpression = 86, RULE_multiLineStringContent = 87, RULE_multiLineStringExpression = 88, 
		RULE_lambdaLiteral = 89, RULE_lambdaParameters = 90, RULE_anonymousFunction = 91, 
		RULE_functionLiteral = 92, RULE_thisExpression = 93, RULE_superExpression = 94, 
		RULE_ifExpression = 95, RULE_whenSubject = 96, RULE_whenExpression = 97, 
		RULE_whenEntry = 98, RULE_whenCondition = 99, RULE_typeTest = 100, RULE_tryExpression = 101, 
		RULE_catchBlock = 102, RULE_finallyBlock = 103, RULE_jumpExpression = 104, 
		RULE_callableReference = 105, RULE_postfixUnarySuffix = 106, RULE_directlyAssignableExpression = 107, 
		RULE_parenthesizedDirectlyAssignableExpression = 108, RULE_assignableExpression = 109, 
		RULE_parenthesizedAssignableExpression = 110, RULE_assignableSuffix = 111, 
		RULE_indexingSuffix = 112, RULE_navigationSuffix = 113, RULE_callSuffix = 114, 
		RULE_annotatedLambda = 115, RULE_typeArguments = 116, RULE_valueArguments = 117, 
		RULE_valueArgument = 118, RULE_assignmentAndOperator = 119, RULE_equalityOperator = 120, 
		RULE_comparisonOperator = 121, RULE_isOperator = 122, RULE_additiveOperator = 123, 
		RULE_multiplicativeOperator = 124, RULE_typeOperation = 125, RULE_prefixUnaryOperator = 126, 
		RULE_postfixUnaryOperator = 127, RULE_excl = 128, RULE_memberAccessOperator = 129, 
		RULE_safeNav = 130, RULE_modifiers = 131, RULE_parameterModifiers = 132, 
		RULE_modifier = 133, RULE_classModifier = 134, RULE_memberModifier = 135, 
		RULE_visibilityModifier = 136, RULE_varianceModifier = 137, RULE_typeParameterModifiers = 138, 
		RULE_typeParameterModifier = 139, RULE_inheritanceModifier = 140, RULE_annotation = 141, 
		RULE_singleAnnotation = 142, RULE_multiAnnotations = 143, RULE_annotationUseSiteTarget = 144, 
		RULE_unescapedAnnotation = 145, RULE_simpleIdentifier = 146, RULE_identifier = 147, 
		RULE_semi = 148, RULE_anysemi = 149;
	private static String[] makeRuleNames() {
		return new String[] {
			"oolangFile", "packageHeader", "importList", "importHeader", "importAlias", 
			"declaration", "classDeclaration", "primaryConstructor", "classParameters", 
			"classParameter", "delegationSpecifiers", "annotatedDelegationSpecifier", 
			"delegationSpecifier", "constructorInvocation", "explicitDelegation", 
			"classBody", "typeParameters", "typeParameter", "typeConstraints", "typeConstraint", 
			"classMemberDeclaration", "anonymousInitializer", "secondaryConstructor", 
			"constructorDelegationCall", "functionDeclaration", "functionValueParameters", 
			"functionValueParameter", "functionBody", "propertyDeclaration", "variableDeclaration", 
			"getter", "setter", "parametersWithOptionalType", "functionValueParameterWithOptionalType", 
			"parameterWithOptionalType", "parameter", "enumClassBody", "enumEntries", 
			"enumEntry", "type", "nullableType", "quest", "userType", "simpleUserType", 
			"typeProjection", "typeProjectionModifiers", "typeProjectionModifier", 
			"functionType", "functionTypeParameters", "parenthesizedType", "receiverType", 
			"parenthesizedUserType", "statements", "statement", "blockLevelExpression", 
			"blockLevelDeclaration", "label", "assignment", "loopStatement", "forStatement", 
			"whileStatement", "controlStructureBody", "block", "expression", "disjunction", 
			"conjunction", "equality", "comparison", "genericCallLikeComparison", 
			"isExpression", "elvisExpression", "elvis", "additiveExpression", "multiplicativeExpression", 
			"typeRHS", "prefixUnaryExpression", "unaryPrefix", "postfixUnaryExpression", 
			"atomicExpression", "parenthesizedExpression", "collectionLiteral", "literalConstant", 
			"stringLiteral", "lineStringLiteral", "multiLineStringLiteral", "lineStringContent", 
			"lineStringExpression", "multiLineStringContent", "multiLineStringExpression", 
			"lambdaLiteral", "lambdaParameters", "anonymousFunction", "functionLiteral", 
			"thisExpression", "superExpression", "ifExpression", "whenSubject", "whenExpression", 
			"whenEntry", "whenCondition", "typeTest", "tryExpression", "catchBlock", 
			"finallyBlock", "jumpExpression", "callableReference", "postfixUnarySuffix", 
			"directlyAssignableExpression", "parenthesizedDirectlyAssignableExpression", 
			"assignableExpression", "parenthesizedAssignableExpression", "assignableSuffix", 
			"indexingSuffix", "navigationSuffix", "callSuffix", "annotatedLambda", 
			"typeArguments", "valueArguments", "valueArgument", "assignmentAndOperator", 
			"equalityOperator", "comparisonOperator", "isOperator", "additiveOperator", 
			"multiplicativeOperator", "typeOperation", "prefixUnaryOperator", "postfixUnaryOperator", 
			"excl", "memberAccessOperator", "safeNav", "modifiers", "parameterModifiers", 
			"modifier", "classModifier", "memberModifier", "visibilityModifier", 
			"varianceModifier", "typeParameterModifiers", "typeParameterModifier", 
			"inheritanceModifier", "annotation", "singleAnnotation", "multiAnnotations", 
			"annotationUseSiteTarget", "unescapedAnnotation", "simpleIdentifier", 
			"identifier", "semi", "anysemi"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, null, "'...'", "'.'", "','", "'('", "')'", "'['", 
			"']'", "'{'", "'}'", "'*'", "'%'", "'/'", "'+'", "'-'", "'++'", "'--'", 
			"'&&'", "'||'", null, "'!'", "':'", "';'", "'='", "'+='", "'-='", "'*='", 
			"'/='", "'%='", "'->'", "'::'", "'@'", null, null, null, null, "'?'", 
			null, "'?:'", "'<'", "'>'", "'<='", "'>='", "'!='", "'!=='", "'as?'", 
			"'=='", "'==='", "'''", "'&'", "'|'", "'package'", "'import'", "'class'", 
			"'interface'", "'fun'", "'val'", "'var'", "'constructor'", "'by'", "'init'", 
			"'this'", "'super'", "'typeof'", "'where'", "'if'", "'else'", "'when'", 
			"'try'", "'catch'", "'finally'", "'for'", "'while'", "'throw'", "'return'", 
			"'continue'", "'yield'", "'as'", "'is'", null, "'in'", "'out'", "'@field'", 
			"'field'", "'@property'", "'@get'", "'@set'", "'get'", "'set'", "'@param'", 
			"'@setparam'", "'@delegate'", "'public'", "'private'", "'protected'", 
			"'enum'", "'sealed'", "'value'", "'record'", "'inner'", "'annotation'", 
			"'override'", "'abstract'", "'final'", "'open'", "'static'", "'vararg'", 
			null, null, null, null, null, null, null, null, "'null'", null, null, 
			null, null, "'\"\"\"'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "DelimitedComment", "LineComment", "WS", "NL", "RESERVED", "DOT", 
			"COMMA", "LPAREN", "RPAREN", "LSQUARE", "RSQUARE", "LCURL", "RCURL", 
			"MULT", "MOD", "DIV", "ADD", "SUB", "INCR", "DECR", "CONJ", "DISJ", "EXCL_WS", 
			"EXCL_NO_WS", "COLON", "SEMICOLON", "ASSIGNMENT", "ADD_ASSIGNMENT", "SUB_ASSIGNMENT", 
			"MULT_ASSIGNMENT", "DIV_ASSIGNMENT", "MOD_ASSIGNMENT", "ARROW", "COLONCOLON", 
			"AT_NO_WS", "AT_POST_WS", "AT_PRE_WS", "AT_BOTH_WS", "QUEST_WS", "QUEST_NO_WS", 
			"ELVIS_WS", "ELVIS_NO_WS", "LANGLE", "RANGLE", "LE", "GE", "EXCL_EQ", 
			"EXCL_EQEQ", "AS_SAFE", "EQEQ", "EQEQEQ", "SINGLE_QUOTE", "AND", "OR", 
			"PACKAGE", "IMPORT", "CLASS", "INTERFACE", "FUN", "VAL", "VAR", "CONSTRUCTOR", 
			"BY", "INIT", "THIS", "SUPER", "TYPEOF", "WHERE", "IF", "ELSE", "WHEN", 
			"TRY", "CATCH", "FINALLY", "FOR", "WHILE", "THROW", "RETURN", "CONTINUE", 
			"YIELD", "AS", "IS", "NOT_IS", "IN", "OUT", "FIELD_SITE", "FIELD", "PROPERTY_SITE", 
			"GET_SITE", "SET_SITE", "GET", "SET", "PARAM_SITE", "SETPARAM_SITE", 
			"DELEGATE_SITE", "PUBLIC", "PRIVATE", "PROTECTED", "ENUM", "SEALED", 
			"VALUE", "RECORD", "INNER", "ANNOTATION", "OVERRIDE", "ABSTRACT", "FINAL", 
			"OPEN", "STATIC", "VARARG", "RealLiteral", "FloatLiteral", "DoubleLiteral", 
			"IntegerLiteral", "HexLiteral", "BinLiteral", "LongLiteral", "BooleanLiteral", 
			"NullLiteral", "CharacterLiteral", "Identifier", "FieldIdentifier", "QUOTE_OPEN", 
			"TRIPLE_QUOTE_OPEN", "UNICODE_CLASS_LL", "UNICODE_CLASS_LM", "UNICODE_CLASS_LO", 
			"UNICODE_CLASS_LT", "UNICODE_CLASS_LU", "UNICODE_CLASS_ND", "UNICODE_CLASS_NL", 
			"QUOTE_CLOSE", "LineStrRef", "LineStrText", "LineStrEscapedChar", "LineStrExprStart", 
			"TRIPLE_QUOTE_CLOSE", "MultiLineStringQuote", "MultiLineStrRef", "MultiLineStrText", 
			"MultiLineStrEscapedChar", "MultiLineStrExprStart", "MultiLineNL", "Inside_Comment", 
			"Inside_WS", "Inside_NL", "ErrorCharacter"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "OolangParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public OolangParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class OolangFileContext extends ParserRuleContext {
		public ImportListContext importList() {
			return getRuleContext(ImportListContext.class,0);
		}
		public List<ClassDeclarationContext> classDeclaration() {
			return getRuleContexts(ClassDeclarationContext.class);
		}
		public ClassDeclarationContext classDeclaration(int i) {
			return getRuleContext(ClassDeclarationContext.class,i);
		}
		public TerminalNode EOF() { return getToken(OolangParser.EOF, 0); }
		public PackageHeaderContext packageHeader() {
			return getRuleContext(PackageHeaderContext.class,0);
		}
		public List<AnysemiContext> anysemi() {
			return getRuleContexts(AnysemiContext.class);
		}
		public AnysemiContext anysemi(int i) {
			return getRuleContext(AnysemiContext.class,i);
		}
		public OolangFileContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_oolangFile; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitOolangFile(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OolangFileContext oolangFile() throws RecognitionException {
		OolangFileContext _localctx = new OolangFileContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_oolangFile);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(301);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==PACKAGE) {
				{
				setState(300);
				packageHeader();
				}
			}

			setState(303);
			importList();
			setState(307);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL || _la==SEMICOLON) {
				{
				{
				setState(304);
				anysemi();
				}
				}
				setState(309);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(310);
			classDeclaration();
			setState(321);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL || _la==SEMICOLON) {
				{
				{
				setState(312); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(311);
						anysemi();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(314); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(317);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 1008806488329682944L) != 0) || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
					{
					setState(316);
					classDeclaration();
					}
				}

				}
				}
				setState(323);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(324);
			match(EOF);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PackageHeaderContext extends ParserRuleContext {
		public TerminalNode PACKAGE() { return getToken(OolangParser.PACKAGE, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public PackageHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_packageHeader; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPackageHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PackageHeaderContext packageHeader() throws RecognitionException {
		PackageHeaderContext _localctx = new PackageHeaderContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_packageHeader);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(326);
			match(PACKAGE);
			setState(327);
			identifier();
			setState(329);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(328);
				semi();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportListContext extends ParserRuleContext {
		public List<ImportHeaderContext> importHeader() {
			return getRuleContexts(ImportHeaderContext.class);
		}
		public ImportHeaderContext importHeader(int i) {
			return getRuleContext(ImportHeaderContext.class,i);
		}
		public ImportListContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importList; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitImportList(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportListContext importList() throws RecognitionException {
		ImportListContext _localctx = new ImportListContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_importList);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(334);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==IMPORT) {
				{
				{
				setState(331);
				importHeader();
				}
				}
				setState(336);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportHeaderContext extends ParserRuleContext {
		public TerminalNode IMPORT() { return getToken(OolangParser.IMPORT, 0); }
		public IdentifierContext identifier() {
			return getRuleContext(IdentifierContext.class,0);
		}
		public ImportAliasContext importAlias() {
			return getRuleContext(ImportAliasContext.class,0);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public ImportHeaderContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importHeader; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitImportHeader(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportHeaderContext importHeader() throws RecognitionException {
		ImportHeaderContext _localctx = new ImportHeaderContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_importHeader);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(337);
			match(IMPORT);
			setState(338);
			identifier();
			setState(340);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AS) {
				{
				setState(339);
				importAlias();
				}
			}

			setState(343);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
			case 1:
				{
				setState(342);
				semi();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ImportAliasContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(OolangParser.AS, 0); }
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public ImportAliasContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_importAlias; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitImportAlias(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImportAliasContext importAlias() throws RecognitionException {
		ImportAliasContext _localctx = new ImportAliasContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_importAlias);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(345);
			match(AS);
			setState(346);
			simpleIdentifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DeclarationContext extends ParserRuleContext {
		public ClassDeclarationContext classDeclaration() {
			return getRuleContext(ClassDeclarationContext.class,0);
		}
		public FunctionDeclarationContext functionDeclaration() {
			return getRuleContext(FunctionDeclarationContext.class,0);
		}
		public PropertyDeclarationContext propertyDeclaration() {
			return getRuleContext(PropertyDeclarationContext.class,0);
		}
		public DeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_declaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DeclarationContext declaration() throws RecognitionException {
		DeclarationContext _localctx = new DeclarationContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_declaration);
		try {
			setState(351);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,9,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(348);
				classDeclaration();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(349);
				functionDeclaration();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(350);
				propertyDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassDeclarationContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(OolangParser.CLASS, 0); }
		public TerminalNode INTERFACE() { return getToken(OolangParser.INTERFACE, 0); }
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public PrimaryConstructorContext primaryConstructor() {
			return getRuleContext(PrimaryConstructorContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public DelegationSpecifiersContext delegationSpecifiers() {
			return getRuleContext(DelegationSpecifiersContext.class,0);
		}
		public TypeConstraintsContext typeConstraints() {
			return getRuleContext(TypeConstraintsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public EnumClassBodyContext enumClassBody() {
			return getRuleContext(EnumClassBodyContext.class,0);
		}
		public TerminalNode FUN() { return getToken(OolangParser.FUN, 0); }
		public ClassDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitClassDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassDeclarationContext classDeclaration() throws RecognitionException {
		ClassDeclarationContext _localctx = new ClassDeclarationContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_classDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(354);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(353);
				modifiers();
				}
			}

			setState(367);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CLASS:
				{
				setState(356);
				match(CLASS);
				}
				break;
			case INTERFACE:
			case FUN:
				{
				setState(364);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==FUN) {
					{
					setState(357);
					match(FUN);
					setState(361);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(358);
						match(NL);
						}
						}
						setState(363);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					}
				}

				setState(366);
				match(INTERFACE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(372);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(369);
				match(NL);
				}
				}
				setState(374);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(375);
			simpleIdentifier();
			setState(383);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				{
				setState(379);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(376);
					match(NL);
					}
					}
					setState(381);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(382);
				typeParameters();
				}
				break;
			}
			setState(392);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
			case 1:
				{
				setState(388);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(385);
					match(NL);
					}
					}
					setState(390);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(391);
				primaryConstructor();
				}
				break;
			}
			setState(408);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
			case 1:
				{
				setState(397);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(394);
					match(NL);
					}
					}
					setState(399);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(400);
				match(COLON);
				setState(404);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(401);
						match(NL);
						}
						} 
					}
					setState(406);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,20,_ctx);
				}
				setState(407);
				delegationSpecifiers();
				}
				break;
			}
			setState(417);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				setState(413);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(410);
					match(NL);
					}
					}
					setState(415);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(416);
				typeConstraints();
				}
				break;
			}
			setState(433);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
			case 1:
				{
				setState(422);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(419);
					match(NL);
					}
					}
					setState(424);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(425);
				classBody();
				}
				break;
			case 2:
				{
				setState(429);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(426);
					match(NL);
					}
					}
					setState(431);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(432);
				enumClassBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrimaryConstructorContext extends ParserRuleContext {
		public ClassParametersContext classParameters() {
			return getRuleContext(ClassParametersContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode CONSTRUCTOR() { return getToken(OolangParser.CONSTRUCTOR, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public PrimaryConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_primaryConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPrimaryConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrimaryConstructorContext primaryConstructor() throws RecognitionException {
		PrimaryConstructorContext _localctx = new PrimaryConstructorContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_primaryConstructor);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(436);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(435);
				modifiers();
				}
			}

			setState(445);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==CONSTRUCTOR) {
				{
				setState(438);
				match(CONSTRUCTOR);
				setState(442);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(439);
					match(NL);
					}
					}
					setState(444);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(447);
			classParameters();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<ClassParameterContext> classParameter() {
			return getRuleContexts(ClassParameterContext.class);
		}
		public ClassParameterContext classParameter(int i) {
			return getRuleContext(ClassParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public ClassParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitClassParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParametersContext classParameters() throws RecognitionException {
		ClassParametersContext _localctx = new ClassParametersContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_classParameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(449);
			match(LPAREN);
			setState(453);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(450);
					match(NL);
					}
					} 
				}
				setState(455);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,30,_ctx);
			}
			setState(485);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,36,_ctx) ) {
			case 1:
				{
				setState(456);
				classParameter();
				setState(473);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(460);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(457);
							match(NL);
							}
							}
							setState(462);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(463);
						match(COMMA);
						setState(467);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(464);
								match(NL);
								}
								} 
							}
							setState(469);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,32,_ctx);
						}
						setState(470);
						classParameter();
						}
						} 
					}
					setState(475);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,33,_ctx);
				}
				setState(483);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,35,_ctx) ) {
				case 1:
					{
					setState(479);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(476);
						match(NL);
						}
						}
						setState(481);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(482);
					match(COMMA);
					}
					break;
				}
				}
				break;
			}
			setState(490);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(487);
				match(NL);
				}
				}
				setState(492);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(493);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassParameterContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode VAL() { return getToken(OolangParser.VAL, 0); }
		public TerminalNode VAR() { return getToken(OolangParser.VAR, 0); }
		public ClassParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitClassParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassParameterContext classParameter() throws RecognitionException {
		ClassParameterContext _localctx = new ClassParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_classParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(496);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,38,_ctx) ) {
			case 1:
				{
				setState(495);
				modifiers();
				}
				break;
			}
			setState(499);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==VAL || _la==VAR) {
				{
				setState(498);
				_la = _input.LA(1);
				if ( !(_la==VAL || _la==VAR) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
			}

			setState(504);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(501);
				match(NL);
				}
				}
				setState(506);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(507);
			simpleIdentifier();
			setState(508);
			match(COLON);
			setState(512);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(509);
				match(NL);
				}
				}
				setState(514);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(515);
			type();
			setState(530);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,44,_ctx) ) {
			case 1:
				{
				setState(519);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(516);
					match(NL);
					}
					}
					setState(521);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(522);
				match(ASSIGNMENT);
				setState(526);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(523);
					match(NL);
					}
					}
					setState(528);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(529);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DelegationSpecifiersContext extends ParserRuleContext {
		public List<AnnotatedDelegationSpecifierContext> annotatedDelegationSpecifier() {
			return getRuleContexts(AnnotatedDelegationSpecifierContext.class);
		}
		public AnnotatedDelegationSpecifierContext annotatedDelegationSpecifier(int i) {
			return getRuleContext(AnnotatedDelegationSpecifierContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public DelegationSpecifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegationSpecifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitDelegationSpecifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelegationSpecifiersContext delegationSpecifiers() throws RecognitionException {
		DelegationSpecifiersContext _localctx = new DelegationSpecifiersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_delegationSpecifiers);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(532);
			annotatedDelegationSpecifier();
			setState(549);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(536);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(533);
						match(NL);
						}
						}
						setState(538);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(539);
					match(COMMA);
					setState(543);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(540);
							match(NL);
							}
							} 
						}
						setState(545);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,46,_ctx);
					}
					setState(546);
					annotatedDelegationSpecifier();
					}
					} 
				}
				setState(551);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,47,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotatedDelegationSpecifierContext extends ParserRuleContext {
		public DelegationSpecifierContext delegationSpecifier() {
			return getRuleContext(DelegationSpecifierContext.class,0);
		}
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public AnnotatedDelegationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedDelegationSpecifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnnotatedDelegationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotatedDelegationSpecifierContext annotatedDelegationSpecifier() throws RecognitionException {
		AnnotatedDelegationSpecifierContext _localctx = new AnnotatedDelegationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_annotatedDelegationSpecifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(555);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(552);
					singleAnnotation();
					}
					} 
				}
				setState(557);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,48,_ctx);
			}
			setState(561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(558);
				match(NL);
				}
				}
				setState(563);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(564);
			delegationSpecifier();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DelegationSpecifierContext extends ParserRuleContext {
		public ConstructorInvocationContext constructorInvocation() {
			return getRuleContext(ConstructorInvocationContext.class,0);
		}
		public ExplicitDelegationContext explicitDelegation() {
			return getRuleContext(ExplicitDelegationContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public DelegationSpecifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_delegationSpecifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitDelegationSpecifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DelegationSpecifierContext delegationSpecifier() throws RecognitionException {
		DelegationSpecifierContext _localctx = new DelegationSpecifierContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_delegationSpecifier);
		try {
			setState(570);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,50,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(566);
				constructorInvocation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(567);
				explicitDelegation();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(568);
				userType();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(569);
				functionType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorInvocationContext extends ParserRuleContext {
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public CallSuffixContext callSuffix() {
			return getRuleContext(CallSuffixContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ConstructorInvocationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorInvocation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitConstructorInvocation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorInvocationContext constructorInvocation() throws RecognitionException {
		ConstructorInvocationContext _localctx = new ConstructorInvocationContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_constructorInvocation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(572);
			userType();
			setState(576);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(573);
					match(NL);
					}
					} 
				}
				setState(578);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,51,_ctx);
			}
			setState(579);
			callSuffix();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExplicitDelegationContext extends ParserRuleContext {
		public TerminalNode BY() { return getToken(OolangParser.BY, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ExplicitDelegationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_explicitDelegation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitExplicitDelegation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExplicitDelegationContext explicitDelegation() throws RecognitionException {
		ExplicitDelegationContext _localctx = new ExplicitDelegationContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_explicitDelegation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(583);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,52,_ctx) ) {
			case 1:
				{
				setState(581);
				userType();
				}
				break;
			case 2:
				{
				setState(582);
				functionType();
				}
				break;
			}
			setState(588);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(585);
				match(NL);
				}
				}
				setState(590);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(591);
			match(BY);
			setState(595);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(592);
				match(NL);
				}
				}
				setState(597);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(598);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassBodyContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(OolangParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<ClassMemberDeclarationContext> classMemberDeclaration() {
			return getRuleContexts(ClassMemberDeclarationContext.class);
		}
		public ClassMemberDeclarationContext classMemberDeclaration(int i) {
			return getRuleContext(ClassMemberDeclarationContext.class,i);
		}
		public ClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassBodyContext classBody() throws RecognitionException {
		ClassBodyContext _localctx = new ClassBodyContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_classBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(600);
			match(LCURL);
			setState(604);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(601);
					match(NL);
					}
					} 
				}
				setState(606);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,55,_ctx);
			}
			setState(610);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9079257020577611776L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 140737073119233L) != 0)) {
				{
				{
				setState(607);
				classMemberDeclaration();
				}
				}
				setState(612);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(616);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(613);
				match(NL);
				}
				}
				setState(618);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(619);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParametersContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(OolangParser.LANGLE, 0); }
		public List<TypeParameterContext> typeParameter() {
			return getRuleContexts(TypeParameterContext.class);
		}
		public TypeParameterContext typeParameter(int i) {
			return getRuleContext(TypeParameterContext.class,i);
		}
		public TerminalNode RANGLE() { return getToken(OolangParser.RANGLE, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public TypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParametersContext typeParameters() throws RecognitionException {
		TypeParametersContext _localctx = new TypeParametersContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_typeParameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(621);
			match(LANGLE);
			setState(625);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(622);
					match(NL);
					}
					} 
				}
				setState(627);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,58,_ctx);
			}
			setState(628);
			typeParameter();
			setState(645);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(632);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(629);
						match(NL);
						}
						}
						setState(634);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(635);
					match(COMMA);
					setState(639);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(636);
							match(NL);
							}
							} 
						}
						setState(641);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,60,_ctx);
					}
					setState(642);
					typeParameter();
					}
					} 
				}
				setState(647);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,61,_ctx);
			}
			setState(655);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,63,_ctx) ) {
			case 1:
				{
				setState(651);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(648);
					match(NL);
					}
					}
					setState(653);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(654);
				match(COMMA);
				}
				break;
			}
			setState(660);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(657);
				match(NL);
				}
				}
				setState(662);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(663);
			match(RANGLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode MULT() { return getToken(OolangParser.MULT, 0); }
		public TypeParameterModifiersContext typeParameterModifiers() {
			return getRuleContext(TypeParameterModifiersContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterContext typeParameter() throws RecognitionException {
		TypeParameterContext _localctx = new TypeParameterContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_typeParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(666);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,65,_ctx) ) {
			case 1:
				{
				setState(665);
				typeParameterModifiers();
				}
				break;
			}
			setState(671);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(668);
				match(NL);
				}
				}
				setState(673);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(676);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case OUT:
			case FIELD:
			case GET:
			case SET:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				{
				setState(674);
				simpleIdentifier();
				}
				break;
			case MULT:
				{
				setState(675);
				match(MULT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(692);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,70,_ctx) ) {
			case 1:
				{
				setState(681);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(678);
					match(NL);
					}
					}
					setState(683);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(684);
				match(COLON);
				setState(688);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(685);
					match(NL);
					}
					}
					setState(690);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(691);
				type();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeConstraintsContext extends ParserRuleContext {
		public TerminalNode WHERE() { return getToken(OolangParser.WHERE, 0); }
		public List<TypeConstraintContext> typeConstraint() {
			return getRuleContexts(TypeConstraintContext.class);
		}
		public TypeConstraintContext typeConstraint(int i) {
			return getRuleContext(TypeConstraintContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public TypeConstraintsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeConstraints; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeConstraints(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeConstraintsContext typeConstraints() throws RecognitionException {
		TypeConstraintsContext _localctx = new TypeConstraintsContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeConstraints);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(694);
			match(WHERE);
			setState(698);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(695);
				match(NL);
				}
				}
				setState(700);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(701);
			typeConstraint();
			setState(718);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(705);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(702);
						match(NL);
						}
						}
						setState(707);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(708);
					match(COMMA);
					setState(712);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(709);
						match(NL);
						}
						}
						setState(714);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(715);
					typeConstraint();
					}
					} 
				}
				setState(720);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,74,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeConstraintContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TypeConstraintContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeConstraint; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeConstraint(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeConstraintContext typeConstraint() throws RecognitionException {
		TypeConstraintContext _localctx = new TypeConstraintContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_typeConstraint);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(724);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				{
				setState(721);
				singleAnnotation();
				}
				}
				setState(726);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(727);
			simpleIdentifier();
			setState(731);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(728);
				match(NL);
				}
				}
				setState(733);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(734);
			match(COLON);
			setState(738);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(735);
				match(NL);
				}
				}
				setState(740);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(741);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassMemberDeclarationContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AnonymousInitializerContext anonymousInitializer() {
			return getRuleContext(AnonymousInitializerContext.class,0);
		}
		public SecondaryConstructorContext secondaryConstructor() {
			return getRuleContext(SecondaryConstructorContext.class,0);
		}
		public List<AnysemiContext> anysemi() {
			return getRuleContexts(AnysemiContext.class);
		}
		public AnysemiContext anysemi(int i) {
			return getRuleContext(AnysemiContext.class,i);
		}
		public ClassMemberDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classMemberDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitClassMemberDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassMemberDeclarationContext classMemberDeclaration() throws RecognitionException {
		ClassMemberDeclarationContext _localctx = new ClassMemberDeclarationContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_classMemberDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(746);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,78,_ctx) ) {
			case 1:
				{
				setState(743);
				declaration();
				}
				break;
			case 2:
				{
				setState(744);
				anonymousInitializer();
				}
				break;
			case 3:
				{
				setState(745);
				secondaryConstructor();
				}
				break;
			}
			setState(749); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(748);
					anysemi();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(751); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,79,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousInitializerContext extends ParserRuleContext {
		public TerminalNode INIT() { return getToken(OolangParser.INIT, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public AnonymousInitializerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousInitializer; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnonymousInitializer(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousInitializerContext anonymousInitializer() throws RecognitionException {
		AnonymousInitializerContext _localctx = new AnonymousInitializerContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_anonymousInitializer);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(753);
			match(INIT);
			setState(757);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(754);
				match(NL);
				}
				}
				setState(759);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(760);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SecondaryConstructorContext extends ParserRuleContext {
		public TerminalNode CONSTRUCTOR() { return getToken(OolangParser.CONSTRUCTOR, 0); }
		public FunctionValueParametersContext functionValueParameters() {
			return getRuleContext(FunctionValueParametersContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public ConstructorDelegationCallContext constructorDelegationCall() {
			return getRuleContext(ConstructorDelegationCallContext.class,0);
		}
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public SecondaryConstructorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_secondaryConstructor; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSecondaryConstructor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SecondaryConstructorContext secondaryConstructor() throws RecognitionException {
		SecondaryConstructorContext _localctx = new SecondaryConstructorContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_secondaryConstructor);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(763);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(762);
				modifiers();
				}
			}

			setState(765);
			match(CONSTRUCTOR);
			setState(769);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(766);
				match(NL);
				}
				}
				setState(771);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(772);
			functionValueParameters();
			setState(787);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,85,_ctx) ) {
			case 1:
				{
				setState(776);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(773);
					match(NL);
					}
					}
					setState(778);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(779);
				match(COLON);
				setState(783);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(780);
					match(NL);
					}
					}
					setState(785);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(786);
				constructorDelegationCall();
				}
				break;
			}
			setState(792);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(789);
					match(NL);
					}
					} 
				}
				setState(794);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,86,_ctx);
			}
			setState(796);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LCURL) {
				{
				setState(795);
				block();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConstructorDelegationCallContext extends ParserRuleContext {
		public ValueArgumentsContext valueArguments() {
			return getRuleContext(ValueArgumentsContext.class,0);
		}
		public TerminalNode THIS() { return getToken(OolangParser.THIS, 0); }
		public TerminalNode SUPER() { return getToken(OolangParser.SUPER, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ConstructorDelegationCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_constructorDelegationCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitConstructorDelegationCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConstructorDelegationCallContext constructorDelegationCall() throws RecognitionException {
		ConstructorDelegationCallContext _localctx = new ConstructorDelegationCallContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_constructorDelegationCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(798);
			_la = _input.LA(1);
			if ( !(_la==THIS || _la==SUPER) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(802);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(799);
				match(NL);
				}
				}
				setState(804);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(805);
			valueArguments();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionDeclarationContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(OolangParser.FUN, 0); }
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public FunctionValueParametersContext functionValueParameters() {
			return getRuleContext(FunctionValueParametersContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ReceiverTypeContext receiverType() {
			return getRuleContext(ReceiverTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(OolangParser.DOT, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeConstraintsContext typeConstraints() {
			return getRuleContext(TypeConstraintsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public FunctionDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDeclarationContext functionDeclaration() throws RecognitionException {
		FunctionDeclarationContext _localctx = new FunctionDeclarationContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_functionDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(808);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(807);
				modifiers();
				}
			}

			setState(810);
			match(FUN);
			setState(818);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,91,_ctx) ) {
			case 1:
				{
				setState(814);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(811);
					match(NL);
					}
					}
					setState(816);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(817);
				typeParameters();
				}
				break;
			}
			setState(835);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,94,_ctx) ) {
			case 1:
				{
				setState(823);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(820);
					match(NL);
					}
					}
					setState(825);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(826);
				receiverType();
				setState(830);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(827);
					match(NL);
					}
					}
					setState(832);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(833);
				match(DOT);
				}
				break;
			}
			setState(840);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(837);
				match(NL);
				}
				}
				setState(842);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(843);
			simpleIdentifier();
			setState(847);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(844);
				match(NL);
				}
				}
				setState(849);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(850);
			functionValueParameters();
			setState(865);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,99,_ctx) ) {
			case 1:
				{
				setState(854);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(851);
					match(NL);
					}
					}
					setState(856);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(857);
				match(COLON);
				setState(861);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(858);
					match(NL);
					}
					}
					setState(863);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(864);
				type();
				}
				break;
			}
			setState(874);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,101,_ctx) ) {
			case 1:
				{
				setState(870);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(867);
					match(NL);
					}
					}
					setState(872);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(873);
				typeConstraints();
				}
				break;
			}
			setState(883);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,103,_ctx) ) {
			case 1:
				{
				setState(879);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(876);
					match(NL);
					}
					}
					setState(881);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(882);
				functionBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionValueParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<FunctionValueParameterContext> functionValueParameter() {
			return getRuleContexts(FunctionValueParameterContext.class);
		}
		public FunctionValueParameterContext functionValueParameter(int i) {
			return getRuleContext(FunctionValueParameterContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public FunctionValueParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionValueParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionValueParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionValueParametersContext functionValueParameters() throws RecognitionException {
		FunctionValueParametersContext _localctx = new FunctionValueParametersContext(_ctx, getState());
		enterRule(_localctx, 50, RULE_functionValueParameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(885);
			match(LPAREN);
			setState(889);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(886);
					match(NL);
					}
					} 
				}
				setState(891);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,104,_ctx);
			}
			setState(921);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628252590768128L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255788123162129L) != 0)) {
				{
				setState(892);
				functionValueParameter();
				setState(909);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(896);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(893);
							match(NL);
							}
							}
							setState(898);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(899);
						match(COMMA);
						setState(903);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(900);
							match(NL);
							}
							}
							setState(905);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(906);
						functionValueParameter();
						}
						} 
					}
					setState(911);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,107,_ctx);
				}
				setState(919);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,109,_ctx) ) {
				case 1:
					{
					setState(915);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(912);
						match(NL);
						}
						}
						setState(917);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(918);
					match(COMMA);
					}
					break;
				}
				}
			}

			setState(926);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(923);
				match(NL);
				}
				}
				setState(928);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(929);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionValueParameterContext extends ParserRuleContext {
		public ParameterContext parameter() {
			return getRuleContext(ParameterContext.class,0);
		}
		public ParameterModifiersContext parameterModifiers() {
			return getRuleContext(ParameterModifiersContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public FunctionValueParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionValueParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionValueParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionValueParameterContext functionValueParameter() throws RecognitionException {
		FunctionValueParameterContext _localctx = new FunctionValueParameterContext(_ctx, getState());
		enterRule(_localctx, 52, RULE_functionValueParameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(932);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				setState(931);
				parameterModifiers();
				}
			}

			setState(934);
			parameter();
			setState(949);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,115,_ctx) ) {
			case 1:
				{
				setState(938);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(935);
					match(NL);
					}
					}
					setState(940);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(941);
				match(ASSIGNMENT);
				setState(945);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(942);
					match(NL);
					}
					}
					setState(947);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(948);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public FunctionBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionBodyContext functionBody() throws RecognitionException {
		FunctionBodyContext _localctx = new FunctionBodyContext(_ctx, getState());
		enterRule(_localctx, 54, RULE_functionBody);
		int _la;
		try {
			setState(960);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LCURL:
				enterOuterAlt(_localctx, 1);
				{
				setState(951);
				block();
				}
				break;
			case ASSIGNMENT:
				enterOuterAlt(_localctx, 2);
				{
				setState(952);
				match(ASSIGNMENT);
				setState(956);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(953);
					match(NL);
					}
					}
					setState(958);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(959);
				expression();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PropertyDeclarationContext extends ParserRuleContext {
		public TerminalNode VAL() { return getToken(OolangParser.VAL, 0); }
		public TerminalNode VAR() { return getToken(OolangParser.VAR, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TypeParametersContext typeParameters() {
			return getRuleContext(TypeParametersContext.class,0);
		}
		public ReceiverTypeContext receiverType() {
			return getRuleContext(ReceiverTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(OolangParser.DOT, 0); }
		public TypeConstraintsContext typeConstraints() {
			return getRuleContext(TypeConstraintsContext.class,0);
		}
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(OolangParser.SEMICOLON, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public GetterContext getter() {
			return getRuleContext(GetterContext.class,0);
		}
		public SetterContext setter() {
			return getRuleContext(SetterContext.class,0);
		}
		public TerminalNode BY() { return getToken(OolangParser.BY, 0); }
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public PropertyDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_propertyDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPropertyDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PropertyDeclarationContext propertyDeclaration() throws RecognitionException {
		PropertyDeclarationContext _localctx = new PropertyDeclarationContext(_ctx, getState());
		enterRule(_localctx, 56, RULE_propertyDeclaration);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(963);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(962);
				modifiers();
				}
			}

			setState(965);
			_la = _input.LA(1);
			if ( !(_la==VAL || _la==VAR) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(973);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,120,_ctx) ) {
			case 1:
				{
				setState(969);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(966);
					match(NL);
					}
					}
					setState(971);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(972);
				typeParameters();
				}
				break;
			}
			setState(990);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,123,_ctx) ) {
			case 1:
				{
				setState(978);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(975);
					match(NL);
					}
					}
					setState(980);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(981);
				receiverType();
				setState(985);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(982);
					match(NL);
					}
					}
					setState(987);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(988);
				match(DOT);
				}
				break;
			}
			{
			setState(995);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(992);
					match(NL);
					}
					} 
				}
				setState(997);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,124,_ctx);
			}
			setState(998);
			variableDeclaration();
			}
			setState(1007);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,126,_ctx) ) {
			case 1:
				{
				setState(1003);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1000);
					match(NL);
					}
					}
					setState(1005);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1006);
				typeConstraints();
				}
				break;
			}
			setState(1023);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,129,_ctx) ) {
			case 1:
				{
				setState(1012);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1009);
					match(NL);
					}
					}
					setState(1014);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1015);
				_la = _input.LA(1);
				if ( !(_la==ASSIGNMENT || _la==BY) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(1019);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1016);
					match(NL);
					}
					}
					setState(1021);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1022);
				expression();
				}
				break;
			}
			setState(1032);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,131,_ctx) ) {
			case 1:
				{
				setState(1028);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1025);
					match(NL);
					}
					}
					setState(1030);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1031);
				match(SEMICOLON);
				}
				break;
			}
			setState(1037);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1034);
					match(NL);
					}
					} 
				}
				setState(1039);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,132,_ctx);
			}
			setState(1065);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,138,_ctx) ) {
			case 1:
				{
				setState(1040);
				getter();
				setState(1051);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,135,_ctx) ) {
				case 1:
					{
					setState(1044);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(1041);
							match(NL);
							}
							} 
						}
						setState(1046);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,133,_ctx);
					}
					setState(1048);
					_errHandler.sync(this);
					_la = _input.LA(1);
					if (_la==NL || _la==SEMICOLON) {
						{
						setState(1047);
						semi();
						}
					}

					setState(1050);
					setter();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(1053);
				setter();
				{
				setState(1057);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1054);
						match(NL);
						}
						} 
					}
					setState(1059);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,136,_ctx);
				}
				setState(1061);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==NL || _la==SEMICOLON) {
					{
					setState(1060);
					semi();
					}
				}

				setState(1063);
				getter();
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VariableDeclarationContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public VariableDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_variableDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitVariableDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VariableDeclarationContext variableDeclaration() throws RecognitionException {
		VariableDeclarationContext _localctx = new VariableDeclarationContext(_ctx, getState());
		enterRule(_localctx, 58, RULE_variableDeclaration);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1070);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				{
				setState(1067);
				singleAnnotation();
				}
				}
				setState(1072);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1076);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1073);
				match(NL);
				}
				}
				setState(1078);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1079);
			simpleIdentifier();
			setState(1094);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,143,_ctx) ) {
			case 1:
				{
				setState(1083);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1080);
					match(NL);
					}
					}
					setState(1085);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1086);
				match(COLON);
				setState(1090);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1087);
					match(NL);
					}
					}
					setState(1092);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1093);
				type();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GetterContext extends ParserRuleContext {
		public TerminalNode GET() { return getToken(OolangParser.GET, 0); }
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public GetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_getter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitGetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GetterContext getter() throws RecognitionException {
		GetterContext _localctx = new GetterContext(_ctx, getState());
		enterRule(_localctx, 60, RULE_getter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1097);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(1096);
				modifiers();
				}
			}

			setState(1099);
			match(GET);
			setState(1137);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,151,_ctx) ) {
			case 1:
				{
				setState(1103);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1100);
					match(NL);
					}
					}
					setState(1105);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1106);
				match(LPAREN);
				setState(1110);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1107);
					match(NL);
					}
					}
					setState(1112);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1113);
				match(RPAREN);
				setState(1128);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,149,_ctx) ) {
				case 1:
					{
					setState(1117);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1114);
						match(NL);
						}
						}
						setState(1119);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1120);
					match(COLON);
					setState(1124);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1121);
						match(NL);
						}
						}
						setState(1126);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1127);
					type();
					}
					break;
				}
				setState(1133);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1130);
					match(NL);
					}
					}
					setState(1135);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1136);
				functionBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SetterContext extends ParserRuleContext {
		public TerminalNode SET() { return getToken(OolangParser.SET, 0); }
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public FunctionValueParameterWithOptionalTypeContext functionValueParameterWithOptionalType() {
			return getRuleContext(FunctionValueParameterWithOptionalTypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COMMA() { return getToken(OolangParser.COMMA, 0); }
		public SetterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_setter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSetter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SetterContext setter() throws RecognitionException {
		SetterContext _localctx = new SetterContext(_ctx, getState());
		enterRule(_localctx, 62, RULE_setter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1140);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==AT_NO_WS || _la==AT_PRE_WS || ((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 33554333L) != 0)) {
				{
				setState(1139);
				modifiers();
				}
			}

			setState(1142);
			match(SET);
			setState(1181);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,159,_ctx) ) {
			case 1:
				{
				setState(1146);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1143);
					match(NL);
					}
					}
					setState(1148);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1149);
				match(LPAREN);
				setState(1153);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1150);
					match(NL);
					}
					}
					setState(1155);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1156);
				functionValueParameterWithOptionalType();
				setState(1164);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,156,_ctx) ) {
				case 1:
					{
					setState(1160);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1157);
						match(NL);
						}
						}
						setState(1162);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1163);
					match(COMMA);
					}
					break;
				}
				setState(1169);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1166);
					match(NL);
					}
					}
					setState(1171);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1172);
				match(RPAREN);
				setState(1176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1173);
					match(NL);
					}
					}
					setState(1178);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1179);
				functionBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParametersWithOptionalTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<FunctionValueParameterWithOptionalTypeContext> functionValueParameterWithOptionalType() {
			return getRuleContexts(FunctionValueParameterWithOptionalTypeContext.class);
		}
		public FunctionValueParameterWithOptionalTypeContext functionValueParameterWithOptionalType(int i) {
			return getRuleContext(FunctionValueParameterWithOptionalTypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public ParametersWithOptionalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parametersWithOptionalType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParametersWithOptionalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersWithOptionalTypeContext parametersWithOptionalType() throws RecognitionException {
		ParametersWithOptionalTypeContext _localctx = new ParametersWithOptionalTypeContext(_ctx, getState());
		enterRule(_localctx, 64, RULE_parametersWithOptionalType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1183);
			match(LPAREN);
			setState(1187);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1184);
					match(NL);
					}
					} 
				}
				setState(1189);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,160,_ctx);
			}
			setState(1219);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628252590768128L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255788123162129L) != 0)) {
				{
				setState(1190);
				functionValueParameterWithOptionalType();
				setState(1207);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1194);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(1191);
							match(NL);
							}
							}
							setState(1196);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1197);
						match(COMMA);
						setState(1201);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(1198);
							match(NL);
							}
							}
							setState(1203);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1204);
						functionValueParameterWithOptionalType();
						}
						} 
					}
					setState(1209);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,163,_ctx);
				}
				setState(1217);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,165,_ctx) ) {
				case 1:
					{
					setState(1213);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1210);
						match(NL);
						}
						}
						setState(1215);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1216);
					match(COMMA);
					}
					break;
				}
				}
			}

			setState(1224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1221);
				match(NL);
				}
				}
				setState(1226);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1227);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionValueParameterWithOptionalTypeContext extends ParserRuleContext {
		public ParameterWithOptionalTypeContext parameterWithOptionalType() {
			return getRuleContext(ParameterWithOptionalTypeContext.class,0);
		}
		public ParameterModifiersContext parameterModifiers() {
			return getRuleContext(ParameterModifiersContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public FunctionValueParameterWithOptionalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionValueParameterWithOptionalType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionValueParameterWithOptionalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionValueParameterWithOptionalTypeContext functionValueParameterWithOptionalType() throws RecognitionException {
		FunctionValueParameterWithOptionalTypeContext _localctx = new FunctionValueParameterWithOptionalTypeContext(_ctx, getState());
		enterRule(_localctx, 66, RULE_functionValueParameterWithOptionalType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1230);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				setState(1229);
				parameterModifiers();
				}
			}

			setState(1232);
			parameterWithOptionalType();
			setState(1247);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,171,_ctx) ) {
			case 1:
				{
				setState(1236);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1233);
					match(NL);
					}
					}
					setState(1238);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1239);
				match(ASSIGNMENT);
				setState(1243);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1240);
					match(NL);
					}
					}
					setState(1245);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1246);
				expression();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterWithOptionalTypeContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ParameterWithOptionalTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterWithOptionalType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParameterWithOptionalType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterWithOptionalTypeContext parameterWithOptionalType() throws RecognitionException {
		ParameterWithOptionalTypeContext _localctx = new ParameterWithOptionalTypeContext(_ctx, getState());
		enterRule(_localctx, 68, RULE_parameterWithOptionalType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1249);
			simpleIdentifier();
			setState(1253);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1250);
					match(NL);
					}
					} 
				}
				setState(1255);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,172,_ctx);
			}
			setState(1264);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==COLON) {
				{
				setState(1256);
				match(COLON);
				setState(1260);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1257);
					match(NL);
					}
					}
					setState(1262);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1263);
				type();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterContext parameter() throws RecognitionException {
		ParameterContext _localctx = new ParameterContext(_ctx, getState());
		enterRule(_localctx, 70, RULE_parameter);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1266);
			simpleIdentifier();
			setState(1270);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1267);
				match(NL);
				}
				}
				setState(1272);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1273);
			match(COLON);
			setState(1277);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1274);
				match(NL);
				}
				}
				setState(1279);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1280);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumClassBodyContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(OolangParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public EnumEntriesContext enumEntries() {
			return getRuleContext(EnumEntriesContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(OolangParser.SEMICOLON, 0); }
		public List<ClassMemberDeclarationContext> classMemberDeclaration() {
			return getRuleContexts(ClassMemberDeclarationContext.class);
		}
		public ClassMemberDeclarationContext classMemberDeclaration(int i) {
			return getRuleContext(ClassMemberDeclarationContext.class,i);
		}
		public EnumClassBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumClassBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitEnumClassBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumClassBodyContext enumClassBody() throws RecognitionException {
		EnumClassBodyContext _localctx = new EnumClassBodyContext(_ctx, getState());
		enterRule(_localctx, 72, RULE_enumClassBody);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1282);
			match(LCURL);
			setState(1286);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1283);
					match(NL);
					}
					} 
				}
				setState(1288);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,177,_ctx);
			}
			setState(1290);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628252590768128L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255925562115601L) != 0)) {
				{
				setState(1289);
				enumEntries();
				}
			}

			setState(1311);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,182,_ctx) ) {
			case 1:
				{
				setState(1295);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1292);
					match(NL);
					}
					}
					setState(1297);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1298);
				match(SEMICOLON);
				setState(1302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1299);
						match(NL);
						}
						} 
					}
					setState(1304);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,180,_ctx);
				}
				setState(1308);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & 9079257020577611776L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 140737073119233L) != 0)) {
					{
					{
					setState(1305);
					classMemberDeclaration();
					}
					}
					setState(1310);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1316);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1313);
				match(NL);
				}
				}
				setState(1318);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1319);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumEntriesContext extends ParserRuleContext {
		public List<EnumEntryContext> enumEntry() {
			return getRuleContexts(EnumEntryContext.class);
		}
		public EnumEntryContext enumEntry(int i) {
			return getRuleContext(EnumEntryContext.class,i);
		}
		public TerminalNode SEMICOLON() { return getToken(OolangParser.SEMICOLON, 0); }
		public EnumEntriesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumEntries; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitEnumEntries(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumEntriesContext enumEntries() throws RecognitionException {
		EnumEntriesContext _localctx = new EnumEntriesContext(_ctx, getState());
		enterRule(_localctx, 74, RULE_enumEntries);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1322); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(1321);
				enumEntry();
				}
				}
				setState(1324); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628252590768128L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255925562115601L) != 0) );
			setState(1327);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,185,_ctx) ) {
			case 1:
				{
				setState(1326);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EnumEntryContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public ModifiersContext modifiers() {
			return getRuleContext(ModifiersContext.class,0);
		}
		public ValueArgumentsContext valueArguments() {
			return getRuleContext(ValueArgumentsContext.class,0);
		}
		public ClassBodyContext classBody() {
			return getRuleContext(ClassBodyContext.class,0);
		}
		public TerminalNode COMMA() { return getToken(OolangParser.COMMA, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public EnumEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitEnumEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumEntryContext enumEntry() throws RecognitionException {
		EnumEntryContext _localctx = new EnumEntryContext(_ctx, getState());
		enterRule(_localctx, 76, RULE_enumEntry);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1336);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,187,_ctx) ) {
			case 1:
				{
				setState(1329);
				modifiers();
				setState(1333);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1330);
					match(NL);
					}
					}
					setState(1335);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1338);
			simpleIdentifier();
			setState(1346);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,189,_ctx) ) {
			case 1:
				{
				setState(1342);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1339);
					match(NL);
					}
					}
					setState(1344);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1345);
				valueArguments();
				}
				break;
			}
			setState(1355);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,191,_ctx) ) {
			case 1:
				{
				setState(1351);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1348);
					match(NL);
					}
					}
					setState(1353);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1354);
				classBody();
				}
				break;
			}
			setState(1364);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,193,_ctx) ) {
			case 1:
				{
				setState(1360);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1357);
					match(NL);
					}
					}
					setState(1362);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1363);
				match(COMMA);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeContext extends ParserRuleContext {
		public FunctionTypeContext functionType() {
			return getRuleContext(FunctionTypeContext.class,0);
		}
		public ParenthesizedTypeContext parenthesizedType() {
			return getRuleContext(ParenthesizedTypeContext.class,0);
		}
		public NullableTypeContext nullableType() {
			return getRuleContext(NullableTypeContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_type; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeContext type() throws RecognitionException {
		TypeContext _localctx = new TypeContext(_ctx, getState());
		enterRule(_localctx, 78, RULE_type);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1369);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1366);
					annotation();
					}
					} 
				}
				setState(1371);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,194,_ctx);
			}
			setState(1376);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,195,_ctx) ) {
			case 1:
				{
				setState(1372);
				functionType();
				}
				break;
			case 2:
				{
				setState(1373);
				parenthesizedType();
				}
				break;
			case 3:
				{
				setState(1374);
				nullableType();
				}
				break;
			case 4:
				{
				setState(1375);
				userType();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NullableTypeContext extends ParserRuleContext {
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public ParenthesizedTypeContext parenthesizedType() {
			return getRuleContext(ParenthesizedTypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<QuestContext> quest() {
			return getRuleContexts(QuestContext.class);
		}
		public QuestContext quest(int i) {
			return getRuleContext(QuestContext.class,i);
		}
		public NullableTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullableType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitNullableType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullableTypeContext nullableType() throws RecognitionException {
		NullableTypeContext _localctx = new NullableTypeContext(_ctx, getState());
		enterRule(_localctx, 80, RULE_nullableType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1380);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case OUT:
			case FIELD:
			case GET:
			case SET:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				{
				setState(1378);
				userType();
				}
				break;
			case LPAREN:
				{
				setState(1379);
				parenthesizedType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1385);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1382);
				match(NL);
				}
				}
				setState(1387);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1389); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1388);
					quest();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1391); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,198,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class QuestContext extends ParserRuleContext {
		public TerminalNode QUEST_NO_WS() { return getToken(OolangParser.QUEST_NO_WS, 0); }
		public TerminalNode QUEST_WS() { return getToken(OolangParser.QUEST_WS, 0); }
		public QuestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitQuest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuestContext quest() throws RecognitionException {
		QuestContext _localctx = new QuestContext(_ctx, getState());
		enterRule(_localctx, 82, RULE_quest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1393);
			_la = _input.LA(1);
			if ( !(_la==QUEST_WS || _la==QUEST_NO_WS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UserTypeContext extends ParserRuleContext {
		public List<SimpleUserTypeContext> simpleUserType() {
			return getRuleContexts(SimpleUserTypeContext.class);
		}
		public SimpleUserTypeContext simpleUserType(int i) {
			return getRuleContext(SimpleUserTypeContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(OolangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(OolangParser.DOT, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public UserTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_userType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitUserType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UserTypeContext userType() throws RecognitionException {
		UserTypeContext _localctx = new UserTypeContext(_ctx, getState());
		enterRule(_localctx, 84, RULE_userType);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1395);
			simpleUserType();
			setState(1412);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1399);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1396);
						match(NL);
						}
						}
						setState(1401);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1402);
					match(DOT);
					setState(1406);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1403);
						match(NL);
						}
						}
						setState(1408);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1409);
					simpleUserType();
					}
					} 
				}
				setState(1414);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,201,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleUserTypeContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SimpleUserTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleUserType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSimpleUserType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleUserTypeContext simpleUserType() throws RecognitionException {
		SimpleUserTypeContext _localctx = new SimpleUserTypeContext(_ctx, getState());
		enterRule(_localctx, 86, RULE_simpleUserType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1415);
			simpleIdentifier();
			setState(1423);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,203,_ctx) ) {
			case 1:
				{
				setState(1419);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1416);
					match(NL);
					}
					}
					setState(1421);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1422);
				typeArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeProjectionContext extends ParserRuleContext {
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TypeProjectionModifiersContext typeProjectionModifiers() {
			return getRuleContext(TypeProjectionModifiersContext.class,0);
		}
		public TerminalNode MULT() { return getToken(OolangParser.MULT, 0); }
		public TypeProjectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeProjection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeProjection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeProjectionContext typeProjection() throws RecognitionException {
		TypeProjectionContext _localctx = new TypeProjectionContext(_ctx, getState());
		enterRule(_localctx, 88, RULE_typeProjection);
		try {
			setState(1430);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case AT_NO_WS:
			case AT_PRE_WS:
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case IN:
			case OUT:
			case FIELD_SITE:
			case FIELD:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case GET:
			case SET:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				enterOuterAlt(_localctx, 1);
				{
				setState(1426);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,204,_ctx) ) {
				case 1:
					{
					setState(1425);
					typeProjectionModifiers();
					}
					break;
				}
				setState(1428);
				type();
				}
				break;
			case MULT:
				enterOuterAlt(_localctx, 2);
				{
				setState(1429);
				match(MULT);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeProjectionModifiersContext extends ParserRuleContext {
		public List<TypeProjectionModifierContext> typeProjectionModifier() {
			return getRuleContexts(TypeProjectionModifierContext.class);
		}
		public TypeProjectionModifierContext typeProjectionModifier(int i) {
			return getRuleContext(TypeProjectionModifierContext.class,i);
		}
		public TypeProjectionModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeProjectionModifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeProjectionModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeProjectionModifiersContext typeProjectionModifiers() throws RecognitionException {
		TypeProjectionModifiersContext _localctx = new TypeProjectionModifiersContext(_ctx, getState());
		enterRule(_localctx, 90, RULE_typeProjectionModifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1433); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(1432);
					typeProjectionModifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(1435); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,206,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeProjectionModifierContext extends ParserRuleContext {
		public VarianceModifierContext varianceModifier() {
			return getRuleContext(VarianceModifierContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SingleAnnotationContext singleAnnotation() {
			return getRuleContext(SingleAnnotationContext.class,0);
		}
		public TypeProjectionModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeProjectionModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeProjectionModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeProjectionModifierContext typeProjectionModifier() throws RecognitionException {
		TypeProjectionModifierContext _localctx = new TypeProjectionModifierContext(_ctx, getState());
		enterRule(_localctx, 92, RULE_typeProjectionModifier);
		int _la;
		try {
			setState(1445);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IN:
			case OUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(1437);
				varianceModifier();
				setState(1441);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1438);
					match(NL);
					}
					}
					setState(1443);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case AT_NO_WS:
			case AT_PRE_WS:
			case FIELD_SITE:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1444);
				singleAnnotation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeContext extends ParserRuleContext {
		public FunctionTypeParametersContext functionTypeParameters() {
			return getRuleContext(FunctionTypeParametersContext.class,0);
		}
		public TerminalNode ARROW() { return getToken(OolangParser.ARROW, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public ReceiverTypeContext receiverType() {
			return getRuleContext(ReceiverTypeContext.class,0);
		}
		public TerminalNode DOT() { return getToken(OolangParser.DOT, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public FunctionTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeContext functionType() throws RecognitionException {
		FunctionTypeContext _localctx = new FunctionTypeContext(_ctx, getState());
		enterRule(_localctx, 94, RULE_functionType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1461);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,211,_ctx) ) {
			case 1:
				{
				setState(1447);
				receiverType();
				setState(1451);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1448);
					match(NL);
					}
					}
					setState(1453);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1454);
				match(DOT);
				setState(1458);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1455);
					match(NL);
					}
					}
					setState(1460);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(1463);
			functionTypeParameters();
			setState(1467);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1464);
				match(NL);
				}
				}
				setState(1469);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1470);
			match(ARROW);
			setState(1474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1471);
				match(NL);
				}
				}
				setState(1476);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1477);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionTypeParametersContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<ParameterContext> parameter() {
			return getRuleContexts(ParameterContext.class);
		}
		public ParameterContext parameter(int i) {
			return getRuleContext(ParameterContext.class,i);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public FunctionTypeParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionTypeParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionTypeParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionTypeParametersContext functionTypeParameters() throws RecognitionException {
		FunctionTypeParametersContext _localctx = new FunctionTypeParametersContext(_ctx, getState());
		enterRule(_localctx, 96, RULE_functionTypeParameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1479);
			match(LPAREN);
			setState(1483);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1480);
					match(NL);
					}
					} 
				}
				setState(1485);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,214,_ctx);
			}
			setState(1488);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,215,_ctx) ) {
			case 1:
				{
				setState(1486);
				parameter();
				}
				break;
			case 2:
				{
				setState(1487);
				type();
				}
				break;
			}
			setState(1509);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1493);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1490);
						match(NL);
						}
						}
						setState(1495);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1496);
					match(COMMA);
					setState(1500);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1497);
						match(NL);
						}
						}
						setState(1502);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1505);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,218,_ctx) ) {
					case 1:
						{
						setState(1503);
						parameter();
						}
						break;
					case 2:
						{
						setState(1504);
						type();
						}
						break;
					}
					}
					} 
				}
				setState(1511);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,219,_ctx);
			}
			setState(1519);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,221,_ctx) ) {
			case 1:
				{
				setState(1515);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1512);
					match(NL);
					}
					}
					setState(1517);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1518);
				match(COMMA);
				}
				break;
			}
			setState(1524);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1521);
				match(NL);
				}
				}
				setState(1526);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1527);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ParenthesizedTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParenthesizedType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedTypeContext parenthesizedType() throws RecognitionException {
		ParenthesizedTypeContext _localctx = new ParenthesizedTypeContext(_ctx, getState());
		enterRule(_localctx, 98, RULE_parenthesizedType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1529);
			match(LPAREN);
			setState(1533);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1530);
				match(NL);
				}
				}
				setState(1535);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1536);
			type();
			setState(1540);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1537);
				match(NL);
				}
				}
				setState(1542);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1543);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ReceiverTypeContext extends ParserRuleContext {
		public ParenthesizedTypeContext parenthesizedType() {
			return getRuleContext(ParenthesizedTypeContext.class,0);
		}
		public NullableTypeContext nullableType() {
			return getRuleContext(NullableTypeContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public AnnotationContext annotation() {
			return getRuleContext(AnnotationContext.class,0);
		}
		public ReceiverTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_receiverType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitReceiverType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ReceiverTypeContext receiverType() throws RecognitionException {
		ReceiverTypeContext _localctx = new ReceiverTypeContext(_ctx, getState());
		enterRule(_localctx, 100, RULE_receiverType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1546);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				setState(1545);
				annotation();
				}
			}

			setState(1551);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,226,_ctx) ) {
			case 1:
				{
				setState(1548);
				parenthesizedType();
				}
				break;
			case 2:
				{
				setState(1549);
				nullableType();
				}
				break;
			case 3:
				{
				setState(1550);
				userType();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedUserTypeContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public ParenthesizedUserTypeContext parenthesizedUserType() {
			return getRuleContext(ParenthesizedUserTypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ParenthesizedUserTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedUserType; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParenthesizedUserType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedUserTypeContext parenthesizedUserType() throws RecognitionException {
		ParenthesizedUserTypeContext _localctx = new ParenthesizedUserTypeContext(_ctx, getState());
		enterRule(_localctx, 102, RULE_parenthesizedUserType);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1553);
			match(LPAREN);
			setState(1557);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1554);
				match(NL);
				}
				}
				setState(1559);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1562);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case OUT:
			case FIELD:
			case GET:
			case SET:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				{
				setState(1560);
				userType();
				}
				break;
			case LPAREN:
				{
				setState(1561);
				parenthesizedUserType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(1567);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1564);
				match(NL);
				}
				}
				setState(1569);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1570);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementsContext extends ParserRuleContext {
		public List<AnysemiContext> anysemi() {
			return getRuleContexts(AnysemiContext.class);
		}
		public AnysemiContext anysemi(int i) {
			return getRuleContext(AnysemiContext.class,i);
		}
		public List<StatementContext> statement() {
			return getRuleContexts(StatementContext.class);
		}
		public StatementContext statement(int i) {
			return getRuleContext(StatementContext.class,i);
		}
		public StatementsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statements; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitStatements(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementsContext statements() throws RecognitionException {
		StatementsContext _localctx = new StatementsContext(_ctx, getState());
		enterRule(_localctx, 104, RULE_statements);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1575);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1572);
					anysemi();
					}
					} 
				}
				setState(1577);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,230,_ctx);
			}
			setState(1592);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,234,_ctx) ) {
			case 1:
				{
				setState(1578);
				statement();
				setState(1589);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1580); 
						_errHandler.sync(this);
						_alt = 1;
						do {
							switch (_alt) {
							case 1:
								{
								{
								setState(1579);
								anysemi();
								}
								}
								break;
							default:
								throw new NoViableAltException(this);
							}
							setState(1582); 
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,231,_ctx);
						} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
						setState(1585);
						_errHandler.sync(this);
						switch ( getInterpreter().adaptivePredict(_input,232,_ctx) ) {
						case 1:
							{
							setState(1584);
							statement();
							}
							break;
						}
						}
						} 
					}
					setState(1591);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,233,_ctx);
				}
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StatementContext extends ParserRuleContext {
		public BlockLevelExpressionContext blockLevelExpression() {
			return getRuleContext(BlockLevelExpressionContext.class,0);
		}
		public BlockLevelDeclarationContext blockLevelDeclaration() {
			return getRuleContext(BlockLevelDeclarationContext.class,0);
		}
		public StatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_statement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StatementContext statement() throws RecognitionException {
		StatementContext _localctx = new StatementContext(_ctx, getState());
		enterRule(_localctx, 106, RULE_statement);
		try {
			setState(1596);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,235,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1594);
				blockLevelExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1595);
				blockLevelDeclaration();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockLevelExpressionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public BlockLevelExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockLevelExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitBlockLevelExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockLevelExpressionContext blockLevelExpression() throws RecognitionException {
		BlockLevelExpressionContext _localctx = new BlockLevelExpressionContext(_ctx, getState());
		enterRule(_localctx, 108, RULE_blockLevelExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1601);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1598);
					annotation();
					}
					} 
				}
				setState(1603);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,236,_ctx);
			}
			setState(1607);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1604);
				match(NL);
				}
				}
				setState(1609);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1610);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockLevelDeclarationContext extends ParserRuleContext {
		public DeclarationContext declaration() {
			return getRuleContext(DeclarationContext.class,0);
		}
		public AssignmentContext assignment() {
			return getRuleContext(AssignmentContext.class,0);
		}
		public LoopStatementContext loopStatement() {
			return getRuleContext(LoopStatementContext.class,0);
		}
		public List<LabelContext> label() {
			return getRuleContexts(LabelContext.class);
		}
		public LabelContext label(int i) {
			return getRuleContext(LabelContext.class,i);
		}
		public BlockLevelDeclarationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockLevelDeclaration; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitBlockLevelDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockLevelDeclarationContext blockLevelDeclaration() throws RecognitionException {
		BlockLevelDeclarationContext _localctx = new BlockLevelDeclarationContext(_ctx, getState());
		enterRule(_localctx, 110, RULE_blockLevelDeclaration);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1615);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1612);
					label();
					}
					} 
				}
				setState(1617);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,238,_ctx);
			}
			setState(1621);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,239,_ctx) ) {
			case 1:
				{
				setState(1618);
				declaration();
				}
				break;
			case 2:
				{
				setState(1619);
				assignment();
				}
				break;
			case 3:
				{
				setState(1620);
				loopStatement();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LabelContext extends ParserRuleContext {
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode AT_NO_WS() { return getToken(OolangParser.AT_NO_WS, 0); }
		public TerminalNode AT_POST_WS() { return getToken(OolangParser.AT_POST_WS, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public LabelContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_label; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLabel(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LabelContext label() throws RecognitionException {
		LabelContext _localctx = new LabelContext(_ctx, getState());
		enterRule(_localctx, 112, RULE_label);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1623);
			simpleIdentifier();
			setState(1624);
			_la = _input.LA(1);
			if ( !(_la==AT_NO_WS || _la==AT_POST_WS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			setState(1628);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,240,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1625);
					match(NL);
					}
					} 
				}
				setState(1630);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,240,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DirectlyAssignableExpressionContext directlyAssignableExpression() {
			return getRuleContext(DirectlyAssignableExpressionContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public AssignableExpressionContext assignableExpression() {
			return getRuleContext(AssignableExpressionContext.class,0);
		}
		public AssignmentAndOperatorContext assignmentAndOperator() {
			return getRuleContext(AssignmentAndOperatorContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public AssignmentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignment; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentContext assignment() throws RecognitionException {
		AssignmentContext _localctx = new AssignmentContext(_ctx, getState());
		enterRule(_localctx, 114, RULE_assignment);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1637);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,241,_ctx) ) {
			case 1:
				{
				setState(1631);
				directlyAssignableExpression();
				setState(1632);
				match(ASSIGNMENT);
				}
				break;
			case 2:
				{
				setState(1634);
				assignableExpression();
				setState(1635);
				assignmentAndOperator();
				}
				break;
			}
			setState(1642);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1639);
				match(NL);
				}
				}
				setState(1644);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1645);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LoopStatementContext extends ParserRuleContext {
		public ForStatementContext forStatement() {
			return getRuleContext(ForStatementContext.class,0);
		}
		public WhileStatementContext whileStatement() {
			return getRuleContext(WhileStatementContext.class,0);
		}
		public LoopStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_loopStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLoopStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LoopStatementContext loopStatement() throws RecognitionException {
		LoopStatementContext _localctx = new LoopStatementContext(_ctx, getState());
		enterRule(_localctx, 116, RULE_loopStatement);
		try {
			setState(1649);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FOR:
				enterOuterAlt(_localctx, 1);
				{
				setState(1647);
				forStatement();
				}
				break;
			case WHILE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1648);
				whileStatement();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ForStatementContext extends ParserRuleContext {
		public TerminalNode FOR() { return getToken(OolangParser.FOR, 0); }
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public ControlStructureBodyContext controlStructureBody() {
			return getRuleContext(ControlStructureBodyContext.class,0);
		}
		public ForStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_forStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitForStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ForStatementContext forStatement() throws RecognitionException {
		ForStatementContext _localctx = new ForStatementContext(_ctx, getState());
		enterRule(_localctx, 118, RULE_forStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1651);
			match(FOR);
			setState(1655);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1652);
				match(NL);
				}
				}
				setState(1657);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1658);
			match(LPAREN);
			setState(1662);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1659);
					singleAnnotation();
					}
					} 
				}
				setState(1664);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,245,_ctx);
			}
			setState(1665);
			variableDeclaration();
			setState(1666);
			match(COLON);
			setState(1667);
			expression();
			setState(1668);
			match(RPAREN);
			setState(1672);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1669);
					match(NL);
					}
					} 
				}
				setState(1674);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,246,_ctx);
			}
			setState(1676);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,247,_ctx) ) {
			case 1:
				{
				setState(1675);
				controlStructureBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhileStatementContext extends ParserRuleContext {
		public TerminalNode WHILE() { return getToken(OolangParser.WHILE, 0); }
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public ControlStructureBodyContext controlStructureBody() {
			return getRuleContext(ControlStructureBodyContext.class,0);
		}
		public TerminalNode SEMICOLON() { return getToken(OolangParser.SEMICOLON, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public WhileStatementContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whileStatement; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitWhileStatement(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhileStatementContext whileStatement() throws RecognitionException {
		WhileStatementContext _localctx = new WhileStatementContext(_ctx, getState());
		enterRule(_localctx, 120, RULE_whileStatement);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1678);
			match(WHILE);
			setState(1682);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1679);
				match(NL);
				}
				}
				setState(1684);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1685);
			match(LPAREN);
			setState(1686);
			expression();
			setState(1687);
			match(RPAREN);
			setState(1691);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,249,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1688);
					match(NL);
					}
					} 
				}
				setState(1693);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,249,_ctx);
			}
			setState(1696);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NL:
			case LPAREN:
			case LSQUARE:
			case LCURL:
			case ADD:
			case SUB:
			case INCR:
			case DECR:
			case EXCL_WS:
			case EXCL_NO_WS:
			case COLONCOLON:
			case AT_NO_WS:
			case AT_PRE_WS:
			case IMPORT:
			case CLASS:
			case INTERFACE:
			case FUN:
			case VAL:
			case VAR:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case THIS:
			case SUPER:
			case WHERE:
			case IF:
			case WHEN:
			case TRY:
			case CATCH:
			case FINALLY:
			case FOR:
			case WHILE:
			case THROW:
			case RETURN:
			case CONTINUE:
			case OUT:
			case FIELD_SITE:
			case FIELD:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case GET:
			case SET:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case VALUE:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case RealLiteral:
			case IntegerLiteral:
			case HexLiteral:
			case BinLiteral:
			case LongLiteral:
			case BooleanLiteral:
			case NullLiteral:
			case CharacterLiteral:
			case Identifier:
			case QUOTE_OPEN:
			case TRIPLE_QUOTE_OPEN:
				{
				setState(1694);
				controlStructureBody();
				}
				break;
			case SEMICOLON:
				{
				setState(1695);
				match(SEMICOLON);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ControlStructureBodyContext extends ParserRuleContext {
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public StatementContext statement() {
			return getRuleContext(StatementContext.class,0);
		}
		public ControlStructureBodyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_controlStructureBody; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitControlStructureBody(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ControlStructureBodyContext controlStructureBody() throws RecognitionException {
		ControlStructureBodyContext _localctx = new ControlStructureBodyContext(_ctx, getState());
		enterRule(_localctx, 122, RULE_controlStructureBody);
		try {
			setState(1700);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,251,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1698);
				block();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1699);
				statement();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class BlockContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(OolangParser.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public BlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_block; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockContext block() throws RecognitionException {
		BlockContext _localctx = new BlockContext(_ctx, getState());
		enterRule(_localctx, 124, RULE_block);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1702);
			match(LCURL);
			setState(1706);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,252,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1703);
					match(NL);
					}
					} 
				}
				setState(1708);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,252,_ctx);
			}
			setState(1709);
			statements();
			setState(1713);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1710);
				match(NL);
				}
				}
				setState(1715);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1716);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExpressionContext extends ParserRuleContext {
		public DisjunctionContext disjunction() {
			return getRuleContext(DisjunctionContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 126, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1718);
			disjunction();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DisjunctionContext extends ParserRuleContext {
		public List<ConjunctionContext> conjunction() {
			return getRuleContexts(ConjunctionContext.class);
		}
		public ConjunctionContext conjunction(int i) {
			return getRuleContext(ConjunctionContext.class,i);
		}
		public List<TerminalNode> DISJ() { return getTokens(OolangParser.DISJ); }
		public TerminalNode DISJ(int i) {
			return getToken(OolangParser.DISJ, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public DisjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_disjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitDisjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DisjunctionContext disjunction() throws RecognitionException {
		DisjunctionContext _localctx = new DisjunctionContext(_ctx, getState());
		enterRule(_localctx, 128, RULE_disjunction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1720);
			conjunction();
			setState(1737);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1724);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1721);
						match(NL);
						}
						}
						setState(1726);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1727);
					match(DISJ);
					setState(1731);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1728);
						match(NL);
						}
						}
						setState(1733);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1734);
					conjunction();
					}
					} 
				}
				setState(1739);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,256,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ConjunctionContext extends ParserRuleContext {
		public List<EqualityContext> equality() {
			return getRuleContexts(EqualityContext.class);
		}
		public EqualityContext equality(int i) {
			return getRuleContext(EqualityContext.class,i);
		}
		public List<TerminalNode> CONJ() { return getTokens(OolangParser.CONJ); }
		public TerminalNode CONJ(int i) {
			return getToken(OolangParser.CONJ, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ConjunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_conjunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitConjunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ConjunctionContext conjunction() throws RecognitionException {
		ConjunctionContext _localctx = new ConjunctionContext(_ctx, getState());
		enterRule(_localctx, 130, RULE_conjunction);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1740);
			equality();
			setState(1757);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,259,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1744);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1741);
						match(NL);
						}
						}
						setState(1746);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1747);
					match(CONJ);
					setState(1751);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1748);
						match(NL);
						}
						}
						setState(1753);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1754);
					equality();
					}
					} 
				}
				setState(1759);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,259,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityContext extends ParserRuleContext {
		public List<ComparisonContext> comparison() {
			return getRuleContexts(ComparisonContext.class);
		}
		public ComparisonContext comparison(int i) {
			return getRuleContext(ComparisonContext.class,i);
		}
		public List<EqualityOperatorContext> equalityOperator() {
			return getRuleContexts(EqualityOperatorContext.class);
		}
		public EqualityOperatorContext equalityOperator(int i) {
			return getRuleContext(EqualityOperatorContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public EqualityContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equality; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitEquality(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityContext equality() throws RecognitionException {
		EqualityContext _localctx = new EqualityContext(_ctx, getState());
		enterRule(_localctx, 132, RULE_equality);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1760);
			comparison();
			setState(1772);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1761);
					equalityOperator();
					setState(1765);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1762);
						match(NL);
						}
						}
						setState(1767);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1768);
					comparison();
					}
					} 
				}
				setState(1774);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,261,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonContext extends ParserRuleContext {
		public List<GenericCallLikeComparisonContext> genericCallLikeComparison() {
			return getRuleContexts(GenericCallLikeComparisonContext.class);
		}
		public GenericCallLikeComparisonContext genericCallLikeComparison(int i) {
			return getRuleContext(GenericCallLikeComparisonContext.class,i);
		}
		public List<ComparisonOperatorContext> comparisonOperator() {
			return getRuleContexts(ComparisonOperatorContext.class);
		}
		public ComparisonOperatorContext comparisonOperator(int i) {
			return getRuleContext(ComparisonOperatorContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonContext comparison() throws RecognitionException {
		ComparisonContext _localctx = new ComparisonContext(_ctx, getState());
		enterRule(_localctx, 134, RULE_comparison);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1775);
			genericCallLikeComparison();
			setState(1787);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1776);
					comparisonOperator();
					setState(1780);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1777);
						match(NL);
						}
						}
						setState(1782);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1783);
					genericCallLikeComparison();
					}
					} 
				}
				setState(1789);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,263,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class GenericCallLikeComparisonContext extends ParserRuleContext {
		public IsExpressionContext isExpression() {
			return getRuleContext(IsExpressionContext.class,0);
		}
		public List<CallSuffixContext> callSuffix() {
			return getRuleContexts(CallSuffixContext.class);
		}
		public CallSuffixContext callSuffix(int i) {
			return getRuleContext(CallSuffixContext.class,i);
		}
		public GenericCallLikeComparisonContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_genericCallLikeComparison; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitGenericCallLikeComparison(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GenericCallLikeComparisonContext genericCallLikeComparison() throws RecognitionException {
		GenericCallLikeComparisonContext _localctx = new GenericCallLikeComparisonContext(_ctx, getState());
		enterRule(_localctx, 136, RULE_genericCallLikeComparison);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1790);
			isExpression();
			setState(1794);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,264,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1791);
					callSuffix();
					}
					} 
				}
				setState(1796);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,264,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsExpressionContext extends ParserRuleContext {
		public ElvisExpressionContext elvisExpression() {
			return getRuleContext(ElvisExpressionContext.class,0);
		}
		public IsOperatorContext isOperator() {
			return getRuleContext(IsOperatorContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public IsExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitIsExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsExpressionContext isExpression() throws RecognitionException {
		IsExpressionContext _localctx = new IsExpressionContext(_ctx, getState());
		enterRule(_localctx, 138, RULE_isExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1797);
			elvisExpression();
			setState(1807);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,266,_ctx) ) {
			case 1:
				{
				setState(1798);
				isOperator();
				setState(1802);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1799);
					match(NL);
					}
					}
					setState(1804);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(1805);
				type();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElvisExpressionContext extends ParserRuleContext {
		public List<AdditiveExpressionContext> additiveExpression() {
			return getRuleContexts(AdditiveExpressionContext.class);
		}
		public AdditiveExpressionContext additiveExpression(int i) {
			return getRuleContext(AdditiveExpressionContext.class,i);
		}
		public List<ElvisContext> elvis() {
			return getRuleContexts(ElvisContext.class);
		}
		public ElvisContext elvis(int i) {
			return getRuleContext(ElvisContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ElvisExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elvisExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitElvisExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElvisExpressionContext elvisExpression() throws RecognitionException {
		ElvisExpressionContext _localctx = new ElvisExpressionContext(_ctx, getState());
		enterRule(_localctx, 140, RULE_elvisExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1809);
			additiveExpression();
			setState(1827);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,269,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1813);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1810);
						match(NL);
						}
						}
						setState(1815);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1816);
					elvis();
					setState(1820);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1817);
						match(NL);
						}
						}
						setState(1822);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1823);
					additiveExpression();
					}
					} 
				}
				setState(1829);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,269,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ElvisContext extends ParserRuleContext {
		public TerminalNode QUEST_NO_WS() { return getToken(OolangParser.QUEST_NO_WS, 0); }
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public ElvisContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_elvis; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitElvis(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ElvisContext elvis() throws RecognitionException {
		ElvisContext _localctx = new ElvisContext(_ctx, getState());
		enterRule(_localctx, 142, RULE_elvis);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1830);
			match(QUEST_NO_WS);
			setState(1831);
			match(COLON);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveExpressionContext extends ParserRuleContext {
		public List<MultiplicativeExpressionContext> multiplicativeExpression() {
			return getRuleContexts(MultiplicativeExpressionContext.class);
		}
		public MultiplicativeExpressionContext multiplicativeExpression(int i) {
			return getRuleContext(MultiplicativeExpressionContext.class,i);
		}
		public List<AdditiveOperatorContext> additiveOperator() {
			return getRuleContexts(AdditiveOperatorContext.class);
		}
		public AdditiveOperatorContext additiveOperator(int i) {
			return getRuleContext(AdditiveOperatorContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public AdditiveExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAdditiveExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveExpressionContext additiveExpression() throws RecognitionException {
		AdditiveExpressionContext _localctx = new AdditiveExpressionContext(_ctx, getState());
		enterRule(_localctx, 144, RULE_additiveExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1833);
			multiplicativeExpression();
			setState(1845);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,271,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1834);
					additiveOperator();
					setState(1838);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1835);
						match(NL);
						}
						}
						setState(1840);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1841);
					multiplicativeExpression();
					}
					} 
				}
				setState(1847);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,271,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeExpressionContext extends ParserRuleContext {
		public List<TypeRHSContext> typeRHS() {
			return getRuleContexts(TypeRHSContext.class);
		}
		public TypeRHSContext typeRHS(int i) {
			return getRuleContext(TypeRHSContext.class,i);
		}
		public List<MultiplicativeOperatorContext> multiplicativeOperator() {
			return getRuleContexts(MultiplicativeOperatorContext.class);
		}
		public MultiplicativeOperatorContext multiplicativeOperator(int i) {
			return getRuleContext(MultiplicativeOperatorContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public MultiplicativeExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMultiplicativeExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeExpressionContext multiplicativeExpression() throws RecognitionException {
		MultiplicativeExpressionContext _localctx = new MultiplicativeExpressionContext(_ctx, getState());
		enterRule(_localctx, 146, RULE_multiplicativeExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1848);
			typeRHS();
			setState(1860);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,273,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1849);
					multiplicativeOperator();
					setState(1853);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1850);
						match(NL);
						}
						}
						setState(1855);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1856);
					typeRHS();
					}
					} 
				}
				setState(1862);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,273,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeRHSContext extends ParserRuleContext {
		public List<PrefixUnaryExpressionContext> prefixUnaryExpression() {
			return getRuleContexts(PrefixUnaryExpressionContext.class);
		}
		public PrefixUnaryExpressionContext prefixUnaryExpression(int i) {
			return getRuleContext(PrefixUnaryExpressionContext.class,i);
		}
		public List<TypeOperationContext> typeOperation() {
			return getRuleContexts(TypeOperationContext.class);
		}
		public TypeOperationContext typeOperation(int i) {
			return getRuleContext(TypeOperationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TypeRHSContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeRHS; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeRHS(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeRHSContext typeRHS() throws RecognitionException {
		TypeRHSContext _localctx = new TypeRHSContext(_ctx, getState());
		enterRule(_localctx, 148, RULE_typeRHS);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1863);
			prefixUnaryExpression();
			setState(1875);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,275,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1867);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1864);
						match(NL);
						}
						}
						setState(1869);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1870);
					typeOperation();
					setState(1871);
					prefixUnaryExpression();
					}
					} 
				}
				setState(1877);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,275,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixUnaryExpressionContext extends ParserRuleContext {
		public PostfixUnaryExpressionContext postfixUnaryExpression() {
			return getRuleContext(PostfixUnaryExpressionContext.class,0);
		}
		public List<UnaryPrefixContext> unaryPrefix() {
			return getRuleContexts(UnaryPrefixContext.class);
		}
		public UnaryPrefixContext unaryPrefix(int i) {
			return getRuleContext(UnaryPrefixContext.class,i);
		}
		public PrefixUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixUnaryExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPrefixUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixUnaryExpressionContext prefixUnaryExpression() throws RecognitionException {
		PrefixUnaryExpressionContext _localctx = new PrefixUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 150, RULE_prefixUnaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1881);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,276,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1878);
					unaryPrefix();
					}
					} 
				}
				setState(1883);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,276,_ctx);
			}
			setState(1884);
			postfixUnaryExpression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnaryPrefixContext extends ParserRuleContext {
		public PrefixUnaryOperatorContext prefixUnaryOperator() {
			return getRuleContext(PrefixUnaryOperatorContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SingleAnnotationContext singleAnnotation() {
			return getRuleContext(SingleAnnotationContext.class,0);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public UnaryPrefixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unaryPrefix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitUnaryPrefix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnaryPrefixContext unaryPrefix() throws RecognitionException {
		UnaryPrefixContext _localctx = new UnaryPrefixContext(_ctx, getState());
		enterRule(_localctx, 152, RULE_unaryPrefix);
		int _la;
		try {
			setState(1895);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ADD:
			case SUB:
			case INCR:
			case DECR:
			case EXCL_WS:
			case EXCL_NO_WS:
				enterOuterAlt(_localctx, 1);
				{
				setState(1886);
				prefixUnaryOperator();
				setState(1890);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1887);
					match(NL);
					}
					}
					setState(1892);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case AT_NO_WS:
			case AT_PRE_WS:
			case FIELD_SITE:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(1893);
				singleAnnotation();
				}
				break;
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case OUT:
			case FIELD:
			case GET:
			case SET:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				enterOuterAlt(_localctx, 3);
				{
				setState(1894);
				label();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixUnaryExpressionContext extends ParserRuleContext {
		public AtomicExpressionContext atomicExpression() {
			return getRuleContext(AtomicExpressionContext.class,0);
		}
		public List<PostfixUnarySuffixContext> postfixUnarySuffix() {
			return getRuleContexts(PostfixUnarySuffixContext.class);
		}
		public PostfixUnarySuffixContext postfixUnarySuffix(int i) {
			return getRuleContext(PostfixUnarySuffixContext.class,i);
		}
		public PostfixUnaryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixUnaryExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPostfixUnaryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixUnaryExpressionContext postfixUnaryExpression() throws RecognitionException {
		PostfixUnaryExpressionContext _localctx = new PostfixUnaryExpressionContext(_ctx, getState());
		enterRule(_localctx, 154, RULE_postfixUnaryExpression);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1897);
			atomicExpression();
			setState(1901);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(1898);
					postfixUnarySuffix();
					}
					} 
				}
				setState(1903);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,279,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AtomicExpressionContext extends ParserRuleContext {
		public ParenthesizedExpressionContext parenthesizedExpression() {
			return getRuleContext(ParenthesizedExpressionContext.class,0);
		}
		public CollectionLiteralContext collectionLiteral() {
			return getRuleContext(CollectionLiteralContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public LiteralConstantContext literalConstant() {
			return getRuleContext(LiteralConstantContext.class,0);
		}
		public StringLiteralContext stringLiteral() {
			return getRuleContext(StringLiteralContext.class,0);
		}
		public CallableReferenceContext callableReference() {
			return getRuleContext(CallableReferenceContext.class,0);
		}
		public FunctionLiteralContext functionLiteral() {
			return getRuleContext(FunctionLiteralContext.class,0);
		}
		public ThisExpressionContext thisExpression() {
			return getRuleContext(ThisExpressionContext.class,0);
		}
		public SuperExpressionContext superExpression() {
			return getRuleContext(SuperExpressionContext.class,0);
		}
		public IfExpressionContext ifExpression() {
			return getRuleContext(IfExpressionContext.class,0);
		}
		public WhenExpressionContext whenExpression() {
			return getRuleContext(WhenExpressionContext.class,0);
		}
		public TryExpressionContext tryExpression() {
			return getRuleContext(TryExpressionContext.class,0);
		}
		public JumpExpressionContext jumpExpression() {
			return getRuleContext(JumpExpressionContext.class,0);
		}
		public AtomicExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_atomicExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAtomicExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AtomicExpressionContext atomicExpression() throws RecognitionException {
		AtomicExpressionContext _localctx = new AtomicExpressionContext(_ctx, getState());
		enterRule(_localctx, 156, RULE_atomicExpression);
		try {
			setState(1917);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,280,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(1904);
				parenthesizedExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(1905);
				collectionLiteral();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(1906);
				simpleIdentifier();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(1907);
				literalConstant();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(1908);
				stringLiteral();
				}
				break;
			case 6:
				enterOuterAlt(_localctx, 6);
				{
				setState(1909);
				callableReference();
				}
				break;
			case 7:
				enterOuterAlt(_localctx, 7);
				{
				setState(1910);
				functionLiteral();
				}
				break;
			case 8:
				enterOuterAlt(_localctx, 8);
				{
				setState(1911);
				thisExpression();
				}
				break;
			case 9:
				enterOuterAlt(_localctx, 9);
				{
				setState(1912);
				superExpression();
				}
				break;
			case 10:
				enterOuterAlt(_localctx, 10);
				{
				setState(1913);
				ifExpression();
				}
				break;
			case 11:
				enterOuterAlt(_localctx, 11);
				{
				setState(1914);
				whenExpression();
				}
				break;
			case 12:
				enterOuterAlt(_localctx, 12);
				{
				setState(1915);
				tryExpression();
				}
				break;
			case 13:
				enterOuterAlt(_localctx, 13);
				{
				setState(1916);
				jumpExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ParenthesizedExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParenthesizedExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedExpressionContext parenthesizedExpression() throws RecognitionException {
		ParenthesizedExpressionContext _localctx = new ParenthesizedExpressionContext(_ctx, getState());
		enterRule(_localctx, 158, RULE_parenthesizedExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1919);
			match(LPAREN);
			setState(1923);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1920);
				match(NL);
				}
				}
				setState(1925);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1926);
			expression();
			setState(1930);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1927);
				match(NL);
				}
				}
				setState(1932);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1933);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CollectionLiteralContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(OolangParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(OolangParser.RSQUARE, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public CollectionLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_collectionLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitCollectionLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CollectionLiteralContext collectionLiteral() throws RecognitionException {
		CollectionLiteralContext _localctx = new CollectionLiteralContext(_ctx, getState());
		enterRule(_localctx, 160, RULE_collectionLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(1935);
			match(LSQUARE);
			setState(1939);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(1936);
				match(NL);
				}
				}
				setState(1941);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1977);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3963167483080338176L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2016768070690858935L) != 0)) {
				{
				setState(1942);
				expression();
				setState(1959);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(1946);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(1943);
							match(NL);
							}
							}
							setState(1948);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1949);
						match(COMMA);
						setState(1953);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(1950);
							match(NL);
							}
							}
							setState(1955);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(1956);
						expression();
						}
						} 
					}
					setState(1961);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,286,_ctx);
				}
				setState(1969);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,288,_ctx) ) {
				case 1:
					{
					setState(1965);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(1962);
						match(NL);
						}
						}
						setState(1967);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(1968);
					match(COMMA);
					}
					break;
				}
				setState(1974);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(1971);
					match(NL);
					}
					}
					setState(1976);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(1979);
			match(RSQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LiteralConstantContext extends ParserRuleContext {
		public TerminalNode BooleanLiteral() { return getToken(OolangParser.BooleanLiteral, 0); }
		public TerminalNode IntegerLiteral() { return getToken(OolangParser.IntegerLiteral, 0); }
		public TerminalNode HexLiteral() { return getToken(OolangParser.HexLiteral, 0); }
		public TerminalNode BinLiteral() { return getToken(OolangParser.BinLiteral, 0); }
		public TerminalNode CharacterLiteral() { return getToken(OolangParser.CharacterLiteral, 0); }
		public TerminalNode RealLiteral() { return getToken(OolangParser.RealLiteral, 0); }
		public TerminalNode NullLiteral() { return getToken(OolangParser.NullLiteral, 0); }
		public TerminalNode LongLiteral() { return getToken(OolangParser.LongLiteral, 0); }
		public LiteralConstantContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_literalConstant; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLiteralConstant(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LiteralConstantContext literalConstant() throws RecognitionException {
		LiteralConstantContext _localctx = new LiteralConstantContext(_ctx, getState());
		enterRule(_localctx, 162, RULE_literalConstant);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1981);
			_la = _input.LA(1);
			if ( !(((((_la - 111)) & ~0x3f) == 0 && ((1L << (_la - 111)) & 1017L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class StringLiteralContext extends ParserRuleContext {
		public LineStringLiteralContext lineStringLiteral() {
			return getRuleContext(LineStringLiteralContext.class,0);
		}
		public MultiLineStringLiteralContext multiLineStringLiteral() {
			return getRuleContext(MultiLineStringLiteralContext.class,0);
		}
		public StringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_stringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final StringLiteralContext stringLiteral() throws RecognitionException {
		StringLiteralContext _localctx = new StringLiteralContext(_ctx, getState());
		enterRule(_localctx, 164, RULE_stringLiteral);
		try {
			setState(1985);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case QUOTE_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(1983);
				lineStringLiteral();
				}
				break;
			case TRIPLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(1984);
				multiLineStringLiteral();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineStringLiteralContext extends ParserRuleContext {
		public TerminalNode QUOTE_OPEN() { return getToken(OolangParser.QUOTE_OPEN, 0); }
		public TerminalNode QUOTE_CLOSE() { return getToken(OolangParser.QUOTE_CLOSE, 0); }
		public List<LineStringContentContext> lineStringContent() {
			return getRuleContexts(LineStringContentContext.class);
		}
		public LineStringContentContext lineStringContent(int i) {
			return getRuleContext(LineStringContentContext.class,i);
		}
		public List<LineStringExpressionContext> lineStringExpression() {
			return getRuleContexts(LineStringExpressionContext.class);
		}
		public LineStringExpressionContext lineStringExpression(int i) {
			return getRuleContext(LineStringExpressionContext.class,i);
		}
		public LineStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineStringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLineStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineStringLiteralContext lineStringLiteral() throws RecognitionException {
		LineStringLiteralContext _localctx = new LineStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 166, RULE_lineStringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1987);
			match(QUOTE_OPEN);
			setState(1992);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 15L) != 0)) {
				{
				setState(1990);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case LineStrRef:
				case LineStrText:
				case LineStrEscapedChar:
					{
					setState(1988);
					lineStringContent();
					}
					break;
				case LineStrExprStart:
					{
					setState(1989);
					lineStringExpression();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(1994);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(1995);
			match(QUOTE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiLineStringLiteralContext extends ParserRuleContext {
		public TerminalNode TRIPLE_QUOTE_OPEN() { return getToken(OolangParser.TRIPLE_QUOTE_OPEN, 0); }
		public TerminalNode TRIPLE_QUOTE_CLOSE() { return getToken(OolangParser.TRIPLE_QUOTE_CLOSE, 0); }
		public List<MultiLineStringContentContext> multiLineStringContent() {
			return getRuleContexts(MultiLineStringContentContext.class);
		}
		public MultiLineStringContentContext multiLineStringContent(int i) {
			return getRuleContext(MultiLineStringContentContext.class,i);
		}
		public List<MultiLineStringExpressionContext> multiLineStringExpression() {
			return getRuleContexts(MultiLineStringExpressionContext.class);
		}
		public MultiLineStringExpressionContext multiLineStringExpression(int i) {
			return getRuleContext(MultiLineStringExpressionContext.class,i);
		}
		public List<TerminalNode> MultiLineStringQuote() { return getTokens(OolangParser.MultiLineStringQuote); }
		public TerminalNode MultiLineStringQuote(int i) {
			return getToken(OolangParser.MultiLineStringQuote, i);
		}
		public MultiLineStringLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiLineStringLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMultiLineStringLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiLineStringLiteralContext multiLineStringLiteral() throws RecognitionException {
		MultiLineStringLiteralContext _localctx = new MultiLineStringLiteralContext(_ctx, getState());
		enterRule(_localctx, 168, RULE_multiLineStringLiteral);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(1997);
			match(TRIPLE_QUOTE_OPEN);
			setState(2003);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & 23L) != 0)) {
				{
				setState(2001);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,294,_ctx) ) {
				case 1:
					{
					setState(1998);
					multiLineStringContent();
					}
					break;
				case 2:
					{
					setState(1999);
					multiLineStringExpression();
					}
					break;
				case 3:
					{
					setState(2000);
					match(MultiLineStringQuote);
					}
					break;
				}
				}
				setState(2005);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2006);
			match(TRIPLE_QUOTE_CLOSE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineStringContentContext extends ParserRuleContext {
		public TerminalNode LineStrText() { return getToken(OolangParser.LineStrText, 0); }
		public TerminalNode LineStrEscapedChar() { return getToken(OolangParser.LineStrEscapedChar, 0); }
		public TerminalNode LineStrRef() { return getToken(OolangParser.LineStrRef, 0); }
		public LineStringContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineStringContent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLineStringContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineStringContentContext lineStringContent() throws RecognitionException {
		LineStringContentContext _localctx = new LineStringContentContext(_ctx, getState());
		enterRule(_localctx, 170, RULE_lineStringContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2008);
			_la = _input.LA(1);
			if ( !(((((_la - 133)) & ~0x3f) == 0 && ((1L << (_la - 133)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LineStringExpressionContext extends ParserRuleContext {
		public TerminalNode LineStrExprStart() { return getToken(OolangParser.LineStrExprStart, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public LineStringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lineStringExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLineStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineStringExpressionContext lineStringExpression() throws RecognitionException {
		LineStringExpressionContext _localctx = new LineStringExpressionContext(_ctx, getState());
		enterRule(_localctx, 172, RULE_lineStringExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2010);
			match(LineStrExprStart);
			setState(2014);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2011);
				match(NL);
				}
				}
				setState(2016);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2017);
			expression();
			setState(2021);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2018);
				match(NL);
				}
				}
				setState(2023);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2024);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiLineStringContentContext extends ParserRuleContext {
		public TerminalNode MultiLineStrText() { return getToken(OolangParser.MultiLineStrText, 0); }
		public TerminalNode MultiLineStringQuote() { return getToken(OolangParser.MultiLineStringQuote, 0); }
		public TerminalNode MultiLineStrRef() { return getToken(OolangParser.MultiLineStrRef, 0); }
		public MultiLineStringContentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiLineStringContent; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMultiLineStringContent(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiLineStringContentContext multiLineStringContent() throws RecognitionException {
		MultiLineStringContentContext _localctx = new MultiLineStringContentContext(_ctx, getState());
		enterRule(_localctx, 174, RULE_multiLineStringContent);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2026);
			_la = _input.LA(1);
			if ( !(((((_la - 138)) & ~0x3f) == 0 && ((1L << (_la - 138)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiLineStringExpressionContext extends ParserRuleContext {
		public TerminalNode MultiLineStrExprStart() { return getToken(OolangParser.MultiLineStrExprStart, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public MultiLineStringExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiLineStringExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMultiLineStringExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiLineStringExpressionContext multiLineStringExpression() throws RecognitionException {
		MultiLineStringExpressionContext _localctx = new MultiLineStringExpressionContext(_ctx, getState());
		enterRule(_localctx, 176, RULE_multiLineStringExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2028);
			match(MultiLineStrExprStart);
			setState(2032);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2029);
				match(NL);
				}
				}
				setState(2034);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2035);
			expression();
			setState(2039);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2036);
				match(NL);
				}
				}
				setState(2041);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2042);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaLiteralContext extends ParserRuleContext {
		public TerminalNode LCURL() { return getToken(OolangParser.LCURL, 0); }
		public StatementsContext statements() {
			return getRuleContext(StatementsContext.class,0);
		}
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode ARROW() { return getToken(OolangParser.ARROW, 0); }
		public LambdaParametersContext lambdaParameters() {
			return getRuleContext(LambdaParametersContext.class,0);
		}
		public LambdaLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLambdaLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaLiteralContext lambdaLiteral() throws RecognitionException {
		LambdaLiteralContext _localctx = new LambdaLiteralContext(_ctx, getState());
		enterRule(_localctx, 178, RULE_lambdaLiteral);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2044);
			match(LCURL);
			setState(2048);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2045);
					match(NL);
					}
					} 
				}
				setState(2050);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,300,_ctx);
			}
			setState(2067);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,304,_ctx) ) {
			case 1:
				{
				setState(2052);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,301,_ctx) ) {
				case 1:
					{
					setState(2051);
					lambdaParameters();
					}
					break;
				}
				setState(2057);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2054);
					match(NL);
					}
					}
					setState(2059);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2060);
				match(ARROW);
				setState(2064);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2061);
						match(NL);
						}
						} 
					}
					setState(2066);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,303,_ctx);
				}
				}
				break;
			}
			setState(2069);
			statements();
			setState(2073);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2070);
				match(NL);
				}
				}
				setState(2075);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2076);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class LambdaParametersContext extends ParserRuleContext {
		public List<VariableDeclarationContext> variableDeclaration() {
			return getRuleContexts(VariableDeclarationContext.class);
		}
		public VariableDeclarationContext variableDeclaration(int i) {
			return getRuleContext(VariableDeclarationContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public LambdaParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_lambdaParameters; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitLambdaParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LambdaParametersContext lambdaParameters() throws RecognitionException {
		LambdaParametersContext _localctx = new LambdaParametersContext(_ctx, getState());
		enterRule(_localctx, 180, RULE_lambdaParameters);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2078);
			variableDeclaration();
			setState(2095);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,308,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2082);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2079);
						match(NL);
						}
						}
						setState(2084);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2085);
					match(COMMA);
					setState(2089);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,307,_ctx);
					while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
						if ( _alt==1 ) {
							{
							{
							setState(2086);
							match(NL);
							}
							} 
						}
						setState(2091);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,307,_ctx);
					}
					setState(2092);
					variableDeclaration();
					}
					} 
				}
				setState(2097);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,308,_ctx);
			}
			setState(2105);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,310,_ctx) ) {
			case 1:
				{
				setState(2101);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2098);
					match(NL);
					}
					}
					setState(2103);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2104);
				match(COMMA);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnonymousFunctionContext extends ParserRuleContext {
		public TerminalNode FUN() { return getToken(OolangParser.FUN, 0); }
		public ParametersWithOptionalTypeContext parametersWithOptionalType() {
			return getRuleContext(ParametersWithOptionalTypeContext.class,0);
		}
		public List<TypeContext> type() {
			return getRuleContexts(TypeContext.class);
		}
		public TypeContext type(int i) {
			return getRuleContext(TypeContext.class,i);
		}
		public TerminalNode DOT() { return getToken(OolangParser.DOT, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeConstraintsContext typeConstraints() {
			return getRuleContext(TypeConstraintsContext.class,0);
		}
		public FunctionBodyContext functionBody() {
			return getRuleContext(FunctionBodyContext.class,0);
		}
		public AnonymousFunctionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anonymousFunction; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnonymousFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnonymousFunctionContext anonymousFunction() throws RecognitionException {
		AnonymousFunctionContext _localctx = new AnonymousFunctionContext(_ctx, getState());
		enterRule(_localctx, 182, RULE_anonymousFunction);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2107);
			match(FUN);
			setState(2123);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,313,_ctx) ) {
			case 1:
				{
				setState(2111);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2108);
					match(NL);
					}
					}
					setState(2113);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2114);
				type();
				setState(2118);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2115);
					match(NL);
					}
					}
					setState(2120);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2121);
				match(DOT);
				}
				break;
			}
			setState(2128);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2125);
				match(NL);
				}
				}
				setState(2130);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2131);
			parametersWithOptionalType();
			setState(2146);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,317,_ctx) ) {
			case 1:
				{
				setState(2135);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2132);
					match(NL);
					}
					}
					setState(2137);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2138);
				match(COLON);
				setState(2142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2139);
					match(NL);
					}
					}
					setState(2144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2145);
				type();
				}
				break;
			}
			setState(2155);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,319,_ctx) ) {
			case 1:
				{
				setState(2151);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2148);
					match(NL);
					}
					}
					setState(2153);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2154);
				typeConstraints();
				}
				break;
			}
			setState(2164);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,321,_ctx) ) {
			case 1:
				{
				setState(2160);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2157);
					match(NL);
					}
					}
					setState(2162);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2163);
				functionBody();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FunctionLiteralContext extends ParserRuleContext {
		public LambdaLiteralContext lambdaLiteral() {
			return getRuleContext(LambdaLiteralContext.class,0);
		}
		public AnonymousFunctionContext anonymousFunction() {
			return getRuleContext(AnonymousFunctionContext.class,0);
		}
		public FunctionLiteralContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionLiteral; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFunctionLiteral(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionLiteralContext functionLiteral() throws RecognitionException {
		FunctionLiteralContext _localctx = new FunctionLiteralContext(_ctx, getState());
		enterRule(_localctx, 184, RULE_functionLiteral);
		try {
			setState(2168);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LCURL:
				enterOuterAlt(_localctx, 1);
				{
				setState(2166);
				lambdaLiteral();
				}
				break;
			case FUN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2167);
				anonymousFunction();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ThisExpressionContext extends ParserRuleContext {
		public TerminalNode THIS() { return getToken(OolangParser.THIS, 0); }
		public ThisExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_thisExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitThisExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ThisExpressionContext thisExpression() throws RecognitionException {
		ThisExpressionContext _localctx = new ThisExpressionContext(_ctx, getState());
		enterRule(_localctx, 186, RULE_thisExpression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2170);
			match(THIS);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SuperExpressionContext extends ParserRuleContext {
		public TerminalNode SUPER() { return getToken(OolangParser.SUPER, 0); }
		public TerminalNode LANGLE() { return getToken(OolangParser.LANGLE, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RANGLE() { return getToken(OolangParser.RANGLE, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SuperExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_superExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSuperExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SuperExpressionContext superExpression() throws RecognitionException {
		SuperExpressionContext _localctx = new SuperExpressionContext(_ctx, getState());
		enterRule(_localctx, 188, RULE_superExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2172);
			match(SUPER);
			setState(2189);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,325,_ctx) ) {
			case 1:
				{
				setState(2173);
				match(LANGLE);
				setState(2177);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2174);
					match(NL);
					}
					}
					setState(2179);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2180);
				type();
				setState(2184);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2181);
					match(NL);
					}
					}
					setState(2186);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2187);
				match(RANGLE);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IfExpressionContext extends ParserRuleContext {
		public TerminalNode IF() { return getToken(OolangParser.IF, 0); }
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<ControlStructureBodyContext> controlStructureBody() {
			return getRuleContexts(ControlStructureBodyContext.class);
		}
		public ControlStructureBodyContext controlStructureBody(int i) {
			return getRuleContext(ControlStructureBodyContext.class,i);
		}
		public TerminalNode ELSE() { return getToken(OolangParser.ELSE, 0); }
		public List<TerminalNode> SEMICOLON() { return getTokens(OolangParser.SEMICOLON); }
		public TerminalNode SEMICOLON(int i) {
			return getToken(OolangParser.SEMICOLON, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public IfExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ifExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitIfExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IfExpressionContext ifExpression() throws RecognitionException {
		IfExpressionContext _localctx = new IfExpressionContext(_ctx, getState());
		enterRule(_localctx, 190, RULE_ifExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2191);
			match(IF);
			setState(2195);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2192);
				match(NL);
				}
				}
				setState(2197);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2198);
			match(LPAREN);
			setState(2202);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2199);
				match(NL);
				}
				}
				setState(2204);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2205);
			expression();
			setState(2209);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2206);
				match(NL);
				}
				}
				setState(2211);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2212);
			match(RPAREN);
			setState(2216);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,329,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2213);
					match(NL);
					}
					} 
				}
				setState(2218);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,329,_ctx);
			}
			setState(2250);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,336,_ctx) ) {
			case 1:
				{
				setState(2219);
				controlStructureBody();
				}
				break;
			case 2:
				{
				setState(2221);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,330,_ctx) ) {
				case 1:
					{
					setState(2220);
					controlStructureBody();
					}
					break;
				}
				setState(2226);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,331,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2223);
						match(NL);
						}
						} 
					}
					setState(2228);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,331,_ctx);
				}
				setState(2230);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==SEMICOLON) {
					{
					setState(2229);
					match(SEMICOLON);
					}
				}

				setState(2235);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2232);
					match(NL);
					}
					}
					setState(2237);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2238);
				match(ELSE);
				setState(2242);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,334,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2239);
						match(NL);
						}
						} 
					}
					setState(2244);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,334,_ctx);
				}
				setState(2247);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NL:
				case LPAREN:
				case LSQUARE:
				case LCURL:
				case ADD:
				case SUB:
				case INCR:
				case DECR:
				case EXCL_WS:
				case EXCL_NO_WS:
				case COLONCOLON:
				case AT_NO_WS:
				case AT_PRE_WS:
				case IMPORT:
				case CLASS:
				case INTERFACE:
				case FUN:
				case VAL:
				case VAR:
				case CONSTRUCTOR:
				case BY:
				case INIT:
				case THIS:
				case SUPER:
				case WHERE:
				case IF:
				case WHEN:
				case TRY:
				case CATCH:
				case FINALLY:
				case FOR:
				case WHILE:
				case THROW:
				case RETURN:
				case CONTINUE:
				case OUT:
				case FIELD_SITE:
				case FIELD:
				case PROPERTY_SITE:
				case GET_SITE:
				case SET_SITE:
				case GET:
				case SET:
				case PARAM_SITE:
				case SETPARAM_SITE:
				case DELEGATE_SITE:
				case PUBLIC:
				case PRIVATE:
				case PROTECTED:
				case ENUM:
				case SEALED:
				case VALUE:
				case RECORD:
				case INNER:
				case ANNOTATION:
				case OVERRIDE:
				case ABSTRACT:
				case FINAL:
				case OPEN:
				case STATIC:
				case VARARG:
				case RealLiteral:
				case IntegerLiteral:
				case HexLiteral:
				case BinLiteral:
				case LongLiteral:
				case BooleanLiteral:
				case NullLiteral:
				case CharacterLiteral:
				case Identifier:
				case QUOTE_OPEN:
				case TRIPLE_QUOTE_OPEN:
					{
					setState(2245);
					controlStructureBody();
					}
					break;
				case SEMICOLON:
					{
					setState(2246);
					match(SEMICOLON);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				break;
			case 3:
				{
				setState(2249);
				match(SEMICOLON);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhenSubjectContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public TerminalNode VAL() { return getToken(OolangParser.VAL, 0); }
		public VariableDeclarationContext variableDeclaration() {
			return getRuleContext(VariableDeclarationContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public WhenSubjectContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenSubject; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitWhenSubject(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenSubjectContext whenSubject() throws RecognitionException {
		WhenSubjectContext _localctx = new WhenSubjectContext(_ctx, getState());
		enterRule(_localctx, 192, RULE_whenSubject);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2252);
			match(LPAREN);
			setState(2286);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,342,_ctx) ) {
			case 1:
				{
				setState(2256);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
					{
					{
					setState(2253);
					singleAnnotation();
					}
					}
					setState(2258);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2262);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2259);
					match(NL);
					}
					}
					setState(2264);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2265);
				match(VAL);
				setState(2269);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,339,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2266);
						match(NL);
						}
						} 
					}
					setState(2271);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,339,_ctx);
				}
				setState(2272);
				variableDeclaration();
				setState(2276);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2273);
					match(NL);
					}
					}
					setState(2278);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2279);
				match(ASSIGNMENT);
				setState(2283);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2280);
					match(NL);
					}
					}
					setState(2285);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			}
			setState(2288);
			expression();
			setState(2289);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhenExpressionContext extends ParserRuleContext {
		public TerminalNode WHEN() { return getToken(OolangParser.WHEN, 0); }
		public TerminalNode LCURL() { return getToken(OolangParser.LCURL, 0); }
		public TerminalNode RCURL() { return getToken(OolangParser.RCURL, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public WhenSubjectContext whenSubject() {
			return getRuleContext(WhenSubjectContext.class,0);
		}
		public List<WhenEntryContext> whenEntry() {
			return getRuleContexts(WhenEntryContext.class);
		}
		public WhenEntryContext whenEntry(int i) {
			return getRuleContext(WhenEntryContext.class,i);
		}
		public WhenExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitWhenExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenExpressionContext whenExpression() throws RecognitionException {
		WhenExpressionContext _localctx = new WhenExpressionContext(_ctx, getState());
		enterRule(_localctx, 194, RULE_whenExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2291);
			match(WHEN);
			setState(2295);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,343,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2292);
					match(NL);
					}
					} 
				}
				setState(2297);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,343,_ctx);
			}
			setState(2299);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LPAREN) {
				{
				setState(2298);
				whenSubject();
				}
			}

			setState(2304);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2301);
				match(NL);
				}
				}
				setState(2306);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2307);
			match(LCURL);
			setState(2311);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,346,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2308);
					match(NL);
					}
					} 
				}
				setState(2313);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,346,_ctx);
			}
			setState(2323);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3963167483080338176L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2016768070691645431L) != 0)) {
				{
				{
				setState(2314);
				whenEntry();
				setState(2318);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,347,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2315);
						match(NL);
						}
						} 
					}
					setState(2320);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,347,_ctx);
				}
				}
				}
				setState(2325);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2329);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2326);
				match(NL);
				}
				}
				setState(2331);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2332);
			match(RCURL);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhenEntryContext extends ParserRuleContext {
		public List<WhenConditionContext> whenCondition() {
			return getRuleContexts(WhenConditionContext.class);
		}
		public WhenConditionContext whenCondition(int i) {
			return getRuleContext(WhenConditionContext.class,i);
		}
		public TerminalNode ARROW() { return getToken(OolangParser.ARROW, 0); }
		public ControlStructureBodyContext controlStructureBody() {
			return getRuleContext(ControlStructureBodyContext.class,0);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SemiContext semi() {
			return getRuleContext(SemiContext.class,0);
		}
		public TerminalNode ELSE() { return getToken(OolangParser.ELSE, 0); }
		public WhenEntryContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenEntry; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitWhenEntry(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenEntryContext whenEntry() throws RecognitionException {
		WhenEntryContext _localctx = new WhenEntryContext(_ctx, getState());
		enterRule(_localctx, 196, RULE_whenEntry);
		int _la;
		try {
			int _alt;
			setState(2398);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case LSQUARE:
			case LCURL:
			case ADD:
			case SUB:
			case INCR:
			case DECR:
			case EXCL_WS:
			case EXCL_NO_WS:
			case COLONCOLON:
			case AT_NO_WS:
			case AT_PRE_WS:
			case IMPORT:
			case FUN:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case THIS:
			case SUPER:
			case WHERE:
			case IF:
			case WHEN:
			case TRY:
			case CATCH:
			case FINALLY:
			case THROW:
			case RETURN:
			case CONTINUE:
			case IS:
			case NOT_IS:
			case OUT:
			case FIELD_SITE:
			case FIELD:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case GET:
			case SET:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case RealLiteral:
			case IntegerLiteral:
			case HexLiteral:
			case BinLiteral:
			case LongLiteral:
			case BooleanLiteral:
			case NullLiteral:
			case CharacterLiteral:
			case Identifier:
			case QUOTE_OPEN:
			case TRIPLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(2334);
				whenCondition();
				setState(2351);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,352,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2338);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(2335);
							match(NL);
							}
							}
							setState(2340);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(2341);
						match(COMMA);
						setState(2345);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(2342);
							match(NL);
							}
							}
							setState(2347);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(2348);
						whenCondition();
						}
						} 
					}
					setState(2353);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,352,_ctx);
				}
				setState(2361);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,354,_ctx) ) {
				case 1:
					{
					setState(2357);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2354);
						match(NL);
						}
						}
						setState(2359);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2360);
					match(COMMA);
					}
					break;
				}
				setState(2366);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2363);
					match(NL);
					}
					}
					setState(2368);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2369);
				match(ARROW);
				setState(2373);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,356,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2370);
						match(NL);
						}
						} 
					}
					setState(2375);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,356,_ctx);
				}
				setState(2376);
				controlStructureBody();
				setState(2378);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,357,_ctx) ) {
				case 1:
					{
					setState(2377);
					semi();
					}
					break;
				}
				}
				break;
			case ELSE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2380);
				match(ELSE);
				setState(2384);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2381);
					match(NL);
					}
					}
					setState(2386);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2387);
				match(ARROW);
				setState(2391);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,359,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2388);
						match(NL);
						}
						} 
					}
					setState(2393);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,359,_ctx);
				}
				setState(2394);
				controlStructureBody();
				setState(2396);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,360,_ctx) ) {
				case 1:
					{
					setState(2395);
					semi();
					}
					break;
				}
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class WhenConditionContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TypeTestContext typeTest() {
			return getRuleContext(TypeTestContext.class,0);
		}
		public WhenConditionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_whenCondition; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitWhenCondition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WhenConditionContext whenCondition() throws RecognitionException {
		WhenConditionContext _localctx = new WhenConditionContext(_ctx, getState());
		enterRule(_localctx, 198, RULE_whenCondition);
		try {
			setState(2402);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LPAREN:
			case LSQUARE:
			case LCURL:
			case ADD:
			case SUB:
			case INCR:
			case DECR:
			case EXCL_WS:
			case EXCL_NO_WS:
			case COLONCOLON:
			case AT_NO_WS:
			case AT_PRE_WS:
			case IMPORT:
			case FUN:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case THIS:
			case SUPER:
			case WHERE:
			case IF:
			case WHEN:
			case TRY:
			case CATCH:
			case FINALLY:
			case THROW:
			case RETURN:
			case CONTINUE:
			case OUT:
			case FIELD_SITE:
			case FIELD:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case GET:
			case SET:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case RealLiteral:
			case IntegerLiteral:
			case HexLiteral:
			case BinLiteral:
			case LongLiteral:
			case BooleanLiteral:
			case NullLiteral:
			case CharacterLiteral:
			case Identifier:
			case QUOTE_OPEN:
			case TRIPLE_QUOTE_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(2400);
				expression();
				}
				break;
			case IS:
			case NOT_IS:
				enterOuterAlt(_localctx, 2);
				{
				setState(2401);
				typeTest();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeTestContext extends ParserRuleContext {
		public IsOperatorContext isOperator() {
			return getRuleContext(IsOperatorContext.class,0);
		}
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TypeTestContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeTest; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeTest(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeTestContext typeTest() throws RecognitionException {
		TypeTestContext _localctx = new TypeTestContext(_ctx, getState());
		enterRule(_localctx, 200, RULE_typeTest);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2404);
			isOperator();
			setState(2408);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2405);
				match(NL);
				}
				}
				setState(2410);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2411);
			type();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TryExpressionContext extends ParserRuleContext {
		public TerminalNode TRY() { return getToken(OolangParser.TRY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public FinallyBlockContext finallyBlock() {
			return getRuleContext(FinallyBlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<CatchBlockContext> catchBlock() {
			return getRuleContexts(CatchBlockContext.class);
		}
		public CatchBlockContext catchBlock(int i) {
			return getRuleContext(CatchBlockContext.class,i);
		}
		public TryExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tryExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTryExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TryExpressionContext tryExpression() throws RecognitionException {
		TryExpressionContext _localctx = new TryExpressionContext(_ctx, getState());
		enterRule(_localctx, 202, RULE_tryExpression);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2413);
			match(TRY);
			setState(2417);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2414);
				match(NL);
				}
				}
				setState(2419);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2420);
			block();
			setState(2448);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,370,_ctx) ) {
			case 1:
				{
				setState(2428); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2424);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(2421);
							match(NL);
							}
							}
							setState(2426);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(2427);
						catchBlock();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2430); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,366,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(2439);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,368,_ctx) ) {
				case 1:
					{
					setState(2435);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2432);
						match(NL);
						}
						}
						setState(2437);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2438);
					finallyBlock();
					}
					break;
				}
				}
				break;
			case 2:
				{
				setState(2444);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2441);
					match(NL);
					}
					}
					setState(2446);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2447);
				finallyBlock();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CatchBlockContext extends ParserRuleContext {
		public TerminalNode CATCH() { return getToken(OolangParser.CATCH, 0); }
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeContext type() {
			return getRuleContext(TypeContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public TerminalNode COMMA() { return getToken(OolangParser.COMMA, 0); }
		public CatchBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_catchBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitCatchBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatchBlockContext catchBlock() throws RecognitionException {
		CatchBlockContext _localctx = new CatchBlockContext(_ctx, getState());
		enterRule(_localctx, 204, RULE_catchBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2450);
			match(CATCH);
			setState(2454);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2451);
				match(NL);
				}
				}
				setState(2456);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2457);
			match(LPAREN);
			setState(2461);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				{
				setState(2458);
				singleAnnotation();
				}
				}
				setState(2463);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2464);
			simpleIdentifier();
			setState(2465);
			match(COLON);
			setState(2466);
			type();
			setState(2474);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NL || _la==COMMA) {
				{
				setState(2470);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2467);
					match(NL);
					}
					}
					setState(2472);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2473);
				match(COMMA);
				}
			}

			setState(2476);
			match(RPAREN);
			setState(2480);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2477);
				match(NL);
				}
				}
				setState(2482);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2483);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class FinallyBlockContext extends ParserRuleContext {
		public TerminalNode FINALLY() { return getToken(OolangParser.FINALLY, 0); }
		public BlockContext block() {
			return getRuleContext(BlockContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public FinallyBlockContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_finallyBlock; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitFinallyBlock(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FinallyBlockContext finallyBlock() throws RecognitionException {
		FinallyBlockContext _localctx = new FinallyBlockContext(_ctx, getState());
		enterRule(_localctx, 206, RULE_finallyBlock);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2485);
			match(FINALLY);
			setState(2489);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2486);
				match(NL);
				}
				}
				setState(2491);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2492);
			block();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class JumpExpressionContext extends ParserRuleContext {
		public TerminalNode THROW() { return getToken(OolangParser.THROW, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode RETURN() { return getToken(OolangParser.RETURN, 0); }
		public TerminalNode CONTINUE() { return getToken(OolangParser.CONTINUE, 0); }
		public JumpExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_jumpExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitJumpExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final JumpExpressionContext jumpExpression() throws RecognitionException {
		JumpExpressionContext _localctx = new JumpExpressionContext(_ctx, getState());
		enterRule(_localctx, 208, RULE_jumpExpression);
		int _la;
		try {
			setState(2507);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case THROW:
				enterOuterAlt(_localctx, 1);
				{
				setState(2494);
				match(THROW);
				setState(2498);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2495);
					match(NL);
					}
					}
					setState(2500);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2501);
				expression();
				}
				break;
			case RETURN:
				enterOuterAlt(_localctx, 2);
				{
				setState(2502);
				match(RETURN);
				setState(2504);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,378,_ctx) ) {
				case 1:
					{
					setState(2503);
					expression();
					}
					break;
				}
				}
				break;
			case CONTINUE:
				enterOuterAlt(_localctx, 3);
				{
				setState(2506);
				match(CONTINUE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallableReferenceContext extends ParserRuleContext {
		public TerminalNode COLONCOLON() { return getToken(OolangParser.COLONCOLON, 0); }
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(OolangParser.CLASS, 0); }
		public ReceiverTypeContext receiverType() {
			return getRuleContext(ReceiverTypeContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public CallableReferenceContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callableReference; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitCallableReference(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallableReferenceContext callableReference() throws RecognitionException {
		CallableReferenceContext _localctx = new CallableReferenceContext(_ctx, getState());
		enterRule(_localctx, 210, RULE_callableReference);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2510);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628252590767872L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255788123162129L) != 0)) {
				{
				setState(2509);
				receiverType();
				}
			}

			setState(2512);
			match(COLONCOLON);
			setState(2516);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2513);
				match(NL);
				}
				}
				setState(2518);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2521);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case OUT:
			case FIELD:
			case GET:
			case SET:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				{
				setState(2519);
				simpleIdentifier();
				}
				break;
			case CLASS:
				{
				setState(2520);
				match(CLASS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixUnarySuffixContext extends ParserRuleContext {
		public PostfixUnaryOperatorContext postfixUnaryOperator() {
			return getRuleContext(PostfixUnaryOperatorContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public CallSuffixContext callSuffix() {
			return getRuleContext(CallSuffixContext.class,0);
		}
		public IndexingSuffixContext indexingSuffix() {
			return getRuleContext(IndexingSuffixContext.class,0);
		}
		public NavigationSuffixContext navigationSuffix() {
			return getRuleContext(NavigationSuffixContext.class,0);
		}
		public PostfixUnarySuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixUnarySuffix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPostfixUnarySuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixUnarySuffixContext postfixUnarySuffix() throws RecognitionException {
		PostfixUnarySuffixContext _localctx = new PostfixUnarySuffixContext(_ctx, getState());
		enterRule(_localctx, 212, RULE_postfixUnarySuffix);
		try {
			setState(2528);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,383,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2523);
				postfixUnaryOperator();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2524);
				typeArguments();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2525);
				callSuffix();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(2526);
				indexingSuffix();
				}
				break;
			case 5:
				enterOuterAlt(_localctx, 5);
				{
				setState(2527);
				navigationSuffix();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DirectlyAssignableExpressionContext extends ParserRuleContext {
		public PostfixUnaryExpressionContext postfixUnaryExpression() {
			return getRuleContext(PostfixUnaryExpressionContext.class,0);
		}
		public AssignableSuffixContext assignableSuffix() {
			return getRuleContext(AssignableSuffixContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public ParenthesizedDirectlyAssignableExpressionContext parenthesizedDirectlyAssignableExpression() {
			return getRuleContext(ParenthesizedDirectlyAssignableExpressionContext.class,0);
		}
		public DirectlyAssignableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_directlyAssignableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitDirectlyAssignableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DirectlyAssignableExpressionContext directlyAssignableExpression() throws RecognitionException {
		DirectlyAssignableExpressionContext _localctx = new DirectlyAssignableExpressionContext(_ctx, getState());
		enterRule(_localctx, 214, RULE_directlyAssignableExpression);
		try {
			setState(2535);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,384,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2530);
				postfixUnaryExpression();
				setState(2531);
				assignableSuffix();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2533);
				simpleIdentifier();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2534);
				parenthesizedDirectlyAssignableExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedDirectlyAssignableExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public DirectlyAssignableExpressionContext directlyAssignableExpression() {
			return getRuleContext(DirectlyAssignableExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ParenthesizedDirectlyAssignableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedDirectlyAssignableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParenthesizedDirectlyAssignableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedDirectlyAssignableExpressionContext parenthesizedDirectlyAssignableExpression() throws RecognitionException {
		ParenthesizedDirectlyAssignableExpressionContext _localctx = new ParenthesizedDirectlyAssignableExpressionContext(_ctx, getState());
		enterRule(_localctx, 216, RULE_parenthesizedDirectlyAssignableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2537);
			match(LPAREN);
			setState(2541);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2538);
				match(NL);
				}
				}
				setState(2543);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2544);
			directlyAssignableExpression();
			setState(2548);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2545);
				match(NL);
				}
				}
				setState(2550);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2551);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableExpressionContext extends ParserRuleContext {
		public PrefixUnaryExpressionContext prefixUnaryExpression() {
			return getRuleContext(PrefixUnaryExpressionContext.class,0);
		}
		public ParenthesizedAssignableExpressionContext parenthesizedAssignableExpression() {
			return getRuleContext(ParenthesizedAssignableExpressionContext.class,0);
		}
		public AssignableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAssignableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableExpressionContext assignableExpression() throws RecognitionException {
		AssignableExpressionContext _localctx = new AssignableExpressionContext(_ctx, getState());
		enterRule(_localctx, 218, RULE_assignableExpression);
		try {
			setState(2555);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,387,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2553);
				prefixUnaryExpression();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2554);
				parenthesizedAssignableExpression();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParenthesizedAssignableExpressionContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public AssignableExpressionContext assignableExpression() {
			return getRuleContext(AssignableExpressionContext.class,0);
		}
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ParenthesizedAssignableExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parenthesizedAssignableExpression; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParenthesizedAssignableExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParenthesizedAssignableExpressionContext parenthesizedAssignableExpression() throws RecognitionException {
		ParenthesizedAssignableExpressionContext _localctx = new ParenthesizedAssignableExpressionContext(_ctx, getState());
		enterRule(_localctx, 220, RULE_parenthesizedAssignableExpression);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2557);
			match(LPAREN);
			setState(2561);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2558);
				match(NL);
				}
				}
				setState(2563);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2564);
			assignableExpression();
			setState(2568);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2565);
				match(NL);
				}
				}
				setState(2570);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2571);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignableSuffixContext extends ParserRuleContext {
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public IndexingSuffixContext indexingSuffix() {
			return getRuleContext(IndexingSuffixContext.class,0);
		}
		public NavigationSuffixContext navigationSuffix() {
			return getRuleContext(NavigationSuffixContext.class,0);
		}
		public AssignableSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignableSuffix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAssignableSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignableSuffixContext assignableSuffix() throws RecognitionException {
		AssignableSuffixContext _localctx = new AssignableSuffixContext(_ctx, getState());
		enterRule(_localctx, 222, RULE_assignableSuffix);
		try {
			setState(2576);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LANGLE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2573);
				typeArguments();
				}
				break;
			case LSQUARE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2574);
				indexingSuffix();
				}
				break;
			case NL:
			case DOT:
			case COLONCOLON:
			case QUEST_NO_WS:
				enterOuterAlt(_localctx, 3);
				{
				setState(2575);
				navigationSuffix();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IndexingSuffixContext extends ParserRuleContext {
		public TerminalNode LSQUARE() { return getToken(OolangParser.LSQUARE, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public TerminalNode RSQUARE() { return getToken(OolangParser.RSQUARE, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public IndexingSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_indexingSuffix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitIndexingSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IndexingSuffixContext indexingSuffix() throws RecognitionException {
		IndexingSuffixContext _localctx = new IndexingSuffixContext(_ctx, getState());
		enterRule(_localctx, 224, RULE_indexingSuffix);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2578);
			match(LSQUARE);
			setState(2582);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2579);
				match(NL);
				}
				}
				setState(2584);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2585);
			expression();
			setState(2602);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,394,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2589);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2586);
						match(NL);
						}
						}
						setState(2591);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2592);
					match(COMMA);
					setState(2596);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2593);
						match(NL);
						}
						}
						setState(2598);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2599);
					expression();
					}
					} 
				}
				setState(2604);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,394,_ctx);
			}
			setState(2612);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,396,_ctx) ) {
			case 1:
				{
				setState(2608);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2605);
					match(NL);
					}
					}
					setState(2610);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2611);
				match(COMMA);
				}
				break;
			}
			setState(2617);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2614);
				match(NL);
				}
				}
				setState(2619);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2620);
			match(RSQUARE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class NavigationSuffixContext extends ParserRuleContext {
		public MemberAccessOperatorContext memberAccessOperator() {
			return getRuleContext(MemberAccessOperatorContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public ParenthesizedExpressionContext parenthesizedExpression() {
			return getRuleContext(ParenthesizedExpressionContext.class,0);
		}
		public TerminalNode CLASS() { return getToken(OolangParser.CLASS, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public NavigationSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_navigationSuffix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitNavigationSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NavigationSuffixContext navigationSuffix() throws RecognitionException {
		NavigationSuffixContext _localctx = new NavigationSuffixContext(_ctx, getState());
		enterRule(_localctx, 226, RULE_navigationSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2622);
			memberAccessOperator();
			setState(2626);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2623);
				match(NL);
				}
				}
				setState(2628);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2632);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IMPORT:
			case CONSTRUCTOR:
			case BY:
			case INIT:
			case WHERE:
			case CATCH:
			case FINALLY:
			case OUT:
			case FIELD:
			case GET:
			case SET:
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
			case ENUM:
			case SEALED:
			case RECORD:
			case INNER:
			case ANNOTATION:
			case OVERRIDE:
			case ABSTRACT:
			case FINAL:
			case OPEN:
			case STATIC:
			case VARARG:
			case Identifier:
				{
				setState(2629);
				simpleIdentifier();
				}
				break;
			case LPAREN:
				{
				setState(2630);
				parenthesizedExpression();
				}
				break;
			case CLASS:
				{
				setState(2631);
				match(CLASS);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class CallSuffixContext extends ParserRuleContext {
		public AnnotatedLambdaContext annotatedLambda() {
			return getRuleContext(AnnotatedLambdaContext.class,0);
		}
		public ValueArgumentsContext valueArguments() {
			return getRuleContext(ValueArgumentsContext.class,0);
		}
		public TypeArgumentsContext typeArguments() {
			return getRuleContext(TypeArgumentsContext.class,0);
		}
		public CallSuffixContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_callSuffix; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitCallSuffix(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallSuffixContext callSuffix() throws RecognitionException {
		CallSuffixContext _localctx = new CallSuffixContext(_ctx, getState());
		enterRule(_localctx, 228, RULE_callSuffix);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2635);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==LANGLE) {
				{
				setState(2634);
				typeArguments();
				}
			}

			setState(2642);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,402,_ctx) ) {
			case 1:
				{
				setState(2638);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if (_la==LPAREN) {
					{
					setState(2637);
					valueArguments();
					}
				}

				setState(2640);
				annotatedLambda();
				}
				break;
			case 2:
				{
				setState(2641);
				valueArguments();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotatedLambdaContext extends ParserRuleContext {
		public LambdaLiteralContext lambdaLiteral() {
			return getRuleContext(LambdaLiteralContext.class,0);
		}
		public List<SingleAnnotationContext> singleAnnotation() {
			return getRuleContexts(SingleAnnotationContext.class);
		}
		public SingleAnnotationContext singleAnnotation(int i) {
			return getRuleContext(SingleAnnotationContext.class,i);
		}
		public LabelContext label() {
			return getRuleContext(LabelContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public AnnotatedLambdaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotatedLambda; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnnotatedLambda(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotatedLambdaContext annotatedLambda() throws RecognitionException {
		AnnotatedLambdaContext _localctx = new AnnotatedLambdaContext(_ctx, getState());
		enterRule(_localctx, 230, RULE_annotatedLambda);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2647);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0)) {
				{
				{
				setState(2644);
				singleAnnotation();
				}
				}
				setState(2649);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2651);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628424389459968L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255784243430929L) != 0)) {
				{
				setState(2650);
				label();
				}
			}

			setState(2656);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2653);
				match(NL);
				}
				}
				setState(2658);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2659);
			lambdaLiteral();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeArgumentsContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(OolangParser.LANGLE, 0); }
		public List<TypeProjectionContext> typeProjection() {
			return getRuleContexts(TypeProjectionContext.class);
		}
		public TypeProjectionContext typeProjection(int i) {
			return getRuleContext(TypeProjectionContext.class,i);
		}
		public TerminalNode RANGLE() { return getToken(OolangParser.RANGLE, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public TypeArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeArguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeArgumentsContext typeArguments() throws RecognitionException {
		TypeArgumentsContext _localctx = new TypeArgumentsContext(_ctx, getState());
		enterRule(_localctx, 232, RULE_typeArguments);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2661);
			match(LANGLE);
			setState(2665);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2662);
				match(NL);
				}
				}
				setState(2667);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2668);
			typeProjection();
			setState(2685);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,409,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2672);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2669);
						match(NL);
						}
						}
						setState(2674);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2675);
					match(COMMA);
					setState(2679);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2676);
						match(NL);
						}
						}
						setState(2681);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2682);
					typeProjection();
					}
					} 
				}
				setState(2687);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,409,_ctx);
			}
			setState(2695);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,411,_ctx) ) {
			case 1:
				{
				setState(2691);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2688);
					match(NL);
					}
					}
					setState(2693);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2694);
				match(COMMA);
				}
				break;
			}
			setState(2700);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2697);
				match(NL);
				}
				}
				setState(2702);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2703);
			match(RANGLE);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueArgumentsContext extends ParserRuleContext {
		public TerminalNode LPAREN() { return getToken(OolangParser.LPAREN, 0); }
		public TerminalNode RPAREN() { return getToken(OolangParser.RPAREN, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public List<ValueArgumentContext> valueArgument() {
			return getRuleContexts(ValueArgumentContext.class);
		}
		public ValueArgumentContext valueArgument(int i) {
			return getRuleContext(ValueArgumentContext.class,i);
		}
		public List<TerminalNode> COMMA() { return getTokens(OolangParser.COMMA); }
		public TerminalNode COMMA(int i) {
			return getToken(OolangParser.COMMA, i);
		}
		public ValueArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueArguments; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitValueArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueArgumentsContext valueArguments() throws RecognitionException {
		ValueArgumentsContext _localctx = new ValueArgumentsContext(_ctx, getState());
		enterRule(_localctx, 234, RULE_valueArguments);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2705);
			match(LPAREN);
			setState(2709);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,413,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2706);
					match(NL);
					}
					} 
				}
				setState(2711);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,413,_ctx);
			}
			setState(2747);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & -3963167483080321776L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 2016768070690858935L) != 0)) {
				{
				setState(2712);
				valueArgument();
				setState(2729);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,416,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2716);
						_errHandler.sync(this);
						_la = _input.LA(1);
						while (_la==NL) {
							{
							{
							setState(2713);
							match(NL);
							}
							}
							setState(2718);
							_errHandler.sync(this);
							_la = _input.LA(1);
						}
						setState(2719);
						match(COMMA);
						setState(2723);
						_errHandler.sync(this);
						_alt = getInterpreter().adaptivePredict(_input,415,_ctx);
						while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
							if ( _alt==1 ) {
								{
								{
								setState(2720);
								match(NL);
								}
								} 
							}
							setState(2725);
							_errHandler.sync(this);
							_alt = getInterpreter().adaptivePredict(_input,415,_ctx);
						}
						setState(2726);
						valueArgument();
						}
						} 
					}
					setState(2731);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,416,_ctx);
				}
				setState(2739);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,418,_ctx) ) {
				case 1:
					{
					setState(2735);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2732);
						match(NL);
						}
						}
						setState(2737);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2738);
					match(COMMA);
					}
					break;
				}
				setState(2744);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2741);
					match(NL);
					}
					}
					setState(2746);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
			}

			setState(2749);
			match(RPAREN);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ValueArgumentContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SimpleIdentifierContext simpleIdentifier() {
			return getRuleContext(SimpleIdentifierContext.class,0);
		}
		public TerminalNode ASSIGNMENT() { return getToken(OolangParser.ASSIGNMENT, 0); }
		public TerminalNode MULT() { return getToken(OolangParser.MULT, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ValueArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_valueArgument; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitValueArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueArgumentContext valueArgument() throws RecognitionException {
		ValueArgumentContext _localctx = new ValueArgumentContext(_ctx, getState());
		enterRule(_localctx, 236, RULE_valueArgument);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2765);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,423,_ctx) ) {
			case 1:
				{
				setState(2751);
				simpleIdentifier();
				setState(2755);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2752);
					match(NL);
					}
					}
					setState(2757);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2758);
				match(ASSIGNMENT);
				setState(2762);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,422,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2759);
						match(NL);
						}
						} 
					}
					setState(2764);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,422,_ctx);
				}
				}
				break;
			}
			setState(2768);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==MULT) {
				{
				setState(2767);
				match(MULT);
				}
			}

			setState(2773);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==NL) {
				{
				{
				setState(2770);
				match(NL);
				}
				}
				setState(2775);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(2776);
			expression();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AssignmentAndOperatorContext extends ParserRuleContext {
		public TerminalNode ADD_ASSIGNMENT() { return getToken(OolangParser.ADD_ASSIGNMENT, 0); }
		public TerminalNode SUB_ASSIGNMENT() { return getToken(OolangParser.SUB_ASSIGNMENT, 0); }
		public TerminalNode MULT_ASSIGNMENT() { return getToken(OolangParser.MULT_ASSIGNMENT, 0); }
		public TerminalNode DIV_ASSIGNMENT() { return getToken(OolangParser.DIV_ASSIGNMENT, 0); }
		public TerminalNode MOD_ASSIGNMENT() { return getToken(OolangParser.MOD_ASSIGNMENT, 0); }
		public AssignmentAndOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_assignmentAndOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAssignmentAndOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AssignmentAndOperatorContext assignmentAndOperator() throws RecognitionException {
		AssignmentAndOperatorContext _localctx = new AssignmentAndOperatorContext(_ctx, getState());
		enterRule(_localctx, 238, RULE_assignmentAndOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2778);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8321499136L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class EqualityOperatorContext extends ParserRuleContext {
		public TerminalNode EXCL_EQ() { return getToken(OolangParser.EXCL_EQ, 0); }
		public TerminalNode EXCL_EQEQ() { return getToken(OolangParser.EXCL_EQEQ, 0); }
		public TerminalNode EQEQ() { return getToken(OolangParser.EQEQ, 0); }
		public TerminalNode EQEQEQ() { return getToken(OolangParser.EQEQEQ, 0); }
		public EqualityOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_equalityOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitEqualityOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EqualityOperatorContext equalityOperator() throws RecognitionException {
		EqualityOperatorContext _localctx = new EqualityOperatorContext(_ctx, getState());
		enterRule(_localctx, 240, RULE_equalityOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2780);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 3799912185593856L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ComparisonOperatorContext extends ParserRuleContext {
		public TerminalNode LANGLE() { return getToken(OolangParser.LANGLE, 0); }
		public TerminalNode RANGLE() { return getToken(OolangParser.RANGLE, 0); }
		public TerminalNode LE() { return getToken(OolangParser.LE, 0); }
		public TerminalNode GE() { return getToken(OolangParser.GE, 0); }
		public ComparisonOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_comparisonOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitComparisonOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ComparisonOperatorContext comparisonOperator() throws RecognitionException {
		ComparisonOperatorContext _localctx = new ComparisonOperatorContext(_ctx, getState());
		enterRule(_localctx, 242, RULE_comparisonOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2782);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 131941395333120L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IsOperatorContext extends ParserRuleContext {
		public TerminalNode IS() { return getToken(OolangParser.IS, 0); }
		public TerminalNode NOT_IS() { return getToken(OolangParser.NOT_IS, 0); }
		public IsOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_isOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitIsOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IsOperatorContext isOperator() throws RecognitionException {
		IsOperatorContext _localctx = new IsOperatorContext(_ctx, getState());
		enterRule(_localctx, 244, RULE_isOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2784);
			_la = _input.LA(1);
			if ( !(_la==IS || _la==NOT_IS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AdditiveOperatorContext extends ParserRuleContext {
		public TerminalNode ADD() { return getToken(OolangParser.ADD, 0); }
		public TerminalNode SUB() { return getToken(OolangParser.SUB, 0); }
		public AdditiveOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_additiveOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAdditiveOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AdditiveOperatorContext additiveOperator() throws RecognitionException {
		AdditiveOperatorContext _localctx = new AdditiveOperatorContext(_ctx, getState());
		enterRule(_localctx, 246, RULE_additiveOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2786);
			_la = _input.LA(1);
			if ( !(_la==ADD || _la==SUB) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiplicativeOperatorContext extends ParserRuleContext {
		public TerminalNode MULT() { return getToken(OolangParser.MULT, 0); }
		public TerminalNode DIV() { return getToken(OolangParser.DIV, 0); }
		public TerminalNode MOD() { return getToken(OolangParser.MOD, 0); }
		public MultiplicativeOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiplicativeOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMultiplicativeOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiplicativeOperatorContext multiplicativeOperator() throws RecognitionException {
		MultiplicativeOperatorContext _localctx = new MultiplicativeOperatorContext(_ctx, getState());
		enterRule(_localctx, 248, RULE_multiplicativeOperator);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2788);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 114688L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeOperationContext extends ParserRuleContext {
		public TerminalNode AS() { return getToken(OolangParser.AS, 0); }
		public TerminalNode AS_SAFE() { return getToken(OolangParser.AS_SAFE, 0); }
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TypeOperationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeOperation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeOperation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeOperationContext typeOperation() throws RecognitionException {
		TypeOperationContext _localctx = new TypeOperationContext(_ctx, getState());
		enterRule(_localctx, 250, RULE_typeOperation);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2790);
			_la = _input.LA(1);
			if ( !(((((_la - 25)) & ~0x3f) == 0 && ((1L << (_la - 25)) & 72057594054705153L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PrefixUnaryOperatorContext extends ParserRuleContext {
		public TerminalNode INCR() { return getToken(OolangParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(OolangParser.DECR, 0); }
		public TerminalNode SUB() { return getToken(OolangParser.SUB, 0); }
		public TerminalNode ADD() { return getToken(OolangParser.ADD, 0); }
		public ExclContext excl() {
			return getRuleContext(ExclContext.class,0);
		}
		public PrefixUnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prefixUnaryOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPrefixUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PrefixUnaryOperatorContext prefixUnaryOperator() throws RecognitionException {
		PrefixUnaryOperatorContext _localctx = new PrefixUnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 252, RULE_prefixUnaryOperator);
		try {
			setState(2797);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2792);
				match(INCR);
				}
				break;
			case DECR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2793);
				match(DECR);
				}
				break;
			case SUB:
				enterOuterAlt(_localctx, 3);
				{
				setState(2794);
				match(SUB);
				}
				break;
			case ADD:
				enterOuterAlt(_localctx, 4);
				{
				setState(2795);
				match(ADD);
				}
				break;
			case EXCL_WS:
			case EXCL_NO_WS:
				enterOuterAlt(_localctx, 5);
				{
				setState(2796);
				excl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class PostfixUnaryOperatorContext extends ParserRuleContext {
		public TerminalNode INCR() { return getToken(OolangParser.INCR, 0); }
		public TerminalNode DECR() { return getToken(OolangParser.DECR, 0); }
		public TerminalNode EXCL_NO_WS() { return getToken(OolangParser.EXCL_NO_WS, 0); }
		public ExclContext excl() {
			return getRuleContext(ExclContext.class,0);
		}
		public PostfixUnaryOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_postfixUnaryOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitPostfixUnaryOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PostfixUnaryOperatorContext postfixUnaryOperator() throws RecognitionException {
		PostfixUnaryOperatorContext _localctx = new PostfixUnaryOperatorContext(_ctx, getState());
		enterRule(_localctx, 254, RULE_postfixUnaryOperator);
		try {
			setState(2803);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case INCR:
				enterOuterAlt(_localctx, 1);
				{
				setState(2799);
				match(INCR);
				}
				break;
			case DECR:
				enterOuterAlt(_localctx, 2);
				{
				setState(2800);
				match(DECR);
				}
				break;
			case EXCL_NO_WS:
				enterOuterAlt(_localctx, 3);
				{
				setState(2801);
				match(EXCL_NO_WS);
				setState(2802);
				excl();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ExclContext extends ParserRuleContext {
		public TerminalNode EXCL_NO_WS() { return getToken(OolangParser.EXCL_NO_WS, 0); }
		public TerminalNode EXCL_WS() { return getToken(OolangParser.EXCL_WS, 0); }
		public ExclContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_excl; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitExcl(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExclContext excl() throws RecognitionException {
		ExclContext _localctx = new ExclContext(_ctx, getState());
		enterRule(_localctx, 256, RULE_excl);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2805);
			_la = _input.LA(1);
			if ( !(_la==EXCL_WS || _la==EXCL_NO_WS) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberAccessOperatorContext extends ParserRuleContext {
		public TerminalNode DOT() { return getToken(OolangParser.DOT, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SafeNavContext safeNav() {
			return getRuleContext(SafeNavContext.class,0);
		}
		public TerminalNode COLONCOLON() { return getToken(OolangParser.COLONCOLON, 0); }
		public MemberAccessOperatorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberAccessOperator; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMemberAccessOperator(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberAccessOperatorContext memberAccessOperator() throws RecognitionException {
		MemberAccessOperatorContext _localctx = new MemberAccessOperatorContext(_ctx, getState());
		enterRule(_localctx, 258, RULE_memberAccessOperator);
		int _la;
		try {
			setState(2822);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,430,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2810);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2807);
					match(NL);
					}
					}
					setState(2812);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2813);
				match(DOT);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2817);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2814);
					match(NL);
					}
					}
					setState(2819);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2820);
				safeNav();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(2821);
				match(COLONCOLON);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SafeNavContext extends ParserRuleContext {
		public TerminalNode QUEST_NO_WS() { return getToken(OolangParser.QUEST_NO_WS, 0); }
		public TerminalNode DOT() { return getToken(OolangParser.DOT, 0); }
		public SafeNavContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_safeNav; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSafeNav(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SafeNavContext safeNav() throws RecognitionException {
		SafeNavContext _localctx = new SafeNavContext(_ctx, getState());
		enterRule(_localctx, 260, RULE_safeNav);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2824);
			match(QUEST_NO_WS);
			setState(2825);
			match(DOT);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifiersContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public List<ModifierContext> modifier() {
			return getRuleContexts(ModifierContext.class);
		}
		public ModifierContext modifier(int i) {
			return getRuleContext(ModifierContext.class,i);
		}
		public ModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifiersContext modifiers() throws RecognitionException {
		ModifiersContext _localctx = new ModifiersContext(_ctx, getState());
		enterRule(_localctx, 262, RULE_modifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2829); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(2829);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case AT_NO_WS:
					case AT_PRE_WS:
					case FIELD_SITE:
					case PROPERTY_SITE:
					case GET_SITE:
					case SET_SITE:
					case PARAM_SITE:
					case SETPARAM_SITE:
					case DELEGATE_SITE:
						{
						setState(2827);
						annotation();
						}
						break;
					case PUBLIC:
					case PRIVATE:
					case PROTECTED:
					case ENUM:
					case SEALED:
					case VALUE:
					case RECORD:
					case INNER:
					case ANNOTATION:
					case OVERRIDE:
					case ABSTRACT:
					case FINAL:
					case OPEN:
					case STATIC:
					case VARARG:
						{
						setState(2828);
						modifier();
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2831); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,432,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ParameterModifiersContext extends ParserRuleContext {
		public List<AnnotationContext> annotation() {
			return getRuleContexts(AnnotationContext.class);
		}
		public AnnotationContext annotation(int i) {
			return getRuleContext(AnnotationContext.class,i);
		}
		public TerminalNode VARARG() { return getToken(OolangParser.VARARG, 0); }
		public ParameterModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameterModifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitParameterModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParameterModifiersContext parameterModifiers() throws RecognitionException {
		ParameterModifiersContext _localctx = new ParameterModifiersContext(_ctx, getState());
		enterRule(_localctx, 264, RULE_parameterModifiers);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2834); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(2833);
				annotation();
				}
				}
				setState(2836); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( ((((_la - 35)) & ~0x3f) == 0 && ((1L << (_la - 35)) & 2082914827658854405L) != 0) );
			setState(2839);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,434,_ctx) ) {
			case 1:
				{
				setState(2838);
				match(VARARG);
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ModifierContext extends ParserRuleContext {
		public ClassModifierContext classModifier() {
			return getRuleContext(ClassModifierContext.class,0);
		}
		public MemberModifierContext memberModifier() {
			return getRuleContext(MemberModifierContext.class,0);
		}
		public VisibilityModifierContext visibilityModifier() {
			return getRuleContext(VisibilityModifierContext.class,0);
		}
		public InheritanceModifierContext inheritanceModifier() {
			return getRuleContext(InheritanceModifierContext.class,0);
		}
		public TerminalNode VARARG() { return getToken(OolangParser.VARARG, 0); }
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public ModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_modifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ModifierContext modifier() throws RecognitionException {
		ModifierContext _localctx = new ModifierContext(_ctx, getState());
		enterRule(_localctx, 266, RULE_modifier);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2846);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ENUM:
			case SEALED:
			case VALUE:
			case RECORD:
			case INNER:
			case ANNOTATION:
				{
				setState(2841);
				classModifier();
				}
				break;
			case OVERRIDE:
			case STATIC:
				{
				setState(2842);
				memberModifier();
				}
				break;
			case PUBLIC:
			case PRIVATE:
			case PROTECTED:
				{
				setState(2843);
				visibilityModifier();
				}
				break;
			case ABSTRACT:
			case FINAL:
			case OPEN:
				{
				setState(2844);
				inheritanceModifier();
				}
				break;
			case VARARG:
				{
				setState(2845);
				match(VARARG);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(2851);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,436,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2848);
					match(NL);
					}
					} 
				}
				setState(2853);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,436,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ClassModifierContext extends ParserRuleContext {
		public TerminalNode ENUM() { return getToken(OolangParser.ENUM, 0); }
		public TerminalNode SEALED() { return getToken(OolangParser.SEALED, 0); }
		public TerminalNode ANNOTATION() { return getToken(OolangParser.ANNOTATION, 0); }
		public TerminalNode RECORD() { return getToken(OolangParser.RECORD, 0); }
		public TerminalNode INNER() { return getToken(OolangParser.INNER, 0); }
		public TerminalNode VALUE() { return getToken(OolangParser.VALUE, 0); }
		public ClassModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_classModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitClassModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ClassModifierContext classModifier() throws RecognitionException {
		ClassModifierContext _localctx = new ClassModifierContext(_ctx, getState());
		enterRule(_localctx, 268, RULE_classModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2854);
			_la = _input.LA(1);
			if ( !(((((_la - 99)) & ~0x3f) == 0 && ((1L << (_la - 99)) & 63L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MemberModifierContext extends ParserRuleContext {
		public TerminalNode OVERRIDE() { return getToken(OolangParser.OVERRIDE, 0); }
		public TerminalNode STATIC() { return getToken(OolangParser.STATIC, 0); }
		public MemberModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_memberModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMemberModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MemberModifierContext memberModifier() throws RecognitionException {
		MemberModifierContext _localctx = new MemberModifierContext(_ctx, getState());
		enterRule(_localctx, 270, RULE_memberModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2856);
			_la = _input.LA(1);
			if ( !(_la==OVERRIDE || _la==STATIC) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VisibilityModifierContext extends ParserRuleContext {
		public TerminalNode PUBLIC() { return getToken(OolangParser.PUBLIC, 0); }
		public TerminalNode PRIVATE() { return getToken(OolangParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(OolangParser.PROTECTED, 0); }
		public VisibilityModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_visibilityModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitVisibilityModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VisibilityModifierContext visibilityModifier() throws RecognitionException {
		VisibilityModifierContext _localctx = new VisibilityModifierContext(_ctx, getState());
		enterRule(_localctx, 272, RULE_visibilityModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2858);
			_la = _input.LA(1);
			if ( !(((((_la - 96)) & ~0x3f) == 0 && ((1L << (_la - 96)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class VarianceModifierContext extends ParserRuleContext {
		public TerminalNode IN() { return getToken(OolangParser.IN, 0); }
		public TerminalNode OUT() { return getToken(OolangParser.OUT, 0); }
		public VarianceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_varianceModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitVarianceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VarianceModifierContext varianceModifier() throws RecognitionException {
		VarianceModifierContext _localctx = new VarianceModifierContext(_ctx, getState());
		enterRule(_localctx, 274, RULE_varianceModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2860);
			_la = _input.LA(1);
			if ( !(_la==IN || _la==OUT) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterModifiersContext extends ParserRuleContext {
		public List<TypeParameterModifierContext> typeParameterModifier() {
			return getRuleContexts(TypeParameterModifierContext.class);
		}
		public TypeParameterModifierContext typeParameterModifier(int i) {
			return getRuleContext(TypeParameterModifierContext.class,i);
		}
		public TypeParameterModifiersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterModifiers; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeParameterModifiers(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterModifiersContext typeParameterModifiers() throws RecognitionException {
		TypeParameterModifiersContext _localctx = new TypeParameterModifiersContext(_ctx, getState());
		enterRule(_localctx, 276, RULE_typeParameterModifiers);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2863); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(2862);
					typeParameterModifier();
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(2865); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,437,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class TypeParameterModifierContext extends ParserRuleContext {
		public VarianceModifierContext varianceModifier() {
			return getRuleContext(VarianceModifierContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public SingleAnnotationContext singleAnnotation() {
			return getRuleContext(SingleAnnotationContext.class,0);
		}
		public TypeParameterModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeParameterModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitTypeParameterModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeParameterModifierContext typeParameterModifier() throws RecognitionException {
		TypeParameterModifierContext _localctx = new TypeParameterModifierContext(_ctx, getState());
		enterRule(_localctx, 278, RULE_typeParameterModifier);
		try {
			int _alt;
			setState(2875);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IN:
			case OUT:
				enterOuterAlt(_localctx, 1);
				{
				setState(2867);
				varianceModifier();
				setState(2871);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,438,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2868);
						match(NL);
						}
						} 
					}
					setState(2873);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,438,_ctx);
				}
				}
				break;
			case AT_NO_WS:
			case AT_PRE_WS:
			case FIELD_SITE:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
				enterOuterAlt(_localctx, 2);
				{
				setState(2874);
				singleAnnotation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class InheritanceModifierContext extends ParserRuleContext {
		public TerminalNode ABSTRACT() { return getToken(OolangParser.ABSTRACT, 0); }
		public TerminalNode FINAL() { return getToken(OolangParser.FINAL, 0); }
		public TerminalNode OPEN() { return getToken(OolangParser.OPEN, 0); }
		public InheritanceModifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inheritanceModifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitInheritanceModifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InheritanceModifierContext inheritanceModifier() throws RecognitionException {
		InheritanceModifierContext _localctx = new InheritanceModifierContext(_ctx, getState());
		enterRule(_localctx, 280, RULE_inheritanceModifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2877);
			_la = _input.LA(1);
			if ( !(((((_la - 106)) & ~0x3f) == 0 && ((1L << (_la - 106)) & 7L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationContext extends ParserRuleContext {
		public SingleAnnotationContext singleAnnotation() {
			return getRuleContext(SingleAnnotationContext.class,0);
		}
		public MultiAnnotationsContext multiAnnotations() {
			return getRuleContext(MultiAnnotationsContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public AnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationContext annotation() throws RecognitionException {
		AnnotationContext _localctx = new AnnotationContext(_ctx, getState());
		enterRule(_localctx, 282, RULE_annotation);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2881);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,440,_ctx) ) {
			case 1:
				{
				setState(2879);
				singleAnnotation();
				}
				break;
			case 2:
				{
				setState(2880);
				multiAnnotations();
				}
				break;
			}
			setState(2886);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,441,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2883);
					match(NL);
					}
					} 
				}
				setState(2888);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,441,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SingleAnnotationContext extends ParserRuleContext {
		public AnnotationUseSiteTargetContext annotationUseSiteTarget() {
			return getRuleContext(AnnotationUseSiteTargetContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public UnescapedAnnotationContext unescapedAnnotation() {
			return getRuleContext(UnescapedAnnotationContext.class,0);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode AT_NO_WS() { return getToken(OolangParser.AT_NO_WS, 0); }
		public TerminalNode AT_PRE_WS() { return getToken(OolangParser.AT_PRE_WS, 0); }
		public SingleAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSingleAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleAnnotationContext singleAnnotation() throws RecognitionException {
		SingleAnnotationContext _localctx = new SingleAnnotationContext(_ctx, getState());
		enterRule(_localctx, 284, RULE_singleAnnotation);
		int _la;
		try {
			setState(2907);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIELD_SITE:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2889);
				annotationUseSiteTarget();
				setState(2893);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2890);
					match(NL);
					}
					}
					setState(2895);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2896);
				match(COLON);
				setState(2900);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2897);
					match(NL);
					}
					}
					setState(2902);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2903);
				unescapedAnnotation();
				}
				break;
			case AT_NO_WS:
			case AT_PRE_WS:
				enterOuterAlt(_localctx, 2);
				{
				setState(2905);
				_la = _input.LA(1);
				if ( !(_la==AT_NO_WS || _la==AT_PRE_WS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2906);
				unescapedAnnotation();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class MultiAnnotationsContext extends ParserRuleContext {
		public AnnotationUseSiteTargetContext annotationUseSiteTarget() {
			return getRuleContext(AnnotationUseSiteTargetContext.class,0);
		}
		public TerminalNode COLON() { return getToken(OolangParser.COLON, 0); }
		public TerminalNode LSQUARE() { return getToken(OolangParser.LSQUARE, 0); }
		public TerminalNode RSQUARE() { return getToken(OolangParser.RSQUARE, 0); }
		public List<UnescapedAnnotationContext> unescapedAnnotation() {
			return getRuleContexts(UnescapedAnnotationContext.class);
		}
		public UnescapedAnnotationContext unescapedAnnotation(int i) {
			return getRuleContext(UnescapedAnnotationContext.class,i);
		}
		public TerminalNode AT_NO_WS() { return getToken(OolangParser.AT_NO_WS, 0); }
		public TerminalNode AT_PRE_WS() { return getToken(OolangParser.AT_PRE_WS, 0); }
		public MultiAnnotationsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_multiAnnotations; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitMultiAnnotations(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MultiAnnotationsContext multiAnnotations() throws RecognitionException {
		MultiAnnotationsContext _localctx = new MultiAnnotationsContext(_ctx, getState());
		enterRule(_localctx, 286, RULE_multiAnnotations);
		int _la;
		try {
			setState(2928);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case FIELD_SITE:
			case PROPERTY_SITE:
			case GET_SITE:
			case SET_SITE:
			case PARAM_SITE:
			case SETPARAM_SITE:
			case DELEGATE_SITE:
				enterOuterAlt(_localctx, 1);
				{
				setState(2909);
				annotationUseSiteTarget();
				setState(2910);
				match(COLON);
				setState(2911);
				match(LSQUARE);
				setState(2913); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2912);
					unescapedAnnotation();
					}
					}
					setState(2915); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628424389459968L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255784243430929L) != 0) );
				setState(2917);
				match(RSQUARE);
				}
				break;
			case AT_NO_WS:
			case AT_PRE_WS:
				enterOuterAlt(_localctx, 2);
				{
				setState(2919);
				_la = _input.LA(1);
				if ( !(_la==AT_NO_WS || _la==AT_PRE_WS) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(2920);
				match(LSQUARE);
				setState(2922); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(2921);
					unescapedAnnotation();
					}
					}
					setState(2924); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628424389459968L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255784243430929L) != 0) );
				setState(2926);
				match(RSQUARE);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnnotationUseSiteTargetContext extends ParserRuleContext {
		public TerminalNode FIELD_SITE() { return getToken(OolangParser.FIELD_SITE, 0); }
		public TerminalNode PROPERTY_SITE() { return getToken(OolangParser.PROPERTY_SITE, 0); }
		public TerminalNode GET_SITE() { return getToken(OolangParser.GET_SITE, 0); }
		public TerminalNode SET_SITE() { return getToken(OolangParser.SET_SITE, 0); }
		public TerminalNode PARAM_SITE() { return getToken(OolangParser.PARAM_SITE, 0); }
		public TerminalNode SETPARAM_SITE() { return getToken(OolangParser.SETPARAM_SITE, 0); }
		public TerminalNode DELEGATE_SITE() { return getToken(OolangParser.DELEGATE_SITE, 0); }
		public AnnotationUseSiteTargetContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_annotationUseSiteTarget; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnnotationUseSiteTarget(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnnotationUseSiteTargetContext annotationUseSiteTarget() throws RecognitionException {
		AnnotationUseSiteTargetContext _localctx = new AnnotationUseSiteTargetContext(_ctx, getState());
		enterRule(_localctx, 288, RULE_annotationUseSiteTarget);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2930);
			_la = _input.LA(1);
			if ( !(((((_la - 86)) & ~0x3f) == 0 && ((1L << (_la - 86)) & 925L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class UnescapedAnnotationContext extends ParserRuleContext {
		public ConstructorInvocationContext constructorInvocation() {
			return getRuleContext(ConstructorInvocationContext.class,0);
		}
		public UserTypeContext userType() {
			return getRuleContext(UserTypeContext.class,0);
		}
		public UnescapedAnnotationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unescapedAnnotation; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitUnescapedAnnotation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnescapedAnnotationContext unescapedAnnotation() throws RecognitionException {
		UnescapedAnnotationContext _localctx = new UnescapedAnnotationContext(_ctx, getState());
		enterRule(_localctx, 290, RULE_unescapedAnnotation);
		try {
			setState(2934);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,448,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2932);
				constructorInvocation();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2933);
				userType();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SimpleIdentifierContext extends ParserRuleContext {
		public TerminalNode Identifier() { return getToken(OolangParser.Identifier, 0); }
		public TerminalNode ABSTRACT() { return getToken(OolangParser.ABSTRACT, 0); }
		public TerminalNode ANNOTATION() { return getToken(OolangParser.ANNOTATION, 0); }
		public TerminalNode BY() { return getToken(OolangParser.BY, 0); }
		public TerminalNode CATCH() { return getToken(OolangParser.CATCH, 0); }
		public TerminalNode CONSTRUCTOR() { return getToken(OolangParser.CONSTRUCTOR, 0); }
		public TerminalNode RECORD() { return getToken(OolangParser.RECORD, 0); }
		public TerminalNode ENUM() { return getToken(OolangParser.ENUM, 0); }
		public TerminalNode FIELD() { return getToken(OolangParser.FIELD, 0); }
		public TerminalNode FINAL() { return getToken(OolangParser.FINAL, 0); }
		public TerminalNode FINALLY() { return getToken(OolangParser.FINALLY, 0); }
		public TerminalNode GET() { return getToken(OolangParser.GET, 0); }
		public TerminalNode IMPORT() { return getToken(OolangParser.IMPORT, 0); }
		public TerminalNode INIT() { return getToken(OolangParser.INIT, 0); }
		public TerminalNode INNER() { return getToken(OolangParser.INNER, 0); }
		public TerminalNode OPEN() { return getToken(OolangParser.OPEN, 0); }
		public TerminalNode OUT() { return getToken(OolangParser.OUT, 0); }
		public TerminalNode OVERRIDE() { return getToken(OolangParser.OVERRIDE, 0); }
		public TerminalNode PRIVATE() { return getToken(OolangParser.PRIVATE, 0); }
		public TerminalNode PROTECTED() { return getToken(OolangParser.PROTECTED, 0); }
		public TerminalNode PUBLIC() { return getToken(OolangParser.PUBLIC, 0); }
		public TerminalNode SEALED() { return getToken(OolangParser.SEALED, 0); }
		public TerminalNode SET() { return getToken(OolangParser.SET, 0); }
		public TerminalNode STATIC() { return getToken(OolangParser.STATIC, 0); }
		public TerminalNode VARARG() { return getToken(OolangParser.VARARG, 0); }
		public TerminalNode WHERE() { return getToken(OolangParser.WHERE, 0); }
		public SimpleIdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_simpleIdentifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSimpleIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SimpleIdentifierContext simpleIdentifier() throws RecognitionException {
		SimpleIdentifierContext _localctx = new SimpleIdentifierContext(_ctx, getState());
		enterRule(_localctx, 292, RULE_simpleIdentifier);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2936);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & -4539628424389459968L) != 0) || ((((_la - 64)) & ~0x3f) == 0 && ((1L << (_la - 64)) & 144255784243430929L) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class IdentifierContext extends ParserRuleContext {
		public List<SimpleIdentifierContext> simpleIdentifier() {
			return getRuleContexts(SimpleIdentifierContext.class);
		}
		public SimpleIdentifierContext simpleIdentifier(int i) {
			return getRuleContext(SimpleIdentifierContext.class,i);
		}
		public List<TerminalNode> DOT() { return getTokens(OolangParser.DOT); }
		public TerminalNode DOT(int i) {
			return getToken(OolangParser.DOT, i);
		}
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public IdentifierContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_identifier; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitIdentifier(this);
			else return visitor.visitChildren(this);
		}
	}

	public final IdentifierContext identifier() throws RecognitionException {
		IdentifierContext _localctx = new IdentifierContext(_ctx, getState());
		enterRule(_localctx, 294, RULE_identifier);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(2938);
			simpleIdentifier();
			setState(2949);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,450,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(2942);
					_errHandler.sync(this);
					_la = _input.LA(1);
					while (_la==NL) {
						{
						{
						setState(2939);
						match(NL);
						}
						}
						setState(2944);
						_errHandler.sync(this);
						_la = _input.LA(1);
					}
					setState(2945);
					match(DOT);
					setState(2946);
					simpleIdentifier();
					}
					} 
				}
				setState(2951);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,450,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class SemiContext extends ParserRuleContext {
		public List<TerminalNode> NL() { return getTokens(OolangParser.NL); }
		public TerminalNode NL(int i) {
			return getToken(OolangParser.NL, i);
		}
		public TerminalNode SEMICOLON() { return getToken(OolangParser.SEMICOLON, 0); }
		public SemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_semi; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitSemi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SemiContext semi() throws RecognitionException {
		SemiContext _localctx = new SemiContext(_ctx, getState());
		enterRule(_localctx, 296, RULE_semi);
		int _la;
		try {
			int _alt;
			setState(2970);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,454,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(2953); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(2952);
						match(NL);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(2955); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,451,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(2960);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==NL) {
					{
					{
					setState(2957);
					match(NL);
					}
					}
					setState(2962);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(2963);
				match(SEMICOLON);
				setState(2967);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,453,_ctx);
				while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1 ) {
						{
						{
						setState(2964);
						match(NL);
						}
						} 
					}
					setState(2969);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,453,_ctx);
				}
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	@SuppressWarnings("CheckReturnValue")
	public static class AnysemiContext extends ParserRuleContext {
		public TerminalNode NL() { return getToken(OolangParser.NL, 0); }
		public TerminalNode SEMICOLON() { return getToken(OolangParser.SEMICOLON, 0); }
		public AnysemiContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_anysemi; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof OolangParserVisitor ) return ((OolangParserVisitor<? extends T>)visitor).visitAnysemi(this);
			else return visitor.visitChildren(this);
		}
	}

	public final AnysemiContext anysemi() throws RecognitionException {
		AnysemiContext _localctx = new AnysemiContext(_ctx, getState());
		enterRule(_localctx, 298, RULE_anysemi);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(2972);
			_la = _input.LA(1);
			if ( !(_la==NL || _la==SEMICOLON) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	private static final String _serializedATNSegment0 =
		"\u0004\u0001\u0093\u0b9f\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001"+
		"\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004"+
		"\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007"+
		"\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b"+
		"\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002\u000f\u0007"+
		"\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0002\u0012\u0007"+
		"\u0012\u0002\u0013\u0007\u0013\u0002\u0014\u0007\u0014\u0002\u0015\u0007"+
		"\u0015\u0002\u0016\u0007\u0016\u0002\u0017\u0007\u0017\u0002\u0018\u0007"+
		"\u0018\u0002\u0019\u0007\u0019\u0002\u001a\u0007\u001a\u0002\u001b\u0007"+
		"\u001b\u0002\u001c\u0007\u001c\u0002\u001d\u0007\u001d\u0002\u001e\u0007"+
		"\u001e\u0002\u001f\u0007\u001f\u0002 \u0007 \u0002!\u0007!\u0002\"\u0007"+
		"\"\u0002#\u0007#\u0002$\u0007$\u0002%\u0007%\u0002&\u0007&\u0002\'\u0007"+
		"\'\u0002(\u0007(\u0002)\u0007)\u0002*\u0007*\u0002+\u0007+\u0002,\u0007"+
		",\u0002-\u0007-\u0002.\u0007.\u0002/\u0007/\u00020\u00070\u00021\u0007"+
		"1\u00022\u00072\u00023\u00073\u00024\u00074\u00025\u00075\u00026\u0007"+
		"6\u00027\u00077\u00028\u00078\u00029\u00079\u0002:\u0007:\u0002;\u0007"+
		";\u0002<\u0007<\u0002=\u0007=\u0002>\u0007>\u0002?\u0007?\u0002@\u0007"+
		"@\u0002A\u0007A\u0002B\u0007B\u0002C\u0007C\u0002D\u0007D\u0002E\u0007"+
		"E\u0002F\u0007F\u0002G\u0007G\u0002H\u0007H\u0002I\u0007I\u0002J\u0007"+
		"J\u0002K\u0007K\u0002L\u0007L\u0002M\u0007M\u0002N\u0007N\u0002O\u0007"+
		"O\u0002P\u0007P\u0002Q\u0007Q\u0002R\u0007R\u0002S\u0007S\u0002T\u0007"+
		"T\u0002U\u0007U\u0002V\u0007V\u0002W\u0007W\u0002X\u0007X\u0002Y\u0007"+
		"Y\u0002Z\u0007Z\u0002[\u0007[\u0002\\\u0007\\\u0002]\u0007]\u0002^\u0007"+
		"^\u0002_\u0007_\u0002`\u0007`\u0002a\u0007a\u0002b\u0007b\u0002c\u0007"+
		"c\u0002d\u0007d\u0002e\u0007e\u0002f\u0007f\u0002g\u0007g\u0002h\u0007"+
		"h\u0002i\u0007i\u0002j\u0007j\u0002k\u0007k\u0002l\u0007l\u0002m\u0007"+
		"m\u0002n\u0007n\u0002o\u0007o\u0002p\u0007p\u0002q\u0007q\u0002r\u0007"+
		"r\u0002s\u0007s\u0002t\u0007t\u0002u\u0007u\u0002v\u0007v\u0002w\u0007"+
		"w\u0002x\u0007x\u0002y\u0007y\u0002z\u0007z\u0002{\u0007{\u0002|\u0007"+
		"|\u0002}\u0007}\u0002~\u0007~\u0002\u007f\u0007\u007f\u0002\u0080\u0007"+
		"\u0080\u0002\u0081\u0007\u0081\u0002\u0082\u0007\u0082\u0002\u0083\u0007"+
		"\u0083\u0002\u0084\u0007\u0084\u0002\u0085\u0007\u0085\u0002\u0086\u0007"+
		"\u0086\u0002\u0087\u0007\u0087\u0002\u0088\u0007\u0088\u0002\u0089\u0007"+
		"\u0089\u0002\u008a\u0007\u008a\u0002\u008b\u0007\u008b\u0002\u008c\u0007"+
		"\u008c\u0002\u008d\u0007\u008d\u0002\u008e\u0007\u008e\u0002\u008f\u0007"+
		"\u008f\u0002\u0090\u0007\u0090\u0002\u0091\u0007\u0091\u0002\u0092\u0007"+
		"\u0092\u0002\u0093\u0007\u0093\u0002\u0094\u0007\u0094\u0002\u0095\u0007"+
		"\u0095\u0001\u0000\u0003\u0000\u012e\b\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0132\b\u0000\n\u0000\f\u0000\u0135\t\u0000\u0001\u0000\u0001\u0000"+
		"\u0004\u0000\u0139\b\u0000\u000b\u0000\f\u0000\u013a\u0001\u0000\u0003"+
		"\u0000\u013e\b\u0000\u0005\u0000\u0140\b\u0000\n\u0000\f\u0000\u0143\t"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003"+
		"\u0001\u014a\b\u0001\u0001\u0002\u0005\u0002\u014d\b\u0002\n\u0002\f\u0002"+
		"\u0150\t\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0003\u0003\u0155\b"+
		"\u0003\u0001\u0003\u0003\u0003\u0158\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005\u0160\b\u0005\u0001"+
		"\u0006\u0003\u0006\u0163\b\u0006\u0001\u0006\u0001\u0006\u0001\u0006\u0005"+
		"\u0006\u0168\b\u0006\n\u0006\f\u0006\u016b\t\u0006\u0003\u0006\u016d\b"+
		"\u0006\u0001\u0006\u0003\u0006\u0170\b\u0006\u0001\u0006\u0005\u0006\u0173"+
		"\b\u0006\n\u0006\f\u0006\u0176\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u017a\b\u0006\n\u0006\f\u0006\u017d\t\u0006\u0001\u0006\u0003\u0006\u0180"+
		"\b\u0006\u0001\u0006\u0005\u0006\u0183\b\u0006\n\u0006\f\u0006\u0186\t"+
		"\u0006\u0001\u0006\u0003\u0006\u0189\b\u0006\u0001\u0006\u0005\u0006\u018c"+
		"\b\u0006\n\u0006\f\u0006\u018f\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u0193\b\u0006\n\u0006\f\u0006\u0196\t\u0006\u0001\u0006\u0003\u0006\u0199"+
		"\b\u0006\u0001\u0006\u0005\u0006\u019c\b\u0006\n\u0006\f\u0006\u019f\t"+
		"\u0006\u0001\u0006\u0003\u0006\u01a2\b\u0006\u0001\u0006\u0005\u0006\u01a5"+
		"\b\u0006\n\u0006\f\u0006\u01a8\t\u0006\u0001\u0006\u0001\u0006\u0005\u0006"+
		"\u01ac\b\u0006\n\u0006\f\u0006\u01af\t\u0006\u0001\u0006\u0003\u0006\u01b2"+
		"\b\u0006\u0001\u0007\u0003\u0007\u01b5\b\u0007\u0001\u0007\u0001\u0007"+
		"\u0005\u0007\u01b9\b\u0007\n\u0007\f\u0007\u01bc\t\u0007\u0003\u0007\u01be"+
		"\b\u0007\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0005\b\u01c4\b\b\n\b"+
		"\f\b\u01c7\t\b\u0001\b\u0001\b\u0005\b\u01cb\b\b\n\b\f\b\u01ce\t\b\u0001"+
		"\b\u0001\b\u0005\b\u01d2\b\b\n\b\f\b\u01d5\t\b\u0001\b\u0005\b\u01d8\b"+
		"\b\n\b\f\b\u01db\t\b\u0001\b\u0005\b\u01de\b\b\n\b\f\b\u01e1\t\b\u0001"+
		"\b\u0003\b\u01e4\b\b\u0003\b\u01e6\b\b\u0001\b\u0005\b\u01e9\b\b\n\b\f"+
		"\b\u01ec\t\b\u0001\b\u0001\b\u0001\t\u0003\t\u01f1\b\t\u0001\t\u0003\t"+
		"\u01f4\b\t\u0001\t\u0005\t\u01f7\b\t\n\t\f\t\u01fa\t\t\u0001\t\u0001\t"+
		"\u0001\t\u0005\t\u01ff\b\t\n\t\f\t\u0202\t\t\u0001\t\u0001\t\u0005\t\u0206"+
		"\b\t\n\t\f\t\u0209\t\t\u0001\t\u0001\t\u0005\t\u020d\b\t\n\t\f\t\u0210"+
		"\t\t\u0001\t\u0003\t\u0213\b\t\u0001\n\u0001\n\u0005\n\u0217\b\n\n\n\f"+
		"\n\u021a\t\n\u0001\n\u0001\n\u0005\n\u021e\b\n\n\n\f\n\u0221\t\n\u0001"+
		"\n\u0005\n\u0224\b\n\n\n\f\n\u0227\t\n\u0001\u000b\u0005\u000b\u022a\b"+
		"\u000b\n\u000b\f\u000b\u022d\t\u000b\u0001\u000b\u0005\u000b\u0230\b\u000b"+
		"\n\u000b\f\u000b\u0233\t\u000b\u0001\u000b\u0001\u000b\u0001\f\u0001\f"+
		"\u0001\f\u0001\f\u0003\f\u023b\b\f\u0001\r\u0001\r\u0005\r\u023f\b\r\n"+
		"\r\f\r\u0242\t\r\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0003\u000e\u0248"+
		"\b\u000e\u0001\u000e\u0005\u000e\u024b\b\u000e\n\u000e\f\u000e\u024e\t"+
		"\u000e\u0001\u000e\u0001\u000e\u0005\u000e\u0252\b\u000e\n\u000e\f\u000e"+
		"\u0255\t\u000e\u0001\u000e\u0001\u000e\u0001\u000f\u0001\u000f\u0005\u000f"+
		"\u025b\b\u000f\n\u000f\f\u000f\u025e\t\u000f\u0001\u000f\u0005\u000f\u0261"+
		"\b\u000f\n\u000f\f\u000f\u0264\t\u000f\u0001\u000f\u0005\u000f\u0267\b"+
		"\u000f\n\u000f\f\u000f\u026a\t\u000f\u0001\u000f\u0001\u000f\u0001\u0010"+
		"\u0001\u0010\u0005\u0010\u0270\b\u0010\n\u0010\f\u0010\u0273\t\u0010\u0001"+
		"\u0010\u0001\u0010\u0005\u0010\u0277\b\u0010\n\u0010\f\u0010\u027a\t\u0010"+
		"\u0001\u0010\u0001\u0010\u0005\u0010\u027e\b\u0010\n\u0010\f\u0010\u0281"+
		"\t\u0010\u0001\u0010\u0005\u0010\u0284\b\u0010\n\u0010\f\u0010\u0287\t"+
		"\u0010\u0001\u0010\u0005\u0010\u028a\b\u0010\n\u0010\f\u0010\u028d\t\u0010"+
		"\u0001\u0010\u0003\u0010\u0290\b\u0010\u0001\u0010\u0005\u0010\u0293\b"+
		"\u0010\n\u0010\f\u0010\u0296\t\u0010\u0001\u0010\u0001\u0010\u0001\u0011"+
		"\u0003\u0011\u029b\b\u0011\u0001\u0011\u0005\u0011\u029e\b\u0011\n\u0011"+
		"\f\u0011\u02a1\t\u0011\u0001\u0011\u0001\u0011\u0003\u0011\u02a5\b\u0011"+
		"\u0001\u0011\u0005\u0011\u02a8\b\u0011\n\u0011\f\u0011\u02ab\t\u0011\u0001"+
		"\u0011\u0001\u0011\u0005\u0011\u02af\b\u0011\n\u0011\f\u0011\u02b2\t\u0011"+
		"\u0001\u0011\u0003\u0011\u02b5\b\u0011\u0001\u0012\u0001\u0012\u0005\u0012"+
		"\u02b9\b\u0012\n\u0012\f\u0012\u02bc\t\u0012\u0001\u0012\u0001\u0012\u0005"+
		"\u0012\u02c0\b\u0012\n\u0012\f\u0012\u02c3\t\u0012\u0001\u0012\u0001\u0012"+
		"\u0005\u0012\u02c7\b\u0012\n\u0012\f\u0012\u02ca\t\u0012\u0001\u0012\u0005"+
		"\u0012\u02cd\b\u0012\n\u0012\f\u0012\u02d0\t\u0012\u0001\u0013\u0005\u0013"+
		"\u02d3\b\u0013\n\u0013\f\u0013\u02d6\t\u0013\u0001\u0013\u0001\u0013\u0005"+
		"\u0013\u02da\b\u0013\n\u0013\f\u0013\u02dd\t\u0013\u0001\u0013\u0001\u0013"+
		"\u0005\u0013\u02e1\b\u0013\n\u0013\f\u0013\u02e4\t\u0013\u0001\u0013\u0001"+
		"\u0013\u0001\u0014\u0001\u0014\u0001\u0014\u0003\u0014\u02eb\b\u0014\u0001"+
		"\u0014\u0004\u0014\u02ee\b\u0014\u000b\u0014\f\u0014\u02ef\u0001\u0015"+
		"\u0001\u0015\u0005\u0015\u02f4\b\u0015\n\u0015\f\u0015\u02f7\t\u0015\u0001"+
		"\u0015\u0001\u0015\u0001\u0016\u0003\u0016\u02fc\b\u0016\u0001\u0016\u0001"+
		"\u0016\u0005\u0016\u0300\b\u0016\n\u0016\f\u0016\u0303\t\u0016\u0001\u0016"+
		"\u0001\u0016\u0005\u0016\u0307\b\u0016\n\u0016\f\u0016\u030a\t\u0016\u0001"+
		"\u0016\u0001\u0016\u0005\u0016\u030e\b\u0016\n\u0016\f\u0016\u0311\t\u0016"+
		"\u0001\u0016\u0003\u0016\u0314\b\u0016\u0001\u0016\u0005\u0016\u0317\b"+
		"\u0016\n\u0016\f\u0016\u031a\t\u0016\u0001\u0016\u0003\u0016\u031d\b\u0016"+
		"\u0001\u0017\u0001\u0017\u0005\u0017\u0321\b\u0017\n\u0017\f\u0017\u0324"+
		"\t\u0017\u0001\u0017\u0001\u0017\u0001\u0018\u0003\u0018\u0329\b\u0018"+
		"\u0001\u0018\u0001\u0018\u0005\u0018\u032d\b\u0018\n\u0018\f\u0018\u0330"+
		"\t\u0018\u0001\u0018\u0003\u0018\u0333\b\u0018\u0001\u0018\u0005\u0018"+
		"\u0336\b\u0018\n\u0018\f\u0018\u0339\t\u0018\u0001\u0018\u0001\u0018\u0005"+
		"\u0018\u033d\b\u0018\n\u0018\f\u0018\u0340\t\u0018\u0001\u0018\u0001\u0018"+
		"\u0003\u0018\u0344\b\u0018\u0001\u0018\u0005\u0018\u0347\b\u0018\n\u0018"+
		"\f\u0018\u034a\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u034e\b\u0018"+
		"\n\u0018\f\u0018\u0351\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018\u0355"+
		"\b\u0018\n\u0018\f\u0018\u0358\t\u0018\u0001\u0018\u0001\u0018\u0005\u0018"+
		"\u035c\b\u0018\n\u0018\f\u0018\u035f\t\u0018\u0001\u0018\u0003\u0018\u0362"+
		"\b\u0018\u0001\u0018\u0005\u0018\u0365\b\u0018\n\u0018\f\u0018\u0368\t"+
		"\u0018\u0001\u0018\u0003\u0018\u036b\b\u0018\u0001\u0018\u0005\u0018\u036e"+
		"\b\u0018\n\u0018\f\u0018\u0371\t\u0018\u0001\u0018\u0003\u0018\u0374\b"+
		"\u0018\u0001\u0019\u0001\u0019\u0005\u0019\u0378\b\u0019\n\u0019\f\u0019"+
		"\u037b\t\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u037f\b\u0019\n\u0019"+
		"\f\u0019\u0382\t\u0019\u0001\u0019\u0001\u0019\u0005\u0019\u0386\b\u0019"+
		"\n\u0019\f\u0019\u0389\t\u0019\u0001\u0019\u0005\u0019\u038c\b\u0019\n"+
		"\u0019\f\u0019\u038f\t\u0019\u0001\u0019\u0005\u0019\u0392\b\u0019\n\u0019"+
		"\f\u0019\u0395\t\u0019\u0001\u0019\u0003\u0019\u0398\b\u0019\u0003\u0019"+
		"\u039a\b\u0019\u0001\u0019\u0005\u0019\u039d\b\u0019\n\u0019\f\u0019\u03a0"+
		"\t\u0019\u0001\u0019\u0001\u0019\u0001\u001a\u0003\u001a\u03a5\b\u001a"+
		"\u0001\u001a\u0001\u001a\u0005\u001a\u03a9\b\u001a\n\u001a\f\u001a\u03ac"+
		"\t\u001a\u0001\u001a\u0001\u001a\u0005\u001a\u03b0\b\u001a\n\u001a\f\u001a"+
		"\u03b3\t\u001a\u0001\u001a\u0003\u001a\u03b6\b\u001a\u0001\u001b\u0001"+
		"\u001b\u0001\u001b\u0005\u001b\u03bb\b\u001b\n\u001b\f\u001b\u03be\t\u001b"+
		"\u0001\u001b\u0003\u001b\u03c1\b\u001b\u0001\u001c\u0003\u001c\u03c4\b"+
		"\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u03c8\b\u001c\n\u001c\f\u001c"+
		"\u03cb\t\u001c\u0001\u001c\u0003\u001c\u03ce\b\u001c\u0001\u001c\u0005"+
		"\u001c\u03d1\b\u001c\n\u001c\f\u001c\u03d4\t\u001c\u0001\u001c\u0001\u001c"+
		"\u0005\u001c\u03d8\b\u001c\n\u001c\f\u001c\u03db\t\u001c\u0001\u001c\u0001"+
		"\u001c\u0003\u001c\u03df\b\u001c\u0001\u001c\u0005\u001c\u03e2\b\u001c"+
		"\n\u001c\f\u001c\u03e5\t\u001c\u0001\u001c\u0001\u001c\u0001\u001c\u0005"+
		"\u001c\u03ea\b\u001c\n\u001c\f\u001c\u03ed\t\u001c\u0001\u001c\u0003\u001c"+
		"\u03f0\b\u001c\u0001\u001c\u0005\u001c\u03f3\b\u001c\n\u001c\f\u001c\u03f6"+
		"\t\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u03fa\b\u001c\n\u001c\f\u001c"+
		"\u03fd\t\u001c\u0001\u001c\u0003\u001c\u0400\b\u001c\u0001\u001c\u0005"+
		"\u001c\u0403\b\u001c\n\u001c\f\u001c\u0406\t\u001c\u0001\u001c\u0003\u001c"+
		"\u0409\b\u001c\u0001\u001c\u0005\u001c\u040c\b\u001c\n\u001c\f\u001c\u040f"+
		"\t\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0413\b\u001c\n\u001c\f\u001c"+
		"\u0416\t\u001c\u0001\u001c\u0003\u001c\u0419\b\u001c\u0001\u001c\u0003"+
		"\u001c\u041c\b\u001c\u0001\u001c\u0001\u001c\u0005\u001c\u0420\b\u001c"+
		"\n\u001c\f\u001c\u0423\t\u001c\u0001\u001c\u0003\u001c\u0426\b\u001c\u0001"+
		"\u001c\u0001\u001c\u0003\u001c\u042a\b\u001c\u0001\u001d\u0005\u001d\u042d"+
		"\b\u001d\n\u001d\f\u001d\u0430\t\u001d\u0001\u001d\u0005\u001d\u0433\b"+
		"\u001d\n\u001d\f\u001d\u0436\t\u001d\u0001\u001d\u0001\u001d\u0005\u001d"+
		"\u043a\b\u001d\n\u001d\f\u001d\u043d\t\u001d\u0001\u001d\u0001\u001d\u0005"+
		"\u001d\u0441\b\u001d\n\u001d\f\u001d\u0444\t\u001d\u0001\u001d\u0003\u001d"+
		"\u0447\b\u001d\u0001\u001e\u0003\u001e\u044a\b\u001e\u0001\u001e\u0001"+
		"\u001e\u0005\u001e\u044e\b\u001e\n\u001e\f\u001e\u0451\t\u001e\u0001\u001e"+
		"\u0001\u001e\u0005\u001e\u0455\b\u001e\n\u001e\f\u001e\u0458\t\u001e\u0001"+
		"\u001e\u0001\u001e\u0005\u001e\u045c\b\u001e\n\u001e\f\u001e\u045f\t\u001e"+
		"\u0001\u001e\u0001\u001e\u0005\u001e\u0463\b\u001e\n\u001e\f\u001e\u0466"+
		"\t\u001e\u0001\u001e\u0003\u001e\u0469\b\u001e\u0001\u001e\u0005\u001e"+
		"\u046c\b\u001e\n\u001e\f\u001e\u046f\t\u001e\u0001\u001e\u0003\u001e\u0472"+
		"\b\u001e\u0001\u001f\u0003\u001f\u0475\b\u001f\u0001\u001f\u0001\u001f"+
		"\u0005\u001f\u0479\b\u001f\n\u001f\f\u001f\u047c\t\u001f\u0001\u001f\u0001"+
		"\u001f\u0005\u001f\u0480\b\u001f\n\u001f\f\u001f\u0483\t\u001f\u0001\u001f"+
		"\u0001\u001f\u0005\u001f\u0487\b\u001f\n\u001f\f\u001f\u048a\t\u001f\u0001"+
		"\u001f\u0003\u001f\u048d\b\u001f\u0001\u001f\u0005\u001f\u0490\b\u001f"+
		"\n\u001f\f\u001f\u0493\t\u001f\u0001\u001f\u0001\u001f\u0005\u001f\u0497"+
		"\b\u001f\n\u001f\f\u001f\u049a\t\u001f\u0001\u001f\u0001\u001f\u0003\u001f"+
		"\u049e\b\u001f\u0001 \u0001 \u0005 \u04a2\b \n \f \u04a5\t \u0001 \u0001"+
		" \u0005 \u04a9\b \n \f \u04ac\t \u0001 \u0001 \u0005 \u04b0\b \n \f \u04b3"+
		"\t \u0001 \u0005 \u04b6\b \n \f \u04b9\t \u0001 \u0005 \u04bc\b \n \f"+
		" \u04bf\t \u0001 \u0003 \u04c2\b \u0003 \u04c4\b \u0001 \u0005 \u04c7"+
		"\b \n \f \u04ca\t \u0001 \u0001 \u0001!\u0003!\u04cf\b!\u0001!\u0001!"+
		"\u0005!\u04d3\b!\n!\f!\u04d6\t!\u0001!\u0001!\u0005!\u04da\b!\n!\f!\u04dd"+
		"\t!\u0001!\u0003!\u04e0\b!\u0001\"\u0001\"\u0005\"\u04e4\b\"\n\"\f\"\u04e7"+
		"\t\"\u0001\"\u0001\"\u0005\"\u04eb\b\"\n\"\f\"\u04ee\t\"\u0001\"\u0003"+
		"\"\u04f1\b\"\u0001#\u0001#\u0005#\u04f5\b#\n#\f#\u04f8\t#\u0001#\u0001"+
		"#\u0005#\u04fc\b#\n#\f#\u04ff\t#\u0001#\u0001#\u0001$\u0001$\u0005$\u0505"+
		"\b$\n$\f$\u0508\t$\u0001$\u0003$\u050b\b$\u0001$\u0005$\u050e\b$\n$\f"+
		"$\u0511\t$\u0001$\u0001$\u0005$\u0515\b$\n$\f$\u0518\t$\u0001$\u0005$"+
		"\u051b\b$\n$\f$\u051e\t$\u0003$\u0520\b$\u0001$\u0005$\u0523\b$\n$\f$"+
		"\u0526\t$\u0001$\u0001$\u0001%\u0004%\u052b\b%\u000b%\f%\u052c\u0001%"+
		"\u0003%\u0530\b%\u0001&\u0001&\u0005&\u0534\b&\n&\f&\u0537\t&\u0003&\u0539"+
		"\b&\u0001&\u0001&\u0005&\u053d\b&\n&\f&\u0540\t&\u0001&\u0003&\u0543\b"+
		"&\u0001&\u0005&\u0546\b&\n&\f&\u0549\t&\u0001&\u0003&\u054c\b&\u0001&"+
		"\u0005&\u054f\b&\n&\f&\u0552\t&\u0001&\u0003&\u0555\b&\u0001\'\u0005\'"+
		"\u0558\b\'\n\'\f\'\u055b\t\'\u0001\'\u0001\'\u0001\'\u0001\'\u0003\'\u0561"+
		"\b\'\u0001(\u0001(\u0003(\u0565\b(\u0001(\u0005(\u0568\b(\n(\f(\u056b"+
		"\t(\u0001(\u0004(\u056e\b(\u000b(\f(\u056f\u0001)\u0001)\u0001*\u0001"+
		"*\u0005*\u0576\b*\n*\f*\u0579\t*\u0001*\u0001*\u0005*\u057d\b*\n*\f*\u0580"+
		"\t*\u0001*\u0005*\u0583\b*\n*\f*\u0586\t*\u0001+\u0001+\u0005+\u058a\b"+
		"+\n+\f+\u058d\t+\u0001+\u0003+\u0590\b+\u0001,\u0003,\u0593\b,\u0001,"+
		"\u0001,\u0003,\u0597\b,\u0001-\u0004-\u059a\b-\u000b-\f-\u059b\u0001."+
		"\u0001.\u0005.\u05a0\b.\n.\f.\u05a3\t.\u0001.\u0003.\u05a6\b.\u0001/\u0001"+
		"/\u0005/\u05aa\b/\n/\f/\u05ad\t/\u0001/\u0001/\u0005/\u05b1\b/\n/\f/\u05b4"+
		"\t/\u0003/\u05b6\b/\u0001/\u0001/\u0005/\u05ba\b/\n/\f/\u05bd\t/\u0001"+
		"/\u0001/\u0005/\u05c1\b/\n/\f/\u05c4\t/\u0001/\u0001/\u00010\u00010\u0005"+
		"0\u05ca\b0\n0\f0\u05cd\t0\u00010\u00010\u00030\u05d1\b0\u00010\u00050"+
		"\u05d4\b0\n0\f0\u05d7\t0\u00010\u00010\u00050\u05db\b0\n0\f0\u05de\t0"+
		"\u00010\u00010\u00030\u05e2\b0\u00050\u05e4\b0\n0\f0\u05e7\t0\u00010\u0005"+
		"0\u05ea\b0\n0\f0\u05ed\t0\u00010\u00030\u05f0\b0\u00010\u00050\u05f3\b"+
		"0\n0\f0\u05f6\t0\u00010\u00010\u00011\u00011\u00051\u05fc\b1\n1\f1\u05ff"+
		"\t1\u00011\u00011\u00051\u0603\b1\n1\f1\u0606\t1\u00011\u00011\u00012"+
		"\u00032\u060b\b2\u00012\u00012\u00012\u00032\u0610\b2\u00013\u00013\u0005"+
		"3\u0614\b3\n3\f3\u0617\t3\u00013\u00013\u00033\u061b\b3\u00013\u00053"+
		"\u061e\b3\n3\f3\u0621\t3\u00013\u00013\u00014\u00054\u0626\b4\n4\f4\u0629"+
		"\t4\u00014\u00014\u00044\u062d\b4\u000b4\f4\u062e\u00014\u00034\u0632"+
		"\b4\u00054\u0634\b4\n4\f4\u0637\t4\u00034\u0639\b4\u00015\u00015\u0003"+
		"5\u063d\b5\u00016\u00056\u0640\b6\n6\f6\u0643\t6\u00016\u00056\u0646\b"+
		"6\n6\f6\u0649\t6\u00016\u00016\u00017\u00057\u064e\b7\n7\f7\u0651\t7\u0001"+
		"7\u00017\u00017\u00037\u0656\b7\u00018\u00018\u00018\u00058\u065b\b8\n"+
		"8\f8\u065e\t8\u00019\u00019\u00019\u00019\u00019\u00019\u00039\u0666\b"+
		"9\u00019\u00059\u0669\b9\n9\f9\u066c\t9\u00019\u00019\u0001:\u0001:\u0003"+
		":\u0672\b:\u0001;\u0001;\u0005;\u0676\b;\n;\f;\u0679\t;\u0001;\u0001;"+
		"\u0005;\u067d\b;\n;\f;\u0680\t;\u0001;\u0001;\u0001;\u0001;\u0001;\u0005"+
		";\u0687\b;\n;\f;\u068a\t;\u0001;\u0003;\u068d\b;\u0001<\u0001<\u0005<"+
		"\u0691\b<\n<\f<\u0694\t<\u0001<\u0001<\u0001<\u0001<\u0005<\u069a\b<\n"+
		"<\f<\u069d\t<\u0001<\u0001<\u0003<\u06a1\b<\u0001=\u0001=\u0003=\u06a5"+
		"\b=\u0001>\u0001>\u0005>\u06a9\b>\n>\f>\u06ac\t>\u0001>\u0001>\u0005>"+
		"\u06b0\b>\n>\f>\u06b3\t>\u0001>\u0001>\u0001?\u0001?\u0001@\u0001@\u0005"+
		"@\u06bb\b@\n@\f@\u06be\t@\u0001@\u0001@\u0005@\u06c2\b@\n@\f@\u06c5\t"+
		"@\u0001@\u0005@\u06c8\b@\n@\f@\u06cb\t@\u0001A\u0001A\u0005A\u06cf\bA"+
		"\nA\fA\u06d2\tA\u0001A\u0001A\u0005A\u06d6\bA\nA\fA\u06d9\tA\u0001A\u0005"+
		"A\u06dc\bA\nA\fA\u06df\tA\u0001B\u0001B\u0001B\u0005B\u06e4\bB\nB\fB\u06e7"+
		"\tB\u0001B\u0001B\u0005B\u06eb\bB\nB\fB\u06ee\tB\u0001C\u0001C\u0001C"+
		"\u0005C\u06f3\bC\nC\fC\u06f6\tC\u0001C\u0001C\u0005C\u06fa\bC\nC\fC\u06fd"+
		"\tC\u0001D\u0001D\u0005D\u0701\bD\nD\fD\u0704\tD\u0001E\u0001E\u0001E"+
		"\u0005E\u0709\bE\nE\fE\u070c\tE\u0001E\u0001E\u0003E\u0710\bE\u0001F\u0001"+
		"F\u0005F\u0714\bF\nF\fF\u0717\tF\u0001F\u0001F\u0005F\u071b\bF\nF\fF\u071e"+
		"\tF\u0001F\u0001F\u0005F\u0722\bF\nF\fF\u0725\tF\u0001G\u0001G\u0001G"+
		"\u0001H\u0001H\u0001H\u0005H\u072d\bH\nH\fH\u0730\tH\u0001H\u0001H\u0005"+
		"H\u0734\bH\nH\fH\u0737\tH\u0001I\u0001I\u0001I\u0005I\u073c\bI\nI\fI\u073f"+
		"\tI\u0001I\u0001I\u0005I\u0743\bI\nI\fI\u0746\tI\u0001J\u0001J\u0005J"+
		"\u074a\bJ\nJ\fJ\u074d\tJ\u0001J\u0001J\u0001J\u0005J\u0752\bJ\nJ\fJ\u0755"+
		"\tJ\u0001K\u0005K\u0758\bK\nK\fK\u075b\tK\u0001K\u0001K\u0001L\u0001L"+
		"\u0005L\u0761\bL\nL\fL\u0764\tL\u0001L\u0001L\u0003L\u0768\bL\u0001M\u0001"+
		"M\u0005M\u076c\bM\nM\fM\u076f\tM\u0001N\u0001N\u0001N\u0001N\u0001N\u0001"+
		"N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0001N\u0003N\u077e\bN\u0001"+
		"O\u0001O\u0005O\u0782\bO\nO\fO\u0785\tO\u0001O\u0001O\u0005O\u0789\bO"+
		"\nO\fO\u078c\tO\u0001O\u0001O\u0001P\u0001P\u0005P\u0792\bP\nP\fP\u0795"+
		"\tP\u0001P\u0001P\u0005P\u0799\bP\nP\fP\u079c\tP\u0001P\u0001P\u0005P"+
		"\u07a0\bP\nP\fP\u07a3\tP\u0001P\u0005P\u07a6\bP\nP\fP\u07a9\tP\u0001P"+
		"\u0005P\u07ac\bP\nP\fP\u07af\tP\u0001P\u0003P\u07b2\bP\u0001P\u0005P\u07b5"+
		"\bP\nP\fP\u07b8\tP\u0003P\u07ba\bP\u0001P\u0001P\u0001Q\u0001Q\u0001R"+
		"\u0001R\u0003R\u07c2\bR\u0001S\u0001S\u0001S\u0005S\u07c7\bS\nS\fS\u07ca"+
		"\tS\u0001S\u0001S\u0001T\u0001T\u0001T\u0001T\u0005T\u07d2\bT\nT\fT\u07d5"+
		"\tT\u0001T\u0001T\u0001U\u0001U\u0001V\u0001V\u0005V\u07dd\bV\nV\fV\u07e0"+
		"\tV\u0001V\u0001V\u0005V\u07e4\bV\nV\fV\u07e7\tV\u0001V\u0001V\u0001W"+
		"\u0001W\u0001X\u0001X\u0005X\u07ef\bX\nX\fX\u07f2\tX\u0001X\u0001X\u0005"+
		"X\u07f6\bX\nX\fX\u07f9\tX\u0001X\u0001X\u0001Y\u0001Y\u0005Y\u07ff\bY"+
		"\nY\fY\u0802\tY\u0001Y\u0003Y\u0805\bY\u0001Y\u0005Y\u0808\bY\nY\fY\u080b"+
		"\tY\u0001Y\u0001Y\u0005Y\u080f\bY\nY\fY\u0812\tY\u0003Y\u0814\bY\u0001"+
		"Y\u0001Y\u0005Y\u0818\bY\nY\fY\u081b\tY\u0001Y\u0001Y\u0001Z\u0001Z\u0005"+
		"Z\u0821\bZ\nZ\fZ\u0824\tZ\u0001Z\u0001Z\u0005Z\u0828\bZ\nZ\fZ\u082b\t"+
		"Z\u0001Z\u0005Z\u082e\bZ\nZ\fZ\u0831\tZ\u0001Z\u0005Z\u0834\bZ\nZ\fZ\u0837"+
		"\tZ\u0001Z\u0003Z\u083a\bZ\u0001[\u0001[\u0005[\u083e\b[\n[\f[\u0841\t"+
		"[\u0001[\u0001[\u0005[\u0845\b[\n[\f[\u0848\t[\u0001[\u0001[\u0003[\u084c"+
		"\b[\u0001[\u0005[\u084f\b[\n[\f[\u0852\t[\u0001[\u0001[\u0005[\u0856\b"+
		"[\n[\f[\u0859\t[\u0001[\u0001[\u0005[\u085d\b[\n[\f[\u0860\t[\u0001[\u0003"+
		"[\u0863\b[\u0001[\u0005[\u0866\b[\n[\f[\u0869\t[\u0001[\u0003[\u086c\b"+
		"[\u0001[\u0005[\u086f\b[\n[\f[\u0872\t[\u0001[\u0003[\u0875\b[\u0001\\"+
		"\u0001\\\u0003\\\u0879\b\\\u0001]\u0001]\u0001^\u0001^\u0001^\u0005^\u0880"+
		"\b^\n^\f^\u0883\t^\u0001^\u0001^\u0005^\u0887\b^\n^\f^\u088a\t^\u0001"+
		"^\u0001^\u0003^\u088e\b^\u0001_\u0001_\u0005_\u0892\b_\n_\f_\u0895\t_"+
		"\u0001_\u0001_\u0005_\u0899\b_\n_\f_\u089c\t_\u0001_\u0001_\u0005_\u08a0"+
		"\b_\n_\f_\u08a3\t_\u0001_\u0001_\u0005_\u08a7\b_\n_\f_\u08aa\t_\u0001"+
		"_\u0001_\u0003_\u08ae\b_\u0001_\u0005_\u08b1\b_\n_\f_\u08b4\t_\u0001_"+
		"\u0003_\u08b7\b_\u0001_\u0005_\u08ba\b_\n_\f_\u08bd\t_\u0001_\u0001_\u0005"+
		"_\u08c1\b_\n_\f_\u08c4\t_\u0001_\u0001_\u0003_\u08c8\b_\u0001_\u0003_"+
		"\u08cb\b_\u0001`\u0001`\u0005`\u08cf\b`\n`\f`\u08d2\t`\u0001`\u0005`\u08d5"+
		"\b`\n`\f`\u08d8\t`\u0001`\u0001`\u0005`\u08dc\b`\n`\f`\u08df\t`\u0001"+
		"`\u0001`\u0005`\u08e3\b`\n`\f`\u08e6\t`\u0001`\u0001`\u0005`\u08ea\b`"+
		"\n`\f`\u08ed\t`\u0003`\u08ef\b`\u0001`\u0001`\u0001`\u0001a\u0001a\u0005"+
		"a\u08f6\ba\na\fa\u08f9\ta\u0001a\u0003a\u08fc\ba\u0001a\u0005a\u08ff\b"+
		"a\na\fa\u0902\ta\u0001a\u0001a\u0005a\u0906\ba\na\fa\u0909\ta\u0001a\u0001"+
		"a\u0005a\u090d\ba\na\fa\u0910\ta\u0005a\u0912\ba\na\fa\u0915\ta\u0001"+
		"a\u0005a\u0918\ba\na\fa\u091b\ta\u0001a\u0001a\u0001b\u0001b\u0005b\u0921"+
		"\bb\nb\fb\u0924\tb\u0001b\u0001b\u0005b\u0928\bb\nb\fb\u092b\tb\u0001"+
		"b\u0005b\u092e\bb\nb\fb\u0931\tb\u0001b\u0005b\u0934\bb\nb\fb\u0937\t"+
		"b\u0001b\u0003b\u093a\bb\u0001b\u0005b\u093d\bb\nb\fb\u0940\tb\u0001b"+
		"\u0001b\u0005b\u0944\bb\nb\fb\u0947\tb\u0001b\u0001b\u0003b\u094b\bb\u0001"+
		"b\u0001b\u0005b\u094f\bb\nb\fb\u0952\tb\u0001b\u0001b\u0005b\u0956\bb"+
		"\nb\fb\u0959\tb\u0001b\u0001b\u0003b\u095d\bb\u0003b\u095f\bb\u0001c\u0001"+
		"c\u0003c\u0963\bc\u0001d\u0001d\u0005d\u0967\bd\nd\fd\u096a\td\u0001d"+
		"\u0001d\u0001e\u0001e\u0005e\u0970\be\ne\fe\u0973\te\u0001e\u0001e\u0005"+
		"e\u0977\be\ne\fe\u097a\te\u0001e\u0004e\u097d\be\u000be\fe\u097e\u0001"+
		"e\u0005e\u0982\be\ne\fe\u0985\te\u0001e\u0003e\u0988\be\u0001e\u0005e"+
		"\u098b\be\ne\fe\u098e\te\u0001e\u0003e\u0991\be\u0001f\u0001f\u0005f\u0995"+
		"\bf\nf\ff\u0998\tf\u0001f\u0001f\u0005f\u099c\bf\nf\ff\u099f\tf\u0001"+
		"f\u0001f\u0001f\u0001f\u0005f\u09a5\bf\nf\ff\u09a8\tf\u0001f\u0003f\u09ab"+
		"\bf\u0001f\u0001f\u0005f\u09af\bf\nf\ff\u09b2\tf\u0001f\u0001f\u0001g"+
		"\u0001g\u0005g\u09b8\bg\ng\fg\u09bb\tg\u0001g\u0001g\u0001h\u0001h\u0005"+
		"h\u09c1\bh\nh\fh\u09c4\th\u0001h\u0001h\u0001h\u0003h\u09c9\bh\u0001h"+
		"\u0003h\u09cc\bh\u0001i\u0003i\u09cf\bi\u0001i\u0001i\u0005i\u09d3\bi"+
		"\ni\fi\u09d6\ti\u0001i\u0001i\u0003i\u09da\bi\u0001j\u0001j\u0001j\u0001"+
		"j\u0001j\u0003j\u09e1\bj\u0001k\u0001k\u0001k\u0001k\u0001k\u0003k\u09e8"+
		"\bk\u0001l\u0001l\u0005l\u09ec\bl\nl\fl\u09ef\tl\u0001l\u0001l\u0005l"+
		"\u09f3\bl\nl\fl\u09f6\tl\u0001l\u0001l\u0001m\u0001m\u0003m\u09fc\bm\u0001"+
		"n\u0001n\u0005n\u0a00\bn\nn\fn\u0a03\tn\u0001n\u0001n\u0005n\u0a07\bn"+
		"\nn\fn\u0a0a\tn\u0001n\u0001n\u0001o\u0001o\u0001o\u0003o\u0a11\bo\u0001"+
		"p\u0001p\u0005p\u0a15\bp\np\fp\u0a18\tp\u0001p\u0001p\u0005p\u0a1c\bp"+
		"\np\fp\u0a1f\tp\u0001p\u0001p\u0005p\u0a23\bp\np\fp\u0a26\tp\u0001p\u0005"+
		"p\u0a29\bp\np\fp\u0a2c\tp\u0001p\u0005p\u0a2f\bp\np\fp\u0a32\tp\u0001"+
		"p\u0003p\u0a35\bp\u0001p\u0005p\u0a38\bp\np\fp\u0a3b\tp\u0001p\u0001p"+
		"\u0001q\u0001q\u0005q\u0a41\bq\nq\fq\u0a44\tq\u0001q\u0001q\u0001q\u0003"+
		"q\u0a49\bq\u0001r\u0003r\u0a4c\br\u0001r\u0003r\u0a4f\br\u0001r\u0001"+
		"r\u0003r\u0a53\br\u0001s\u0005s\u0a56\bs\ns\fs\u0a59\ts\u0001s\u0003s"+
		"\u0a5c\bs\u0001s\u0005s\u0a5f\bs\ns\fs\u0a62\ts\u0001s\u0001s\u0001t\u0001"+
		"t\u0005t\u0a68\bt\nt\ft\u0a6b\tt\u0001t\u0001t\u0005t\u0a6f\bt\nt\ft\u0a72"+
		"\tt\u0001t\u0001t\u0005t\u0a76\bt\nt\ft\u0a79\tt\u0001t\u0005t\u0a7c\b"+
		"t\nt\ft\u0a7f\tt\u0001t\u0005t\u0a82\bt\nt\ft\u0a85\tt\u0001t\u0003t\u0a88"+
		"\bt\u0001t\u0005t\u0a8b\bt\nt\ft\u0a8e\tt\u0001t\u0001t\u0001u\u0001u"+
		"\u0005u\u0a94\bu\nu\fu\u0a97\tu\u0001u\u0001u\u0005u\u0a9b\bu\nu\fu\u0a9e"+
		"\tu\u0001u\u0001u\u0005u\u0aa2\bu\nu\fu\u0aa5\tu\u0001u\u0005u\u0aa8\b"+
		"u\nu\fu\u0aab\tu\u0001u\u0005u\u0aae\bu\nu\fu\u0ab1\tu\u0001u\u0003u\u0ab4"+
		"\bu\u0001u\u0005u\u0ab7\bu\nu\fu\u0aba\tu\u0003u\u0abc\bu\u0001u\u0001"+
		"u\u0001v\u0001v\u0005v\u0ac2\bv\nv\fv\u0ac5\tv\u0001v\u0001v\u0005v\u0ac9"+
		"\bv\nv\fv\u0acc\tv\u0003v\u0ace\bv\u0001v\u0003v\u0ad1\bv\u0001v\u0005"+
		"v\u0ad4\bv\nv\fv\u0ad7\tv\u0001v\u0001v\u0001w\u0001w\u0001x\u0001x\u0001"+
		"y\u0001y\u0001z\u0001z\u0001{\u0001{\u0001|\u0001|\u0001}\u0001}\u0001"+
		"~\u0001~\u0001~\u0001~\u0001~\u0003~\u0aee\b~\u0001\u007f\u0001\u007f"+
		"\u0001\u007f\u0001\u007f\u0003\u007f\u0af4\b\u007f\u0001\u0080\u0001\u0080"+
		"\u0001\u0081\u0005\u0081\u0af9\b\u0081\n\u0081\f\u0081\u0afc\t\u0081\u0001"+
		"\u0081\u0001\u0081\u0005\u0081\u0b00\b\u0081\n\u0081\f\u0081\u0b03\t\u0081"+
		"\u0001\u0081\u0001\u0081\u0003\u0081\u0b07\b\u0081\u0001\u0082\u0001\u0082"+
		"\u0001\u0082\u0001\u0083\u0001\u0083\u0004\u0083\u0b0e\b\u0083\u000b\u0083"+
		"\f\u0083\u0b0f\u0001\u0084\u0004\u0084\u0b13\b\u0084\u000b\u0084\f\u0084"+
		"\u0b14\u0001\u0084\u0003\u0084\u0b18\b\u0084\u0001\u0085\u0001\u0085\u0001"+
		"\u0085\u0001\u0085\u0001\u0085\u0003\u0085\u0b1f\b\u0085\u0001\u0085\u0005"+
		"\u0085\u0b22\b\u0085\n\u0085\f\u0085\u0b25\t\u0085\u0001\u0086\u0001\u0086"+
		"\u0001\u0087\u0001\u0087\u0001\u0088\u0001\u0088\u0001\u0089\u0001\u0089"+
		"\u0001\u008a\u0004\u008a\u0b30\b\u008a\u000b\u008a\f\u008a\u0b31\u0001"+
		"\u008b\u0001\u008b\u0005\u008b\u0b36\b\u008b\n\u008b\f\u008b\u0b39\t\u008b"+
		"\u0001\u008b\u0003\u008b\u0b3c\b\u008b\u0001\u008c\u0001\u008c\u0001\u008d"+
		"\u0001\u008d\u0003\u008d\u0b42\b\u008d\u0001\u008d\u0005\u008d\u0b45\b"+
		"\u008d\n\u008d\f\u008d\u0b48\t\u008d\u0001\u008e\u0001\u008e\u0005\u008e"+
		"\u0b4c\b\u008e\n\u008e\f\u008e\u0b4f\t\u008e\u0001\u008e\u0001\u008e\u0005"+
		"\u008e\u0b53\b\u008e\n\u008e\f\u008e\u0b56\t\u008e\u0001\u008e\u0001\u008e"+
		"\u0001\u008e\u0001\u008e\u0003\u008e\u0b5c\b\u008e\u0001\u008f\u0001\u008f"+
		"\u0001\u008f\u0001\u008f\u0004\u008f\u0b62\b\u008f\u000b\u008f\f\u008f"+
		"\u0b63\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0001\u008f\u0004"+
		"\u008f\u0b6b\b\u008f\u000b\u008f\f\u008f\u0b6c\u0001\u008f\u0001\u008f"+
		"\u0003\u008f\u0b71\b\u008f\u0001\u0090\u0001\u0090\u0001\u0091\u0001\u0091"+
		"\u0003\u0091\u0b77\b\u0091\u0001\u0092\u0001\u0092\u0001\u0093\u0001\u0093"+
		"\u0005\u0093\u0b7d\b\u0093\n\u0093\f\u0093\u0b80\t\u0093\u0001\u0093\u0001"+
		"\u0093\u0005\u0093\u0b84\b\u0093\n\u0093\f\u0093\u0b87\t\u0093\u0001\u0094"+
		"\u0004\u0094\u0b8a\b\u0094\u000b\u0094\f\u0094\u0b8b\u0001\u0094\u0005"+
		"\u0094\u0b8f\b\u0094\n\u0094\f\u0094\u0b92\t\u0094\u0001\u0094\u0001\u0094"+
		"\u0005\u0094\u0b96\b\u0094\n\u0094\f\u0094\u0b99\t\u0094\u0003\u0094\u0b9b"+
		"\b\u0094\u0001\u0095\u0001\u0095\u0001\u0095\u0000\u0000\u0096\u0000\u0002"+
		"\u0004\u0006\b\n\f\u000e\u0010\u0012\u0014\u0016\u0018\u001a\u001c\u001e"+
		" \"$&(*,.02468:<>@BDFHJLNPRTVXZ\\^`bdfhjlnprtvxz|~\u0080\u0082\u0084\u0086"+
		"\u0088\u008a\u008c\u008e\u0090\u0092\u0094\u0096\u0098\u009a\u009c\u009e"+
		"\u00a0\u00a2\u00a4\u00a6\u00a8\u00aa\u00ac\u00ae\u00b0\u00b2\u00b4\u00b6"+
		"\u00b8\u00ba\u00bc\u00be\u00c0\u00c2\u00c4\u00c6\u00c8\u00ca\u00cc\u00ce"+
		"\u00d0\u00d2\u00d4\u00d6\u00d8\u00da\u00dc\u00de\u00e0\u00e2\u00e4\u00e6"+
		"\u00e8\u00ea\u00ec\u00ee\u00f0\u00f2\u00f4\u00f6\u00f8\u00fa\u00fc\u00fe"+
		"\u0100\u0102\u0104\u0106\u0108\u010a\u010c\u010e\u0110\u0112\u0114\u0116"+
		"\u0118\u011a\u011c\u011e\u0120\u0122\u0124\u0126\u0128\u012a\u0000\u0019"+
		"\u0001\u0000<=\u0001\u0000AB\u0002\u0000\u001b\u001b??\u0001\u0000\'("+
		"\u0001\u0000#$\u0002\u0000oorx\u0001\u0000\u0085\u0087\u0001\u0000\u008a"+
		"\u008c\u0001\u0000\u001c \u0002\u0000/023\u0001\u0000+.\u0001\u0000RS"+
		"\u0001\u0000\u0011\u0012\u0001\u0000\u000e\u0010\u0003\u0000\u0019\u0019"+
		"11QQ\u0001\u0000\u0017\u0018\u0001\u0000ch\u0002\u0000iimm\u0001\u0000"+
		"`b\u0001\u0000TU\u0001\u0000jl\u0002\u0000##%%\u0003\u0000VVXZ]_\n\u0000"+
		"88>@DDIJUUWW[\\`dfnyy\u0002\u0000\u0004\u0004\u001a\u001a\u0cf7\u0000"+
		"\u012d\u0001\u0000\u0000\u0000\u0002\u0146\u0001\u0000\u0000\u0000\u0004"+
		"\u014e\u0001\u0000\u0000\u0000\u0006\u0151\u0001\u0000\u0000\u0000\b\u0159"+
		"\u0001\u0000\u0000\u0000\n\u015f\u0001\u0000\u0000\u0000\f\u0162\u0001"+
		"\u0000\u0000\u0000\u000e\u01b4\u0001\u0000\u0000\u0000\u0010\u01c1\u0001"+
		"\u0000\u0000\u0000\u0012\u01f0\u0001\u0000\u0000\u0000\u0014\u0214\u0001"+
		"\u0000\u0000\u0000\u0016\u022b\u0001\u0000\u0000\u0000\u0018\u023a\u0001"+
		"\u0000\u0000\u0000\u001a\u023c\u0001\u0000\u0000\u0000\u001c\u0247\u0001"+
		"\u0000\u0000\u0000\u001e\u0258\u0001\u0000\u0000\u0000 \u026d\u0001\u0000"+
		"\u0000\u0000\"\u029a\u0001\u0000\u0000\u0000$\u02b6\u0001\u0000\u0000"+
		"\u0000&\u02d4\u0001\u0000\u0000\u0000(\u02ea\u0001\u0000\u0000\u0000*"+
		"\u02f1\u0001\u0000\u0000\u0000,\u02fb\u0001\u0000\u0000\u0000.\u031e\u0001"+
		"\u0000\u0000\u00000\u0328\u0001\u0000\u0000\u00002\u0375\u0001\u0000\u0000"+
		"\u00004\u03a4\u0001\u0000\u0000\u00006\u03c0\u0001\u0000\u0000\u00008"+
		"\u03c3\u0001\u0000\u0000\u0000:\u042e\u0001\u0000\u0000\u0000<\u0449\u0001"+
		"\u0000\u0000\u0000>\u0474\u0001\u0000\u0000\u0000@\u049f\u0001\u0000\u0000"+
		"\u0000B\u04ce\u0001\u0000\u0000\u0000D\u04e1\u0001\u0000\u0000\u0000F"+
		"\u04f2\u0001\u0000\u0000\u0000H\u0502\u0001\u0000\u0000\u0000J\u052a\u0001"+
		"\u0000\u0000\u0000L\u0538\u0001\u0000\u0000\u0000N\u0559\u0001\u0000\u0000"+
		"\u0000P\u0564\u0001\u0000\u0000\u0000R\u0571\u0001\u0000\u0000\u0000T"+
		"\u0573\u0001\u0000\u0000\u0000V\u0587\u0001\u0000\u0000\u0000X\u0596\u0001"+
		"\u0000\u0000\u0000Z\u0599\u0001\u0000\u0000\u0000\\\u05a5\u0001\u0000"+
		"\u0000\u0000^\u05b5\u0001\u0000\u0000\u0000`\u05c7\u0001\u0000\u0000\u0000"+
		"b\u05f9\u0001\u0000\u0000\u0000d\u060a\u0001\u0000\u0000\u0000f\u0611"+
		"\u0001\u0000\u0000\u0000h\u0627\u0001\u0000\u0000\u0000j\u063c\u0001\u0000"+
		"\u0000\u0000l\u0641\u0001\u0000\u0000\u0000n\u064f\u0001\u0000\u0000\u0000"+
		"p\u0657\u0001\u0000\u0000\u0000r\u0665\u0001\u0000\u0000\u0000t\u0671"+
		"\u0001\u0000\u0000\u0000v\u0673\u0001\u0000\u0000\u0000x\u068e\u0001\u0000"+
		"\u0000\u0000z\u06a4\u0001\u0000\u0000\u0000|\u06a6\u0001\u0000\u0000\u0000"+
		"~\u06b6\u0001\u0000\u0000\u0000\u0080\u06b8\u0001\u0000\u0000\u0000\u0082"+
		"\u06cc\u0001\u0000\u0000\u0000\u0084\u06e0\u0001\u0000\u0000\u0000\u0086"+
		"\u06ef\u0001\u0000\u0000\u0000\u0088\u06fe\u0001\u0000\u0000\u0000\u008a"+
		"\u0705\u0001\u0000\u0000\u0000\u008c\u0711\u0001\u0000\u0000\u0000\u008e"+
		"\u0726\u0001\u0000\u0000\u0000\u0090\u0729\u0001\u0000\u0000\u0000\u0092"+
		"\u0738\u0001\u0000\u0000\u0000\u0094\u0747\u0001\u0000\u0000\u0000\u0096"+
		"\u0759\u0001\u0000\u0000\u0000\u0098\u0767\u0001\u0000\u0000\u0000\u009a"+
		"\u0769\u0001\u0000\u0000\u0000\u009c\u077d\u0001\u0000\u0000\u0000\u009e"+
		"\u077f\u0001\u0000\u0000\u0000\u00a0\u078f\u0001\u0000\u0000\u0000\u00a2"+
		"\u07bd\u0001\u0000\u0000\u0000\u00a4\u07c1\u0001\u0000\u0000\u0000\u00a6"+
		"\u07c3\u0001\u0000\u0000\u0000\u00a8\u07cd\u0001\u0000\u0000\u0000\u00aa"+
		"\u07d8\u0001\u0000\u0000\u0000\u00ac\u07da\u0001\u0000\u0000\u0000\u00ae"+
		"\u07ea\u0001\u0000\u0000\u0000\u00b0\u07ec\u0001\u0000\u0000\u0000\u00b2"+
		"\u07fc\u0001\u0000\u0000\u0000\u00b4\u081e\u0001\u0000\u0000\u0000\u00b6"+
		"\u083b\u0001\u0000\u0000\u0000\u00b8\u0878\u0001\u0000\u0000\u0000\u00ba"+
		"\u087a\u0001\u0000\u0000\u0000\u00bc\u087c\u0001\u0000\u0000\u0000\u00be"+
		"\u088f\u0001\u0000\u0000\u0000\u00c0\u08cc\u0001\u0000\u0000\u0000\u00c2"+
		"\u08f3\u0001\u0000\u0000\u0000\u00c4\u095e\u0001\u0000\u0000\u0000\u00c6"+
		"\u0962\u0001\u0000\u0000\u0000\u00c8\u0964\u0001\u0000\u0000\u0000\u00ca"+
		"\u096d\u0001\u0000\u0000\u0000\u00cc\u0992\u0001\u0000\u0000\u0000\u00ce"+
		"\u09b5\u0001\u0000\u0000\u0000\u00d0\u09cb\u0001\u0000\u0000\u0000\u00d2"+
		"\u09ce\u0001\u0000\u0000\u0000\u00d4\u09e0\u0001\u0000\u0000\u0000\u00d6"+
		"\u09e7\u0001\u0000\u0000\u0000\u00d8\u09e9\u0001\u0000\u0000\u0000\u00da"+
		"\u09fb\u0001\u0000\u0000\u0000\u00dc\u09fd\u0001\u0000\u0000\u0000\u00de"+
		"\u0a10\u0001\u0000\u0000\u0000\u00e0\u0a12\u0001\u0000\u0000\u0000\u00e2"+
		"\u0a3e\u0001\u0000\u0000\u0000\u00e4\u0a4b\u0001\u0000\u0000\u0000\u00e6"+
		"\u0a57\u0001\u0000\u0000\u0000\u00e8\u0a65\u0001\u0000\u0000\u0000\u00ea"+
		"\u0a91\u0001\u0000\u0000\u0000\u00ec\u0acd\u0001\u0000\u0000\u0000\u00ee"+
		"\u0ada\u0001\u0000\u0000\u0000\u00f0\u0adc\u0001\u0000\u0000\u0000\u00f2"+
		"\u0ade\u0001\u0000\u0000\u0000\u00f4\u0ae0\u0001\u0000\u0000\u0000\u00f6"+
		"\u0ae2\u0001\u0000\u0000\u0000\u00f8\u0ae4\u0001\u0000\u0000\u0000\u00fa"+
		"\u0ae6\u0001\u0000\u0000\u0000\u00fc\u0aed\u0001\u0000\u0000\u0000\u00fe"+
		"\u0af3\u0001\u0000\u0000\u0000\u0100\u0af5\u0001\u0000\u0000\u0000\u0102"+
		"\u0b06\u0001\u0000\u0000\u0000\u0104\u0b08\u0001\u0000\u0000\u0000\u0106"+
		"\u0b0d\u0001\u0000\u0000\u0000\u0108\u0b12\u0001\u0000\u0000\u0000\u010a"+
		"\u0b1e\u0001\u0000\u0000\u0000\u010c\u0b26\u0001\u0000\u0000\u0000\u010e"+
		"\u0b28\u0001\u0000\u0000\u0000\u0110\u0b2a\u0001\u0000\u0000\u0000\u0112"+
		"\u0b2c\u0001\u0000\u0000\u0000\u0114\u0b2f\u0001\u0000\u0000\u0000\u0116"+
		"\u0b3b\u0001\u0000\u0000\u0000\u0118\u0b3d\u0001\u0000\u0000\u0000\u011a"+
		"\u0b41\u0001\u0000\u0000\u0000\u011c\u0b5b\u0001\u0000\u0000\u0000\u011e"+
		"\u0b70\u0001\u0000\u0000\u0000\u0120\u0b72\u0001\u0000\u0000\u0000\u0122"+
		"\u0b76\u0001\u0000\u0000\u0000\u0124\u0b78\u0001\u0000\u0000\u0000\u0126"+
		"\u0b7a\u0001\u0000\u0000\u0000\u0128\u0b9a\u0001\u0000\u0000\u0000\u012a"+
		"\u0b9c\u0001\u0000\u0000\u0000\u012c\u012e\u0003\u0002\u0001\u0000\u012d"+
		"\u012c\u0001\u0000\u0000\u0000\u012d\u012e\u0001\u0000\u0000\u0000\u012e"+
		"\u012f\u0001\u0000\u0000\u0000\u012f\u0133\u0003\u0004\u0002\u0000\u0130"+
		"\u0132\u0003\u012a\u0095\u0000\u0131\u0130\u0001\u0000\u0000\u0000\u0132"+
		"\u0135\u0001\u0000\u0000\u0000\u0133\u0131\u0001\u0000\u0000\u0000\u0133"+
		"\u0134\u0001\u0000\u0000\u0000\u0134\u0136\u0001\u0000\u0000\u0000\u0135"+
		"\u0133\u0001\u0000\u0000\u0000\u0136\u0141\u0003\f\u0006\u0000\u0137\u0139"+
		"\u0003\u012a\u0095\u0000\u0138\u0137\u0001\u0000\u0000\u0000\u0139\u013a"+
		"\u0001\u0000\u0000\u0000\u013a\u0138\u0001\u0000\u0000\u0000\u013a\u013b"+
		"\u0001\u0000\u0000\u0000\u013b\u013d\u0001\u0000\u0000\u0000\u013c\u013e"+
		"\u0003\f\u0006\u0000\u013d\u013c\u0001\u0000\u0000\u0000\u013d\u013e\u0001"+
		"\u0000\u0000\u0000\u013e\u0140\u0001\u0000\u0000\u0000\u013f\u0138\u0001"+
		"\u0000\u0000\u0000\u0140\u0143\u0001\u0000\u0000\u0000\u0141\u013f\u0001"+
		"\u0000\u0000\u0000\u0141\u0142\u0001\u0000\u0000\u0000\u0142\u0144\u0001"+
		"\u0000\u0000\u0000\u0143\u0141\u0001\u0000\u0000\u0000\u0144\u0145\u0005"+
		"\u0000\u0000\u0001\u0145\u0001\u0001\u0000\u0000\u0000\u0146\u0147\u0005"+
		"7\u0000\u0000\u0147\u0149\u0003\u0126\u0093\u0000\u0148\u014a\u0003\u0128"+
		"\u0094\u0000\u0149\u0148\u0001\u0000\u0000\u0000\u0149\u014a\u0001\u0000"+
		"\u0000\u0000\u014a\u0003\u0001\u0000\u0000\u0000\u014b\u014d\u0003\u0006"+
		"\u0003\u0000\u014c\u014b\u0001\u0000\u0000\u0000\u014d\u0150\u0001\u0000"+
		"\u0000\u0000\u014e\u014c\u0001\u0000\u0000\u0000\u014e\u014f\u0001\u0000"+
		"\u0000\u0000\u014f\u0005\u0001\u0000\u0000\u0000\u0150\u014e\u0001\u0000"+
		"\u0000\u0000\u0151\u0152\u00058\u0000\u0000\u0152\u0154\u0003\u0126\u0093"+
		"\u0000\u0153\u0155\u0003\b\u0004\u0000\u0154\u0153\u0001\u0000\u0000\u0000"+
		"\u0154\u0155\u0001\u0000\u0000\u0000\u0155\u0157\u0001\u0000\u0000\u0000"+
		"\u0156\u0158\u0003\u0128\u0094\u0000\u0157\u0156\u0001\u0000\u0000\u0000"+
		"\u0157\u0158\u0001\u0000\u0000\u0000\u0158\u0007\u0001\u0000\u0000\u0000"+
		"\u0159\u015a\u0005Q\u0000\u0000\u015a\u015b\u0003\u0124\u0092\u0000\u015b"+
		"\t\u0001\u0000\u0000\u0000\u015c\u0160\u0003\f\u0006\u0000\u015d\u0160"+
		"\u00030\u0018\u0000\u015e\u0160\u00038\u001c\u0000\u015f\u015c\u0001\u0000"+
		"\u0000\u0000\u015f\u015d\u0001\u0000\u0000\u0000\u015f\u015e\u0001\u0000"+
		"\u0000\u0000\u0160\u000b\u0001\u0000\u0000\u0000\u0161\u0163\u0003\u0106"+
		"\u0083\u0000\u0162\u0161\u0001\u0000\u0000\u0000\u0162\u0163\u0001\u0000"+
		"\u0000\u0000\u0163\u016f\u0001\u0000\u0000\u0000\u0164\u0170\u00059\u0000"+
		"\u0000\u0165\u0169\u0005;\u0000\u0000\u0166\u0168\u0005\u0004\u0000\u0000"+
		"\u0167\u0166\u0001\u0000\u0000\u0000\u0168\u016b\u0001\u0000\u0000\u0000"+
		"\u0169\u0167\u0001\u0000\u0000\u0000\u0169\u016a\u0001\u0000\u0000\u0000"+
		"\u016a\u016d\u0001\u0000\u0000\u0000\u016b\u0169\u0001\u0000\u0000\u0000"+
		"\u016c\u0165\u0001\u0000\u0000\u0000\u016c\u016d\u0001\u0000\u0000\u0000"+
		"\u016d\u016e\u0001\u0000\u0000\u0000\u016e\u0170\u0005:\u0000\u0000\u016f"+
		"\u0164\u0001\u0000\u0000\u0000\u016f\u016c\u0001\u0000\u0000\u0000\u0170"+
		"\u0174\u0001\u0000\u0000\u0000\u0171\u0173\u0005\u0004\u0000\u0000\u0172"+
		"\u0171\u0001\u0000\u0000\u0000\u0173\u0176\u0001\u0000\u0000\u0000\u0174"+
		"\u0172\u0001\u0000\u0000\u0000\u0174\u0175\u0001\u0000\u0000\u0000\u0175"+
		"\u0177\u0001\u0000\u0000\u0000\u0176\u0174\u0001\u0000\u0000\u0000\u0177"+
		"\u017f\u0003\u0124\u0092\u0000\u0178\u017a\u0005\u0004\u0000\u0000\u0179"+
		"\u0178\u0001\u0000\u0000\u0000\u017a\u017d\u0001\u0000\u0000\u0000\u017b"+
		"\u0179\u0001\u0000\u0000\u0000\u017b\u017c\u0001\u0000\u0000\u0000\u017c"+
		"\u017e\u0001\u0000\u0000\u0000\u017d\u017b\u0001\u0000\u0000\u0000\u017e"+
		"\u0180\u0003 \u0010\u0000\u017f\u017b\u0001\u0000\u0000\u0000\u017f\u0180"+
		"\u0001\u0000\u0000\u0000\u0180\u0188\u0001\u0000\u0000\u0000\u0181\u0183"+
		"\u0005\u0004\u0000\u0000\u0182\u0181\u0001\u0000\u0000\u0000\u0183\u0186"+
		"\u0001\u0000\u0000\u0000\u0184\u0182\u0001\u0000\u0000\u0000\u0184\u0185"+
		"\u0001\u0000\u0000\u0000\u0185\u0187\u0001\u0000\u0000\u0000\u0186\u0184"+
		"\u0001\u0000\u0000\u0000\u0187\u0189\u0003\u000e\u0007\u0000\u0188\u0184"+
		"\u0001\u0000\u0000\u0000\u0188\u0189\u0001\u0000\u0000\u0000\u0189\u0198"+
		"\u0001\u0000\u0000\u0000\u018a\u018c\u0005\u0004\u0000\u0000\u018b\u018a"+
		"\u0001\u0000\u0000\u0000\u018c\u018f\u0001\u0000\u0000\u0000\u018d\u018b"+
		"\u0001\u0000\u0000\u0000\u018d\u018e\u0001\u0000\u0000\u0000\u018e\u0190"+
		"\u0001\u0000\u0000\u0000\u018f\u018d\u0001\u0000\u0000\u0000\u0190\u0194"+
		"\u0005\u0019\u0000\u0000\u0191\u0193\u0005\u0004\u0000\u0000\u0192\u0191"+
		"\u0001\u0000\u0000\u0000\u0193\u0196\u0001\u0000\u0000\u0000\u0194\u0192"+
		"\u0001\u0000\u0000\u0000\u0194\u0195\u0001\u0000\u0000\u0000\u0195\u0197"+
		"\u0001\u0000\u0000\u0000\u0196\u0194\u0001\u0000\u0000\u0000\u0197\u0199"+
		"\u0003\u0014\n\u0000\u0198\u018d\u0001\u0000\u0000\u0000\u0198\u0199\u0001"+
		"\u0000\u0000\u0000\u0199\u01a1\u0001\u0000\u0000\u0000\u019a\u019c\u0005"+
		"\u0004\u0000\u0000\u019b\u019a\u0001\u0000\u0000\u0000\u019c\u019f\u0001"+
		"\u0000\u0000\u0000\u019d\u019b\u0001\u0000\u0000\u0000\u019d\u019e\u0001"+
		"\u0000\u0000\u0000\u019e\u01a0\u0001\u0000\u0000\u0000\u019f\u019d\u0001"+
		"\u0000\u0000\u0000\u01a0\u01a2\u0003$\u0012\u0000\u01a1\u019d\u0001\u0000"+
		"\u0000\u0000\u01a1\u01a2\u0001\u0000\u0000\u0000\u01a2\u01b1\u0001\u0000"+
		"\u0000\u0000\u01a3\u01a5\u0005\u0004\u0000\u0000\u01a4\u01a3\u0001\u0000"+
		"\u0000\u0000\u01a5\u01a8\u0001\u0000\u0000\u0000\u01a6\u01a4\u0001\u0000"+
		"\u0000\u0000\u01a6\u01a7\u0001\u0000\u0000\u0000\u01a7\u01a9\u0001\u0000"+
		"\u0000\u0000\u01a8\u01a6\u0001\u0000\u0000\u0000\u01a9\u01b2\u0003\u001e"+
		"\u000f\u0000\u01aa\u01ac\u0005\u0004\u0000\u0000\u01ab\u01aa\u0001\u0000"+
		"\u0000\u0000\u01ac\u01af\u0001\u0000\u0000\u0000\u01ad\u01ab\u0001\u0000"+
		"\u0000\u0000\u01ad\u01ae\u0001\u0000\u0000\u0000\u01ae\u01b0\u0001\u0000"+
		"\u0000\u0000\u01af\u01ad\u0001\u0000\u0000\u0000\u01b0\u01b2\u0003H$\u0000"+
		"\u01b1\u01a6\u0001\u0000\u0000\u0000\u01b1\u01ad\u0001\u0000\u0000\u0000"+
		"\u01b1\u01b2\u0001\u0000\u0000\u0000\u01b2\r\u0001\u0000\u0000\u0000\u01b3"+
		"\u01b5\u0003\u0106\u0083\u0000\u01b4\u01b3\u0001\u0000\u0000\u0000\u01b4"+
		"\u01b5\u0001\u0000\u0000\u0000\u01b5\u01bd\u0001\u0000\u0000\u0000\u01b6"+
		"\u01ba\u0005>\u0000\u0000\u01b7\u01b9\u0005\u0004\u0000\u0000\u01b8\u01b7"+
		"\u0001\u0000\u0000\u0000\u01b9\u01bc\u0001\u0000\u0000\u0000\u01ba\u01b8"+
		"\u0001\u0000\u0000\u0000\u01ba\u01bb\u0001\u0000\u0000\u0000\u01bb\u01be"+
		"\u0001\u0000\u0000\u0000\u01bc\u01ba\u0001\u0000\u0000\u0000\u01bd\u01b6"+
		"\u0001\u0000\u0000\u0000\u01bd\u01be\u0001\u0000\u0000\u0000\u01be\u01bf"+
		"\u0001\u0000\u0000\u0000\u01bf\u01c0\u0003\u0010\b\u0000\u01c0\u000f\u0001"+
		"\u0000\u0000\u0000\u01c1\u01c5\u0005\b\u0000\u0000\u01c2\u01c4\u0005\u0004"+
		"\u0000\u0000\u01c3\u01c2\u0001\u0000\u0000\u0000\u01c4\u01c7\u0001\u0000"+
		"\u0000\u0000\u01c5\u01c3\u0001\u0000\u0000\u0000\u01c5\u01c6\u0001\u0000"+
		"\u0000\u0000\u01c6\u01e5\u0001\u0000\u0000\u0000\u01c7\u01c5\u0001\u0000"+
		"\u0000\u0000\u01c8\u01d9\u0003\u0012\t\u0000\u01c9\u01cb\u0005\u0004\u0000"+
		"\u0000\u01ca\u01c9\u0001\u0000\u0000\u0000\u01cb\u01ce\u0001\u0000\u0000"+
		"\u0000\u01cc\u01ca\u0001\u0000\u0000\u0000\u01cc\u01cd\u0001\u0000\u0000"+
		"\u0000\u01cd\u01cf\u0001\u0000\u0000\u0000\u01ce\u01cc\u0001\u0000\u0000"+
		"\u0000\u01cf\u01d3\u0005\u0007\u0000\u0000\u01d0\u01d2\u0005\u0004\u0000"+
		"\u0000\u01d1\u01d0\u0001\u0000\u0000\u0000\u01d2\u01d5\u0001\u0000\u0000"+
		"\u0000\u01d3\u01d1\u0001\u0000\u0000\u0000\u01d3\u01d4\u0001\u0000\u0000"+
		"\u0000\u01d4\u01d6\u0001\u0000\u0000\u0000\u01d5\u01d3\u0001\u0000\u0000"+
		"\u0000\u01d6\u01d8\u0003\u0012\t\u0000\u01d7\u01cc\u0001\u0000\u0000\u0000"+
		"\u01d8\u01db\u0001\u0000\u0000\u0000\u01d9\u01d7\u0001\u0000\u0000\u0000"+
		"\u01d9\u01da\u0001\u0000\u0000\u0000\u01da\u01e3\u0001\u0000\u0000\u0000"+
		"\u01db\u01d9\u0001\u0000\u0000\u0000\u01dc\u01de\u0005\u0004\u0000\u0000"+
		"\u01dd\u01dc\u0001\u0000\u0000\u0000\u01de\u01e1\u0001\u0000\u0000\u0000"+
		"\u01df\u01dd\u0001\u0000\u0000\u0000\u01df\u01e0\u0001\u0000\u0000\u0000"+
		"\u01e0\u01e2\u0001\u0000\u0000\u0000\u01e1\u01df\u0001\u0000\u0000\u0000"+
		"\u01e2\u01e4\u0005\u0007\u0000\u0000\u01e3\u01df\u0001\u0000\u0000\u0000"+
		"\u01e3\u01e4\u0001\u0000\u0000\u0000\u01e4\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e5\u01c8\u0001\u0000\u0000\u0000\u01e5\u01e6\u0001\u0000\u0000\u0000"+
		"\u01e6\u01ea\u0001\u0000\u0000\u0000\u01e7\u01e9\u0005\u0004\u0000\u0000"+
		"\u01e8\u01e7\u0001\u0000\u0000\u0000\u01e9\u01ec\u0001\u0000\u0000\u0000"+
		"\u01ea\u01e8\u0001\u0000\u0000\u0000\u01ea\u01eb\u0001\u0000\u0000\u0000"+
		"\u01eb\u01ed\u0001\u0000\u0000\u0000\u01ec\u01ea\u0001\u0000\u0000\u0000"+
		"\u01ed\u01ee\u0005\t\u0000\u0000\u01ee\u0011\u0001\u0000\u0000\u0000\u01ef"+
		"\u01f1\u0003\u0106\u0083\u0000\u01f0\u01ef\u0001\u0000\u0000\u0000\u01f0"+
		"\u01f1\u0001\u0000\u0000\u0000\u01f1\u01f3\u0001\u0000\u0000\u0000\u01f2"+
		"\u01f4\u0007\u0000\u0000\u0000\u01f3\u01f2\u0001\u0000\u0000\u0000\u01f3"+
		"\u01f4\u0001\u0000\u0000\u0000\u01f4\u01f8\u0001\u0000\u0000\u0000\u01f5"+
		"\u01f7\u0005\u0004\u0000\u0000\u01f6\u01f5\u0001\u0000\u0000\u0000\u01f7"+
		"\u01fa\u0001\u0000\u0000\u0000\u01f8\u01f6\u0001\u0000\u0000\u0000\u01f8"+
		"\u01f9\u0001\u0000\u0000\u0000\u01f9\u01fb\u0001\u0000\u0000\u0000\u01fa"+
		"\u01f8\u0001\u0000\u0000\u0000\u01fb\u01fc\u0003\u0124\u0092\u0000\u01fc"+
		"\u0200\u0005\u0019\u0000\u0000\u01fd\u01ff\u0005\u0004\u0000\u0000\u01fe"+
		"\u01fd\u0001\u0000\u0000\u0000\u01ff\u0202\u0001\u0000\u0000\u0000\u0200"+
		"\u01fe\u0001\u0000\u0000\u0000\u0200\u0201\u0001\u0000\u0000\u0000\u0201"+
		"\u0203\u0001\u0000\u0000\u0000\u0202\u0200\u0001\u0000\u0000\u0000\u0203"+
		"\u0212\u0003N\'\u0000\u0204\u0206\u0005\u0004\u0000\u0000\u0205\u0204"+
		"\u0001\u0000\u0000\u0000\u0206\u0209\u0001\u0000\u0000\u0000\u0207\u0205"+
		"\u0001\u0000\u0000\u0000\u0207\u0208\u0001\u0000\u0000\u0000\u0208\u020a"+
		"\u0001\u0000\u0000\u0000\u0209\u0207\u0001\u0000\u0000\u0000\u020a\u020e"+
		"\u0005\u001b\u0000\u0000\u020b\u020d\u0005\u0004\u0000\u0000\u020c\u020b"+
		"\u0001\u0000\u0000\u0000\u020d\u0210\u0001\u0000\u0000\u0000\u020e\u020c"+
		"\u0001\u0000\u0000\u0000\u020e\u020f\u0001\u0000\u0000\u0000\u020f\u0211"+
		"\u0001\u0000\u0000\u0000\u0210\u020e\u0001\u0000\u0000\u0000\u0211\u0213"+
		"\u0003~?\u0000\u0212\u0207\u0001\u0000\u0000\u0000\u0212\u0213\u0001\u0000"+
		"\u0000\u0000\u0213\u0013\u0001\u0000\u0000\u0000\u0214\u0225\u0003\u0016"+
		"\u000b\u0000\u0215\u0217\u0005\u0004\u0000\u0000\u0216\u0215\u0001\u0000"+
		"\u0000\u0000\u0217\u021a\u0001\u0000\u0000\u0000\u0218\u0216\u0001\u0000"+
		"\u0000\u0000\u0218\u0219\u0001\u0000\u0000\u0000\u0219\u021b\u0001\u0000"+
		"\u0000\u0000\u021a\u0218\u0001\u0000\u0000\u0000\u021b\u021f\u0005\u0007"+
		"\u0000\u0000\u021c\u021e\u0005\u0004\u0000\u0000\u021d\u021c\u0001\u0000"+
		"\u0000\u0000\u021e\u0221\u0001\u0000\u0000\u0000\u021f\u021d\u0001\u0000"+
		"\u0000\u0000\u021f\u0220\u0001\u0000\u0000\u0000\u0220\u0222\u0001\u0000"+
		"\u0000\u0000\u0221\u021f\u0001\u0000\u0000\u0000\u0222\u0224\u0003\u0016"+
		"\u000b\u0000\u0223\u0218\u0001\u0000\u0000\u0000\u0224\u0227\u0001\u0000"+
		"\u0000\u0000\u0225\u0223\u0001\u0000\u0000\u0000\u0225\u0226\u0001\u0000"+
		"\u0000\u0000\u0226\u0015\u0001\u0000\u0000\u0000\u0227\u0225\u0001\u0000"+
		"\u0000\u0000\u0228\u022a\u0003\u011c\u008e\u0000\u0229\u0228\u0001\u0000"+
		"\u0000\u0000\u022a\u022d\u0001\u0000\u0000\u0000\u022b\u0229\u0001\u0000"+
		"\u0000\u0000\u022b\u022c\u0001\u0000\u0000\u0000\u022c\u0231\u0001\u0000"+
		"\u0000\u0000\u022d\u022b\u0001\u0000\u0000\u0000\u022e\u0230\u0005\u0004"+
		"\u0000\u0000\u022f\u022e\u0001\u0000\u0000\u0000\u0230\u0233\u0001\u0000"+
		"\u0000\u0000\u0231\u022f\u0001\u0000\u0000\u0000\u0231\u0232\u0001\u0000"+
		"\u0000\u0000\u0232\u0234\u0001\u0000\u0000\u0000\u0233\u0231\u0001\u0000"+
		"\u0000\u0000\u0234\u0235\u0003\u0018\f\u0000\u0235\u0017\u0001\u0000\u0000"+
		"\u0000\u0236\u023b\u0003\u001a\r\u0000\u0237\u023b\u0003\u001c\u000e\u0000"+
		"\u0238\u023b\u0003T*\u0000\u0239\u023b\u0003^/\u0000\u023a\u0236\u0001"+
		"\u0000\u0000\u0000\u023a\u0237\u0001\u0000\u0000\u0000\u023a\u0238\u0001"+
		"\u0000\u0000\u0000\u023a\u0239\u0001\u0000\u0000\u0000\u023b\u0019\u0001"+
		"\u0000\u0000\u0000\u023c\u0240\u0003T*\u0000\u023d\u023f\u0005\u0004\u0000"+
		"\u0000\u023e\u023d\u0001\u0000\u0000\u0000\u023f\u0242\u0001\u0000\u0000"+
		"\u0000\u0240\u023e\u0001\u0000\u0000\u0000\u0240\u0241\u0001\u0000\u0000"+
		"\u0000\u0241\u0243\u0001\u0000\u0000\u0000\u0242\u0240\u0001\u0000\u0000"+
		"\u0000\u0243\u0244\u0003\u00e4r\u0000\u0244\u001b\u0001\u0000\u0000\u0000"+
		"\u0245\u0248\u0003T*\u0000\u0246\u0248\u0003^/\u0000\u0247\u0245\u0001"+
		"\u0000\u0000\u0000\u0247\u0246\u0001\u0000\u0000\u0000\u0248\u024c\u0001"+
		"\u0000\u0000\u0000\u0249\u024b\u0005\u0004\u0000\u0000\u024a\u0249\u0001"+
		"\u0000\u0000\u0000\u024b\u024e\u0001\u0000\u0000\u0000\u024c\u024a\u0001"+
		"\u0000\u0000\u0000\u024c\u024d\u0001\u0000\u0000\u0000\u024d\u024f\u0001"+
		"\u0000\u0000\u0000\u024e\u024c\u0001\u0000\u0000\u0000\u024f\u0253\u0005"+
		"?\u0000\u0000\u0250\u0252\u0005\u0004\u0000\u0000\u0251\u0250\u0001\u0000"+
		"\u0000\u0000\u0252\u0255\u0001\u0000\u0000\u0000\u0253\u0251\u0001\u0000"+
		"\u0000\u0000\u0253\u0254\u0001\u0000\u0000\u0000\u0254\u0256\u0001\u0000"+
		"\u0000\u0000\u0255\u0253\u0001\u0000\u0000\u0000\u0256\u0257\u0003~?\u0000"+
		"\u0257\u001d\u0001\u0000\u0000\u0000\u0258\u025c\u0005\f\u0000\u0000\u0259"+
		"\u025b\u0005\u0004\u0000\u0000\u025a\u0259\u0001\u0000\u0000\u0000\u025b"+
		"\u025e\u0001\u0000\u0000\u0000\u025c\u025a\u0001\u0000\u0000\u0000\u025c"+
		"\u025d\u0001\u0000\u0000\u0000\u025d\u0262\u0001\u0000\u0000\u0000\u025e"+
		"\u025c\u0001\u0000\u0000\u0000\u025f\u0261\u0003(\u0014\u0000\u0260\u025f"+
		"\u0001\u0000\u0000\u0000\u0261\u0264\u0001\u0000\u0000\u0000\u0262\u0260"+
		"\u0001\u0000\u0000\u0000\u0262\u0263\u0001\u0000\u0000\u0000\u0263\u0268"+
		"\u0001\u0000\u0000\u0000\u0264\u0262\u0001\u0000\u0000\u0000\u0265\u0267"+
		"\u0005\u0004\u0000\u0000\u0266\u0265\u0001\u0000\u0000\u0000\u0267\u026a"+
		"\u0001\u0000\u0000\u0000\u0268\u0266\u0001\u0000\u0000\u0000\u0268\u0269"+
		"\u0001\u0000\u0000\u0000\u0269\u026b\u0001\u0000\u0000\u0000\u026a\u0268"+
		"\u0001\u0000\u0000\u0000\u026b\u026c\u0005\r\u0000\u0000\u026c\u001f\u0001"+
		"\u0000\u0000\u0000\u026d\u0271\u0005+\u0000\u0000\u026e\u0270\u0005\u0004"+
		"\u0000\u0000\u026f\u026e\u0001\u0000\u0000\u0000\u0270\u0273\u0001\u0000"+
		"\u0000\u0000\u0271\u026f\u0001\u0000\u0000\u0000\u0271\u0272\u0001\u0000"+
		"\u0000\u0000\u0272\u0274\u0001\u0000\u0000\u0000\u0273\u0271\u0001\u0000"+
		"\u0000\u0000\u0274\u0285\u0003\"\u0011\u0000\u0275\u0277\u0005\u0004\u0000"+
		"\u0000\u0276\u0275\u0001\u0000\u0000\u0000\u0277\u027a\u0001\u0000\u0000"+
		"\u0000\u0278\u0276\u0001\u0000\u0000\u0000\u0278\u0279\u0001\u0000\u0000"+
		"\u0000\u0279\u027b\u0001\u0000\u0000\u0000\u027a\u0278\u0001\u0000\u0000"+
		"\u0000\u027b\u027f\u0005\u0007\u0000\u0000\u027c\u027e\u0005\u0004\u0000"+
		"\u0000\u027d\u027c\u0001\u0000\u0000\u0000\u027e\u0281\u0001\u0000\u0000"+
		"\u0000\u027f\u027d\u0001\u0000\u0000\u0000\u027f\u0280\u0001\u0000\u0000"+
		"\u0000\u0280\u0282\u0001\u0000\u0000\u0000\u0281\u027f\u0001\u0000\u0000"+
		"\u0000\u0282\u0284\u0003\"\u0011\u0000\u0283\u0278\u0001\u0000\u0000\u0000"+
		"\u0284\u0287\u0001\u0000\u0000\u0000\u0285\u0283\u0001\u0000\u0000\u0000"+
		"\u0285\u0286\u0001\u0000\u0000\u0000\u0286\u028f\u0001\u0000\u0000\u0000"+
		"\u0287\u0285\u0001\u0000\u0000\u0000\u0288\u028a\u0005\u0004\u0000\u0000"+
		"\u0289\u0288\u0001\u0000\u0000\u0000\u028a\u028d\u0001\u0000\u0000\u0000"+
		"\u028b\u0289\u0001\u0000\u0000\u0000\u028b\u028c\u0001\u0000\u0000\u0000"+
		"\u028c\u028e\u0001\u0000\u0000\u0000\u028d\u028b\u0001\u0000\u0000\u0000"+
		"\u028e\u0290\u0005\u0007\u0000\u0000\u028f\u028b\u0001\u0000\u0000\u0000"+
		"\u028f\u0290\u0001\u0000\u0000\u0000\u0290\u0294\u0001\u0000\u0000\u0000"+
		"\u0291\u0293\u0005\u0004\u0000\u0000\u0292\u0291\u0001\u0000\u0000\u0000"+
		"\u0293\u0296\u0001\u0000\u0000\u0000\u0294\u0292\u0001\u0000\u0000\u0000"+
		"\u0294\u0295\u0001\u0000\u0000\u0000\u0295\u0297\u0001\u0000\u0000\u0000"+
		"\u0296\u0294\u0001\u0000\u0000\u0000\u0297\u0298\u0005,\u0000\u0000\u0298"+
		"!\u0001\u0000\u0000\u0000\u0299\u029b\u0003\u0114\u008a\u0000\u029a\u0299"+
		"\u0001\u0000\u0000\u0000\u029a\u029b\u0001\u0000\u0000\u0000\u029b\u029f"+
		"\u0001\u0000\u0000\u0000\u029c\u029e\u0005\u0004\u0000\u0000\u029d\u029c"+
		"\u0001\u0000\u0000\u0000\u029e\u02a1\u0001\u0000\u0000\u0000\u029f\u029d"+
		"\u0001\u0000\u0000\u0000\u029f\u02a0\u0001\u0000\u0000\u0000\u02a0\u02a4"+
		"\u0001\u0000\u0000\u0000\u02a1\u029f\u0001\u0000\u0000\u0000\u02a2\u02a5"+
		"\u0003\u0124\u0092\u0000\u02a3\u02a5\u0005\u000e\u0000\u0000\u02a4\u02a2"+
		"\u0001\u0000\u0000\u0000\u02a4\u02a3\u0001\u0000\u0000\u0000\u02a5\u02b4"+
		"\u0001\u0000\u0000\u0000\u02a6\u02a8\u0005\u0004\u0000\u0000\u02a7\u02a6"+
		"\u0001\u0000\u0000\u0000\u02a8\u02ab\u0001\u0000\u0000\u0000\u02a9\u02a7"+
		"\u0001\u0000\u0000\u0000\u02a9\u02aa\u0001\u0000\u0000\u0000\u02aa\u02ac"+
		"\u0001\u0000\u0000\u0000\u02ab\u02a9\u0001\u0000\u0000\u0000\u02ac\u02b0"+
		"\u0005\u0019\u0000\u0000\u02ad\u02af\u0005\u0004\u0000\u0000\u02ae\u02ad"+
		"\u0001\u0000\u0000\u0000\u02af\u02b2\u0001\u0000\u0000\u0000\u02b0\u02ae"+
		"\u0001\u0000\u0000\u0000\u02b0\u02b1\u0001\u0000\u0000\u0000\u02b1\u02b3"+
		"\u0001\u0000\u0000\u0000\u02b2\u02b0\u0001\u0000\u0000\u0000\u02b3\u02b5"+
		"\u0003N\'\u0000\u02b4\u02a9\u0001\u0000\u0000\u0000\u02b4\u02b5\u0001"+
		"\u0000\u0000\u0000\u02b5#\u0001\u0000\u0000\u0000\u02b6\u02ba\u0005D\u0000"+
		"\u0000\u02b7\u02b9\u0005\u0004\u0000\u0000\u02b8\u02b7\u0001\u0000\u0000"+
		"\u0000\u02b9\u02bc\u0001\u0000\u0000\u0000\u02ba\u02b8\u0001\u0000\u0000"+
		"\u0000\u02ba\u02bb\u0001\u0000\u0000\u0000\u02bb\u02bd\u0001\u0000\u0000"+
		"\u0000\u02bc\u02ba\u0001\u0000\u0000\u0000\u02bd\u02ce\u0003&\u0013\u0000"+
		"\u02be\u02c0\u0005\u0004\u0000\u0000\u02bf\u02be\u0001\u0000\u0000\u0000"+
		"\u02c0\u02c3\u0001\u0000\u0000\u0000\u02c1\u02bf\u0001\u0000\u0000\u0000"+
		"\u02c1\u02c2\u0001\u0000\u0000\u0000\u02c2\u02c4\u0001\u0000\u0000\u0000"+
		"\u02c3\u02c1\u0001\u0000\u0000\u0000\u02c4\u02c8\u0005\u0007\u0000\u0000"+
		"\u02c5\u02c7\u0005\u0004\u0000\u0000\u02c6\u02c5\u0001\u0000\u0000\u0000"+
		"\u02c7\u02ca\u0001\u0000\u0000\u0000\u02c8\u02c6\u0001\u0000\u0000\u0000"+
		"\u02c8\u02c9\u0001\u0000\u0000\u0000\u02c9\u02cb\u0001\u0000\u0000\u0000"+
		"\u02ca\u02c8\u0001\u0000\u0000\u0000\u02cb\u02cd\u0003&\u0013\u0000\u02cc"+
		"\u02c1\u0001\u0000\u0000\u0000\u02cd\u02d0\u0001\u0000\u0000\u0000\u02ce"+
		"\u02cc\u0001\u0000\u0000\u0000\u02ce\u02cf\u0001\u0000\u0000\u0000\u02cf"+
		"%\u0001\u0000\u0000\u0000\u02d0\u02ce\u0001\u0000\u0000\u0000\u02d1\u02d3"+
		"\u0003\u011c\u008e\u0000\u02d2\u02d1\u0001\u0000\u0000\u0000\u02d3\u02d6"+
		"\u0001\u0000\u0000\u0000\u02d4\u02d2\u0001\u0000\u0000\u0000\u02d4\u02d5"+
		"\u0001\u0000\u0000\u0000\u02d5\u02d7\u0001\u0000\u0000\u0000\u02d6\u02d4"+
		"\u0001\u0000\u0000\u0000\u02d7\u02db\u0003\u0124\u0092\u0000\u02d8\u02da"+
		"\u0005\u0004\u0000\u0000\u02d9\u02d8\u0001\u0000\u0000\u0000\u02da\u02dd"+
		"\u0001\u0000\u0000\u0000\u02db\u02d9\u0001\u0000\u0000\u0000\u02db\u02dc"+
		"\u0001\u0000\u0000\u0000\u02dc\u02de\u0001\u0000\u0000\u0000\u02dd\u02db"+
		"\u0001\u0000\u0000\u0000\u02de\u02e2\u0005\u0019\u0000\u0000\u02df\u02e1"+
		"\u0005\u0004\u0000\u0000\u02e0\u02df\u0001\u0000\u0000\u0000\u02e1\u02e4"+
		"\u0001\u0000\u0000\u0000\u02e2\u02e0\u0001\u0000\u0000\u0000\u02e2\u02e3"+
		"\u0001\u0000\u0000\u0000\u02e3\u02e5\u0001\u0000\u0000\u0000\u02e4\u02e2"+
		"\u0001\u0000\u0000\u0000\u02e5\u02e6\u0003N\'\u0000\u02e6\'\u0001\u0000"+
		"\u0000\u0000\u02e7\u02eb\u0003\n\u0005\u0000\u02e8\u02eb\u0003*\u0015"+
		"\u0000\u02e9\u02eb\u0003,\u0016\u0000\u02ea\u02e7\u0001\u0000\u0000\u0000"+
		"\u02ea\u02e8\u0001\u0000\u0000\u0000\u02ea\u02e9\u0001\u0000\u0000\u0000"+
		"\u02eb\u02ed\u0001\u0000\u0000\u0000\u02ec\u02ee\u0003\u012a\u0095\u0000"+
		"\u02ed\u02ec\u0001\u0000\u0000\u0000\u02ee\u02ef\u0001\u0000\u0000\u0000"+
		"\u02ef\u02ed\u0001\u0000\u0000\u0000\u02ef\u02f0\u0001\u0000\u0000\u0000"+
		"\u02f0)\u0001\u0000\u0000\u0000\u02f1\u02f5\u0005@\u0000\u0000\u02f2\u02f4"+
		"\u0005\u0004\u0000\u0000\u02f3\u02f2\u0001\u0000\u0000\u0000\u02f4\u02f7"+
		"\u0001\u0000\u0000\u0000\u02f5\u02f3\u0001\u0000\u0000\u0000\u02f5\u02f6"+
		"\u0001\u0000\u0000\u0000\u02f6\u02f8\u0001\u0000\u0000\u0000\u02f7\u02f5"+
		"\u0001\u0000\u0000\u0000\u02f8\u02f9\u0003|>\u0000\u02f9+\u0001\u0000"+
		"\u0000\u0000\u02fa\u02fc\u0003\u0106\u0083\u0000\u02fb\u02fa\u0001\u0000"+
		"\u0000\u0000\u02fb\u02fc\u0001\u0000\u0000\u0000\u02fc\u02fd\u0001\u0000"+
		"\u0000\u0000\u02fd\u0301\u0005>\u0000\u0000\u02fe\u0300\u0005\u0004\u0000"+
		"\u0000\u02ff\u02fe\u0001\u0000\u0000\u0000\u0300\u0303\u0001\u0000\u0000"+
		"\u0000\u0301\u02ff\u0001\u0000\u0000\u0000\u0301\u0302\u0001\u0000\u0000"+
		"\u0000\u0302\u0304\u0001\u0000\u0000\u0000\u0303\u0301\u0001\u0000\u0000"+
		"\u0000\u0304\u0313\u00032\u0019\u0000\u0305\u0307\u0005\u0004\u0000\u0000"+
		"\u0306\u0305\u0001\u0000\u0000\u0000\u0307\u030a\u0001\u0000\u0000\u0000"+
		"\u0308\u0306\u0001\u0000\u0000\u0000\u0308\u0309\u0001\u0000\u0000\u0000"+
		"\u0309\u030b\u0001\u0000\u0000\u0000\u030a\u0308\u0001\u0000\u0000\u0000"+
		"\u030b\u030f\u0005\u0019\u0000\u0000\u030c\u030e\u0005\u0004\u0000\u0000"+
		"\u030d\u030c\u0001\u0000\u0000\u0000\u030e\u0311\u0001\u0000\u0000\u0000"+
		"\u030f\u030d\u0001\u0000\u0000\u0000\u030f\u0310\u0001\u0000\u0000\u0000"+
		"\u0310\u0312\u0001\u0000\u0000\u0000\u0311\u030f\u0001\u0000\u0000\u0000"+
		"\u0312\u0314\u0003.\u0017\u0000\u0313\u0308\u0001\u0000\u0000\u0000\u0313"+
		"\u0314\u0001\u0000\u0000\u0000\u0314\u0318\u0001\u0000\u0000\u0000\u0315"+
		"\u0317\u0005\u0004\u0000\u0000\u0316\u0315\u0001\u0000\u0000\u0000\u0317"+
		"\u031a\u0001\u0000\u0000\u0000\u0318\u0316\u0001\u0000\u0000\u0000\u0318"+
		"\u0319\u0001\u0000\u0000\u0000\u0319\u031c\u0001\u0000\u0000\u0000\u031a"+
		"\u0318\u0001\u0000\u0000\u0000\u031b\u031d\u0003|>\u0000\u031c\u031b\u0001"+
		"\u0000\u0000\u0000\u031c\u031d\u0001\u0000\u0000\u0000\u031d-\u0001\u0000"+
		"\u0000\u0000\u031e\u0322\u0007\u0001\u0000\u0000\u031f\u0321\u0005\u0004"+
		"\u0000\u0000\u0320\u031f\u0001\u0000\u0000\u0000\u0321\u0324\u0001\u0000"+
		"\u0000\u0000\u0322\u0320\u0001\u0000\u0000\u0000\u0322\u0323\u0001\u0000"+
		"\u0000\u0000\u0323\u0325\u0001\u0000\u0000\u0000\u0324\u0322\u0001\u0000"+
		"\u0000\u0000\u0325\u0326\u0003\u00eau\u0000\u0326/\u0001\u0000\u0000\u0000"+
		"\u0327\u0329\u0003\u0106\u0083\u0000\u0328\u0327\u0001\u0000\u0000\u0000"+
		"\u0328\u0329\u0001\u0000\u0000\u0000\u0329\u032a\u0001\u0000\u0000\u0000"+
		"\u032a\u0332\u0005;\u0000\u0000\u032b\u032d\u0005\u0004\u0000\u0000\u032c"+
		"\u032b\u0001\u0000\u0000\u0000\u032d\u0330\u0001\u0000\u0000\u0000\u032e"+
		"\u032c\u0001\u0000\u0000\u0000\u032e\u032f\u0001\u0000\u0000\u0000\u032f"+
		"\u0331\u0001\u0000\u0000\u0000\u0330\u032e\u0001\u0000\u0000\u0000\u0331"+
		"\u0333\u0003 \u0010\u0000\u0332\u032e\u0001\u0000\u0000\u0000\u0332\u0333"+
		"\u0001\u0000\u0000\u0000\u0333\u0343\u0001\u0000\u0000\u0000\u0334\u0336"+
		"\u0005\u0004\u0000\u0000\u0335\u0334\u0001\u0000\u0000\u0000\u0336\u0339"+
		"\u0001\u0000\u0000\u0000\u0337\u0335\u0001\u0000\u0000\u0000\u0337\u0338"+
		"\u0001\u0000\u0000\u0000\u0338\u033a\u0001\u0000\u0000\u0000\u0339\u0337"+
		"\u0001\u0000\u0000\u0000\u033a\u033e\u0003d2\u0000\u033b\u033d\u0005\u0004"+
		"\u0000\u0000\u033c\u033b\u0001\u0000\u0000\u0000\u033d\u0340\u0001\u0000"+
		"\u0000\u0000\u033e\u033c\u0001\u0000\u0000\u0000\u033e\u033f\u0001\u0000"+
		"\u0000\u0000\u033f\u0341\u0001\u0000\u0000\u0000\u0340\u033e\u0001\u0000"+
		"\u0000\u0000\u0341\u0342\u0005\u0006\u0000\u0000\u0342\u0344\u0001\u0000"+
		"\u0000\u0000\u0343\u0337\u0001\u0000\u0000\u0000\u0343\u0344\u0001\u0000"+
		"\u0000\u0000\u0344\u0348\u0001\u0000\u0000\u0000\u0345\u0347\u0005\u0004"+
		"\u0000\u0000\u0346\u0345\u0001\u0000\u0000\u0000\u0347\u034a\u0001\u0000"+
		"\u0000\u0000\u0348\u0346\u0001\u0000\u0000\u0000\u0348\u0349\u0001\u0000"+
		"\u0000\u0000\u0349\u034b\u0001\u0000\u0000\u0000\u034a\u0348\u0001\u0000"+
		"\u0000\u0000\u034b\u034f\u0003\u0124\u0092\u0000\u034c\u034e\u0005\u0004"+
		"\u0000\u0000\u034d\u034c\u0001\u0000\u0000\u0000\u034e\u0351\u0001\u0000"+
		"\u0000\u0000\u034f\u034d\u0001\u0000\u0000\u0000\u034f\u0350\u0001\u0000"+
		"\u0000\u0000\u0350\u0352\u0001\u0000\u0000\u0000\u0351\u034f\u0001\u0000"+
		"\u0000\u0000\u0352\u0361\u00032\u0019\u0000\u0353\u0355\u0005\u0004\u0000"+
		"\u0000\u0354\u0353\u0001\u0000\u0000\u0000\u0355\u0358\u0001\u0000\u0000"+
		"\u0000\u0356\u0354\u0001\u0000\u0000\u0000\u0356\u0357\u0001\u0000\u0000"+
		"\u0000\u0357\u0359\u0001\u0000\u0000\u0000\u0358\u0356\u0001\u0000\u0000"+
		"\u0000\u0359\u035d\u0005\u0019\u0000\u0000\u035a\u035c\u0005\u0004\u0000"+
		"\u0000\u035b\u035a\u0001\u0000\u0000\u0000\u035c\u035f\u0001\u0000\u0000"+
		"\u0000\u035d\u035b\u0001\u0000\u0000\u0000\u035d\u035e\u0001\u0000\u0000"+
		"\u0000\u035e\u0360\u0001\u0000\u0000\u0000\u035f\u035d\u0001\u0000\u0000"+
		"\u0000\u0360\u0362\u0003N\'\u0000\u0361\u0356\u0001\u0000\u0000\u0000"+
		"\u0361\u0362\u0001\u0000\u0000\u0000\u0362\u036a\u0001\u0000\u0000\u0000"+
		"\u0363\u0365\u0005\u0004\u0000\u0000\u0364\u0363\u0001\u0000\u0000\u0000"+
		"\u0365\u0368\u0001\u0000\u0000\u0000\u0366\u0364\u0001\u0000\u0000\u0000"+
		"\u0366\u0367\u0001\u0000\u0000\u0000\u0367\u0369\u0001\u0000\u0000\u0000"+
		"\u0368\u0366\u0001\u0000\u0000\u0000\u0369\u036b\u0003$\u0012\u0000\u036a"+
		"\u0366\u0001\u0000\u0000\u0000\u036a\u036b\u0001\u0000\u0000\u0000\u036b"+
		"\u0373\u0001\u0000\u0000\u0000\u036c\u036e\u0005\u0004\u0000\u0000\u036d"+
		"\u036c\u0001\u0000\u0000\u0000\u036e\u0371\u0001\u0000\u0000\u0000\u036f"+
		"\u036d\u0001\u0000\u0000\u0000\u036f\u0370\u0001\u0000\u0000\u0000\u0370"+
		"\u0372\u0001\u0000\u0000\u0000\u0371\u036f\u0001\u0000\u0000\u0000\u0372"+
		"\u0374\u00036\u001b\u0000\u0373\u036f\u0001\u0000\u0000\u0000\u0373\u0374"+
		"\u0001\u0000\u0000\u0000\u03741\u0001\u0000\u0000\u0000\u0375\u0379\u0005"+
		"\b\u0000\u0000\u0376\u0378\u0005\u0004\u0000\u0000\u0377\u0376\u0001\u0000"+
		"\u0000\u0000\u0378\u037b\u0001\u0000\u0000\u0000\u0379\u0377\u0001\u0000"+
		"\u0000\u0000\u0379\u037a\u0001\u0000\u0000\u0000\u037a\u0399\u0001\u0000"+
		"\u0000\u0000\u037b\u0379\u0001\u0000\u0000\u0000\u037c\u038d\u00034\u001a"+
		"\u0000\u037d\u037f\u0005\u0004\u0000\u0000\u037e\u037d\u0001\u0000\u0000"+
		"\u0000\u037f\u0382\u0001\u0000\u0000\u0000\u0380\u037e\u0001\u0000\u0000"+
		"\u0000\u0380\u0381\u0001\u0000\u0000\u0000\u0381\u0383\u0001\u0000\u0000"+
		"\u0000\u0382\u0380\u0001\u0000\u0000\u0000\u0383\u0387\u0005\u0007\u0000"+
		"\u0000\u0384\u0386\u0005\u0004\u0000\u0000\u0385\u0384\u0001\u0000\u0000"+
		"\u0000\u0386\u0389\u0001\u0000\u0000\u0000\u0387\u0385\u0001\u0000\u0000"+
		"\u0000\u0387\u0388\u0001\u0000\u0000\u0000\u0388\u038a\u0001\u0000\u0000"+
		"\u0000\u0389\u0387\u0001\u0000\u0000\u0000\u038a\u038c\u00034\u001a\u0000"+
		"\u038b\u0380\u0001\u0000\u0000\u0000\u038c\u038f\u0001\u0000\u0000\u0000"+
		"\u038d\u038b\u0001\u0000\u0000\u0000\u038d\u038e\u0001\u0000\u0000\u0000"+
		"\u038e\u0397\u0001\u0000\u0000\u0000\u038f\u038d\u0001\u0000\u0000\u0000"+
		"\u0390\u0392\u0005\u0004\u0000\u0000\u0391\u0390\u0001\u0000\u0000\u0000"+
		"\u0392\u0395\u0001\u0000\u0000\u0000\u0393\u0391\u0001\u0000\u0000\u0000"+
		"\u0393\u0394\u0001\u0000\u0000\u0000\u0394\u0396\u0001\u0000\u0000\u0000"+
		"\u0395\u0393\u0001\u0000\u0000\u0000\u0396\u0398\u0005\u0007\u0000\u0000"+
		"\u0397\u0393\u0001\u0000\u0000\u0000\u0397\u0398\u0001\u0000\u0000\u0000"+
		"\u0398\u039a\u0001\u0000\u0000\u0000\u0399\u037c\u0001\u0000\u0000\u0000"+
		"\u0399\u039a\u0001\u0000\u0000\u0000\u039a\u039e\u0001\u0000\u0000\u0000"+
		"\u039b\u039d\u0005\u0004\u0000\u0000\u039c\u039b\u0001\u0000\u0000\u0000"+
		"\u039d\u03a0\u0001\u0000\u0000\u0000\u039e\u039c\u0001\u0000\u0000\u0000"+
		"\u039e\u039f\u0001\u0000\u0000\u0000\u039f\u03a1\u0001\u0000\u0000\u0000"+
		"\u03a0\u039e\u0001\u0000\u0000\u0000\u03a1\u03a2\u0005\t\u0000\u0000\u03a2"+
		"3\u0001\u0000\u0000\u0000\u03a3\u03a5\u0003\u0108\u0084\u0000\u03a4\u03a3"+
		"\u0001\u0000\u0000\u0000\u03a4\u03a5\u0001\u0000\u0000\u0000\u03a5\u03a6"+
		"\u0001\u0000\u0000\u0000\u03a6\u03b5\u0003F#\u0000\u03a7\u03a9\u0005\u0004"+
		"\u0000\u0000\u03a8\u03a7\u0001\u0000\u0000\u0000\u03a9\u03ac\u0001\u0000"+
		"\u0000\u0000\u03aa\u03a8\u0001\u0000\u0000\u0000\u03aa\u03ab\u0001\u0000"+
		"\u0000\u0000\u03ab\u03ad\u0001\u0000\u0000\u0000\u03ac\u03aa\u0001\u0000"+
		"\u0000\u0000\u03ad\u03b1\u0005\u001b\u0000\u0000\u03ae\u03b0\u0005\u0004"+
		"\u0000\u0000\u03af\u03ae\u0001\u0000\u0000\u0000\u03b0\u03b3\u0001\u0000"+
		"\u0000\u0000\u03b1\u03af\u0001\u0000\u0000\u0000\u03b1\u03b2\u0001\u0000"+
		"\u0000\u0000\u03b2\u03b4\u0001\u0000\u0000\u0000\u03b3\u03b1\u0001\u0000"+
		"\u0000\u0000\u03b4\u03b6\u0003~?\u0000\u03b5\u03aa\u0001\u0000\u0000\u0000"+
		"\u03b5\u03b6\u0001\u0000\u0000\u0000\u03b65\u0001\u0000\u0000\u0000\u03b7"+
		"\u03c1\u0003|>\u0000\u03b8\u03bc\u0005\u001b\u0000\u0000\u03b9\u03bb\u0005"+
		"\u0004\u0000\u0000\u03ba\u03b9\u0001\u0000\u0000\u0000\u03bb\u03be\u0001"+
		"\u0000\u0000\u0000\u03bc\u03ba\u0001\u0000\u0000\u0000\u03bc\u03bd\u0001"+
		"\u0000\u0000\u0000\u03bd\u03bf\u0001\u0000\u0000\u0000\u03be\u03bc\u0001"+
		"\u0000\u0000\u0000\u03bf\u03c1\u0003~?\u0000\u03c0\u03b7\u0001\u0000\u0000"+
		"\u0000\u03c0\u03b8\u0001\u0000\u0000\u0000\u03c17\u0001\u0000\u0000\u0000"+
		"\u03c2\u03c4\u0003\u0106\u0083\u0000\u03c3\u03c2\u0001\u0000\u0000\u0000"+
		"\u03c3\u03c4\u0001\u0000\u0000\u0000\u03c4\u03c5\u0001\u0000\u0000\u0000"+
		"\u03c5\u03cd\u0007\u0000\u0000\u0000\u03c6\u03c8\u0005\u0004\u0000\u0000"+
		"\u03c7\u03c6\u0001\u0000\u0000\u0000\u03c8\u03cb\u0001\u0000\u0000\u0000"+
		"\u03c9\u03c7\u0001\u0000\u0000\u0000\u03c9\u03ca\u0001\u0000\u0000\u0000"+
		"\u03ca\u03cc\u0001\u0000\u0000\u0000\u03cb\u03c9\u0001\u0000\u0000\u0000"+
		"\u03cc\u03ce\u0003 \u0010\u0000\u03cd\u03c9\u0001\u0000\u0000\u0000\u03cd"+
		"\u03ce\u0001\u0000\u0000\u0000\u03ce\u03de\u0001\u0000\u0000\u0000\u03cf"+
		"\u03d1\u0005\u0004\u0000\u0000\u03d0\u03cf\u0001\u0000\u0000\u0000\u03d1"+
		"\u03d4\u0001\u0000\u0000\u0000\u03d2\u03d0\u0001\u0000\u0000\u0000\u03d2"+
		"\u03d3\u0001\u0000\u0000\u0000\u03d3\u03d5\u0001\u0000\u0000\u0000\u03d4"+
		"\u03d2\u0001\u0000\u0000\u0000\u03d5\u03d9\u0003d2\u0000\u03d6\u03d8\u0005"+
		"\u0004\u0000\u0000\u03d7\u03d6\u0001\u0000\u0000\u0000\u03d8\u03db\u0001"+
		"\u0000\u0000\u0000\u03d9\u03d7\u0001\u0000\u0000\u0000\u03d9\u03da\u0001"+
		"\u0000\u0000\u0000\u03da\u03dc\u0001\u0000\u0000\u0000\u03db\u03d9\u0001"+
		"\u0000\u0000\u0000\u03dc\u03dd\u0005\u0006\u0000\u0000\u03dd\u03df\u0001"+
		"\u0000\u0000\u0000\u03de\u03d2\u0001\u0000\u0000\u0000\u03de\u03df\u0001"+
		"\u0000\u0000\u0000\u03df\u03e3\u0001\u0000\u0000\u0000\u03e0\u03e2\u0005"+
		"\u0004\u0000\u0000\u03e1\u03e0\u0001\u0000\u0000\u0000\u03e2\u03e5\u0001"+
		"\u0000\u0000\u0000\u03e3\u03e1\u0001\u0000\u0000\u0000\u03e3\u03e4\u0001"+
		"\u0000\u0000\u0000\u03e4\u03e6\u0001\u0000\u0000\u0000\u03e5\u03e3\u0001"+
		"\u0000\u0000\u0000\u03e6\u03e7\u0003:\u001d\u0000\u03e7\u03ef\u0001\u0000"+
		"\u0000\u0000\u03e8\u03ea\u0005\u0004\u0000\u0000\u03e9\u03e8\u0001\u0000"+
		"\u0000\u0000\u03ea\u03ed\u0001\u0000\u0000\u0000\u03eb\u03e9\u0001\u0000"+
		"\u0000\u0000\u03eb\u03ec\u0001\u0000\u0000\u0000\u03ec\u03ee\u0001\u0000"+
		"\u0000\u0000\u03ed\u03eb\u0001\u0000\u0000\u0000\u03ee\u03f0\u0003$\u0012"+
		"\u0000\u03ef\u03eb\u0001\u0000\u0000\u0000\u03ef\u03f0\u0001\u0000\u0000"+
		"\u0000\u03f0\u03ff\u0001\u0000\u0000\u0000\u03f1\u03f3\u0005\u0004\u0000"+
		"\u0000\u03f2\u03f1\u0001\u0000\u0000\u0000\u03f3\u03f6\u0001\u0000\u0000"+
		"\u0000\u03f4\u03f2\u0001\u0000\u0000\u0000\u03f4\u03f5\u0001\u0000\u0000"+
		"\u0000\u03f5\u03f7\u0001\u0000\u0000\u0000\u03f6\u03f4\u0001\u0000\u0000"+
		"\u0000\u03f7\u03fb\u0007\u0002\u0000\u0000\u03f8\u03fa\u0005\u0004\u0000"+
		"\u0000\u03f9\u03f8\u0001\u0000\u0000\u0000\u03fa\u03fd\u0001\u0000\u0000"+
		"\u0000\u03fb\u03f9\u0001\u0000\u0000\u0000\u03fb\u03fc\u0001\u0000\u0000"+
		"\u0000\u03fc\u03fe\u0001\u0000\u0000\u0000\u03fd\u03fb\u0001\u0000\u0000"+
		"\u0000\u03fe\u0400\u0003~?\u0000\u03ff\u03f4\u0001\u0000\u0000\u0000\u03ff"+
		"\u0400\u0001\u0000\u0000\u0000\u0400\u0408\u0001\u0000\u0000\u0000\u0401"+
		"\u0403\u0005\u0004\u0000\u0000\u0402\u0401\u0001\u0000\u0000\u0000\u0403"+
		"\u0406\u0001\u0000\u0000\u0000\u0404\u0402\u0001\u0000\u0000\u0000\u0404"+
		"\u0405\u0001\u0000\u0000\u0000\u0405\u0407\u0001\u0000\u0000\u0000\u0406"+
		"\u0404\u0001\u0000\u0000\u0000\u0407\u0409\u0005\u001a\u0000\u0000\u0408"+
		"\u0404\u0001\u0000\u0000\u0000\u0408\u0409\u0001\u0000\u0000\u0000\u0409"+
		"\u040d\u0001\u0000\u0000\u0000\u040a\u040c\u0005\u0004\u0000\u0000\u040b"+
		"\u040a\u0001\u0000\u0000\u0000\u040c\u040f\u0001\u0000\u0000\u0000\u040d"+
		"\u040b\u0001\u0000\u0000\u0000\u040d\u040e\u0001\u0000\u0000\u0000\u040e"+
		"\u0429\u0001\u0000\u0000\u0000\u040f\u040d\u0001\u0000\u0000\u0000\u0410"+
		"\u041b\u0003<\u001e\u0000\u0411\u0413\u0005\u0004\u0000\u0000\u0412\u0411"+
		"\u0001\u0000\u0000\u0000\u0413\u0416\u0001\u0000\u0000\u0000\u0414\u0412"+
		"\u0001\u0000\u0000\u0000\u0414\u0415\u0001\u0000\u0000\u0000\u0415\u0418"+
		"\u0001\u0000\u0000\u0000\u0416\u0414\u0001\u0000\u0000\u0000\u0417\u0419"+
		"\u0003\u0128\u0094\u0000\u0418\u0417\u0001\u0000\u0000\u0000\u0418\u0419"+
		"\u0001\u0000\u0000\u0000\u0419\u041a\u0001\u0000\u0000\u0000\u041a\u041c"+
		"\u0003>\u001f\u0000\u041b\u0414\u0001\u0000\u0000\u0000\u041b\u041c\u0001"+
		"\u0000\u0000\u0000\u041c\u042a\u0001\u0000\u0000\u0000\u041d\u0421\u0003"+
		">\u001f\u0000\u041e\u0420\u0005\u0004\u0000\u0000\u041f\u041e\u0001\u0000"+
		"\u0000\u0000\u0420\u0423\u0001\u0000\u0000\u0000\u0421\u041f\u0001\u0000"+
		"\u0000\u0000\u0421\u0422\u0001\u0000\u0000\u0000\u0422\u0425\u0001\u0000"+
		"\u0000\u0000\u0423\u0421\u0001\u0000\u0000\u0000\u0424\u0426\u0003\u0128"+
		"\u0094\u0000\u0425\u0424\u0001\u0000\u0000\u0000\u0425\u0426\u0001\u0000"+
		"\u0000\u0000\u0426\u0427\u0001\u0000\u0000\u0000\u0427\u0428\u0003<\u001e"+
		"\u0000\u0428\u042a\u0001\u0000\u0000\u0000\u0429\u0410\u0001\u0000\u0000"+
		"\u0000\u0429\u041d\u0001\u0000\u0000\u0000\u0429\u042a\u0001\u0000\u0000"+
		"\u0000\u042a9\u0001\u0000\u0000\u0000\u042b\u042d\u0003\u011c\u008e\u0000"+
		"\u042c\u042b\u0001\u0000\u0000\u0000\u042d\u0430\u0001\u0000\u0000\u0000"+
		"\u042e\u042c\u0001\u0000\u0000\u0000\u042e\u042f\u0001\u0000\u0000\u0000"+
		"\u042f\u0434\u0001\u0000\u0000\u0000\u0430\u042e\u0001\u0000\u0000\u0000"+
		"\u0431\u0433\u0005\u0004\u0000\u0000\u0432\u0431\u0001\u0000\u0000\u0000"+
		"\u0433\u0436\u0001\u0000\u0000\u0000\u0434\u0432\u0001\u0000\u0000\u0000"+
		"\u0434\u0435\u0001\u0000\u0000\u0000\u0435\u0437\u0001\u0000\u0000\u0000"+
		"\u0436\u0434\u0001\u0000\u0000\u0000\u0437\u0446\u0003\u0124\u0092\u0000"+
		"\u0438\u043a\u0005\u0004\u0000\u0000\u0439\u0438\u0001\u0000\u0000\u0000"+
		"\u043a\u043d\u0001\u0000\u0000\u0000\u043b\u0439\u0001\u0000\u0000\u0000"+
		"\u043b\u043c\u0001\u0000\u0000\u0000\u043c\u043e\u0001\u0000\u0000\u0000"+
		"\u043d\u043b\u0001\u0000\u0000\u0000\u043e\u0442\u0005\u0019\u0000\u0000"+
		"\u043f\u0441\u0005\u0004\u0000\u0000\u0440\u043f\u0001\u0000\u0000\u0000"+
		"\u0441\u0444\u0001\u0000\u0000\u0000\u0442\u0440\u0001\u0000\u0000\u0000"+
		"\u0442\u0443\u0001\u0000\u0000\u0000\u0443\u0445\u0001\u0000\u0000\u0000"+
		"\u0444\u0442\u0001\u0000\u0000\u0000\u0445\u0447\u0003N\'\u0000\u0446"+
		"\u043b\u0001\u0000\u0000\u0000\u0446\u0447\u0001\u0000\u0000\u0000\u0447"+
		";\u0001\u0000\u0000\u0000\u0448\u044a\u0003\u0106\u0083\u0000\u0449\u0448"+
		"\u0001\u0000\u0000\u0000\u0449\u044a\u0001\u0000\u0000\u0000\u044a\u044b"+
		"\u0001\u0000\u0000\u0000\u044b\u0471\u0005[\u0000\u0000\u044c\u044e\u0005"+
		"\u0004\u0000\u0000\u044d\u044c\u0001\u0000\u0000\u0000\u044e\u0451\u0001"+
		"\u0000\u0000\u0000\u044f\u044d\u0001\u0000\u0000\u0000\u044f\u0450\u0001"+
		"\u0000\u0000\u0000\u0450\u0452\u0001\u0000\u0000\u0000\u0451\u044f\u0001"+
		"\u0000\u0000\u0000\u0452\u0456\u0005\b\u0000\u0000\u0453\u0455\u0005\u0004"+
		"\u0000\u0000\u0454\u0453\u0001\u0000\u0000\u0000\u0455\u0458\u0001\u0000"+
		"\u0000\u0000\u0456\u0454\u0001\u0000\u0000\u0000\u0456\u0457\u0001\u0000"+
		"\u0000\u0000\u0457\u0459\u0001\u0000\u0000\u0000\u0458\u0456\u0001\u0000"+
		"\u0000\u0000\u0459\u0468\u0005\t\u0000\u0000\u045a\u045c\u0005\u0004\u0000"+
		"\u0000\u045b\u045a\u0001\u0000\u0000\u0000\u045c\u045f\u0001\u0000\u0000"+
		"\u0000\u045d\u045b\u0001\u0000\u0000\u0000\u045d\u045e\u0001\u0000\u0000"+
		"\u0000\u045e\u0460\u0001\u0000\u0000\u0000\u045f\u045d\u0001\u0000\u0000"+
		"\u0000\u0460\u0464\u0005\u0019\u0000\u0000\u0461\u0463\u0005\u0004\u0000"+
		"\u0000\u0462\u0461\u0001\u0000\u0000\u0000\u0463\u0466\u0001\u0000\u0000"+
		"\u0000\u0464\u0462\u0001\u0000\u0000\u0000\u0464\u0465\u0001\u0000\u0000"+
		"\u0000\u0465\u0467\u0001\u0000\u0000\u0000\u0466\u0464\u0001\u0000\u0000"+
		"\u0000\u0467\u0469\u0003N\'\u0000\u0468\u045d\u0001\u0000\u0000\u0000"+
		"\u0468\u0469\u0001\u0000\u0000\u0000\u0469\u046d\u0001\u0000\u0000\u0000"+
		"\u046a\u046c\u0005\u0004\u0000\u0000\u046b\u046a\u0001\u0000\u0000\u0000"+
		"\u046c\u046f\u0001\u0000\u0000\u0000\u046d\u046b\u0001\u0000\u0000\u0000"+
		"\u046d\u046e\u0001\u0000\u0000\u0000\u046e\u0470\u0001\u0000\u0000\u0000"+
		"\u046f\u046d\u0001\u0000\u0000\u0000\u0470\u0472\u00036\u001b\u0000\u0471"+
		"\u044f\u0001\u0000\u0000\u0000\u0471\u0472\u0001\u0000\u0000\u0000\u0472"+
		"=\u0001\u0000\u0000\u0000\u0473\u0475\u0003\u0106\u0083\u0000\u0474\u0473"+
		"\u0001\u0000\u0000\u0000\u0474\u0475\u0001\u0000\u0000\u0000\u0475\u0476"+
		"\u0001\u0000\u0000\u0000\u0476\u049d\u0005\\\u0000\u0000\u0477\u0479\u0005"+
		"\u0004\u0000\u0000\u0478\u0477\u0001\u0000\u0000\u0000\u0479\u047c\u0001"+
		"\u0000\u0000\u0000\u047a\u0478\u0001\u0000\u0000\u0000\u047a\u047b\u0001"+
		"\u0000\u0000\u0000\u047b\u047d\u0001\u0000\u0000\u0000\u047c\u047a\u0001"+
		"\u0000\u0000\u0000\u047d\u0481\u0005\b\u0000\u0000\u047e\u0480\u0005\u0004"+
		"\u0000\u0000\u047f\u047e\u0001\u0000\u0000\u0000\u0480\u0483\u0001\u0000"+
		"\u0000\u0000\u0481\u047f\u0001\u0000\u0000\u0000\u0481\u0482\u0001\u0000"+
		"\u0000\u0000\u0482\u0484\u0001\u0000\u0000\u0000\u0483\u0481\u0001\u0000"+
		"\u0000\u0000\u0484\u048c\u0003B!\u0000\u0485\u0487\u0005\u0004\u0000\u0000"+
		"\u0486\u0485\u0001\u0000\u0000\u0000\u0487\u048a\u0001\u0000\u0000\u0000"+
		"\u0488\u0486\u0001\u0000\u0000\u0000\u0488\u0489\u0001\u0000\u0000\u0000"+
		"\u0489\u048b\u0001\u0000\u0000\u0000\u048a\u0488\u0001\u0000\u0000\u0000"+
		"\u048b\u048d\u0005\u0007\u0000\u0000\u048c\u0488\u0001\u0000\u0000\u0000"+
		"\u048c\u048d\u0001\u0000\u0000\u0000\u048d\u0491\u0001\u0000\u0000\u0000"+
		"\u048e\u0490\u0005\u0004\u0000\u0000\u048f\u048e\u0001\u0000\u0000\u0000"+
		"\u0490\u0493\u0001\u0000\u0000\u0000\u0491\u048f\u0001\u0000\u0000\u0000"+
		"\u0491\u0492\u0001\u0000\u0000\u0000\u0492\u0494\u0001\u0000\u0000\u0000"+
		"\u0493\u0491\u0001\u0000\u0000\u0000\u0494\u0498\u0005\t\u0000\u0000\u0495"+
		"\u0497\u0005\u0004\u0000\u0000\u0496\u0495\u0001\u0000\u0000\u0000\u0497"+
		"\u049a\u0001\u0000\u0000\u0000\u0498\u0496\u0001\u0000\u0000\u0000\u0498"+
		"\u0499\u0001\u0000\u0000\u0000\u0499\u049b\u0001\u0000\u0000\u0000\u049a"+
		"\u0498\u0001\u0000\u0000\u0000\u049b\u049c\u00036\u001b\u0000\u049c\u049e"+
		"\u0001\u0000\u0000\u0000\u049d\u047a\u0001\u0000\u0000\u0000\u049d\u049e"+
		"\u0001\u0000\u0000\u0000\u049e?\u0001\u0000\u0000\u0000\u049f\u04a3\u0005"+
		"\b\u0000\u0000\u04a0\u04a2\u0005\u0004\u0000\u0000\u04a1\u04a0\u0001\u0000"+
		"\u0000\u0000\u04a2\u04a5\u0001\u0000\u0000\u0000\u04a3\u04a1\u0001\u0000"+
		"\u0000\u0000\u04a3\u04a4\u0001\u0000\u0000\u0000\u04a4\u04c3\u0001\u0000"+
		"\u0000\u0000\u04a5\u04a3\u0001\u0000\u0000\u0000\u04a6\u04b7\u0003B!\u0000"+
		"\u04a7\u04a9\u0005\u0004\u0000\u0000\u04a8\u04a7\u0001\u0000\u0000\u0000"+
		"\u04a9\u04ac\u0001\u0000\u0000\u0000\u04aa\u04a8\u0001\u0000\u0000\u0000"+
		"\u04aa\u04ab\u0001\u0000\u0000\u0000\u04ab\u04ad\u0001\u0000\u0000\u0000"+
		"\u04ac\u04aa\u0001\u0000\u0000\u0000\u04ad\u04b1\u0005\u0007\u0000\u0000"+
		"\u04ae\u04b0\u0005\u0004\u0000\u0000\u04af\u04ae\u0001\u0000\u0000\u0000"+
		"\u04b0\u04b3\u0001\u0000\u0000\u0000\u04b1\u04af\u0001\u0000\u0000\u0000"+
		"\u04b1\u04b2\u0001\u0000\u0000\u0000\u04b2\u04b4\u0001\u0000\u0000\u0000"+
		"\u04b3\u04b1\u0001\u0000\u0000\u0000\u04b4\u04b6\u0003B!\u0000\u04b5\u04aa"+
		"\u0001\u0000\u0000\u0000\u04b6\u04b9\u0001\u0000\u0000\u0000\u04b7\u04b5"+
		"\u0001\u0000\u0000\u0000\u04b7\u04b8\u0001\u0000\u0000\u0000\u04b8\u04c1"+
		"\u0001\u0000\u0000\u0000\u04b9\u04b7\u0001\u0000\u0000\u0000\u04ba\u04bc"+
		"\u0005\u0004\u0000\u0000\u04bb\u04ba\u0001\u0000\u0000\u0000\u04bc\u04bf"+
		"\u0001\u0000\u0000\u0000\u04bd\u04bb\u0001\u0000\u0000\u0000\u04bd\u04be"+
		"\u0001\u0000\u0000\u0000\u04be\u04c0\u0001\u0000\u0000\u0000\u04bf\u04bd"+
		"\u0001\u0000\u0000\u0000\u04c0\u04c2\u0005\u0007\u0000\u0000\u04c1\u04bd"+
		"\u0001\u0000\u0000\u0000\u04c1\u04c2\u0001\u0000\u0000\u0000\u04c2\u04c4"+
		"\u0001\u0000\u0000\u0000\u04c3\u04a6\u0001\u0000\u0000\u0000\u04c3\u04c4"+
		"\u0001\u0000\u0000\u0000\u04c4\u04c8\u0001\u0000\u0000\u0000\u04c5\u04c7"+
		"\u0005\u0004\u0000\u0000\u04c6\u04c5\u0001\u0000\u0000\u0000\u04c7\u04ca"+
		"\u0001\u0000\u0000\u0000\u04c8\u04c6\u0001\u0000\u0000\u0000\u04c8\u04c9"+
		"\u0001\u0000\u0000\u0000\u04c9\u04cb\u0001\u0000\u0000\u0000\u04ca\u04c8"+
		"\u0001\u0000\u0000\u0000\u04cb\u04cc\u0005\t\u0000\u0000\u04ccA\u0001"+
		"\u0000\u0000\u0000\u04cd\u04cf\u0003\u0108\u0084\u0000\u04ce\u04cd\u0001"+
		"\u0000\u0000\u0000\u04ce\u04cf\u0001\u0000\u0000\u0000\u04cf\u04d0\u0001"+
		"\u0000\u0000\u0000\u04d0\u04df\u0003D\"\u0000\u04d1\u04d3\u0005\u0004"+
		"\u0000\u0000\u04d2\u04d1\u0001\u0000\u0000\u0000\u04d3\u04d6\u0001\u0000"+
		"\u0000\u0000\u04d4\u04d2\u0001\u0000\u0000\u0000\u04d4\u04d5\u0001\u0000"+
		"\u0000\u0000\u04d5\u04d7\u0001\u0000\u0000\u0000\u04d6\u04d4\u0001\u0000"+
		"\u0000\u0000\u04d7\u04db\u0005\u001b\u0000\u0000\u04d8\u04da\u0005\u0004"+
		"\u0000\u0000\u04d9\u04d8\u0001\u0000\u0000\u0000\u04da\u04dd\u0001\u0000"+
		"\u0000\u0000\u04db\u04d9\u0001\u0000\u0000\u0000\u04db\u04dc\u0001\u0000"+
		"\u0000\u0000\u04dc\u04de\u0001\u0000\u0000\u0000\u04dd\u04db\u0001\u0000"+
		"\u0000\u0000\u04de\u04e0\u0003~?\u0000\u04df\u04d4\u0001\u0000\u0000\u0000"+
		"\u04df\u04e0\u0001\u0000\u0000\u0000\u04e0C\u0001\u0000\u0000\u0000\u04e1"+
		"\u04e5\u0003\u0124\u0092\u0000\u04e2\u04e4\u0005\u0004\u0000\u0000\u04e3"+
		"\u04e2\u0001\u0000\u0000\u0000\u04e4\u04e7\u0001\u0000\u0000\u0000\u04e5"+
		"\u04e3\u0001\u0000\u0000\u0000\u04e5\u04e6\u0001\u0000\u0000\u0000\u04e6"+
		"\u04f0\u0001\u0000\u0000\u0000\u04e7\u04e5\u0001\u0000\u0000\u0000\u04e8"+
		"\u04ec\u0005\u0019\u0000\u0000\u04e9\u04eb\u0005\u0004\u0000\u0000\u04ea"+
		"\u04e9\u0001\u0000\u0000\u0000\u04eb\u04ee\u0001\u0000\u0000\u0000\u04ec"+
		"\u04ea\u0001\u0000\u0000\u0000\u04ec\u04ed\u0001\u0000\u0000\u0000\u04ed"+
		"\u04ef\u0001\u0000\u0000\u0000\u04ee\u04ec\u0001\u0000\u0000\u0000\u04ef"+
		"\u04f1\u0003N\'\u0000\u04f0\u04e8\u0001\u0000\u0000\u0000\u04f0\u04f1"+
		"\u0001\u0000\u0000\u0000\u04f1E\u0001\u0000\u0000\u0000\u04f2\u04f6\u0003"+
		"\u0124\u0092\u0000\u04f3\u04f5\u0005\u0004\u0000\u0000\u04f4\u04f3\u0001"+
		"\u0000\u0000\u0000\u04f5\u04f8\u0001\u0000\u0000\u0000\u04f6\u04f4\u0001"+
		"\u0000\u0000\u0000\u04f6\u04f7\u0001\u0000\u0000\u0000\u04f7\u04f9\u0001"+
		"\u0000\u0000\u0000\u04f8\u04f6\u0001\u0000\u0000\u0000\u04f9\u04fd\u0005"+
		"\u0019\u0000\u0000\u04fa\u04fc\u0005\u0004\u0000\u0000\u04fb\u04fa\u0001"+
		"\u0000\u0000\u0000\u04fc\u04ff\u0001\u0000\u0000\u0000\u04fd\u04fb\u0001"+
		"\u0000\u0000\u0000\u04fd\u04fe\u0001\u0000\u0000\u0000\u04fe\u0500\u0001"+
		"\u0000\u0000\u0000\u04ff\u04fd\u0001\u0000\u0000\u0000\u0500\u0501\u0003"+
		"N\'\u0000\u0501G\u0001\u0000\u0000\u0000\u0502\u0506\u0005\f\u0000\u0000"+
		"\u0503\u0505\u0005\u0004\u0000\u0000\u0504\u0503\u0001\u0000\u0000\u0000"+
		"\u0505\u0508\u0001\u0000\u0000\u0000\u0506\u0504\u0001\u0000\u0000\u0000"+
		"\u0506\u0507\u0001\u0000\u0000\u0000\u0507\u050a\u0001\u0000\u0000\u0000"+
		"\u0508\u0506\u0001\u0000\u0000\u0000\u0509\u050b\u0003J%\u0000\u050a\u0509"+
		"\u0001\u0000\u0000\u0000\u050a\u050b\u0001\u0000\u0000\u0000\u050b\u051f"+
		"\u0001\u0000\u0000\u0000\u050c\u050e\u0005\u0004\u0000\u0000\u050d\u050c"+
		"\u0001\u0000\u0000\u0000\u050e\u0511\u0001\u0000\u0000\u0000\u050f\u050d"+
		"\u0001\u0000\u0000\u0000\u050f\u0510\u0001\u0000\u0000\u0000\u0510\u0512"+
		"\u0001\u0000\u0000\u0000\u0511\u050f\u0001\u0000\u0000\u0000\u0512\u0516"+
		"\u0005\u001a\u0000\u0000\u0513\u0515\u0005\u0004\u0000\u0000\u0514\u0513"+
		"\u0001\u0000\u0000\u0000\u0515\u0518\u0001\u0000\u0000\u0000\u0516\u0514"+
		"\u0001\u0000\u0000\u0000\u0516\u0517\u0001\u0000\u0000\u0000\u0517\u051c"+
		"\u0001\u0000\u0000\u0000\u0518\u0516\u0001\u0000\u0000\u0000\u0519\u051b"+
		"\u0003(\u0014\u0000\u051a\u0519\u0001\u0000\u0000\u0000\u051b\u051e\u0001"+
		"\u0000\u0000\u0000\u051c\u051a\u0001\u0000\u0000\u0000\u051c\u051d\u0001"+
		"\u0000\u0000\u0000\u051d\u0520\u0001\u0000\u0000\u0000\u051e\u051c\u0001"+
		"\u0000\u0000\u0000\u051f\u050f\u0001\u0000\u0000\u0000\u051f\u0520\u0001"+
		"\u0000\u0000\u0000\u0520\u0524\u0001\u0000\u0000\u0000\u0521\u0523\u0005"+
		"\u0004\u0000\u0000\u0522\u0521\u0001\u0000\u0000\u0000\u0523\u0526\u0001"+
		"\u0000\u0000\u0000\u0524\u0522\u0001\u0000\u0000\u0000\u0524\u0525\u0001"+
		"\u0000\u0000\u0000\u0525\u0527\u0001\u0000\u0000\u0000\u0526\u0524\u0001"+
		"\u0000\u0000\u0000\u0527\u0528\u0005\r\u0000\u0000\u0528I\u0001\u0000"+
		"\u0000\u0000\u0529\u052b\u0003L&\u0000\u052a\u0529\u0001\u0000\u0000\u0000"+
		"\u052b\u052c\u0001\u0000\u0000\u0000\u052c\u052a\u0001\u0000\u0000\u0000"+
		"\u052c\u052d\u0001\u0000\u0000\u0000\u052d\u052f\u0001\u0000\u0000\u0000"+
		"\u052e\u0530\u0005\u001a\u0000\u0000\u052f\u052e\u0001\u0000\u0000\u0000"+
		"\u052f\u0530\u0001\u0000\u0000\u0000\u0530K\u0001\u0000\u0000\u0000\u0531"+
		"\u0535\u0003\u0106\u0083\u0000\u0532\u0534\u0005\u0004\u0000\u0000\u0533"+
		"\u0532\u0001\u0000\u0000\u0000\u0534\u0537\u0001\u0000\u0000\u0000\u0535"+
		"\u0533\u0001\u0000\u0000\u0000\u0535\u0536\u0001\u0000\u0000\u0000\u0536"+
		"\u0539\u0001\u0000\u0000\u0000\u0537\u0535\u0001\u0000\u0000\u0000\u0538"+
		"\u0531\u0001\u0000\u0000\u0000\u0538\u0539\u0001\u0000\u0000\u0000\u0539"+
		"\u053a\u0001\u0000\u0000\u0000\u053a\u0542\u0003\u0124\u0092\u0000\u053b"+
		"\u053d\u0005\u0004\u0000\u0000\u053c\u053b\u0001\u0000\u0000\u0000\u053d"+
		"\u0540\u0001\u0000\u0000\u0000\u053e\u053c\u0001\u0000\u0000\u0000\u053e"+
		"\u053f\u0001\u0000\u0000\u0000\u053f\u0541\u0001\u0000\u0000\u0000\u0540"+
		"\u053e\u0001\u0000\u0000\u0000\u0541\u0543\u0003\u00eau\u0000\u0542\u053e"+
		"\u0001\u0000\u0000\u0000\u0542\u0543\u0001\u0000\u0000\u0000\u0543\u054b"+
		"\u0001\u0000\u0000\u0000\u0544\u0546\u0005\u0004\u0000\u0000\u0545\u0544"+
		"\u0001\u0000\u0000\u0000\u0546\u0549\u0001\u0000\u0000\u0000\u0547\u0545"+
		"\u0001\u0000\u0000\u0000\u0547\u0548\u0001\u0000\u0000\u0000\u0548\u054a"+
		"\u0001\u0000\u0000\u0000\u0549\u0547\u0001\u0000\u0000\u0000\u054a\u054c"+
		"\u0003\u001e\u000f\u0000\u054b\u0547\u0001\u0000\u0000\u0000\u054b\u054c"+
		"\u0001\u0000\u0000\u0000\u054c\u0554\u0001\u0000\u0000\u0000\u054d\u054f"+
		"\u0005\u0004\u0000\u0000\u054e\u054d\u0001\u0000\u0000\u0000\u054f\u0552"+
		"\u0001\u0000\u0000\u0000\u0550\u054e\u0001\u0000\u0000\u0000\u0550\u0551"+
		"\u0001\u0000\u0000\u0000\u0551\u0553\u0001\u0000\u0000\u0000\u0552\u0550"+
		"\u0001\u0000\u0000\u0000\u0553\u0555\u0005\u0007\u0000\u0000\u0554\u0550"+
		"\u0001\u0000\u0000\u0000\u0554\u0555\u0001\u0000\u0000\u0000\u0555M\u0001"+
		"\u0000\u0000\u0000\u0556\u0558\u0003\u011a\u008d\u0000\u0557\u0556\u0001"+
		"\u0000\u0000\u0000\u0558\u055b\u0001\u0000\u0000\u0000\u0559\u0557\u0001"+
		"\u0000\u0000\u0000\u0559\u055a\u0001\u0000\u0000\u0000\u055a\u0560\u0001"+
		"\u0000\u0000\u0000\u055b\u0559\u0001\u0000\u0000\u0000\u055c\u0561\u0003"+
		"^/\u0000\u055d\u0561\u0003b1\u0000\u055e\u0561\u0003P(\u0000\u055f\u0561"+
		"\u0003T*\u0000\u0560\u055c\u0001\u0000\u0000\u0000\u0560\u055d\u0001\u0000"+
		"\u0000\u0000\u0560\u055e\u0001\u0000\u0000\u0000\u0560\u055f\u0001\u0000"+
		"\u0000\u0000\u0561O\u0001\u0000\u0000\u0000\u0562\u0565\u0003T*\u0000"+
		"\u0563\u0565\u0003b1\u0000\u0564\u0562\u0001\u0000\u0000\u0000\u0564\u0563"+
		"\u0001\u0000\u0000\u0000\u0565\u0569\u0001\u0000\u0000\u0000\u0566\u0568"+
		"\u0005\u0004\u0000\u0000\u0567\u0566\u0001\u0000\u0000\u0000\u0568\u056b"+
		"\u0001\u0000\u0000\u0000\u0569\u0567\u0001\u0000\u0000\u0000\u0569\u056a"+
		"\u0001\u0000\u0000\u0000\u056a\u056d\u0001\u0000\u0000\u0000\u056b\u0569"+
		"\u0001\u0000\u0000\u0000\u056c\u056e\u0003R)\u0000\u056d\u056c\u0001\u0000"+
		"\u0000\u0000\u056e\u056f\u0001\u0000\u0000\u0000\u056f\u056d\u0001\u0000"+
		"\u0000\u0000\u056f\u0570\u0001\u0000\u0000\u0000\u0570Q\u0001\u0000\u0000"+
		"\u0000\u0571\u0572\u0007\u0003\u0000\u0000\u0572S\u0001\u0000\u0000\u0000"+
		"\u0573\u0584\u0003V+\u0000\u0574\u0576\u0005\u0004\u0000\u0000\u0575\u0574"+
		"\u0001\u0000\u0000\u0000\u0576\u0579\u0001\u0000\u0000\u0000\u0577\u0575"+
		"\u0001\u0000\u0000\u0000\u0577\u0578\u0001\u0000\u0000\u0000\u0578\u057a"+
		"\u0001\u0000\u0000\u0000\u0579\u0577\u0001\u0000\u0000\u0000\u057a\u057e"+
		"\u0005\u0006\u0000\u0000\u057b\u057d\u0005\u0004\u0000\u0000\u057c\u057b"+
		"\u0001\u0000\u0000\u0000\u057d\u0580\u0001\u0000\u0000\u0000\u057e\u057c"+
		"\u0001\u0000\u0000\u0000\u057e\u057f\u0001\u0000\u0000\u0000\u057f\u0581"+
		"\u0001\u0000\u0000\u0000\u0580\u057e\u0001\u0000\u0000\u0000\u0581\u0583"+
		"\u0003V+\u0000\u0582\u0577\u0001\u0000\u0000\u0000\u0583\u0586\u0001\u0000"+
		"\u0000\u0000\u0584\u0582\u0001\u0000\u0000\u0000\u0584\u0585\u0001\u0000"+
		"\u0000\u0000\u0585U\u0001\u0000\u0000\u0000\u0586\u0584\u0001\u0000\u0000"+
		"\u0000\u0587\u058f\u0003\u0124\u0092\u0000\u0588\u058a\u0005\u0004\u0000"+
		"\u0000\u0589\u0588\u0001\u0000\u0000\u0000\u058a\u058d\u0001\u0000\u0000"+
		"\u0000\u058b\u0589\u0001\u0000\u0000\u0000\u058b\u058c\u0001\u0000\u0000"+
		"\u0000\u058c\u058e\u0001\u0000\u0000\u0000\u058d\u058b\u0001\u0000\u0000"+
		"\u0000\u058e\u0590\u0003\u00e8t\u0000\u058f\u058b\u0001\u0000\u0000\u0000"+
		"\u058f\u0590\u0001\u0000\u0000\u0000\u0590W\u0001\u0000\u0000\u0000\u0591"+
		"\u0593\u0003Z-\u0000\u0592\u0591\u0001\u0000\u0000\u0000\u0592\u0593\u0001"+
		"\u0000\u0000\u0000\u0593\u0594\u0001\u0000\u0000\u0000\u0594\u0597\u0003"+
		"N\'\u0000\u0595\u0597\u0005\u000e\u0000\u0000\u0596\u0592\u0001\u0000"+
		"\u0000\u0000\u0596\u0595\u0001\u0000\u0000\u0000\u0597Y\u0001\u0000\u0000"+
		"\u0000\u0598\u059a\u0003\\.\u0000\u0599\u0598\u0001\u0000\u0000\u0000"+
		"\u059a\u059b\u0001\u0000\u0000\u0000\u059b\u0599\u0001\u0000\u0000\u0000"+
		"\u059b\u059c\u0001\u0000\u0000\u0000\u059c[\u0001\u0000\u0000\u0000\u059d"+
		"\u05a1\u0003\u0112\u0089\u0000\u059e\u05a0\u0005\u0004\u0000\u0000\u059f"+
		"\u059e\u0001\u0000\u0000\u0000\u05a0\u05a3\u0001\u0000\u0000\u0000\u05a1"+
		"\u059f\u0001\u0000\u0000\u0000\u05a1\u05a2\u0001\u0000\u0000\u0000\u05a2"+
		"\u05a6\u0001\u0000\u0000\u0000\u05a3\u05a1\u0001\u0000\u0000\u0000\u05a4"+
		"\u05a6\u0003\u011c\u008e\u0000\u05a5\u059d\u0001\u0000\u0000\u0000\u05a5"+
		"\u05a4\u0001\u0000\u0000\u0000\u05a6]\u0001\u0000\u0000\u0000\u05a7\u05ab"+
		"\u0003d2\u0000\u05a8\u05aa\u0005\u0004\u0000\u0000\u05a9\u05a8\u0001\u0000"+
		"\u0000\u0000\u05aa\u05ad\u0001\u0000\u0000\u0000\u05ab\u05a9\u0001\u0000"+
		"\u0000\u0000\u05ab\u05ac\u0001\u0000\u0000\u0000\u05ac\u05ae\u0001\u0000"+
		"\u0000\u0000\u05ad\u05ab\u0001\u0000\u0000\u0000\u05ae\u05b2\u0005\u0006"+
		"\u0000\u0000\u05af\u05b1\u0005\u0004\u0000\u0000\u05b0\u05af\u0001\u0000"+
		"\u0000\u0000\u05b1\u05b4\u0001\u0000\u0000\u0000\u05b2\u05b0\u0001\u0000"+
		"\u0000\u0000\u05b2\u05b3\u0001\u0000\u0000\u0000\u05b3\u05b6\u0001\u0000"+
		"\u0000\u0000\u05b4\u05b2\u0001\u0000\u0000\u0000\u05b5\u05a7\u0001\u0000"+
		"\u0000\u0000\u05b5\u05b6\u0001\u0000\u0000\u0000\u05b6\u05b7\u0001\u0000"+
		"\u0000\u0000\u05b7\u05bb\u0003`0\u0000\u05b8\u05ba\u0005\u0004\u0000\u0000"+
		"\u05b9\u05b8\u0001\u0000\u0000\u0000\u05ba\u05bd\u0001\u0000\u0000\u0000"+
		"\u05bb\u05b9\u0001\u0000\u0000\u0000\u05bb\u05bc\u0001\u0000\u0000\u0000"+
		"\u05bc\u05be\u0001\u0000\u0000\u0000\u05bd\u05bb\u0001\u0000\u0000\u0000"+
		"\u05be\u05c2\u0005!\u0000\u0000\u05bf\u05c1\u0005\u0004\u0000\u0000\u05c0"+
		"\u05bf\u0001\u0000\u0000\u0000\u05c1\u05c4\u0001\u0000\u0000\u0000\u05c2"+
		"\u05c0\u0001\u0000\u0000\u0000\u05c2\u05c3\u0001\u0000\u0000\u0000\u05c3"+
		"\u05c5\u0001\u0000\u0000\u0000\u05c4\u05c2\u0001\u0000\u0000\u0000\u05c5"+
		"\u05c6\u0003N\'\u0000\u05c6_\u0001\u0000\u0000\u0000\u05c7\u05cb\u0005"+
		"\b\u0000\u0000\u05c8\u05ca\u0005\u0004\u0000\u0000\u05c9\u05c8\u0001\u0000"+
		"\u0000\u0000\u05ca\u05cd\u0001\u0000\u0000\u0000\u05cb\u05c9\u0001\u0000"+
		"\u0000\u0000\u05cb\u05cc\u0001\u0000\u0000\u0000\u05cc\u05d0\u0001\u0000"+
		"\u0000\u0000\u05cd\u05cb\u0001\u0000\u0000\u0000\u05ce\u05d1\u0003F#\u0000"+
		"\u05cf\u05d1\u0003N\'\u0000\u05d0\u05ce\u0001\u0000\u0000\u0000\u05d0"+
		"\u05cf\u0001\u0000\u0000\u0000\u05d0\u05d1\u0001\u0000\u0000\u0000\u05d1"+
		"\u05e5\u0001\u0000\u0000\u0000\u05d2\u05d4\u0005\u0004\u0000\u0000\u05d3"+
		"\u05d2\u0001\u0000\u0000\u0000\u05d4\u05d7\u0001\u0000\u0000\u0000\u05d5"+
		"\u05d3\u0001\u0000\u0000\u0000\u05d5\u05d6\u0001\u0000\u0000\u0000\u05d6"+
		"\u05d8\u0001\u0000\u0000\u0000\u05d7\u05d5\u0001\u0000\u0000\u0000\u05d8"+
		"\u05dc\u0005\u0007\u0000\u0000\u05d9\u05db\u0005\u0004\u0000\u0000\u05da"+
		"\u05d9\u0001\u0000\u0000\u0000\u05db\u05de\u0001\u0000\u0000\u0000\u05dc"+
		"\u05da\u0001\u0000\u0000\u0000\u05dc\u05dd\u0001\u0000\u0000\u0000\u05dd"+
		"\u05e1\u0001\u0000\u0000\u0000\u05de\u05dc\u0001\u0000\u0000\u0000\u05df"+
		"\u05e2\u0003F#\u0000\u05e0\u05e2\u0003N\'\u0000\u05e1\u05df\u0001\u0000"+
		"\u0000\u0000\u05e1\u05e0\u0001\u0000\u0000\u0000\u05e2\u05e4\u0001\u0000"+
		"\u0000\u0000\u05e3\u05d5\u0001\u0000\u0000\u0000\u05e4\u05e7\u0001\u0000"+
		"\u0000\u0000\u05e5\u05e3\u0001\u0000\u0000\u0000\u05e5\u05e6\u0001\u0000"+
		"\u0000\u0000\u05e6\u05ef\u0001\u0000\u0000\u0000\u05e7\u05e5\u0001\u0000"+
		"\u0000\u0000\u05e8\u05ea\u0005\u0004\u0000\u0000\u05e9\u05e8\u0001\u0000"+
		"\u0000\u0000\u05ea\u05ed\u0001\u0000\u0000\u0000\u05eb\u05e9\u0001\u0000"+
		"\u0000\u0000\u05eb\u05ec\u0001\u0000\u0000\u0000\u05ec\u05ee\u0001\u0000"+
		"\u0000\u0000\u05ed\u05eb\u0001\u0000\u0000\u0000\u05ee\u05f0\u0005\u0007"+
		"\u0000\u0000\u05ef\u05eb\u0001\u0000\u0000\u0000\u05ef\u05f0\u0001\u0000"+
		"\u0000\u0000\u05f0\u05f4\u0001\u0000\u0000\u0000\u05f1\u05f3\u0005\u0004"+
		"\u0000\u0000\u05f2\u05f1\u0001\u0000\u0000\u0000\u05f3\u05f6\u0001\u0000"+
		"\u0000\u0000\u05f4\u05f2\u0001\u0000\u0000\u0000\u05f4\u05f5\u0001\u0000"+
		"\u0000\u0000\u05f5\u05f7\u0001\u0000\u0000\u0000\u05f6\u05f4\u0001\u0000"+
		"\u0000\u0000\u05f7\u05f8\u0005\t\u0000\u0000\u05f8a\u0001\u0000\u0000"+
		"\u0000\u05f9\u05fd\u0005\b\u0000\u0000\u05fa\u05fc\u0005\u0004\u0000\u0000"+
		"\u05fb\u05fa\u0001\u0000\u0000\u0000\u05fc\u05ff\u0001\u0000\u0000\u0000"+
		"\u05fd\u05fb\u0001\u0000\u0000\u0000\u05fd\u05fe\u0001\u0000\u0000\u0000"+
		"\u05fe\u0600\u0001\u0000\u0000\u0000\u05ff\u05fd\u0001\u0000\u0000\u0000"+
		"\u0600\u0604\u0003N\'\u0000\u0601\u0603\u0005\u0004\u0000\u0000\u0602"+
		"\u0601\u0001\u0000\u0000\u0000\u0603\u0606\u0001\u0000\u0000\u0000\u0604"+
		"\u0602\u0001\u0000\u0000\u0000\u0604\u0605\u0001\u0000\u0000\u0000\u0605"+
		"\u0607\u0001\u0000\u0000\u0000\u0606\u0604\u0001\u0000\u0000\u0000\u0607"+
		"\u0608\u0005\t\u0000\u0000\u0608c\u0001\u0000\u0000\u0000\u0609\u060b"+
		"\u0003\u011a\u008d\u0000\u060a\u0609\u0001\u0000\u0000\u0000\u060a\u060b"+
		"\u0001\u0000\u0000\u0000\u060b\u060f\u0001\u0000\u0000\u0000\u060c\u0610"+
		"\u0003b1\u0000\u060d\u0610\u0003P(\u0000\u060e\u0610\u0003T*\u0000\u060f"+
		"\u060c\u0001\u0000\u0000\u0000\u060f\u060d\u0001\u0000\u0000\u0000\u060f"+
		"\u060e\u0001\u0000\u0000\u0000\u0610e\u0001\u0000\u0000\u0000\u0611\u0615"+
		"\u0005\b\u0000\u0000\u0612\u0614\u0005\u0004\u0000\u0000\u0613\u0612\u0001"+
		"\u0000\u0000\u0000\u0614\u0617\u0001\u0000\u0000\u0000\u0615\u0613\u0001"+
		"\u0000\u0000\u0000\u0615\u0616\u0001\u0000\u0000\u0000\u0616\u061a\u0001"+
		"\u0000\u0000\u0000\u0617\u0615\u0001\u0000\u0000\u0000\u0618\u061b\u0003"+
		"T*\u0000\u0619\u061b\u0003f3\u0000\u061a\u0618\u0001\u0000\u0000\u0000"+
		"\u061a\u0619\u0001\u0000\u0000\u0000\u061b\u061f\u0001\u0000\u0000\u0000"+
		"\u061c\u061e\u0005\u0004\u0000\u0000\u061d\u061c\u0001\u0000\u0000\u0000"+
		"\u061e\u0621\u0001\u0000\u0000\u0000\u061f\u061d\u0001\u0000\u0000\u0000"+
		"\u061f\u0620\u0001\u0000\u0000\u0000\u0620\u0622\u0001\u0000\u0000\u0000"+
		"\u0621\u061f\u0001\u0000\u0000\u0000\u0622\u0623\u0005\t\u0000\u0000\u0623"+
		"g\u0001\u0000\u0000\u0000\u0624\u0626\u0003\u012a\u0095\u0000\u0625\u0624"+
		"\u0001\u0000\u0000\u0000\u0626\u0629\u0001\u0000\u0000\u0000\u0627\u0625"+
		"\u0001\u0000\u0000\u0000\u0627\u0628\u0001\u0000\u0000\u0000\u0628\u0638"+
		"\u0001\u0000\u0000\u0000\u0629\u0627\u0001\u0000\u0000\u0000\u062a\u0635"+
		"\u0003j5\u0000\u062b\u062d\u0003\u012a\u0095\u0000\u062c\u062b\u0001\u0000"+
		"\u0000\u0000\u062d\u062e\u0001\u0000\u0000\u0000\u062e\u062c\u0001\u0000"+
		"\u0000\u0000\u062e\u062f\u0001\u0000\u0000\u0000\u062f\u0631\u0001\u0000"+
		"\u0000\u0000\u0630\u0632\u0003j5\u0000\u0631\u0630\u0001\u0000\u0000\u0000"+
		"\u0631\u0632\u0001\u0000\u0000\u0000\u0632\u0634\u0001\u0000\u0000\u0000"+
		"\u0633\u062c\u0001\u0000\u0000\u0000\u0634\u0637\u0001\u0000\u0000\u0000"+
		"\u0635\u0633\u0001\u0000\u0000\u0000\u0635\u0636\u0001\u0000\u0000\u0000"+
		"\u0636\u0639\u0001\u0000\u0000\u0000\u0637\u0635\u0001\u0000\u0000\u0000"+
		"\u0638\u062a\u0001\u0000\u0000\u0000\u0638\u0639\u0001\u0000\u0000\u0000"+
		"\u0639i\u0001\u0000\u0000\u0000\u063a\u063d\u0003l6\u0000\u063b\u063d"+
		"\u0003n7\u0000\u063c\u063a\u0001\u0000\u0000\u0000\u063c\u063b\u0001\u0000"+
		"\u0000\u0000\u063dk\u0001\u0000\u0000\u0000\u063e\u0640\u0003\u011a\u008d"+
		"\u0000\u063f\u063e\u0001\u0000\u0000\u0000\u0640\u0643\u0001\u0000\u0000"+
		"\u0000\u0641\u063f\u0001\u0000\u0000\u0000\u0641\u0642\u0001\u0000\u0000"+
		"\u0000\u0642\u0647\u0001\u0000\u0000\u0000\u0643\u0641\u0001\u0000\u0000"+
		"\u0000\u0644\u0646\u0005\u0004\u0000\u0000\u0645\u0644\u0001\u0000\u0000"+
		"\u0000\u0646\u0649\u0001\u0000\u0000\u0000\u0647\u0645\u0001\u0000\u0000"+
		"\u0000\u0647\u0648\u0001\u0000\u0000\u0000\u0648\u064a\u0001\u0000\u0000"+
		"\u0000\u0649\u0647\u0001\u0000\u0000\u0000\u064a\u064b\u0003~?\u0000\u064b"+
		"m\u0001\u0000\u0000\u0000\u064c\u064e\u0003p8\u0000\u064d\u064c\u0001"+
		"\u0000\u0000\u0000\u064e\u0651\u0001\u0000\u0000\u0000\u064f\u064d\u0001"+
		"\u0000\u0000\u0000\u064f\u0650\u0001\u0000\u0000\u0000\u0650\u0655\u0001"+
		"\u0000\u0000\u0000\u0651\u064f\u0001\u0000\u0000\u0000\u0652\u0656\u0003"+
		"\n\u0005\u0000\u0653\u0656\u0003r9\u0000\u0654\u0656\u0003t:\u0000\u0655"+
		"\u0652\u0001\u0000\u0000\u0000\u0655\u0653\u0001\u0000\u0000\u0000\u0655"+
		"\u0654\u0001\u0000\u0000\u0000\u0656o\u0001\u0000\u0000\u0000\u0657\u0658"+
		"\u0003\u0124\u0092\u0000\u0658\u065c\u0007\u0004\u0000\u0000\u0659\u065b"+
		"\u0005\u0004\u0000\u0000\u065a\u0659\u0001\u0000\u0000\u0000\u065b\u065e"+
		"\u0001\u0000\u0000\u0000\u065c\u065a\u0001\u0000\u0000\u0000\u065c\u065d"+
		"\u0001\u0000\u0000\u0000\u065dq\u0001\u0000\u0000\u0000\u065e\u065c\u0001"+
		"\u0000\u0000\u0000\u065f\u0660\u0003\u00d6k\u0000\u0660\u0661\u0005\u001b"+
		"\u0000\u0000\u0661\u0666\u0001\u0000\u0000\u0000\u0662\u0663\u0003\u00da"+
		"m\u0000\u0663\u0664\u0003\u00eew\u0000\u0664\u0666\u0001\u0000\u0000\u0000"+
		"\u0665\u065f\u0001\u0000\u0000\u0000\u0665\u0662\u0001\u0000\u0000\u0000"+
		"\u0666\u066a\u0001\u0000\u0000\u0000\u0667\u0669\u0005\u0004\u0000\u0000"+
		"\u0668\u0667\u0001\u0000\u0000\u0000\u0669\u066c\u0001\u0000\u0000\u0000"+
		"\u066a\u0668\u0001\u0000\u0000\u0000\u066a\u066b\u0001\u0000\u0000\u0000"+
		"\u066b\u066d\u0001\u0000\u0000\u0000\u066c\u066a\u0001\u0000\u0000\u0000"+
		"\u066d\u066e\u0003~?\u0000\u066es\u0001\u0000\u0000\u0000\u066f\u0672"+
		"\u0003v;\u0000\u0670\u0672\u0003x<\u0000\u0671\u066f\u0001\u0000\u0000"+
		"\u0000\u0671\u0670\u0001\u0000\u0000\u0000\u0672u\u0001\u0000\u0000\u0000"+
		"\u0673\u0677\u0005K\u0000\u0000\u0674\u0676\u0005\u0004\u0000\u0000\u0675"+
		"\u0674\u0001\u0000\u0000\u0000\u0676\u0679\u0001\u0000\u0000\u0000\u0677"+
		"\u0675\u0001\u0000\u0000\u0000\u0677\u0678\u0001\u0000\u0000\u0000\u0678"+
		"\u067a\u0001\u0000\u0000\u0000\u0679\u0677\u0001\u0000\u0000\u0000\u067a"+
		"\u067e\u0005\b\u0000\u0000\u067b\u067d\u0003\u011c\u008e\u0000\u067c\u067b"+
		"\u0001\u0000\u0000\u0000\u067d\u0680\u0001\u0000\u0000\u0000\u067e\u067c"+
		"\u0001\u0000\u0000\u0000\u067e\u067f\u0001\u0000\u0000\u0000\u067f\u0681"+
		"\u0001\u0000\u0000\u0000\u0680\u067e\u0001\u0000\u0000\u0000\u0681\u0682"+
		"\u0003:\u001d\u0000\u0682\u0683\u0005\u0019\u0000\u0000\u0683\u0684\u0003"+
		"~?\u0000\u0684\u0688\u0005\t\u0000\u0000\u0685\u0687\u0005\u0004\u0000"+
		"\u0000\u0686\u0685\u0001\u0000\u0000\u0000\u0687\u068a\u0001\u0000\u0000"+
		"\u0000\u0688\u0686\u0001\u0000\u0000\u0000\u0688\u0689\u0001\u0000\u0000"+
		"\u0000\u0689\u068c\u0001\u0000\u0000\u0000\u068a\u0688\u0001\u0000\u0000"+
		"\u0000\u068b\u068d\u0003z=\u0000\u068c\u068b\u0001\u0000\u0000\u0000\u068c"+
		"\u068d\u0001\u0000\u0000\u0000\u068dw\u0001\u0000\u0000\u0000\u068e\u0692"+
		"\u0005L\u0000\u0000\u068f\u0691\u0005\u0004\u0000\u0000\u0690\u068f\u0001"+
		"\u0000\u0000\u0000\u0691\u0694\u0001\u0000\u0000\u0000\u0692\u0690\u0001"+
		"\u0000\u0000\u0000\u0692\u0693\u0001\u0000\u0000\u0000\u0693\u0695\u0001"+
		"\u0000\u0000\u0000\u0694\u0692\u0001\u0000\u0000\u0000\u0695\u0696\u0005"+
		"\b\u0000\u0000\u0696\u0697\u0003~?\u0000\u0697\u069b\u0005\t\u0000\u0000"+
		"\u0698\u069a\u0005\u0004\u0000\u0000\u0699\u0698\u0001\u0000\u0000\u0000"+
		"\u069a\u069d\u0001\u0000\u0000\u0000\u069b\u0699\u0001\u0000\u0000\u0000"+
		"\u069b\u069c\u0001\u0000\u0000\u0000\u069c\u06a0\u0001\u0000\u0000\u0000"+
		"\u069d\u069b\u0001\u0000\u0000\u0000\u069e\u06a1\u0003z=\u0000\u069f\u06a1"+
		"\u0005\u001a\u0000\u0000\u06a0\u069e\u0001\u0000\u0000\u0000\u06a0\u069f"+
		"\u0001\u0000\u0000\u0000\u06a1y\u0001\u0000\u0000\u0000\u06a2\u06a5\u0003"+
		"|>\u0000\u06a3\u06a5\u0003j5\u0000\u06a4\u06a2\u0001\u0000\u0000\u0000"+
		"\u06a4\u06a3\u0001\u0000\u0000\u0000\u06a5{\u0001\u0000\u0000\u0000\u06a6"+
		"\u06aa\u0005\f\u0000\u0000\u06a7\u06a9\u0005\u0004\u0000\u0000\u06a8\u06a7"+
		"\u0001\u0000\u0000\u0000\u06a9\u06ac\u0001\u0000\u0000\u0000\u06aa\u06a8"+
		"\u0001\u0000\u0000\u0000\u06aa\u06ab\u0001\u0000\u0000\u0000\u06ab\u06ad"+
		"\u0001\u0000\u0000\u0000\u06ac\u06aa\u0001\u0000\u0000\u0000\u06ad\u06b1"+
		"\u0003h4\u0000\u06ae\u06b0\u0005\u0004\u0000\u0000\u06af\u06ae\u0001\u0000"+
		"\u0000\u0000\u06b0\u06b3\u0001\u0000\u0000\u0000\u06b1\u06af\u0001\u0000"+
		"\u0000\u0000\u06b1\u06b2\u0001\u0000\u0000\u0000\u06b2\u06b4\u0001\u0000"+
		"\u0000\u0000\u06b3\u06b1\u0001\u0000\u0000\u0000\u06b4\u06b5\u0005\r\u0000"+
		"\u0000\u06b5}\u0001\u0000\u0000\u0000\u06b6\u06b7\u0003\u0080@\u0000\u06b7"+
		"\u007f\u0001\u0000\u0000\u0000\u06b8\u06c9\u0003\u0082A\u0000\u06b9\u06bb"+
		"\u0005\u0004\u0000\u0000\u06ba\u06b9\u0001\u0000\u0000\u0000\u06bb\u06be"+
		"\u0001\u0000\u0000\u0000\u06bc\u06ba\u0001\u0000\u0000\u0000\u06bc\u06bd"+
		"\u0001\u0000\u0000\u0000\u06bd\u06bf\u0001\u0000\u0000\u0000\u06be\u06bc"+
		"\u0001\u0000\u0000\u0000\u06bf\u06c3\u0005\u0016\u0000\u0000\u06c0\u06c2"+
		"\u0005\u0004\u0000\u0000\u06c1\u06c0\u0001\u0000\u0000\u0000\u06c2\u06c5"+
		"\u0001\u0000\u0000\u0000\u06c3\u06c1\u0001\u0000\u0000\u0000\u06c3\u06c4"+
		"\u0001\u0000\u0000\u0000\u06c4\u06c6\u0001\u0000\u0000\u0000\u06c5\u06c3"+
		"\u0001\u0000\u0000\u0000\u06c6\u06c8\u0003\u0082A\u0000\u06c7\u06bc\u0001"+
		"\u0000\u0000\u0000\u06c8\u06cb\u0001\u0000\u0000\u0000\u06c9\u06c7\u0001"+
		"\u0000\u0000\u0000\u06c9\u06ca\u0001\u0000\u0000\u0000\u06ca\u0081\u0001"+
		"\u0000\u0000\u0000\u06cb\u06c9\u0001\u0000\u0000\u0000\u06cc\u06dd\u0003"+
		"\u0084B\u0000\u06cd\u06cf\u0005\u0004\u0000\u0000\u06ce\u06cd\u0001\u0000"+
		"\u0000\u0000\u06cf\u06d2\u0001\u0000\u0000\u0000\u06d0\u06ce\u0001\u0000"+
		"\u0000\u0000\u06d0\u06d1\u0001\u0000\u0000\u0000\u06d1\u06d3\u0001\u0000"+
		"\u0000\u0000\u06d2\u06d0\u0001\u0000\u0000\u0000\u06d3\u06d7\u0005\u0015"+
		"\u0000\u0000\u06d4\u06d6\u0005\u0004\u0000\u0000\u06d5\u06d4\u0001\u0000"+
		"\u0000\u0000\u06d6\u06d9\u0001\u0000\u0000\u0000\u06d7\u06d5\u0001\u0000"+
		"\u0000\u0000\u06d7\u06d8\u0001\u0000\u0000\u0000\u06d8\u06da\u0001\u0000"+
		"\u0000\u0000\u06d9\u06d7\u0001\u0000\u0000\u0000\u06da\u06dc\u0003\u0084"+
		"B\u0000\u06db\u06d0\u0001\u0000\u0000\u0000\u06dc\u06df\u0001\u0000\u0000"+
		"\u0000\u06dd\u06db\u0001\u0000\u0000\u0000\u06dd\u06de\u0001\u0000\u0000"+
		"\u0000\u06de\u0083\u0001\u0000\u0000\u0000\u06df\u06dd\u0001\u0000\u0000"+
		"\u0000\u06e0\u06ec\u0003\u0086C\u0000\u06e1\u06e5\u0003\u00f0x\u0000\u06e2"+
		"\u06e4\u0005\u0004\u0000\u0000\u06e3\u06e2\u0001\u0000\u0000\u0000\u06e4"+
		"\u06e7\u0001\u0000\u0000\u0000\u06e5\u06e3\u0001\u0000\u0000\u0000\u06e5"+
		"\u06e6\u0001\u0000\u0000\u0000\u06e6\u06e8\u0001\u0000\u0000\u0000\u06e7"+
		"\u06e5\u0001\u0000\u0000\u0000\u06e8\u06e9\u0003\u0086C\u0000\u06e9\u06eb"+
		"\u0001\u0000\u0000\u0000\u06ea\u06e1\u0001\u0000\u0000\u0000\u06eb\u06ee"+
		"\u0001\u0000\u0000\u0000\u06ec\u06ea\u0001\u0000\u0000\u0000\u06ec\u06ed"+
		"\u0001\u0000\u0000\u0000\u06ed\u0085\u0001\u0000\u0000\u0000\u06ee\u06ec"+
		"\u0001\u0000\u0000\u0000\u06ef\u06fb\u0003\u0088D\u0000\u06f0\u06f4\u0003"+
		"\u00f2y\u0000\u06f1\u06f3\u0005\u0004\u0000\u0000\u06f2\u06f1\u0001\u0000"+
		"\u0000\u0000\u06f3\u06f6\u0001\u0000\u0000\u0000\u06f4\u06f2\u0001\u0000"+
		"\u0000\u0000\u06f4\u06f5\u0001\u0000\u0000\u0000\u06f5\u06f7\u0001\u0000"+
		"\u0000\u0000\u06f6\u06f4\u0001\u0000\u0000\u0000\u06f7\u06f8\u0003\u0088"+
		"D\u0000\u06f8\u06fa\u0001\u0000\u0000\u0000\u06f9\u06f0\u0001\u0000\u0000"+
		"\u0000\u06fa\u06fd\u0001\u0000\u0000\u0000\u06fb\u06f9\u0001\u0000\u0000"+
		"\u0000\u06fb\u06fc\u0001\u0000\u0000\u0000\u06fc\u0087\u0001\u0000\u0000"+
		"\u0000\u06fd\u06fb\u0001\u0000\u0000\u0000\u06fe\u0702\u0003\u008aE\u0000"+
		"\u06ff\u0701\u0003\u00e4r\u0000\u0700\u06ff\u0001\u0000\u0000\u0000\u0701"+
		"\u0704\u0001\u0000\u0000\u0000\u0702\u0700\u0001\u0000\u0000\u0000\u0702"+
		"\u0703\u0001\u0000\u0000\u0000\u0703\u0089\u0001\u0000\u0000\u0000\u0704"+
		"\u0702\u0001\u0000\u0000\u0000\u0705\u070f\u0003\u008cF\u0000\u0706\u070a"+
		"\u0003\u00f4z\u0000\u0707\u0709\u0005\u0004\u0000\u0000\u0708\u0707\u0001"+
		"\u0000\u0000\u0000\u0709\u070c\u0001\u0000\u0000\u0000\u070a\u0708\u0001"+
		"\u0000\u0000\u0000\u070a\u070b\u0001\u0000\u0000\u0000\u070b\u070d\u0001"+
		"\u0000\u0000\u0000\u070c\u070a\u0001\u0000\u0000\u0000\u070d\u070e\u0003"+
		"N\'\u0000\u070e\u0710\u0001\u0000\u0000\u0000\u070f\u0706\u0001\u0000"+
		"\u0000\u0000\u070f\u0710\u0001\u0000\u0000\u0000\u0710\u008b\u0001\u0000"+
		"\u0000\u0000\u0711\u0723\u0003\u0090H\u0000\u0712\u0714\u0005\u0004\u0000"+
		"\u0000\u0713\u0712\u0001\u0000\u0000\u0000\u0714\u0717\u0001\u0000\u0000"+
		"\u0000\u0715\u0713\u0001\u0000\u0000\u0000\u0715\u0716\u0001\u0000\u0000"+
		"\u0000\u0716\u0718\u0001\u0000\u0000\u0000\u0717\u0715\u0001\u0000\u0000"+
		"\u0000\u0718\u071c\u0003\u008eG\u0000\u0719\u071b\u0005\u0004\u0000\u0000"+
		"\u071a\u0719\u0001\u0000\u0000\u0000\u071b\u071e\u0001\u0000\u0000\u0000"+
		"\u071c\u071a\u0001\u0000\u0000\u0000\u071c\u071d\u0001\u0000\u0000\u0000"+
		"\u071d\u071f\u0001\u0000\u0000\u0000\u071e\u071c\u0001\u0000\u0000\u0000"+
		"\u071f\u0720\u0003\u0090H\u0000\u0720\u0722\u0001\u0000\u0000\u0000\u0721"+
		"\u0715\u0001\u0000\u0000\u0000\u0722\u0725\u0001\u0000\u0000\u0000\u0723"+
		"\u0721\u0001\u0000\u0000\u0000\u0723\u0724\u0001\u0000\u0000\u0000\u0724"+
		"\u008d\u0001\u0000\u0000\u0000\u0725\u0723\u0001\u0000\u0000\u0000\u0726"+
		"\u0727\u0005(\u0000\u0000\u0727\u0728\u0005\u0019\u0000\u0000\u0728\u008f"+
		"\u0001\u0000\u0000\u0000\u0729\u0735\u0003\u0092I\u0000\u072a\u072e\u0003"+
		"\u00f6{\u0000\u072b\u072d\u0005\u0004\u0000\u0000\u072c\u072b\u0001\u0000"+
		"\u0000\u0000\u072d\u0730\u0001\u0000\u0000\u0000\u072e\u072c\u0001\u0000"+
		"\u0000\u0000\u072e\u072f\u0001\u0000\u0000\u0000\u072f\u0731\u0001\u0000"+
		"\u0000\u0000\u0730\u072e\u0001\u0000\u0000\u0000\u0731\u0732\u0003\u0092"+
		"I\u0000\u0732\u0734\u0001\u0000\u0000\u0000\u0733\u072a\u0001\u0000\u0000"+
		"\u0000\u0734\u0737\u0001\u0000\u0000\u0000\u0735\u0733\u0001\u0000\u0000"+
		"\u0000\u0735\u0736\u0001\u0000\u0000\u0000\u0736\u0091\u0001\u0000\u0000"+
		"\u0000\u0737\u0735\u0001\u0000\u0000\u0000\u0738\u0744\u0003\u0094J\u0000"+
		"\u0739\u073d\u0003\u00f8|\u0000\u073a\u073c\u0005\u0004\u0000\u0000\u073b"+
		"\u073a\u0001\u0000\u0000\u0000\u073c\u073f\u0001\u0000\u0000\u0000\u073d"+
		"\u073b\u0001\u0000\u0000\u0000\u073d\u073e\u0001\u0000\u0000\u0000\u073e"+
		"\u0740\u0001\u0000\u0000\u0000\u073f\u073d\u0001\u0000\u0000\u0000\u0740"+
		"\u0741\u0003\u0094J\u0000\u0741\u0743\u0001\u0000\u0000\u0000\u0742\u0739"+
		"\u0001\u0000\u0000\u0000\u0743\u0746\u0001\u0000\u0000\u0000\u0744\u0742"+
		"\u0001\u0000\u0000\u0000\u0744\u0745\u0001\u0000\u0000\u0000\u0745\u0093"+
		"\u0001\u0000\u0000\u0000\u0746\u0744\u0001\u0000\u0000\u0000\u0747\u0753"+
		"\u0003\u0096K\u0000\u0748\u074a\u0005\u0004\u0000\u0000\u0749\u0748\u0001"+
		"\u0000\u0000\u0000\u074a\u074d\u0001\u0000\u0000\u0000\u074b\u0749\u0001"+
		"\u0000\u0000\u0000\u074b\u074c\u0001\u0000\u0000\u0000\u074c\u074e\u0001"+
		"\u0000\u0000\u0000\u074d\u074b\u0001\u0000\u0000\u0000\u074e\u074f\u0003"+
		"\u00fa}\u0000\u074f\u0750\u0003\u0096K\u0000\u0750\u0752\u0001\u0000\u0000"+
		"\u0000\u0751\u074b\u0001\u0000\u0000\u0000\u0752\u0755\u0001\u0000\u0000"+
		"\u0000\u0753\u0751\u0001\u0000\u0000\u0000\u0753\u0754\u0001\u0000\u0000"+
		"\u0000\u0754\u0095\u0001\u0000\u0000\u0000\u0755\u0753\u0001\u0000\u0000"+
		"\u0000\u0756\u0758\u0003\u0098L\u0000\u0757\u0756\u0001\u0000\u0000\u0000"+
		"\u0758\u075b\u0001\u0000\u0000\u0000\u0759\u0757\u0001\u0000\u0000\u0000"+
		"\u0759\u075a\u0001\u0000\u0000\u0000\u075a\u075c\u0001\u0000\u0000\u0000"+
		"\u075b\u0759\u0001\u0000\u0000\u0000\u075c\u075d\u0003\u009aM\u0000\u075d"+
		"\u0097\u0001\u0000\u0000\u0000\u075e\u0762\u0003\u00fc~\u0000\u075f\u0761"+
		"\u0005\u0004\u0000\u0000\u0760\u075f\u0001\u0000\u0000\u0000\u0761\u0764"+
		"\u0001\u0000\u0000\u0000\u0762\u0760\u0001\u0000\u0000\u0000\u0762\u0763"+
		"\u0001\u0000\u0000\u0000\u0763\u0768\u0001\u0000\u0000\u0000\u0764\u0762"+
		"\u0001\u0000\u0000\u0000\u0765\u0768\u0003\u011c\u008e\u0000\u0766\u0768"+
		"\u0003p8\u0000\u0767\u075e\u0001\u0000\u0000\u0000\u0767\u0765\u0001\u0000"+
		"\u0000\u0000\u0767\u0766\u0001\u0000\u0000\u0000\u0768\u0099\u0001\u0000"+
		"\u0000\u0000\u0769\u076d\u0003\u009cN\u0000\u076a\u076c\u0003\u00d4j\u0000"+
		"\u076b\u076a\u0001\u0000\u0000\u0000\u076c\u076f\u0001\u0000\u0000\u0000"+
		"\u076d\u076b\u0001\u0000\u0000\u0000\u076d\u076e\u0001\u0000\u0000\u0000"+
		"\u076e\u009b\u0001\u0000\u0000\u0000\u076f\u076d\u0001\u0000\u0000\u0000"+
		"\u0770\u077e\u0003\u009eO\u0000\u0771\u077e\u0003\u00a0P\u0000\u0772\u077e"+
		"\u0003\u0124\u0092\u0000\u0773\u077e\u0003\u00a2Q\u0000\u0774\u077e\u0003"+
		"\u00a4R\u0000\u0775\u077e\u0003\u00d2i\u0000\u0776\u077e\u0003\u00b8\\"+
		"\u0000\u0777\u077e\u0003\u00ba]\u0000\u0778\u077e\u0003\u00bc^\u0000\u0779"+
		"\u077e\u0003\u00be_\u0000\u077a\u077e\u0003\u00c2a\u0000\u077b\u077e\u0003"+
		"\u00cae\u0000\u077c\u077e\u0003\u00d0h\u0000\u077d\u0770\u0001\u0000\u0000"+
		"\u0000\u077d\u0771\u0001\u0000\u0000\u0000\u077d\u0772\u0001\u0000\u0000"+
		"\u0000\u077d\u0773\u0001\u0000\u0000\u0000\u077d\u0774\u0001\u0000\u0000"+
		"\u0000\u077d\u0775\u0001\u0000\u0000\u0000\u077d\u0776\u0001\u0000\u0000"+
		"\u0000\u077d\u0777\u0001\u0000\u0000\u0000\u077d\u0778\u0001\u0000\u0000"+
		"\u0000\u077d\u0779\u0001\u0000\u0000\u0000\u077d\u077a\u0001\u0000\u0000"+
		"\u0000\u077d\u077b\u0001\u0000\u0000\u0000\u077d\u077c\u0001\u0000\u0000"+
		"\u0000\u077e\u009d\u0001\u0000\u0000\u0000\u077f\u0783\u0005\b\u0000\u0000"+
		"\u0780\u0782\u0005\u0004\u0000\u0000\u0781\u0780\u0001\u0000\u0000\u0000"+
		"\u0782\u0785\u0001\u0000\u0000\u0000\u0783\u0781\u0001\u0000\u0000\u0000"+
		"\u0783\u0784\u0001\u0000\u0000\u0000\u0784\u0786\u0001\u0000\u0000\u0000"+
		"\u0785\u0783\u0001\u0000\u0000\u0000\u0786\u078a\u0003~?\u0000\u0787\u0789"+
		"\u0005\u0004\u0000\u0000\u0788\u0787\u0001\u0000\u0000\u0000\u0789\u078c"+
		"\u0001\u0000\u0000\u0000\u078a\u0788\u0001\u0000\u0000\u0000\u078a\u078b"+
		"\u0001\u0000\u0000\u0000\u078b\u078d\u0001\u0000\u0000\u0000\u078c\u078a"+
		"\u0001\u0000\u0000\u0000\u078d\u078e\u0005\t\u0000\u0000\u078e\u009f\u0001"+
		"\u0000\u0000\u0000\u078f\u0793\u0005\n\u0000\u0000\u0790\u0792\u0005\u0004"+
		"\u0000\u0000\u0791\u0790\u0001\u0000\u0000\u0000\u0792\u0795\u0001\u0000"+
		"\u0000\u0000\u0793\u0791\u0001\u0000\u0000\u0000\u0793\u0794\u0001\u0000"+
		"\u0000\u0000\u0794\u07b9\u0001\u0000\u0000\u0000\u0795\u0793\u0001\u0000"+
		"\u0000\u0000\u0796\u07a7\u0003~?\u0000\u0797\u0799\u0005\u0004\u0000\u0000"+
		"\u0798\u0797\u0001\u0000\u0000\u0000\u0799\u079c\u0001\u0000\u0000\u0000"+
		"\u079a\u0798\u0001\u0000\u0000\u0000\u079a\u079b\u0001\u0000\u0000\u0000"+
		"\u079b\u079d\u0001\u0000\u0000\u0000\u079c\u079a\u0001\u0000\u0000\u0000"+
		"\u079d\u07a1\u0005\u0007\u0000\u0000\u079e\u07a0\u0005\u0004\u0000\u0000"+
		"\u079f\u079e\u0001\u0000\u0000\u0000\u07a0\u07a3\u0001\u0000\u0000\u0000"+
		"\u07a1\u079f\u0001\u0000\u0000\u0000\u07a1\u07a2\u0001\u0000\u0000\u0000"+
		"\u07a2\u07a4\u0001\u0000\u0000\u0000\u07a3\u07a1\u0001\u0000\u0000\u0000"+
		"\u07a4\u07a6\u0003~?\u0000\u07a5\u079a\u0001\u0000\u0000\u0000\u07a6\u07a9"+
		"\u0001\u0000\u0000\u0000\u07a7\u07a5\u0001\u0000\u0000\u0000\u07a7\u07a8"+
		"\u0001\u0000\u0000\u0000\u07a8\u07b1\u0001\u0000\u0000\u0000\u07a9\u07a7"+
		"\u0001\u0000\u0000\u0000\u07aa\u07ac\u0005\u0004\u0000\u0000\u07ab\u07aa"+
		"\u0001\u0000\u0000\u0000\u07ac\u07af\u0001\u0000\u0000\u0000\u07ad\u07ab"+
		"\u0001\u0000\u0000\u0000\u07ad\u07ae\u0001\u0000\u0000\u0000\u07ae\u07b0"+
		"\u0001\u0000\u0000\u0000\u07af\u07ad\u0001\u0000\u0000\u0000\u07b0\u07b2"+
		"\u0005\u0007\u0000\u0000\u07b1\u07ad\u0001\u0000\u0000\u0000\u07b1\u07b2"+
		"\u0001\u0000\u0000\u0000\u07b2\u07b6\u0001\u0000\u0000\u0000\u07b3\u07b5"+
		"\u0005\u0004\u0000\u0000\u07b4\u07b3\u0001\u0000\u0000\u0000\u07b5\u07b8"+
		"\u0001\u0000\u0000\u0000\u07b6\u07b4\u0001\u0000\u0000\u0000\u07b6\u07b7"+
		"\u0001\u0000\u0000\u0000\u07b7\u07ba\u0001\u0000\u0000\u0000\u07b8\u07b6"+
		"\u0001\u0000\u0000\u0000\u07b9\u0796\u0001\u0000\u0000\u0000\u07b9\u07ba"+
		"\u0001\u0000\u0000\u0000\u07ba\u07bb\u0001\u0000\u0000\u0000\u07bb\u07bc"+
		"\u0005\u000b\u0000\u0000\u07bc\u00a1\u0001\u0000\u0000\u0000\u07bd\u07be"+
		"\u0007\u0005\u0000\u0000\u07be\u00a3\u0001\u0000\u0000\u0000\u07bf\u07c2"+
		"\u0003\u00a6S\u0000\u07c0\u07c2\u0003\u00a8T\u0000\u07c1\u07bf\u0001\u0000"+
		"\u0000\u0000\u07c1\u07c0\u0001\u0000\u0000\u0000\u07c2\u00a5\u0001\u0000"+
		"\u0000\u0000\u07c3\u07c8\u0005{\u0000\u0000\u07c4\u07c7\u0003\u00aaU\u0000"+
		"\u07c5\u07c7\u0003\u00acV\u0000\u07c6\u07c4\u0001\u0000\u0000\u0000\u07c6"+
		"\u07c5\u0001\u0000\u0000\u0000\u07c7\u07ca\u0001\u0000\u0000\u0000\u07c8"+
		"\u07c6\u0001\u0000\u0000\u0000\u07c8\u07c9\u0001\u0000\u0000\u0000\u07c9"+
		"\u07cb\u0001\u0000\u0000\u0000\u07ca\u07c8\u0001\u0000\u0000\u0000\u07cb"+
		"\u07cc\u0005\u0084\u0000\u0000\u07cc\u00a7\u0001\u0000\u0000\u0000\u07cd"+
		"\u07d3\u0005|\u0000\u0000\u07ce\u07d2\u0003\u00aeW\u0000\u07cf\u07d2\u0003"+
		"\u00b0X\u0000\u07d0\u07d2\u0005\u008a\u0000\u0000\u07d1\u07ce\u0001\u0000"+
		"\u0000\u0000\u07d1\u07cf\u0001\u0000\u0000\u0000\u07d1\u07d0\u0001\u0000"+
		"\u0000\u0000\u07d2\u07d5\u0001\u0000\u0000\u0000\u07d3\u07d1\u0001\u0000"+
		"\u0000\u0000\u07d3\u07d4\u0001\u0000\u0000\u0000\u07d4\u07d6\u0001\u0000"+
		"\u0000\u0000\u07d5\u07d3\u0001\u0000\u0000\u0000\u07d6\u07d7\u0005\u0089"+
		"\u0000\u0000\u07d7\u00a9\u0001\u0000\u0000\u0000\u07d8\u07d9\u0007\u0006"+
		"\u0000\u0000\u07d9\u00ab\u0001\u0000\u0000\u0000\u07da\u07de\u0005\u0088"+
		"\u0000\u0000\u07db\u07dd\u0005\u0004\u0000\u0000\u07dc\u07db\u0001\u0000"+
		"\u0000\u0000\u07dd\u07e0\u0001\u0000\u0000\u0000\u07de\u07dc\u0001\u0000"+
		"\u0000\u0000\u07de\u07df\u0001\u0000\u0000\u0000\u07df\u07e1\u0001\u0000"+
		"\u0000\u0000\u07e0\u07de\u0001\u0000\u0000\u0000\u07e1\u07e5\u0003~?\u0000"+
		"\u07e2\u07e4\u0005\u0004\u0000\u0000\u07e3\u07e2\u0001\u0000\u0000\u0000"+
		"\u07e4\u07e7\u0001\u0000\u0000\u0000\u07e5\u07e3\u0001\u0000\u0000\u0000"+
		"\u07e5\u07e6\u0001\u0000\u0000\u0000\u07e6\u07e8\u0001\u0000\u0000\u0000"+
		"\u07e7\u07e5\u0001\u0000\u0000\u0000\u07e8\u07e9\u0005\r\u0000\u0000\u07e9"+
		"\u00ad\u0001\u0000\u0000\u0000\u07ea\u07eb\u0007\u0007\u0000\u0000\u07eb"+
		"\u00af\u0001\u0000\u0000\u0000\u07ec\u07f0\u0005\u008e\u0000\u0000\u07ed"+
		"\u07ef\u0005\u0004\u0000\u0000\u07ee\u07ed\u0001\u0000\u0000\u0000\u07ef"+
		"\u07f2\u0001\u0000\u0000\u0000\u07f0\u07ee\u0001\u0000\u0000\u0000\u07f0"+
		"\u07f1\u0001\u0000\u0000\u0000\u07f1\u07f3\u0001\u0000\u0000\u0000\u07f2"+
		"\u07f0\u0001\u0000\u0000\u0000\u07f3\u07f7\u0003~?\u0000\u07f4\u07f6\u0005"+
		"\u0004\u0000\u0000\u07f5\u07f4\u0001\u0000\u0000\u0000\u07f6\u07f9\u0001"+
		"\u0000\u0000\u0000\u07f7\u07f5\u0001\u0000\u0000\u0000\u07f7\u07f8\u0001"+
		"\u0000\u0000\u0000\u07f8\u07fa\u0001\u0000\u0000\u0000\u07f9\u07f7\u0001"+
		"\u0000\u0000\u0000\u07fa\u07fb\u0005\r\u0000\u0000\u07fb\u00b1\u0001\u0000"+
		"\u0000\u0000\u07fc\u0800\u0005\f\u0000\u0000\u07fd\u07ff\u0005\u0004\u0000"+
		"\u0000\u07fe\u07fd\u0001\u0000\u0000\u0000\u07ff\u0802\u0001\u0000\u0000"+
		"\u0000\u0800\u07fe\u0001\u0000\u0000\u0000\u0800\u0801\u0001\u0000\u0000"+
		"\u0000\u0801\u0813\u0001\u0000\u0000\u0000\u0802\u0800\u0001\u0000\u0000"+
		"\u0000\u0803\u0805\u0003\u00b4Z\u0000\u0804\u0803\u0001\u0000\u0000\u0000"+
		"\u0804\u0805\u0001\u0000\u0000\u0000\u0805\u0809\u0001\u0000\u0000\u0000"+
		"\u0806\u0808\u0005\u0004\u0000\u0000\u0807\u0806\u0001\u0000\u0000\u0000"+
		"\u0808\u080b\u0001\u0000\u0000\u0000\u0809\u0807\u0001\u0000\u0000\u0000"+
		"\u0809\u080a\u0001\u0000\u0000\u0000\u080a\u080c\u0001\u0000\u0000\u0000"+
		"\u080b\u0809\u0001\u0000\u0000\u0000\u080c\u0810\u0005!\u0000\u0000\u080d"+
		"\u080f\u0005\u0004\u0000\u0000\u080e\u080d\u0001\u0000\u0000\u0000\u080f"+
		"\u0812\u0001\u0000\u0000\u0000\u0810\u080e\u0001\u0000\u0000\u0000\u0810"+
		"\u0811\u0001\u0000\u0000\u0000\u0811\u0814\u0001\u0000\u0000\u0000\u0812"+
		"\u0810\u0001\u0000\u0000\u0000\u0813\u0804\u0001\u0000\u0000\u0000\u0813"+
		"\u0814\u0001\u0000\u0000\u0000\u0814\u0815\u0001\u0000\u0000\u0000\u0815"+
		"\u0819\u0003h4\u0000\u0816\u0818\u0005\u0004\u0000\u0000\u0817\u0816\u0001"+
		"\u0000\u0000\u0000\u0818\u081b\u0001\u0000\u0000\u0000\u0819\u0817\u0001"+
		"\u0000\u0000\u0000\u0819\u081a\u0001\u0000\u0000\u0000\u081a\u081c\u0001"+
		"\u0000\u0000\u0000\u081b\u0819\u0001\u0000\u0000\u0000\u081c\u081d\u0005"+
		"\r\u0000\u0000\u081d\u00b3\u0001\u0000\u0000\u0000\u081e\u082f\u0003:"+
		"\u001d\u0000\u081f\u0821\u0005\u0004\u0000\u0000\u0820\u081f\u0001\u0000"+
		"\u0000\u0000\u0821\u0824\u0001\u0000\u0000\u0000\u0822\u0820\u0001\u0000"+
		"\u0000\u0000\u0822\u0823\u0001\u0000\u0000\u0000\u0823\u0825\u0001\u0000"+
		"\u0000\u0000\u0824\u0822\u0001\u0000\u0000\u0000\u0825\u0829\u0005\u0007"+
		"\u0000\u0000\u0826\u0828\u0005\u0004\u0000\u0000\u0827\u0826\u0001\u0000"+
		"\u0000\u0000\u0828\u082b\u0001\u0000\u0000\u0000\u0829\u0827\u0001\u0000"+
		"\u0000\u0000\u0829\u082a\u0001\u0000\u0000\u0000\u082a\u082c\u0001\u0000"+
		"\u0000\u0000\u082b\u0829\u0001\u0000\u0000\u0000\u082c\u082e\u0003:\u001d"+
		"\u0000\u082d\u0822\u0001\u0000\u0000\u0000\u082e\u0831\u0001\u0000\u0000"+
		"\u0000\u082f\u082d\u0001\u0000\u0000\u0000\u082f\u0830\u0001\u0000\u0000"+
		"\u0000\u0830\u0839\u0001\u0000\u0000\u0000\u0831\u082f\u0001\u0000\u0000"+
		"\u0000\u0832\u0834\u0005\u0004\u0000\u0000\u0833\u0832\u0001\u0000\u0000"+
		"\u0000\u0834\u0837\u0001\u0000\u0000\u0000\u0835\u0833\u0001\u0000\u0000"+
		"\u0000\u0835\u0836\u0001\u0000\u0000\u0000\u0836\u0838\u0001\u0000\u0000"+
		"\u0000\u0837\u0835\u0001\u0000\u0000\u0000\u0838\u083a\u0005\u0007\u0000"+
		"\u0000\u0839\u0835\u0001\u0000\u0000\u0000\u0839\u083a\u0001\u0000\u0000"+
		"\u0000\u083a\u00b5\u0001\u0000\u0000\u0000\u083b\u084b\u0005;\u0000\u0000"+
		"\u083c\u083e\u0005\u0004\u0000\u0000\u083d\u083c\u0001\u0000\u0000\u0000"+
		"\u083e\u0841\u0001\u0000\u0000\u0000\u083f\u083d\u0001\u0000\u0000\u0000"+
		"\u083f\u0840\u0001\u0000\u0000\u0000\u0840\u0842\u0001\u0000\u0000\u0000"+
		"\u0841\u083f\u0001\u0000\u0000\u0000\u0842\u0846\u0003N\'\u0000\u0843"+
		"\u0845\u0005\u0004\u0000\u0000\u0844\u0843\u0001\u0000\u0000\u0000\u0845"+
		"\u0848\u0001\u0000\u0000\u0000\u0846\u0844\u0001\u0000\u0000\u0000\u0846"+
		"\u0847\u0001\u0000\u0000\u0000\u0847\u0849\u0001\u0000\u0000\u0000\u0848"+
		"\u0846\u0001\u0000\u0000\u0000\u0849\u084a\u0005\u0006\u0000\u0000\u084a"+
		"\u084c\u0001\u0000\u0000\u0000\u084b\u083f\u0001\u0000\u0000\u0000\u084b"+
		"\u084c\u0001\u0000\u0000\u0000\u084c\u0850\u0001\u0000\u0000\u0000\u084d"+
		"\u084f\u0005\u0004\u0000\u0000\u084e\u084d\u0001\u0000\u0000\u0000\u084f"+
		"\u0852\u0001\u0000\u0000\u0000\u0850\u084e\u0001\u0000\u0000\u0000\u0850"+
		"\u0851\u0001\u0000\u0000\u0000\u0851\u0853\u0001\u0000\u0000\u0000\u0852"+
		"\u0850\u0001\u0000\u0000\u0000\u0853\u0862\u0003@ \u0000\u0854\u0856\u0005"+
		"\u0004\u0000\u0000\u0855\u0854\u0001\u0000\u0000\u0000\u0856\u0859\u0001"+
		"\u0000\u0000\u0000\u0857\u0855\u0001\u0000\u0000\u0000\u0857\u0858\u0001"+
		"\u0000\u0000\u0000\u0858\u085a\u0001\u0000\u0000\u0000\u0859\u0857\u0001"+
		"\u0000\u0000\u0000\u085a\u085e\u0005\u0019\u0000\u0000\u085b\u085d\u0005"+
		"\u0004\u0000\u0000\u085c\u085b\u0001\u0000\u0000\u0000\u085d\u0860\u0001"+
		"\u0000\u0000\u0000\u085e\u085c\u0001\u0000\u0000\u0000\u085e\u085f\u0001"+
		"\u0000\u0000\u0000\u085f\u0861\u0001\u0000\u0000\u0000\u0860\u085e\u0001"+
		"\u0000\u0000\u0000\u0861\u0863\u0003N\'\u0000\u0862\u0857\u0001\u0000"+
		"\u0000\u0000\u0862\u0863\u0001\u0000\u0000\u0000\u0863\u086b\u0001\u0000"+
		"\u0000\u0000\u0864\u0866\u0005\u0004\u0000\u0000\u0865\u0864\u0001\u0000"+
		"\u0000\u0000\u0866\u0869\u0001\u0000\u0000\u0000\u0867\u0865\u0001\u0000"+
		"\u0000\u0000\u0867\u0868\u0001\u0000\u0000\u0000\u0868\u086a\u0001\u0000"+
		"\u0000\u0000\u0869\u0867\u0001\u0000\u0000\u0000\u086a\u086c\u0003$\u0012"+
		"\u0000\u086b\u0867\u0001\u0000\u0000\u0000\u086b\u086c\u0001\u0000\u0000"+
		"\u0000\u086c\u0874\u0001\u0000\u0000\u0000\u086d\u086f\u0005\u0004\u0000"+
		"\u0000\u086e\u086d\u0001\u0000\u0000\u0000\u086f\u0872\u0001\u0000\u0000"+
		"\u0000\u0870\u086e\u0001\u0000\u0000\u0000\u0870\u0871\u0001\u0000\u0000"+
		"\u0000\u0871\u0873\u0001\u0000\u0000\u0000\u0872\u0870\u0001\u0000\u0000"+
		"\u0000\u0873\u0875\u00036\u001b\u0000\u0874\u0870\u0001\u0000\u0000\u0000"+
		"\u0874\u0875\u0001\u0000\u0000\u0000\u0875\u00b7\u0001\u0000\u0000\u0000"+
		"\u0876\u0879\u0003\u00b2Y\u0000\u0877\u0879\u0003\u00b6[\u0000\u0878\u0876"+
		"\u0001\u0000\u0000\u0000\u0878\u0877\u0001\u0000\u0000\u0000\u0879\u00b9"+
		"\u0001\u0000\u0000\u0000\u087a\u087b\u0005A\u0000\u0000\u087b\u00bb\u0001"+
		"\u0000\u0000\u0000\u087c\u088d\u0005B\u0000\u0000\u087d\u0881\u0005+\u0000"+
		"\u0000\u087e\u0880\u0005\u0004\u0000\u0000\u087f\u087e\u0001\u0000\u0000"+
		"\u0000\u0880\u0883\u0001\u0000\u0000\u0000\u0881\u087f\u0001\u0000\u0000"+
		"\u0000\u0881\u0882\u0001\u0000\u0000\u0000\u0882\u0884\u0001\u0000\u0000"+
		"\u0000\u0883\u0881\u0001\u0000\u0000\u0000\u0884\u0888\u0003N\'\u0000"+
		"\u0885\u0887\u0005\u0004\u0000\u0000\u0886\u0885\u0001\u0000\u0000\u0000"+
		"\u0887\u088a\u0001\u0000\u0000\u0000\u0888\u0886\u0001\u0000\u0000\u0000"+
		"\u0888\u0889\u0001\u0000\u0000\u0000\u0889\u088b\u0001\u0000\u0000\u0000"+
		"\u088a\u0888\u0001\u0000\u0000\u0000\u088b\u088c\u0005,\u0000\u0000\u088c"+
		"\u088e\u0001\u0000\u0000\u0000\u088d\u087d\u0001\u0000\u0000\u0000\u088d"+
		"\u088e\u0001\u0000\u0000\u0000\u088e\u00bd\u0001\u0000\u0000\u0000\u088f"+
		"\u0893\u0005E\u0000\u0000\u0890\u0892\u0005\u0004\u0000\u0000\u0891\u0890"+
		"\u0001\u0000\u0000\u0000\u0892\u0895\u0001\u0000\u0000\u0000\u0893\u0891"+
		"\u0001\u0000\u0000\u0000\u0893\u0894\u0001\u0000\u0000\u0000\u0894\u0896"+
		"\u0001\u0000\u0000\u0000\u0895\u0893\u0001\u0000\u0000\u0000\u0896\u089a"+
		"\u0005\b\u0000\u0000\u0897\u0899\u0005\u0004\u0000\u0000\u0898\u0897\u0001"+
		"\u0000\u0000\u0000\u0899\u089c\u0001\u0000\u0000\u0000\u089a\u0898\u0001"+
		"\u0000\u0000\u0000\u089a\u089b\u0001\u0000\u0000\u0000\u089b\u089d\u0001"+
		"\u0000\u0000\u0000\u089c\u089a\u0001\u0000\u0000\u0000\u089d\u08a1\u0003"+
		"~?\u0000\u089e\u08a0\u0005\u0004\u0000\u0000\u089f\u089e\u0001\u0000\u0000"+
		"\u0000\u08a0\u08a3\u0001\u0000\u0000\u0000\u08a1\u089f\u0001\u0000\u0000"+
		"\u0000\u08a1\u08a2\u0001\u0000\u0000\u0000\u08a2\u08a4\u0001\u0000\u0000"+
		"\u0000\u08a3\u08a1\u0001\u0000\u0000\u0000\u08a4\u08a8\u0005\t\u0000\u0000"+
		"\u08a5\u08a7\u0005\u0004\u0000\u0000\u08a6\u08a5\u0001\u0000\u0000\u0000"+
		"\u08a7\u08aa\u0001\u0000\u0000\u0000\u08a8\u08a6\u0001\u0000\u0000\u0000"+
		"\u08a8\u08a9\u0001\u0000\u0000\u0000\u08a9\u08ca\u0001\u0000\u0000\u0000"+
		"\u08aa\u08a8\u0001\u0000\u0000\u0000\u08ab\u08cb\u0003z=\u0000\u08ac\u08ae"+
		"\u0003z=\u0000\u08ad\u08ac\u0001\u0000\u0000\u0000\u08ad\u08ae\u0001\u0000"+
		"\u0000\u0000\u08ae\u08b2\u0001\u0000\u0000\u0000\u08af\u08b1\u0005\u0004"+
		"\u0000\u0000\u08b0\u08af\u0001\u0000\u0000\u0000\u08b1\u08b4\u0001\u0000"+
		"\u0000\u0000\u08b2\u08b0\u0001\u0000\u0000\u0000\u08b2\u08b3\u0001\u0000"+
		"\u0000\u0000\u08b3\u08b6\u0001\u0000\u0000\u0000\u08b4\u08b2\u0001\u0000"+
		"\u0000\u0000\u08b5\u08b7\u0005\u001a\u0000\u0000\u08b6\u08b5\u0001\u0000"+
		"\u0000\u0000\u08b6\u08b7\u0001\u0000\u0000\u0000\u08b7\u08bb\u0001\u0000"+
		"\u0000\u0000\u08b8\u08ba\u0005\u0004\u0000\u0000\u08b9\u08b8\u0001\u0000"+
		"\u0000\u0000\u08ba\u08bd\u0001\u0000\u0000\u0000\u08bb\u08b9\u0001\u0000"+
		"\u0000\u0000\u08bb\u08bc\u0001\u0000\u0000\u0000\u08bc\u08be\u0001\u0000"+
		"\u0000\u0000\u08bd\u08bb\u0001\u0000\u0000\u0000\u08be\u08c2\u0005F\u0000"+
		"\u0000\u08bf\u08c1\u0005\u0004\u0000\u0000\u08c0\u08bf\u0001\u0000\u0000"+
		"\u0000\u08c1\u08c4\u0001\u0000\u0000\u0000\u08c2\u08c0\u0001\u0000\u0000"+
		"\u0000\u08c2\u08c3\u0001\u0000\u0000\u0000\u08c3\u08c7\u0001\u0000\u0000"+
		"\u0000\u08c4\u08c2\u0001\u0000\u0000\u0000\u08c5\u08c8\u0003z=\u0000\u08c6"+
		"\u08c8\u0005\u001a\u0000\u0000\u08c7\u08c5\u0001\u0000\u0000\u0000\u08c7"+
		"\u08c6\u0001\u0000\u0000\u0000\u08c8\u08cb\u0001\u0000\u0000\u0000\u08c9"+
		"\u08cb\u0005\u001a\u0000\u0000\u08ca\u08ab\u0001\u0000\u0000\u0000\u08ca"+
		"\u08ad\u0001\u0000\u0000\u0000\u08ca\u08c9\u0001\u0000\u0000\u0000\u08cb"+
		"\u00bf\u0001\u0000\u0000\u0000\u08cc\u08ee\u0005\b\u0000\u0000\u08cd\u08cf"+
		"\u0003\u011c\u008e\u0000\u08ce\u08cd\u0001\u0000\u0000\u0000\u08cf\u08d2"+
		"\u0001\u0000\u0000\u0000\u08d0\u08ce\u0001\u0000\u0000\u0000\u08d0\u08d1"+
		"\u0001\u0000\u0000\u0000\u08d1\u08d6\u0001\u0000\u0000\u0000\u08d2\u08d0"+
		"\u0001\u0000\u0000\u0000\u08d3\u08d5\u0005\u0004\u0000\u0000\u08d4\u08d3"+
		"\u0001\u0000\u0000\u0000\u08d5";
	private static final String _serializedATNSegment1 =
		"\u08d8\u0001\u0000\u0000\u0000\u08d6\u08d4\u0001\u0000\u0000\u0000\u08d6"+
		"\u08d7\u0001\u0000\u0000\u0000\u08d7\u08d9\u0001\u0000\u0000\u0000\u08d8"+
		"\u08d6\u0001\u0000\u0000\u0000\u08d9\u08dd\u0005<\u0000\u0000\u08da\u08dc"+
		"\u0005\u0004\u0000\u0000\u08db\u08da\u0001\u0000\u0000\u0000\u08dc\u08df"+
		"\u0001\u0000\u0000\u0000\u08dd\u08db\u0001\u0000\u0000\u0000\u08dd\u08de"+
		"\u0001\u0000\u0000\u0000\u08de\u08e0\u0001\u0000\u0000\u0000\u08df\u08dd"+
		"\u0001\u0000\u0000\u0000\u08e0\u08e4\u0003:\u001d\u0000\u08e1\u08e3\u0005"+
		"\u0004\u0000\u0000\u08e2\u08e1\u0001\u0000\u0000\u0000\u08e3\u08e6\u0001"+
		"\u0000\u0000\u0000\u08e4\u08e2\u0001\u0000\u0000\u0000\u08e4\u08e5\u0001"+
		"\u0000\u0000\u0000\u08e5\u08e7\u0001\u0000\u0000\u0000\u08e6\u08e4\u0001"+
		"\u0000\u0000\u0000\u08e7\u08eb\u0005\u001b\u0000\u0000\u08e8\u08ea\u0005"+
		"\u0004\u0000\u0000\u08e9\u08e8\u0001\u0000\u0000\u0000\u08ea\u08ed\u0001"+
		"\u0000\u0000\u0000\u08eb\u08e9\u0001\u0000\u0000\u0000\u08eb\u08ec\u0001"+
		"\u0000\u0000\u0000\u08ec\u08ef\u0001\u0000\u0000\u0000\u08ed\u08eb\u0001"+
		"\u0000\u0000\u0000\u08ee\u08d0\u0001\u0000\u0000\u0000\u08ee\u08ef\u0001"+
		"\u0000\u0000\u0000\u08ef\u08f0\u0001\u0000\u0000\u0000\u08f0\u08f1\u0003"+
		"~?\u0000\u08f1\u08f2\u0005\t\u0000\u0000\u08f2\u00c1\u0001\u0000\u0000"+
		"\u0000\u08f3\u08f7\u0005G\u0000\u0000\u08f4\u08f6\u0005\u0004\u0000\u0000"+
		"\u08f5\u08f4\u0001\u0000\u0000\u0000\u08f6\u08f9\u0001\u0000\u0000\u0000"+
		"\u08f7\u08f5\u0001\u0000\u0000\u0000\u08f7\u08f8\u0001\u0000\u0000\u0000"+
		"\u08f8\u08fb\u0001\u0000\u0000\u0000\u08f9\u08f7\u0001\u0000\u0000\u0000"+
		"\u08fa\u08fc\u0003\u00c0`\u0000\u08fb\u08fa\u0001\u0000\u0000\u0000\u08fb"+
		"\u08fc\u0001\u0000\u0000\u0000\u08fc\u0900\u0001\u0000\u0000\u0000\u08fd"+
		"\u08ff\u0005\u0004\u0000\u0000\u08fe\u08fd\u0001\u0000\u0000\u0000\u08ff"+
		"\u0902\u0001\u0000\u0000\u0000\u0900\u08fe\u0001\u0000\u0000\u0000\u0900"+
		"\u0901\u0001\u0000\u0000\u0000\u0901\u0903\u0001\u0000\u0000\u0000\u0902"+
		"\u0900\u0001\u0000\u0000\u0000\u0903\u0907\u0005\f\u0000\u0000\u0904\u0906"+
		"\u0005\u0004\u0000\u0000\u0905\u0904\u0001\u0000\u0000\u0000\u0906\u0909"+
		"\u0001\u0000\u0000\u0000\u0907\u0905\u0001\u0000\u0000\u0000\u0907\u0908"+
		"\u0001\u0000\u0000\u0000\u0908\u0913\u0001\u0000\u0000\u0000\u0909\u0907"+
		"\u0001\u0000\u0000\u0000\u090a\u090e\u0003\u00c4b\u0000\u090b\u090d\u0005"+
		"\u0004\u0000\u0000\u090c\u090b\u0001\u0000\u0000\u0000\u090d\u0910\u0001"+
		"\u0000\u0000\u0000\u090e\u090c\u0001\u0000\u0000\u0000\u090e\u090f\u0001"+
		"\u0000\u0000\u0000\u090f\u0912\u0001\u0000\u0000\u0000\u0910\u090e\u0001"+
		"\u0000\u0000\u0000\u0911\u090a\u0001\u0000\u0000\u0000\u0912\u0915\u0001"+
		"\u0000\u0000\u0000\u0913\u0911\u0001\u0000\u0000\u0000\u0913\u0914\u0001"+
		"\u0000\u0000\u0000\u0914\u0919\u0001\u0000\u0000\u0000\u0915\u0913\u0001"+
		"\u0000\u0000\u0000\u0916\u0918\u0005\u0004\u0000\u0000\u0917\u0916\u0001"+
		"\u0000\u0000\u0000\u0918\u091b\u0001\u0000\u0000\u0000\u0919\u0917\u0001"+
		"\u0000\u0000\u0000\u0919\u091a\u0001\u0000\u0000\u0000\u091a\u091c\u0001"+
		"\u0000\u0000\u0000\u091b\u0919\u0001\u0000\u0000\u0000\u091c\u091d\u0005"+
		"\r\u0000\u0000\u091d\u00c3\u0001\u0000\u0000\u0000\u091e\u092f\u0003\u00c6"+
		"c\u0000\u091f\u0921\u0005\u0004\u0000\u0000\u0920\u091f\u0001\u0000\u0000"+
		"\u0000\u0921\u0924\u0001\u0000\u0000\u0000\u0922\u0920\u0001\u0000\u0000"+
		"\u0000\u0922\u0923\u0001\u0000\u0000\u0000\u0923\u0925\u0001\u0000\u0000"+
		"\u0000\u0924\u0922\u0001\u0000\u0000\u0000\u0925\u0929\u0005\u0007\u0000"+
		"\u0000\u0926\u0928\u0005\u0004\u0000\u0000\u0927\u0926\u0001\u0000\u0000"+
		"\u0000\u0928\u092b\u0001\u0000\u0000\u0000\u0929\u0927\u0001\u0000\u0000"+
		"\u0000\u0929\u092a\u0001\u0000\u0000\u0000\u092a\u092c\u0001\u0000\u0000"+
		"\u0000\u092b\u0929\u0001\u0000\u0000\u0000\u092c\u092e\u0003\u00c6c\u0000"+
		"\u092d\u0922\u0001\u0000\u0000\u0000\u092e\u0931\u0001\u0000\u0000\u0000"+
		"\u092f\u092d\u0001\u0000\u0000\u0000\u092f\u0930\u0001\u0000\u0000\u0000"+
		"\u0930\u0939\u0001\u0000\u0000\u0000\u0931\u092f\u0001\u0000\u0000\u0000"+
		"\u0932\u0934\u0005\u0004\u0000\u0000\u0933\u0932\u0001\u0000\u0000\u0000"+
		"\u0934\u0937\u0001\u0000\u0000\u0000\u0935\u0933\u0001\u0000\u0000\u0000"+
		"\u0935\u0936\u0001\u0000\u0000\u0000\u0936\u0938\u0001\u0000\u0000\u0000"+
		"\u0937\u0935\u0001\u0000\u0000\u0000\u0938\u093a\u0005\u0007\u0000\u0000"+
		"\u0939\u0935\u0001\u0000\u0000\u0000\u0939\u093a\u0001\u0000\u0000\u0000"+
		"\u093a\u093e\u0001\u0000\u0000\u0000\u093b\u093d\u0005\u0004\u0000\u0000"+
		"\u093c\u093b\u0001\u0000\u0000\u0000\u093d\u0940\u0001\u0000\u0000\u0000"+
		"\u093e\u093c\u0001\u0000\u0000\u0000\u093e\u093f\u0001\u0000\u0000\u0000"+
		"\u093f\u0941\u0001\u0000\u0000\u0000\u0940\u093e\u0001\u0000\u0000\u0000"+
		"\u0941\u0945\u0005!\u0000\u0000\u0942\u0944\u0005\u0004\u0000\u0000\u0943"+
		"\u0942\u0001\u0000\u0000\u0000\u0944\u0947\u0001\u0000\u0000\u0000\u0945"+
		"\u0943\u0001\u0000\u0000\u0000\u0945\u0946\u0001\u0000\u0000\u0000\u0946"+
		"\u0948\u0001\u0000\u0000\u0000\u0947\u0945\u0001\u0000\u0000\u0000\u0948"+
		"\u094a\u0003z=\u0000\u0949\u094b\u0003\u0128\u0094\u0000\u094a\u0949\u0001"+
		"\u0000\u0000\u0000\u094a\u094b\u0001\u0000\u0000\u0000\u094b\u095f\u0001"+
		"\u0000\u0000\u0000\u094c\u0950\u0005F\u0000\u0000\u094d\u094f\u0005\u0004"+
		"\u0000\u0000\u094e\u094d\u0001\u0000\u0000\u0000\u094f\u0952\u0001\u0000"+
		"\u0000\u0000\u0950\u094e\u0001\u0000\u0000\u0000\u0950\u0951\u0001\u0000"+
		"\u0000\u0000\u0951\u0953\u0001\u0000\u0000\u0000\u0952\u0950\u0001\u0000"+
		"\u0000\u0000\u0953\u0957\u0005!\u0000\u0000\u0954\u0956\u0005\u0004\u0000"+
		"\u0000\u0955\u0954\u0001\u0000\u0000\u0000\u0956\u0959\u0001\u0000\u0000"+
		"\u0000\u0957\u0955\u0001\u0000\u0000\u0000\u0957\u0958\u0001\u0000\u0000"+
		"\u0000\u0958\u095a\u0001\u0000\u0000\u0000\u0959\u0957\u0001\u0000\u0000"+
		"\u0000\u095a\u095c\u0003z=\u0000\u095b\u095d\u0003\u0128\u0094\u0000\u095c"+
		"\u095b\u0001\u0000\u0000\u0000\u095c\u095d\u0001\u0000\u0000\u0000\u095d"+
		"\u095f\u0001\u0000\u0000\u0000\u095e\u091e\u0001\u0000\u0000\u0000\u095e"+
		"\u094c\u0001\u0000\u0000\u0000\u095f\u00c5\u0001\u0000\u0000\u0000\u0960"+
		"\u0963\u0003~?\u0000\u0961\u0963\u0003\u00c8d\u0000\u0962\u0960\u0001"+
		"\u0000\u0000\u0000\u0962\u0961\u0001\u0000\u0000\u0000\u0963\u00c7\u0001"+
		"\u0000\u0000\u0000\u0964\u0968\u0003\u00f4z\u0000\u0965\u0967\u0005\u0004"+
		"\u0000\u0000\u0966\u0965\u0001\u0000\u0000\u0000\u0967\u096a\u0001\u0000"+
		"\u0000\u0000\u0968\u0966\u0001\u0000\u0000\u0000\u0968\u0969\u0001\u0000"+
		"\u0000\u0000\u0969\u096b\u0001\u0000\u0000\u0000\u096a\u0968\u0001\u0000"+
		"\u0000\u0000\u096b\u096c\u0003N\'\u0000\u096c\u00c9\u0001\u0000\u0000"+
		"\u0000\u096d\u0971\u0005H\u0000\u0000\u096e\u0970\u0005\u0004\u0000\u0000"+
		"\u096f\u096e\u0001\u0000\u0000\u0000\u0970\u0973\u0001\u0000\u0000\u0000"+
		"\u0971\u096f\u0001\u0000\u0000\u0000\u0971\u0972\u0001\u0000\u0000\u0000"+
		"\u0972\u0974\u0001\u0000\u0000\u0000\u0973\u0971\u0001\u0000\u0000\u0000"+
		"\u0974\u0990\u0003|>\u0000\u0975\u0977\u0005\u0004\u0000\u0000\u0976\u0975"+
		"\u0001\u0000\u0000\u0000\u0977\u097a\u0001\u0000\u0000\u0000\u0978\u0976"+
		"\u0001\u0000\u0000\u0000\u0978\u0979\u0001\u0000\u0000\u0000\u0979\u097b"+
		"\u0001\u0000\u0000\u0000\u097a\u0978\u0001\u0000\u0000\u0000\u097b\u097d"+
		"\u0003\u00ccf\u0000\u097c\u0978\u0001\u0000\u0000\u0000\u097d\u097e\u0001"+
		"\u0000\u0000\u0000\u097e\u097c\u0001\u0000\u0000\u0000\u097e\u097f\u0001"+
		"\u0000\u0000\u0000\u097f\u0987\u0001\u0000\u0000\u0000\u0980\u0982\u0005"+
		"\u0004\u0000\u0000\u0981\u0980\u0001\u0000\u0000\u0000\u0982\u0985\u0001"+
		"\u0000\u0000\u0000\u0983\u0981\u0001\u0000\u0000\u0000\u0983\u0984\u0001"+
		"\u0000\u0000\u0000\u0984\u0986\u0001\u0000\u0000\u0000\u0985\u0983\u0001"+
		"\u0000\u0000\u0000\u0986\u0988\u0003\u00ceg\u0000\u0987\u0983\u0001\u0000"+
		"\u0000\u0000\u0987\u0988\u0001\u0000\u0000\u0000\u0988\u0991\u0001\u0000"+
		"\u0000\u0000\u0989\u098b\u0005\u0004\u0000\u0000\u098a\u0989\u0001\u0000"+
		"\u0000\u0000\u098b\u098e\u0001\u0000\u0000\u0000\u098c\u098a\u0001\u0000"+
		"\u0000\u0000\u098c\u098d\u0001\u0000\u0000\u0000\u098d\u098f\u0001\u0000"+
		"\u0000\u0000\u098e\u098c\u0001\u0000\u0000\u0000\u098f\u0991\u0003\u00ce"+
		"g\u0000\u0990\u097c\u0001\u0000\u0000\u0000\u0990\u098c\u0001\u0000\u0000"+
		"\u0000\u0991\u00cb\u0001\u0000\u0000\u0000\u0992\u0996\u0005I\u0000\u0000"+
		"\u0993\u0995\u0005\u0004\u0000\u0000\u0994\u0993\u0001\u0000\u0000\u0000"+
		"\u0995\u0998\u0001\u0000\u0000\u0000\u0996\u0994\u0001\u0000\u0000\u0000"+
		"\u0996\u0997\u0001\u0000\u0000\u0000\u0997\u0999\u0001\u0000\u0000\u0000"+
		"\u0998\u0996\u0001\u0000\u0000\u0000\u0999\u099d\u0005\b\u0000\u0000\u099a"+
		"\u099c\u0003\u011c\u008e\u0000\u099b\u099a\u0001\u0000\u0000\u0000\u099c"+
		"\u099f\u0001\u0000\u0000\u0000\u099d\u099b\u0001\u0000\u0000\u0000\u099d"+
		"\u099e\u0001\u0000\u0000\u0000\u099e\u09a0\u0001\u0000\u0000\u0000\u099f"+
		"\u099d\u0001\u0000\u0000\u0000\u09a0\u09a1\u0003\u0124\u0092\u0000\u09a1"+
		"\u09a2\u0005\u0019\u0000\u0000\u09a2\u09aa\u0003N\'\u0000\u09a3\u09a5"+
		"\u0005\u0004\u0000\u0000\u09a4\u09a3\u0001\u0000\u0000\u0000\u09a5\u09a8"+
		"\u0001\u0000\u0000\u0000\u09a6\u09a4\u0001\u0000\u0000\u0000\u09a6\u09a7"+
		"\u0001\u0000\u0000\u0000\u09a7\u09a9\u0001\u0000\u0000\u0000\u09a8\u09a6"+
		"\u0001\u0000\u0000\u0000\u09a9\u09ab\u0005\u0007\u0000\u0000\u09aa\u09a6"+
		"\u0001\u0000\u0000\u0000\u09aa\u09ab\u0001\u0000\u0000\u0000\u09ab\u09ac"+
		"\u0001\u0000\u0000\u0000\u09ac\u09b0\u0005\t\u0000\u0000\u09ad\u09af\u0005"+
		"\u0004\u0000\u0000\u09ae\u09ad\u0001\u0000\u0000\u0000\u09af\u09b2\u0001"+
		"\u0000\u0000\u0000\u09b0\u09ae\u0001\u0000\u0000\u0000\u09b0\u09b1\u0001"+
		"\u0000\u0000\u0000\u09b1\u09b3\u0001\u0000\u0000\u0000\u09b2\u09b0\u0001"+
		"\u0000\u0000\u0000\u09b3\u09b4\u0003|>\u0000\u09b4\u00cd\u0001\u0000\u0000"+
		"\u0000\u09b5\u09b9\u0005J\u0000\u0000\u09b6\u09b8\u0005\u0004\u0000\u0000"+
		"\u09b7\u09b6\u0001\u0000\u0000\u0000\u09b8\u09bb\u0001\u0000\u0000\u0000"+
		"\u09b9\u09b7\u0001\u0000\u0000\u0000\u09b9\u09ba\u0001\u0000\u0000\u0000"+
		"\u09ba\u09bc\u0001\u0000\u0000\u0000\u09bb\u09b9\u0001\u0000\u0000\u0000"+
		"\u09bc\u09bd\u0003|>\u0000\u09bd\u00cf\u0001\u0000\u0000\u0000\u09be\u09c2"+
		"\u0005M\u0000\u0000\u09bf\u09c1\u0005\u0004\u0000\u0000\u09c0\u09bf\u0001"+
		"\u0000\u0000\u0000\u09c1\u09c4\u0001\u0000\u0000\u0000\u09c2\u09c0\u0001"+
		"\u0000\u0000\u0000\u09c2\u09c3\u0001\u0000\u0000\u0000\u09c3\u09c5\u0001"+
		"\u0000\u0000\u0000\u09c4\u09c2\u0001\u0000\u0000\u0000\u09c5\u09cc\u0003"+
		"~?\u0000\u09c6\u09c8\u0005N\u0000\u0000\u09c7\u09c9\u0003~?\u0000\u09c8"+
		"\u09c7\u0001\u0000\u0000\u0000\u09c8\u09c9\u0001\u0000\u0000\u0000\u09c9"+
		"\u09cc\u0001\u0000\u0000\u0000\u09ca\u09cc\u0005O\u0000\u0000\u09cb\u09be"+
		"\u0001\u0000\u0000\u0000\u09cb\u09c6\u0001\u0000\u0000\u0000\u09cb\u09ca"+
		"\u0001\u0000\u0000\u0000\u09cc\u00d1\u0001\u0000\u0000\u0000\u09cd\u09cf"+
		"\u0003d2\u0000\u09ce\u09cd\u0001\u0000\u0000\u0000\u09ce\u09cf\u0001\u0000"+
		"\u0000\u0000\u09cf\u09d0\u0001\u0000\u0000\u0000\u09d0\u09d4\u0005\"\u0000"+
		"\u0000\u09d1\u09d3\u0005\u0004\u0000\u0000\u09d2\u09d1\u0001\u0000\u0000"+
		"\u0000\u09d3\u09d6\u0001\u0000\u0000\u0000\u09d4\u09d2\u0001\u0000\u0000"+
		"\u0000\u09d4\u09d5\u0001\u0000\u0000\u0000\u09d5\u09d9\u0001\u0000\u0000"+
		"\u0000\u09d6\u09d4\u0001\u0000\u0000\u0000\u09d7\u09da\u0003\u0124\u0092"+
		"\u0000\u09d8\u09da\u00059\u0000\u0000\u09d9\u09d7\u0001\u0000\u0000\u0000"+
		"\u09d9\u09d8\u0001\u0000\u0000\u0000\u09da\u00d3\u0001\u0000\u0000\u0000"+
		"\u09db\u09e1\u0003\u00fe\u007f\u0000\u09dc\u09e1\u0003\u00e8t\u0000\u09dd"+
		"\u09e1\u0003\u00e4r\u0000\u09de\u09e1\u0003\u00e0p\u0000\u09df\u09e1\u0003"+
		"\u00e2q\u0000\u09e0\u09db\u0001\u0000\u0000\u0000\u09e0\u09dc\u0001\u0000"+
		"\u0000\u0000\u09e0\u09dd\u0001\u0000\u0000\u0000\u09e0\u09de\u0001\u0000"+
		"\u0000\u0000\u09e0\u09df\u0001\u0000\u0000\u0000\u09e1\u00d5\u0001\u0000"+
		"\u0000\u0000\u09e2\u09e3\u0003\u009aM\u0000\u09e3\u09e4\u0003\u00deo\u0000"+
		"\u09e4\u09e8\u0001\u0000\u0000\u0000\u09e5\u09e8\u0003\u0124\u0092\u0000"+
		"\u09e6\u09e8\u0003\u00d8l\u0000\u09e7\u09e2\u0001\u0000\u0000\u0000\u09e7"+
		"\u09e5\u0001\u0000\u0000\u0000\u09e7\u09e6\u0001\u0000\u0000\u0000\u09e8"+
		"\u00d7\u0001\u0000\u0000\u0000\u09e9\u09ed\u0005\b\u0000\u0000\u09ea\u09ec"+
		"\u0005\u0004\u0000\u0000\u09eb\u09ea\u0001\u0000\u0000\u0000\u09ec\u09ef"+
		"\u0001\u0000\u0000\u0000\u09ed\u09eb\u0001\u0000\u0000\u0000\u09ed\u09ee"+
		"\u0001\u0000\u0000\u0000\u09ee\u09f0\u0001\u0000\u0000\u0000\u09ef\u09ed"+
		"\u0001\u0000\u0000\u0000\u09f0\u09f4\u0003\u00d6k\u0000\u09f1\u09f3\u0005"+
		"\u0004\u0000\u0000\u09f2\u09f1\u0001\u0000\u0000\u0000\u09f3\u09f6\u0001"+
		"\u0000\u0000\u0000\u09f4\u09f2\u0001\u0000\u0000\u0000\u09f4\u09f5\u0001"+
		"\u0000\u0000\u0000\u09f5\u09f7\u0001\u0000\u0000\u0000\u09f6\u09f4\u0001"+
		"\u0000\u0000\u0000\u09f7\u09f8\u0005\t\u0000\u0000\u09f8\u00d9\u0001\u0000"+
		"\u0000\u0000\u09f9\u09fc\u0003\u0096K\u0000\u09fa\u09fc\u0003\u00dcn\u0000"+
		"\u09fb\u09f9\u0001\u0000\u0000\u0000\u09fb\u09fa\u0001\u0000\u0000\u0000"+
		"\u09fc\u00db\u0001\u0000\u0000\u0000\u09fd\u0a01\u0005\b\u0000\u0000\u09fe"+
		"\u0a00\u0005\u0004\u0000\u0000\u09ff\u09fe\u0001\u0000\u0000\u0000\u0a00"+
		"\u0a03\u0001\u0000\u0000\u0000\u0a01\u09ff\u0001\u0000\u0000\u0000\u0a01"+
		"\u0a02\u0001\u0000\u0000\u0000\u0a02\u0a04\u0001\u0000\u0000\u0000\u0a03"+
		"\u0a01\u0001\u0000\u0000\u0000\u0a04\u0a08\u0003\u00dam\u0000\u0a05\u0a07"+
		"\u0005\u0004\u0000\u0000\u0a06\u0a05\u0001\u0000\u0000\u0000\u0a07\u0a0a"+
		"\u0001\u0000\u0000\u0000\u0a08\u0a06\u0001\u0000\u0000\u0000\u0a08\u0a09"+
		"\u0001\u0000\u0000\u0000\u0a09\u0a0b\u0001\u0000\u0000\u0000\u0a0a\u0a08"+
		"\u0001\u0000\u0000\u0000\u0a0b\u0a0c\u0005\t\u0000\u0000\u0a0c\u00dd\u0001"+
		"\u0000\u0000\u0000\u0a0d\u0a11\u0003\u00e8t\u0000\u0a0e\u0a11\u0003\u00e0"+
		"p\u0000\u0a0f\u0a11\u0003\u00e2q\u0000\u0a10\u0a0d\u0001\u0000\u0000\u0000"+
		"\u0a10\u0a0e\u0001\u0000\u0000\u0000\u0a10\u0a0f\u0001\u0000\u0000\u0000"+
		"\u0a11\u00df\u0001\u0000\u0000\u0000\u0a12\u0a16\u0005\n\u0000\u0000\u0a13"+
		"\u0a15\u0005\u0004\u0000\u0000\u0a14\u0a13\u0001\u0000\u0000\u0000\u0a15"+
		"\u0a18\u0001\u0000\u0000\u0000\u0a16\u0a14\u0001\u0000\u0000\u0000\u0a16"+
		"\u0a17\u0001\u0000\u0000\u0000\u0a17\u0a19\u0001\u0000\u0000\u0000\u0a18"+
		"\u0a16\u0001\u0000\u0000\u0000\u0a19\u0a2a\u0003~?\u0000\u0a1a\u0a1c\u0005"+
		"\u0004\u0000\u0000\u0a1b\u0a1a\u0001\u0000\u0000\u0000\u0a1c\u0a1f\u0001"+
		"\u0000\u0000\u0000\u0a1d\u0a1b\u0001\u0000\u0000\u0000\u0a1d\u0a1e\u0001"+
		"\u0000\u0000\u0000\u0a1e\u0a20\u0001\u0000\u0000\u0000\u0a1f\u0a1d\u0001"+
		"\u0000\u0000\u0000\u0a20\u0a24\u0005\u0007\u0000\u0000\u0a21\u0a23\u0005"+
		"\u0004\u0000\u0000\u0a22\u0a21\u0001\u0000\u0000\u0000\u0a23\u0a26\u0001"+
		"\u0000\u0000\u0000\u0a24\u0a22\u0001\u0000\u0000\u0000\u0a24\u0a25\u0001"+
		"\u0000\u0000\u0000\u0a25\u0a27\u0001\u0000\u0000\u0000\u0a26\u0a24\u0001"+
		"\u0000\u0000\u0000\u0a27\u0a29\u0003~?\u0000\u0a28\u0a1d\u0001\u0000\u0000"+
		"\u0000\u0a29\u0a2c\u0001\u0000\u0000\u0000\u0a2a\u0a28\u0001\u0000\u0000"+
		"\u0000\u0a2a\u0a2b\u0001\u0000\u0000\u0000\u0a2b\u0a34\u0001\u0000\u0000"+
		"\u0000\u0a2c\u0a2a\u0001\u0000\u0000\u0000\u0a2d\u0a2f\u0005\u0004\u0000"+
		"\u0000\u0a2e\u0a2d\u0001\u0000\u0000\u0000\u0a2f\u0a32\u0001\u0000\u0000"+
		"\u0000\u0a30\u0a2e\u0001\u0000\u0000\u0000\u0a30\u0a31\u0001\u0000\u0000"+
		"\u0000\u0a31\u0a33\u0001\u0000\u0000\u0000\u0a32\u0a30\u0001\u0000\u0000"+
		"\u0000\u0a33\u0a35\u0005\u0007\u0000\u0000\u0a34\u0a30\u0001\u0000\u0000"+
		"\u0000\u0a34\u0a35\u0001\u0000\u0000\u0000\u0a35\u0a39\u0001\u0000\u0000"+
		"\u0000\u0a36\u0a38\u0005\u0004\u0000\u0000\u0a37\u0a36\u0001\u0000\u0000"+
		"\u0000\u0a38\u0a3b\u0001\u0000\u0000\u0000\u0a39\u0a37\u0001\u0000\u0000"+
		"\u0000\u0a39\u0a3a\u0001\u0000\u0000\u0000\u0a3a\u0a3c\u0001\u0000\u0000"+
		"\u0000\u0a3b\u0a39\u0001\u0000\u0000\u0000\u0a3c\u0a3d\u0005\u000b\u0000"+
		"\u0000\u0a3d\u00e1\u0001\u0000\u0000\u0000\u0a3e\u0a42\u0003\u0102\u0081"+
		"\u0000\u0a3f\u0a41\u0005\u0004\u0000\u0000\u0a40\u0a3f\u0001\u0000\u0000"+
		"\u0000\u0a41\u0a44\u0001\u0000\u0000\u0000\u0a42\u0a40\u0001\u0000\u0000"+
		"\u0000\u0a42\u0a43\u0001\u0000\u0000\u0000\u0a43\u0a48\u0001\u0000\u0000"+
		"\u0000\u0a44\u0a42\u0001\u0000\u0000\u0000\u0a45\u0a49\u0003\u0124\u0092"+
		"\u0000\u0a46\u0a49\u0003\u009eO\u0000\u0a47\u0a49\u00059\u0000\u0000\u0a48"+
		"\u0a45\u0001\u0000\u0000\u0000\u0a48\u0a46\u0001\u0000\u0000\u0000\u0a48"+
		"\u0a47\u0001\u0000\u0000\u0000\u0a49\u00e3\u0001\u0000\u0000\u0000\u0a4a"+
		"\u0a4c\u0003\u00e8t\u0000\u0a4b\u0a4a\u0001\u0000\u0000\u0000\u0a4b\u0a4c"+
		"\u0001\u0000\u0000\u0000\u0a4c\u0a52\u0001\u0000\u0000\u0000\u0a4d\u0a4f"+
		"\u0003\u00eau\u0000\u0a4e\u0a4d\u0001\u0000\u0000\u0000\u0a4e\u0a4f\u0001"+
		"\u0000\u0000\u0000\u0a4f\u0a50\u0001\u0000\u0000\u0000\u0a50\u0a53\u0003"+
		"\u00e6s\u0000\u0a51\u0a53\u0003\u00eau\u0000\u0a52\u0a4e\u0001\u0000\u0000"+
		"\u0000\u0a52\u0a51\u0001\u0000\u0000\u0000\u0a53\u00e5\u0001\u0000\u0000"+
		"\u0000\u0a54\u0a56\u0003\u011c\u008e\u0000\u0a55\u0a54\u0001\u0000\u0000"+
		"\u0000\u0a56\u0a59\u0001\u0000\u0000\u0000\u0a57\u0a55\u0001\u0000\u0000"+
		"\u0000\u0a57\u0a58\u0001\u0000\u0000\u0000\u0a58\u0a5b\u0001\u0000\u0000"+
		"\u0000\u0a59\u0a57\u0001\u0000\u0000\u0000\u0a5a\u0a5c\u0003p8\u0000\u0a5b"+
		"\u0a5a\u0001\u0000\u0000\u0000\u0a5b\u0a5c\u0001\u0000\u0000\u0000\u0a5c"+
		"\u0a60\u0001\u0000\u0000\u0000\u0a5d\u0a5f\u0005\u0004\u0000\u0000\u0a5e"+
		"\u0a5d\u0001\u0000\u0000\u0000\u0a5f\u0a62\u0001\u0000\u0000\u0000\u0a60"+
		"\u0a5e\u0001\u0000\u0000\u0000\u0a60\u0a61\u0001\u0000\u0000\u0000\u0a61"+
		"\u0a63\u0001\u0000\u0000\u0000\u0a62\u0a60\u0001\u0000\u0000\u0000\u0a63"+
		"\u0a64\u0003\u00b2Y\u0000\u0a64\u00e7\u0001\u0000\u0000\u0000\u0a65\u0a69"+
		"\u0005+\u0000\u0000\u0a66\u0a68\u0005\u0004\u0000\u0000\u0a67\u0a66\u0001"+
		"\u0000\u0000\u0000\u0a68\u0a6b\u0001\u0000\u0000\u0000\u0a69\u0a67\u0001"+
		"\u0000\u0000\u0000\u0a69\u0a6a\u0001\u0000\u0000\u0000\u0a6a\u0a6c\u0001"+
		"\u0000\u0000\u0000\u0a6b\u0a69\u0001\u0000\u0000\u0000\u0a6c\u0a7d\u0003"+
		"X,\u0000\u0a6d\u0a6f\u0005\u0004\u0000\u0000\u0a6e\u0a6d\u0001\u0000\u0000"+
		"\u0000\u0a6f\u0a72\u0001\u0000\u0000\u0000\u0a70\u0a6e\u0001\u0000\u0000"+
		"\u0000\u0a70\u0a71\u0001\u0000\u0000\u0000\u0a71\u0a73\u0001\u0000\u0000"+
		"\u0000\u0a72\u0a70\u0001\u0000\u0000\u0000\u0a73\u0a77\u0005\u0007\u0000"+
		"\u0000\u0a74\u0a76\u0005\u0004\u0000\u0000\u0a75\u0a74\u0001\u0000\u0000"+
		"\u0000\u0a76\u0a79\u0001\u0000\u0000\u0000\u0a77\u0a75\u0001\u0000\u0000"+
		"\u0000\u0a77\u0a78\u0001\u0000\u0000\u0000\u0a78\u0a7a\u0001\u0000\u0000"+
		"\u0000\u0a79\u0a77\u0001\u0000\u0000\u0000\u0a7a\u0a7c\u0003X,\u0000\u0a7b"+
		"\u0a70\u0001\u0000\u0000\u0000\u0a7c\u0a7f\u0001\u0000\u0000\u0000\u0a7d"+
		"\u0a7b\u0001\u0000\u0000\u0000\u0a7d\u0a7e\u0001\u0000\u0000\u0000\u0a7e"+
		"\u0a87\u0001\u0000\u0000\u0000\u0a7f\u0a7d\u0001\u0000\u0000\u0000\u0a80"+
		"\u0a82\u0005\u0004\u0000\u0000\u0a81\u0a80\u0001\u0000\u0000\u0000\u0a82"+
		"\u0a85\u0001\u0000\u0000\u0000\u0a83\u0a81\u0001\u0000\u0000\u0000\u0a83"+
		"\u0a84\u0001\u0000\u0000\u0000\u0a84\u0a86\u0001\u0000\u0000\u0000\u0a85"+
		"\u0a83\u0001\u0000\u0000\u0000\u0a86\u0a88\u0005\u0007\u0000\u0000\u0a87"+
		"\u0a83\u0001\u0000\u0000\u0000\u0a87\u0a88\u0001\u0000\u0000\u0000\u0a88"+
		"\u0a8c\u0001\u0000\u0000\u0000\u0a89\u0a8b\u0005\u0004\u0000\u0000\u0a8a"+
		"\u0a89\u0001\u0000\u0000\u0000\u0a8b\u0a8e\u0001\u0000\u0000\u0000\u0a8c"+
		"\u0a8a\u0001\u0000\u0000\u0000\u0a8c\u0a8d\u0001\u0000\u0000\u0000\u0a8d"+
		"\u0a8f\u0001\u0000\u0000\u0000\u0a8e\u0a8c\u0001\u0000\u0000\u0000\u0a8f"+
		"\u0a90\u0005,\u0000\u0000\u0a90\u00e9\u0001\u0000\u0000\u0000\u0a91\u0a95"+
		"\u0005\b\u0000\u0000\u0a92\u0a94\u0005\u0004\u0000\u0000\u0a93\u0a92\u0001"+
		"\u0000\u0000\u0000\u0a94\u0a97\u0001\u0000\u0000\u0000\u0a95\u0a93\u0001"+
		"\u0000\u0000\u0000\u0a95\u0a96\u0001\u0000\u0000\u0000\u0a96\u0abb\u0001"+
		"\u0000\u0000\u0000\u0a97\u0a95\u0001\u0000\u0000\u0000\u0a98\u0aa9\u0003"+
		"\u00ecv\u0000\u0a99\u0a9b\u0005\u0004\u0000\u0000\u0a9a\u0a99\u0001\u0000"+
		"\u0000\u0000\u0a9b\u0a9e\u0001\u0000\u0000\u0000\u0a9c\u0a9a\u0001\u0000"+
		"\u0000\u0000\u0a9c\u0a9d\u0001\u0000\u0000\u0000\u0a9d\u0a9f\u0001\u0000"+
		"\u0000\u0000\u0a9e\u0a9c\u0001\u0000\u0000\u0000\u0a9f\u0aa3\u0005\u0007"+
		"\u0000\u0000\u0aa0\u0aa2\u0005\u0004\u0000\u0000\u0aa1\u0aa0\u0001\u0000"+
		"\u0000\u0000\u0aa2\u0aa5\u0001\u0000\u0000\u0000\u0aa3\u0aa1\u0001\u0000"+
		"\u0000\u0000\u0aa3\u0aa4\u0001\u0000\u0000\u0000\u0aa4\u0aa6\u0001\u0000"+
		"\u0000\u0000\u0aa5\u0aa3\u0001\u0000\u0000\u0000\u0aa6\u0aa8\u0003\u00ec"+
		"v\u0000\u0aa7\u0a9c\u0001\u0000\u0000\u0000\u0aa8\u0aab\u0001\u0000\u0000"+
		"\u0000\u0aa9\u0aa7\u0001\u0000\u0000\u0000\u0aa9\u0aaa\u0001\u0000\u0000"+
		"\u0000\u0aaa\u0ab3\u0001\u0000\u0000\u0000\u0aab\u0aa9\u0001\u0000\u0000"+
		"\u0000\u0aac\u0aae\u0005\u0004\u0000\u0000\u0aad\u0aac\u0001\u0000\u0000"+
		"\u0000\u0aae\u0ab1\u0001\u0000\u0000\u0000\u0aaf\u0aad\u0001\u0000\u0000"+
		"\u0000\u0aaf\u0ab0\u0001\u0000\u0000\u0000\u0ab0\u0ab2\u0001\u0000\u0000"+
		"\u0000\u0ab1\u0aaf\u0001\u0000\u0000\u0000\u0ab2\u0ab4\u0005\u0007\u0000"+
		"\u0000\u0ab3\u0aaf\u0001\u0000\u0000\u0000\u0ab3\u0ab4\u0001\u0000\u0000"+
		"\u0000\u0ab4\u0ab8\u0001\u0000\u0000\u0000\u0ab5\u0ab7\u0005\u0004\u0000"+
		"\u0000\u0ab6\u0ab5\u0001\u0000\u0000\u0000\u0ab7\u0aba\u0001\u0000\u0000"+
		"\u0000\u0ab8\u0ab6\u0001\u0000\u0000\u0000\u0ab8\u0ab9\u0001\u0000\u0000"+
		"\u0000\u0ab9\u0abc\u0001\u0000\u0000\u0000\u0aba\u0ab8\u0001\u0000\u0000"+
		"\u0000\u0abb\u0a98\u0001\u0000\u0000\u0000\u0abb\u0abc\u0001\u0000\u0000"+
		"\u0000\u0abc\u0abd\u0001\u0000\u0000\u0000\u0abd\u0abe\u0005\t\u0000\u0000"+
		"\u0abe\u00eb\u0001\u0000\u0000\u0000\u0abf\u0ac3\u0003\u0124\u0092\u0000"+
		"\u0ac0\u0ac2\u0005\u0004\u0000\u0000\u0ac1\u0ac0\u0001\u0000\u0000\u0000"+
		"\u0ac2\u0ac5\u0001\u0000\u0000\u0000\u0ac3\u0ac1\u0001\u0000\u0000\u0000"+
		"\u0ac3\u0ac4\u0001\u0000\u0000\u0000\u0ac4\u0ac6\u0001\u0000\u0000\u0000"+
		"\u0ac5\u0ac3\u0001\u0000\u0000\u0000\u0ac6\u0aca\u0005\u001b\u0000\u0000"+
		"\u0ac7\u0ac9\u0005\u0004\u0000\u0000\u0ac8\u0ac7\u0001\u0000\u0000\u0000"+
		"\u0ac9\u0acc\u0001\u0000\u0000\u0000\u0aca\u0ac8\u0001\u0000\u0000\u0000"+
		"\u0aca\u0acb\u0001\u0000\u0000\u0000\u0acb\u0ace\u0001\u0000\u0000\u0000"+
		"\u0acc\u0aca\u0001\u0000\u0000\u0000\u0acd\u0abf\u0001\u0000\u0000\u0000"+
		"\u0acd\u0ace\u0001\u0000\u0000\u0000\u0ace\u0ad0\u0001\u0000\u0000\u0000"+
		"\u0acf\u0ad1\u0005\u000e\u0000\u0000\u0ad0\u0acf\u0001\u0000\u0000\u0000"+
		"\u0ad0\u0ad1\u0001\u0000\u0000\u0000\u0ad1\u0ad5\u0001\u0000\u0000\u0000"+
		"\u0ad2\u0ad4\u0005\u0004\u0000\u0000\u0ad3\u0ad2\u0001\u0000\u0000\u0000"+
		"\u0ad4\u0ad7\u0001\u0000\u0000\u0000\u0ad5\u0ad3\u0001\u0000\u0000\u0000"+
		"\u0ad5\u0ad6\u0001\u0000\u0000\u0000\u0ad6\u0ad8\u0001\u0000\u0000\u0000"+
		"\u0ad7\u0ad5\u0001\u0000\u0000\u0000\u0ad8\u0ad9\u0003~?\u0000\u0ad9\u00ed"+
		"\u0001\u0000\u0000\u0000\u0ada\u0adb\u0007\b\u0000\u0000\u0adb\u00ef\u0001"+
		"\u0000\u0000\u0000\u0adc\u0add\u0007\t\u0000\u0000\u0add\u00f1\u0001\u0000"+
		"\u0000\u0000\u0ade\u0adf\u0007\n\u0000\u0000\u0adf\u00f3\u0001\u0000\u0000"+
		"\u0000\u0ae0\u0ae1\u0007\u000b\u0000\u0000\u0ae1\u00f5\u0001\u0000\u0000"+
		"\u0000\u0ae2\u0ae3\u0007\f\u0000\u0000\u0ae3\u00f7\u0001\u0000\u0000\u0000"+
		"\u0ae4\u0ae5\u0007\r\u0000\u0000\u0ae5\u00f9\u0001\u0000\u0000\u0000\u0ae6"+
		"\u0ae7\u0007\u000e\u0000\u0000\u0ae7\u00fb\u0001\u0000\u0000\u0000\u0ae8"+
		"\u0aee\u0005\u0013\u0000\u0000\u0ae9\u0aee\u0005\u0014\u0000\u0000\u0aea"+
		"\u0aee\u0005\u0012\u0000\u0000\u0aeb\u0aee\u0005\u0011\u0000\u0000\u0aec"+
		"\u0aee\u0003\u0100\u0080\u0000\u0aed\u0ae8\u0001\u0000\u0000\u0000\u0aed"+
		"\u0ae9\u0001\u0000\u0000\u0000\u0aed\u0aea\u0001\u0000\u0000\u0000\u0aed"+
		"\u0aeb\u0001\u0000\u0000\u0000\u0aed\u0aec\u0001\u0000\u0000\u0000\u0aee"+
		"\u00fd\u0001\u0000\u0000\u0000\u0aef\u0af4\u0005\u0013\u0000\u0000\u0af0"+
		"\u0af4\u0005\u0014\u0000\u0000\u0af1\u0af2\u0005\u0018\u0000\u0000\u0af2"+
		"\u0af4\u0003\u0100\u0080\u0000\u0af3\u0aef\u0001\u0000\u0000\u0000\u0af3"+
		"\u0af0\u0001\u0000\u0000\u0000\u0af3\u0af1\u0001\u0000\u0000\u0000\u0af4"+
		"\u00ff\u0001\u0000\u0000\u0000\u0af5\u0af6\u0007\u000f\u0000\u0000\u0af6"+
		"\u0101\u0001\u0000\u0000\u0000\u0af7\u0af9\u0005\u0004\u0000\u0000\u0af8"+
		"\u0af7\u0001\u0000\u0000\u0000\u0af9\u0afc\u0001\u0000\u0000\u0000\u0afa"+
		"\u0af8\u0001\u0000\u0000\u0000\u0afa\u0afb\u0001\u0000\u0000\u0000\u0afb"+
		"\u0afd\u0001\u0000\u0000\u0000\u0afc\u0afa\u0001\u0000\u0000\u0000\u0afd"+
		"\u0b07\u0005\u0006\u0000\u0000\u0afe\u0b00\u0005\u0004\u0000\u0000\u0aff"+
		"\u0afe\u0001\u0000\u0000\u0000\u0b00\u0b03\u0001\u0000\u0000\u0000\u0b01"+
		"\u0aff\u0001\u0000\u0000\u0000\u0b01\u0b02\u0001\u0000\u0000\u0000\u0b02"+
		"\u0b04\u0001\u0000\u0000\u0000\u0b03\u0b01\u0001\u0000\u0000\u0000\u0b04"+
		"\u0b07\u0003\u0104\u0082\u0000\u0b05\u0b07\u0005\"\u0000\u0000\u0b06\u0afa"+
		"\u0001\u0000\u0000\u0000\u0b06\u0b01\u0001\u0000\u0000\u0000\u0b06\u0b05"+
		"\u0001\u0000\u0000\u0000\u0b07\u0103\u0001\u0000\u0000\u0000\u0b08\u0b09"+
		"\u0005(\u0000\u0000\u0b09\u0b0a\u0005\u0006\u0000\u0000\u0b0a\u0105\u0001"+
		"\u0000\u0000\u0000\u0b0b\u0b0e\u0003\u011a\u008d\u0000\u0b0c\u0b0e\u0003"+
		"\u010a\u0085\u0000\u0b0d\u0b0b\u0001\u0000\u0000\u0000\u0b0d\u0b0c\u0001"+
		"\u0000\u0000\u0000\u0b0e\u0b0f\u0001\u0000\u0000\u0000\u0b0f\u0b0d\u0001"+
		"\u0000\u0000\u0000\u0b0f\u0b10\u0001\u0000\u0000\u0000\u0b10\u0107\u0001"+
		"\u0000\u0000\u0000\u0b11\u0b13\u0003\u011a\u008d\u0000\u0b12\u0b11\u0001"+
		"\u0000\u0000\u0000\u0b13\u0b14\u0001\u0000\u0000\u0000\u0b14\u0b12\u0001"+
		"\u0000\u0000\u0000\u0b14\u0b15\u0001\u0000\u0000\u0000\u0b15\u0b17\u0001"+
		"\u0000\u0000\u0000\u0b16\u0b18\u0005n\u0000\u0000\u0b17\u0b16\u0001\u0000"+
		"\u0000\u0000\u0b17\u0b18\u0001\u0000\u0000\u0000\u0b18\u0109\u0001\u0000"+
		"\u0000\u0000\u0b19\u0b1f\u0003\u010c\u0086\u0000\u0b1a\u0b1f\u0003\u010e"+
		"\u0087\u0000\u0b1b\u0b1f\u0003\u0110\u0088\u0000\u0b1c\u0b1f\u0003\u0118"+
		"\u008c\u0000\u0b1d\u0b1f\u0005n\u0000\u0000\u0b1e\u0b19\u0001\u0000\u0000"+
		"\u0000\u0b1e\u0b1a\u0001\u0000\u0000\u0000\u0b1e\u0b1b\u0001\u0000\u0000"+
		"\u0000\u0b1e\u0b1c\u0001\u0000\u0000\u0000\u0b1e\u0b1d\u0001\u0000\u0000"+
		"\u0000\u0b1f\u0b23\u0001\u0000\u0000\u0000\u0b20\u0b22\u0005\u0004\u0000"+
		"\u0000\u0b21\u0b20\u0001\u0000\u0000\u0000\u0b22\u0b25\u0001\u0000\u0000"+
		"\u0000\u0b23\u0b21\u0001\u0000\u0000\u0000\u0b23\u0b24\u0001\u0000\u0000"+
		"\u0000\u0b24\u010b\u0001\u0000\u0000\u0000\u0b25\u0b23\u0001\u0000\u0000"+
		"\u0000\u0b26\u0b27\u0007\u0010\u0000\u0000\u0b27\u010d\u0001\u0000\u0000"+
		"\u0000\u0b28\u0b29\u0007\u0011\u0000\u0000\u0b29\u010f\u0001\u0000\u0000"+
		"\u0000\u0b2a\u0b2b\u0007\u0012\u0000\u0000\u0b2b\u0111\u0001\u0000\u0000"+
		"\u0000\u0b2c\u0b2d\u0007\u0013\u0000\u0000\u0b2d\u0113\u0001\u0000\u0000"+
		"\u0000\u0b2e\u0b30\u0003\u0116\u008b\u0000\u0b2f\u0b2e\u0001\u0000\u0000"+
		"\u0000\u0b30\u0b31\u0001\u0000\u0000\u0000\u0b31\u0b2f\u0001\u0000\u0000"+
		"\u0000\u0b31\u0b32\u0001\u0000\u0000\u0000\u0b32\u0115\u0001\u0000\u0000"+
		"\u0000\u0b33\u0b37\u0003\u0112\u0089\u0000\u0b34\u0b36\u0005\u0004\u0000"+
		"\u0000\u0b35\u0b34\u0001\u0000\u0000\u0000\u0b36\u0b39\u0001\u0000\u0000"+
		"\u0000\u0b37\u0b35\u0001\u0000\u0000\u0000\u0b37\u0b38\u0001\u0000\u0000"+
		"\u0000\u0b38\u0b3c\u0001\u0000\u0000\u0000\u0b39\u0b37\u0001\u0000\u0000"+
		"\u0000\u0b3a\u0b3c\u0003\u011c\u008e\u0000\u0b3b\u0b33\u0001\u0000\u0000"+
		"\u0000\u0b3b\u0b3a\u0001\u0000\u0000\u0000\u0b3c\u0117\u0001\u0000\u0000"+
		"\u0000\u0b3d\u0b3e\u0007\u0014\u0000\u0000\u0b3e\u0119\u0001\u0000\u0000"+
		"\u0000\u0b3f\u0b42\u0003\u011c\u008e\u0000\u0b40\u0b42\u0003\u011e\u008f"+
		"\u0000\u0b41\u0b3f\u0001\u0000\u0000\u0000\u0b41\u0b40\u0001\u0000\u0000"+
		"\u0000\u0b42\u0b46\u0001\u0000\u0000\u0000\u0b43\u0b45\u0005\u0004\u0000"+
		"\u0000\u0b44\u0b43\u0001\u0000\u0000\u0000\u0b45\u0b48\u0001\u0000\u0000"+
		"\u0000\u0b46\u0b44\u0001\u0000\u0000\u0000\u0b46\u0b47\u0001\u0000\u0000"+
		"\u0000\u0b47\u011b\u0001\u0000\u0000\u0000\u0b48\u0b46\u0001\u0000\u0000"+
		"\u0000\u0b49\u0b4d\u0003\u0120\u0090\u0000\u0b4a\u0b4c\u0005\u0004\u0000"+
		"\u0000\u0b4b\u0b4a\u0001\u0000\u0000\u0000\u0b4c\u0b4f\u0001\u0000\u0000"+
		"\u0000\u0b4d\u0b4b\u0001\u0000\u0000\u0000\u0b4d\u0b4e\u0001\u0000\u0000"+
		"\u0000\u0b4e\u0b50\u0001\u0000\u0000\u0000\u0b4f\u0b4d\u0001\u0000\u0000"+
		"\u0000\u0b50\u0b54\u0005\u0019\u0000\u0000\u0b51\u0b53\u0005\u0004\u0000"+
		"\u0000\u0b52\u0b51\u0001\u0000\u0000\u0000\u0b53\u0b56\u0001\u0000\u0000"+
		"\u0000\u0b54\u0b52\u0001\u0000\u0000\u0000\u0b54\u0b55\u0001\u0000\u0000"+
		"\u0000\u0b55\u0b57\u0001\u0000\u0000\u0000\u0b56\u0b54\u0001\u0000\u0000"+
		"\u0000\u0b57\u0b58\u0003\u0122\u0091\u0000\u0b58\u0b5c\u0001\u0000\u0000"+
		"\u0000\u0b59\u0b5a\u0007\u0015\u0000\u0000\u0b5a\u0b5c\u0003\u0122\u0091"+
		"\u0000\u0b5b\u0b49\u0001\u0000\u0000\u0000\u0b5b\u0b59\u0001\u0000\u0000"+
		"\u0000\u0b5c\u011d\u0001\u0000\u0000\u0000\u0b5d\u0b5e\u0003\u0120\u0090"+
		"\u0000\u0b5e\u0b5f\u0005\u0019\u0000\u0000\u0b5f\u0b61\u0005\n\u0000\u0000"+
		"\u0b60\u0b62\u0003\u0122\u0091\u0000\u0b61\u0b60\u0001\u0000\u0000\u0000"+
		"\u0b62\u0b63\u0001\u0000\u0000\u0000\u0b63\u0b61\u0001\u0000\u0000\u0000"+
		"\u0b63\u0b64\u0001\u0000\u0000\u0000\u0b64\u0b65\u0001\u0000\u0000\u0000"+
		"\u0b65\u0b66\u0005\u000b\u0000\u0000\u0b66\u0b71\u0001\u0000\u0000\u0000"+
		"\u0b67\u0b68\u0007\u0015\u0000\u0000\u0b68\u0b6a\u0005\n\u0000\u0000\u0b69"+
		"\u0b6b\u0003\u0122\u0091\u0000\u0b6a\u0b69\u0001\u0000\u0000\u0000\u0b6b"+
		"\u0b6c\u0001\u0000\u0000\u0000\u0b6c\u0b6a\u0001\u0000\u0000\u0000\u0b6c"+
		"\u0b6d\u0001\u0000\u0000\u0000\u0b6d\u0b6e\u0001\u0000\u0000\u0000\u0b6e"+
		"\u0b6f\u0005\u000b\u0000\u0000\u0b6f\u0b71\u0001\u0000\u0000\u0000\u0b70"+
		"\u0b5d\u0001\u0000\u0000\u0000\u0b70\u0b67\u0001\u0000\u0000\u0000\u0b71"+
		"\u011f\u0001\u0000\u0000\u0000\u0b72\u0b73\u0007\u0016\u0000\u0000\u0b73"+
		"\u0121\u0001\u0000\u0000\u0000\u0b74\u0b77\u0003\u001a\r\u0000\u0b75\u0b77"+
		"\u0003T*\u0000\u0b76\u0b74\u0001\u0000\u0000\u0000\u0b76\u0b75\u0001\u0000"+
		"\u0000\u0000\u0b77\u0123\u0001\u0000\u0000\u0000\u0b78\u0b79\u0007\u0017"+
		"\u0000\u0000\u0b79\u0125\u0001\u0000\u0000\u0000\u0b7a\u0b85\u0003\u0124"+
		"\u0092\u0000\u0b7b\u0b7d\u0005\u0004\u0000\u0000\u0b7c\u0b7b\u0001\u0000"+
		"\u0000\u0000\u0b7d\u0b80\u0001\u0000\u0000\u0000\u0b7e\u0b7c\u0001\u0000"+
		"\u0000\u0000\u0b7e\u0b7f\u0001\u0000\u0000\u0000\u0b7f\u0b81\u0001\u0000"+
		"\u0000\u0000\u0b80\u0b7e\u0001\u0000\u0000\u0000\u0b81\u0b82\u0005\u0006"+
		"\u0000\u0000\u0b82\u0b84\u0003\u0124\u0092\u0000\u0b83\u0b7e\u0001\u0000"+
		"\u0000\u0000\u0b84\u0b87\u0001\u0000\u0000\u0000\u0b85\u0b83\u0001\u0000"+
		"\u0000\u0000\u0b85\u0b86\u0001\u0000\u0000\u0000\u0b86\u0127\u0001\u0000"+
		"\u0000\u0000\u0b87\u0b85\u0001\u0000\u0000\u0000\u0b88\u0b8a\u0005\u0004"+
		"\u0000\u0000\u0b89\u0b88\u0001\u0000\u0000\u0000\u0b8a\u0b8b\u0001\u0000"+
		"\u0000\u0000\u0b8b\u0b89\u0001\u0000\u0000\u0000\u0b8b\u0b8c\u0001\u0000"+
		"\u0000\u0000\u0b8c\u0b9b\u0001\u0000\u0000\u0000\u0b8d\u0b8f\u0005\u0004"+
		"\u0000\u0000\u0b8e\u0b8d\u0001\u0000\u0000\u0000\u0b8f\u0b92\u0001\u0000"+
		"\u0000\u0000\u0b90\u0b8e\u0001\u0000\u0000\u0000\u0b90\u0b91\u0001\u0000"+
		"\u0000\u0000\u0b91\u0b93\u0001\u0000\u0000\u0000\u0b92\u0b90\u0001\u0000"+
		"\u0000\u0000\u0b93\u0b97\u0005\u001a\u0000\u0000\u0b94\u0b96\u0005\u0004"+
		"\u0000\u0000\u0b95\u0b94\u0001\u0000\u0000\u0000\u0b96\u0b99\u0001\u0000"+
		"\u0000\u0000\u0b97\u0b95\u0001\u0000\u0000\u0000\u0b97\u0b98\u0001\u0000"+
		"\u0000\u0000\u0b98\u0b9b\u0001\u0000\u0000\u0000\u0b99\u0b97\u0001\u0000"+
		"\u0000\u0000\u0b9a\u0b89\u0001\u0000\u0000\u0000\u0b9a\u0b90\u0001\u0000"+
		"\u0000\u0000\u0b9b\u0129\u0001\u0000\u0000\u0000\u0b9c\u0b9d\u0007\u0018"+
		"\u0000\u0000\u0b9d\u012b\u0001\u0000\u0000\u0000\u01c7\u012d\u0133\u013a"+
		"\u013d\u0141\u0149\u014e\u0154\u0157\u015f\u0162\u0169\u016c\u016f\u0174"+
		"\u017b\u017f\u0184\u0188\u018d\u0194\u0198\u019d\u01a1\u01a6\u01ad\u01b1"+
		"\u01b4\u01ba\u01bd\u01c5\u01cc\u01d3\u01d9\u01df\u01e3\u01e5\u01ea\u01f0"+
		"\u01f3\u01f8\u0200\u0207\u020e\u0212\u0218\u021f\u0225\u022b\u0231\u023a"+
		"\u0240\u0247\u024c\u0253\u025c\u0262\u0268\u0271\u0278\u027f\u0285\u028b"+
		"\u028f\u0294\u029a\u029f\u02a4\u02a9\u02b0\u02b4\u02ba\u02c1\u02c8\u02ce"+
		"\u02d4\u02db\u02e2\u02ea\u02ef\u02f5\u02fb\u0301\u0308\u030f\u0313\u0318"+
		"\u031c\u0322\u0328\u032e\u0332\u0337\u033e\u0343\u0348\u034f\u0356\u035d"+
		"\u0361\u0366\u036a\u036f\u0373\u0379\u0380\u0387\u038d\u0393\u0397\u0399"+
		"\u039e\u03a4\u03aa\u03b1\u03b5\u03bc\u03c0\u03c3\u03c9\u03cd\u03d2\u03d9"+
		"\u03de\u03e3\u03eb\u03ef\u03f4\u03fb\u03ff\u0404\u0408\u040d\u0414\u0418"+
		"\u041b\u0421\u0425\u0429\u042e\u0434\u043b\u0442\u0446\u0449\u044f\u0456"+
		"\u045d\u0464\u0468\u046d\u0471\u0474\u047a\u0481\u0488\u048c\u0491\u0498"+
		"\u049d\u04a3\u04aa\u04b1\u04b7\u04bd\u04c1\u04c3\u04c8\u04ce\u04d4\u04db"+
		"\u04df\u04e5\u04ec\u04f0\u04f6\u04fd\u0506\u050a\u050f\u0516\u051c\u051f"+
		"\u0524\u052c\u052f\u0535\u0538\u053e\u0542\u0547\u054b\u0550\u0554\u0559"+
		"\u0560\u0564\u0569\u056f\u0577\u057e\u0584\u058b\u058f\u0592\u0596\u059b"+
		"\u05a1\u05a5\u05ab\u05b2\u05b5\u05bb\u05c2\u05cb\u05d0\u05d5\u05dc\u05e1"+
		"\u05e5\u05eb\u05ef\u05f4\u05fd\u0604\u060a\u060f\u0615\u061a\u061f\u0627"+
		"\u062e\u0631\u0635\u0638\u063c\u0641\u0647\u064f\u0655\u065c\u0665\u066a"+
		"\u0671\u0677\u067e\u0688\u068c\u0692\u069b\u06a0\u06a4\u06aa\u06b1\u06bc"+
		"\u06c3\u06c9\u06d0\u06d7\u06dd\u06e5\u06ec\u06f4\u06fb\u0702\u070a\u070f"+
		"\u0715\u071c\u0723\u072e\u0735\u073d\u0744\u074b\u0753\u0759\u0762\u0767"+
		"\u076d\u077d\u0783\u078a\u0793\u079a\u07a1\u07a7\u07ad\u07b1\u07b6\u07b9"+
		"\u07c1\u07c6\u07c8\u07d1\u07d3\u07de\u07e5\u07f0\u07f7\u0800\u0804\u0809"+
		"\u0810\u0813\u0819\u0822\u0829\u082f\u0835\u0839\u083f\u0846\u084b\u0850"+
		"\u0857\u085e\u0862\u0867\u086b\u0870\u0874\u0878\u0881\u0888\u088d\u0893"+
		"\u089a\u08a1\u08a8\u08ad\u08b2\u08b6\u08bb\u08c2\u08c7\u08ca\u08d0\u08d6"+
		"\u08dd\u08e4\u08eb\u08ee\u08f7\u08fb\u0900\u0907\u090e\u0913\u0919\u0922"+
		"\u0929\u092f\u0935\u0939\u093e\u0945\u094a\u0950\u0957\u095c\u095e\u0962"+
		"\u0968\u0971\u0978\u097e\u0983\u0987\u098c\u0990\u0996\u099d\u09a6\u09aa"+
		"\u09b0\u09b9\u09c2\u09c8\u09cb\u09ce\u09d4\u09d9\u09e0\u09e7\u09ed\u09f4"+
		"\u09fb\u0a01\u0a08\u0a10\u0a16\u0a1d\u0a24\u0a2a\u0a30\u0a34\u0a39\u0a42"+
		"\u0a48\u0a4b\u0a4e\u0a52\u0a57\u0a5b\u0a60\u0a69\u0a70\u0a77\u0a7d\u0a83"+
		"\u0a87\u0a8c\u0a95\u0a9c\u0aa3\u0aa9\u0aaf\u0ab3\u0ab8\u0abb\u0ac3\u0aca"+
		"\u0acd\u0ad0\u0ad5\u0aed\u0af3\u0afa\u0b01\u0b06\u0b0d\u0b0f\u0b14\u0b17"+
		"\u0b1e\u0b23\u0b31\u0b37\u0b3b\u0b41\u0b46\u0b4d\u0b54\u0b5b\u0b63\u0b6c"+
		"\u0b70\u0b76\u0b7e\u0b85\u0b8b\u0b90\u0b97\u0b9a";
	public static final String _serializedATN = Utils.join(
		new String[] {
			_serializedATNSegment0,
			_serializedATNSegment1
		},
		""
	);
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}