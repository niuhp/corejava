package com.niuhp.corejava.pattern.composite;

public class Board extends Equipment {

	public Board() {
		super("ZhuBan");
	}

	@Override
	public float selfPrice() {
		return 699;
	}

}
