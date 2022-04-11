package com.conversions;

public class OctalTodecimal {
		 
        public static void main(String[] args) {
               
                //declare string containing octal number
                String strOctalNumber = "33";
              
                /*
                 * to convert octal number to decimal number use,
                 * int parseInt method of Integer wrapper class.
                 * Pass 8 as redix second argument.
                 */
                 
                 int decimalNumber = Integer.parseInt(strOctalNumber,8);
                 System.out.println("Octal number converted to decimal number");
                 System.out.println("Decimal number is : " + decimalNumber);
               
        }
}
 