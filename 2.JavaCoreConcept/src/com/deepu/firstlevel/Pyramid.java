package com.deepu.firstlevel;

import java.io.*;

class Pyramid {

	public static void main(String[] args) {

		String inpstring = "";
		InputStreamReader input = new InputStreamReader(System.in);
		BufferedReader reader = new BufferedReader(input);

		try {
			System.out.print("Enter number of rows for pyramid:");
			inpstring = reader.readLine();
			int n = Integer.parseInt(inpstring, 10);

			for (int i = 1; i <= n; i++) {
				for (int j = 0; j < (n - i); j++)
					System.out.print(" ");

				for (int j = 1; j <= i; j++)
					System.out.print("*");

				for (int k = 1; k < i; k++)
					System.out.print("*");

				System.out.println();
			}

			System.out.println();
			System.out.println();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
