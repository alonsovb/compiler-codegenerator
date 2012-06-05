package AST;
import java_cup.runtime.Symbol;

public class APrimaryIdentifier extends PrimaryExpression {
        public Symbol id1;

	public APrimaryIdentifier(Symbol ID1) {
            id1=ID1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryIdentifier(this,arg);
	}
}

