package com.learnJava.streams;

import java.util.ArrayList;
import java.util.stream.Stream;

public class CollectionsvsStreams {

	public static void main(String[] args) {

		ArrayList<String> names = new ArrayList<>();
		names.add("Adam");
		names.add("Jim");
		names.add("Jenny");
		// we can traverse n no. of times.
		for (String string : names) {
			System.out.println("1st traverse :" + string);
		}
		for (String string : names) {
			System.out.println("2nd traverse :" + string);
		}
		names.remove(0);
		System.out.println(names);

		Stream<String> namesStream = names.stream();
		namesStream.forEach(System.out::println);
		// traserve again and get the exception.
		namesStream.forEach(System.out::println);

	}
}
