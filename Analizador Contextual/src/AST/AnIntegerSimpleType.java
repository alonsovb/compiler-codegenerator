package AST;

public class AnIntegerSimpleType extends SimpleType {

	public AnIntegerSimpleType() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnIntegerSimpleType(this,arg);
	}
}

