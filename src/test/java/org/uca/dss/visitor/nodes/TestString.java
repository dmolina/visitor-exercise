package org.uca.dss.visitor.nodes;

import static org.junit.Assert.*;

import org.junit.Test;

public class TestString {

	@Test
	public void testStringConstant() {
		assertEquals(new Constant(2.3).toString(), "2.3");
		assertEquals(new Constant(2).toString(), "2.0");
		assertEquals(new Constant(-5.1).toString(), "-5.1");
	}
	
	@Test
	public void testStringVariable() {
		assertEquals(new Variable("x").toString(), "x");
		assertEquals(new Variable("X").toString(), "x");
		assertEquals(new Variable("y").toString(), "y");
		assertEquals(new Variable("Y").toString(), "y");
	}
	
	@Test
	public void testStringOperator() {
		Expression exp;
		
		exp = new Operator(new Constant(1.0), '+', new Constant(3.2));
		assertEquals(exp.toString(), "1.0 + 3.2");
		exp = new Operator(new Constant(1.0), '-', new Constant(4.0));
		assertEquals(exp.toString(), "1.0 - 4.0");
		exp = new Operator(new Constant(5.0), '*', new Constant(2.0));
		assertEquals(exp.toString(), "5.0 * 2.0");
		exp = new Operator(new Constant(1.2), '/', new Constant(2.0));
		assertEquals(exp.toString(), "1.2 / 2.0");
	}

}
