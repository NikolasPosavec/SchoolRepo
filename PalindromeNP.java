import java.util.Scanner;
public class PalindromeNP {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your word?");
        String originalWord = sc.nextLine().toLowerCase();

        StringBuilder sb = new StringBuilder();
        for (char ch : originalWord.toCharArray()) {
            if (Character.isLetter(ch)) {
                sb.append(ch); 
            }
        }
        String processedWord = sb.toString();
        int processedlength = processedWord.length();
        boolean palindrome = true;
        for (int i = 0; i < processedlength / 2; i++) {
            if (processedWord.charAt(i) != processedWord.charAt(processedlength - i - 1)) {
                palindrome = false;
            }
        }
        System.out.println("The word: " + processedWord + (palindrome ? " is a palindrome." : " is not a palindrome."));
    }
}
