package com.niuhp.corejava.pattern.command;

public class Command implements ICommand {

	private Receiver receiver;

	public Command(Receiver receiver) {
		this.receiver = receiver;
	}

	@Override
	public void excute() {
		receiver.action();

	}

}
