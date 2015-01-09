package org.uca.dss.visitor.nodes;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

public class TestDerivate {
	TestUtilRandom random;
	private final double epsilon = 1e-6;
	private Variable x;
	private Map<String,Double> values;
	private Map<String,Double> novalues;
	private Derivate derivate;
	
	@Before
	public void init() {
		random = new TestUtilRandom();
		x = new Variable("x");
		novalues = new HashMap<String, Double>();
		values = new HashMap<String, Double>();
		values.put("x", 1.0);
		derivate = new Derivate();
	}
	private Expression derivate(Expression exp) {
		return derivate.apply(exp);
	}
	@Test
	public void testConstant() {
		for (int i = 1; i <= 10; i++) {
			double value = random.randDouble();			
			assertEquals(derivate(new Constant(value)).toString(), "0.0");
		}
	}
	
	@Test
	public void testVariable() {
		Variable x = new Variable("x");
		assertEquals(derivate(x).toString(), "1.0");
	}
	
	@Test
	public void testOperator() {
		Constant c_1 = new Constant(1);
		Constant c_2 = new Constant(2);
		Constant c_3 = new Constant(3);
		Constant c_5 = new Constant(5);
		
		Expression op;
		
		op = new Operator(c_1, '+', c_2);
		assertEquals(derivate(op).toString(), "0.0 + 0.0");
		op = new Operator(x, '+', c_2);
		assertEquals(derivate(op).toString(), "1.0 + 0.0");
		op = new Operator(c_3, '*', x);
		assertEquals(derivate(op).toString(), "0.0 * x + 3.0 * 1.0");
		assertEquals(3.0, derivate(op).evaluate(values), epsilon);
	}

}
