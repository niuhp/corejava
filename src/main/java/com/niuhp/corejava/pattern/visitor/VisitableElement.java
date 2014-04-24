package com.niuhp.corejava.pattern.visitor;

public abstract class VisitableElement<T> implements Visitable {

	protected T element;

	public VisitableElement(T element) {
		this.element = element;
	}

	public T getElement() {
		return element;
	}

	public void setElement(T element) {
		this.element = element;
	}

}
