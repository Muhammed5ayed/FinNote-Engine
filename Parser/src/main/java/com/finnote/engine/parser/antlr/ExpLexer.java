// Generated from C:/Users/Muhammed/IdeaProjects/FinNote/Parser/src/main/java/antlr/ExpLexer.g4 by ANTLR 4.13.2
package com.finnote.engine.parser.antlr;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue", "this-escape"})
public class ExpLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.13.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		STRING=1, LABEL=2, BEGINGROUB=3, ENDGROUB=4, POW=5, TIMES=6, DIVIDE=7, 
		PLUS=8, MINUS=9, NUMBER=10, EQUALS=11, VALUE_VAR=12, FIND=13, ARABIC=14, 
		STRINGMARK=15, WS=16, NEWLINE=17, COMMEA=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"STRING", "LABEL", "BEGINGROUB", "ENDGROUB", "POW", "TIMES", "DIVIDE", 
			"PLUS", "MINUS", "NUMBER", "EQUALS", "VALUE_VAR", "FIND", "ARABIC", "STRINGMARK", 
			"WS", "NEWLINE", "COMMEA"
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


	public ExpLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ExpLexer.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\u0004\u0000\u0012~\u0006\uffff\uffff\u0002\u0000\u0007\u0000\u0002\u0001"+
		"\u0007\u0001\u0002\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004"+
		"\u0007\u0004\u0002\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007"+
		"\u0007\u0007\u0002\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b"+
		"\u0007\u000b\u0002\f\u0007\f\u0002\r\u0007\r\u0002\u000e\u0007\u000e\u0002"+
		"\u000f\u0007\u000f\u0002\u0010\u0007\u0010\u0002\u0011\u0007\u0011\u0001"+
		"\u0000\u0001\u0000\u0001\u0000\u0001\u0000\u0005\u0000*\b\u0000\n\u0000"+
		"\f\u0000-\t\u0000\u0001\u0000\u0001\u0000\u0001\u0001\u0001\u0001\u0005"+
		"\u00013\b\u0001\n\u0001\f\u00016\t\u0001\u0001\u0001\u0003\u00019\b\u0001"+
		"\u0001\u0002\u0001\u0002\u0001\u0003\u0001\u0003\u0001\u0004\u0001\u0004"+
		"\u0001\u0005\u0001\u0005\u0001\u0006\u0001\u0006\u0001\u0007\u0001\u0007"+
		"\u0001\b\u0001\b\u0001\t\u0004\tJ\b\t\u000b\t\f\tK\u0001\t\u0001\t\u0005"+
		"\tP\b\t\n\t\f\tS\t\t\u0003\tU\b\t\u0001\n\u0005\nX\b\n\n\n\f\n[\t\n\u0001"+
		"\n\u0001\n\u0005\n_\b\n\n\n\f\nb\t\n\u0001\u000b\u0001\u000b\u0001\u000b"+
		"\u0005\u000bg\b\u000b\n\u000b\f\u000bj\t\u000b\u0001\u000b\u0001\u000b"+
		"\u0001\f\u0001\f\u0001\r\u0001\r\u0001\u000e\u0001\u000e\u0001\u000f\u0001"+
		"\u000f\u0001\u000f\u0001\u000f\u0001\u0010\u0004\u0010y\b\u0010\u000b"+
		"\u0010\f\u0010z\u0001\u0011\u0001\u0011\u0000\u0000\u0012\u0001\u0001"+
		"\u0003\u0002\u0005\u0003\u0007\u0004\t\u0005\u000b\u0006\r\u0007\u000f"+
		"\b\u0011\t\u0013\n\u0015\u000b\u0017\f\u0019\r\u001b\u000e\u001d\u000f"+
		"\u001f\u0010!\u0011#\u0012\u0001\u0000\b\u0002\u0000\"\"\\\\\u0003\u0000"+
		"AZaz\u0621\u064a\u0006\u0000  ..09AZaz\u0621\u064a\u0001\u000009\u0002"+
		"\u0000??\u061f\u061f\u0001\u0000\u0621\u064a\u0003\u0000\t\t\r\r  \u0001"+
		"\u0000\n\n\u0088\u0000\u0001\u0001\u0000\u0000\u0000\u0000\u0003\u0001"+
		"\u0000\u0000\u0000\u0000\u0005\u0001\u0000\u0000\u0000\u0000\u0007\u0001"+
		"\u0000\u0000\u0000\u0000\t\u0001\u0000\u0000\u0000\u0000\u000b\u0001\u0000"+
		"\u0000\u0000\u0000\r\u0001\u0000\u0000\u0000\u0000\u000f\u0001\u0000\u0000"+
		"\u0000\u0000\u0011\u0001\u0000\u0000\u0000\u0000\u0013\u0001\u0000\u0000"+
		"\u0000\u0000\u0015\u0001\u0000\u0000\u0000\u0000\u0017\u0001\u0000\u0000"+
		"\u0000\u0000\u0019\u0001\u0000\u0000\u0000\u0000\u001b\u0001\u0000\u0000"+
		"\u0000\u0000\u001d\u0001\u0000\u0000\u0000\u0000\u001f\u0001\u0000\u0000"+
		"\u0000\u0000!\u0001\u0000\u0000\u0000\u0000#\u0001\u0000\u0000\u0000\u0001"+
		"%\u0001\u0000\u0000\u0000\u00030\u0001\u0000\u0000\u0000\u0005:\u0001"+
		"\u0000\u0000\u0000\u0007<\u0001\u0000\u0000\u0000\t>\u0001\u0000\u0000"+
		"\u0000\u000b@\u0001\u0000\u0000\u0000\rB\u0001\u0000\u0000\u0000\u000f"+
		"D\u0001\u0000\u0000\u0000\u0011F\u0001\u0000\u0000\u0000\u0013I\u0001"+
		"\u0000\u0000\u0000\u0015Y\u0001\u0000\u0000\u0000\u0017c\u0001\u0000\u0000"+
		"\u0000\u0019m\u0001\u0000\u0000\u0000\u001bo\u0001\u0000\u0000\u0000\u001d"+
		"q\u0001\u0000\u0000\u0000\u001fs\u0001\u0000\u0000\u0000!x\u0001\u0000"+
		"\u0000\u0000#|\u0001\u0000\u0000\u0000%+\u0005\"\u0000\u0000&\'\u0005"+
		"\\\u0000\u0000\'*\t\u0000\u0000\u0000(*\b\u0000\u0000\u0000)&\u0001\u0000"+
		"\u0000\u0000)(\u0001\u0000\u0000\u0000*-\u0001\u0000\u0000\u0000+)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,.\u0001\u0000\u0000\u0000"+
		"-+\u0001\u0000\u0000\u0000./\u0005\"\u0000\u0000/\u0002\u0001\u0000\u0000"+
		"\u000008\u0007\u0001\u0000\u000013\u0007\u0002\u0000\u000021\u0001\u0000"+
		"\u0000\u000036\u0001\u0000\u0000\u000042\u0001\u0000\u0000\u000045\u0001"+
		"\u0000\u0000\u000057\u0001\u0000\u0000\u000064\u0001\u0000\u0000\u0000"+
		"79\u0007\u0001\u0000\u000084\u0001\u0000\u0000\u000089\u0001\u0000\u0000"+
		"\u00009\u0004\u0001\u0000\u0000\u0000:;\u0005(\u0000\u0000;\u0006\u0001"+
		"\u0000\u0000\u0000<=\u0005)\u0000\u0000=\b\u0001\u0000\u0000\u0000>?\u0005"+
		"^\u0000\u0000?\n\u0001\u0000\u0000\u0000@A\u0005*\u0000\u0000A\f\u0001"+
		"\u0000\u0000\u0000BC\u0005/\u0000\u0000C\u000e\u0001\u0000\u0000\u0000"+
		"DE\u0005+\u0000\u0000E\u0010\u0001\u0000\u0000\u0000FG\u0005-\u0000\u0000"+
		"G\u0012\u0001\u0000\u0000\u0000HJ\u0007\u0003\u0000\u0000IH\u0001\u0000"+
		"\u0000\u0000JK\u0001\u0000\u0000\u0000KI\u0001\u0000\u0000\u0000KL\u0001"+
		"\u0000\u0000\u0000LT\u0001\u0000\u0000\u0000MQ\u0005.\u0000\u0000NP\u0007"+
		"\u0003\u0000\u0000ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000"+
		"QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000"+
		"\u0000SQ\u0001\u0000\u0000\u0000TM\u0001\u0000\u0000\u0000TU\u0001\u0000"+
		"\u0000\u0000U\u0014\u0001\u0000\u0000\u0000VX\u0005 \u0000\u0000WV\u0001"+
		"\u0000\u0000\u0000X[\u0001\u0000\u0000\u0000YW\u0001\u0000\u0000\u0000"+
		"YZ\u0001\u0000\u0000\u0000Z\\\u0001\u0000\u0000\u0000[Y\u0001\u0000\u0000"+
		"\u0000\\`\u0005=\u0000\u0000]_\u0005 \u0000\u0000^]\u0001\u0000\u0000"+
		"\u0000_b\u0001\u0000\u0000\u0000`^\u0001\u0000\u0000\u0000`a\u0001\u0000"+
		"\u0000\u0000a\u0016\u0001\u0000\u0000\u0000b`\u0001\u0000\u0000\u0000"+
		"cd\u0005#\u0000\u0000dh\u0007\u0001\u0000\u0000eg\u0007\u0002\u0000\u0000"+
		"fe\u0001\u0000\u0000\u0000gj\u0001\u0000\u0000\u0000hf\u0001\u0000\u0000"+
		"\u0000hi\u0001\u0000\u0000\u0000ik\u0001\u0000\u0000\u0000jh\u0001\u0000"+
		"\u0000\u0000kl\u0007\u0001\u0000\u0000l\u0018\u0001\u0000\u0000\u0000"+
		"mn\u0007\u0004\u0000\u0000n\u001a\u0001\u0000\u0000\u0000op\u0007\u0005"+
		"\u0000\u0000p\u001c\u0001\u0000\u0000\u0000qr\u0005\"\u0000\u0000r\u001e"+
		"\u0001\u0000\u0000\u0000st\u0007\u0006\u0000\u0000tu\u0001\u0000\u0000"+
		"\u0000uv\u0006\u000f\u0000\u0000v \u0001\u0000\u0000\u0000wy\u0007\u0007"+
		"\u0000\u0000xw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000zx\u0001"+
		"\u0000\u0000\u0000z{\u0001\u0000\u0000\u0000{\"\u0001\u0000\u0000\u0000"+
		"|}\u0005,\u0000\u0000}$\u0001\u0000\u0000\u0000\f\u0000)+48KQTY`hz\u0001"+
		"\u0006\u0000\u0000";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}