package AST;

public abstract class ConstantExpression extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
