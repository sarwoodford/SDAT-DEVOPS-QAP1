package Library;

import java.util.Scanner;

public class LibraryInterface {
    private static LibraryManager libraryManager = new LibraryManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args){

        initializeUsers();
        initializeBooks();


        }

    private static void initializeUsers(){
        UserManager user1 = new UserManager("U1", "John Doe", null);
        libraryManager.addUser(user1);
        UserManager user2 = new UserManager("U2", "Jane Smith", null);
        libraryManager.addUser(user2);
    }

    private static void initializeBooks(){
        BookManager book1 = new BookManager("B1", "Hunger Games", null, null, 2, true);
        libraryManager.addBook(book1);
        BookManager book2 = new BookManager("B2", "Harry Potter", null, null, 1, true);
        libraryManager.addBook(book2);
        BookManager book3 = new BookManager("B3", "Unavailable Book", null, null, 0, false);
        libraryManager.addBook(book3);
    }


}
