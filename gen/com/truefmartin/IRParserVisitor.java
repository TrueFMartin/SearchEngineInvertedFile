// Generated from C:/Users/truef/OneDrive - University of Arkansas/School/InfoRet/AntlrHW1/src/main/antlr4/com/truefmartin\IRParser.g4 by ANTLR 4.12.0
package com.truefmartin;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link IRParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface IRParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link IRParser#document}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDocument(IRParser.DocumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#html}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHtml(IRParser.HtmlContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#tagStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTagStart(IRParser.TagStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#tag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTag(IRParser.TagContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#noTagStart}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNoTagStart(IRParser.NoTagStartContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#outOfTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutOfTag(IRParser.OutOfTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#outOfTagDirty}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutOfTagDirty(IRParser.OutOfTagDirtyContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#outOfTagClean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOutOfTagClean(IRParser.OutOfTagCleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#internalTag}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInternalTag(IRParser.InternalTagContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#contentText}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentText(IRParser.ContentTextContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#contentOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitContentOptions(IRParser.ContentOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link IRParser#handleInteger}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHandleInteger(IRParser.HandleIntegerContext ctx);
}