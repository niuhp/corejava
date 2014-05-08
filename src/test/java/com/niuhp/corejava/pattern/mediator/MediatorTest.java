package com.niuhp.corejava.pattern.mediator;

import org.junit.Test;

public class MediatorTest {

	@Test
	public void testMediatorTest() {

		Mediator m = new Mediator();

		Colleague c1 = new Colleague("tiny", m);

		Colleague c2 = new Colleague("puck", m);

		m.addColleague(c1);

		m.addColleague(c2);

		c1.doSelf();
		c1.requestOther("puck");

		c2.doSelf();
		c2.requestOther("tiny");
	}
}
