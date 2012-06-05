package AST;

public class AConstantFalse extends ConstantExpression {

	public AConstantFalse() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAConstantFalse(this,arg);
	}
}

