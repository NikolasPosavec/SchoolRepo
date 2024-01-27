import java.util.Scanner;

public class CheckMailNP
    {
        public static void main(String[] args)
        {
            Scanner sc = new Scanner(System.in);

            /*getting dimensions and weight (user input, simple print statements in 
            conjunction with defining the dimensions)*/
            
            System.out.println("In order to ship a package first class, the sum of length and girth must be less than 100 inches and the package must weigh less than 70 lbs.");
            
            System.out.println("Enter the weight of the package in pounds: ");
            double weight = sc.nextDouble();

            System.out.println("Enter the length of the package in inches: ");
            double dim1 = sc.nextDouble();

            System.out.println("Enter the width of the package in inches: ");
            double dim2 = sc.nextDouble();

            System.out.println("Enter the height of the package in inches: ");
            double dim3 = sc.nextDouble();
            
            /*determine the largest side and calculate girth (done using
            if and else if statements with the calculation for girth inside the 
            curly braces)*/

            double largest = dim1;
            double girth = 2 * (dim2 + dim3);

            if(dim2 > largest && dim2 > dim3){
                largest = dim2;
                girth = (2*dim1) + (2*dim3);
            }else if(dim3 > largest && dim3 > dim2){
                largest = dim3;
                girth = (2*dim1) + (2*dim2);
            }

            double length = largest;

            System.out.println("Girth is: " + girth + " inches");
            System.out.println("Length is: " + length + " inches");
            System.out.println("Weight is: " + weight + " pounds");

            /*determine if package is oversized or if it is acceptable
            (done by using if and if else statements to go through a list of parameters
            depending on what parameters the package fits a different message will be output)*/

            if(length + girth > 100 && weight > 70){
                System.out.println("Package is too large and too heavy.");
            }else if(length + girth > 100){
                System.out.println("Package is too large.");
            }else if(weight > 70){
                System.out.println("Package is too heavy.");
            }else if(length + girth < 100 && weight < 70 && length + girth >= 0 && weight >= 0){
                System.out.println("Package is acceptable.");
            }else if(length + girth < 0 || weight < 0){
                System.out.println("A value entered is invalid, please try again.");
            }

        }
    }