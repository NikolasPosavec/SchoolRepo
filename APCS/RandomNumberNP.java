package APCS;
import java.util.ArrayList;

public class RandomNumberNP 
{
    public static void main(String[] args) 
    {
        ArrayList <Integer> list = new <Integer> ArrayList();
        int limit = 20;
        int total = 0;
        double avg = 0;

        for(int i = 0; i <= limit; i++)
        {
            int x = (int)(Math.random()*100)+1;
            list.add(x);
            //Integer xobj = new Integer(x); <- Old Way
            //list.add(xobj); <- Old way
        }

        System.out.println("List of randomly generated numbers: ");

        for(int x: list)
        {
            System.out.println(x);
            total += x;
        }
        /*for(int i = 0; i < list.size(); i++) <- Old for loop
        {
            //int y = (Integer)list.get(i); <-Old way
            int y = list.get(i);
            System.out.println(list.get(i));
            total += y;
        }*/
        
        avg = (double)total/list.size();
        System.out.println("The average of " + limit + " randomly generated numbers is: "+ avg);
    }
}

