package com.deepu.array;

public class ArrayEvenNumber {

	public static void main(String[] args) {
		int arr[] = new int[100];

		for (int i = 1; i <= 100; i++) {
			arr[i - 1] = i;
		}

		int evencount = 0;
		int oddcount = 0;
		for (int i = 0; i < 100; i++) {

			if (arr[i] % 2 == 0) {
				evencount++;
			} else {
				oddcount++;
			}
		}

		System.out.println("Total even Number " + evencount);
		System.out.println("Total even Number " + oddcount);

	}
}
