package com.niuhp.corejava.pattern.builder;

import org.junit.Test;

public class BuilderTest {

	@Test
	public void testBuilder() {
		Builder builder = new ConcreteBuilder();
		Director director = new Director(builder);
		director.construct();
		Product product = builder.getResult();
		System.out.println(product);
	}
}
