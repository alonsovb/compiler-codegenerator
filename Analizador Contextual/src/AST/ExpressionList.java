package AST;

public abstract class ExpressionList extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
