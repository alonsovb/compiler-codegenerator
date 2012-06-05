package AST;

import java_cup.runtime.Symbol;

public class AnArrayAssignmentStatement extends AST {
	public Symbol id1;
	public Expression e0;
	public Expression e1;

	public AnArrayAssignmentStatement(Symbol ID1, Expression E0, Expression E1) {
		id1 = ID1;
		e0 = E0;
		e1 = E1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnArrayAssignmentStatement(this,arg);
	}
}

