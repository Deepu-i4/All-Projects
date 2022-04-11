package com.java8.features.datatimeapi;

import java.time.ZoneId;
import java.time.ZonedDateTime;

public class LocalDateExample2 {

	public static void main(String[] args) {
		ZoneId zone = ZoneId.systemDefault();
		System.out.println(zone);

		ZoneId zoned = ZoneId.of("America/Los_Angeles");
		ZonedDateTime dt = ZonedDateTime.now(zoned);
		System.out.println(dt);
	}
}
