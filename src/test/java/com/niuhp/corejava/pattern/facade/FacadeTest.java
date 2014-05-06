package com.niuhp.corejava.pattern.facade;

import org.junit.Test;

public class FacadeTest {

	@Test
	public void testFacade() throws InterruptedException {
		final AnimalFacade af = new AnimalFacade();

		// final Clock clock = Clock.systemDefaultZone();
		// long t1 = clock.millis();
		Thread thread1 = new Thread() {
			@Override
			public void run() {
				while (Cat.getInstanceCount() < 100) {
					// synchronized (af) {
					af.addAnimal(new Cat());
					// }
				}
			}
		};

		Thread thread2 = new Thread() {
			@Override
			public void run() {
				while (Dog.getInstanceCount() < 100) {
					// synchronized (af) {
					af.addAnimal(new Dog());
					// }
				}
			}
		};

		thread1.start();
		thread2.start();

		thread1.join();
		thread2.join();

		af.allSpeak();
	}
}
