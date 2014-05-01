package com.niuhp.corejava.features.java8.time;

import java.time.LocalDateTime;
import java.time.Month;

public class LocalDateTimes {

	public void dateTime() {
		LocalDateTime sylvester = LocalDateTime.of(2014, Month.DECEMBER, 31, 23, 59, 59);
		sylvester.getChronology();
		// operations of sylvester
	}
}
