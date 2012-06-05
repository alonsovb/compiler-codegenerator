package AST;

public class ASwitchStatement extends AST {
	public Expression e0;
	public ASwitchBlock sb1;

	public ASwitchStatement(Expression E0, ASwitchBlock SB1) {
		e0 = E0;
		sb1 = SB1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitASwitchStatement(this,arg);
	}
}

