package com.niuhp.corejava.pattern.builder;

public interface Builder {

	void buildPartA();

	void buildPartB();

	void buildPartC();

	Product getResult();
}
