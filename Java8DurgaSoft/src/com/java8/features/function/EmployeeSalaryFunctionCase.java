package com.java8.features.function;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

class Employee {
	private String name;
	double salary;

	public Employee(String name, double salary) {
		super();
		this.name = name;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	@Override
	public String toString() {
		return name + " " + salary;
	}

}

public class EmployeeSalaryFunctionCase {

	public static void main(String[] args) {
		List<Employee> employeeList = new ArrayList<Employee>();
		getTotalSalary(employeeList);
		System.out.println("+++++++++++++++++++++++++++++++++");
		salaryIncremented(employeeList);

	}

	private static void salaryIncremented(List<Employee> employeeList) {
		System.out.println("Before Salary Change :- " + employeeList);
		Predicate<Employee> empPred = e -> e.getSalary() < 60000;
		Function<Employee, Employee> function = e -> {
			e.salary = e.getSalary() + 5000;
			return e;
		};

		List<Employee> newEmployeeList = new ArrayList<Employee>();
		for (Employee employee : employeeList) {
			if (empPred.test(employee)) {
				newEmployeeList.add(function.apply(employee));
			}
		}
		System.out.println("Before Salry Change :- " + newEmployeeList);
	}

	private static void getTotalSalary(List<Employee> employeeList) {
		populate(employeeList);
		Function<List<Employee>, Double> salaryfn = employees -> {
			double total = 0;
			for (Employee employee : employees) {
				total = total + employee.getSalary();
			}
			return total;
		};
		System.out.println(salaryfn.apply(employeeList));
	}

	private static void populate(List<Employee> employees) {
		employees.add(new Employee("Pushpendra", 80000));
		employees.add(new Employee("Salma", 90000));
		employees.add(new Employee("Rakesh", 55000));
		employees.add(new Employee("Bhadu", 50000));
		employees.add(new Employee("Nandu", 40000));
		employees.add(new Employee("Amit", 63000));
		employees.add(new Employee("Sumit", 73000));
	}

}
