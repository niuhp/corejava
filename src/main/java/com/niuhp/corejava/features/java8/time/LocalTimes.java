package com.niuhp.corejava.features.java8.time;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

public class LocalTimes {

	public void localTime() {
		LocalTime t1 = LocalTime.now();

		DateTimeFormatter germanFormatter = DateTimeFormatter.ofLocalizedTime(FormatStyle.SHORT).withLocale(
				Locale.GERMAN);

		LocalTime t2 = LocalTime.parse("20:21", germanFormatter);
		t1.isAfter(t2);
		ChronoUnit.HOURS.between(t1, t2);
	}
}
