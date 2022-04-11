package com.java8.features.datatimeapi;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.Period;
import java.time.Year;
import java.util.Scanner;

public class LocalDateExample {

	public static void isLeapYear() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter year");
		int n = sc.nextInt();
		Year y = Year.of(n);
		if (y.isLeap()) {
			System.out.println("It is Leap Year " + y);
		} else {
			System.out.println("It is Not Leap Year " + y);
		}
	}

	public static void main(String[] args) {
		LocalDate date = LocalDate.now();
		System.out.println("date:- " + date);

		int dd = date.getDayOfMonth();

		Month month = date.getMonth();
		System.out.println("month :- " + month);

		int mm = date.getMonthValue();

		int yyyy = date.getYear();

		System.out.printf("%d-%d-%d", dd, mm, yyyy);
		System.out.println();

		LocalTime time = LocalTime.now();
		System.out.println("time:-" + time);

		int h = time.getHour();
		int m = time.getMinute();
		int s = time.getSecond();
		int n = time.getNano();
		System.out.printf("\n%d:%d:%d:%d", h, m, s, n);

		System.out.println();

		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println("dateTime :- " + dateTime);

		LocalDateTime dateTime1 = LocalDateTime.of(2017, 7, 17, 23, 30, 45, 900);
		System.out.println("dateTime1 :- " + dateTime1);

		System.out.println("After six months:" + dateTime1.plusMonths(6));

		System.out.println("Before six months:" + dateTime1.minusMonths(6));

		// calculate the age:-
		LocalDate birthDay = LocalDate.of(1989, 9, 14);
		LocalDate today = LocalDate.now();
		Period p = Period.between(birthDay, today);
		System.out.printf("you age is %d years %d months %d days", p.getYears(), p.getMonths(), p.getDays());

		System.out.println();
		// Death Date
		LocalDate deathDay = LocalDate.of(1989 + 60, 9, 14);
		Period p1 = Period.between(today, deathDay);
		int d = p1.getYears() * 365 + p1.getMonths() * 30 + p1.getDays();
		System.out.printf("Days left on earth %d ", d);

		System.out.println();
		isLeapYear();

	}
}
