package AST;

public abstract class Type extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
