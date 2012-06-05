package AST;

import java_cup.runtime.Symbol;

public class AVarDeclaration extends AST {
	public Type t0;
	public Symbol id1;

	public AVarDeclaration(Type T0, Symbol ID1) {
		t0 = T0;
		id1 = ID1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAVarDeclaration(this,arg);
	}
}

