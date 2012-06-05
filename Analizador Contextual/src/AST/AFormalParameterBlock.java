package AST;

public class AFormalParameterBlock extends AST {
    public FormalParameterList fpl0;

 public AFormalParameterBlock(FormalParameterList FPL0) {
  fpl0 = FPL0;
 }

 public Object visit(Visitor v, Object arg) {
  return v.visitAFormalParameterBlock(this,arg);
 }
}

