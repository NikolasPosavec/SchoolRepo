import java.io.*;

public class TriangleArea 
{
    public static void main(String[] args) 
    {
        EasyReader reader = new EasyReader();

        System.out.print("Enter the base of the triangle: ");
         double base = reader.readDouble();

        System.out.print("Enter the height of the triangle: ");
         double height = reader.readDouble();

         double area = 0.5 * base * height;

        System.out.println("The area of the triangle is: " + area);
    }
}
