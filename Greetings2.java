import java.io.*;

public class Greetings2
{
   public static void main(String[] args)    
   {
   EasyReader console = new EasyReader ();   //this line is the instantliation
                                         
   System.out.print("Enter your first name: ");
   
   String firstName = console.readLine();
   
   
   System.out.print("Enter your last name: ");
   String lastName = console.readLine();
   System.out.println ("Hello, " + firstName + " " + lastName);
      
   }
}