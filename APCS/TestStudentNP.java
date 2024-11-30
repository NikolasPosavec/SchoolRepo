import java.text.DecimalFormat;
import java.util.*;

public class TestStudentNP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DecimalFormat df = new DecimalFormat();
        df.setMaximumFractionDigits(2);

        // s1-I entered
        ArrayList<Double> tG1 = new ArrayList<Double>();
        tG1.add(65.2);
        tG1.add(34.7);
        tG1.add(81.3);
        StudentNP s1 = new StudentNP("Nick", 2025, "male", tG1, 60.4);
        
        // s2-user input
        System.out.println("What is your name?");
        String n = sc.nextLine();
        System.out.println("What is your graduation year?");
        int gr = sc.nextInt();
        sc.nextLine();
        System.out.println("What is your gender?");
        String ge = sc.nextLine();

        ArrayList<Double> tG2 = new ArrayList<Double>();
        System.out.println("How many test grades would you like to enter?");
        int tG2control = sc.nextInt();
        for (int i = 0; i < tG2control; i++) {
            double test;
            do {
                System.out.println("Enter test number " + (i + 1) + " (decimal places allowed, between 0 and 100):");
                test = sc.nextDouble();
                if (test < 0 || test > 100) {
                    System.out.println("Invalid input. Please enter a grade between 0 and 100.");
                }
            } while (test < 0 || test > 100);
            tG2.add(test);
        }

        double av = 0.0;
        for (Double test : tG2) {
            av += test;
        }
        av = av / tG2control;

        StudentNP s2 = new StudentNP(n, gr, ge, tG2, av);

        System.out.println("This is the data for student 1:");
        System.out.println(s1);
        System.out.println("Letter Grade for student 1: " + s1.getLetterGrade());

        System.out.println("This is the data for student 2:");
        System.out.println(s2);
        System.out.println("Letter Grade for student 2: " + s2.getLetterGrade());

        // Add extra grades
        System.out.println("Would you like to add more grades for student 2? (yes/no)");
        String addMore = sc.next();
        while (addMore.equalsIgnoreCase("yes")) {
            System.out.println("Enter the new grade (decimal places allowed, between 0 and 100): ");
            double newGrade = sc.nextDouble();
            s2.addTestGrade(newGrade);

            System.out.println("Updated Test Grades: " + s2.getTestGrades());
            System.out.println("Updated Average: " + df.format(s2.getAverage()));
            System.out.println("Letter Grade: " + s2.getLetterGrade());

            System.out.println("Would you like to add more grades for student 2? (yes/no)");
            addMore = sc.next();
        }

        s2.printSortedGrades();
        s2.printHighestAndLowest();
    }
}
