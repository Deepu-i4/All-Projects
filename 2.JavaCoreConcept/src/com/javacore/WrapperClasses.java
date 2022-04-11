package com.javacore;

public class WrapperClasses {

	public static void main(String[] args) {
		// upto java 4 we used below
		{
			// Primitive to String
			int a = 123;
			String st = String.valueOf(123);
			System.out.println(st instanceof String);
			System.out.println(Integer.toString(123) instanceof String);
		}
		{
			// String to primitve.
			String str = "99";
			System.out.println(Integer.parseInt(str));
			String str1 = "true";
			System.out.println(Boolean.parseBoolean(str1));

		}
		{
			// Primitive to Wrapper class
			int a = 10;
			Integer intr = new Integer(120);
			System.out.println(intr);
			System.out.println(Integer.valueOf(232432));
			System.out.println(Boolean.valueOf(false));
		}
		{
			Character ch = new Character('A');
			char ch1 = ch.charValue();
			System.out.println(ch1);
			Boolean b = new Boolean(false);
			boolean bw = b.booleanValue();
			System.out.println(bw);
		}

		// from java 5 Autoboxing concept came.
		{
			Long val1 = 127L;
			Long val2 = 127L;
			System.out.println(val1 == val2);
			Long val3 = 128L;
			Long val4 = 128L;
			System.out.println(val3 == val4);

			Float f1 = 12.23f;
			Float f2 = 12.23f;
			System.out.println(f1 == f2);

			Double d1 = 12.23;
			Double d2 = 12.23;
			System.out.println(d1 == d2);
			
			Character ch1='A';
			Character ch2='A';
			System.out.println(ch1==ch2);

			Character ch3=(char)171;
			Character ch4=(char)171;
			System.out.println(ch3==ch4);
			

		}

	}

}
