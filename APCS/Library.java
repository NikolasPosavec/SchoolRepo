import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Library 
{
    private ArrayList<BookNP> books;
    private ArrayList<PatronNP> patrons;

    public Library() 
    {
        books = new ArrayList<>();
        patrons = new ArrayList<>();
    }

    public void loadBooksFromFile(String filename) 
    {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 3) {
                    books.add(new BookNP(parts[0].trim(), parts[1].trim(), parts[2].trim()));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Books file not found.");
        }
    }

    public void loadPatronsFromFile(String filename) 
    {
        try (Scanner scanner = new Scanner(new File(filename))) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                patrons.add(new PatronNP(line.trim(), new ArrayList<BookNP>()));
            }
        } catch (FileNotFoundException e) {
            System.out.println("Patrons file not found.");
        }
    }

    public void displayBooks() 
    {
        System.out.println("Books in the Library:");
        for (BookNP book : books) {
            System.out.println(book);
        }
    }

    public void displayPatrons() 
    {
        System.out.println("Patrons:");
        for (PatronNP patron : patrons) {
            System.out.println(patron);
        }
    }

    public void addBook(String title, String author, String ISBN) 
    {
        books.add(new BookNP(title, author, ISBN));
    }

    public void addPatron(String name) 
    {
        patrons.add(new PatronNP(name, new ArrayList<BookNP>()));
    }

    public void checkoutBook(String patronName, String bookTitle) 
    {
        for (PatronNP patron : patrons) {
            if (patron.getName().equalsIgnoreCase(patronName)) {
                for (BookNP book : books) {
                    if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                        patron.borrowBook(book);
                        System.out.println("Book checked out successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Patron or book not found.");
    }

    public void returnBook(String patronName, String bookTitle) 
    {
        for (PatronNP patron : patrons) {
            if (patron.getName().equalsIgnoreCase(patronName)) {
                for (BookNP book : patron.getBorrowedBooks()) {
                    if (book.getTitle().equalsIgnoreCase(bookTitle)) {
                        patron.returnBook(book);
                        System.out.println("Book returned successfully.");
                        return;
                    }
                }
            }
        }
        System.out.println("Patron or book not found.");
    }

    public static void main(String[] args) 
    {
        Library library = new Library();
        String booksFilePath = "/home/bolt/nikolas/SchoolRepo-main/APCS/books.txt"; 
        String patronsFilePath = "/home/bolt/nikolas/SchoolRepo-main/APCS/patrons.txt"; 
        
        library.loadBooksFromFile(booksFilePath);
        library.loadPatronsFromFile(patronsFilePath);

        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("Menu:\n1. View Books\n2. View Patrons\n3. Add Book\n4. Add Patron\n5. Checkout Book\n6. Return Book\n7. Exit");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    library.displayBooks();
                    break;
                case 2:
                    library.displayPatrons();
                    break;
                case 3:
                    System.out.println("Enter title, author, ISBN:");
                    String title = scanner.nextLine();
                    String author = scanner.nextLine();
                    String isbn = scanner.nextLine();
                    library.addBook(title, author, isbn);
                    break;
                case 4:
                    System.out.println("Enter patron name:");
                    String patronName = scanner.nextLine();
                    library.addPatron(patronName);
                    break;
                case 5:
                    System.out.println("Enter patron name and book title:");
                    String patronForCheckout = scanner.nextLine();
                    String bookForCheckout = scanner.nextLine();
                    library.checkoutBook(patronForCheckout, bookForCheckout);
                    break;
                case 6:
                    System.out.println("Enter patron name and book title:");
                    String patronForReturn = scanner.nextLine();
                    String bookForReturn = scanner.nextLine();
                    library.returnBook(patronForReturn, bookForReturn);
                    break;
                case 7:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
