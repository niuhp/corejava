package com.niuhp.corejava.features.java8.lambda;

import java.util.function.Predicate;

public class Predicates {

	public void predicateString() {
		Predicate<String> p = Boolean::valueOf;
		p.test("true");
	}

	public void predicateInteger() {
		Predicate<Integer> p = (i) -> i > 0;
		p.test(15);
	}

}
