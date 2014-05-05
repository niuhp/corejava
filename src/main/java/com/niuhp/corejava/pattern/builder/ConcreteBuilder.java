package com.niuhp.corejava.pattern.builder;

public class ConcreteBuilder implements Builder {
	private Part partA;
	private Part partB;
	private Part partC;

	@Override
	public void buildPartA() {
		partA = new ConcretePart("partA");
		System.out.println("partA completeed.");
	}

	@Override
	public void buildPartB() {
		partB = new ConcretePart("partB");
		System.out.println("partB completeed.");

	}

	@Override
	public void buildPartC() {
		partC = new ConcretePart("partC");
		System.out.println("partC completeed.");

	}

	@Override
	public Product getResult() {
		Product product = new ConcreteProduct();
		product.addPart(partA);
		product.addPart(partB);
		product.addPart(partC);
		return product;
	}

}
