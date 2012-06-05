package AST;

public class AnExpressionAnd extends Expression {
	public AnAndExpression ae0;

	public AnExpressionAnd(AnAndExpression AE0) {
		ae0 = AE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionAnd(this,arg);
	}
}

