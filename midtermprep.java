public class midtermprep {
    public static void main(String[] args) {
        int dice = 0;
        int count = 0;
        while(dice>4 || dice<4){
            dice=(int)(Math.random()*6)+1;
            count++;
        }
            System.out.println(count);
    }
}
        

        
