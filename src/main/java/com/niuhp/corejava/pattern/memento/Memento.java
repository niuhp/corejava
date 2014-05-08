package com.niuhp.corejava.pattern.memento;

public class Memento extends Originator {

	public Memento(Originator originator) {
		setName(originator.getName());
		setNumber(originator.getNumber());
	}
}
