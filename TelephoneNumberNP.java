import java.util.Scanner;

public class TelephoneNumberNP
{
/* This program is a telephone number validator.  It scans an input
     telephone number String and validates it as a String in a standard 
     format with parentheses, dashes and numbers (for example,
     (987)654-3210, where 987 is the area code, 654 is the exchange, 
     and 3210 is the line number.  
   
   The program performs the following operations on the input String:
   
   1.  Remove all characters from the String which are not numeric or 
   parenthesis or dash.
   
   2.  Check to see that the new String is the correct length (13).  If it 
   is not, print an error message stating the wrong length.
   
   3.  Check that the ( is in position 0, the ) is in position 4 and the 
   dash is in position 8.  If it is not, print an appropriate error message. 
   
   4.  Takes the valid format telephone number and divides it into 
   its three components (area code, exchange, and line number) and 
   prints each seperately.
   
   */
public static void main(String[] args)
{
	Scanner sc = new Scanner(System.in);
	System.out.println("Please enter the original telephone number: "); 
	String phonenum = sc.nextLine();
	String newtn = "";

// #1 ********************************************************	
/* Write the code here to remove all characters from the String that 
     are not numeric or parenthesis or dash.*/
	for (char c : phonenum.toCharArray()) {
          if (Character.isDigit(c) || c == '(' || c == ')' || c == '-') {
              newtn += c;
          }
      }

      System.out.println("The new telephone number is: " + newtn);
      System.out.println("The original telephone number was: " + phonenum);
// #2 ********************************************************
/* Write the code here to check to see that the new String is the 
    correct length (13) and print an error message if necessary.*/	
    if (newtn.length() != 13) {
     System.out.println("The original telephone number of length " + newtn.length() + " was not the correct length");
     return;
 }
// #3 ********************************************************
/* Write the code here to check that the ( is in position 0, the ) is in
     position 4 and the dash is in position 8.  If it is not, print an 
     appropriate error message. */
	if ((newtn.charAt(0) != '(' || newtn.charAt(4) != ')' || newtn.charAt(8) != '-')) {
          System.out.println("The original telephone number did not have the parenthesis or dash in the correct position.");
          return;
     }


// #4 ********************************************************
/* Write the code here that takes a valid format telephone 
     number and divides it into its three components (area code, 
     exchange, and line number) and prints each seperately.*/
     String areaCode = newtn.substring(1, 4);
     String exchange = newtn.substring(5, 8);
     String lineNumber = newtn.substring(9);

     System.out.println("Area Code: " + areaCode);
     System.out.println("Exchange: " + exchange);
     System.out.println("Line Number: " + lineNumber);
}
}