package ast;

public abstract class Expression extends AST {
    public String type = "unset";
    public abstract Object visit(Visitor v, Object arg);
}
