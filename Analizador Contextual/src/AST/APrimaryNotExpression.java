package AST;

public class APrimaryNotExpression extends PrimaryExpression {
	public ANotExpression ne0;

	public APrimaryNotExpression(ANotExpression NE0) {
		ne0 = NE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryNotExpression(this,arg);
	}
}

