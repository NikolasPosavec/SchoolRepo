import java.text.DecimalFormat;
import java.util.Scanner;

public class IRSProgramNP 
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter marital status (1 = single, 2 = married): ");
        double mstat = sc.nextDouble();

        System.out.println("Enter your taxable income: ");
        double taxinc = sc.nextDouble();

        double fedtax = 0;

        if (mstat == 1) {
            if (taxinc > 0 && taxinc <= 27050) {
                fedtax = taxinc * 0.15;
            } 
            else if (taxinc > 27050 && taxinc <= 65550) {
                fedtax = 4057.50 + (taxinc - 27050) * 0.275;
            } 
            else if (taxinc > 65550 && taxinc <= 136750) {
                fedtax = 14645.00 + (taxinc - 65550) * 0.305;
            } 
            else if (taxinc > 136750 && taxinc <= 297350) {
                fedtax = 36361.00 + (taxinc - 136750) * 0.355;
            } 
            else if (taxinc > 297350) {
                fedtax = 93374.00 + (taxinc - 297350) * 0.391;
            }
        } else if (mstat == 2) {
            if (taxinc > 0 && taxinc <= 45200) {
                fedtax = taxinc * 0.15;
            } 
            else if (taxinc > 45200 && taxinc <= 109250) {
                fedtax = 6780.00 + (taxinc - 45200) * 0.275;
            } 
            else if (taxinc > 109250 && taxinc <= 166500) {
                fedtax = 24393.75 + (taxinc - 109250) * 0.305;
            } 
            else if (taxinc > 166500 && taxinc <= 297350) {
                fedtax = 41855.00 + (taxinc - 166500) * 0.355;
            }
            else if (taxinc > 297350) {
                fedtax = 88306.00 + (taxinc - 297350) * 0.391;
            }
        }
        
        DecimalFormat d = new DecimalFormat("#.##");
        fedtax = Double.parseDouble(d.format(fedtax));
        
        System.out.println("Your Federal tax is: " + fedtax);

        }

    }


    

