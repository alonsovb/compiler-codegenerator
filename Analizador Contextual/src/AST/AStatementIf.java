package AST;

public class AStatementIf extends Statement {
	public AnIfStatement is0;

	public AStatementIf(AnIfStatement IS0) {
		is0 = IS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementIf(this,arg);
	}
}

