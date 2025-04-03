package APCS;

public class test 
{
    private int n;

    public test()
    {
        n = 0;
    }
    public static int hailstoneLength(int n) {
        if (n == 1) {
            return 1; 
        } else if (n % 2 == 0) {
            return 1 + hailstoneLength(n / 2);
        } else { 
            return 1 + hailstoneLength(3 * n + 1); 
        }
    }

    public static void main(String[] args) 
    {
        test t = new test();
        System.out.println(t.hailstoneLength(8)); // 4
        System.out.println(t.hailstoneLength(1)); // 1
        System.out.println(t.hailstoneLength(2)); // 2
        System.out.println(t.hailstoneLength(3)); // 8
        System.out.println(t.hailstoneLength(4)); // 3
        System.out.println(t.hailstoneLength(5)); // 6
        System.out.println(t.hailstoneLength(6)); // 9
    }
}
