package AST;

public class ABlock extends AST {
	public AStatementList sl0;

	public ABlock(AStatementList SL0) {
		sl0 = SL0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitABlock(this,arg);
	}
}

