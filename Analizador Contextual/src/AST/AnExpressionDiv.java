package AST;

public class AnExpressionDiv extends Expression {
 public ADivExpression de0;

 public AnExpressionDiv(ADivExpression DE0) {
  de0 = DE0;
 }

 public Object visit(Visitor v, Object arg) {
  return v.visitAnExpressionDiv(this,arg);
 }
}

