package AST;
import java_cup.runtime.Symbol;

public class AConstantChar extends ConstantExpression {
    public Symbol c1;
    
	public AConstantChar( Symbol C1) {
            c1=C1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAConstantChar(this,arg);
	}
}

