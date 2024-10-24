import java.util.ArrayList;

public class PatronNP 
{
    public String name;
    ArrayList <String> books = new ArrayList<String>();

    public PatronNP()
    {
        this("", new ArrayList<String>());
    }
    public PatronNP(String n, ArrayList<String> b)
    {
        name = n;
        books = b;
    }
    public PatronNP(PatronNP p)
    {
        this(p.name, p.books);
    }

    public void setName(String n)
    {
        name = n;
    }
    public String getName()
    {
        return name;
    }
    public void setBooks(ArrayList<String> b)
    {
        books = b;
    }
    public ArrayList<String> getBooks()
    {
        return books;
    }

    @Override
    public String toString()
    {
        return String.format(
            "Name: %s%n" +
            "Books: %s%n",
            name, books
        );
    }
}
