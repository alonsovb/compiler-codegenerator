package AST;

public class AnExpressionMenor extends Expression {
 public AMenorQueExpression mqe0;

 public AnExpressionMenor(AMenorQueExpression MQE0) {
  mqe0 = MQE0;
 }

 public Object visit(Visitor v, Object arg) {
  return v.visitAnExpressionMenor(this,arg);
 }
}

