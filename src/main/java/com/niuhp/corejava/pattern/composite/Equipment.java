package com.niuhp.corejava.pattern.composite;

import java.util.ArrayList;
import java.util.Collection;

public abstract class Equipment implements Priceable<Equipment> {

	private String name;

	private Collection<Equipment> equipments = new ArrayList<>();

	public Equipment() {

	}

	public Equipment(String name) {
		this.name = name;
	}

	@Override
	public float countPrice() {
		float countPrice = selfPrice();
		Equipment[] subs = subs();
		if (subs != null && subs.length != 0) {
			for (Equipment sub : subs) {
				countPrice += sub.countPrice();
			}
		}
		return countPrice;
	}

	@Override
	public boolean addSub(Equipment sub) {

		return equipments.add(sub);
	}

	@Override
	public boolean removeSub(Equipment sub) {

		return equipments.remove(sub);
	}

	@Override
	public Equipment[] subs() {

		return equipments.toArray(new Equipment[0]);
	}

	@Override
	public void removeAllSub() {
		equipments.clear();
	}

	@Override
	public String toString() {
		return "Equipment [name=" + name + ",selfPrice=" + selfPrice() + "]";
	}

}
