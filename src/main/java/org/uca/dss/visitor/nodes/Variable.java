package org.uca.dss.visitor.nodes;

import java.util.Map;

public class Variable extends Terminal {
	private String name;
	
	public Variable(String name) {
		this.name = name.toLowerCase();
	}
	
	@Override
	public String toString() {
		return name;
	}
	
	public double evaluate(Map<String, Double> values) throws VariableUndefined {
		if (values.containsKey(this.name)) {
			return values.get(this.name).floatValue();
		}
		else {
			throw new VariableUndefined(this.name);
		}
	}

		

}
