package AST;

public class AnAndExpression extends AST {
	public PrimaryExpression pe0;
	public PrimaryExpression pe1;

	public AnAndExpression(PrimaryExpression PE0, PrimaryExpression PE1) {
		pe0 = PE0;
		pe1 = PE1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnAndExpression(this,arg);
	}
}

