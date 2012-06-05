package AST;

public class AStatementArrayAssignment extends Statement {
	public AnArrayAssignmentStatement aas0;

	public AStatementArrayAssignment(AnArrayAssignmentStatement AAS0) {
		aas0 = AAS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementArrayAssignment(this,arg);
	}
}

