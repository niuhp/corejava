package com.niuhp.corejava.features.java8.lambda;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class LambdaExpression {

	public void lambda1() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Comparator<Integer> c = (Integer a, Integer b) -> {
			return a.compareTo(b);
		};
		Collections.sort(list, c);
	}

	public void lambda2() {
		List<Integer> list = Arrays.asList(1, 2, 3);
		Comparator<Integer> c = (a, b) -> a.compareTo(b);
		Collections.sort(list, c);
	}

	public void lambdaCustom1() {
		Printor1 p = (a) -> System.out.println(a);
		p.printObject("8455d");
	}

	public void lambdaCustom1_1() {
		PrintStream out = System.out;
		Printor1 p = out::println;
		p.printObject("8455d");
	}

	public void lambdaCustom2() {
		Printor2 p = (a, b) -> System.out.println(a);
		p.printObjects("8455d", null);
	}

	public void lambdaCustom3() {
		Printor3 p = (objs) -> System.out.println(objs);
		p.printObjects("8455d", null);
	}

	public void lambdaCustom4() {
		Printor4 p = () -> System.out.println("nothing");
		p.printObject();
	}

	public void lambdaCustom5() {
		Runnable r = () -> System.out.println();
		Thread t = new Thread(r);
		t.start();
	}
}

interface Printor1 {
	void printObject(Object obj);
}

interface Printor2 {
	void printObjects(Object o1, Object o2);
}

interface Printor3 {
	void printObjects(Object... objs);
}

interface Printor4 {
	void printObject();
}