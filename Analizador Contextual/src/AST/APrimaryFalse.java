package AST;

public class APrimaryFalse extends PrimaryExpression {

	public APrimaryFalse() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryFalse(this,arg);
	}
}

