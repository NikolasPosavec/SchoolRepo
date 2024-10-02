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
            System.out.println("The Leibniz sequence says that " + N + " terms into the sequence, pi/4 = " + piFour);
            break;
            case 3:
            int P;
            do {
                System.out.println("2^x? (Type in your x value, or a negative number to quit)");
                P = sc.nextInt();
                if (P >= 0) {
                    int finalPow = powsOfTwo(P);
                    if (finalPow == -1) {
                        System.out.println("Invalid input, try again.");
                    } else {
                        System.out.println("2^" + P + " = " + finalPow);
                    }
                }
            } while (P >= 0);
            System.out.println("Exited powers of two.");
            break;
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
    double piDivFour = 0; //this is what tryna find
    double numberAtN; //gonna use this to add up each value to piDivFour
    for(int i = 0; i <= N; i++) //basically im just sayin that i = k and N is the limit
    {
        double topTerm = 0.0; //trying to figure out if topTerm is -1 or 1 -> (-1)^k
        if(i % 2 == 0)
        {
            topTerm = 1;
        } else {
            topTerm = -1;
        }
        numberAtN = topTerm/((2*i)+1); //now im just sayin that the value at term N is ____
        piDivFour += numberAtN; //continue to add up cus its inf series
    }
    return piDivFour;
}

public static int powsOfTwo (int N)
{
    if(N < 0){ //sentinel value checker
        return -1;
    }
    int powOfTwo = 1; //start at 1 because 2^0 = 1 and 0 is lowest allowed value
    int i = 1; //LCV for outer while loop
    int j = 1; //LCV for inner while loop
    
    while(i <= N) 
    {
        i++; //Increment outer loop counter
        
        while(j < i) 
        {
            j++; //Increment inner loop counter
            powOfTwo *= 2;
        }
    }
    return powOfTwo;
}

}