package com.niuhp.corejava.features.java7;

import java.util.Collection;

public class HeapPollution {

	@SuppressWarnings("unchecked")
	public <E> void addToCollection(Collection<E> c, E... elements) {
		for (E element : elements) {
			c.add(element);
		}
	}

}
