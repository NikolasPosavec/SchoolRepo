public class NameStringRearrangeNP {
    public static void main(String[] args) {
        String name = "Posavec, Nikolas Stjepan";

        int pos = name.indexOf(',');

        String lastname = name.substring(0, pos);
        String firstname = name.substring(pos + 2, name.indexOf(' ', pos + 2));
        String middlename = name.substring(name.indexOf(' ', pos + 2) + 1);

        System.out.println(firstname + " " + middlename + ", " + lastname);
    }
}

    

