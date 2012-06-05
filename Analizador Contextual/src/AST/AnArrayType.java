package AST;

public class AnArrayType extends AST {
	public SimpleType st0;

	public AnArrayType(SimpleType ST0) {
		st0 = ST0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnArrayType(this,arg);
	}
}

