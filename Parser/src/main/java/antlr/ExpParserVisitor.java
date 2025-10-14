// Generated from C:/Users/Muhammed/IdeaProjects/FinNote/Parser/src/main/java/antlr/ExpParser.g4 by ANTLR 4.13.2
package antlr;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link ExpParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface ExpParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link ExpParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(ExpParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#line}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLine(ExpParser.LineContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#save_var}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSave_var(ExpParser.Save_varContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#call_Method}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall_Method(ExpParser.Call_MethodContext ctx);
	/**
	 * Visit a parse tree produced by {@link ExpParser#expersion}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpersion(ExpParser.ExpersionContext ctx);
}