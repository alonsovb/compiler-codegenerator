package AST;

public class APrimaryAllocationExpression extends PrimaryExpression {
	public AnAllocationExpression ae0;

	public APrimaryAllocationExpression(AnAllocationExpression AE0) {
		ae0 = AE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryAllocationExpression(this,arg);
	}
}

