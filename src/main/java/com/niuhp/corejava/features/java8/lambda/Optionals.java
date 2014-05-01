package com.niuhp.corejava.features.java8.lambda;

import java.util.Optional;

public class Optionals {

	public void optional() {
		Optional<String> op = Optional.of("hello");
		op.isPresent();
		op.get();
		op.orElse("hi");
		op.ifPresent((s) -> System.out.println(s));
	}
}
