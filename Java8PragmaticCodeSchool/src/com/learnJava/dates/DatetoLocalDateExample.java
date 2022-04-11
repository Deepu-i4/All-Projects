package com.learnJava.dates;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Date;

public class DatetoLocalDateExample {

	public static void main(String[] args) {
		// 1. java.util.Date deals with Instant directly.
		/**
		 * java.util.Date to LocalDate
		 */
		Date date = new Date();
		Instant instant = date.toInstant();
		ZonedDateTime zonedDateTime = instant.atZone(ZoneId.of("America/Chicago"));
		LocalDate localDate = zonedDateTime.toLocalDate();
		System.out.println("java.util.Date to LocalDate :- " + localDate);

		/**
		 * LocalDate to java.util.Date.
		 */
		LocalDateTime localDateTime = localDate.atTime(LocalTime.now());
		ZonedDateTime zonedDateTime1 = localDateTime.atZone(ZoneId.systemDefault());
		Instant instant1 = zonedDateTime.toInstant();
		Date date1 = new Date().from(instant1);
		System.out.println("LocalDate to java.util.Date :- " + date1);

		// 2. java.sql.Date deals with LocalDate directly.
		/**
		 * LocalDate to java.sql.Date.
		 */
		java.sql.Date date2 = java.sql.Date.valueOf(localDate);
		System.out.println("LocalDate to java.sql.Date :- " + date2);

		/**
		 * java.sql.Date to LocalDate
		 */
		LocalDate localDate2 = date2.toLocalDate();
		System.out.println("java.sql.Date to LocalDate :- " + localDate2);
	}
}
