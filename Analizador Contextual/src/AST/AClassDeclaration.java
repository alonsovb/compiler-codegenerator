package AST;

import java_cup.runtime.Symbol;

public class AClassDeclaration extends AST {
	public Symbol id1;
	public AVarDecl vd0;
	public AMethodDecl md1;

	public AClassDeclaration(Symbol ID1, AVarDecl VD0, AMethodDecl MD1) {
		id1 = ID1;
		vd0 = VD0;
		md1 = MD1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAClassDeclaration(this,arg);
	}
}

