package AST;

public class AStatementPrint extends Statement {
	public APrintStatement ps0;

	public AStatementPrint(APrintStatement PS0) {
		ps0 = PS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementPrint(this,arg);
	}
}

