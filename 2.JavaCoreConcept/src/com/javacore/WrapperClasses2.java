package com.javacore;

public class WrapperClasses2 {

	public static void main(String[] args) {
		{
			ShowClass ShowClass = new ShowClass();
			byte b1 = 123;
			byte b2 = 123;
			ShowClass.show(b1, b2);
			// System.loadLibrary(null);
			Runtime rt = Runtime.getRuntime();
			System.out.println("freeMemory:- " + rt.freeMemory() / 1000000);
			System.out.println("totalMemory:- " + rt.totalMemory() / 1000000);
			System.out.println("maxMemory:- " + rt.maxMemory() / 1000000);

		}
	}

}

class ShowClass {
	void show(int a, int b) {
		System.out.println("int a,int b");
	}

	void show(Byte a, Byte b) {
		System.out.println("Byte a,Byte b");
	}

	void show(byte a, byte b) {
		System.out.println("byte a,byte b");
	}

	void show(byte... bs) {
		System.out.println("byte...bs");
	}
}
