package com.niuhp.corejava.features.java8.time;

import java.time.Clock;
import java.time.Instant;
import java.util.Date;

public class Clocks {

	public void clock() {
		Clock clock = Clock.systemDefaultZone();
		long mills = clock.millis();
		Instant instant = clock.instant();
		Date d1 = Date.from(instant);
		Date d2 = new Date(mills);
		d1.after(d2);
	}
}
