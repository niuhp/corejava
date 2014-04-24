package com.niuhp.corejava.pattern.bridge;

public class DrinkingImpl1 implements Drinking {

	public void havaDrink() {
		Drink drink = DrinkSingleton.getInstance().getDrink();
		drink.haveDrink();
	}
}
