package AST;

public class ATypeClassDeclaration extends TypeDeclaration {
	public AClassDeclaration cd0;

	public ATypeClassDeclaration(AClassDeclaration CD0) {
		cd0 = CD0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitATypeClassDeclaration(this,arg);
	}
}

