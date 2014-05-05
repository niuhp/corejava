package com.niuhp.corejava.pattern.factorymethod;

import junit.framework.Assert;

import org.junit.Test;

import com.niuhp.corejava.pattern.factorymethod.IFactory;
import com.niuhp.corejava.pattern.factorymethod.ISample;
import com.niuhp.corejava.pattern.factorymethod.Sample1;
import com.niuhp.corejava.pattern.factorymethod.Sample2;

public class FactoryMethodTest {

	@Test
	public void testFactoryMethod() {
		ISample s1 = IFactory.createSample("Sample1");
		Assert.assertTrue((s1 instanceof Sample1));

		ISample s2 = IFactory.createSample("Sample2");
		Assert.assertTrue((s2 instanceof Sample2));

		ISample ss = IFactory.createSample("SampleX");
		Assert.assertNull(ss);

//		Sample sn = Factory.createSample(null);
//		Assert.assertNull(sn);
	}
}
