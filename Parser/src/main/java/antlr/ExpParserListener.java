// Generated from C:/Users/Muhammed/IdeaProjects/FinNote/Parser/src/main/java/antlr/ExpParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link ExpParser}.
 */
public interface ExpParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(ExpParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(ExpParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#line}.
	 * @param ctx the parse tree
	 */
	void enterLine(ExpParser.LineContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#line}.
	 * @param ctx the parse tree
	 */
	void exitLine(ExpParser.LineContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#save_var}.
	 * @param ctx the parse tree
	 */
	void enterSave_var(ExpParser.Save_varContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#save_var}.
	 * @param ctx the parse tree
	 */
	void exitSave_var(ExpParser.Save_varContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#call_Method}.
	 * @param ctx the parse tree
	 */
	void enterCall_Method(ExpParser.Call_MethodContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#call_Method}.
	 * @param ctx the parse tree
	 */
	void exitCall_Method(ExpParser.Call_MethodContext ctx);
	/**
	 * Enter a parse tree produced by {@link ExpParser#expersion}.
	 * @param ctx the parse tree
	 */
	void enterExpersion(ExpParser.ExpersionContext ctx);
	/**
	 * Exit a parse tree produced by {@link ExpParser#expersion}.
	 * @param ctx the parse tree
	 */
	void exitExpersion(ExpParser.ExpersionContext ctx);
}