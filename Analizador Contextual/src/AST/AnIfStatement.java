package AST;

public class AnIfStatement extends AST {
	public Expression e0;
	public Statement s1;
	public Statement s2;

	public AnIfStatement(Expression E0, Statement S1, Statement S2) {
		e0 = E0;
		s1 = S1;
		s2 = S2;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnIfStatement(this,arg);
	}
}

