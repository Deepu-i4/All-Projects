package com.java8.features.lambdaVScollections;

import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;

public class MapSorting {
	Map<Integer, String> treeMap = new TreeMap<Integer, String>();

	public MapSorting() {
		treeMap.put(1, "Pushpendra");
		treeMap.put(7, "Kirti");
		treeMap.put(9, "Teepu");
		treeMap.put(21, "Vivek");
		treeMap.put(3, "Akash");
		treeMap.put(0, "Salma");
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
		Map<Integer, String> sortedtreeMap = new TreeMap(decendingOrderTreeComparator);
		sortedtreeMap.putAll(treeMap);
		System.out.println(sortedtreeMap);
	}

	public void sortDecendingOrderSetWitLambda() {
		Map<Integer, String> sortedtreeMap = new TreeMap(lambdaDecendingOrderTreeComparator);
		sortedtreeMap.putAll(treeMap);
		System.out.println("With Lambda :- " + sortedtreeMap);
	}

	public static void main(String[] args) {
		MapSorting listSorting = new MapSorting();
		System.out.println("Natural sorting :- " + listSorting.treeMap);
		listSorting.sortDecendingOrderSet();
		listSorting.sortDecendingOrderSetWitLambda();
	}
}
