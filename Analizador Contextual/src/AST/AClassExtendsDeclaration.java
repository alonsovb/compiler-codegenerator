package AST;
import java_cup.runtime.Symbol;

public class AClassExtendsDeclaration extends AST {
	public Symbol id1;
	public Symbol id2;
	public AVarDecl vd0;
	public AMethodDecl md1;

	public AClassExtendsDeclaration(Symbol ID1, Symbol ID2, AVarDecl VD0, AMethodDecl MD1) {
		id1 = ID1;
		id2 = ID2;
		vd0 = VD0;
		md1 = MD1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAClassExtendsDeclaration(this,arg);
	}
}

