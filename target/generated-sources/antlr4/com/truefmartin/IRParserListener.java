// Generated from com/truefmartin/IRParser.g4 by ANTLR 4.12.0
package com.truefmartin;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link IRParser}.
 */
public interface IRParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link IRParser#document}.
	 * @param ctx the parse tree
	 */
	void enterDocument(IRParser.DocumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#document}.
	 * @param ctx the parse tree
	 */
	void exitDocument(IRParser.DocumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#html}.
	 * @param ctx the parse tree
	 */
	void enterHtml(IRParser.HtmlContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#html}.
	 * @param ctx the parse tree
	 */
	void exitHtml(IRParser.HtmlContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#tagStart}.
	 * @param ctx the parse tree
	 */
	void enterTagStart(IRParser.TagStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#tagStart}.
	 * @param ctx the parse tree
	 */
	void exitTagStart(IRParser.TagStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#tag}.
	 * @param ctx the parse tree
	 */
	void enterTag(IRParser.TagContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#tag}.
	 * @param ctx the parse tree
	 */
	void exitTag(IRParser.TagContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#noTagStart}.
	 * @param ctx the parse tree
	 */
	void enterNoTagStart(IRParser.NoTagStartContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#noTagStart}.
	 * @param ctx the parse tree
	 */
	void exitNoTagStart(IRParser.NoTagStartContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#outOfTag}.
	 * @param ctx the parse tree
	 */
	void enterOutOfTag(IRParser.OutOfTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#outOfTag}.
	 * @param ctx the parse tree
	 */
	void exitOutOfTag(IRParser.OutOfTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#outOfTagDirty}.
	 * @param ctx the parse tree
	 */
	void enterOutOfTagDirty(IRParser.OutOfTagDirtyContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#outOfTagDirty}.
	 * @param ctx the parse tree
	 */
	void exitOutOfTagDirty(IRParser.OutOfTagDirtyContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#outOfTagClean}.
	 * @param ctx the parse tree
	 */
	void enterOutOfTagClean(IRParser.OutOfTagCleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#outOfTagClean}.
	 * @param ctx the parse tree
	 */
	void exitOutOfTagClean(IRParser.OutOfTagCleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#internalTag}.
	 * @param ctx the parse tree
	 */
	void enterInternalTag(IRParser.InternalTagContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#internalTag}.
	 * @param ctx the parse tree
	 */
	void exitInternalTag(IRParser.InternalTagContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#contentText}.
	 * @param ctx the parse tree
	 */
	void enterContentText(IRParser.ContentTextContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#contentText}.
	 * @param ctx the parse tree
	 */
	void exitContentText(IRParser.ContentTextContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#contentOptions}.
	 * @param ctx the parse tree
	 */
	void enterContentOptions(IRParser.ContentOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#contentOptions}.
	 * @param ctx the parse tree
	 */
	void exitContentOptions(IRParser.ContentOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link IRParser#handleInteger}.
	 * @param ctx the parse tree
	 */
	void enterHandleInteger(IRParser.HandleIntegerContext ctx);
	/**
	 * Exit a parse tree produced by {@link IRParser#handleInteger}.
	 * @param ctx the parse tree
	 */
	void exitHandleInteger(IRParser.HandleIntegerContext ctx);
}