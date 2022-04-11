package com.javacore;

public class App2 {
	public static void main(String[] args) {
		String str = "";
		System.out.println(String.class.getClassLoader());
		System.out.println(App2.class.getClassLoader());
		byte b=(byte) 128;
		System.out.println(b);
		int g= 0b01; // Binary Literals
		System.out.println(g);
		
		byte b1=12;
		byte c1=12;
		
		int a=-1;
		System.out.println(a);
		char ch =(char)a;
		System.out.println(ch);
		int bb = ch;
		System.out.println(bb);
		int aa =~15;
		System.out.println(aa);
		
		int xx=10;
		switch(xx) {
		case 0:{
			int a2w=10;
			System.out.println("case 0"+a2w);
		}
		case 10:{
			int a2w =23;
			System.out.println("case xx"+a2w);
		}
		}
		
		
		final boolean bsd = true;
		for(;bsd;) 
			System.out.println("run");
		//System.out.println("stop");
		
				
	}

}
