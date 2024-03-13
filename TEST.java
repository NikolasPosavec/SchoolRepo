import java.util.Scanner;

public class TEST {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("What's your word?");
        String strF = sc.nextLine();
        char[] strFa = strF.toCharArray();
        char[] strRa = new char[strF.length()];
        for (int i = 0; i < strF.length(); i++) {
            strRa[strF.length() - 1 - i] = strFa[i];
        }
        String backward = new String(strRa);
        System.out.println(backward);
    }
}
