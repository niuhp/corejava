package com.niuhp.corejava.pattern.visitor;

public class FloatElement extends VisitableElement<Float> {

	public FloatElement(Float element) {
		super(element);
	}

	public void accept(Visitor v) {
		v.visitFloat(element);
	}

}
