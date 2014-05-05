package com.niuhp.corejava.pattern.builder;

public interface Product {
	boolean addPart(Part part);

	boolean removePart(Part part);

	Part[] getAllPart();
}
