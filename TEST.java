import java.util.Scanner;
public class TEST 
{
    public static void main(String[] args){
    Scanner sc = new Scanner(System.in);

    System.out.println("What is your word?");
    String testWord = sc.nextLine();
    char[] letters = new char[testWord.length()];

    for (int i = 0; i < testWord.length(); i++) {
        char ch = testWord.charAt(i);
        letters[i] = ch;
    }

    boolean isPalindrome = true;
    for (int i = 0; i < testWord.length() / 2; i++) {
        if (letters[i] != letters[testWord.length() - i - 1]) {
            isPalindrome = false;
            break;
        }
    }

    if (isPalindrome) {
        System.out.println("The word: " + testWord + " is a palindrome.");
    } else {
        System.out.println("The word: " + testWord + " is not a palindrome.");
    }
}
}
