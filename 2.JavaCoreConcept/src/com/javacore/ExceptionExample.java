package com.javacore;


class MyException extends Exception {

	String s;

	public MyException(String s) {
		this.s = s;
	}

	@Override
	public String toString() {
		return s;
	}
}

public class ExceptionExample {

	public static void main(String[] args) {
		try {
			getAge(10);
		} catch (MyException e) {
			e.printStackTrace();
			//System.out.println(e.getMessage());
			//System.out.println(e);
			//System.out.println(e.toString());
		}
		System.out.println("Hello");

	}

	public static void getAge(int age) throws MyException {
		if (age < 18) {
			throw new MyException("invalid Age");
		}
	}
}
