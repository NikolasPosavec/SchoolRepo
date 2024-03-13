import java.util.Scanner;
public class MethodsCalculatorNP {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        System.out.println("Do you want to add(+), subtract(-), multiply(*), or divide(/)? Type the corresponding symbol.");
        String symbol = sc.nextLine();
        System.out.println("Write the first number you would like in the equation: ");
        double d = sc.nextDouble();
        System.out.println("Write the second number you would like in the equation: ");
        double e = sc.nextDouble();
        if(symbol.equals("+")){
            double ans = add(d, e);
            System.out.println(ans);
        }else if(symbol.equals("-")){
            double ans1 = sub(d, e);
            System.out.println(ans1);
        }else if(symbol.equals("*")){
            double ans2 = mult(d, e);
            System.out.println(ans2);
        }else if(symbol.equals("/")){
            double ans3 = div(d, e);
            System.out.println(ans3);
        }else{
            System.out.println("Invalid symbol, try again");
        }
    }
    public static double add(double d, double e) {
        double sum = d+e;
        return(sum);
    }
    public static double sub(double d, double e) {
        double diff = d-e;
        return(diff);
    }
    public static double mult(double d, double e){
        double product = d*e;
        return(product);
    }
    public static double div(double d, double e){
        double quo = d/e;
        return(quo);
    }
}
