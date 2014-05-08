package com.niuhp.corejava.pattern.interpreter;

public class DivNode extends SymbolNode {

	public DivNode(Node left, Node right) {
		super(left, right);
	}

	@Override
	public double interpret() {
		return left.interpret() / right.interpret();
	}

}
