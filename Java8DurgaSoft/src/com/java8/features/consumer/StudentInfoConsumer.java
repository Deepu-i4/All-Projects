package com.java8.features.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

class Student {
	private String name;
	private int marks;

	public Student(String name, int marks) {
		super();
		this.name = name;
		this.marks = marks;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMarks() {
		return marks;
	}

	public void setMarks(int marks) {
		this.marks = marks;
	}

	@Override
	public String toString() {
		return name + " " + marks;
	}

}

public class StudentInfoConsumer {

	private static void populate(List<Student> students) {
		students.add(new Student("Pushpendra", 80));
		students.add(new Student("Salma", 90));
		students.add(new Student("Rakesh", 55));
		students.add(new Student("Bhadu", 50));
		students.add(new Student("Nandu", 40));
		students.add(new Student("Amit", 63));
		students.add(new Student("Sumit", 73));
	}

	public static void main(String[] args) {
		List<Student> students = new ArrayList<Student>();
		populate(students);

		Predicate<Student> predicate = s -> s.getMarks() > 60;

		Function<Student, String> gradefn = s -> {
			int marks = s.getMarks();
			if (marks >= 80) {
				return "A Grade";
			} else if (marks >= 60) {
				return "B Grade";
			} else if (marks >= 50) {
				return "C Grade";
			} else if (marks >= 35) {
				return "D Grade";
			}
			return "Failure";
		};

		Consumer<Student> consumer = s -> {
			System.out.println("Student Name : " + s.getName());
			System.out.println("Student Marks : " + s.getMarks());
			System.out.println("Student Grade : " + gradefn.apply(s));
			System.out.println("*************************************");
		};

		for (Student student : students) {
			if (predicate.test(student)) {
				consumer.accept(student);
			}
		}

	}

}
