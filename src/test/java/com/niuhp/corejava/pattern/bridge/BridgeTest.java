package com.niuhp.corejava.pattern.bridge;

import org.junit.Test;

public class BridgeTest {

	@Test
	public void testBridge() {
		DrinkSingleton.getInstance().setDrink(new DrinkImpl2());

		Drinking d1 = new DrinkingImpl1();
		d1.havaDrink();

		System.out.println("----------------------------------");

		Drinking d2 = new DrinkingImpl2();
		d2.havaDrink();
	}
}
