package com.javacore;
import java.lang.reflect.Constructor;

public class ReflectionExample {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException {
		Class<?> cl = Class.forName("Emp");
		//Object obj = cl .newInstance();
		
		Constructor<?>[] constructors = cl.getDeclaredConstructors();
		for (Constructor<?> constructor : constructors) {
			System.out.println(constructor);
		}
		
		Class paramsReq[] = new Class[] {int.class, String.class};
		Constructor<?> constructor = cl.getDeclaredConstructor(paramsReq);
		System.out.println(constructor);
		

	}

}

class Emp {
	private int eid;
	private String name;
	private int age;

	private Emp(int eid, String name) {
		super();
		this.eid = eid;
		this.name = name;
	}

	private Emp(int eid, String name, int age) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
	}
	
	private void show() {
		System.out.println("show");
	}

}