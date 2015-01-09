package org.uca.dss.visitor.nodes;

import java.util.Random;

public class TestUtilRandom {
	private Random rand;
	
	public TestUtilRandom() {
		rand = new Random();
	}
	
	public double randDouble() {
		return rand.nextDouble()*10-5;
	}
}
