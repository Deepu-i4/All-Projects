package com.javacore;

public class App3 {
	public static void main(String[] args) {

		extracted();
		extracted1();
		extracted2();
		extracted3();
		System.out.println("last:-");
		extracted4();

		int arr[] = new int[3];
		System.out.println(arr.length);
		/*
		 * boolean b= false; while(b) { System.out.println("asd"); }
		 * System.out.println("asdsa");
		 * 
		 * do { System.out.println("asdasd"); }while(true);
		 */

	}

	private static void extracted() {
		char ch = 'A';
		for (int row = 1; row <= 5; row++) {
			for (int col = 1; col <= row; col++) {
				System.out.print(ch + "");
				// ch++;
			}
			// ch++;
			System.out.println();

		}
	}

	private static void extracted4() {
		
		for (int row = 1; row <= 5; row++) {
			int ch = 1;
			for (int col = 1; col <= row; col++) {
				System.out.print(ch + "");
				ch = ch == 0 ? 1 : 0;
			}
			//ch = ch == 0 ? 1 : 0;
			System.out.println();

		}
	}

	private static void extracted1() {
		int n = 5;
		char ch = 'A';
		for (int row = 0; row < n; row++) {
			for (int col = 0; col < n - row; col++) {
				System.out.print("  ");
			}
			for (int col = 0; col <= row; col++) {
				System.out.print(ch + " ");
			}
			System.out.println();
			ch++;
		}
	}

	private static void extracted2() {
		int n = 5;
		char ch = 'A';
		for (int row = 0; row < n; row++) {
			for (int col = 1; col < n - row; col++) {
				System.out.print(" ");
			}
			for (int col = 0; col <= row; col++) {
				System.out.print(ch + "");
			}
			System.out.println();
			ch++;
		}
	}

	private static void extracted3() {
		char ch = 'A';
		int rows = 0;
		do {
			int cols = 0;
			do {
				System.out.print(ch + "");
				cols++;
			} while (cols <= rows);
			rows++;
			ch++;
			System.out.println();
		} while (rows < 5);

	}
}
