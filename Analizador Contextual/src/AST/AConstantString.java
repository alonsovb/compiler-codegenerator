package AST;
import java_cup.runtime.Symbol;

public class AConstantString extends ConstantExpression {
        public Symbol str1;
	public AConstantString(Symbol STR1) {
            str1=STR1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAConstantString(this,arg);
	}
}

