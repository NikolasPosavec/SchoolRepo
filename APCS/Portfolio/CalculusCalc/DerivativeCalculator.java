package Portfolio.CalculusCalc;
import java.util.Scanner;

public class DerivativeCalculator 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Welcome to the Derivative Calculator!");
        System.out.println("Enter a mathematical expression (e.g., x^n, sin(x), cos(x)): ");
        String expression = sc.nextLine();

        try 
        {
            String derivative = calculateDerivative(expression);
            System.out.println("The derivative of " + expression + " is: " + derivative);
        } catch (IllegalArgumentException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private static String calculateDerivative(String expression) 
    {
        expression = expression.trim();

        if (expression.matches("x\\^\\d+")) 
        { 
            return powerRule(expression);
        } else if (expression.equalsIgnoreCase("sin(x)")) { 
            return "cos(x)";
        } else if (expression.equalsIgnoreCase("cos(x)")) { 
            return "-sin(x)";
        } else if (expression.equalsIgnoreCase("tan(x)")) { 
            return "sec^2(x)";
        } else {
            throw new IllegalArgumentException("Unsupported expression. Try x^n, sin(x), cos(x), or tan(x).");
        }
    }

    private static String powerRule(String expression) 
    {
        String[] parts = expression.split("\\^");
        int exponent = Integer.parseInt(parts[1]);

        if (exponent == 1) {
            return "1"; 
        }

        return exponent + "*x^" + (exponent - 1); 
    }
}
