package AST;

public class AVarDecl extends AST {
	public AVarDecl vd0;
	public AVarDeclaration vd1;

	public AVarDecl(AVarDecl VD0, AVarDeclaration VD1) {
		vd0 = VD0;
		vd1 = VD1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAVarDecl(this,arg);
	}
}

