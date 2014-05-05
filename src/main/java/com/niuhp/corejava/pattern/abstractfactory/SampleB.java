package com.niuhp.corejava.pattern.abstractfactory;

public abstract class SampleB {
	private static int instanceCount;

	protected int instanceIndex;

	public SampleB() {
		instanceCount++;
		this.instanceIndex = instanceCount;
	}

	public void interactSampleA(SampleA sa) {
		System.out.println(this + " interact " + sa);
	}

	@Override
	public String toString() {

		return "SampleB---" + instanceIndex;
	}
}
