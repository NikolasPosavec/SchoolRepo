import java.util.Scanner;

public class EnterPositiveNumber 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        double num1= 0;


        while(true)
        {
             System.out.println("Enter a positive number: ");
             double userinput= sc.nextDouble();

             if(userinput>0)
             {
                break;
             }

        }

    }
}
