
public class recursion_practice
{
    public int fact(int n)
    {
        if(n == 1)
        {
            return 1;
        }
        else
        {
            return n * fact(n-1);
        }
    }
    public static void main(String[] args)
    {
        recursion_practice r = new recursion_practice();
        System.out.println(r.fact(20));
    }
}
