package com.niuhp.corejava.features.java8.intface;

public interface DefaultImplInInterface {

	void eatFood();

	void eatFood(String food);

	default String getType() {
		return "animal";
	}

	default String getName() {
		return "animal's name";
	}
}
