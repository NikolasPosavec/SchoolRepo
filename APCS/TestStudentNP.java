import java.text.DecimalFormat;
import java.util.*;

public class TestStudentNP
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner (System.in);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);
        ArrayList <Double> tG1 = new ArrayList<Double>();
        ArrayList <Double> tG2 = new ArrayList<Double>();
        tG1.add(65.2);
        tG1.add(34.7);
        tG1.add(81.3);
        double avg = 60.4;
        
        StudentNP s1 = new StudentNP();
        s1.setName("Nick");
        s1.setGradYear(2025);
        s1.setGender("male");
        s1.setTestGrades(tG1);
        s1.setAverage(avg);

        System.out.println("What is your name?");
        String n = sc.nextLine();
        System.out.println("What is your graduation year?");
        int gr = sc.nextInt();
        sc.nextLine();
        System.out.println("What is your gender?");
        String ge = sc.nextLine();
        //for making arraylist thingy
        System.out.println("How many test grades would you like to enter?");
        int tG2control = sc.nextInt();
        for(int i = 0; i < tG2control; i++)
        {
            System.out.println("Enter test number " + (i+1) + " (decimal places are allowed)...");
            double test = sc.nextDouble();
            tG2.add(test);
        }
        //find average called av of tests in tG2
        double av = 0.0;
        double counter = 0.0;
        for(Double test: tG2)
        {
            av += test;
            counter += 1.0;
        }
        av = av/counter;
        df.format(av);

        StudentNP s2 = new StudentNP(n,gr,ge,tG2,av);

        System.out.println("This is the data for student 1: ");
        System.out.println(s1);
        System.out.println("This is the data for student 2 (user entered data): ");
        System.out.println(s2);
    }
}
