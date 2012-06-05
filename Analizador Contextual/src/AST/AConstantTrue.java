package AST;

public class AConstantTrue extends ConstantExpression {

	public AConstantTrue() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAConstantTrue(this,arg);
	}
}

