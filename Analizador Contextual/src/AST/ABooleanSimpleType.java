package AST;

public class ABooleanSimpleType extends SimpleType {

	public ABooleanSimpleType() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitABooleanSimpleType(this,arg);
	}
}

