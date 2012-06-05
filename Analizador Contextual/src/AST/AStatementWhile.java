package AST;

public class AStatementWhile extends Statement {
	public AWhileStatement ws0;

	public AStatementWhile(AWhileStatement WS0) {
		ws0 = WS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementWhile(this,arg);
	}
}

