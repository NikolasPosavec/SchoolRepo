import java.util.*;

public class StudentNP {
    private String name;
    private int gradYear;
    private String gender;
    ArrayList<Double> testGrades = new ArrayList<Double>();
    private double average;

    public StudentNP() {
        this("", 0, "", new ArrayList<Double>(), 0.0);
    }

    public StudentNP(String n, int gr, String ge, ArrayList<Double> tG, double avg) {
        name = n;
        gradYear = gr;
        gender = ge;
        testGrades = tG;
        average = avg;
    }

    public StudentNP(StudentNP s) {
        this(s.name, s.gradYear, s.gender, s.testGrades, s.average);
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setGradYear(int gr) {
        gradYear = gr;
    }

    public int getGradYear() {
        return gradYear;
    }

    public void setGender(String ge) {
        gender = ge;
    }

    public String getGender() {
        return gender;
    }

    public void setTestGrades(ArrayList<Double> tG) {
        testGrades = tG;
    }

    public ArrayList<Double> getTestGrades() {
        return testGrades;
    }

    public void setAverage(double avg) {
        average = avg;
    }

    public double getAverage() {
        return average;
    }

    public String getLetterGrade() {
        if (average >= 90) {
            return "A";
        } else if (average >= 80) {
            return "B";
        } else if (average >= 70) {
            return "C";
        } else if (average >= 60) {
            return "D";
        } else {
            return "F";
        }
    }

    public void sortGrades() {
        Collections.sort(testGrades);
    }

    public void printSortedGrades() {
        sortGrades();
        System.out.println("Sorted Test Grades: " + testGrades);
    }

    public double getHighestGrade() {
        return Collections.max(testGrades);
    }

    public double getLowestGrade() {
        return Collections.min(testGrades);
    }

    public void printHighestAndLowest() {
        System.out.println("Highest Grade: " + getHighestGrade());
        System.out.println("Lowest Grade: " + getLowestGrade());
    }

    public void addTestGrade(double grade) {
        if (grade >= 0 && grade <= 100) {
            testGrades.add(grade);
            updateAverage();
        } else {
            System.out.println("Invalid grade. Please enter a grade between 0 and 100.");
        }
    }

    private void updateAverage() {
        double sum = 0.0;
        for (Double grade : testGrades) {
            sum += grade;
        }
        average = sum / testGrades.size();
    }

    public String toString() {
        return String.format(
            "Name: %s%n" +
            "Graduation Year: %d%n" +
            "Gender: %s%n" +
            "Test Grades: %s%n" +
            "Average: %.2f",
            name, gradYear, gender, testGrades, average
        );
    }
}
