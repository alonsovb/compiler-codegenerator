package AST;

import java_cup.runtime.Symbol;

public class AMessageSend extends AST {
	public PrimaryExpression pe0;
	public Symbol id1;
	public AnExpressionListBlock elb1;

	public AMessageSend(PrimaryExpression PE0, Symbol ID1, AnExpressionListBlock ELB1) {
		pe0 = PE0;
		id1 = ID1;
		elb1 = ELB1;
	}

	public Object visit(Visitor v, Object arg) {
		return v.visitAMessageSend(this,arg);
	}
}

