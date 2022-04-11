package com.java8.features.lambdaVScollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorting {

	List<String> names = new ArrayList();

	public ListSorting() {
		names.add("Ramesh");
		names.add("Akash");
		names.add("Vivek");
		names.add("Neha");
		names.add("Salma");
	}

	public void sortNaturalOrderList() {
		Collections.sort(names);
		System.out.println(names);
	}

	/**
	 * Before Java 8
	 */
	Comparator<String> decendingOrderComparator = new Comparator<String>() {
		public int compare(String o1, String o2) {
			return o2.compareTo(o1);
		}
	};

	public void sortDecendingOrderList() {
		Collections.sort(names, decendingOrderComparator);
		System.out.println(names);
	}

	public void sortDecendingOrderListWithLambda() {
		Collections.sort(names, (o1, o2) -> o2.compareTo(o1));
		System.out.println("With Lambda " + names);
	}

	public static void main(String[] args) {
		ListSorting listSorting = new ListSorting();
		listSorting.sortNaturalOrderList();
		listSorting.sortDecendingOrderList();
		listSorting.sortDecendingOrderListWithLambda();
	}
}
