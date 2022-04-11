package com.javacore;

public class App6 {

	public static void main(String[] args) {
		String string = "JLCINDIA";
		char[] ch = new char[string.length()];
		for (int i = 0; i < string.length(); i++) {
			ch[i] = string.charAt(i);
		}

		for (int i = 0; i < ch.length; i++) {
			System.out.println(i + " " + ch[i]);
		}

		byte[] bb = new byte[string.length()];

		for (int k = 0; k < string.length(); k++) {
			bb[k] = (byte) string.charAt(k);
		}

		for (int i = 0; i < ch.length; i++) {
			System.out.println(i + " " + bb[i]);
		}
		
		//System.out.println(Integer.parseInt(string));
		
		char arr[]=null;
		String try2=null;
		String gh= String.valueOf(arr);
		System.out.println(try2);
		
		String rt ="ABDS";
		System.out.println("hashcode: "+ rt.hashCode()); // overridden one
		StringBuffer sb = new StringBuffer(rt);
		System.out.println("hashcode: "+ sb.hashCode());
		
		// StringBuffer sb1 = new StringBuffer(null); RTE
		//sb.insert(2,null); // Ambigous
		// sb.append(null); // Ambigous
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.append("Pushpendra");
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.ensureCapacity(50);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		System.out.println(sb);
		sb.setLength(8);
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());
		sb.trimToSize();
		System.out.println(sb);
		System.out.println(sb.length());
		System.out.println(sb.capacity());

	}

}