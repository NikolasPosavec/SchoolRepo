public class RollDiceNP 
{
    public static void main(String[] args)
    {
        int rolls = 0;
        int die1, die2, die3;
        
            do 
            {
                rolls++;
           
                die1 = (int) (Math.random() * 6) + 1;
                die2 = (int) (Math.random() * 6) + 1;
                die3 = (int) (Math.random() * 6) + 1;
        
            } while (die1 != die2 || die2 != die3);
        
        System.out.println("It took " + rolls + " rolls to get three of a kind: " + die1);
    }
}
        
 
