package com.niuhp.corejava.pattern.command;

public class Invoker {
	private ICommand command;

	public Invoker(ICommand command) {
		this.command = command;
	}

	public void action() {
		command.excute();
	}
}
