package AST;

public class AFormalParameterListRest extends FormalParameterList {
	public FormalParameterList fpl0;
	public AFormalParameterRest fpr1;

	public AFormalParameterListRest(FormalParameterList FPL0, AFormalParameterRest FPR1) {
		fpl0 = FPL0;
		fpr1 = FPR1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAFormalParameterListRest(this,arg);
	}
}

