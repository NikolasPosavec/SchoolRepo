import java.util.Arrays;
import java.util.Random;

public class TEST {
    public static void main(String[] args) {
        // Generate random numbers
        int[] numbers = new int[10];
        Random random = new Random();

        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt((100 - 1) + 1) + 1; // Random number between 1 and 100
        }

        // Sort even and odd numbers
        int[] evenNumbers = new int[numbers.length];
        int[] oddNumbers = new int[numbers.length];
        int evenCount = 0;
        int oddCount = 0;

        (int number = 0;  < numbers.length; count++)
            if (number % 2 == 0) {
                evenNumbers[evenCount++] = number;
            } else {
                oddNumbers[oddCount++] = number;
            }
        }

        // Trim arrays to actual size
        evenNumbers = Arrays.copyOf(evenNumbers, evenCount);
        oddNumbers = Arrays.copyOf(oddNumbers, oddCount);

        // Sort the arrays
        Arrays.sort(evenNumbers);
        Arrays.sort(oddNumbers);

        // Print the sorted arrays
        System.out.println("Even Numbers: " + Arrays.toString(evenNumbers));
        System.out.println("Odd Numbers: " + Arrays.toString(oddNumbers));
    }
}
