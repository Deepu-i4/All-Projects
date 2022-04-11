package com.java8.features.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class Employee {
	private String name;
	private String designation;
	private Double salary;
	private String city;

	public Employee(String names, String designation, Double salary, String city) {
		super();
		this.name = names;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}

	public String getNames() {
		return name;
	}

	public void setNames(String names) {
		this.name = names;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Double getSalary() {
		return salary;
	}

	public void setSalary(Double salary) {
		this.salary = salary;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return String.format("(%s,%s,%.2f,%s)", name, designation, salary, city);
	}

	@Override
	public boolean equals(Object obj) {
		Employee emp = (Employee) obj;
		if (name.equals(emp.name) && designation.equals(emp.designation) && salary.equals(emp.salary)
				&& city.equals(emp.city)) {
			return true;
		} else {
			return false;
		}
	}

}

public class EmployeeManagementPredicate {

	private static void populate(List<Employee> emplist) {
		Employee e1 = new Employee("Durga", "CEO", 30000.00, "Hyderabad");
		emplist.add(e1);
		Employee e2 = new Employee("Sunny", "Manager", 20000.00, "Bangalore");
		emplist.add(e2);
		Employee e3 = new Employee("Mallika", "SE", 30000.00, "Hyderabad");
		emplist.add(e3);
		Employee e4 = new Employee("Katrine", "Manager", 40000.00, "Pune");
		emplist.add(e4);
		Employee e5 = new Employee("Kajal", "HR", 10000.00, "Noida");
		emplist.add(e5);
		Employee e6 = new Employee("Radhe", "Manager", 30000.00, "Hyderabad");
		emplist.add(e6);
		Employee e7 = new Employee("Sam", "Manager", 10000.00, "Hyderabad");
		emplist.add(e7);

	}

	private static void display(Predicate<Employee> empPred, List<Employee> emplist) {
		for (Employee employee : emplist) {
			if (empPred.test(employee))
				System.out.println(employee);
		}
		System.out.println("-----------------------------------");
	}

	public static void main(String[] args) {
		List<Employee> emplist = new ArrayList<Employee>();
		populate(emplist);
		Predicate<Employee> managerPred = emp -> emp.getDesignation().equals("Manager");
		Predicate<Employee> hydPred = emp -> emp.getCity().equals("Hyderabad");
		Predicate<Employee> salaryPred = emp -> emp.getSalary() <= 20000;
		Predicate<Employee> ceoPred = Predicate.isEqual(new Employee("Durga", "CEO", 30000.00, "Hyderabad"));

		System.out.println("original List := " + emplist);

		System.out.println("Manager List :");
		display(managerPred, emplist);

		System.out.println("Hyderabad List :");
		display(hydPred, emplist);

		System.out.println("Salary less than 20000 :");
		display(salaryPred, emplist);

		System.out.println("Manager in Hyderabad will get pink slip:");
		display(hydPred.and(managerPred), emplist);

		System.out.println("Manager or Salary less than 20000 :");
		display(salaryPred.or(managerPred), emplist);

		System.out.println("All Employee who is not Manager :- ");
		display(managerPred.negate(), emplist);

		System.out.println("Match with CEO :- ");
		display(ceoPred, emplist);

	}

}
