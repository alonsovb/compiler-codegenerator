package AST;

public class AStatementSwitch extends Statement {
	public ASwitchStatement ss0;

	public AStatementSwitch(ASwitchStatement SS0) {
		ss0 = SS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementSwitch(this,arg);
	}
}

