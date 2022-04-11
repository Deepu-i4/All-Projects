package com.learnJava.streams_terminal;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.List;
import java.util.Set;

import static java.util.stream.Collectors.*;

public class StreamsMappingExample {

	public static void main(String[] args) {

		Set<String> namesSet = StudentDataBase.getAllStudents().stream() // stream
				.collect(mapping(Student::getName, toSet())); // this
		System.out.println("namesSet : " + namesSet);
		List<String> namesList = StudentDataBase.getAllStudents().stream() // stream
				.collect(mapping(Student::getName, toList())); // this
		System.out.println("namesList : " + namesList);

	}

}
