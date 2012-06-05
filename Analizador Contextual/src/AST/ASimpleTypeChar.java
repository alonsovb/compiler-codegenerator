package AST;

public class ASimpleTypeChar extends SimpleType {

	public ASimpleTypeChar() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitASimpleTypeChar(this,arg);
	}
}
