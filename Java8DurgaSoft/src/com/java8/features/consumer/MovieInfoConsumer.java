package com.java8.features.consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

class Movie {
	private String name;
	private String hero;
	private String heroine;

	public Movie(String name, String hero, String heroine) {
		super();
		this.name = name;
		this.hero = hero;
		this.heroine = heroine;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHero() {
		return hero;
	}

	public void setHero(String hero) {
		this.hero = hero;
	}

	public String getHeroine() {
		return heroine;
	}

	public void setHeroine(String heroine) {
		this.heroine = heroine;
	}

	@Override
	public String toString() {
		return "[" + name + " " + hero + " " + heroine + "]";
	}

}

public class MovieInfoConsumer {

	public static void main(String args[]) {

		List<Movie> moviesList = new ArrayList();
		populate(moviesList);

		Consumer<Movie> consumer = c -> {
			System.out.println("Movie Name :- " + c.getName());
			System.out.println("Movie Hero :- " + c.getHero());
			System.out.println("Movie Heroine :- " + c.getHeroine());
			System.out.println("*************************************");
		};

		moviesList.forEach(consumer);

		/*
		 * replaced by above line. for (Movie movie : moviesList) {
		 * consumer.accept(movie); }
		 */
	}

	private static void populate(List<Movie> moviesList) {
		moviesList.add(new Movie("Bahubali", "Amrinder", "Verma"));
		moviesList.add(new Movie("Rocky", "John", "Katrine"));
		moviesList.add(new Movie("Radhe", "Salman", "Kajol"));
		moviesList.add(new Movie("RaOne", "Sharukh", "Kajal"));
	}
}
