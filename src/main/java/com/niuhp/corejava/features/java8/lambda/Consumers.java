package com.niuhp.corejava.features.java8.lambda;

import java.util.function.Consumer;

public class Consumers {

	public void consumer1() {
		Consumer<Person> c = (p) -> System.out.println("name=" + p.getName());
		c.accept(new Person());
	}
}
