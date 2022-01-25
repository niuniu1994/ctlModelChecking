package antlr;// Generated from /Users/kainingxin/IdeaProjects/tp-model-check-ctl/src/main/resources/ctl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ctlParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ctlVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by the {@code falseHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFalseHandler(ctlParser.FalseHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code atomHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAtomHandler(ctlParser.AtomHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code andHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndHandler(ctlParser.AndHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code exHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExHandler(ctlParser.ExHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code trueHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTrueHandler(ctlParser.TrueHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code axHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAxHandler(ctlParser.AxHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code afHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAfHandler(ctlParser.AfHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code auHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAuHandler(ctlParser.AuHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code agHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAgHandler(ctlParser.AgHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code notHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNotHandler(ctlParser.NotHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code orHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrHandler(ctlParser.OrHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code efHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEfHandler(ctlParser.EfHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code egHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEgHandler(ctlParser.EgHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code euHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEuHandler(ctlParser.EuHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code bracketHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBracketHandler(ctlParser.BracketHandlerContext ctx);
	/**
	 * Visit a parse tree produced by the {@code implyHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitImplyHandler(ctlParser.ImplyHandlerContext ctx);
}