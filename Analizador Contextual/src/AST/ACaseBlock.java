package AST;

public class ACaseBlock extends AST {
	public ConstantExpression ce0;
	public AStatementList sl1;
	public ABreakStatement bs2;

	public ACaseBlock(ConstantExpression CE0, AStatementList SL1, ABreakStatement BS2) {
		ce0 = CE0;
		sl1 = SL1;
		bs2 = BS2;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitACaseBlock(this,arg);
	}
}

