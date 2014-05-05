package com.niuhp.corejava.pattern.builder;

import java.util.ArrayList;
import java.util.Collection;

public class ConcreteProduct implements Product {
	private Collection<Part> parts;

	@Override
	public boolean addPart(Part part) {
		if (parts == null) {
			parts = new ArrayList<>();
		}

		return parts.add(part);
	}

	@Override
	public boolean removePart(Part part) {
		if (parts == null) {
			return false;
		}
		return parts.remove(part);
	}

	@Override
	public Part[] getAllPart() {
		if (parts == null) {
			return null;
		}
		return parts.toArray(new Part[0]);
	}

	@Override
	public String toString() {
		return "ConcreteProduct [parts=" + parts + "]";
	}

}
