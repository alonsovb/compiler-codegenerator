package AST;

public class AnExpressionMinus extends Expression {
	public AMinusExpression me0;

	public AnExpressionMinus(AMinusExpression ME0) {
		me0 = ME0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionMinus(this,arg);
	}
}

