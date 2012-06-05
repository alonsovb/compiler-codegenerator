package AST;

public class APrimaryThis extends PrimaryExpression {

	public APrimaryThis() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryThis(this,arg);
	}
}

