package com.niuhp.corejava.pattern.visitor;

public class StringElement extends VisitableElement<String> {

	public StringElement(String element) {
		super(element);
	}

	public void accept(Visitor v) {
		v.visitString(element);

	}
}
