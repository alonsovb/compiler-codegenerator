package AST;
import java_cup.runtime.Symbol;

public class AConstantInteger extends ConstantExpression {
        public Symbol int1;
    
	public AConstantInteger(Symbol INT1) {
            int1=INT1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAConstantInteger(this,arg);
	}
}

