package com.niuhp.corejava.features.java8.lambda;

public class LambdaConstructor {

	public void lambdaConstructor1() {
		PersonFactory1<Person> f = Person::new;
		f.create();
	}

	public void lambdaConstructor2() {
		PersonFactory2<Person> f = Person::new;
		f.create(25, "tiny");
	}
}

interface PersonFactory1<T extends Person> {
	T create();

}

interface PersonFactory2<T extends Person> {

	T create(int age, String name);
}
