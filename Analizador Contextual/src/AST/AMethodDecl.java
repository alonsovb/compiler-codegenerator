package AST;

public class AMethodDecl extends AST {
	public AMethodDecl md0;
	public AMethodDeclaration md1;

	public AMethodDecl(AMethodDecl MD0, AMethodDeclaration MD1) {
		md0 = MD0;
		md1 = MD1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAMethodDecl(this,arg);
	}
}

