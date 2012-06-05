package AST;

public class ACharSimpleType extends SimpleType {

	public ACharSimpleType() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitACharSimpleType(this,arg);
	}
}

