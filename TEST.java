import java.util.Arrays;
import java.util.Scanner;

public class TEST{
    public static void main(String[] args) {
        EasyReader console = new EasyReader();
        System.out.println("How many names?");
        int num = console.readInt();
        Scanner sc = new Scanner(System.in);
        String [] names = new String [num];
        int [] ages = new int [num];

        for( int i=0 ; i<num; i++){
            System.out.println("What is name # " + (i+1) + "?");
            names [i] = sc.next();
            System.out.println("What is age # " + (i+1) + "?");
            ages [i] = sc.nextInt();
        }
        
        System.out.println("Name\tAge");System.out.println("Name" + Arrays.toString(names) + "\tAge" + Arrays.toString(ages));
     
}
}