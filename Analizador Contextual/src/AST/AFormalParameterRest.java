package AST;

public class AFormalParameterRest extends AST {
	public FormalParameterList fpl0;

	public AFormalParameterRest(FormalParameterList FPL0) {
		fpl0 = FPL0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAFormalParameterRest(this,arg);
	}
}

