package antlr;// Generated from /Users/kainingxin/IdeaProjects/tp-model-check-ctl/src/main/resources/ctl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ctlLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, IMPLY=3, NOT=4, TRUE=5, FALSE=6, A=7, E=8, U=9, AX=10, AG=11, 
		AF=12, EF=13, EG=14, EX=15, LEFT_BRACKTET=16, RIGHT_BRACKTET=17, ATOM=18;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"AND", "OR", "IMPLY", "NOT", "TRUE", "FALSE", "A", "E", "U", "AX", "AG", 
			"AF", "EF", "EG", "EX", "LEFT_BRACKTET", "RIGHT_BRACKTET", "ATOM"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'&&'", "'||'", "'=>'", "'^'", "'true'", "'false'", "'A'", "'E'", 
			"'U'", "'AX'", "'AG'", "'AF'", "'EF'", "'EG'", "'EX'", "'('", "')'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "AND", "OR", "IMPLY", "NOT", "TRUE", "FALSE", "A", "E", "U", "AX", 
			"AG", "AF", "EF", "EG", "EX", "LEFT_BRACKTET", "RIGHT_BRACKTET", "ATOM"
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


	public ctlLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "ctl.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\24^\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\3\2\3\3\3\3\3\3\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\7\3\7\3\7\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13\3"+
		"\f\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3\16\3\17\3\17\3\17\3\20\3\20\3\20\3"+
		"\21\3\21\3\22\3\22\3\23\6\23[\n\23\r\23\16\23\\\2\2\24\3\3\5\4\7\5\t\6"+
		"\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24"+
		"\3\2\3\3\2c|\2^\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3"+
		"\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2"+
		"\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3"+
		"\2\2\2\2#\3\2\2\2\2%\3\2\2\2\3\'\3\2\2\2\5*\3\2\2\2\7-\3\2\2\2\t\60\3"+
		"\2\2\2\13\62\3\2\2\2\r\67\3\2\2\2\17=\3\2\2\2\21?\3\2\2\2\23A\3\2\2\2"+
		"\25C\3\2\2\2\27F\3\2\2\2\31I\3\2\2\2\33L\3\2\2\2\35O\3\2\2\2\37R\3\2\2"+
		"\2!U\3\2\2\2#W\3\2\2\2%Z\3\2\2\2\'(\7(\2\2()\7(\2\2)\4\3\2\2\2*+\7~\2"+
		"\2+,\7~\2\2,\6\3\2\2\2-.\7?\2\2./\7@\2\2/\b\3\2\2\2\60\61\7`\2\2\61\n"+
		"\3\2\2\2\62\63\7v\2\2\63\64\7t\2\2\64\65\7w\2\2\65\66\7g\2\2\66\f\3\2"+
		"\2\2\678\7h\2\289\7c\2\29:\7n\2\2:;\7u\2\2;<\7g\2\2<\16\3\2\2\2=>\7C\2"+
		"\2>\20\3\2\2\2?@\7G\2\2@\22\3\2\2\2AB\7W\2\2B\24\3\2\2\2CD\7C\2\2DE\7"+
		"Z\2\2E\26\3\2\2\2FG\7C\2\2GH\7I\2\2H\30\3\2\2\2IJ\7C\2\2JK\7H\2\2K\32"+
		"\3\2\2\2LM\7G\2\2MN\7H\2\2N\34\3\2\2\2OP\7G\2\2PQ\7I\2\2Q\36\3\2\2\2R"+
		"S\7G\2\2ST\7Z\2\2T \3\2\2\2UV\7*\2\2V\"\3\2\2\2WX\7+\2\2X$\3\2\2\2Y[\t"+
		"\2\2\2ZY\3\2\2\2[\\\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]&\3\2\2\2\4\2\\\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}