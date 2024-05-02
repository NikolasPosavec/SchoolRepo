import java.util.Scanner;

class PiggyBank {
    private int pennies;
    private int nickels;
    private int dimes;
    private int quarters;
    private int coinTotalValue;
    private double dollarAmount;

    PiggyBank(int totval, int pens, int nicks, int dims, int quarts) {
        coinTotalValue = totval;
        pennies = pens;
        nickels = nicks;
        dimes = dims;
        quarters = quarts;
    }

    PiggyBank(int pens, int nicks, int dimes1, int quarts) {
        pennies = pens;
        nickels = nicks;
        dimes = dimes1;
        quarters = quarts;
    }

    int getNumPennies() {
        return pennies;
    }

    int getNumNickels() {
        return nickels;
    }

    int getNumDimes() {
        return dimes;
    }

    int getNumQuarters() {
        return quarters;
    }

    void addCoins(int num1, int num2, int num3, int num4) {
        pennies += num1;
        nickels += num2;
        dimes += num3;
        quarters += num4;
    }

    int calcCoins() {
        coinTotalValue = pennies + (nickels * 5) + (dimes * 10) + (quarters * 25);
        return coinTotalValue; 
    }

    void sortCoins() {
        int remainingValue = coinTotalValue;
        quarters = remainingValue / 25;
        remainingValue = remainingValue - quarters * 25;
        dimes = remainingValue / 10;
        remainingValue = remainingValue - dimes * 10;
        nickels = remainingValue / 5;
        remainingValue = remainingValue - nickels * 5;
        pennies = remainingValue;
    }

    public String toString() {
        int totalCents = calcCoins();
        int dollars = totalCents / 100;
        int cents = totalCents % 100;
        return ("You have " + pennies + " pennies, " + nickels + " nickels, " + dimes + " dimes, and " + quarters + " quarters."
                + " Your piggy bank has a value of $" + dollars + "." + (cents < 10 ? "0" : "") + cents + ".");
    }

    public String toString2() {
        return ("You have " + quarters + " quarters, " + dimes + " dimes, " + nickels + " nickels, " + "and " + pennies + " pennies.");
    }
}

public class PiggyBankNP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Would you like to start with a cent value (type 0) or do you want to set your own value for each coin type (type 1)?");
        int bankchoice = sc.nextInt();
        PiggyBank bank;

        switch (bankchoice) {
            case 0:
                System.out.println("What is the total value of coins in cents?");
                int coinVal = sc.nextInt();
                int pennies = 0;
                int nickels = 0;
                int dimes = 0;
                int quarters = 0;
                bank = new PiggyBank(coinVal, pennies, nickels, dimes, quarters);
                bank.sortCoins();
                System.out.println(bank.toString2());

                boolean numchecker = true;
                while (numchecker) {
                    System.out.println("Would you like to add more (type 0) or exit (type 1)?");
                    int numcheck = sc.nextInt();
                    if (numcheck == 0) {
                        System.out.println("How many pennies would you like to add to the bank?");
                        int pens = sc.nextInt();
                        System.out.println("How many nickels would you like to add to the bank?");
                        int nicks = sc.nextInt();
                        System.out.println("How many dimes would you like to add to the bank?");
                        int dimes1 = sc.nextInt();
                        System.out.println("How many quarters would you like to add to the bank?");
                        int quarts = sc.nextInt();
                        bank.addCoins(pens, nicks, dimes1, quarts);
                        System.out.println(bank.toString2());
                    } else if (numcheck == 1) {
                        numchecker = false;
                    }
                }
                break;
            case 1:
                System.out.println("How many pennies would you like to add to the bank?");
                int pens1 = sc.nextInt();
                System.out.println("How many nickels would you like to add to the bank?");
                int nicks1 = sc.nextInt();
                System.out.println("How many dimes would you like to add to the bank?");
                int dimes11 = sc.nextInt();
                System.out.println("How many quarters would you like to add to the bank?");
                int quarts1 = sc.nextInt();

                bank = new PiggyBank(pens1, nicks1, dimes11, quarts1);
                double totalvalue11 = bank.calcCoins();
                System.out.println(bank.toString());
            
                boolean numchecker1 = true;
                while (numchecker1) {
                    System.out.println("Would you like to add more (type 0) or exit (type 1)?");
                    int numcheck1 = sc.nextInt();
                    if (numcheck1 == 0) {
                        System.out.println("How many pennies would you like to add to the bank?");
                        int pens = sc.nextInt();
                        System.out.println("How many nickels would you like to add to the bank?");
                        int nicks = sc.nextInt();
                        System.out.println("How many dimes would you like to add to the bank?");
                        int dimes1 = sc.nextInt();
                        System.out.println("How many quarters would you like to add to the bank?");
                        int quarts = sc.nextInt();
                
                        bank.addCoins(pens, nicks, dimes1, quarts);
                        double totalvalue1 = bank.calcCoins();
                        System.out.println(bank.toString());
                    } else if (numcheck1 == 1) {
                        numchecker1 = false;
                    }
                }
                break;
            
        }
    }
}
