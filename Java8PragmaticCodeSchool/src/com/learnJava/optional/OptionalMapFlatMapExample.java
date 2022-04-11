package com.learnJava.optional;

import com.learnJava.data.Bike;
import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalMapFlatMapExample {

	public static void optionalFlatMap() {
		Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();
		if (studentOptional.isPresent()) {
			Optional<Bike> bikeOptional = studentOptional // optional
					.flatMap(Student::getBike);
			// get value of optional object inside the other optional object
			System.out.println("bikeOptional : " + bikeOptional.get());
		}
	}

	public static void optionalFlatMap1() {
		Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();
		if (studentOptional.isPresent()) {
			Optional<String> bikeName = studentOptional // optional
					.flatMap(Student::getBike).map(Bike::getName);
			// get value of optional object inside the other optional object
			System.out.println("bikeName : " + bikeName.get());
		}
	}

	public static void optionalMap() {
		Optional<Student> studentOptional = StudentDataBase.getOptionalStudent();
		if (studentOptional.isPresent()) {
			Optional<String> nameOptional = studentOptional // Optional
					.filter(student -> student.getGpa() >= 3) // filter
					.map(Student::getName); // name
			System.out.println("nameOptional : " + nameOptional);
		}
	}

	public static void optionalFilter() {
		Optional<Student> studentOptional = StudentDataBase.getOptionalStudent()
				.filter(student -> student.getGpa() >= 3);
		studentOptional.ifPresent(student -> System.out.println(student));
	}

	public static void main(String[] args) {
		optionalFlatMap();
		optionalFlatMap1();
		optionalMap();
		optionalFilter();
	}
}
