package com.niuhp.corejava.pattern.bridge;

import junit.framework.TestCase;

public class BridgeTest extends TestCase {

	public void testBridge() {
		DrinkSingleton.getInstance().setDrink(new DrinkImpl2());

		Drinking d1 = new DrinkingImpl1();
		d1.havaDrink();

		System.out.println("----------------------------------");

		Drinking d2 = new DrinkingImpl2();
		d2.havaDrink();
	}
}
