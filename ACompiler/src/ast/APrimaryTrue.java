package ast;

public class APrimaryTrue extends PrimaryExpression {

	public APrimaryTrue() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryTrue(this,arg);
	}
}

