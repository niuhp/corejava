package com.niuhp.corejava.pattern.visitor;

public class ObjectElement extends VisitableElement<Object> {

	public ObjectElement(Object element) {
		super(element);
	}

	public void accept(Visitor v) {
		v.visitObject(element);

	}
}
