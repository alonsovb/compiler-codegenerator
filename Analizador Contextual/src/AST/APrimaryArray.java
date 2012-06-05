package AST;

public class APrimaryArray extends PrimaryExpression {
	public AnArrayAllocationExpression aaae0;

	public APrimaryArray(AnArrayAllocationExpression AAAE0) {
		aaae0 = AAAE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryArray(this,arg);
	}
}

