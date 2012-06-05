package AST;

public class AnExpressionListBlock extends AST {
	public ExpressionList el0;

	public AnExpressionListBlock(ExpressionList EL0) {
		el0 = EL0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionListBlock(this,arg);
	}
}

