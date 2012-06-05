package AST;

public class ANotExpression extends AST {
	public Expression e0;

	public ANotExpression(Expression E0) {
		e0 = E0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitANotExpression(this,arg);
	}
}

