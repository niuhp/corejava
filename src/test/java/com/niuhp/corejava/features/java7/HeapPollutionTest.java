package com.niuhp.corejava.features.java7;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;

public class HeapPollutionTest {

	@Test
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void testAddToCollection() {
		HeapPollution hp = new HeapPollution();
		Collection<String> list1 = new ArrayList<>();
		Collection<Integer> list2 = new ArrayList<>();

		String[] strs = { "1", "123" };
		Integer[] ints = { 1, 2 };

		hp.addToCollection(list1, "1", "123");
		hp.addToCollection(list2, 1, 2);
		hp.addToCollection(list1, strs);
		hp.addToCollection(list2, ints);

		List list = new ArrayList<>();
		list.add(1);
		list1 = list;// Heap Pollution
		Object o = list1.iterator().next();
		Assert.assertTrue(o instanceof String);// false
	}
}
