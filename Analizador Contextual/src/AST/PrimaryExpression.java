package AST;

public abstract class PrimaryExpression extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
