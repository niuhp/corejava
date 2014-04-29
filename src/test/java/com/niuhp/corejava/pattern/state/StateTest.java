package com.niuhp.corejava.pattern.state;

import org.junit.Test;

public class StateTest {

	@Test
	public void testState() {
		ColorState cs = new RedState();

		StateManager sm = new StateManager();

		sm.setColorState(cs);

		System.out.println("----------doPush----------");

		sm.push();
		sm.push();
		sm.push();
		sm.push();

		System.out.println("----------doPoll----------");

		sm.poll();
		sm.poll();
		sm.poll();
		sm.poll();
	}
}
