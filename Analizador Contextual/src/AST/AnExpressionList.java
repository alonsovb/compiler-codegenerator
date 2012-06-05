package AST;

public class AnExpressionList extends ExpressionList {
	public Expression e0;

	public AnExpressionList(Expression E0) {
		e0 = E0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionList(this,arg);
	}
}

