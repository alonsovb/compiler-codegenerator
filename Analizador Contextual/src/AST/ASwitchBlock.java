package AST;

public class ASwitchBlock extends AST {
	public ACaseBlockList cbl0;
	public ADefaultBlock db1;

	public ASwitchBlock(ACaseBlockList CBL0, ADefaultBlock DB1) {
		cbl0 = CBL0;
		db1 = DB1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitASwitchBlock(this,arg);
	}
}

