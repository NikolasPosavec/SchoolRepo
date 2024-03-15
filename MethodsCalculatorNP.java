import java.util.Scanner;

public class MethodsCalculatorNP {
    private static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Select a calculator: ");
        System.out.println("1: Quadratic equation");
        System.out.println("2: System of equations");
        System.out.println("3: Perfect square trinomial");
        System.out.println("4: Circles");
        int calcop = sc.nextInt();

        switch (calcop) {
            case 1:
                Quadratic();
                break;
            case 2:
                solveSystemOfEquations();
                break;
            case 3:
                perfectSquareTrinomial();
                break;
            case 4:
                Circles();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }

    public static void Quadratic() {
        System.out.println("Enter coefficients a, b, and c:");
        double a = sc.nextDouble();
        double b = sc.nextDouble();
        double c = sc.nextDouble();

        double discriminant = b * b - 4 * a * c;

        if (discriminant > 0) {
            double root1 = (-b + Math.sqrt(discriminant)) / (2 * a);
            double root2 = (-b - Math.sqrt(discriminant)) / (2 * a);
            root1 = roundToTwoDecimals(root1);
            root2 = roundToTwoDecimals(root2);
            System.out.println("Real roots: " + root1 + " and " + root2);
        } else if (discriminant == 0) {
            double root = -b / (2 * a);
            root = roundToTwoDecimals(root);
            System.out.println("Real and same root: " + root);
        } else {
            double realPart = -b / (2 * a);
            double imaginaryPart = Math.sqrt(Math.abs(discriminant)) / (2 * a);
            realPart = roundToTwoDecimals(realPart);
            imaginaryPart = roundToTwoDecimals(imaginaryPart);
            System.out.println("Imaginary roots: " + realPart + " + " + imaginaryPart + "i and " + realPart + " - " + imaginaryPart + "i");
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
            x = roundToTwoDecimals(x);
            y = roundToTwoDecimals(y);
            System.out.println("Solution: x = " + x + ", y = " + y);
        }
    }
    public static void perfectSquareTrinomial() {
        System.out.println("Enter your coefficients for the equation (ax+b)^2:");
        System.out.print("a: ");
        double a = sc.nextDouble();
        System.out.print("b: ");
        double b = sc.nextDouble();

        double axSquared = a * a;
        double twoabx = 2 * a * b;
        double bb = b * b;
        axSquared = roundToTwoDecimals(axSquared);
        twoabx = roundToTwoDecimals(twoabx);
        bb = roundToTwoDecimals(bb);
        System.out.println("Solution: " + axSquared + "x^2 + " + twoabx + "x + " + bb);
    }
    public static void Circles() {
        System.out.println("Which calculation would you like to perform?");
        System.out.println("1: Calculate arc length");
        System.out.println("2: Calculate central angle");
        System.out.println("3: Calculate center of a circle");
        int choice = sc.nextInt();

        switch (choice) {
            case 1:
                calculateArcLength();
                break;
            case 2:
                calculateCentralAngle();
                break;
            case 3:
                calculateCircleCenter();
                break;
            default:
                System.out.println("Invalid choice");
        }
    }
    public static void calculateArcLength() {
        System.out.print("Enter the angle (in radians): ");
        double angleRadians = sc.nextDouble();
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        double arcLength = angleRadians * radius;
        arcLength = roundToTwoDecimals(arcLength);
        System.out.println("The arc length is: " + arcLength);
    }
    public static void calculateCentralAngle() {
        System.out.print("Enter the arc length: ");
        double arcLength = sc.nextDouble();
        System.out.print("Enter the radius of the circle: ");
        double radius = sc.nextDouble();
        radius = roundToTwoDecimals(radius);
        double centralAngle = arcLength / radius;
        centralAngle = roundToTwoDecimals(centralAngle);
        System.out.println("The central angle (in radians) is: " + centralAngle);
    }
    public static void calculateCircleCenter() {
        System.out.println("Enter the coordinates of the endpoints of the diameter:");
        System.out.print("x1: ");
        double x1 = sc.nextDouble();
        System.out.print("y1: ");
        double y1 = sc.nextDouble();
        System.out.print("x2: ");
        double x2 = sc.nextDouble();
        System.out.print("y2: ");
        double y2 = sc.nextDouble();

        double centerX = (x1 + x2) / 2;
        double centerY = (y1 + y2) / 2;
        centerX = roundToTwoDecimals(centerX);
        centerY = roundToTwoDecimals(centerY);
        System.out.println("The coordinates of the center of the circle are: (" + centerX + ", " + centerY + ")");
    }
    public static double roundToTwoDecimals(double number) {
        return Math.round(number * 100.0) / 100.0;
    }
}
