import java.util.Scanner;

class PiggyBank {
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int coinTotalValue;
    private int amountOfEachCoin;
    
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

    void addCoins(int num1, int num2, int num3, int num4){
        pennies += num1;
        nickels += num2;
        dimes += num3;
        quarters += num4;
    }

    double calcCoins(){
        coinTotalValue = pennies + (nickels*5) + (dimes*10) + (quarters*25);
        coinTotalValue = coinTotalValue/100;
        return coinTotalValue;
    }
}

    public class PiggyBankNP{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Would you like to start with zero coins(type 0) or do you want to set your amount(type 1)?");
            int bankchoice = sc.nextInt();

            switch (bankchoice) {
                case 0:
                    PiggyBank bank1 = new PiggyBank();
                    System.out.println("How many pennies would you like to add to the bank?");
                    int num1 = sc.nextInt();
                    System.out.println("How many nickels would you like to add to the bank?");
                    int num2 = sc.nextInt();
                    System.out.println("How many dimes would you like to add to the bank?");
                    int num3 = sc.nextInt();
                    System.out.println("How many quarters would you like to add to the bank?");
                    int num4 = sc.nextInt();
                    
                    bank1.addCoins(num1, num2, num3, num4);
                    double totalvalue = bank1.calcCoins();

                    System.out.println("You have " + num1 + " pennies, " + num2 + " nickels, "+ num3 + " dimes, and" + num4 + " quarters.");
                    System.out.println("Your piggybank has a value of " + totalvalue + "dollars");
                    break;
            
                case 1:
                    break;
            }

        

        }
    }
