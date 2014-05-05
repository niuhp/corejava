package com.niuhp.corejava.pattern.builder;

public class ConcretePart implements Part {

	private String label;

	public ConcretePart(String label) {
		this.label = label;
	}

	@Override
	public String toString() {
		return label;
	}

}
