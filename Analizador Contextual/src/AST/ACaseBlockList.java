package AST;

public class ACaseBlockList extends AST {
	public ACaseBlockList cbl0;
	public ACaseBlock cb1;

	public ACaseBlockList(ACaseBlockList CBL0, ACaseBlock CB1) {
		cbl0 = CBL0;
		cb1 = CB1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitACaseBlockList(this,arg);
	}
}

