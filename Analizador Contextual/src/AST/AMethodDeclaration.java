package AST;
import java_cup.runtime.Symbol;

public class AMethodDeclaration extends AST {
	public Type t0;
	public Symbol id1;
	public AFormalParameterBlock fpb1;
	public AVarDecl vd2;
	public AStatementList sl3;
	public Expression e4;

	public AMethodDeclaration(Type T0, Symbol ID1, AFormalParameterBlock FPB1, AVarDecl VD2, AStatementList SL3, Expression E4) {
		t0 = T0;
		id1 = ID1;
		fpb1 = FPB1;
		vd2 = VD2;
		sl3 = SL3;
		e4 = E4;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAMethodDeclaration(this,arg);
	}
}
