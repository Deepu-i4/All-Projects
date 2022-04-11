package com.java8.features.BiFunctionalInterface;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

class Employee {
	String name;
	double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " " + salary;
	}
}

public class BiConsumerCase {

	public static void main(String[] args) {
		getName();
		getEmployee();
	}

	private static void getName() {
		BiConsumer<String, String> consumer = (s1, s2) -> {
			System.out.println(s1.concat(s2));
		};
		consumer.accept("Pushpendra ", "Kumar");
	}

	private static void getEmployee() {
		List<Employee> list = new ArrayList<Employee>();
		BiFunction<String, Double, Employee> bifunc = (name, salary) -> new Employee(name, salary);
		list.add(bifunc.apply("Durga", 100000.00));
		list.add(bifunc.apply("Hello", 200989.00));
		list.add(bifunc.apply("Radha", 543002.00));
		list.add(bifunc.apply("Krishna", 1000000.00));
		System.out.println("Employee list :- " + list);

		BiConsumer<Employee, Double> consumer = (e, increment) -> {
			e.salary = e.salary + increment;
			System.out.println(e);
		};
		for (Employee employee : list) {
			consumer.accept(employee, 3400.00);
		}
	}

}
