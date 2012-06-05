package AST;

public class ATypeDecl extends AST {
    public ATypeDecl td1;
    public TypeDeclaration td2;

     public ATypeDecl(ATypeDecl TD1, TypeDeclaration TD2) {
        td1 = TD1;
        td2 = TD2;
    }

 public Object visit(Visitor v, Object arg) {
  return v.visitATypeDecl(this,arg);
 }
}

