package com.niuhp.corejava.pattern.abstractfactory;

public class Factory1 extends AbstractFactory {

	@Override
	public SampleA createSampleA() {

		return new SampleA1();
	}

	@Override
	public SampleB createSampleB() {

		return new SampleB1();
	}

}
