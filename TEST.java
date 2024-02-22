import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your word?");
        String testWord = sc.nextLine();

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < testWord.length(); i++) {
            char ch = testWord.charAt(i);
            if ((ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                sb.append(Character.toLowerCase(ch)); 
            }
        }

        String processedWord = sb.toString();

        char[] letters = new char[processedWord.length()];

        for (int i = 0; i < processedWord.length(); i++) {
            letters[i] = processedWord.charAt(i);
        }

        boolean palindromeChecker = true;

        for (int i = 0; i < processedWord.length() / 2; i++) {
            if (letters[i] != letters[processedWord.length() - i - 1]) {
                palindromeChecker = false;
            }
        }

        if (palindromeChecker) {
            System.out.println("The word: " + processedWord + " is a palindrome.");
        } else {
            System.out.println("The word: " + processedWord + " is not a palindrome.");
        }
    }
}
