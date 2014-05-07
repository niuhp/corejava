package com.niuhp.corejava.pattern.composite;

public class Disk extends Equipment {

	public Disk() {
		super("YingPan");
	}

	@Override
	public float selfPrice() {

		return 399;
	}

}
