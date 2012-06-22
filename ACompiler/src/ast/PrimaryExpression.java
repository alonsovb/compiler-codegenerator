package ast;

public abstract class PrimaryExpression extends Expression {

    public abstract Object visit(Visitor v, Object arg);
}
