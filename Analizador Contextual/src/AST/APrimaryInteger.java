package AST;
import java_cup.runtime.Symbol;


public class APrimaryInteger extends PrimaryExpression {
        public Symbol int1;

	public APrimaryInteger(Symbol INTT1) {
            int1=INTT1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAPrimaryInteger(this,arg);
	}
}

