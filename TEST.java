import java.util.Scanner;


public class TEST {
    public static void main(String[] args){
        boolean answer = findPair(4,12,4);
    }
    public static boolean findPair(int first, int second, int third) {
        boolean answer = true;
        if(first==second || first==third || second==third){
            answer = true;
            if(first==second || first==third){
                System.out.println(first);
            }else{
                System.out.println(second);
            return;

        }
        
    }

    
}
