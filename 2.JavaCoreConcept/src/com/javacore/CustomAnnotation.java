package com.javacore;

public class CustomAnnotation {
	public static void main(String[] args) {
		Employee233 emp = new Employee233(10, "sjs");
		System.out.println(emp);

	}
}

@Employee1(eid = 22, sname = "hey")
class Employee233 {

	int eid;
	String name;

	public Employee233(int eid, String name) {
		this.eid = eid;
		this.name = name;
	}

	public String toString() {
		return eid + "\t" + name;
	}

}

@interface Employee1 {
	int eid();

	String sname();

}