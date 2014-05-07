package com.niuhp.corejava.pattern.template;

import org.junit.Test;

public class TemplateTest {

	@Test
	public void testTemplate() {
		Animal cat = new Cat();
		Animal dog = new Dog();

		cat.speak(5);

		dog.speak(3);
	}
}
