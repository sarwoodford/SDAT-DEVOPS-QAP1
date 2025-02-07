package Library;

import java.util.List;
import java.util.ArrayList;
import java.util.stream.Collectors;
public class LibraryManager{
    private List<BookManager> books = new ArrayList<>();
    private List<UserManager> users = new ArrayList<>();

    public LibraryManager(){
        this.books = new ArrayList<>();
        this.users = new ArrayList<>();
    }

    public void addBook(BookManager book){
        books.add(book);
    }

    public boolean borrowBook(UserManager user, BookManager book){
        if(book.getIsAvailable() && user.booksBorrowedCount() < 3){
            user.getBorrowedBooks().add(book);
            book.setIsAvailable(false);
            return true;
        }

        System.out.println("The selected book is unavailable, or you have reached your borrowing limit (3).");
        return false;
    }

    public boolean returnBook(UserManager user, BookManager book){
        if(user.getBorrowedBooks().contains(book)){
            user.getBorrowedBooks().remove(book);
            book.setIsAvailable(true);
            return true;
        }

        System.out.println("The entered book has not been borrowed by you.");
        return false;
    }

    public List<BookManager> searchBookTitle(String bookTitle){
        return books.stream().filter(
            book -> book.getBookTitle().toLowerCase().contains(bookTitle.toLowerCase())).collect(Collectors.toList()
            );
    }

    public void addUser(UserManager user){
        if (!users.contains(user)){
            users.add(user);
        } else {
            System.out.println("A user with these credentials already exists!");
        }
    }

    public List<BookManager> searchCatalog(){
        return new ArrayList<>(books);
    }

    public List<UserManager> getUsers(){
        return users;
    }
}