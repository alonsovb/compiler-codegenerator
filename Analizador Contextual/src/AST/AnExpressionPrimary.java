package AST;

public class AnExpressionPrimary extends Expression {
	public PrimaryExpression pe0;

	public AnExpressionPrimary(PrimaryExpression PE0) {
		pe0 = PE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionPrimary(this,arg);
	}
}

