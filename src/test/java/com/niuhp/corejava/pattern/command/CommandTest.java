package com.niuhp.corejava.pattern.command;

import org.junit.Test;

public class CommandTest {

	@Test
	public void testCommand() {
		Receiver r = new Receiver();
		ICommand c = () -> {
			r.action();
		};// new Command(r);

		Invoker v = new Invoker(c);
		v.action();
	}
}
