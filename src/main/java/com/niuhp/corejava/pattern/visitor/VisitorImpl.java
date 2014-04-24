package com.niuhp.corejava.pattern.visitor;

import java.util.Collection;

public class VisitorImpl implements Visitor {

	public void visitCollection(Collection<?> c) {
		if (c == null || c.isEmpty()) {
			return;
		}
		
		for (Object o : c) {
			if (o instanceof Visitable) {
				Visitable v = (Visitable) o;
				v.accept(this);
			} else {
				System.out.println(o + " is not visitable !");
			}
		}

	}

	public void visitString(String s) {
		System.out.println("String[" + s + "]");

	}

	public void visitFloat(Float f) {
		System.out.println("Float[" + f + "]");

	}

	public void visitObject(Object o) {
		System.out.println("object[" + o + "]");

	}

}
