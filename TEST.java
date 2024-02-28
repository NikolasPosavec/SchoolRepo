import java.util.Scanner;
public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter a word: ");
        String pword = sc.nextLine().toLowerCase();
        String norm = "";
        String reverse = "";
        boolean isPal = true;
        
        for(int i=0; i<pword.length(); i++){
            if(pword.charAt(i) >= 'a' && pword.charAt(i) <= 'z'){
                norm += pword.charAt(i);
            }
        }

        System.out.println(norm);

        for(int i = 0; i<norm.length()-1; i++){
            if(norm.charAt(i) != norm.charAt((norm.length()-1)-i)){
                isPal = false;
                System.out.println("The word " + pword + " is not a palindrome");
                break;
            }
        }

        if(isPal) System.out.println("This word " + pword + " is a palindrome!");

    }
}
