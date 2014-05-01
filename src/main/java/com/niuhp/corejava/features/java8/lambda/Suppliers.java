package com.niuhp.corejava.features.java8.lambda;

import java.util.Random;
import java.util.function.Supplier;

public class Suppliers {

	public void supply1() {
		Supplier<Person> s1 = Person::new;
		s1.get();
	}

	public void supply2() {
		Supplier<Random> s1 = Random::new;
		s1.get();
	}

}
