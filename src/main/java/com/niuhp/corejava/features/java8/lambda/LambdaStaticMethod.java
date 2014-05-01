package com.niuhp.corejava.features.java8.lambda;

public class LambdaStaticMethod {

	public void lambdaStaticMethod() {
		Convert c = Integer::parseInt;
		System.out.println(c.toInt("123"));
	}
}

interface Convert {
	int toInt(String str);
}