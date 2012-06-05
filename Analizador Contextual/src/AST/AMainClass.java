package AST;
import java_cup.runtime.Symbol;

public class AMainClass extends AST {
	public Symbol id1;
	public Symbol id2;
	public APrintStatement ps0;

	public AMainClass(Symbol ID1, Symbol ID2, APrintStatement PS0) {
		id1 = ID1;
		id2 = ID2;
		ps0 = PS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAMainClass(this,arg);
	}
}

