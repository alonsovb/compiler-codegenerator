package ast;

public class APlusExpression extends Expression {
	public PrimaryExpression pe0;
	public PrimaryExpression pe1;

	public APlusExpression(PrimaryExpression PE0, PrimaryExpression PE1) {
		pe0 = PE0;
		pe1 = PE1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPlusExpression(this,arg);
	}
}

