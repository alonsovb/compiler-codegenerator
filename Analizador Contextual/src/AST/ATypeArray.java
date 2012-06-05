package AST;

public class ATypeArray extends Type {
	public AnArrayType at0;

	public ATypeArray(AnArrayType AT0) {
		at0 = AT0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitATypeArray(this,arg);
	}
}

