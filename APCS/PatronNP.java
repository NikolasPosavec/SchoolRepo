import java.util.ArrayList;

public class PatronNP {
    public String name;
    ArrayList<BookNP> books = new ArrayList<BookNP>();

    public PatronNP() {
        this("", new ArrayList<BookNP>());
    }

    public PatronNP(String n, ArrayList<BookNP> b) {
        name = n;
        books = b;
    }

    public PatronNP(PatronNP p) {
        this(p.name, new ArrayList<BookNP>(p.books));
    }

    public void setName(String n) {
        name = n;
    }

    public String getName() {
        return name;
    }

    public void setBooks(ArrayList<BookNP> b) {
        books = b;
    }

    public ArrayList<BookNP> getBooks() {
        return books;
    }

    public void addBook(BookNP book) {
        books.add(book);
    }

    public void returnBook(BookNP book) {
        books.remove(book);
    }

    @Override
    public String toString() {
        return String.format(
            "Name: %s%n" +
            "Books: %s%n",
            name, books
        );
    }

    public void borrowBook(BookNP book) {
        if (!books.contains(book)) {
            books.add(book);
        }
    }

    public BookNP[] getBorrowedBooks() {
        return books.toArray(new BookNP[0]);
    }
}
