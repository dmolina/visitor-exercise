package org.uca.dss.visitor.nodes;

public abstract class ExpressionOperation {
	public abstract Expression apply(Constant c);
	public abstract Expression apply(Variable v);
	public abstract Expression apply(Operator op);
	
	public Expression apply(Expression exp) {
		if (exp instanceof Constant) {
			return apply((Constant) exp);
		}
		else if (exp instanceof Variable) {
			return apply((Variable) exp);
		}
		else if (exp instanceof Operator) {
			return apply((Operator) exp);
		}
		else {
			throw new RuntimeException("Node not defined");
		}
	}
}
