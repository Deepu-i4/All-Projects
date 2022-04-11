package com.java8.features.Predicate;

import java.util.Scanner;
import java.util.function.Predicate;

class User {
	private String username;
	private String password;

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

}

public class UserAuthenticationPredicate {

	public static void main(String[] args) {
		Predicate<User> userpred = user -> user.getUsername().equals("Pushpendra") && user.getPassword().equals("java");
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Username");
		String username = scanner.next();
		System.out.println("Enter Password");
		String password = scanner.next();
		User user = new User(username, password);
		if (userpred.test(user)) {
			System.out.println("Valid User");
		} else {
			System.out.println("Invalid User");
		}
	}
}
