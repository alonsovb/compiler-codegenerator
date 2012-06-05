package AST;

public class ASimpleTypeBool extends SimpleType {

	public ASimpleTypeBool() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitASimpleTypeBool(this,arg);
	}
}
