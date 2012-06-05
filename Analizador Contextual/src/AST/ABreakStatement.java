package AST;

public class ABreakStatement extends AST {

	public ABreakStatement() {
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitABreakStatement(this,arg);
	}
}

