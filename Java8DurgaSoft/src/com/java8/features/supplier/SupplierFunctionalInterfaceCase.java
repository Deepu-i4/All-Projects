package com.java8.features.supplier;

import java.util.Date;
import java.util.function.Supplier;

public class SupplierFunctionalInterfaceCase {

	public static void main(String[] args) {
		getDate();
		getRandom();
		getOTP();
		getPassword();
	}

	/**
	 * get Date
	 */
	private static void getDate() {
		Supplier<Date> sd = () -> new Date();
		System.out.println(sd.get());
	}

	/**
	 * get Random Name
	 */
	private static void getRandom() {
		Supplier<String> sd = () -> {
			String[] stringArray = { "Sunny", "Bunny", "Chinny", "Vinay" };
			int x = (int) Math.random() * 4;
			return stringArray[x];
		};
		System.out.println(sd.get());
	}

	/**
	 * get OTP
	 */
	private static void getOTP() {
		Supplier<String> sd = () -> {
			String otp = "";
			for (int i = 0; i < 6; i++) {
				otp = otp + (int) (Math.random() * 10);
			}
			return otp;
		};
		System.out.println(sd.get());
	}

	/**
	 * Length should be 8 Characters. 2,4,6,8 places only digits. 1,3,5,7 places
	 * only Upper case alphabet symbols,@,#,$.
	 */
	private static void getPassword() {
		Supplier<String> sd = () -> {
			String pwd = "";
			Supplier<Integer> intSup = () -> (int) (Math.random() * 10);

			String symbols = "ABCDEFGHIJKLMNOPQRSTUVWXYZ@#$";

			Supplier<Character> strSup = () -> symbols.charAt((int) (Math.random() * 29));

			for (int i = 0; i < 8; i++) {
				if (i % 2 == 0) {
					pwd = pwd + intSup.get();
				} else {
					pwd = pwd + strSup.get();
				}
			}
			return pwd;
		};
		System.out.println(sd.get());
	}

}
