package com.niuhp.corejava.pattern.adapter;

public class EatAdapter extends SpeakImpl {

	private IEat eat;

	public EatAdapter(IEat eat) {
		this.eat = eat;
	}

	public void eat() {
		eat.eat();
	}
}
