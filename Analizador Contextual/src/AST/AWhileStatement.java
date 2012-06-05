package AST;

public class AWhileStatement extends AST {
	public Expression e0;
	public Statement s1;

	public AWhileStatement(Expression E0, Statement S1) {
		e0 = E0;
		s1 = S1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAWhileStatement(this,arg);
	}
}

