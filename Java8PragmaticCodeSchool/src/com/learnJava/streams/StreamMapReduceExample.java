package com.learnJava.streams;

import com.learnJava.data.Student;
import com.learnJava.data.StudentDataBase;

public class StreamMapReduceExample {

	public static int noOfNoteBooks() {
		// int noOfNoteBooks =
		// StudentDataBase.getAllStudents().stream().map(Student::getNoteBooks).reduce((a,
		// b) -> a + b)
		// .get();
		int noOfNoteBooks = StudentDataBase.getAllStudents().stream().map(Student::getNoteBooks).reduce(Integer::sum)
				.get();
		int noOfNoteBooks1 = StudentDataBase.getAllStudents().stream().filter(student -> student.getGradeLevel() >= 3)
				.filter(student -> student.getGender().equals("female")).map(Student::getNoteBooks).reduce(Integer::sum)
				.get();
		return noOfNoteBooks1;
	}

	public static void main(String args[]) {
		System.out.println("noOfNoteBooks:- " + noOfNoteBooks());
	}
}
