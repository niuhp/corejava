package com.niuhp.corejava.pattern.facade;

public class Cat implements Animal {
	private static int instanceCount;
	private int instanceIndex;

	public Cat() {
		instanceCount++;
		instanceIndex = instanceCount;
	}

	public static int getInstanceCount() {
		return instanceCount;
	}

	@Override
	public void speak() {
		System.out.println("I'm Cat" + String.format("%1$03d", instanceIndex) + ",miao miao ...");

	}
}
