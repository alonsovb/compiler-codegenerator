package AST;

public class ASimpleTypeInt extends SimpleType {

	public ASimpleTypeInt() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitASimpleTypeInt(this,arg);
	}
}
