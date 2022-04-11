package com.conversions;


	public class Hex2Decimal {

	    public static int hex2decimal(String s) {
	        String digits = "0123456789ABCDEF";
	        s = s.toUpperCase();
	        int val = 0;
	        for (int i = 0; i < s.length(); i++) {
	            char c = s.charAt(i);
	            System.out.println("c : "+c);
	            int d = digits.indexOf(c);
	            System.out.println("d : "+c);
	            val = 16*val + d;
	            System.out.println("val : "+val);
	        }
	        return val;
	    }


	    public static void main(String[] args) {
	       int decimal = hex2decimal("38");
	        System.out.println(decimal);

	        /*String hex = decimal2hex(decimal);
	        System.out.println(hex);*/
	    }

/* // precondition:  d is a nonnegative integer
	    public static String decimal2hex(int d) {
	        String digits = "0123456789ABCDEF";
	        if (d == 0) return "0";
	        String hex = "";
	        while (d > 0) {
	            int digit = d % 16;                // rightmost digit
	            hex = digits.charAt(digit) + hex;  // string concatenation
	            d = d / 16;
	        }
	        return hex;
	    }
*/
	}
