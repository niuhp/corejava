package com.niuhp.corejava.collection;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Test;

public class SetTest {

	@Test
	public void testHashSet() {
		Set<People> peoples = new HashSet<>();
		People p1 = new People(20, "tiny", 175f);
		People p2 = new People(20, "puck", 178f);
		People p3 = new People(22, "tiny", 175f);
		People p4 = new People(20, "tiny", 175f);
		peoples.add(p1);
		peoples.add(p2);
		peoples.add(p3);
		peoples.add(p4);

		Assert.assertTrue(peoples.size() == 3);
	}

	@Test
	public void testTreeSet() {
		Set<People> peoples = new TreeSet<>();
		People p1 = new People(20, "tiny", 175f);
		People p2 = new People(20, "puck", 178f);
		People p3 = new People(22, "tiny", 175f);
		People p4 = new People(20, "tiny", 175f);
		peoples.add(p1);
		peoples.add(p2);
		peoples.add(p3);
		peoples.add(p4);

		Assert.assertTrue(peoples.size() == 2);
	}

	private static class People implements Comparable<People> {
		private int age;
		private String name;
		private float height;

		public People(int age, String name, float height) {
			super();
			this.age = age;
			this.name = name;
			this.height = height;
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + age;
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			People other = (People) obj;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		@Override
		public int compareTo(People o) {

			return new Float(this.height).compareTo(o.height);
		}

	}
}
