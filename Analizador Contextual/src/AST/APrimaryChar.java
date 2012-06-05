package AST;
import java_cup.runtime.Symbol;

public class APrimaryChar extends PrimaryExpression {
        public Symbol ch1;
	public APrimaryChar(Symbol CH1) {
            ch1=CH1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryChar(this,arg);
	}
}

