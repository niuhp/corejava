package com.niuhp.corejava.pattern.decorator;

import org.junit.Test;

public class DecoratorTest {

	@Test
	public void testDecorator() {
		Download d1 = new Download() {

			public void doJob() {
				System.out.println("----downloading....");

			}
		};

		Download dd = new Downloador(d1) {
			@Override
			protected void beforeDoJob() {
				System.out.println("---login in-----");
			}

			@Override
			protected void afterDoJob() {
				System.out.println("---login out-----");
			}
		};

		Download d = new Downloador(dd) {
			@Override
			protected void beforeDoJob() {
				System.out.println("---connecting-----");
			}

			@Override
			protected void afterDoJob() {
				System.out.println("---disconnecting-----");
			}
		};

		d.doJob();
	}
}
