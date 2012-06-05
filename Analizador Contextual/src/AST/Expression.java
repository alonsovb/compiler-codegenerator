package AST;

public abstract class Expression extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
