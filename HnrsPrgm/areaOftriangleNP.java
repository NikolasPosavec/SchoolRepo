import java.util.Scanner;

public class areaOftriangleNP 
{
    public static void main(String[] args)
    { 
        
        Scanner sc = new Scanner(System.in);

        System.out.print("Input your height here: ");
        double height = sc.nextDouble();

        System.out.print("Input your base here: ");
        double base = sc.nextDouble();

        double area = (1.0/2.0) * base * height;
        System.out.println("Your area is..." + area);

    }
}

