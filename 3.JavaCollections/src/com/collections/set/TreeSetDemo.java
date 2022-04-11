package com.collections.set;

import java.util.Comparator;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

public class TreeSetDemo {

	public static void main(String[] args) {

		// creating treeSet
		
		//If compareTo methis is not consistent with equals method.
		TreeSet ts = new TreeSet(new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				String s1 = (String)o1;
				String s2 = (String)o2;
				return s1.equals(s2)?-1:0;
			}

		});
		
		ts.add("push");
		ts.add("push");
		System.out.println(ts);


		// creating treeSet by passing comparator object
		// TreeSet ts1 = new TreeSet(Comparator c);

		SortedSet s = new TreeSet();
		// equivalent treeSet of sortedSet
		TreeSet ts2 = new TreeSet(s);

		HashSet hs = new HashSet();
		// equivalent treeSet of HashSet
		TreeSet ts3 = new TreeSet(hs);

		// treeSet with generics syntax
		TreeSet<Employee> ts4 = new TreeSet<Employee>();
		ts4.add(new Employee("John", 30000));
	}

}
