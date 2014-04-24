package com.niuhp.corejava.pattern.bridge;

public class DrinkSingleton {
	private static DrinkSingleton DS;
	private Drink drink;

	private DrinkSingleton() {

	}

	public static DrinkSingleton getInstance() {
		if (DS == null) {
			DS = new DrinkSingleton();
		}
		return DS;
	}

	public Drink getDrink() {
		return drink;
	}

	public void setDrink(Drink drink) {
		this.drink = drink;
	}

}
