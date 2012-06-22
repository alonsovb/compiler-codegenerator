package ast;

public abstract class Statement extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
