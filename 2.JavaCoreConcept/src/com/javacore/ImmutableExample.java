package com.javacore;

public class ImmutableExample {

	public static void main(String[] args) {
		Address refAdd = new Address("12", "BTM");
		User user = new User("Pushpendra", refAdd);
		System.out.println(user);
		Address add = user.getAdd();
		add.setCity("23");
		add.setState("KTM");
		System.out.println(user);

	}
}

final class User {
	private final String name;
	private final Address add;

	public User(String name, Address add) {
		this.add = add;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Address getAdd() {
		/*
		 * try { return (Address) add.clone(); } catch (CloneNotSupportedException e) {
		 * e.printStackTrace(); } return null;
		 */
		return new Address(add);
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", add=" + add + "]";
	}

}

class Address implements Cloneable {
	private String city;
	private String state;

	public Address(String city, String state) {
		this.state = state;
		this.city = city;
	}
	
	public Address(Address add) {
		this(add.city,add.state);
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}

	@Override
	public String toString() {
		return "Address [state=" + state + ", city=" + city + "]";
	}

}
