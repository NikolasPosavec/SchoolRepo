package APCS;
import java.util.*;

public class summation
{
    static double sum;
    static double uB;
    static double lB;
    static String funct;

    public summation()
    {
        sum = 0.0;
        uB = 0.0;
        lB = 0.0;
        funct = " ";
    }
    public summation(double S, double U, double L, String F)
    {
        sum = S;
        uB = U;
        lB = L;
        funct = F;
    }

public static void main(String[] args) 
{
    Scanner sc = new Scanner (System.in);
    sum = 0.0;
    System.out.println("What is your upper bound?");
    double uB = sc.nextDouble();
    System.out.println("What is your lower bound?");
    double lB = sc.nextDouble();
    System.out.println("What is your function?");
    String funct = sc.nextLine();

    summation(sum, uB, lB, funct);
    
        for(int i = 0; i <= uB; i++)
        {
            sum += 
        }
        
    }
    
}