import java.util.Scanner;

public class LoanTableNP 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner (System.in);

        System.out.print("Enter the amount of the loan: ");
        double principal = sc.nextDouble();

        System.out.print("Enter the length of the loan in years: ");
        double years = sc.nextInt();

        System.out.print("Enter the low interest rate in %: ");
        double lowRate = sc.nextDouble();

        System.out.print("Enter the high interest rate in %: ");
        double highRate = sc.nextDouble();

        System.out.println("Annual Interest Rate" + " : " + "Monthly Payment");
        System.out.println("------------------------------------------------");

        
        for (double interestRate = lowRate; interestRate <= highRate; interestRate += 0.25) 
        {
            double monthlyInterestRate = interestRate / 1200.0;
            double numberOfPayments = years * 12;
            double letterc = Math.pow(1 + monthlyInterestRate, numberOfPayments);
            double monthlyPayment = principal * monthlyInterestRate * letterc / (letterc - 1);
            
            System.out.println(interestRate + " : " + monthlyPayment);
        }
            
        
    }
}
