import java.util.Objects;

public class BookNP {
    public String title;
    public String author;
    public String ISBN;

    public BookNP() {
        this("", "", "");
    }

    public BookNP(String t, String a, String IS) {
        title = t;
        author = a;
        ISBN = IS;
    }

    public BookNP(BookNP b) {
        this(b.title, b.author, b.ISBN);
    }

    public void setTitle(String t) {
        title = t;
    }

    public void setAuthor(String a) {
        author = a;
    }

    public void setISBN(String IS) {
        ISBN = IS;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getISBN() {
        return ISBN;
    }

    @Override
    public String toString() {
        return String.format(
            "Title: %s%n" +
            "Author: %s%n" +
            "ISBN: %s%n",
            title, author, ISBN
        );
    }
}
