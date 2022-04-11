package com.learnJava.optional;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

import java.util.Optional;

public class OptionalOrElseExample {

	public static String optionalOrElse() {
		// Optional<Student> getOptionalStudent =
		// Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> getOptionalStudent = Optional.ofNullable(null);
		return getOptionalStudent.map(Student::getName).orElse("Default");
	}

	public static String optionalOrElseGet() {
		// Optional<Student> getOptionalStudent =
		// Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> getOptionalStudent = Optional.ofNullable(null);
		return getOptionalStudent.map(Student::getName).orElseGet(() -> "Default");
	}

	public static String optionalOrElseThrow() {
		// Optional<Student> getOptionalStudent =
		// Optional.ofNullable(StudentDataBase.studentSupplier.get());
		Optional<Student> getOptionalStudent = Optional.ofNullable(null);
		return getOptionalStudent.map(Student::getName).orElseThrow(() -> new RuntimeException("No Data Found"));
	}

	public static void main(String[] args) {
		System.out.println("optionalOrElse :- " + optionalOrElse());
		System.out.println("optionalOrElseGet :- " + optionalOrElseGet());
		System.out.println("optionalOrElseThrow :- " + optionalOrElseThrow());
	}
}
