package AST;

public class AnExpressionArrayLenght extends Expression {
	public AnArrayLength al0;

	public AnExpressionArrayLenght(AnArrayLength AL0) {
		al0 = AL0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionArrayLenght(this,arg);
	}
}

