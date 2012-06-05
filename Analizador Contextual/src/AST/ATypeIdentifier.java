package AST;

import java_cup.runtime.Symbol;

public class ATypeIdentifier extends Type {

    public Symbol id1;

    public ATypeIdentifier(Symbol ID1) {
        id1 = ID1;
    }

    public Object visit(Visitor v, Object arg) {
        return v.visitATypeIdentifier(this, arg);
    }
}
