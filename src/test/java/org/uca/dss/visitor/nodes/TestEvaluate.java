package org.uca.dss.visitor.nodes;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.junit.Before;
import org.junit.Test;

public class TestEvaluate {
	private static final double epsilon = 1e-6;
	private TestUtilRandom random;
	private Map<String,Double> values;
	private Map<String,Double> valuesX;
	
	@Before
	public void init() {
		random = new TestUtilRandom();
		values = new HashMap<String, Double>();
		values.put("x", 1.0);
		values.put("y", 3.0);
	}
	
	@Test
	public void testConstant() {
			
		for (int i = 1; i < 10; i++) {
			double value = random.randDouble();
			Expression exp = new Constant(value);
			assertEquals(exp.evaluate(values), value, epsilon);
			values.put("x", random.randDouble());
			assertEquals(exp.evaluate(values), value, epsilon);
		}
	}

	@Test
	public void testVariable() {
		Expression exp, expy;
		
		exp = new Variable("x");
		assertEquals(exp.evaluate(values), 1.0, epsilon);
		expy = new Variable("y");
		assertEquals(expy.evaluate(values), 3.0, epsilon);
		values.put("x", 2.0);
		assertEquals(exp.evaluate(values), 2.0, epsilon);
		expy = new Variable("y");
		assertEquals(expy.evaluate(values), 3.0, epsilon);
	}
	
	@Test
	public void testOperator() {
		Expression op;
		Variable x = new Variable("x");
		Variable y = new Variable("y");
		Constant c_1 = new Constant(1);
		Constant c_3 = new Constant(3);
		
		op = new Operator(c_1, '+', c_3);
		assertEquals(op.evaluate(values), 4.0, epsilon);
		op = new Operator(x, '+', y);
		assertEquals(op.evaluate(values), 4.0, epsilon);
		op = new Operator(c_1, '-', c_3);
		assertEquals(op.evaluate(values), -2.0, epsilon);
		op = new Operator(x, '-', y);
		assertEquals(op.evaluate(values), -2.0, epsilon);
		op = new Operator(c_1, '-', y);
		assertEquals(op.evaluate(values), -2.0, epsilon);
		op = new Operator(x, '*', y);
		assertEquals(op.evaluate(values), 3.0, epsilon);
		op = new Operator(x, '/', y);
		assertEquals(op.evaluate(values), 0.33333333333, epsilon);
	}
	
	@Test(expected=VariableUndefined.class)
	public void testNotDefined() {
		Variable z = new Variable("z");
		z.evaluate(values);
	}
	@Test(expected=VariableUndefined.class)
	public void testNotDefinedVar() {
		Variable x = new Variable("x");
		values.remove("x");
		x.evaluate(values);
	}
}
