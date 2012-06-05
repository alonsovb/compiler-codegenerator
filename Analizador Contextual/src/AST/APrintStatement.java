package AST;

public class APrintStatement extends AST {
	public Expression e0;

	public APrintStatement(Expression E0) {
		e0 = E0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrintStatement(this,arg);
	}
}

