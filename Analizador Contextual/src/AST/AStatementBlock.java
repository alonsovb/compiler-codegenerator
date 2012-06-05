package AST;

public class AStatementBlock extends Statement {
	public ABlock b0;

	public AStatementBlock(ABlock B0) {
		b0 = B0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementBlock(this,arg);
	}
}

