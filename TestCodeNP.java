import java.util.Scanner;

public class TestCodeNP {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Please enter the original telephone number: ");
        String phonenum = sc.nextLine();
        String newtn = "";

        // #1: Remove all characters from the String that are not numeric or parenthesis or dash.
        for (char c : phonenum.toCharArray()) {
            if (Character.isDigit(c) || c == '(' || c == ')' || c == '-') {
                newtn += c;
            }
        }

        System.out.println(newtn);

        // #2: Check the length
        if (newtn.length() != 13) {
            System.out.println("Error: Invalid length. The telephone number should be 13 characters long.");
            return;
        }

        // #3: Check the format
        if (!(newtn.charAt(0) == '(' && newtn.charAt(4) == ')' && newtn.charAt(8) == '-')) {
            System.out.println("Error: Invalid format. Correct format is (XXX)XXX-XXXX.");
            return;
        }

        // #4: Parse and print components
        String areaCode = newtn.substring(1, 4);
        String exchange = newtn.substring(5, 8);
        String lineNumber = newtn.substring(9);

        System.out.println("Area Code: " + areaCode);
        System.out.println("Exchange: " + exchange);
        System.out.println("Line Number: " + lineNumber);
    }
}
