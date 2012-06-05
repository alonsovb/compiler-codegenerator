package AST;

public class AnExpressionArrayLookup extends Expression {
	public AnArrayLookup al0;

	public AnExpressionArrayLookup(AnArrayLookup AL0) {
		al0 = AL0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionArrayLookup(this,arg);
	}
}

