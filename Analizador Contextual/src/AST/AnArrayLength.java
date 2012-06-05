package AST;

public class AnArrayLength extends AST {
	public PrimaryExpression pe0;

	public AnArrayLength(PrimaryExpression PE0) {
		pe0 = PE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnArrayLength(this,arg);
	}
}

