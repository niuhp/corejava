package com.niuhp.corejava.features.java8.time;

import java.time.ZoneId;
import java.util.Set;

public class TimeZones {

	public void timeZone() {
		Set<String> zoneIds = ZoneId.getAvailableZoneIds();
		zoneIds.forEach(System.out::print);
		ZoneId zoneId = ZoneId.of("Europe/Berlin");
		zoneId.getRules();
	}
}
