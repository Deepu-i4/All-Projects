package com.javacore;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Iterator;

/**
 * Creating Object using Parameterized constructors.
 * 
 * @author Deepu Verma
 *
 */
public class ReflectionExample2 {

	public static void main(String[] args)
			throws ClassNotFoundException, InstantiationException, IllegalAccessException, NoSuchMethodException,
			SecurityException, IllegalArgumentException, InvocationTargetException {
		{
			Class<?> cl = Class.forName("Student");
			Constructor<?>[] constructors = cl.getDeclaredConstructors();

			Object consArgs[] = null;

			for (int i = 0; i < constructors.length; i++) {
				Constructor c = constructors[i];
				Class params[] = c.getParameterTypes();
				consArgs = new Object[params.length];
				for (int j = 0; j < params.length; j++) {
					String type = params[j].getName();
					System.out.println(type);
					if (type.equals("int")) {
						consArgs[j] = 10;
					}
					if (type.equals("java.lang.String")) {
						consArgs[j] = "Pushpendra";
					}
				}
				Object obj = c.newInstance(consArgs);
				System.out.println(obj);
			}
		}

		{
			Class<?> cl = Class.forName("Student");
			Object obj = cl.newInstance();
			Field[] declaredFields = cl.getDeclaredFields();
			for (int i = 0; i < declaredFields.length; i++) {

				Field field = declaredFields[i];
				field.setAccessible(true);
				String name=field.getName();
				String type=field.getType().getName();
				Object value= null;
				if (type.equals("int")) {
					value = 10;
					field.set(obj, value);
				}
				if (type.equals("java.lang.String")) {
					value = "Pushpendra";
					field.set(obj, value);
				}
			}
			System.out.println("asdsa "+obj);
		}
	}

}

class Student {
	private int eid;
	private String name;
	private int age;

	public Student() {
		// TODO Auto-generated constructor stub
	}

	public Student(int eid, String name, int age) {
		super();
		this.eid = eid;
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Student [eid=" + eid + ", name=" + name + ", age=" + age + "]";
	}

}