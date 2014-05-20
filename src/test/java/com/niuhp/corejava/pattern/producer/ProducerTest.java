package com.niuhp.corejava.pattern.producer;

import java.time.Clock;

import org.junit.Test;

public class ProducerTest {

	@Test
	public void testProducer() {

		Clock clock = Clock.systemDefaultZone();

		Market market = new Market(10, 150);

		long t1 = clock.millis();
		long t2 = clock.millis();
		while (market.getCurrent() != 0 && (t2 - t1 < 20000)) {
			Role c = new Consumer(market);
			c.start();

			if (market.getCurrent() == 0) {
				break;
			}

			Role p = new Producer(market);
			p.start();

			t2 = clock.millis();
		}
	}
}
