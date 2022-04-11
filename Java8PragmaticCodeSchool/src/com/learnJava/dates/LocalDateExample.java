package com.learnJava.dates;

import java.time.*;
import java.time.temporal.*;

public class LocalDateExample {
	public static void main(String[] args) {
		LocalDate localDate = LocalDate.now();
		System.out.println("Current Date is " + localDate);

		LocalDate localDate1 = LocalDate.of(2018, 03, 03);
		System.out.println("localDate1 :- " + localDate1);

		System.out.println("Year Day Date :- " + LocalDate.ofYearDay(2018, 02));
		System.out.println("Epoch Day :- " + LocalDate.ofEpochDay(1));
		/**
		 * Getting Values from Local Date
		 */
		System.out.println("getMonth :- " + localDate.getMonth());
		System.out.println("getMonthValue:- " + localDate.getMonthValue());
		System.out.println("getDayOfWeek:- " + localDate.getDayOfWeek());
		System.out.println("getDayOfYear:- " + localDate.getDayOfYear());
		System.out.println("getYear:- " + localDate.getYear());
		System.out.println("Day of Month using get : " + localDate.get(ChronoField.DAY_OF_MONTH));
		System.out.println("Day of Week using get : " + localDate.get(ChronoField.DAY_OF_WEEK));
		/**
		 * Modifying Values in Local Date
		 */
		System.out.println("Plus Weeks  : " + localDate.plusWeeks(1));
		System.out.println("Plus Years : " + localDate.plusYears(1));
		System.out.println("Plus Days " + localDate.plusDays(1));
		System.out.println("Plus Months : " + localDate.plusMonths(1));
		System.out.println("Minus Months : " + localDate.minusMonths(1));
		System.out.println("Chrono Unit : " + localDate.minus(2, ChronoUnit.YEARS));
		System.out.println("With Year : " + localDate.withYear(2019));
		System.out.println("With Year Chrono Field : " + localDate.with(ChronoField.YEAR, 2020));
		System.out.println(
				"With Temporal Adjusters lastDayOfMonth : " + localDate.with(TemporalAdjusters.lastDayOfMonth()));
		System.out.println("With Temporal Adjusters dayOfWeekInMonth : "
				+ localDate.with(TemporalAdjusters.dayOfWeekInMonth(1, DayOfWeek.FRIDAY)));
		/*
		 * Additional Support Methods
		 */
		System.out.println("Not a Leap Year : " + localDate.isLeapYear());
		System.out.println("Leap Year : " + LocalDate.of(2020, 01, 31).isLeapYear());
		System.out.println("isBefore : " + localDate1.isBefore(localDate));
		System.out.println("isAfter : " + localDate1.isAfter(localDate));
		System.out.println("isEqual : " + localDate1.isEqual(localDate));
		/**
		 * Unsupported Scenarios
		 */
		// System.out.println("Chrono Unit : " + localDate.minus(2,ChronoUnit.SECONDS));
		System.out.println("is Supported : " + localDate.isSupported(ChronoUnit.SECONDS));
		System.out.println("is Supported : " + localDate.isSupported(ChronoUnit.DAYS));
	}
}
