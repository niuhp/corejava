package com.niuhp.corejava.features.java8.annotations;

import java.lang.annotation.Repeatable;

@Repeatable(Anns.class)
public @interface Ann {
	int value();
}
