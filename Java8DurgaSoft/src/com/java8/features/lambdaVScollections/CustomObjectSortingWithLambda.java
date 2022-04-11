package com.java8.features.lambdaVScollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Employee {
	int eno;
	String ename;

	public Employee(int eno, String ename) {
		super();
		this.eno = eno;
		this.ename = ename;
	}

	public int getEno() {
		return eno;
	}

	public void setEno(int eno) {
		this.eno = eno;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String toString() {
		return eno + " : " + ename;
	}
}

public class CustomObjectSortingWithLambda {

	public static void main(String[] args) {
		List<Employee> employeelist = new ArrayList();
		employeelist.add(new Employee(200, "Deepika"));
		employeelist.add(new Employee(400, "Sunny"));
		employeelist.add(new Employee(300, "Mallika"));
		employeelist.add(new Employee(100, "Katrina"));
		employeelist.add(new Employee(700, "Amit"));
		System.out.println("Before Sorting " + employeelist);

		Collections.sort(employeelist, (e1, e2) -> e1.eno < e2.eno ? -1 : e1.eno > e2.eno ? 1 : 0);
		System.out.println("Sorted in Ascending :- " + employeelist);

		Collections.sort(employeelist, (e1, e2) -> e1.eno > e2.eno ? -1 : e1.eno < e2.eno ? 1 : 0);
		System.out.println("Sorted in Descending :- " + employeelist);
	}
}
