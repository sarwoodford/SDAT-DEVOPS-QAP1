package Library;

import java.util.List;
public class LibraryInterface {
    private static LibraryManager libraryManager = new LibraryManager();

    public static void main(String [] args){
        
        if (args.length == 0) {
            System.out.println("Please provide a command.");
            displayMenu();
            return;
        }
        if (args[0].equals("help")) {
            displayMenu();
            return;
        }

            String command = args[0];

            switch(command){
                case "addBook":
                    addBook(args);
                    break;
                case "borrowBook":
                    borrowBook(args);
                    break;
                case "returnBook":
                    returnBook(args);
                    break;
                case "searchCatalog":
                    showCatalog();
                    break;
                case "addUser":
                    addUser(args);
                    break;
                case "viewBooksBorrowedByUser":
                    booksBorrowedByUser(args);
                    break;
                default:
                    System.out.println("Invalid option entered. Type 'help' to view all menu options");
                    break;
                
            }
        }

            private static void displayMenu(){
                System.out.println("\nWelcome to the Library Manager!");
                System.out.println("'addBook' - add a new book");
                System.out.println("'borrowBook' - borrow a book from the library with user id");
                System.out.println("'returnBook' - return a book to the library with user id");
                System.out.println("'searchCatalog' - view all books in the library");
                System.out.println("'addUser' - add a user to the library system");
                System.out.println("'viewBooksBorrowedByUser' - view books borrowed by a specific user");
            }

            private static void addBook(String[] args){
                while(true){
                    if (args.length != 4){
                        System.out.println("Usage: addBook <bookID> <bookTitle> <availableCopies>");
                        return;
                    }

                    try{
                        String bookID = args[1];
                        String bookTitle = args[2];
                        int availableCopies = Integer.parseInt(args[3]);

                        BookManager book = new BookManager(bookID, bookTitle, null, null, availableCopies, true);
                        libraryManager.addBook(book);
                        System.out.println("Book: " + bookTitle + ", added successfully!");

                        System.out.println("Books in the library: ");
                        libraryManager.searchCatalog().forEach(b -> System.out.println(b.getBookID() + " " + b.getBookTitle()));

                        break;

                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please retry!");
                    }

                    break;
                }
            }

            private static void borrowBook(String[] args){

                while(true){
                    if (args.length!= 3){
                        System.out.println("Usage: borrowBook <userID> <bookID>");
                        return;
                    }
    
                    try{
                        String userID = args[1];
                        String bookID = args[2];

                        UserManager user = findUser(userID);
                        BookManager book = findBook(bookID);

                        if(user != null && book != null){
                            libraryManager.borrowBook(user, book);
                        } else {
                            System.out.println("user/book not found. Please retry!");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid input for user ID / book ID. format: U<id#> / B<id#> Please retry!");
                    }

                    break;
                }
            }

            private static void returnBook(String[] args){

                while(true){
                    if(args.length != 3){
                        System.out.println("Usage: returnBook <userID> <bookID>");
                        return;
                    } 
    
                    try{
                        String userID = args[1];
                        String bookID = args[2];
    
                        UserManager user = findUser(userID);
                        BookManager book = findBook(bookID);
    
                        if(user != null && book != null){
                            libraryManager.returnBook(user, book);
                            System.out.println("Book Returned Successfully!");
            
                        } else {
                            System.out.println("user/book not found. Please retry!");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid input for user ID / book ID. format: U<id#> / B<id#> Please retry!");
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
                    try{
                        String userID = args[1];
                        String userName = args[2];
        
                        UserManager user = new UserManager(userID, userName, null);
                        libraryManager.addUser(user);
                        System.out.println("User added successfully!");


                        System.out.println("Users in the library: ");
                        libraryManager.getUsers().forEach(u -> System.out.println(u.getUserID() + " " + u.getUserName()));



                        break;
                    } catch(NumberFormatException e){
                        System.out.println("Invalid user ID entered. format: U<id#>");
                    }
                    break;
                }
            }


            private static void booksBorrowedByUser(String[] args){
                while(true){
                    if(args.length != 2){
                        System.out.println("Usage: booksBorrowedByUser <userID>");
                        return;
                    }

                    try{
                        String userID = args[1];

                        UserManager user = findUser(userID);

                        if( user != null){
                            System.out.println("books borrowed by user" + userID + ": ");
                            user.getBorrowedBooks().forEach(
                                book -> System.out.println(book.getBookTitle())
                            );
                        } else {
                            System.out.println("user not found.");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid user ID entered. format: U<id#>");
                    }
                    break;
                }

            }


        // private static BookManager findBook(String bookID){
        //     return libraryManager.searchCatalog().stream().filter(
        //         book -> book.getBookID().equals(bookID)
        //     ).findFirst().orElse(null);
        // }

        private static BookManager findBook(String bookID) {
            System.out.println("Looking for book with ID: " + bookID); // Debugging statement
            BookManager book = libraryManager.searchCatalog().stream().filter(
                b -> b.getBookID().trim().toLowerCase().equals(bookID.trim().toLowerCase())
            ).findFirst().orElse(null);
            if (book == null) {
                System.out.println("Book not found!");
            }
            return book;
        }

        // private static UserManager findUser(String userID){
        //     return libraryManager.getUsers().stream().filter(
        //         user -> user.getUserID().equals(userID)
        //     ).findFirst().orElse(null);
        // }


        private static UserManager findUser(String userID) {
            System.out.println("Looking for user with ID: " + userID); // Debugging statement
            UserManager user = libraryManager.getUsers().stream().filter(
                u -> u.getUserID().trim().toLowerCase().equals(userID.trim().toLowerCase())
            ).findFirst().orElse(null);
            if (user == null) {
                System.out.println("User not found!");
            }
            return user;
        }
        

}
