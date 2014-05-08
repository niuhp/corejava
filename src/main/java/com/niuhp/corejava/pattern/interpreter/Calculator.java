package com.niuhp.corejava.pattern.interpreter;

import java.util.Stack;

public class Calculator {

	private Node node;

	public void build(String statement) {
		Node left = null;
		Node right = null;
		Stack<Node> stack = new Stack<>();

		String[] statementArr = statement.split(" ");

		for (int i = 0; i < statementArr.length; i++) {
			String symbol = statementArr[i];
			switch (symbol) {
			case "*": {
				left = (Node) stack.pop();
				double val = Double.parseDouble(statementArr[++i]);
				right = new ValueNode(val);
				stack.push(new MulNode(left, right));
				break;
			}
			case "/": {
				left = (Node) stack.pop();
				double val = Double.parseDouble(statementArr[++i]);
				right = new ValueNode(val);
				stack.push(new DivNode(left, right));
				break;
			}
			default:
				stack.push(new ValueNode(Double.parseDouble(statementArr[i])));
			}

		}
		this.node = (Node) stack.pop();
	}

	public double compute() {
		return node.interpret();
	}
}
