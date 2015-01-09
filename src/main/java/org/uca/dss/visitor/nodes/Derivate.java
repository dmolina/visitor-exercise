package org.uca.dss.visitor.nodes;

public class Derivate extends ExpressionOperation {

	public Expression apply(Constant c) {
		return new Constant(0);
	}

	public Expression apply(Variable v) {
		return new Constant(1);
	}

	public Expression apply(Operator operator) {
		Expression value1, value2;
		Expression operador1 = operator.getOperador1();
		Expression operador2 = operator.getOperador2();
		char op = operator.getOp();
		
		value1 = apply(operator.getOperador1());
		value2 = apply(operator.getOperador2());
		
		if (op == '+' || op == '-') {
			return new Operator(value1, op, value2);
		}
		else if (op == '*') {
			return new Operator(
					new Operator(value1, op, operador2),
					'+', 
					new Operator(operador1, op, value2)
					);
		}
		else {
			return new Operator(
					new Operator(
							new Operator(value1, '*', operador2), 
							'-', new Operator(operador1, '*', value2)),
					'/', 
					new Operator(value2, '*', value2)
					);
		}
	}

}
