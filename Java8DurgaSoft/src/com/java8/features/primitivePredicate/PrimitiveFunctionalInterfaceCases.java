package com.java8.features.primitivePredicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntSupplier;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.LongToDoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.function.ToIntFunction;
import java.util.function.UnaryOperator;

class Employee {
	String name;
	double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String toString() {
		return name + " " + salary;
	}
}

public class PrimitiveFunctionalInterfaceCases {

	public static void main(String[] args) {
		predicate0();
		function1();
		function2();
		function3();
		function4();
		consumer1();
		consumer2();
		supplier1();
		unaryoperator();
		unaryoperator1();
		binaryOperator();
		binaryOperator1();
	}

	private static void predicate0() {
		int[] x = { 0, 5, 10, 12, 45 };
		IntPredicate intpred = i -> i % 2 == 0;
		for (int j : x) {
			if (intpred.test(j)) {
				System.out.println(j);
			}
		}
	}

	private static void function1() {
		long[] x = { 0, 5, 10, 12, 45 };
		LongToDoubleFunction intpred = i -> i;
		for (long j : x) {
			System.out.println(intpred.applyAsDouble(j));
		}
		System.out.println("****************************");
	}

	private static void function2() {
		IntFunction function = i -> i * i;
		System.out.println(function.apply(4));
		System.out.println("****************************");
	}

	private static void function3() {
		ToIntFunction<String> function = s -> s.length();
		System.out.println(function.applyAsInt("Pushpendra"));
		System.out.println("****************************");
	}

	private static void function4() {
		IntToDoubleFunction function = s -> Math.sqrt(s);
		System.out.println(function.applyAsDouble(5));
		System.out.println("****************************");
	}

	private static void consumer1() {
		IntConsumer c = i -> {
			System.out.println(i * i);
		};
		c.accept(10);
		System.out.println("****************************");
	}

	private static void consumer2() {
		List<Employee> employeelist = new ArrayList<Employee>();
		employeelist.add(new Employee("Pushpendra", 20000.00));
		employeelist.add(new Employee("Salma", 10000.00));
		ObjDoubleConsumer<Employee> c = (e, d) -> e.salary = e.salary + d;
		for (Employee employee : employeelist) {
			c.accept(employee, 500);
			System.out.println(employee);
		}
		System.out.println("****************************");
	}

	/**
	 * get OTP
	 */
	private static void supplier1() {
		IntSupplier sd = () -> (int) (Math.random() * 10);
		String otp = "";
		for (int i = 0; i < 6; i++) {
			otp = otp + sd.getAsInt();
		}
		System.out.println(otp);
		System.out.println("****************************");
	}

	private static void unaryoperator() {
		UnaryOperator<Integer> un = i -> i * i;
		System.out.println(un.apply(5));
		System.out.println("****************************");

	}

	private static void unaryoperator1() {
		IntUnaryOperator un = i -> i * i;
		System.out.println(un.applyAsInt(10));
		System.out.println("****************************");

	}

	private static void binaryOperator() {
		BinaryOperator<String> un = (s1, s2) -> s1 + s2;
		System.out.println(un.apply("Pushpendra ", "Kumar"));
		System.out.println("****************************");

	}

	private static void binaryOperator1() {
		IntBinaryOperator un = (i1, i2) -> i1 * i2;
		System.out.println(un.applyAsInt(10, 15));
		System.out.println("****************************");

	}

}
