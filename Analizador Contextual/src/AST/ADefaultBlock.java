package AST;

public class ADefaultBlock extends AST {
	public AStatementList sl0;
	public ABreakStatement bs1;

	public ADefaultBlock(AStatementList SL0, ABreakStatement BS1) {
		sl0 = SL0;
		bs1 = BS1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitADefaultBlock(this,arg);
	}
}

