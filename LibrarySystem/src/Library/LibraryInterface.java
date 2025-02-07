package LibrarySystem.src.Library;

import java.util.List;
import java.util.Scanner;
public class LibraryInterface {
    private static LibraryManager libraryManager = new LibraryManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String [] args){

        while(true){
            System.out.println("\nWelcome to the Library Manager!");
                System.out.println("1. addBook - add a new book");
                System.out.println("2. borrowBook - borrow a book from the library with user id");
                System.out.println("3. returnBook - return a book to the library with user id");
                System.out.println("4. searchCatalog - view all books in the library");
                System.out.println("5. addUser - add a user to the library system");
                System.out.println("6. viewBooksBorrowedByUser - view books borrowed by a specific user");
                System.out.println("7. exit menu");
                System.out.println("Enter your choice: ");

                int choice = scanner.nextInt();
                scanner.nextLine();

                switch(choice){
                    case 1:
                        addBook(args);
                        break;
                    case 2:
                        borrowBook(args);
                        break;
                    case 3:
                        returnBook(args);
                        break;
                    case 4:
                        showCatalog();
                        break;
                    case 5:
                        addUser(args);
                        break;
                    case 6:
                        booksBorrowedByUser(args);
                        break;
                    default:
                        System.out.println("Invalid option entered. Type 'help' to view all menu options");
                        break;
                    
                }
            }
        }

            private static void addBook(String[] args){
                while(true){

                    System.out.print("Enter book ID: ");
                    String bookID = scanner.nextLine();
                    System.out.print("Enter book title: ");
                    String bookTitle = scanner.nextLine();
                    System.out.print("Enter number of available copies: ");
                    int availableCopies = scanner.nextInt();
                    scanner.nextLine(); 

            
                    BookManager book = new BookManager(bookID, bookTitle, null, null, availableCopies, true);
                    libraryManager.addBook(book);
                    System.out.println("Book added successfully!");


                break;
                }
            }

            private static void borrowBook(String[] args){

                while(true){

                    System.out.print("Enter user ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookID = scanner.nextLine();
            
                    UserManager user = findUser(userID);
                    BookManager book = findBook(bookID);
            
                    if (user != null && book != null) {
                        if (libraryManager.borrowBook(user, book)) {
                            System.out.println("Book borrowed successfully!");
                        }
                    } else {
                        System.out.println("User or book not found.");
                    }

                break;
                }
            }

            private static void returnBook(String[] args){

                while(true){
                    System.out.print("Enter user ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter book ID: ");
                    String bookID = scanner.nextLine();
            
                    UserManager user = findUser(userID);
                    BookManager book = findBook(bookID);
            
                    if (user != null && book != null) {
                        if (libraryManager.returnBook(user, book)) {
                            System.out.println("Book returned successfully!");
                        }
                    } else {
                        System.out.println("User or book not found.");
                    }

                break;
                }
            }

            public static void showCatalog(){
                List<BookManager> books = libraryManager.searchCatalog();

                if(books.isEmpty()){
                    System.out.println("no books to show!");
                } else{
                    books.forEach(
                        book -> System.out.println(book.getBookTitle())
                    );
                }
            }


            private static void addUser(String[] args){
                while(true){

                    System.out.print("Enter user ID: ");
                    String userID = scanner.nextLine();
                    System.out.print("Enter user name: ");
                    String userName = scanner.nextLine();

                    UserManager user = new UserManager(userID, userName, null);
                    libraryManager.addUser(user);
                    System.out.println("User added successfully!");

                break;
                }
            }


            private static void booksBorrowedByUser(String[] args){
                while(true){

                    System.out.print("Enter user ID: ");
                    String userID = scanner.nextLine();
            
                    UserManager user = findUser(userID);
                    if (user != null) {
                        List<BookManager> borrowedBooks = user.getBorrowedBooks();
                        if (borrowedBooks.isEmpty()) {
                            System.out.println("No books borrowed by this user.");
                        } else {
                            System.out.println("Books borrowed by user " + userID + ":");
                            borrowedBooks.forEach(book -> System.out.println(book.getBookID() + " - " + book.getBookTitle()));
                        }
                    } else {
                        System.out.println("User not found.");
                    }
                }

            }



        private static BookManager findBook(String bookID) {
            System.out.println("Looking for book with ID: " + bookID);
            
            
            BookManager book = libraryManager.searchCatalog().stream()
                .filter(b -> b.getBookID().trim().equalsIgnoreCase(bookID.trim()))
                .findFirst()
                .orElse(null);
            
            if (book == null) {
                System.out.println("Book not found!");
            }
            return book;
        }



        private static UserManager findUser(String userID) {
            System.out.println("Looking for user with ID: " + userID); 
            UserManager user = libraryManager.getUsers().stream().filter(
                u -> u.getUserID().trim().toLowerCase().equals(userID.trim().toLowerCase())
            ).findFirst().orElse(null);
            if (user == null) {
                System.out.println("User not found!");
            }
            return user;
        }
        

}
