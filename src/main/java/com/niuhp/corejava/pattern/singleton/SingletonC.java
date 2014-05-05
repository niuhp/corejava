package com.niuhp.corejava.pattern.singleton;

public class SingletonC {

	private SingletonC() {

	}

	private static class SingletonHolder {
		static final SingletonC INSTANCE = new SingletonC();
	}

	public static SingletonC getInstance() {

		return SingletonHolder.INSTANCE;
	}
}
