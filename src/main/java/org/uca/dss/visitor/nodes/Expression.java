package org.uca.dss.visitor.nodes;

import java.util.Map;

/**
 * Represent any expression in the tree of expressions
 * @author daniel
 *
 */
public interface Expression extends Cloneable {
	String toString();
	double evaluate(Map<String,Double> values) throws VariableUndefined;
	Expression derivate();
}
