package AST;
import java_cup.runtime.Symbol;

public class AFormalParameter extends AST {
	public Type t0;
	public Symbol id1;

	public AFormalParameter(Type T0, Symbol ID1) {
		t0 = T0;
		id1 = ID1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAFormalParameter(this,arg);
	}
}

