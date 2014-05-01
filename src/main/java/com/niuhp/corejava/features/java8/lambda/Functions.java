package com.niuhp.corejava.features.java8.lambda;

import java.util.function.Function;

public class Functions {

	private Function<String, Integer> toInteger = Integer::parseInt;
	private Function<Integer, String> toString = String::valueOf;
	private Function<String, Boolean> toBoolean = Boolean::valueOf;

	public void function1() {
		Function<String, Boolean> f1 = toInteger.andThen(toString).andThen(toBoolean);
		f1.apply("true");
	}

	public void function2() {
		toBoolean.apply("true");
	}
}
