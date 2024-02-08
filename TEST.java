public class TEST {
    public static void main(String[] args) {
        String name = "Posavec, Nikolas";
        String rearrangedName = rearrangeName(name);
        System.out.println(rearrangedName);
    }

    public static String rearrangeName(String name) {
        int commaIndex = name.indexOf(',');
        String lastName = name.substring(0, commaIndex).trim();
        String firstName = name.substring(commaIndex + 2).trim(); // +2 to skip comma and space

        // Extracting middle initial (assuming there's only one middle name)
        char middleInitial = firstName.charAt(firstName.indexOf(' ') + 1);

        // Rearranging name with middle initial in the middle
        firstName = firstName.substring(0, firstName.indexOf(' ')); // Extracting first name
        String rearrangedName = firstName + " " + middleInitial + ". " + lastName;
        
        return rearrangedName;
    }
}
