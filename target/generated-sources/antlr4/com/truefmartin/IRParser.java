// Generated from com/truefmartin/IRParser.g4 by ANTLR 4.12.0
package com.truefmartin;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast", "CheckReturnValue"})
public class IRParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.12.0", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		JS=1, JS_TYPE=2, TAG_START=3, TAG_END=4, TAG_END_EXLAM=5, TAG_START_OPEN=6, 
		COMMENT_START=7, URL=8, EMAIL=9, FLOAT=10, PUNCT=11, INTEGER=12, PLAIN_TEXT=13, 
		TEXT_WITH_PUNCTUATION=14, NEW_LINE=15, WS=16, OTHER=17, JS_END=18, OTHER_JS=19, 
		EXLAM_END=20, EXLAM_CONTENT_SKIP=21, COMMENT_END=22, COMMENT_CONTENT_SKIP=23, 
		TAG_START_CLOSE=24, IN_TAG_URL=25, CONTENT_START_IGNORE=26, CONTENT_START=27, 
		OTHERS=28, CONTENT_CLOSE=29, CONTENT_FLOAT=30, CONTENT_INTEGER=31, CONTENT_EMAIL=32, 
		CONTENT_TEXT=33, CONTENT_PUNCTUATION=34, CONTENT_WS=35, TEXT_WITH_PUNCUATION=36;
	public static final int
		RULE_document = 0, RULE_html = 1, RULE_tagStart = 2, RULE_noTagStart = 3, 
		RULE_outOfTag = 4, RULE_outOfTagDirty = 5, RULE_outOfTagClean = 6, RULE_internalTag = 7, 
		RULE_contentText = 8, RULE_contentOptions = 9, RULE_handleInteger = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "html", "tagStart", "noTagStart", "outOfTag", "outOfTagDirty", 
			"outOfTagClean", "internalTag", "contentText", "contentOptions", "handleInteger"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'<script>'", null, null, null, null, null, "'<!--'", null, null, 
			null, null, null, null, null, null, null, null, "'</script>'", null, 
			"'>'", null, null, null, null, null, null, null, null, "'\"'", null, 
			null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "JS", "JS_TYPE", "TAG_START", "TAG_END", "TAG_END_EXLAM", "TAG_START_OPEN", 
			"COMMENT_START", "URL", "EMAIL", "FLOAT", "PUNCT", "INTEGER", "PLAIN_TEXT", 
			"TEXT_WITH_PUNCTUATION", "NEW_LINE", "WS", "OTHER", "JS_END", "OTHER_JS", 
			"EXLAM_END", "EXLAM_CONTENT_SKIP", "COMMENT_END", "COMMENT_CONTENT_SKIP", 
			"TAG_START_CLOSE", "IN_TAG_URL", "CONTENT_START_IGNORE", "CONTENT_START", 
			"OTHERS", "CONTENT_CLOSE", "CONTENT_FLOAT", "CONTENT_INTEGER", "CONTENT_EMAIL", 
			"CONTENT_TEXT", "CONTENT_PUNCTUATION", "CONTENT_WS", "TEXT_WITH_PUNCUATION"
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
	public String getGrammarFileName() { return "IRParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public IRParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@SuppressWarnings("CheckReturnValue")
	public static class DocumentContext extends ParserRuleContext {
		public TerminalNode EOF() { return getToken(IRParser.EOF, 0); }
		public List<HtmlContext> html() {
			return getRuleContexts(HtmlContext.class);
		}
		public HtmlContext html(int i) {
			return getRuleContext(HtmlContext.class,i);
		}
		public DocumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_document; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterDocument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitDocument(this);
		}
	}

	public final DocumentContext document() throws RecognitionException {
		DocumentContext _localctx = new DocumentContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_document);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(23); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(22);
				html();
				}
				}
				setState(25); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70867006296L) != 0) );
			setState(27);
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
	public static class HtmlContext extends ParserRuleContext {
		public TagStartContext tagStart() {
			return getRuleContext(TagStartContext.class,0);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(IRParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(IRParser.NEW_LINE, i);
		}
		public NoTagStartContext noTagStart() {
			return getRuleContext(NoTagStartContext.class,0);
		}
		public HtmlContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_html; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterHtml(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitHtml(this);
		}
	}

	public final HtmlContext html() throws RecognitionException {
		HtmlContext _localctx = new HtmlContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_html);
		try {
			int _alt;
			setState(46);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_START:
			case TAG_START_OPEN:
				enterOuterAlt(_localctx, 1);
				{
				setState(29);
				tagStart();
				setState(31); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(30);
						match(NEW_LINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(33); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,1,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case TAG_END:
			case URL:
			case EMAIL:
			case INTEGER:
			case PLAIN_TEXT:
			case CONTENT_INTEGER:
			case TEXT_WITH_PUNCUATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				noTagStart();
				setState(37); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(36);
						match(NEW_LINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(39); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case NEW_LINE:
				enterOuterAlt(_localctx, 3);
				{
				setState(42); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(41);
						match(NEW_LINE);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(44); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
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
	public static class TagStartContext extends ParserRuleContext {
		public List<TerminalNode> TAG_START() { return getTokens(IRParser.TAG_START); }
		public TerminalNode TAG_START(int i) {
			return getToken(IRParser.TAG_START, i);
		}
		public List<InternalTagContext> internalTag() {
			return getRuleContexts(InternalTagContext.class);
		}
		public InternalTagContext internalTag(int i) {
			return getRuleContext(InternalTagContext.class,i);
		}
		public List<OutOfTagContext> outOfTag() {
			return getRuleContexts(OutOfTagContext.class);
		}
		public OutOfTagContext outOfTag(int i) {
			return getRuleContext(OutOfTagContext.class,i);
		}
		public List<TerminalNode> TAG_END() { return getTokens(IRParser.TAG_END); }
		public TerminalNode TAG_END(int i) {
			return getToken(IRParser.TAG_END, i);
		}
		public TagStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tagStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterTagStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitTagStart(this);
		}
	}

	public final TagStartContext tagStart() throws RecognitionException {
		TagStartContext _localctx = new TagStartContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_tagStart);
		try {
			int _alt;
			setState(84);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(49); 
				_errHandler.sync(this);
				_alt = 1+1;
				do {
					switch (_alt) {
					case 1+1:
						{
						{
						setState(48);
						match(TAG_START);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(51); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(53);
						internalTag();
						}
						} 
					}
					setState(58);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				}
				setState(63);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						setState(61);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case URL:
						case EMAIL:
						case INTEGER:
						case PLAIN_TEXT:
						case CONTENT_INTEGER:
						case TEXT_WITH_PUNCUATION:
							{
							setState(59);
							outOfTag();
							}
							break;
						case TAG_END:
							{
							setState(60);
							match(TAG_END);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(65);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,8,_ctx);
				}
				}
				break;
			case TAG_START_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(67); 
				_errHandler.sync(this);
				_alt = 1+1;
				do {
					switch (_alt) {
					case 1+1:
						{
						{
						setState(66);
						internalTag();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(69); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(74);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(71);
						match(TAG_START);
						}
						} 
					}
					setState(76);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,10,_ctx);
				}
				setState(81);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						setState(79);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case URL:
						case EMAIL:
						case INTEGER:
						case PLAIN_TEXT:
						case CONTENT_INTEGER:
						case TEXT_WITH_PUNCUATION:
							{
							setState(77);
							outOfTag();
							}
							break;
						case TAG_END:
							{
							setState(78);
							match(TAG_END);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(83);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
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
	public static class NoTagStartContext extends ParserRuleContext {
		public List<OutOfTagContext> outOfTag() {
			return getRuleContexts(OutOfTagContext.class);
		}
		public OutOfTagContext outOfTag(int i) {
			return getRuleContext(OutOfTagContext.class,i);
		}
		public List<TerminalNode> TAG_START() { return getTokens(IRParser.TAG_START); }
		public TerminalNode TAG_START(int i) {
			return getToken(IRParser.TAG_START, i);
		}
		public List<TerminalNode> TAG_END() { return getTokens(IRParser.TAG_END); }
		public TerminalNode TAG_END(int i) {
			return getToken(IRParser.TAG_END, i);
		}
		public NoTagStartContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_noTagStart; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterNoTagStart(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitNoTagStart(this);
		}
	}

	public final NoTagStartContext noTagStart() throws RecognitionException {
		NoTagStartContext _localctx = new NoTagStartContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_noTagStart);
		int _la;
		try {
			setState(99);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
			case EMAIL:
			case INTEGER:
			case PLAIN_TEXT:
			case CONTENT_INTEGER:
			case TEXT_WITH_PUNCUATION:
				enterOuterAlt(_localctx, 1);
				{
				setState(86);
				outOfTag();
				setState(90); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(90);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case URL:
					case EMAIL:
					case INTEGER:
					case PLAIN_TEXT:
					case CONTENT_INTEGER:
					case TEXT_WITH_PUNCUATION:
						{
						setState(87);
						outOfTag();
						}
						break;
					case TAG_START:
						{
						setState(88);
						match(TAG_START);
						}
						break;
					case TAG_END:
						{
						setState(89);
						match(TAG_END);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(92); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 70866973464L) != 0) );
				}
				break;
			case TAG_END:
				enterOuterAlt(_localctx, 2);
				{
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(94);
					match(TAG_END);
					}
					}
					setState(97); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TAG_END );
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
	public static class OutOfTagContext extends ParserRuleContext {
		public OutOfTagCleanContext outOfTagClean() {
			return getRuleContext(OutOfTagCleanContext.class,0);
		}
		public OutOfTagDirtyContext outOfTagDirty() {
			return getRuleContext(OutOfTagDirtyContext.class,0);
		}
		public HandleIntegerContext handleInteger() {
			return getRuleContext(HandleIntegerContext.class,0);
		}
		public OutOfTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outOfTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterOutOfTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitOutOfTag(this);
		}
	}

	public final OutOfTagContext outOfTag() throws RecognitionException {
		OutOfTagContext _localctx = new OutOfTagContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_outOfTag);
		try {
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
			case EMAIL:
			case PLAIN_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(101);
				outOfTagClean();
				}
				break;
			case TEXT_WITH_PUNCUATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(102);
				outOfTagDirty();
				}
				break;
			case INTEGER:
			case CONTENT_INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(103);
				handleInteger();
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
	public static class OutOfTagDirtyContext extends ParserRuleContext {
		public TerminalNode TEXT_WITH_PUNCUATION() { return getToken(IRParser.TEXT_WITH_PUNCUATION, 0); }
		public OutOfTagDirtyContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outOfTagDirty; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterOutOfTagDirty(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitOutOfTagDirty(this);
		}
	}

	public final OutOfTagDirtyContext outOfTagDirty() throws RecognitionException {
		OutOfTagDirtyContext _localctx = new OutOfTagDirtyContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_outOfTagDirty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(106);
			match(TEXT_WITH_PUNCUATION);
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
	public static class OutOfTagCleanContext extends ParserRuleContext {
		public TerminalNode PLAIN_TEXT() { return getToken(IRParser.PLAIN_TEXT, 0); }
		public TerminalNode EMAIL() { return getToken(IRParser.EMAIL, 0); }
		public TerminalNode URL() { return getToken(IRParser.URL, 0); }
		public OutOfTagCleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outOfTagClean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterOutOfTagClean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitOutOfTagClean(this);
		}
	}

	public final OutOfTagCleanContext outOfTagClean() throws RecognitionException {
		OutOfTagCleanContext _localctx = new OutOfTagCleanContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_outOfTagClean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 8960L) != 0)) ) {
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
	public static class InternalTagContext extends ParserRuleContext {
		public TerminalNode TAG_START_OPEN() { return getToken(IRParser.TAG_START_OPEN, 0); }
		public TerminalNode TAG_START_CLOSE() { return getToken(IRParser.TAG_START_CLOSE, 0); }
		public ContentTextContext contentText() {
			return getRuleContext(ContentTextContext.class,0);
		}
		public InternalTagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_internalTag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterInternalTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitInternalTag(this);
		}
	}

	public final InternalTagContext internalTag() throws RecognitionException {
		InternalTagContext _localctx = new InternalTagContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_internalTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(110);
			match(TAG_START_OPEN);
			setState(112);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN_TAG_URL || _la==CONTENT_START) {
				{
				setState(111);
				contentText();
				}
			}

			setState(114);
			match(TAG_START_CLOSE);
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
	public static class ContentTextContext extends ParserRuleContext {
		public TerminalNode CONTENT_START() { return getToken(IRParser.CONTENT_START, 0); }
		public TerminalNode CONTENT_CLOSE() { return getToken(IRParser.CONTENT_CLOSE, 0); }
		public List<ContentOptionsContext> contentOptions() {
			return getRuleContexts(ContentOptionsContext.class);
		}
		public ContentOptionsContext contentOptions(int i) {
			return getRuleContext(ContentOptionsContext.class,i);
		}
		public List<TerminalNode> CONTENT_WS() { return getTokens(IRParser.CONTENT_WS); }
		public TerminalNode CONTENT_WS(int i) {
			return getToken(IRParser.CONTENT_WS, i);
		}
		public TerminalNode IN_TAG_URL() { return getToken(IRParser.IN_TAG_URL, 0); }
		public ContentTextContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contentText; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterContentText(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitContentText(this);
		}
	}

	public final ContentTextContext contentText() throws RecognitionException {
		ContentTextContext _localctx = new ContentTextContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_contentText);
		int _la;
		try {
			setState(125);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTENT_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(116);
				match(CONTENT_START);
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(119);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INTEGER:
					case CONTENT_INTEGER:
					case CONTENT_EMAIL:
					case CONTENT_TEXT:
						{
						setState(117);
						contentOptions();
						}
						break;
					case CONTENT_WS:
						{
						setState(118);
						match(CONTENT_WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 49392128000L) != 0) );
				setState(123);
				match(CONTENT_CLOSE);
				}
				break;
			case IN_TAG_URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(124);
				match(IN_TAG_URL);
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
	public static class ContentOptionsContext extends ParserRuleContext {
		public TerminalNode CONTENT_TEXT() { return getToken(IRParser.CONTENT_TEXT, 0); }
		public HandleIntegerContext handleInteger() {
			return getRuleContext(HandleIntegerContext.class,0);
		}
		public TerminalNode CONTENT_EMAIL() { return getToken(IRParser.CONTENT_EMAIL, 0); }
		public ContentOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_contentOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterContentOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitContentOptions(this);
		}
	}

	public final ContentOptionsContext contentOptions() throws RecognitionException {
		ContentOptionsContext _localctx = new ContentOptionsContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_contentOptions);
		try {
			setState(130);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTENT_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(127);
				match(CONTENT_TEXT);
				}
				break;
			case INTEGER:
			case CONTENT_INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(128);
				handleInteger();
				}
				break;
			case CONTENT_EMAIL:
				enterOuterAlt(_localctx, 3);
				{
				setState(129);
				match(CONTENT_EMAIL);
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
	public static class HandleIntegerContext extends ParserRuleContext {
		public TerminalNode INTEGER() { return getToken(IRParser.INTEGER, 0); }
		public TerminalNode CONTENT_INTEGER() { return getToken(IRParser.CONTENT_INTEGER, 0); }
		public HandleIntegerContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_handleInteger; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterHandleInteger(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitHandleInteger(this);
		}
	}

	public final HandleIntegerContext handleInteger() throws RecognitionException {
		HandleIntegerContext _localctx = new HandleIntegerContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_handleInteger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(132);
			_la = _input.LA(1);
			if ( !(_la==INTEGER || _la==CONTENT_INTEGER) ) {
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

	public static final String _serializedATN =
		"\u0004\u0001$\u0087\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002"+
		"\u0002\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002"+
		"\u0005\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002"+
		"\b\u0007\b\u0002\t\u0007\t\u0002\n\u0007\n\u0001\u0000\u0004\u0000\u0018"+
		"\b\u0000\u000b\u0000\f\u0000\u0019\u0001\u0000\u0001\u0000\u0001\u0001"+
		"\u0001\u0001\u0004\u0001 \b\u0001\u000b\u0001\f\u0001!\u0001\u0001\u0001"+
		"\u0001\u0004\u0001&\b\u0001\u000b\u0001\f\u0001\'\u0001\u0001\u0004\u0001"+
		"+\b\u0001\u000b\u0001\f\u0001,\u0003\u0001/\b\u0001\u0001\u0002\u0004"+
		"\u00022\b\u0002\u000b\u0002\f\u00023\u0001\u0002\u0005\u00027\b\u0002"+
		"\n\u0002\f\u0002:\t\u0002\u0001\u0002\u0001\u0002\u0005\u0002>\b\u0002"+
		"\n\u0002\f\u0002A\t\u0002\u0001\u0002\u0004\u0002D\b\u0002\u000b\u0002"+
		"\f\u0002E\u0001\u0002\u0005\u0002I\b\u0002\n\u0002\f\u0002L\t\u0002\u0001"+
		"\u0002\u0001\u0002\u0005\u0002P\b\u0002\n\u0002\f\u0002S\t\u0002\u0003"+
		"\u0002U\b\u0002\u0001\u0003\u0001\u0003\u0001\u0003\u0001\u0003\u0004"+
		"\u0003[\b\u0003\u000b\u0003\f\u0003\\\u0001\u0003\u0004\u0003`\b\u0003"+
		"\u000b\u0003\f\u0003a\u0003\u0003d\b\u0003\u0001\u0004\u0001\u0004\u0001"+
		"\u0004\u0003\u0004i\b\u0004\u0001\u0005\u0001\u0005\u0001\u0006\u0001"+
		"\u0006\u0001\u0007\u0001\u0007\u0003\u0007q\b\u0007\u0001\u0007\u0001"+
		"\u0007\u0001\b\u0001\b\u0001\b\u0004\bx\b\b\u000b\b\f\by\u0001\b\u0001"+
		"\b\u0003\b~\b\b\u0001\t\u0001\t\u0001\t\u0003\t\u0083\b\t\u0001\n\u0001"+
		"\n\u0001\n\u000638?EJQ\u0000\u000b\u0000\u0002\u0004\u0006\b\n\f\u000e"+
		"\u0010\u0012\u0014\u0000\u0002\u0002\u0000\b\t\r\r\u0002\u0000\f\f\u001f"+
		"\u001f\u0097\u0000\u0017\u0001\u0000\u0000\u0000\u0002.\u0001\u0000\u0000"+
		"\u0000\u0004T\u0001\u0000\u0000\u0000\u0006c\u0001\u0000\u0000\u0000\b"+
		"h\u0001\u0000\u0000\u0000\nj\u0001\u0000\u0000\u0000\fl\u0001\u0000\u0000"+
		"\u0000\u000en\u0001\u0000\u0000\u0000\u0010}\u0001\u0000\u0000\u0000\u0012"+
		"\u0082\u0001\u0000\u0000\u0000\u0014\u0084\u0001\u0000\u0000\u0000\u0016"+
		"\u0018\u0003\u0002\u0001\u0000\u0017\u0016\u0001\u0000\u0000\u0000\u0018"+
		"\u0019\u0001\u0000\u0000\u0000\u0019\u0017\u0001\u0000\u0000\u0000\u0019"+
		"\u001a\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000\u0000\u0000\u001b"+
		"\u001c\u0005\u0000\u0000\u0001\u001c\u0001\u0001\u0000\u0000\u0000\u001d"+
		"\u001f\u0003\u0004\u0002\u0000\u001e \u0005\u000f\u0000\u0000\u001f\u001e"+
		"\u0001\u0000\u0000\u0000 !\u0001\u0000\u0000\u0000!\u001f\u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"/\u0001\u0000\u0000\u0000#%\u0003"+
		"\u0006\u0003\u0000$&\u0005\u000f\u0000\u0000%$\u0001\u0000\u0000\u0000"+
		"&\'\u0001\u0000\u0000\u0000\'%\u0001\u0000\u0000\u0000\'(\u0001\u0000"+
		"\u0000\u0000(/\u0001\u0000\u0000\u0000)+\u0005\u000f\u0000\u0000*)\u0001"+
		"\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,*\u0001\u0000\u0000\u0000"+
		",-\u0001\u0000\u0000\u0000-/\u0001\u0000\u0000\u0000.\u001d\u0001\u0000"+
		"\u0000\u0000.#\u0001\u0000\u0000\u0000.*\u0001\u0000\u0000\u0000/\u0003"+
		"\u0001\u0000\u0000\u000002\u0005\u0003\u0000\u000010\u0001\u0000\u0000"+
		"\u000023\u0001\u0000\u0000\u000034\u0001\u0000\u0000\u000031\u0001\u0000"+
		"\u0000\u000048\u0001\u0000\u0000\u000057\u0003\u000e\u0007\u000065\u0001"+
		"\u0000\u0000\u00007:\u0001\u0000\u0000\u000089\u0001\u0000\u0000\u0000"+
		"86\u0001\u0000\u0000\u00009?\u0001\u0000\u0000\u0000:8\u0001\u0000\u0000"+
		"\u0000;>\u0003\b\u0004\u0000<>\u0005\u0004\u0000\u0000=;\u0001\u0000\u0000"+
		"\u0000=<\u0001\u0000\u0000\u0000>A\u0001\u0000\u0000\u0000?@\u0001\u0000"+
		"\u0000\u0000?=\u0001\u0000\u0000\u0000@U\u0001\u0000\u0000\u0000A?\u0001"+
		"\u0000\u0000\u0000BD\u0003\u000e\u0007\u0000CB\u0001\u0000\u0000\u0000"+
		"DE\u0001\u0000\u0000\u0000EF\u0001\u0000\u0000\u0000EC\u0001\u0000\u0000"+
		"\u0000FJ\u0001\u0000\u0000\u0000GI\u0005\u0003\u0000\u0000HG\u0001\u0000"+
		"\u0000\u0000IL\u0001\u0000\u0000\u0000JK\u0001\u0000\u0000\u0000JH\u0001"+
		"\u0000\u0000\u0000KQ\u0001\u0000\u0000\u0000LJ\u0001\u0000\u0000\u0000"+
		"MP\u0003\b\u0004\u0000NP\u0005\u0004\u0000\u0000OM\u0001\u0000\u0000\u0000"+
		"ON\u0001\u0000\u0000\u0000PS\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000RU\u0001\u0000\u0000\u0000SQ\u0001\u0000"+
		"\u0000\u0000T1\u0001\u0000\u0000\u0000TC\u0001\u0000\u0000\u0000U\u0005"+
		"\u0001\u0000\u0000\u0000VZ\u0003\b\u0004\u0000W[\u0003\b\u0004\u0000X"+
		"[\u0005\u0003\u0000\u0000Y[\u0005\u0004\u0000\u0000ZW\u0001\u0000\u0000"+
		"\u0000ZX\u0001\u0000\u0000\u0000ZY\u0001\u0000\u0000\u0000[\\\u0001\u0000"+
		"\u0000\u0000\\Z\u0001\u0000\u0000\u0000\\]\u0001\u0000\u0000\u0000]d\u0001"+
		"\u0000\u0000\u0000^`\u0005\u0004\u0000\u0000_^\u0001\u0000\u0000\u0000"+
		"`a\u0001\u0000\u0000\u0000a_\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000"+
		"\u0000bd\u0001\u0000\u0000\u0000cV\u0001\u0000\u0000\u0000c_\u0001\u0000"+
		"\u0000\u0000d\u0007\u0001\u0000\u0000\u0000ei\u0003\f\u0006\u0000fi\u0003"+
		"\n\u0005\u0000gi\u0003\u0014\n\u0000he\u0001\u0000\u0000\u0000hf\u0001"+
		"\u0000\u0000\u0000hg\u0001\u0000\u0000\u0000i\t\u0001\u0000\u0000\u0000"+
		"jk\u0005$\u0000\u0000k\u000b\u0001\u0000\u0000\u0000lm\u0007\u0000\u0000"+
		"\u0000m\r\u0001\u0000\u0000\u0000np\u0005\u0006\u0000\u0000oq\u0003\u0010"+
		"\b\u0000po\u0001\u0000\u0000\u0000pq\u0001\u0000\u0000\u0000qr\u0001\u0000"+
		"\u0000\u0000rs\u0005\u0018\u0000\u0000s\u000f\u0001\u0000\u0000\u0000"+
		"tw\u0005\u001b\u0000\u0000ux\u0003\u0012\t\u0000vx\u0005#\u0000\u0000"+
		"wu\u0001\u0000\u0000\u0000wv\u0001\u0000\u0000\u0000xy\u0001\u0000\u0000"+
		"\u0000yw\u0001\u0000\u0000\u0000yz\u0001\u0000\u0000\u0000z{\u0001\u0000"+
		"\u0000\u0000{~\u0005\u001d\u0000\u0000|~\u0005\u0019\u0000\u0000}t\u0001"+
		"\u0000\u0000\u0000}|\u0001\u0000\u0000\u0000~\u0011\u0001\u0000\u0000"+
		"\u0000\u007f\u0083\u0005!\u0000\u0000\u0080\u0083\u0003\u0014\n\u0000"+
		"\u0081\u0083\u0005 \u0000\u0000\u0082\u007f\u0001\u0000\u0000\u0000\u0082"+
		"\u0080\u0001\u0000\u0000\u0000\u0082\u0081\u0001\u0000\u0000\u0000\u0083"+
		"\u0013\u0001\u0000\u0000\u0000\u0084\u0085\u0007\u0001\u0000\u0000\u0085"+
		"\u0015\u0001\u0000\u0000\u0000\u0018\u0019!\',.38=?EJOQTZ\\achpwy}\u0082";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}