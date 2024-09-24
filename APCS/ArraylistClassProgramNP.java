package APCS;
import java.util.*;

public class ArraylistClassProgramNP 
{
    static Scanner sc = new Scanner(System.in);
    static ArrayList<String> Words = new ArrayList<String>();
    static ArrayList<String> NewList = new ArrayList<String>();
    static int num = 3;

    public static void main(String[] args) 
    {
        NewWay();
    }

    public static void NewWay()
    {
        String temp;

        do {
            System.out.println("Type in a word (type negativeone to stop): ");
            temp = sc.nextLine();

            if (!temp.equals("negativeone")) {
                Words.add(temp);
            }

        } while (!temp.equals("negativeone"));

        for (String word : Words)
        {
            if (word.length() == num)
            {
                NewList.add(word);
            }
        }

        while (!NewList.isEmpty())
        {
            System.out.println(NewList.remove(0));
        }
    }
}
