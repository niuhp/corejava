package com.niuhp.corejava.pattern.interpreter;

public class MulNode extends SymbolNode {

	public MulNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double interpret() {
		return left.interpret() * right.interpret();
	}

}
