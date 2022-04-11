package com.java8.features.BiFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;

class Student {
	String name;
	String rollNo;

	public Student(String name, String rollNo) {
		super();
		this.name = name;
		this.rollNo = rollNo;
	}

	public String toString() {
		return name + " " + rollNo;
	}
}

public class BiFunctionCase2 {

	public static void main(String[] args) {
		getProductofTwoNumber();
		createStudent();
	}

	private static void createStudent() {
		List<Student> list = new ArrayList<Student>();
		BiFunction<String, String, Student> bifunc = (name, rollno) -> new Student(name, rollno);
		list.add(bifunc.apply("Durga", "100"));
		list.add(bifunc.apply("Hello", "200"));
		System.out.println("Student list :- " + list);
	}

	private static void getProductofTwoNumber() {
		BiFunction<Integer, Integer, Integer> bipred = (a, b) -> (a * b);
		System.out.println(bipred.apply(10, 20));
		System.out.println(bipred.apply(15, 20));
	}

}
