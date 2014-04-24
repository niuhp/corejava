package com.niuhp.corejava.pattern.bridge;

public class DrinkingImpl2 implements Drinking {

	public void havaDrink() {
		Drink drink = DrinkSingleton.getInstance().getDrink();
		for (int i = 0; i < 3; i++) {
			drink.haveDrink();
		}
	}
}
