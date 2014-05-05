package com.niuhp.corejava.pattern.singleton;

import org.junit.Assert;
import org.junit.Test;

public class SingletonTest {

	@Test
	public void testSingleton() {
		SingletonA sa1 = SingletonA.getInstance();
		SingletonA sa2 = SingletonA.getInstance();

		SingletonB sb1 = SingletonB.getInstance();
		SingletonB sb2 = SingletonB.getInstance();

		SingletonC sc1 = SingletonC.getInstance();
		SingletonC sc2 = SingletonC.getInstance();

		Assert.assertTrue(sa1 == sa2);
		Assert.assertTrue(sb1 == sb2);
		Assert.assertTrue(sc1 == sc2);
	}
}
