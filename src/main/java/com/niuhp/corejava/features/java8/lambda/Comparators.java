package com.niuhp.corejava.features.java8.lambda;

import java.util.Comparator;

public class Comparators {

	public void comparator1() {
		Comparator<Person> c = (p1, p2) -> p1.getAge() - p2.getAge();
		Person p1 = new Person(20, "tiny");
		Person p2 = new Person(18, "puck");
		c.compare(p1, p2);
		c.reversed().compare(p1, p2);
	}
}
