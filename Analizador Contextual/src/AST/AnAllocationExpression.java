package AST;

import java_cup.runtime.Symbol;

public class AnAllocationExpression extends AST {
	public Symbol id1;

	public AnAllocationExpression(Symbol ID1) {
		id1 = ID1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnAllocationExpression(this,arg);
	}
}

