package com.java8.features.BiFunctionalInterface;

import java.util.function.BiFunction;

class Employe {
	int eno;
	String name;
	Double dailyWages;

	public Employe(final int eno, final String name, final Double dailyWages) {
		super();
		this.eno = eno;
		this.name = name;
		this.dailyWages = dailyWages;
	}

	public String toString() {
		return eno + " " + name + " " + dailyWages;
	}
}

class TimeSheet {
	int eno;
	int days;

	public TimeSheet(final int eno, final int days) {
		super();
		this.eno = eno;
		this.days = days;
	}

}

public class BiFunctionCase {

	public static void main(final String[] args) {
		final BiFunction<Employe, TimeSheet, Double> bifunc = (e, t) -> e.dailyWages * t.days;
		final Employe emp = new Employe(101, "Pushpendra", 3000.00);
		final TimeSheet timeSheet = new TimeSheet(101, 25);
		System.out.println(emp.name + " Total Salary :- " + bifunc.apply(emp, timeSheet));

	}

}
