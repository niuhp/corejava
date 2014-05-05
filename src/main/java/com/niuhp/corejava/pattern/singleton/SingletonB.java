package com.niuhp.corejava.pattern.singleton;

public class SingletonB {
	
	private static SingletonB instance = new SingletonB();

	private SingletonB() {

	}

	public static SingletonB getInstance() {

		return instance;
	}
}
