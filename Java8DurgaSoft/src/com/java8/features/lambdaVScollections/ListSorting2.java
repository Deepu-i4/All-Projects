package com.java8.features.lambdaVScollections;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSorting2 {
	List<Integer> age = new ArrayList();

	public ListSorting2() {
		age.add(10);
		age.add(0);
		age.add(5);
		age.add(44);
		age.add(2);
		age.add(23);
		age.add(9);
	}

	public void sortNaturalOrderList() {
		Collections.sort(age);
		System.out.println(age);
	}

	/**
	 * Before Java 8
	 */
	Comparator<Integer> decendingOrderComparator = new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o1 > o2 ? -1 : (o1 < o2) ? +1 : 0;
		}
	};

	/**
	 * After Java 8
	 */
	Comparator<Integer> lambdaDecendingOrderComparator = (o1, o2) -> {
		return o1 > o2 ? -1 : (o1 < o2) ? +1 : 0;
	};

	public void sortDecendingOrderList() {
		Collections.sort(age, decendingOrderComparator);
		System.out.println(age);
	}

	public void sortDecendingOrderListWitLambda() {
		Collections.sort(age, lambdaDecendingOrderComparator);
		System.out.println("With Lambda :- " + age);
	}

	public static void main(String[] args) {
		ListSorting2 listSorting = new ListSorting2();
		listSorting.sortNaturalOrderList();
		listSorting.sortDecendingOrderList();
		listSorting.sortDecendingOrderListWitLambda();
	}
}
