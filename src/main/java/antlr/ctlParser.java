package antlr;// Generated from /Users/kainingxin/IdeaProjects/tp-model-check-ctl/src/main/resources/ctl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class ctlParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.9.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		AND=1, OR=2, IMPLY=3, NOT=4, TRUE=5, FALSE=6, A=7, E=8, U=9, AX=10, AG=11, 
		AF=12, EF=13, EG=14, EX=15, LEFT_BRACKTET=16, RIGHT_BRACKTET=17, ATOM=18;
	public static final int
		RULE_expression = 0;
	private static String[] makeRuleNames() {
		return new String[] {
			"expression"
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

	@Override
	public String getGrammarFileName() { return "ctl.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public ctlParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ExpressionContext extends ParserRuleContext {
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
	 
		public ExpressionContext() { }
		public void copyFrom(ExpressionContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class FalseHandlerContext extends ExpressionContext {
		public TerminalNode FALSE() { return getToken(ctlParser.FALSE, 0); }
		public FalseHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterFalseHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitFalseHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitFalseHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AtomHandlerContext extends ExpressionContext {
		public TerminalNode ATOM() { return getToken(ctlParser.ATOM, 0); }
		public AtomHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterAtomHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitAtomHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitAtomHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AndHandlerContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode AND() { return getToken(ctlParser.AND, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AndHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterAndHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitAndHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitAndHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExHandlerContext extends ExpressionContext {
		public ExpressionContext al;
		public TerminalNode EX() { return getToken(ctlParser.EX, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public ExHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterExHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitExHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitExHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TrueHandlerContext extends ExpressionContext {
		public TerminalNode TRUE() { return getToken(ctlParser.TRUE, 0); }
		public TrueHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterTrueHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitTrueHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitTrueHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AxHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode AX() { return getToken(ctlParser.AX, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AxHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterAxHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitAxHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitAxHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AfHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode AF() { return getToken(ctlParser.AF, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AfHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterAfHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitAfHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitAfHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AuHandlerContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode A() { return getToken(ctlParser.A, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode U() { return getToken(ctlParser.U, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public AuHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterAuHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitAuHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitAuHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class AgHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode AG() { return getToken(ctlParser.AG, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AgHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterAgHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitAgHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitAgHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NotHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode NOT() { return getToken(ctlParser.NOT, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public NotHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterNotHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitNotHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitNotHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrHandlerContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode OR() { return getToken(ctlParser.OR, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public OrHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterOrHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitOrHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitOrHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EfHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode EF() { return getToken(ctlParser.EF, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EfHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterEfHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitEfHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitEfHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EgHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode EG() { return getToken(ctlParser.EG, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public EgHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterEgHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitEgHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitEgHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class EuHandlerContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode E() { return getToken(ctlParser.E, 0); }
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode U() { return getToken(ctlParser.U, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public EuHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterEuHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitEuHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitEuHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BracketHandlerContext extends ExpressionContext {
		public ExpressionContext val;
		public TerminalNode LEFT_BRACKTET() { return getToken(ctlParser.LEFT_BRACKTET, 0); }
		public TerminalNode RIGHT_BRACKTET() { return getToken(ctlParser.RIGHT_BRACKTET, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public BracketHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterBracketHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitBracketHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitBracketHandler(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ImplyHandlerContext extends ExpressionContext {
		public ExpressionContext left;
		public ExpressionContext right;
		public TerminalNode IMPLY() { return getToken(ctlParser.IMPLY, 0); }
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public ImplyHandlerContext(ExpressionContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).enterImplyHandler(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof ctlListener ) ((ctlListener)listener).exitImplyHandler(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof ctlVisitor ) return ((ctlVisitor<? extends T>)visitor).visitImplyHandler(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		return expression(0);
	}

	private ExpressionContext expression(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExpressionContext _localctx = new ExpressionContext(_ctx, _parentState);
		ExpressionContext _prevctx = _localctx;
		int _startState = 0;
		enterRecursionRule(_localctx, 0, RULE_expression, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case ATOM:
				{
				_localctx = new AtomHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(3);
				match(ATOM);
				}
				break;
			case FALSE:
				{
				_localctx = new FalseHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(4);
				match(FALSE);
				}
				break;
			case TRUE:
				{
				_localctx = new TrueHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(5);
				match(TRUE);
				}
				break;
			case LEFT_BRACKTET:
				{
				_localctx = new BracketHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(6);
				match(LEFT_BRACKTET);
				setState(7);
				((BracketHandlerContext)_localctx).val = expression(0);
				setState(8);
				match(RIGHT_BRACKTET);
				}
				break;
			case NOT:
				{
				_localctx = new NotHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(10);
				match(NOT);
				setState(11);
				match(LEFT_BRACKTET);
				setState(12);
				((NotHandlerContext)_localctx).val = expression(0);
				setState(13);
				match(RIGHT_BRACKTET);
				}
				break;
			case AX:
				{
				_localctx = new AxHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(15);
				match(AX);
				setState(16);
				match(LEFT_BRACKTET);
				setState(17);
				((AxHandlerContext)_localctx).val = expression(0);
				setState(18);
				match(RIGHT_BRACKTET);
				}
				break;
			case AF:
				{
				_localctx = new AfHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(20);
				match(AF);
				setState(21);
				match(LEFT_BRACKTET);
				setState(22);
				((AfHandlerContext)_localctx).val = expression(0);
				setState(23);
				match(RIGHT_BRACKTET);
				}
				break;
			case AG:
				{
				_localctx = new AgHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(25);
				match(AG);
				setState(26);
				match(LEFT_BRACKTET);
				setState(27);
				((AgHandlerContext)_localctx).val = expression(0);
				setState(28);
				match(RIGHT_BRACKTET);
				}
				break;
			case A:
				{
				_localctx = new AuHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(30);
				match(A);
				setState(31);
				match(LEFT_BRACKTET);
				setState(32);
				((AuHandlerContext)_localctx).left = expression(0);
				setState(33);
				match(U);
				setState(34);
				((AuHandlerContext)_localctx).right = expression(0);
				setState(35);
				match(RIGHT_BRACKTET);
				}
				break;
			case EX:
				{
				_localctx = new ExHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(37);
				match(EX);
				setState(38);
				match(LEFT_BRACKTET);
				setState(39);
				((ExHandlerContext)_localctx).al = expression(0);
				setState(40);
				match(RIGHT_BRACKTET);
				}
				break;
			case EF:
				{
				_localctx = new EfHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(42);
				match(EF);
				setState(43);
				match(LEFT_BRACKTET);
				setState(44);
				((EfHandlerContext)_localctx).val = expression(0);
				setState(45);
				match(RIGHT_BRACKTET);
				}
				break;
			case EG:
				{
				_localctx = new EgHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(47);
				match(EG);
				setState(48);
				match(LEFT_BRACKTET);
				setState(49);
				((EgHandlerContext)_localctx).val = expression(0);
				setState(50);
				match(RIGHT_BRACKTET);
				}
				break;
			case E:
				{
				_localctx = new EuHandlerContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(52);
				match(E);
				setState(53);
				match(LEFT_BRACKTET);
				setState(54);
				((EuHandlerContext)_localctx).left = expression(0);
				setState(55);
				match(U);
				setState(56);
				((EuHandlerContext)_localctx).right = expression(0);
				setState(57);
				match(RIGHT_BRACKTET);
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			_ctx.stop = _input.LT(-1);
			setState(72);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(70);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
					case 1:
						{
						_localctx = new AndHandlerContext(new ExpressionContext(_parentctx, _parentState));
						((AndHandlerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(61);
						if (!(precpred(_ctx, 13))) throw new FailedPredicateException(this, "precpred(_ctx, 13)");
						setState(62);
						match(AND);
						setState(63);
						((AndHandlerContext)_localctx).right = expression(14);
						}
						break;
					case 2:
						{
						_localctx = new OrHandlerContext(new ExpressionContext(_parentctx, _parentState));
						((OrHandlerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(64);
						if (!(precpred(_ctx, 11))) throw new FailedPredicateException(this, "precpred(_ctx, 11)");
						setState(65);
						match(OR);
						setState(66);
						((OrHandlerContext)_localctx).right = expression(12);
						}
						break;
					case 3:
						{
						_localctx = new ImplyHandlerContext(new ExpressionContext(_parentctx, _parentState));
						((ImplyHandlerContext)_localctx).left = _prevctx;
						pushNewRecursionContext(_localctx, _startState, RULE_expression);
						setState(67);
						if (!(precpred(_ctx, 10))) throw new FailedPredicateException(this, "precpred(_ctx, 10)");
						setState(68);
						match(IMPLY);
						setState(69);
						((ImplyHandlerContext)_localctx).right = expression(11);
						}
						break;
					}
					} 
				}
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
		case 0:
			return expression_sempred((ExpressionContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean expression_sempred(ExpressionContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 13);
		case 1:
			return precpred(_ctx, 11);
		case 2:
			return precpred(_ctx, 10);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\24N\4\2\t\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\5\2>\n\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\7\2I\n\2\f\2"+
		"\16\2L\13\2\3\2\2\3\2\3\2\2\2\2[\2=\3\2\2\2\4\5\b\2\1\2\5>\7\24\2\2\6"+
		">\7\b\2\2\7>\7\7\2\2\b\t\7\22\2\2\t\n\5\2\2\2\n\13\7\23\2\2\13>\3\2\2"+
		"\2\f\r\7\6\2\2\r\16\7\22\2\2\16\17\5\2\2\2\17\20\7\23\2\2\20>\3\2\2\2"+
		"\21\22\7\f\2\2\22\23\7\22\2\2\23\24\5\2\2\2\24\25\7\23\2\2\25>\3\2\2\2"+
		"\26\27\7\16\2\2\27\30\7\22\2\2\30\31\5\2\2\2\31\32\7\23\2\2\32>\3\2\2"+
		"\2\33\34\7\r\2\2\34\35\7\22\2\2\35\36\5\2\2\2\36\37\7\23\2\2\37>\3\2\2"+
		"\2 !\7\t\2\2!\"\7\22\2\2\"#\5\2\2\2#$\7\13\2\2$%\5\2\2\2%&\7\23\2\2&>"+
		"\3\2\2\2\'(\7\21\2\2()\7\22\2\2)*\5\2\2\2*+\7\23\2\2+>\3\2\2\2,-\7\17"+
		"\2\2-.\7\22\2\2./\5\2\2\2/\60\7\23\2\2\60>\3\2\2\2\61\62\7\20\2\2\62\63"+
		"\7\22\2\2\63\64\5\2\2\2\64\65\7\23\2\2\65>\3\2\2\2\66\67\7\n\2\2\678\7"+
		"\22\2\289\5\2\2\29:\7\13\2\2:;\5\2\2\2;<\7\23\2\2<>\3\2\2\2=\4\3\2\2\2"+
		"=\6\3\2\2\2=\7\3\2\2\2=\b\3\2\2\2=\f\3\2\2\2=\21\3\2\2\2=\26\3\2\2\2="+
		"\33\3\2\2\2= \3\2\2\2=\'\3\2\2\2=,\3\2\2\2=\61\3\2\2\2=\66\3\2\2\2>J\3"+
		"\2\2\2?@\f\17\2\2@A\7\3\2\2AI\5\2\2\20BC\f\r\2\2CD\7\4\2\2DI\5\2\2\16"+
		"EF\f\f\2\2FG\7\5\2\2GI\5\2\2\rH?\3\2\2\2HB\3\2\2\2HE\3\2\2\2IL\3\2\2\2"+
		"JH\3\2\2\2JK\3\2\2\2K\3\3\2\2\2LJ\3\2\2\2\5=HJ";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}