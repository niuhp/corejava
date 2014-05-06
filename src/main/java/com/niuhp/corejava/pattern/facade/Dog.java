package com.niuhp.corejava.pattern.facade;

public class Dog implements Animal {

	private static int instanceCount;
	private int instanceIndex;

	public Dog() {
		instanceCount++;
		instanceIndex = instanceCount;
	}

	public static int getInstanceCount() {
		return instanceCount;
	}

	@Override
	public void speak() {
		System.out.println("I'm Dog" + String.format("%1$03d", instanceIndex) + ",wang wang ...");

	}
}
