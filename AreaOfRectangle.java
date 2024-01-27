import java.util.Scanner;

public class AreaOfRectangle
   {
      public static void main(String[] args)
      {
         Scanner sc = new Scanner (System.in);
         
         System.out.print("Input length: ");
         double length = sc.nextDouble();
         
         System.out.print("Input width: ");
         double width = sc.nextDouble();
         
         double area = (length * width);
         System.out.print("A rectangle with a length of " + length + "and a width of " + width + "has an area of " + area);
      }
   }