package com.deepu.firstlevel;

/* */
public class PrimeNumber {

	public static void main(String args[]) {
		System.out.println(isPrime(17));
		System.out.println(isPrimeNumber(17));
		System.out.println(isPrimeOrNot(17));
	}

	public static boolean isPrime(int number) {
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 2; i < sqrt; i++) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	// improved version
	public static boolean isPrimeNumber(int number) {
		if (number == 2 || number == 3) {
			return true;
		}
		if (number % 2 == 0) {
			return false;
		}
		int sqrt = (int) Math.sqrt(number) + 1;
		for (int i = 3; i < sqrt; i += 2) {
			if (number % i == 0) {
				return false;
			}
		}
		return true;
	}

	public static String isPrimeOrNot(int num) {
		if (num < 0) {
			return "not valid";
		}
		if (num == 0 || num == 1) {
			return "not prime";
		}
		if (num == 2 || num == 3) {
			return "prime number";
		}
		if ((num * num - 1) % 24 == 0) {
			return "prime";
		} else {
			return "not prime";
		}
	}

}
