package com.javacore;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.lang.reflect.Parameter;
import java.util.HashSet;

public class PrintSuperClassNames {

	public static void main(String[] args) {
		HashSet<String> hashSet = new HashSet<String>();
		printClasses(hashSet);
		System.out.println("-------------------");
		printInterfaces(hashSet);

		String str = "Pushpendra";
		printModifier(str);

		privateObject();

		privateMethod();
	}

	private static void privateObject() {
		PrivateObject privateObject = new PrivateObject("Pushpendra");
		try {
			Field declaredField = PrivateObject.class.getDeclaredField("privateStr");
			declaredField.setAccessible(true);
			String object = null;
			try {
				object = (String) declaredField.get(privateObject);
			} catch (IllegalArgumentException | IllegalAccessException e) {
				e.printStackTrace();
			}
			System.out.println("-----------------");
			System.out.println(object);
		} catch (NoSuchFieldException | SecurityException e) {
			e.printStackTrace();
		}
	}

	private static void privateMethod() {
		PrivateObject privateObject = new PrivateObject("Pushpendra");

		try {
			Method declaredMethod = PrivateObject.class.getDeclaredMethod("getPrivateString", null);
			declaredMethod.setAccessible(true);
			String object = (String) declaredMethod.invoke(privateObject, null);
			System.out.println("-----------------");
			System.out.println(object);
		} catch (NoSuchMethodException | SecurityException | InvocationTargetException | IllegalAccessException
				| IllegalArgumentException e1) {
			e1.printStackTrace();
		}

	}

	private static void printModifier(String str) {
		Class<? extends String> class1 = str.getClass();
		int modifiers = class1.getModifiers();
		if (Modifier.isPublic(modifiers)) {
			System.out.println("Public");
		}
		if (Modifier.isFinal(modifiers)) {
			System.out.println("FInal");
		}
		if (Modifier.isAbstract(modifiers)) {
			System.out.println("Public");
		}

		System.out.println("-----------");
		Constructor<?>[] constructor = class1.getConstructors();
		for (Constructor<?> cons : constructor) {
			System.out.println(cons);
			Parameter[] parameters = cons.getParameters();
			for (Parameter c : parameters) {
				System.out.println(c.getType());
			}
		}
	}

	private static void printClasses(HashSet<String> hashSet) {
		Class subClass = hashSet.getClass();
		while (subClass.getSuperclass() != null) {
			System.out.println(subClass.getSuperclass().getName());
			subClass = subClass.getSuperclass();
		}
	}

	private static void printInterfaces(HashSet<String> hashSet) {
		Class subClass1 = hashSet.getClass();
		Class[] interfaces = subClass1.getInterfaces();
		for (Class c : interfaces) {
			System.out.println(c.getName());
		}
	}

}

class PrivateObject {
	private String privateStr = null;

	public PrivateObject(String privateStr) {
		this.privateStr = privateStr;
	}

	private String getPrivateString() {
		return this.privateStr;
	}
}