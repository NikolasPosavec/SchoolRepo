import java.text.DecimalFormat;
import java.util.Scanner;

public class GradesArrayNP 
{
        public static void main(String[] args) 
        {
            Scanner sc = new Scanner(System.in);
            System.out.println("How many courses do you take?");
            int coursenumber = sc.nextInt();

            sc.nextLine();

            String[] courses = new String[coursenumber];
            int[] grades = new int[coursenumber];
            double sum = 0;
            double average = 0;
            char[] letters = new char[coursenumber];
            double[] cgpa = new double [coursenumber];
            double GPA = 0;

        for (int i = 0; i < coursenumber; i++) 
        {
            System.out.print("Enter grade #" + (i + 1) + ": ");
            grades[i] = sc.nextInt();
        }

        sc.nextLine();

        for (int i = 0; i < coursenumber; i++) 
        {
            System.out.println("Enter Course #" + (i + 1) + ":");
            courses[i] = sc.nextLine();
        }

        System.out.println("\n\033[1mGRADE REPORT:\033[0m");

        System.out.printf("%-15s%-10s%-10s%-10s\n", "Course", "Grade", "Letter", "GPA");
        for (int i = 0; i < coursenumber; i++) 
        {
            if (grades[i] >= 90) {
                letters [i] = 'A';
            } else if (grades[i] >= 80) {
                letters [i] = 'B';
            } else if (grades[i] >= 70) {
                letters [i] = 'C';
            } else if (grades[i] >= 60) {
                letters [i] = 'D';
            } else {
                letters [i] = 'F';
            }

            double courseGPA;
            if (grades[i] >= 90) {
                cgpa [i] = 4.0;
            } else if (grades[i] >= 80) {
                cgpa [i] = 3.0;
            } else if (grades[i] >= 70) {
                cgpa [i] = 2.0;
            } else if (grades[i] >= 60) {
                cgpa [i] = 1.0;
            } else {
                cgpa [i] = 0.0;
            }

            System.out.printf("%-15s%-10d%-10c%-10.2f\n", courses[i], grades[i], letters [i], cgpa [i]);
            
            sum += grades [i];
            GPA += cgpa [i];
        }

        average = sum / coursenumber;

        DecimalFormat d = new DecimalFormat("#.##");
        average = Double.parseDouble(d.format(average));

        System.out.println("The numerical average of the grades is: " + average);

        GPA = GPA/coursenumber;
        
        DecimalFormat e = new DecimalFormat("#.##");
        GPA = Double.parseDouble(e.format(GPA));

        System.out.println("Your GPA is: " + GPA);
    }
}
