import java.util.Arrays;
public class TestCodeNP {
    public static void main(String[] args) {
        char[] list = {'a', 'A', 'b', 'B', 'c', 'C', 'd', 'D', '0', '9'};
        int[] numbers = new int[10];
        char[] uppercase = new char[10];
        char[] lowercase = new char[10];
        int numcounter = 0;
        int lowcounter = 0;
        int upcounter = 0;

        for (int i = 0; i < list.length; i++) {
            char value = list[i];
            if (value >= 'A' && value <= 'Z') {
                uppercase[upcounter++] = value;
            } else if (value >= 'a' && value <= 'z') {
                lowercase[lowcounter++] = value;
            } else if (value >= '0' && value <= '9') {
                numbers[numcounter++] = value;
            }
        }

        uppercase = Arrays.copyOf(uppercase, upcounter);
        lowercase = Arrays.copyOf(lowercase, lowcounter);
        numbers = Arrays.copyOf(numbers, numcounter);

        System.out.println("Uppercase Letters: " + Arrays.toString(uppercase));
        System.out.println("Lowercase Letters: " + Arrays.toString(lowercase));
        System.out.println("Numbers: " + Arrays.toString(numbers));
    }
}

