import java.util.Scanner;

class PiggyBank {
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int coinTotalValue;
    private int amountOfEachCoin;
    
    PiggyBank(int totval, int pens, int nicks, int dims, int quarts){
        coinTotalValue = totval;
        pennies = pens;
        nickels = nicks;
        dimes = dims;
        quarters = quarts;
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

    void sortCoins(){
        quarters = coinTotalValue/25;
        coinTotalValue = coinTotalValue - quarters*25;
        dimes = coinTotalValue/10;
        coinTotalValue = coinTotalValue - dimes*10;
        nickels = coinTotalValue/5;
        coinTotalValue = coinTotalValue - nickels*5;
        pennies = coinTotalValue;
    }

    public String toString(){
        return ("You have " + pennies + " pennies, " + nickels + " nickels, "+ dimes + " dimes, and" + quarters + " quarters." 
               + "Your piggybank has a value of " + coinTotalValue + "dollars");
    }

    public String toString2(){
        return ("You have " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + "and " + pennies + " pennies.");
    }
}

    public class PiggyBankNP{
        public static void main(String[] args){
            Scanner sc = new Scanner(System.in);
            
            System.out.println("Would you like to start with a cent value (type 0) or do you want to set your own value for each coin type(type 1)?");
            int bankchoice = sc.nextInt();

            switch (bankchoice) {
                case 0:
                    while(checker){
                    boolean checker = true;
                    System.out.println("What is the total value of coins in cents?");
                    int coinVal = sc.nextInt();
                    int pennies = 0;
                    int nickels = 0;
                    int dimes = 0;
                    int quarters = 0;
                    PiggyBank bank1 = new PiggyBank(coinVal, pennies, nickels, dimes, quarters);
                    bank1.sortCoins();
                    System.out.println(bank1.toString2());
                    System.out.println("Would you like to add more (type 0) or exit (type 1)?");
                    int numcheck = sc.nextInt();
                    if(numcheck==1){
                        checker = false;
                    }
                }
                    break;
                case 1:
                    while(checker1){
                    boolean checker1 = true;
                    System.out.println("How many pennies would you like to add to the bank?");
                    int pens = sc.nextInt();
                    System.out.println("How many nickels would you like to add to the bank?");
                    int nicks = sc.nextInt();
                    System.out.println("How many dimes would you like to add to the bank?");
                    int dimes1 = sc.nextInt();
                    System.out.println("How many quarters would you like to add to the bank?");
                    int quarts = sc.nextInt();
                    PiggyBank bank2 = new PiggyBank(pens, nicks, dimes1, quarts);
                    double totalvalue1 = bank2.calcCoins();
                    System.out.println(bank2.toString());
                    System.out.println("Would you like to add more (type 0) or exit (type 1)?");
                    int numcheck1 = sc.nextInt();
                    if(numcheck1==1){
                        checker1 = false;
                    }
                    }
                    break;
            }

        

        
    
