package com.java8.features.streams;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamExample1 {

	static List<Integer> integerList = new ArrayList<Integer>();

	static {
		integerList.add(35);
		integerList.add(60);
		integerList.add(110);
		integerList.add(0);
		integerList.add(10);
		integerList.add(15);
		integerList.add(25);
	}

	public static void main(String[] args) {
		evenNumber();
		doubleNumber();
		getNames();
		getSorted();
		getSorted1();
		getMin();
		getMax();
		getForEach();
		getToArray();
		getOfStream();

	}

	private static void getOfStream() {
		System.out.println("********STREAM OF***********");
		Stream<Integer> s = Stream.of(9, 99, 999, 999);
		s.forEach(System.out::println);
		
		System.out.println("********STREAM OF***********");
		Double[] d = { 10.0, 10.1, 10.2, 10.3 };
		Stream s1 = Stream.of(d);
		s1.forEach(System.out::println);
	}

	private static void getToArray() {
		System.out.println("********TO ARRAY***********");
		Integer[] arr = integerList.stream().toArray(Integer[]::new);
		for (Integer integer : arr) {
			System.out.println(integer);
		}
	}

	private static void getForEach() {
		System.out.println("********FOR EACH***********");
		// integerList.stream().forEach(s -> System.out.println(s));
		integerList.stream().forEach(System.out::println);
	}

	private static void getMax() {
		Integer minValue = integerList.stream().max((a, b) -> a.compareTo(b)).get();
		System.out.println("Max Value :- " + minValue);
	}

	private static void getMin() {
		Integer maxValue = integerList.stream().min((a, b) -> a.compareTo(b)).get();
		System.out.println("Min Value :- " + maxValue);
	}

	private static void getSorted1() {
		// (a, b) -> -a.compareTo(b)
		List<Integer> newList = integerList.stream().sorted((a, b) -> b.compareTo(a)).collect(Collectors.toList());
		System.out.println("Sorted in Reverse Order :- " + newList);

	}

	private static void getSorted() {
		List<Integer> newList = integerList.stream().sorted().collect(Collectors.toList());
		System.out.println("Sorted in Default Natural Order :- " + newList);

	}

	private static void getNames() {
		List<String> list = new ArrayList();
		list.add("Pushpendra");
		list.add("Salma Sultan");
		list.add("amit");
		list.add("simran");
		System.out.println("Original List" + list);
		List<String> newList = list.stream().filter(s -> s.length() >= 9).collect(Collectors.toList());
		System.out.println("Name lenght more than 9:- " + newList);
		List<String> newList1 = list.stream().map(s -> s.toUpperCase()).collect(Collectors.toList());
		System.out.println("Names in Upper case :- " + newList1);
		long count = list.stream().filter(s -> s.length() >= 9).count();
		System.out.println("Count of names in length of 9 or more :- " + count);
	}

	private static void doubleNumber() {
		List<Integer> newList = integerList.stream().map(i -> i * 2).collect(Collectors.toList());
		System.out.println(newList);

	}

	private static void evenNumber() {
		List<Integer> evenNumberList = integerList.stream().filter(i -> i % 2 == 0).collect(Collectors.toList());
		System.out.println(evenNumberList);
	}
}
