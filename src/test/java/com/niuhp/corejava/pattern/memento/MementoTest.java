package com.niuhp.corejava.pattern.memento;

import org.junit.Assert;
import org.junit.Test;

public class MementoTest {

	@Test
	public void testMemento() {

		Originator o = new Originator();

		o.setNumber(15);
		o.setName("name1");
		Originator o1 = o.clone();

		Memento m = o.getMemento();

		o.setNumber(18);
		o.setName("newName");
		Originator o2 = o.clone();

		System.out.println(o);

		o.revertByMemento(m);
		Originator o3 = o.clone();

		Assert.assertFalse(o2.equals(o1));

		Assert.assertTrue(o3.equals(o1));
	}
}
