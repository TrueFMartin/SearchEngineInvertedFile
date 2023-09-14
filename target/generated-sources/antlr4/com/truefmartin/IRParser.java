// Generated from com\truefmartin\IRParser.g4 by ANTLR 4.12.0
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
		TAG_START=1, TAG_END=2, TAG_START_OPEN=3, COMMENT_START=4, URL=5, EMAIL=6, 
		FLOAT=7, PUNCT=8, INTEGER=9, PLAIN_TEXT=10, TEXT_WITH_PUNCTUATION=11, 
		NEW_LINE=12, WS=13, OTHER=14, COMMENT_END=15, COMMENT_CONTENT_SKIP=16, 
		TAG_START_CLOSE=17, IN_TAG_URL=18, CONTENT_START_IGNORE=19, CONTENT_START=20, 
		ATTRIBUTE_IGNORE=21, FILLER=22, TAG_WS=23, AWS=24, CONTENT_CLOSE=25, CONTENT_FLOAT=26, 
		CONTENT_INTEGER=27, CONTENT_EMAIL=28, CONTENT_TEXT=29, CONTENT_PUNCTUATION=30, 
		CONTENT_WS=31, TEXT_WITH_PUNCUATION=32;
	public static final int
		RULE_document = 0, RULE_html = 1, RULE_tagStart = 2, RULE_tag = 3, RULE_noTagStart = 4, 
		RULE_outOfTag = 5, RULE_outOfTagDirty = 6, RULE_outOfTagClean = 7, RULE_internalTag = 8, 
		RULE_contentText = 9, RULE_contentOptions = 10, RULE_handleInteger = 11;
	private static String[] makeRuleNames() {
		return new String[] {
			"document", "html", "tagStart", "tag", "noTagStart", "outOfTag", "outOfTagDirty", 
			"outOfTagClean", "internalTag", "contentText", "contentOptions", "handleInteger"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, null, null, "'<!--'", null, null, null, null, null, null, 
			null, null, null, null, null, null, null, null, null, null, null, null, 
			null, null, "'\"'", null, null, null, null, null, "' '"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "TAG_START", "TAG_END", "TAG_START_OPEN", "COMMENT_START", "URL", 
			"EMAIL", "FLOAT", "PUNCT", "INTEGER", "PLAIN_TEXT", "TEXT_WITH_PUNCTUATION", 
			"NEW_LINE", "WS", "OTHER", "COMMENT_END", "COMMENT_CONTENT_SKIP", "TAG_START_CLOSE", 
			"IN_TAG_URL", "CONTENT_START_IGNORE", "CONTENT_START", "ATTRIBUTE_IGNORE", 
			"FILLER", "TAG_WS", "AWS", "CONTENT_CLOSE", "CONTENT_FLOAT", "CONTENT_INTEGER", 
			"CONTENT_EMAIL", "CONTENT_TEXT", "CONTENT_PUNCTUATION", "CONTENT_WS", 
			"TEXT_WITH_PUNCUATION"
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
			setState(25); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(24);
				html();
				}
				}
				setState(27); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4429190766L) != 0) );
			setState(29);
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
		public NoTagStartContext noTagStart() {
			return getRuleContext(NoTagStartContext.class,0);
		}
		public List<TerminalNode> NEW_LINE() { return getTokens(IRParser.NEW_LINE); }
		public TerminalNode NEW_LINE(int i) {
			return getToken(IRParser.NEW_LINE, i);
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
			enterOuterAlt(_localctx, 1);
			{
			setState(33);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_START:
			case TAG_START_OPEN:
				{
				setState(31);
				tagStart();
				}
				break;
			case TAG_END:
			case URL:
			case EMAIL:
			case INTEGER:
			case PLAIN_TEXT:
			case CONTENT_INTEGER:
			case TEXT_WITH_PUNCUATION:
				{
				setState(32);
				noTagStart();
				}
				break;
			case NEW_LINE:
				break;
			default:
				break;
			}
			setState(36); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(35);
					match(NEW_LINE);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(38); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
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
	public static class TagStartContext extends ParserRuleContext {
		public TagContext tag() {
			return getRuleContext(TagContext.class,0);
		}
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
		int _la;
		try {
			int _alt;
			setState(58);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case TAG_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(41); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(40);
					match(TAG_START);
					}
					}
					setState(43); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==TAG_START );
				setState(45);
				tag();
				}
				break;
			case TAG_START_OPEN:
				enterOuterAlt(_localctx, 2);
				{
				setState(47); 
				_errHandler.sync(this);
				_alt = 1+1;
				do {
					switch (_alt) {
					case 1+1:
						{
						{
						setState(46);
						internalTag();
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(49); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,4,_ctx);
				} while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(55);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						setState(53);
						_errHandler.sync(this);
						switch (_input.LA(1)) {
						case URL:
						case EMAIL:
						case INTEGER:
						case PLAIN_TEXT:
						case CONTENT_INTEGER:
						case TEXT_WITH_PUNCUATION:
							{
							setState(51);
							outOfTag();
							}
							break;
						case TAG_END:
							{
							setState(52);
							match(TAG_END);
							}
							break;
						default:
							throw new NoViableAltException(this);
						}
						} 
					}
					setState(57);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,6,_ctx);
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
	public static class TagContext extends ParserRuleContext {
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
		public TagContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tag; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).enterTag(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof IRParserListener ) ((IRParserListener)listener).exitTag(this);
		}
	}

	public final TagContext tag() throws RecognitionException {
		TagContext _localctx = new TagContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_tag);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(64);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
			while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1+1 ) {
					{
					setState(62);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case URL:
					case EMAIL:
					case INTEGER:
					case PLAIN_TEXT:
					case CONTENT_INTEGER:
					case TEXT_WITH_PUNCUATION:
						{
						setState(60);
						outOfTag();
						}
						break;
					case TAG_END:
						{
						setState(61);
						match(TAG_END);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					} 
				}
				setState(66);
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
		enterRule(_localctx, 8, RULE_noTagStart);
		int _la;
		try {
			int _alt;
			setState(83);
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
				setState(68); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(67);
					outOfTag();
					}
					}
					setState(70); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 4429186656L) != 0) );
				setState(75);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				while ( _alt!=1 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
					if ( _alt==1+1 ) {
						{
						{
						setState(72);
						match(TAG_END);
						}
						} 
					}
					setState(77);
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,11,_ctx);
				}
				}
				break;
			case TAG_END:
				enterOuterAlt(_localctx, 2);
				{
				setState(79); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(78);
					match(TAG_END);
					}
					}
					setState(81); 
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
		enterRule(_localctx, 10, RULE_outOfTag);
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case URL:
			case EMAIL:
			case PLAIN_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(85);
				outOfTagClean();
				}
				break;
			case TEXT_WITH_PUNCUATION:
				enterOuterAlt(_localctx, 2);
				{
				setState(86);
				outOfTagDirty();
				}
				break;
			case INTEGER:
			case CONTENT_INTEGER:
				enterOuterAlt(_localctx, 3);
				{
				setState(87);
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
		enterRule(_localctx, 12, RULE_outOfTagDirty);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
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
		enterRule(_localctx, 14, RULE_outOfTagClean);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & 1120L) != 0)) ) {
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
		enterRule(_localctx, 16, RULE_internalTag);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(94);
			match(TAG_START_OPEN);
			setState(96);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==IN_TAG_URL || _la==CONTENT_START) {
				{
				setState(95);
				contentText();
				}
			}

			setState(98);
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
		enterRule(_localctx, 18, RULE_contentText);
		int _la;
		try {
			setState(109);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTENT_START:
				enterOuterAlt(_localctx, 1);
				{
				setState(100);
				match(CONTENT_START);
				setState(103); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					setState(103);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case INTEGER:
					case CONTENT_INTEGER:
					case CONTENT_EMAIL:
					case CONTENT_TEXT:
						{
						setState(101);
						contentOptions();
						}
						break;
					case CONTENT_WS:
						{
						setState(102);
						match(CONTENT_WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					setState(105); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( (((_la) & ~0x3f) == 0 && ((1L << _la) & 3087008256L) != 0) );
				setState(107);
				match(CONTENT_CLOSE);
				}
				break;
			case IN_TAG_URL:
				enterOuterAlt(_localctx, 2);
				{
				setState(108);
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
		enterRule(_localctx, 20, RULE_contentOptions);
		try {
			setState(114);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case CONTENT_TEXT:
				enterOuterAlt(_localctx, 1);
				{
				setState(111);
				match(CONTENT_TEXT);
				}
				break;
			case INTEGER:
			case CONTENT_INTEGER:
				enterOuterAlt(_localctx, 2);
				{
				setState(112);
				handleInteger();
				}
				break;
			case CONTENT_EMAIL:
				enterOuterAlt(_localctx, 3);
				{
				setState(113);
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
		enterRule(_localctx, 22, RULE_handleInteger);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(116);
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
		"\u0004\u0001 w\u0002\u0000\u0007\u0000\u0002\u0001\u0007\u0001\u0002\u0002"+
		"\u0007\u0002\u0002\u0003\u0007\u0003\u0002\u0004\u0007\u0004\u0002\u0005"+
		"\u0007\u0005\u0002\u0006\u0007\u0006\u0002\u0007\u0007\u0007\u0002\b\u0007"+
		"\b\u0002\t\u0007\t\u0002\n\u0007\n\u0002\u000b\u0007\u000b\u0001\u0000"+
		"\u0004\u0000\u001a\b\u0000\u000b\u0000\f\u0000\u001b\u0001\u0000\u0001"+
		"\u0000\u0001\u0001\u0001\u0001\u0003\u0001\"\b\u0001\u0001\u0001\u0004"+
		"\u0001%\b\u0001\u000b\u0001\f\u0001&\u0001\u0002\u0004\u0002*\b\u0002"+
		"\u000b\u0002\f\u0002+\u0001\u0002\u0001\u0002\u0004\u00020\b\u0002\u000b"+
		"\u0002\f\u00021\u0001\u0002\u0001\u0002\u0005\u00026\b\u0002\n\u0002\f"+
		"\u00029\t\u0002\u0003\u0002;\b\u0002\u0001\u0003\u0001\u0003\u0005\u0003"+
		"?\b\u0003\n\u0003\f\u0003B\t\u0003\u0001\u0004\u0004\u0004E\b\u0004\u000b"+
		"\u0004\f\u0004F\u0001\u0004\u0005\u0004J\b\u0004\n\u0004\f\u0004M\t\u0004"+
		"\u0001\u0004\u0004\u0004P\b\u0004\u000b\u0004\f\u0004Q\u0003\u0004T\b"+
		"\u0004\u0001\u0005\u0001\u0005\u0001\u0005\u0003\u0005Y\b\u0005\u0001"+
		"\u0006\u0001\u0006\u0001\u0007\u0001\u0007\u0001\b\u0001\b\u0003\ba\b"+
		"\b\u0001\b\u0001\b\u0001\t\u0001\t\u0001\t\u0004\th\b\t\u000b\t\f\ti\u0001"+
		"\t\u0001\t\u0003\tn\b\t\u0001\n\u0001\n\u0001\n\u0003\ns\b\n\u0001\u000b"+
		"\u0001\u000b\u0001\u000b\u000417@K\u0000\f\u0000\u0002\u0004\u0006\b\n"+
		"\f\u000e\u0010\u0012\u0014\u0016\u0000\u0002\u0002\u0000\u0005\u0006\n"+
		"\n\u0002\u0000\t\t\u001b\u001b\u0081\u0000\u0019\u0001\u0000\u0000\u0000"+
		"\u0002!\u0001\u0000\u0000\u0000\u0004:\u0001\u0000\u0000\u0000\u0006@"+
		"\u0001\u0000\u0000\u0000\bS\u0001\u0000\u0000\u0000\nX\u0001\u0000\u0000"+
		"\u0000\fZ\u0001\u0000\u0000\u0000\u000e\\\u0001\u0000\u0000\u0000\u0010"+
		"^\u0001\u0000\u0000\u0000\u0012m\u0001\u0000\u0000\u0000\u0014r\u0001"+
		"\u0000\u0000\u0000\u0016t\u0001\u0000\u0000\u0000\u0018\u001a\u0003\u0002"+
		"\u0001\u0000\u0019\u0018\u0001\u0000\u0000\u0000\u001a\u001b\u0001\u0000"+
		"\u0000\u0000\u001b\u0019\u0001\u0000\u0000\u0000\u001b\u001c\u0001\u0000"+
		"\u0000\u0000\u001c\u001d\u0001\u0000\u0000\u0000\u001d\u001e\u0005\u0000"+
		"\u0000\u0001\u001e\u0001\u0001\u0000\u0000\u0000\u001f\"\u0003\u0004\u0002"+
		"\u0000 \"\u0003\b\u0004\u0000!\u001f\u0001\u0000\u0000\u0000! \u0001\u0000"+
		"\u0000\u0000!\"\u0001\u0000\u0000\u0000\"$\u0001\u0000\u0000\u0000#%\u0005"+
		"\f\u0000\u0000$#\u0001\u0000\u0000\u0000%&\u0001\u0000\u0000\u0000&$\u0001"+
		"\u0000\u0000\u0000&\'\u0001\u0000\u0000\u0000\'\u0003\u0001\u0000\u0000"+
		"\u0000(*\u0005\u0001\u0000\u0000)(\u0001\u0000\u0000\u0000*+\u0001\u0000"+
		"\u0000\u0000+)\u0001\u0000\u0000\u0000+,\u0001\u0000\u0000\u0000,-\u0001"+
		"\u0000\u0000\u0000-;\u0003\u0006\u0003\u0000.0\u0003\u0010\b\u0000/.\u0001"+
		"\u0000\u0000\u000001\u0001\u0000\u0000\u000012\u0001\u0000\u0000\u0000"+
		"1/\u0001\u0000\u0000\u000027\u0001\u0000\u0000\u000036\u0003\n\u0005\u0000"+
		"46\u0005\u0002\u0000\u000053\u0001\u0000\u0000\u000054\u0001\u0000\u0000"+
		"\u000069\u0001\u0000\u0000\u000078\u0001\u0000\u0000\u000075\u0001\u0000"+
		"\u0000\u00008;\u0001\u0000\u0000\u000097\u0001\u0000\u0000\u0000:)\u0001"+
		"\u0000\u0000\u0000:/\u0001\u0000\u0000\u0000;\u0005\u0001\u0000\u0000"+
		"\u0000<?\u0003\n\u0005\u0000=?\u0005\u0002\u0000\u0000><\u0001\u0000\u0000"+
		"\u0000>=\u0001\u0000\u0000\u0000?B\u0001\u0000\u0000\u0000@A\u0001\u0000"+
		"\u0000\u0000@>\u0001\u0000\u0000\u0000A\u0007\u0001\u0000\u0000\u0000"+
		"B@\u0001\u0000\u0000\u0000CE\u0003\n\u0005\u0000DC\u0001\u0000\u0000\u0000"+
		"EF\u0001\u0000\u0000\u0000FD\u0001\u0000\u0000\u0000FG\u0001\u0000\u0000"+
		"\u0000GK\u0001\u0000\u0000\u0000HJ\u0005\u0002\u0000\u0000IH\u0001\u0000"+
		"\u0000\u0000JM\u0001\u0000\u0000\u0000KL\u0001\u0000\u0000\u0000KI\u0001"+
		"\u0000\u0000\u0000LT\u0001\u0000\u0000\u0000MK\u0001\u0000\u0000\u0000"+
		"NP\u0005\u0002\u0000\u0000ON\u0001\u0000\u0000\u0000PQ\u0001\u0000\u0000"+
		"\u0000QO\u0001\u0000\u0000\u0000QR\u0001\u0000\u0000\u0000RT\u0001\u0000"+
		"\u0000\u0000SD\u0001\u0000\u0000\u0000SO\u0001\u0000\u0000\u0000T\t\u0001"+
		"\u0000\u0000\u0000UY\u0003\u000e\u0007\u0000VY\u0003\f\u0006\u0000WY\u0003"+
		"\u0016\u000b\u0000XU\u0001\u0000\u0000\u0000XV\u0001\u0000\u0000\u0000"+
		"XW\u0001\u0000\u0000\u0000Y\u000b\u0001\u0000\u0000\u0000Z[\u0005 \u0000"+
		"\u0000[\r\u0001\u0000\u0000\u0000\\]\u0007\u0000\u0000\u0000]\u000f\u0001"+
		"\u0000\u0000\u0000^`\u0005\u0003\u0000\u0000_a\u0003\u0012\t\u0000`_\u0001"+
		"\u0000\u0000\u0000`a\u0001\u0000\u0000\u0000ab\u0001\u0000\u0000\u0000"+
		"bc\u0005\u0011\u0000\u0000c\u0011\u0001\u0000\u0000\u0000dg\u0005\u0014"+
		"\u0000\u0000eh\u0003\u0014\n\u0000fh\u0005\u001f\u0000\u0000ge\u0001\u0000"+
		"\u0000\u0000gf\u0001\u0000\u0000\u0000hi\u0001\u0000\u0000\u0000ig\u0001"+
		"\u0000\u0000\u0000ij\u0001\u0000\u0000\u0000jk\u0001\u0000\u0000\u0000"+
		"kn\u0005\u0019\u0000\u0000ln\u0005\u0012\u0000\u0000md\u0001\u0000\u0000"+
		"\u0000ml\u0001\u0000\u0000\u0000n\u0013\u0001\u0000\u0000\u0000os\u0005"+
		"\u001d\u0000\u0000ps\u0003\u0016\u000b\u0000qs\u0005\u001c\u0000\u0000"+
		"ro\u0001\u0000\u0000\u0000rp\u0001\u0000\u0000\u0000rq\u0001\u0000\u0000"+
		"\u0000s\u0015\u0001\u0000\u0000\u0000tu\u0007\u0001\u0000\u0000u\u0017"+
		"\u0001\u0000\u0000\u0000\u0014\u001b!&+157:>@FKQSX`gimr";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}