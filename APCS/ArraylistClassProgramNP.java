package APCS;
import java.util.*;

public class ArraylistClassProgramNP 
{
    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);

        System.out.println("Do you want to use raw array lists (type 1) or generic array lists (type 2)?");
        int control = sc.nextInt();

        switch(control)
        {
            case 1:
            String temp;
            int numOfStrings = 0;
            do{
                System.out.println("Type in a word (type negativeone to stop): ");
                temp = sc.nextLine();

            }while(temp != "negativeone");

            for(int i = 0; i <= numOfStrings; i++)
            {
                if(temp != "negativeone")
                {

                }
            }
            break;
            case 2:

            break;
        }
    }

    public static void OldWay()
    {
        ArrayList list = new ArrayList();
        String word;
        int count;

        for(int i = 0; i < list.size(); i++)
        {
            word = (String)list.get(i);
            
            if(word.length() == num)
            {
                count++;
            }
        }
    }
}
