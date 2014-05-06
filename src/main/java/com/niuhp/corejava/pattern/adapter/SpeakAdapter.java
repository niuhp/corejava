package com.niuhp.corejava.pattern.adapter;

public class SpeakAdapter extends EatImpl {

	private ISpeak speak;

	public SpeakAdapter(ISpeak speak) {
		this.speak = speak;
	}

	public void speak() {
		speak.speak();
	}
}
