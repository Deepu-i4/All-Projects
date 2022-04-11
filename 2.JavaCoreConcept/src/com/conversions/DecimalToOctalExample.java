package com.conversions;

import java.util.Scanner;

class DecimalToOctalExample
{
  public static void main(String args[])
  {
    Scanner input = new Scanner( System.in );
    System.out.print("Enter a decimal number : ");
    int num =input.nextInt();
 
    /* Method 1: 
     * Using predefined method toOctalString(int)
     * Pass the decimal number to this method and
     * it would return the equivalent octal number
     */
    String octalString = Integer.toOctalString(num);
    System.out.println("Method 1: Decimal to octal: " + octalString);
 
    /* Method 2: 
     * Writing your own logic: Here we will write
     * our own logic for decimal to octal conversion
     */
 
    // For storing remainder
    int rem;
 
    // For storing result
    String str=""; 
 
    // Digits in Octal number system
    char dig[]={'0','1','2','3','4','5','6','7'};
 
    while(num>0)
    {
       rem=num%8; 
       str=dig[rem]+str; 
       num=num/8;
    }
    System.out.println("Method 2: Decimal to octal: "+str);
  }
}