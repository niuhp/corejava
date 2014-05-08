package com.niuhp.corejava.algorithm.interpreter;

import org.junit.Test;

import com.niuhp.corejava.pattern.interpreter.Calculator;

public class InterpreterTest {

	@Test
	public void testInterpreter() {
		String statement = "6 * 5.0 / 2 / 3";
		Calculator c = new Calculator();
		c.build(statement);
		System.out.println(c.compute());
	}
}
