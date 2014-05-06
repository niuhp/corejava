package com.niuhp.corejava.pattern.proxy;

public class DBForum implements Forum {

	private String name;

	@Override
	public void setName(String name) {
		this.name = name;
		// other operations

	}

	public String getName() {
		return name;
	}

}
