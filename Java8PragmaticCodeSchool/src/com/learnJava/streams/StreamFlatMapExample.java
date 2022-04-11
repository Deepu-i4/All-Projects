package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;

import static java.util.stream.Collectors.toList;

public class StreamFlatMapExample {

	public static List<String> printStudentActivities() {

		List<String> studentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.collect(toList());

		return studentActivities;

	}

	public static List<String> printUniqueStudentActivities() {

		List<String> studentActivities = StudentDataBase.getAllStudents().stream() // Stream<Student>
				.map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct() // Stream<String> -> with distinct function performed
				.sorted() // Stream<String> -> with sorted function performed
				.collect(toList()); // Collect as list

		return studentActivities;

	}

	public static long getStudentActivitiesCount() {

		long totalActivities = StudentDataBase.getAllStudents().stream().map(Student::getActivities) // Stream<List<String>>
				.flatMap(List::stream) // Stream<String>
				.distinct() // Stream<String> -> with distinct function performed
				.count(); // count of all items

		return totalActivities;

	}

	public static void main(String[] args) {

		System.out.println("Student Activities : " + printStudentActivities());
		System.out.println("Unique Student Activities : " + printUniqueStudentActivities());
		System.out.println("Unique Student Activities Count: " + getStudentActivitiesCount());

	}

}
