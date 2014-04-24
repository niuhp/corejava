package com.niuhp.corejava.pattern.state;

import junit.framework.TestCase;

public class StateTest extends TestCase {

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
