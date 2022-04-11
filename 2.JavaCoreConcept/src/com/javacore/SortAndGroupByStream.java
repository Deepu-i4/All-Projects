package com.javacore;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class TavantEmployee {
	private String name;
	private int age;
	private Date joiningDate;
	private static SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

	public TavantEmployee(String name, int age, Date joiningDate) {
		this.name = name;
		this.age = age;
		this.joiningDate = joiningDate;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public Date getJoiningDate() {
		return joiningDate;
	}

	@Override
	public String toString() {
		return "TavantEmployee [name=" + name + ", age=" + age + ", joiningDate=" + joiningDate + "]";
	}

	public static List<TavantEmployee> getTavantEmployees() throws ParseException {

		/**
		 * 2nd grade students
		 */
		TavantEmployee student1 = new TavantEmployee("Robert", 24, sdf.parse("2020-01-5"));

		TavantEmployee student2 = new TavantEmployee("Adam", 25, sdf.parse("2020-01-5"));
		TavantEmployee student5 = new TavantEmployee("Verman", 25, sdf.parse("2020-01-12"));
		TavantEmployee student6 = new TavantEmployee("Radhika", 25, sdf.parse("2020-01-12"));
		
		TavantEmployee student3 = new TavantEmployee("Sanya", 26, sdf.parse("2020-01-8"));
		TavantEmployee student4 = new TavantEmployee("Milan", 21, sdf.parse("2020-01-8"));
		List<TavantEmployee> students = Arrays.asList(student1, student2, student3, student4, student5, student6);
		return students;
	}
}

public class SortAndGroupByStream {


	public static void main(String[] args) throws ParseException {
		List<TavantEmployee> tavantEmployees = TavantEmployee.getTavantEmployees();
		
		Map<Date, List<TavantEmployee>> gourpByCollect = tavantEmployees.stream()
				.collect(Collectors.groupingBy(TavantEmployee::getJoiningDate));
		Stream.of(gourpByCollect).forEach(System.out::println);
		
		System.out.println("--------------------------------------");
		Set<Entry<Date, List<TavantEmployee>>> entrySet = gourpByCollect.entrySet();
		entrySet.stream()
		 .sorted(Entry.comparingByKey())
		        .collect(Collectors.toList()).forEach(System.out::println);
	}

}
