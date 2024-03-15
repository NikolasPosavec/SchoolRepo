import java.util.Scanner;

public class MethodsCalculatorNP {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Which calculator would you like to use? 1: Quadratic equation 2: System of equations");
        int calcop = sc.nextInt();

        switch (calcop) {
            case 1:
                Quadratic();
                break;
            case 2:
                solveSystemOfEquations();
                break;
            default:
                System.out.println("Error: Not an option");
        }
    }

    public static void Quadratic() {
        System.out.println("Enter the coefficients (a, b, c) of the quadratic equation: ");
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
        double b = sc.nextDouble();
        System.out.print("c: ");
        double c = sc.nextDouble();
        double discriminant = b * b - 4 * a * c;
        if (discriminant >= 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);

            System.out.println("The roots are real and different.");
            System.out.println("Root 1 = " + root1);
            System.out.println("Root 2 = " + root2);
        } else {
            System.out.println("There are no real solutions.");
        }
    }

    public static void solveSystemOfEquations() {
        System.out.println("Enter coefficients for the first equation (ax + by = c):");
        System.out.print("a: ");
        double a1 = sc.nextDouble();
        System.out.print("b: ");
        double b1 = sc.nextDouble();
        System.out.print("c: ");
        double c1 = sc.nextDouble();

        System.out.println("Enter coefficients for the second equation (dx + ey = f):");
        System.out.print("d: ");
        double a2 = sc.nextDouble();
        System.out.print("e: ");
        double b2 = sc.nextDouble();
        System.out.print("f: ");
        double c2 = sc.nextDouble();

        double determinant = a1 * b2 - a2 * b1;

        if (determinant == 0) {
            System.out.println("The system of equations has no unique solution.");
        } else {
            double x = (c1 * b2 - c2 * b1) / determinant;
            double y = (a1 * c2 - a2 * c1) / determinant;
            System.out.println("Solution: x = " + x + ", y = " + y);
        }
    }
}
