package AST;

public abstract class FormalParameterList extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
