import java.util.Scanner;

public class PerimterOfRectangle
{
   public static void main(String[] args)
   {
      Scanner sc = new Scanner (System.in);
      
      System.out.print("Input length: ");
      double length = sc.nextDouble();
      
      System.out.print("Input width: ");
      double width = sc.nextDouble();
      
      double perimeter = (length*2) + (width*2);
      System.out.print("The perimeter of the rectangle with a length of " + length + " and a width of " + width + " has a perimeter of " + perimeter);
    }
}