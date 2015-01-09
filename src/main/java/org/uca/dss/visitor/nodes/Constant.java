package org.uca.dss.visitor.nodes;

import java.util.Map;

public class Constant extends Terminal {
	double value;
	
	Constant(double value) {
		this.value = value;
	}

	public double evaluate(Map<String, Double> values) {
		return value;
	}

	public Expression derivate() {
		return new Constant(0);
	}
	
	@Override
	public String toString() {
		return Double.toString(value);
	}

}
