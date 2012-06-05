package AST;

public class AnExpressionRest extends AST {
        public ExpressionList el;

	public AnExpressionRest(ExpressionList EL) {
                el = EL;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionRest(this,arg);
	}
}

