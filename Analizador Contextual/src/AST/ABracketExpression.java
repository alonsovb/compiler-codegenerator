package AST;

public class ABracketExpression extends AST {
	public Expression e0;

	public ABracketExpression(Expression E0) {
		e0 = E0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitABracketExpression(this,arg);
	}
}

