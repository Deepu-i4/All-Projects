package com.learnJava.optional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class Person {
	private String name;
	private int age;
	private String password;

	public Person() {
	}

	public Person(String name, int age, String password) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
	}

	public Optional<String> getName() {
		return Optional.ofNullable(name);
	}

	public Optional<Integer> getAge() {
		return Optional.ofNullable(age);
	}

	public Optional<String> getPassword() {
		return Optional.ofNullable(password);
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + " : " + age + " : " + password;
	}
}

public class PersonProcessor {

	public static List<Person> persons = new ArrayList<Person>();

	static {
		persons.add(new Person("Pushpendra", 21, "sdsdsd"));
		persons.add(new Person("Push", 25, "sdsdsd"));
		persons.add(new Person("PushK", 21, "sdsdsd"));
		persons.add(new Person("Salma", 29, "sdsdsd"));
		persons.add(new Person("Radha", 26, "sdsdsd"));
	}

	// Never pass Optional as argument.
	public static List<Person> search(List<Person> people, String name, Optional<Integer> age) {
		// Null checks for people and name
		return people.stream().peek(System.out::println).filter(p -> p.getName().get().equals(name))
				.peek(System.out::println).filter(p -> p.getAge().get() >= age.get()).peek(System.out::println)
				.collect(Collectors.toList());
	}

	public static List<Person> search1(List<Person> people, String name, Integer age) {
		// Null checks for people and name
		final Integer ageFilter = age != null ? age : 0;
		return people.stream().filter(p -> p.getName().get().equals(name)).peek(System.out::println)
				.filter(p -> p.getAge().get() >= ageFilter).collect(Collectors.toList());
	}

	public static void main(String[] args) {
		Optional<Integer> age = Optional.ofNullable(26);
		System.out.println(search1(persons, "Radha", null));
		System.out.println("***********");
	}

}
