import java.util.ArrayList;

public class LibraryNP 
{
    public static void main(String[] args) 
    {
        ArrayList <BookNP> books = new ArrayList <BookNP>();
        BookNP Nineteen = new BookNP("1984", "George Orwell", "9780140817744");
        BookNP Gatsby = new BookNP("The Great Gatsby", "F. Scott Fitzgerlad", "9780198864400");
        BookNP Cookie = new BookNP("If You Give a Mouse a Cookie", "Laura Numeroff", "9780064434096");
        books.add(Nineteen);
        books.add(Gatsby);
        books.add(Cookie);
        
        ArrayList <PatronNP> patrons = new ArrayList <PatronNP>();
        PatronNP Nick = new PatronNP("Nick", "1984");

    }
}
