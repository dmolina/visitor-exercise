package org.uca.dss.visitor.nodes;

import java.util.Map;

public class Operator implements Expression {
	private Expression operador1;
	private Expression operador2;
	private char op;

	public Operator(Expression op1, char op, Expression op2) {
		this.operador1 = op1;
		this.operador2 = op2;
		this.op = op;
	}
	
	public double evaluate(Map<String, Double> values) throws VariableUndefined {
		double value1, value2;
		double result = 0;

		value1 = this.operador1.evaluate(values);
		value2 = this.operador2.evaluate(values);

		switch (this.op) {
		case '+':
			result = value1 + value2;
			break;

		case '-':
			result = value1 - value2;
			break;

		case '*':
			result = value1 * value2;
			break;

		case '/':
			result = value1 / value2;
			break;

		}

		return result;
	}

	@Override
	public String toString() {
		return String.format("%s %c %s", operador1.toString(), this.op,
				operador2.toString());
	}

	public Expression derivate() {
		Expression value1, value2;

		value1 = this.operador1.derivate();
		value2 = this.operador2.derivate();
		
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
