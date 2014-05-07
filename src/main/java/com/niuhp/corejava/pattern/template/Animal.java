package com.niuhp.corejava.pattern.template;

public abstract class Animal {
	protected abstract void speak();

	public void speak(int count) {
		for (int i = 0; i < count; i++) {
			speak();
		}
	}
}
