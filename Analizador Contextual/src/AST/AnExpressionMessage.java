package AST;

public class AnExpressionMessage extends Expression {
	public AMessageSend ms0;

	public AnExpressionMessage(AMessageSend MS0) {
		ms0 = MS0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAnExpressionMessage(this,arg);
	}
}

