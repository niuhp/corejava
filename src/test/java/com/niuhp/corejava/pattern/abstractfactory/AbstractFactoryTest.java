package com.niuhp.corejava.pattern.abstractfactory;

import org.junit.Test;

public class AbstractFactoryTest {

	@Test
	public void testAbstractFactory() {
		AbstractFactory f1 = new Factory1();
		AbstractFactory f2 = new Factory1();

		SampleA sa1 = f1.createSampleA();
		SampleA sa2 = f2.createSampleA();

		SampleB sb1 = f1.createSampleB();
		SampleB sb2 = f2.createSampleB();

		sb1.interactSampleA(sa1);
		sb1.interactSampleA(sa2);
		sb2.interactSampleA(sa1);
		sb2.interactSampleA(sa2);
	}
}
