package com.niuhp.corejava.features.java8.time;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LocalDates {

	public void localDate() {
		LocalDate today = LocalDate.now();
		LocalDate tomorrow = today.plus(1, ChronoUnit.DAYS);
		LocalDate yesterday = today.minusDays(1);
		tomorrow.isAfter(yesterday);
	}
}
