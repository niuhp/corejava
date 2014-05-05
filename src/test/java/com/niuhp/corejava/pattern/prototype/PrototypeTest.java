package com.niuhp.corejava.pattern.prototype;

import org.junit.Assert;
import org.junit.Test;

public class PrototypeTest {

	@Test
	public void testPrototype() {
		SubPrototypeObj p = new SubPrototypeObj();
		p.setName("hello");
		p.setUserLabel("label");

		SubPrototypeObj p1 = (SubPrototypeObj) p.clone();
		
		Assert.assertTrue(p.getName().equals(p1.getName()));
		Assert.assertTrue(p.getUserLabel().equals(p1.getUserLabel()));

	}
}
