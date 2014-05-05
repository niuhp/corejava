package com.niuhp.corejava.pattern.abstractfactory;

public abstract class SampleA {

	private static int instanceCount;

	protected int instanceIndex;

	public SampleA() {
		instanceCount++;
		this.instanceIndex = instanceCount;
	}

	@Override
	public String toString() {

		return "SampleA---" + instanceIndex;
	}
}
