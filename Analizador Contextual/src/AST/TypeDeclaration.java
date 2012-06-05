package AST;

public abstract class TypeDeclaration extends AST
{
	public abstract Object visit(Visitor v,Object arg);
}
