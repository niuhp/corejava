package com.niuhp.corejava.pattern.visitor;

import java.util.Collection;

public interface Visitor {

	void visitCollection(Collection<?> c);

	void visitString(String s);

	void visitFloat(Float f);

	void visitObject(Object o);
}
