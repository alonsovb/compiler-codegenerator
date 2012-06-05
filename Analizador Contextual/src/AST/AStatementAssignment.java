package AST;

public class AStatementAssignment extends Statement {
	public AnAssignmentStatement as0;

	public AStatementAssignment(AnAssignmentStatement AS0) {
		as0 = AS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAStatementAssignment(this,arg);
	}
}

