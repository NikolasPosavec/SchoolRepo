import java.util.Scanner;

public class Greetings3AddingNumbers
{
 	public static void main(String[] args)
	{
	
   EasyReader console = new EasyReader(); 
	
   System.out.print ("Enter your first number: ");
	int firstNum = console.readInt();
	
   System.out.print ("Enter your last number: ");
	int lastNum = console.readInt();
   
   int sum = firstNum + lastNum;
	
   System.out.println (" " + firstNum + "+" + lastNum + "=" + sum);
	System.out.println ("Congratulations on your fourth program!");
	}
}
  
