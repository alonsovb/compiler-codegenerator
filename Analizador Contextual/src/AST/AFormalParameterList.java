package AST;

public class AFormalParameterList extends FormalParameterList {
	public AFormalParameter fpl0;

	public AFormalParameterList(AFormalParameter FPL0) {
		fpl0 = FPL0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAFormalParameterList(this,arg);
	}
}

