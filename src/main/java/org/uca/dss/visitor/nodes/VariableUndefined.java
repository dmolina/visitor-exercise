package org.uca.dss.visitor.nodes;

public class VariableUndefined extends RuntimeException {
	public VariableUndefined(String variable) {
		super(String.format("Variable %s not defined", variable));
	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
