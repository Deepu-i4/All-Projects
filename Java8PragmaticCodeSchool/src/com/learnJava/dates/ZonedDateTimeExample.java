package com.learnJava.dates;

import java.time.*;
import java.time.zone.ZoneRules;

public class ZonedDateTimeExample {

	public static void main(String[] args) {
		// getZonesDetails();
		// getZones();
		// getAmericaZoneTimes();

		/**
		 * Local Date time using Zone Id.
		 */
		LocalDateTime localDateTime = LocalDateTime.now(ZoneId.of("America/Detroit"));
		System.out.println("Detroit1 :- " + localDateTime);

		LocalDateTime localDateTime1 = LocalDateTime.now(Clock.system(ZoneId.of("America/Detroit")));
		System.out.println("Detroit2 :- " + localDateTime1);

		/**
		 * LocalDateTime using Instant
		 */
		LocalDateTime localDateTime2 = LocalDateTime.ofInstant(Instant.now(), ZoneId.systemDefault());
		System.out.println("Instant LocalDate time :- " + localDateTime2);

		/**
		 * Convert LocalDateTime to ZonedDateTime
		 */
		ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.of("America/Chicago"));
		System.out.println("LocalDateTime to ZonedDateTime : " + zonedDateTime1);

		/**
		 * Convert Instant to ZonedDateTime
		 */
		ZonedDateTime zonedDateTime2 = Instant.now().atZone(ZoneId.of("America/Chicago"));
		System.out.println("Instant to ZonedDateTime : " + zonedDateTime2);

		/**
		 * Convert LocalDateTime to OffsetDateTime
		 */
		OffsetDateTime offsetDateTime = localDateTime.atOffset(ZoneOffset.ofHours(-6));
		System.out.println("offsetDateTime : " + offsetDateTime);

	}

	public static void getZonesDetails() {
		System.out.println("getAvailableZoneIds : " + ZoneId.getAvailableZoneIds());
		ZoneId.getAvailableZoneIds().forEach(zone -> {
			System.out.println("zone : " + zone);
		});
		System.out.println("No. Of Zones :- " + ZoneId.getAvailableZoneIds().size());
	}

	public static void getZones() {
		ZonedDateTime zonedDateTime = ZonedDateTime.now();
		System.out.println("zonedDateTime :- " + zonedDateTime);

		ZoneOffset zoneOffset = zonedDateTime.getOffset();
		System.out.println("zoneOffset :- " + zoneOffset);

		ZoneId zoneId = zonedDateTime.getZone();
		System.out.println("zoneId :- " + zoneId.getId());
	}

	private static void getAmericaZoneTimes() {
		/**
		 * Times in each zone
		 */
		System.out.println("Chicago CST     :- " + ZonedDateTime.now(ZoneId.of("America/Chicago")));
		System.out.println("Detroit EST     :- " + ZonedDateTime.now(ZoneId.of("America/Detroit")));
		System.out.println("LA PST :- " + ZonedDateTime.now(ZoneId.of("America/Los_Angeles")));
		System.out.println("Denver MST     :- " + ZonedDateTime.now(ZoneId.of("America/Denver")));
		System.out.println(
				"ZonedDate Time using Clock :- " + ZonedDateTime.now(Clock.system(ZoneId.of("America/Denver"))));

	}
}
