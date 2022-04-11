package com.learnJava.dates;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Period;

public class ComparingDatesPeriodExample {

	public static void main(String[] args) {
		LocalDate localDate = LocalDate.of(2018, 01, 01);
		LocalDate localDate1 = LocalDate.of(2018, 12, 31);
		/**
		 * until - Period
		 */
		Period period = localDate.until(localDate1);
		System.out.println("getDays : " + period.getDays()); // results in 30 days performs (31-1)
		System.out.println("getMonths : " + period.getMonths()); // results in 0 days (12-01)
		System.out.println("getYears : " + period.getYears());
		System.out.println("**************************************");

		Period period1 = Period.ofDays(10);
		System.out.println("period1 getDays : " + period1.getDays());
		System.out.println("**************************************");

		Period period2 = Period.ofYears(20);
		System.out.println("period2 getYears : " + period2.getYears());
		System.out.println("period2 toTotalMonths : " + period2.toTotalMonths());
		System.out.println("period2 getDays : " + period2.getDays());
		System.out.println("**************************************");

		Period period3 = Period.between(localDate, localDate1);
		System.out.println("period3 getDays : " + period3.getDays());
		System.out.println("period3 getMonths : " + period3.getMonths());
		System.out.println("period3 getYears : " + period3.getYears());
		// This is only to compare LocalDate. It dont take LocalTime
	}
}
