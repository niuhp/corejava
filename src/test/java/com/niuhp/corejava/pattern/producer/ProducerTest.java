package com.niuhp.corejava.pattern.producer;

import java.time.Clock;

import org.junit.Test;

public class ProducerTest {

	@Test
	public void testProducer() {

		Clock clock = Clock.systemDefaultZone();

		Market market = new Market(150, 10);

		long t1 = clock.millis();
		long t2 = clock.millis();
		while (t2 - t1 < 10000) {
			Role c = new Consumer(market);
			c.start();

			Role p = new Producer(market);
			p.start();

			t2 = clock.millis();
		}
	}
}
