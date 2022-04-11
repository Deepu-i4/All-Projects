package com.javacore;

/**
 * Suppose you go for the internship at GeeksForGeeks and their you were told to
 * write a program, to count the number of Employees working in the
 * company(excluding interns).To make this program, you have to use the concept
 * of a garbage collector.
 * 
 * @author Deepu Verma
 *
 */
//Correct code to count number
//of employees excluding interns.
class Employee {
	private int ID;
	private String name;
	private int age;
	private static int nextId = 1;

	// it is made static because it
	// is keep common among all and
	// shared by all objects
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
		this.ID = nextId++;
	}

	public void show() {
		System.out.println("Id=" + ID + "\nName=" + name + "\nAge=" + age);
	}

	public void showNextId() {
		System.out.println("Next employee id will be=" + nextId);
	}

	protected void finalize() {
		--nextId;
		// In this case,
		// gc will call finalize()
		// for 2 times for 2 objects.
	}
}

//it is closing brace of Employee class
class GarbageCollector2 {
	public static void main(String[] args) {
		Employee E = new Employee("GFG1", 56);
		Employee F = new Employee("GFG2", 45);
		Employee G = new Employee("GFG3", 25);
		E.show();
		F.show();
		G.show();
		E.showNextId();
		F.showNextId();
		G.showNextId();

		{
			// It is sub block to keep
			// all those interns.
			Employee X = new Employee("GFG4", 23);
			Employee Y = new Employee("GFG5", 21);
			X.show();
			Y.show();
			X.showNextId();
			Y.showNextId();
			X = Y = null;
			System.gc();
			// This method is used for ensuring that finalize method is
			// guranted to be called.calling this method is equivalent to
			// Runtime.getRuntime().runFinalization().
			System.runFinalization();
		}
		E.showNextId();
	}
}
