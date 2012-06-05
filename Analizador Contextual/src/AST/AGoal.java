package AST;

import java_cup.runtime.Symbol;

public class AGoal extends AST {

    public AMainClass mc;
    public ATypeDecl td;

    public AGoal(AMainClass MC, ATypeDecl TD) {
        mc = MC;
        td = TD;
    }

    public Object visit(Visitor v, Object arg) {
        return v.visitAGoal(this, arg);
    }
}