package antlr;// Generated from /Users/kainingxin/IdeaProjects/tp-model-check-ctl/src/main/resources/ctl.g4 by ANTLR 4.9.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ctlParser}.
 */
public interface ctlListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by the {@code falseHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterFalseHandler(ctlParser.FalseHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code falseHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitFalseHandler(ctlParser.FalseHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code atomHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAtomHandler(ctlParser.AtomHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code atomHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAtomHandler(ctlParser.AtomHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code andHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAndHandler(ctlParser.AndHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code andHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAndHandler(ctlParser.AndHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code exHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExHandler(ctlParser.ExHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code exHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExHandler(ctlParser.ExHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code trueHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterTrueHandler(ctlParser.TrueHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code trueHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitTrueHandler(ctlParser.TrueHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code axHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAxHandler(ctlParser.AxHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code axHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAxHandler(ctlParser.AxHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code afHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAfHandler(ctlParser.AfHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code afHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAfHandler(ctlParser.AfHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code auHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAuHandler(ctlParser.AuHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code auHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAuHandler(ctlParser.AuHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code agHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterAgHandler(ctlParser.AgHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code agHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitAgHandler(ctlParser.AgHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code notHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterNotHandler(ctlParser.NotHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code notHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitNotHandler(ctlParser.NotHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code orHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterOrHandler(ctlParser.OrHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code orHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitOrHandler(ctlParser.OrHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code efHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEfHandler(ctlParser.EfHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code efHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEfHandler(ctlParser.EfHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code egHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEgHandler(ctlParser.EgHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code egHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEgHandler(ctlParser.EgHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code euHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterEuHandler(ctlParser.EuHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code euHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitEuHandler(ctlParser.EuHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code bracketHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterBracketHandler(ctlParser.BracketHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code bracketHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitBracketHandler(ctlParser.BracketHandlerContext ctx);
	/**
	 * Enter a parse tree produced by the {@code implyHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterImplyHandler(ctlParser.ImplyHandlerContext ctx);
	/**
	 * Exit a parse tree produced by the {@code implyHandler}
	 * labeled alternative in {@link ctlParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitImplyHandler(ctlParser.ImplyHandlerContext ctx);
}