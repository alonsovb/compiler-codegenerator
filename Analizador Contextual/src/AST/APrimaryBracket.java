package AST;

public class APrimaryBracket extends PrimaryExpression {
	public ABracketExpression be0;

	public APrimaryBracket(ABracketExpression BE0) {
		be0 = BE0;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryBracket(this,arg);
	}
}

