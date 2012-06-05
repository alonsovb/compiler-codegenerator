package AST;

public class ATypeSimple extends Type {
	public SimpleType st0;

	public ATypeSimple(SimpleType ST0) {
		st0 = ST0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitATypeSimple(this,arg);
	}
}

