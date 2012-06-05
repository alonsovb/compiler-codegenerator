package AST;

public class AnExpressionTimes extends Expression {
	public ATimesExpression te0;

	public AnExpressionTimes(ATimesExpression TE0) {
		te0 = TE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionTimes(this,arg);
	}
}

