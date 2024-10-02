public class NameStringRearrangeNP
{
    public static void main(String[] args) 
    {
        String name = "Posavec, Nikolas Stjepan";
        int pos = name.indexOf(',');
        int space2 = name.indexOf(" ", pos+2);
        
        String lastname = name.substring(0, pos);
        String firstname = name.substring(pos + 2, space2);
        String middlename = name.substring(space2 + 1);
        String minitial = middlename.substring(0,1);

        System.out.println(firstname + " " + minitial + ", " + lastname);
    }
}
