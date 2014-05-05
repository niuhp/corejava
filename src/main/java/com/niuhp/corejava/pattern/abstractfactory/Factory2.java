package com.niuhp.corejava.pattern.abstractfactory;

public class Factory2 extends AbstractFactory {

	@Override
	public SampleA createSampleA() {

		return new SampleA2();
	}

	@Override
	public SampleB createSampleB() {

		return new SampleB2();
	}

}
