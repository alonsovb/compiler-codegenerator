package AST;

import java_cup.runtime.Symbol;

public class AnAssignmentStatement extends AST {
 public Symbol id1;
 public Expression e0;

 public AnAssignmentStatement(Symbol ID1, Expression E0) {
  id1 = ID1;
  e0 = E0;
 }

 public Object visit(Visitor v, Object arg) {
  return v.visitAnAssignmentStatement(this,arg);
 }
}

