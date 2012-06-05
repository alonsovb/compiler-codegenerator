package AST;
import java_cup.runtime.Symbol;


public class APrimaryString extends PrimaryExpression {
        public Symbol str1;
	public APrimaryString(Symbol STR1) {
            str1=STR1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryString(this,arg);
	}
}

