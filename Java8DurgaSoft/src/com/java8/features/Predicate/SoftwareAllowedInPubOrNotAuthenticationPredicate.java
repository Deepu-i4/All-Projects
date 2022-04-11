package com.java8.features.Predicate;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

class SoftwareEnginer {
	private String name;
	private int age;
	private Boolean isHavingGf;

	public SoftwareEnginer(String name, int age, Boolean isHavingGf) {
		super();
		this.name = name;
		this.age = age;
		this.isHavingGf = isHavingGf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public Boolean getIsHavingGf() {
		return isHavingGf;
	}

	public void setIsHavingGf(Boolean isHavingGf) {
		this.isHavingGf = isHavingGf;
	}

	@Override
	public String toString() {
		return name;
	}

}

public class SoftwareAllowedInPubOrNotAuthenticationPredicate {

	public static void main(String[] args) {
		List<SoftwareEnginer> enginers = new ArrayList<SoftwareEnginer>();
		enginers.add(new SoftwareEnginer("Push", 16, false));
		enginers.add(new SoftwareEnginer("Sunil", 25, true));
		enginers.add(new SoftwareEnginer("Sayan", 26, true));
		enginers.add(new SoftwareEnginer("Sibbu", 28, false));
		enginers.add(new SoftwareEnginer("Ravi", 15, true));

		Predicate<SoftwareEnginer> sePred = se -> se.getAge() > 18 && se.getIsHavingGf();
		for (SoftwareEnginer softwareEnginer : enginers) {
			if (sePred.test(softwareEnginer)) {
				System.out.println("Allowed :- " + softwareEnginer);
			} else {
				System.out.println("Not Allowed :- " + softwareEnginer);
			}
		}

	}
}
