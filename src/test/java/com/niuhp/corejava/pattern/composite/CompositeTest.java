package com.niuhp.corejava.pattern.composite;

import org.junit.Test;

public class CompositeTest {

	@Test
	public void testComposite() {
		Equipment c = new Case();
		Equipment b = new Board();
		Equipment r1 = new RamMemory();
		Equipment r2 = new RamMemory();
		Equipment r3 = new RamMemory();
		Equipment r4 = new RamMemory();
		Equipment d1 = new Disk();
		Equipment d2 = new Disk();
		Equipment d3 = new Disk();

		b.addSub(r1);
		b.addSub(r2);
		b.addSub(r3);
		b.addSub(r4);

		c.addSub(b);
		c.addSub(d1);
		c.addSub(d2);
		c.addSub(d3);

		System.out.println(c + "---" + c.countPrice());

	}
}
