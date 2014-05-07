package com.niuhp.corejava.pattern.composite;

public interface Priceable<T> {

	float selfPrice();

	float countPrice();

	boolean addSub(T sub);

	boolean removeSub(T sub);

	T[] subs();

	void removeAllSub();
}
