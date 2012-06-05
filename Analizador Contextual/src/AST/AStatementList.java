package AST;

public class AStatementList extends AST {
	public AStatementList sl0;
	public Statement s1;

	public AStatementList(AStatementList SL0, Statement S1) {
		sl0 = SL0;
		s1 = S1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementList(this,arg);
	}
}

