package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class StreamReduceExample {

	public static int performMultiplication(List<Integer> integerList) {

		return integerList.stream()
				// 1
				// 3
				// 5
				// 7
				// a=1;//default value b=1(from stream) => result 1 is returned
				// a=1;//result from previous step b=3(from stream) => result 3 is returned
				// a=3;//result from previous b=5(from stream) => result 15 is returned
				// a=15;//result from previous b=7(from stream) => result 105 is returned
				.reduce(1, (a, b) -> a * b);

	}

	public static Optional<Integer> performMultiplicationWithNoInitialValue(List<Integer> integerList) {
		return integerList.stream().reduce((a, b) -> a * b);
	}

	public static int performSum1() {
		return Arrays.asList(1, 2, 3).stream()
				// 10*1*3*5*7
				.reduce(10, (a, b) -> {
					System.out.println("Accumalator was Called " + (a + b) + " a:- " + a + " b:- " + b);
					return a + b;
				});
	}

	public static Integer performMultiplicationWithParralel() {
		// Accumulator
		// Combiner :- 11,12,13
		// 12+13 =25
		// 25+11 =36
		return Arrays.asList(1, 2, 3).parallelStream().reduce(10, (a, b) -> {
			System.out.println("Accumalator was Called " + (a + b) + " a:- " + a + " b:- " + b);
			return a + b;
		}, (a, b) -> {
			System.out.println("Combiner was called. " + (a + b) + " a:- " + a + " b:- " + b);
			return a + b;
		});
	}

	public static String combineStudentNames() {

		return StudentDataBase.getAllStudents().stream().map(Student::getName).distinct().reduce("",
				(a, b) -> a.concat(" ").concat(b));
	}

	public static Optional<Student> getHighestGradeStudent() {

		Optional<Student> studentOptional = StudentDataBase.getAllStudents().stream()
				// student one by one.
				.reduce((s1, s2) -> (s1.getGpa() > s2.getGpa()) ? s1 : s2);
		return studentOptional;
	}

	public static void main(String[] args) {

		List<Integer> integerList = Arrays.asList(1, 3, 5, 7);
		System.out.println("Result is : " + performMultiplication(integerList));
		System.out.println("*********************************************");

		System.out.println("Result is : " + performSum1());
		System.out.println("*********************************************");

		Optional<Integer> result = performMultiplicationWithNoInitialValue(integerList);

		if (result.isPresent()) {
			System.out.println("Result is : " + result.get());
		} else {
			System.out.println("Result is : " + 0);
		}
		System.out.println("*********************************************");

		System.out.println(performMultiplicationWithParralel());
		System.out.println("*********************************************");

		System.out.println(combineStudentNames());
		System.out.println("*********************************************");

		System.out.println(getHighestGradeStudent().get());
	}
}
