// Generated from C:/Users/Muhammed/IdeaProjects/FinNote/Parser/src/main/java/antlr/ExpParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExpParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, LABEL=2, BEGINGROUB=3, ENDGROUB=4, POW=5, TIMES=6, DIVIDE=7, 
		PLUS=8, MINUS=9, NUMBER=10, EQUALS=11, VALUE_VAR=12, FIND=13, ARABIC=14, 
		STRINGMARK=15, WS=16, NEWLINE=17, COMMEA=18;
	public static final int
		RULE_prog = 0, RULE_line = 1, RULE_save_var = 2, RULE_call_Method = 3, 
		RULE_expersion = 4;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "line", "save_var", "call_Method", "expersion"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, "'('", "')'", "'^'", "'*'", "'/'", "'+'", "'-'", null, 
			null, null, null, null, "'\"'", null, null, "','"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "STRING", "LABEL", "BEGINGROUB", "ENDGROUB", "POW", "TIMES", "DIVIDE", 
			"PLUS", "MINUS", "NUMBER", "EQUALS", "VALUE_VAR", "FIND", "ARABIC", "STRINGMARK", 
			"WS", "NEWLINE", "COMMEA"
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
	public String getGrammarFileName() { return "ExpParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ExpParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class ProgContext extends ParserRuleContext {
		public List<TerminalNode> NEWLINE() { return getTokens(ExpParser.NEWLINE); }
		public TerminalNode NEWLINE(int i) {
			return getToken(ExpParser.NEWLINE, i);
		}
		public List<LineContext> line() {
			return getRuleContexts(LineContext.class);
		}
		public LineContext line(int i) {
			return getRuleContext(LineContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpParserVisitor ) return ((ExpParserVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(11);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==NEWLINE) {
				{
				setState(10);
				match(NEWLINE);
				}
			}

			setState(18);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(13);
					line();
					setState(14);
					match(NEWLINE);
					}
					} 
				}
				setState(20);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
			}
			setState(22);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5646L) != 0)) {
				{
				setState(21);
				line();
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
	public static class LineContext extends ParserRuleContext {
		public Call_MethodContext call_Method() {
			return getRuleContext(Call_MethodContext.class,0);
		}
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public Save_varContext save_var() {
			return getRuleContext(Save_varContext.class,0);
		}
		public LineContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_line; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).enterLine(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).exitLine(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpParserVisitor ) return ((ExpParserVisitor<? extends T>)visitor).visitLine(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LineContext line() throws RecognitionException {
		LineContext _localctx = new LineContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_line);
		try {
			setState(27);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(24);
				call_Method();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(25);
				expersion(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(26);
				save_var();
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
	public static class Save_varContext extends ParserRuleContext {
		public TerminalNode LABEL() { return getToken(ExpParser.LABEL, 0); }
		public TerminalNode EQUALS() { return getToken(ExpParser.EQUALS, 0); }
		public TerminalNode FIND() { return getToken(ExpParser.FIND, 0); }
		public ExpersionContext expersion() {
			return getRuleContext(ExpersionContext.class,0);
		}
		public Call_MethodContext call_Method() {
			return getRuleContext(Call_MethodContext.class,0);
		}
		public Save_varContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_save_var; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).enterSave_var(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).exitSave_var(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpParserVisitor ) return ((ExpParserVisitor<? extends T>)visitor).visitSave_var(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Save_varContext save_var() throws RecognitionException {
		Save_varContext _localctx = new Save_varContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_save_var);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(29);
			match(LABEL);
			setState(30);
			match(EQUALS);
			setState(34);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				{
				setState(31);
				match(FIND);
				}
				break;
			case 2:
				{
				setState(32);
				expersion(0);
				}
				break;
			case 3:
				{
				setState(33);
				call_Method();
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
	public static class Call_MethodContext extends ParserRuleContext {
		public TerminalNode LABEL() { return getToken(ExpParser.LABEL, 0); }
		public TerminalNode BEGINGROUB() { return getToken(ExpParser.BEGINGROUB, 0); }
		public TerminalNode ENDGROUB() { return getToken(ExpParser.ENDGROUB, 0); }
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public List<TerminalNode> COMMEA() { return getTokens(ExpParser.COMMEA); }
		public TerminalNode COMMEA(int i) {
			return getToken(ExpParser.COMMEA, i);
		}
		public Call_MethodContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_Method; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).enterCall_Method(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).exitCall_Method(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpParserVisitor ) return ((ExpParserVisitor<? extends T>)visitor).visitCall_Method(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_MethodContext call_Method() throws RecognitionException {
		Call_MethodContext _localctx = new Call_MethodContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_call_Method);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(36);
			match(LABEL);
			setState(37);
			match(BEGINGROUB);
			setState(43);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(38);
					expersion(0);
					setState(39);
					match(COMMEA);
					}
					} 
				}
				setState(45);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
			}
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & 5646L) != 0)) {
				{
				setState(46);
				expersion(0);
				}
			}

			setState(49);
			match(ENDGROUB);
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
	public static class ExpersionContext extends ParserRuleContext {
		public ExpersionContext left;
		public Token op;
		public ExpersionContext right;
		public TerminalNode MINUS() { return getToken(ExpParser.MINUS, 0); }
		public TerminalNode LABEL() { return getToken(ExpParser.LABEL, 0); }
		public TerminalNode NUMBER() { return getToken(ExpParser.NUMBER, 0); }
		public TerminalNode VALUE_VAR() { return getToken(ExpParser.VALUE_VAR, 0); }
		public Call_MethodContext call_Method() {
			return getRuleContext(Call_MethodContext.class,0);
		}
		public TerminalNode BEGINGROUB() { return getToken(ExpParser.BEGINGROUB, 0); }
		public List<ExpersionContext> expersion() {
			return getRuleContexts(ExpersionContext.class);
		}
		public ExpersionContext expersion(int i) {
			return getRuleContext(ExpersionContext.class,i);
		}
		public TerminalNode ENDGROUB() { return getToken(ExpParser.ENDGROUB, 0); }
		public TerminalNode STRING() { return getToken(ExpParser.STRING, 0); }
		public TerminalNode POW() { return getToken(ExpParser.POW, 0); }
		public TerminalNode TIMES() { return getToken(ExpParser.TIMES, 0); }
		public TerminalNode DIVIDE() { return getToken(ExpParser.DIVIDE, 0); }
		public TerminalNode PLUS() { return getToken(ExpParser.PLUS, 0); }
		public ExpersionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expersion; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).enterExpersion(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ExpParserListener ) ((ExpParserListener)listener).exitExpersion(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ExpParserVisitor ) return ((ExpParserVisitor<? extends T>)visitor).visitExpersion(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpersionContext expersion() throws RecognitionException {
		return expersion(0);
	}

	private ExpersionContext expersion(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpersionContext _localctx = new ExpersionContext(_ctx, _parentState);
		ExpersionContext _prevctx = _localctx;
		int _startState = 8;
		enterRecursionRule(_localctx, 8, RULE_expersion, _p);
		int _la;
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(69);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(52);
				match(MINUS);
				setState(53);
				match(LABEL);
				}
				break;
			case 2:
				{
				setState(54);
				match(MINUS);
				setState(55);
				match(NUMBER);
				}
				break;
			case 3:
				{
				setState(56);
				match(MINUS);
				setState(57);
				match(VALUE_VAR);
				}
				break;
			case 4:
				{
				setState(58);
				match(MINUS);
				setState(59);
				call_Method();
				}
				break;
			case 5:
				{
				setState(60);
				call_Method();
				}
				break;
			case 6:
				{
				setState(61);
				match(BEGINGROUB);
				setState(62);
				expersion(0);
				setState(63);
				match(ENDGROUB);
				}
				break;
			case 7:
				{
				setState(65);
				match(STRING);
				}
				break;
			case 8:
				{
				setState(66);
				match(LABEL);
				}
				break;
			case 9:
				{
				setState(67);
				match(NUMBER);
				}
				break;
			case 10:
				{
				setState(68);
				match(VALUE_VAR);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(82);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(80);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,8,_ctx) ) {
					case 1:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(71);
						if (!(precpred(_ctx, 7))) throw new FailedPredicateException(this, "precpred(_ctx, 7)");
						setState(72);
						((ExpersionContext)_localctx).op = match(POW);
						setState(73);
						((ExpersionContext)_localctx).right = expersion(8);
						}
						break;
					case 2:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(74);
						if (!(precpred(_ctx, 6))) throw new FailedPredicateException(this, "precpred(_ctx, 6)");
						setState(75);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==TIMES || _la==DIVIDE) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(76);
						((ExpersionContext)_localctx).right = expersion(7);
						}
						break;
					case 3:
						{
						_localctx = new ExpersionContext(_parentctx, _parentState);
						_localctx.left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expersion);
						setState(77);
						if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
						setState(78);
						((ExpersionContext)_localctx).op = _input.LT(1);
						_la = _input.LA(1);
						if ( !(_la==PLUS || _la==MINUS) ) {
							((ExpersionContext)_localctx).op = (Token)_errHandler.recoverInline(this);
						}
						else {
							if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
							_errHandler.reportMatch(this);
							consume();
						}
						setState(79);
						((ExpersionContext)_localctx).right = expersion(6);
						}
						break;
					}
					} 
				}
				setState(84);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 4:
			return expersion_sempred((ExpersionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expersion_sempred(ExpersionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 7);
		case 1:
			return precpred(_ctx, 6);
		case 2:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\u0004\u0001\u0012V\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0001"+
		"\u0000\u0003\u0000\f\b\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005"+
		"\u0000\u0011\b\u0000\n\u0000\f\u0000\u0014\t\u0000\u0001\u0000\u0003\u0000"+
		"\u0017\b\u0000\u0001\u0001\u0001\u0001\u0001\u0001\u0003\u0001\u001c\b"+
		"\u0001\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0001\u0002\u0003"+
		"\u0002#\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0001"+
		"\u0003\u0005\u0003*\b\u0003\n\u0003\f\u0003-\t\u0003\u0001\u0003\u0003"+
		"\u00030\b\u0003\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0003\u0004F\b\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0001\u0004\u0001\u0004\u0005\u0004Q\b\u0004\n\u0004\f\u0004T\t"+
		"\u0004\u0001\u0004\u0000\u0001\b\u0005\u0000\u0002\u0004\u0006\b\u0000"+
		"\u0002\u0001\u0000\u0006\u0007\u0001\u0000\b\te\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0002\u001b\u0001\u0000\u0000\u0000\u0004\u001d\u0001\u0000"+
		"\u0000\u0000\u0006$\u0001\u0000\u0000\u0000\bE\u0001\u0000\u0000\u0000"+
		"\n\f\u0005\u0011\u0000\u0000\u000b\n\u0001\u0000\u0000\u0000\u000b\f\u0001"+
		"\u0000\u0000\u0000\f\u0012\u0001\u0000\u0000\u0000\r\u000e\u0003\u0002"+
		"\u0001\u0000\u000e\u000f\u0005\u0011\u0000\u0000\u000f\u0011\u0001\u0000"+
		"\u0000\u0000\u0010\r\u0001\u0000\u0000\u0000\u0011\u0014\u0001\u0000\u0000"+
		"\u0000\u0012\u0010\u0001\u0000\u0000\u0000\u0012\u0013\u0001\u0000\u0000"+
		"\u0000\u0013\u0016\u0001\u0000\u0000\u0000\u0014\u0012\u0001\u0000\u0000"+
		"\u0000\u0015\u0017\u0003\u0002\u0001\u0000\u0016\u0015\u0001\u0000\u0000"+
		"\u0000\u0016\u0017\u0001\u0000\u0000\u0000\u0017\u0001\u0001\u0000\u0000"+
		"\u0000\u0018\u001c\u0003\u0006\u0003\u0000\u0019\u001c\u0003\b\u0004\u0000"+
		"\u001a\u001c\u0003\u0004\u0002\u0000\u001b\u0018\u0001\u0000\u0000\u0000"+
		"\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001a\u0001\u0000\u0000\u0000"+
		"\u001c\u0003\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0002\u0000\u0000"+
		"\u001e\"\u0005\u000b\u0000\u0000\u001f#\u0005\r\u0000\u0000 #\u0003\b"+
		"\u0004\u0000!#\u0003\u0006\u0003\u0000\"\u001f\u0001\u0000\u0000\u0000"+
		"\" \u0001\u0000\u0000\u0000\"!\u0001\u0000\u0000\u0000#\u0005\u0001\u0000"+
		"\u0000\u0000$%\u0005\u0002\u0000\u0000%+\u0005\u0003\u0000\u0000&\'\u0003"+
		"\b\u0004\u0000\'(\u0005\u0012\u0000\u0000(*\u0001\u0000\u0000\u0000)&"+
		"\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001\u0000\u0000"+
		"\u0000+,\u0001\u0000\u0000\u0000,/\u0001\u0000\u0000\u0000-+\u0001\u0000"+
		"\u0000\u0000.0\u0003\b\u0004\u0000/.\u0001\u0000\u0000\u0000/0\u0001\u0000"+
		"\u0000\u000001\u0001\u0000\u0000\u000012\u0005\u0004\u0000\u00002\u0007"+
		"\u0001\u0000\u0000\u000034\u0006\u0004\uffff\uffff\u000045\u0005\t\u0000"+
		"\u00005F\u0005\u0002\u0000\u000067\u0005\t\u0000\u00007F\u0005\n\u0000"+
		"\u000089\u0005\t\u0000\u00009F\u0005\f\u0000\u0000:;\u0005\t\u0000\u0000"+
		";F\u0003\u0006\u0003\u0000<F\u0003\u0006\u0003\u0000=>\u0005\u0003\u0000"+
		"\u0000>?\u0003\b\u0004\u0000?@\u0005\u0004\u0000\u0000@F\u0001\u0000\u0000"+
		"\u0000AF\u0005\u0001\u0000\u0000BF\u0005\u0002\u0000\u0000CF\u0005\n\u0000"+
		"\u0000DF\u0005\f\u0000\u0000E3\u0001\u0000\u0000\u0000E6\u0001\u0000\u0000"+
		"\u0000E8\u0001\u0000\u0000\u0000E:\u0001\u0000\u0000\u0000E<\u0001\u0000"+
		"\u0000\u0000E=\u0001\u0000\u0000\u0000EA\u0001\u0000\u0000\u0000EB\u0001"+
		"\u0000\u0000\u0000EC\u0001\u0000\u0000\u0000ED\u0001\u0000\u0000\u0000"+
		"FR\u0001\u0000\u0000\u0000GH\n\u0007\u0000\u0000HI\u0005\u0005\u0000\u0000"+
		"IQ\u0003\b\u0004\bJK\n\u0006\u0000\u0000KL\u0007\u0000\u0000\u0000LQ\u0003"+
		"\b\u0004\u0007MN\n\u0005\u0000\u0000NO\u0007\u0001\u0000\u0000OQ\u0003"+
		"\b\u0004\u0006PG\u0001\u0000\u0000\u0000PJ\u0001\u0000\u0000\u0000PM\u0001"+
		"\u0000\u0000\u0000QT\u0001\u0000\u0000\u0000RP\u0001\u0000\u0000\u0000"+
		"RS\u0001\u0000\u0000\u0000S\t\u0001\u0000\u0000\u0000TR\u0001\u0000\u0000"+
		"\u0000\n\u000b\u0012\u0016\u001b\"+/EPR";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}