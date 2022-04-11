package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.stream.Collectors;

public class StreamsJoiningExample {

	public static String joining() {

		return Arrays.asList("String","ABD").stream() // stream
				.collect(Collectors.joining()); // appends
	}

	public static String joiningWithDelimiter() {
		return StudentDataBase.getAllStudents().stream() // stream
				.map(Student::getName) // Stream<String>
				.collect(Collectors.joining("-")); // appends
	}

	public static String joiningWithDelimiterWithPrefix() {
		return StudentDataBase.getAllStudents().stream() // stream
				.map(Student::getName) // Stream<String>
				.collect(Collectors.joining("-", "[", "]")); // appends
	}

	public static void main(String[] args) {
		System.out.println("Names : " + joining());
		System.out.println("Names With Delimiter : " + joiningWithDelimiter());
		System.out.println("Names With Delimiter Prefix and Suffix : " + joiningWithDelimiterWithPrefix());
	}
}
