package org.uca.dss.visitor.nodes;

public interface ExpressionOperation {
	public Expression apply(Constant c);
	public Expression apply(Variable v);
	public Expression apply(Operator op);
}
