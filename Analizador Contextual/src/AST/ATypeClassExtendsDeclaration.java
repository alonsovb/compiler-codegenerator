package AST;

public class ATypeClassExtendsDeclaration extends TypeDeclaration {
	public AClassExtendsDeclaration ced0;

	public ATypeClassExtendsDeclaration(AClassExtendsDeclaration CED0) {
		ced0 = CED0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitATypeClassExtendsDeclaration(this,arg);
	}
}

