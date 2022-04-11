package com.java8.features.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class MovieClass {
	private String name;
	private String result;

	public MovieClass(String name, String result) {
		super();
		this.name = name;
		this.result = result;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}

public class MovieInfoConsumer2 {

	public static void main(String args[]) {

		List<MovieClass> moviesList = new ArrayList();
		populate(moviesList);

		Consumer<MovieClass> consumer1 = m -> System.out
				.println("Movie Name :- " + m.getName() + " is ready to release");

		Consumer<MovieClass> consumer2 = m -> System.out
				.println("Movie Name :- " + m.getName() + " is just released and it is :- " + m.getResult());

		Consumer<MovieClass> consumer3 = m -> System.out
				.println("Movie Name :- " + m.getName() + " information storing in DB");

		Consumer<MovieClass> consumer4 = m -> System.out
				.println("*****************************************************");

		for (MovieClass movie : moviesList) {
			consumer1.andThen(consumer2).andThen(consumer3).andThen(consumer4).accept(movie);
		}

	}

	private static void populate(List<MovieClass> moviesList) {
		moviesList.add(new MovieClass("Bahubali", "SuperHit"));
		moviesList.add(new MovieClass("Rocky", "Flop"));
		moviesList.add(new MovieClass("Radhe", "Hit"));
		moviesList.add(new MovieClass("RaOne", "Super Hit"));
	}
}
