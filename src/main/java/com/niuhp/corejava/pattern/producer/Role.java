package com.niuhp.corejava.pattern.producer;

import java.util.Random;

public abstract class Role extends Thread {

	protected Market market;
	protected static final Random RAN = new Random();

	public Role(Market market) {
		this.market = market;
	}
}
