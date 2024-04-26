import java.util.Scanner;

class PiggyBank {
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    
    PiggyBank(){
        pennies = 0;
        nickels = 0;
        dimes = 0;
        quarters = 0;
    }
    PiggyBank(int pens, int nicks, int dimes1, int quarts){
        pennies = pens;
        nickels = nicks;
        dimes = dimes1;
        quarters = quarts;
    }

    int getNumPennies(){
        return pennies;
    }
    int getNumNickels(){
        return nickels;
    }
    int getNumDimes(){
        return dimes;
    }
    int getNumQuarters(){
        return quarters;
    }

    void addPennies(int num1){
        pennies += num1;
    }
    void addNickels(int num1){
        nickels += num1;
    }
    void addDimes(int num1){
        dimes += num1;
    }
    void addQuarters(int num1){
        quarters += num1;
    }
}

    public class PiggyBankNP{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            

        

        }
    }
