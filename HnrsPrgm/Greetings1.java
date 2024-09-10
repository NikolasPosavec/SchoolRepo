/* This is a block comment
Name: Nick Posavec
This is my first program to output my name by hardcoding the name.
*/

public class Greetings1    // Single line comment - filename.java must match this class name
{
   public static void main(String[] args)    // This line is always needed and is where the program begins
   {
      String firstName = "Nick";    // firstName is a String storage location, like a variable
      /* "Nick" is a literal String, meaning whatever is inside the quotes is stored or printed exactly as seen.
      firstName is a variable String, meaning the name of a storage location.
      The = sign is called an assignment statement, meaning store in memory whatever 
      is on the right into the storage location on the left. */
      
      String lastName = "Posavec";
      System.out.println("Hello, " + firstName + " " + lastName);
      System.out.println("Congratulations on your first program");
      
      // The output is the concatenation of literal and variable Strings.
   }
}
   