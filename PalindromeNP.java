import java.util.Scanner;
public class PalindromeNP {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        System.out.println("What is your word?");
        String testWord = sc.nextLine();
        char [] letters = new char[testWord.length()];

        for(int i=0; i<testWord.length(); i++){
            char ch = testWord.charAt(i);
            ch = letters [i];
        }

        if (letters[0]==letters[testWord.length()]){
            for(int i = 1; i<testWord.length(); i++){
                if(letters[0+i]==letters[testWord.length()-i]){
                    System.out.println("The word: " + testWord + " is a palindrome." );
                }
            }
        }
    }
    
}
