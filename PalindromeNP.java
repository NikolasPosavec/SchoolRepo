import java.util.Scanner;
public class PalindromeNP {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your word?");
        String testWord = sc.nextLine();
        char [] letters = new char[testWord.length()];

        for(int i=0; i<testWord.length(); i++){
            letters[i] = testWord.charAt(i);
        }

        boolean palindromechecker = true;

        for(int i = 0; i<testWord.length()/2; i++){
            if (letters[i] != letters[testWord.length() - i - 1]) {
                palindromechecker = false;
            }
        }
        
        if (palindromechecker) {
            System.out.println("The word: " + testWord + " is a palindrome.");
        } else {
            System.out.println("The word: " + testWord + " is not a palindrome.");
        }
    }
}
    

