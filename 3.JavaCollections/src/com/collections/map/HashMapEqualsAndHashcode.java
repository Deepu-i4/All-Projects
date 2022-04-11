package com.collections.map;

import java.util.HashMap;
import java.util.Map;

class Employee {
	int id;

	public Employee(int id) {
		this.id = id;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (id != other.id)
			return false;
		return true;
	}

}

public class HashMapEqualsAndHashcode {

	public static void main(String[] args) {
		Employee emp1 = new Employee(1);
		Employee emp2 = new Employee(1);

		Map<Employee, String> map = new HashMap();
		map.put(emp1, "Jack");
		map.put(emp2, "Jack");

		System.out.println(map.size()); // 2 ->1
		// this should return 1 as size.
		System.out.println(map.entrySet());

		// clue
		Integer i = new Integer(1);
		Integer i1 = new Integer(1);

		Map<Integer, String> map1 = new HashMap();
		map1.put(i, "Jack");
		map1.put(i1, "Jack");
		System.out.println(map1.size()); // 1

	}

}
