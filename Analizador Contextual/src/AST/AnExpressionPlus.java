package AST;

public class AnExpressionPlus extends Expression {
	public APlusExpression pe0;

	public AnExpressionPlus(APlusExpression PE0) {
		pe0 = PE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionPlus(this,arg);
	}
}

