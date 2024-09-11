package APCS;
import java.util.Scanner;

public class FirstThreePrograms 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to test a right triangle (enter 1), compute pi/4 (enter 2), or computer powers of two (enter 3)?");
        int choice = sc.nextInt();

        switch(choice)
        {
            case 1:
            System.out.println("Give me one side of the triangle please.");
            int firstSide = sc.nextInt();
            System.out.println("Give me another side of the triangle please.");
            int secondSide = sc.nextInt();
            System.out.println("Give me the last side of the triangle please.");
            int thirdSide = sc.nextInt();
            boolean rightTriChecker = rightTriangle(firstSide, secondSide, thirdSide);
            if(rightTriChecker == true)
            {
                System.out.println("It is a right triangle!");
            } else {
                System.out.println("It is not a right triangle!");
            }
            break;
            case 2:
            System.out.println("How many terms would you like to go into the sequence?");
            int N = sc.nextInt();
            double piFour = LeibnizFormPi(N);
            System.out.println(piFour);
        }
    }   

public static boolean rightTriangle(int firstSide, int secondSide, int thirdSide)
{
    int a = 0;
    int b = 0;
    int c = 0;
    if(firstSide > secondSide && firstSide > thirdSide)
    {
        c = firstSide;
    } else {
        a = firstSide;
    }
    if(secondSide > firstSide && secondSide > thirdSide)
    {
        c = secondSide;
    } else {
        b = secondSide;
    }
    if(a == 0)
    {
        a = thirdSide;
    } else if(b == 0){
        b = thirdSide;
    } else if(c == 0){
        c = thirdSide;
    }
    double result = (a*a) + (b*b);
    double check = (c*c);
    if(result == check)
    {
        return true;
    } else {
        return false;
    }
}

public static double LeibnizFormPi(int N)
{
    double piDivFour = 0;
    double numberAtN;
    for(int i = 0; i <= N; i++)
    {
        double topTerm = 0.0;
        if(i % 2 == 0)
        {
            topTerm = 1;
        } else {
            topTerm = -1;
        }
        numberAtN = topTerm/((2*i)+1);
        piDivFour += numberAtN;
    }
    return piDivFour;
}
}

