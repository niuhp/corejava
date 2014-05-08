package com.niuhp.corejava.pattern.mediator;

public class Colleague {

	private String name;
	private Mediator mediator;

	public Colleague(String name, Mediator mediator) {
		this.name = name;
		this.mediator = mediator;
	}

	public void doSelf() {
		System.out.println(name + " do his job carefully!");
	}

	public void requestOther(String otherName) {
		System.out.println(name + " request " + otherName + " do his job carefully!");
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Mediator getMediator() {
		return mediator;
	}

	public void setMediator(Mediator mediator) {
		this.mediator = mediator;
	}

}
