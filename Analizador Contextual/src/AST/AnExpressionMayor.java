package AST;

public class AnExpressionMayor extends Expression {
 public AMayorQueExpression mqe0;

 public AnExpressionMayor(AMayorQueExpression MQE0) {
  mqe0 = MQE0;
 }

 public Object visit(Visitor v, Object arg) {
  return v.visitAnExpressionMayor(this,arg);
 }
}

