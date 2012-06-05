package AST;

public class AnArrayAllocationExpression extends AST {
	public SimpleType st0;
	public Expression e1;

	public AnArrayAllocationExpression(SimpleType ST0, Expression E1) {
		st0 = ST0;
		e1 = E1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnArrayAllocationExpression(this,arg);
	}
}

