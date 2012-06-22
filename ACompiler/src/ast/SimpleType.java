package ast;

public abstract class SimpleType extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
