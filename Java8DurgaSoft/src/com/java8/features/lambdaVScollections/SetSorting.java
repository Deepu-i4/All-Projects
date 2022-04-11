package com.java8.features.lambdaVScollections;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

public class SetSorting {
	Set<Integer> age = new TreeSet<Integer>();

	public SetSorting() {
		age.add(10);
		age.add(0);
		age.add(5);
		age.add(44);
		age.add(2);
		age.add(23);
		age.add(9);
	}

	/**
	 * Before Java 8
	 */
	Comparator<Integer> decendingOrderTreeComparator = new Comparator<Integer>() {
		public int compare(Integer o1, Integer o2) {
			return o1 > o2 ? -1 : (o1 < o2) ? +1 : 0;
		}
	};
	/**
	 * After Java 8
	 */
	Comparator<Integer> lambdaDecendingOrderTreeComparator = (o1, o2) -> {
		return o1 > o2 ? -1 : (o1 < o2) ? +1 : 0;
	};

	public void sortDecendingOrderSet() {
		TreeSet<Integer> treeSet = new TreeSet<Integer>(decendingOrderTreeComparator);
		treeSet.addAll(age);
		System.out.println(treeSet);
	}

	public void sortDecendingOrderSetWitLambda() {
		TreeSet<Integer> treeSet = new TreeSet<Integer>((o1, o2) -> o1 > o2 ? -1 : (o1 < o2) ? 1 : 0);
		treeSet.addAll(age);
		System.out.println("With Lambda :- " + treeSet);
	}

	public static void main(String[] args) {
		SetSorting listSorting = new SetSorting();
		System.out.println("Before Sorting Natural sorting :- " + listSorting.age);
		listSorting.sortDecendingOrderSet();
		listSorting.sortDecendingOrderSetWitLambda();
	}
}
