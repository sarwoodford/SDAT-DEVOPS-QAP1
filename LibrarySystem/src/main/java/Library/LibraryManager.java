package LibrarySystem.src.main.java.Library;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class LibraryManager {
    /**
     * initializing ArrayLists for books and users, which are managed
     * in this class
     */
    private List<BookManager> books = new ArrayList<>();
    private List<UserManager> users = new ArrayList<>();

    public LibraryManager() {
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    /**
     * adding a book to the books list
     * 
     * @param book
     */
    public void addBook(BookManager book) {
        books.add(book);
    }

    /**
     * borrowing a book from the system, verifying that the user
     * and book id's are valid and that the user has not exceeded
     * their borrowing limit (3)
     * 
     * @param user
     * @param book
     * @return boolean
     */
    public boolean borrowBook(UserManager user, BookManager book) {
        if (!book.getIsAvailable()) {
            System.out.println("Book is unavailable.");
            return false;
        }
        if (user.booksBorrowedCount() >= 3) {
            System.out.println("User has reached the borrowing limit.");
            return false;
        }

        user.getBorrowedBooks().add(book);
        book.setIsAvailable(false);
        return true;
    }

    /**
     * method to return a borrowed book, verifying that the user has
     * borrowed the specified book
     * 
     * @param user
     * @param book
     * @return boolean
     */
    public boolean returnBook(UserManager user, BookManager book) {
        if (user.getBorrowedBooks().contains(book)) {
            user.getBorrowedBooks().remove(book);
            book.setIsAvailable(true);
            return true;
        }

        System.out.println("The entered book has not been borrowed by you.");
        return false;
    }

    /**
     * method to search for a specific book by its title
     * 
     * @param bookTitle
     * @return books
     */
    public List<BookManager> searchBookTitle(String bookTitle) {
        return books.stream().filter(
                book -> book.getBookTitle().toLowerCase().contains(bookTitle.toLowerCase()))
                .collect(Collectors.toList());
    }

    /**
     * adding a user to the system, verifying that the user
     * has unique credentials
     * 
     * @param user
     */
    public void addUser(UserManager user) {
        if (!users.contains(user)) {
            users.add(user);
        } else {
            System.out.println("A user with these credentials already exists!");
        }
    }

    /**
     * List of all books to display the catalog in
     * LibraryInterface
     * 
     * @return ArrayList<>(books)
     */
    public List<BookManager> searchCatalog() {
        return new ArrayList<>(books);
    }

    /**
     * List of all users in the system
     * 
     * @return users
     */
    public List<UserManager> getUsers() {
        return users;
    }
}