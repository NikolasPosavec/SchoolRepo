import java.util.Arrays;
import java.util.Scanner;
public class RandomNumberGeneratorNP 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        int [] numbers = new int [10];
        

        for(int count = 0 ; count < numbers.length ; count++)
        {
            numbers[count] = (int) (Math.random() * 100) + 1;
        }
        
        int [] evens = new int [numbers.length];
        int [] odds = new int [numbers.length];
        int evenCount=0;
        int oddCount=0;
        
        for (int count = 0; count < numbers.length; count++)
        {
            int number = numbers[count];
            
            if (number % 2 == 0) {
                evens[evenCount++] = number;
            } else {
                odds[oddCount++] = number;
            }
        }

        evens = Arrays.copyOf(evens, evenCount);
        odds = Arrays.copyOf(odds, oddCount);

        System.out.println("Even numbers: " + Arrays.toString(evens));
        System.out.println("Odd Numbers: " + Arrays.toString(odds)); 
    }
}
    

