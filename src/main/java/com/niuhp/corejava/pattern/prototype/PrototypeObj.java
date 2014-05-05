package com.niuhp.corejava.pattern.prototype;

public class PrototypeObj implements Cloneable {

	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public PrototypeObj clone() {

		try {
			return (PrototypeObj) super.clone();
		} catch (CloneNotSupportedException e) {
			return null;
		}
	}

}
