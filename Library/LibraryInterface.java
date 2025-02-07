package Library;

import java.util.List;
public class LibraryInterface {
    private static LibraryManager libraryManager = new LibraryManager();
    private static List<BookManager> books;
    private static List<UserManager> users;

    public static void main(String [] args){
        
            System.out.println("Please enter desired menu option:");
            displayMenu();
            

            if(args[0].equals("help")){
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
                    searchCatalog(args);
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
                        System.out.println("Invalid input for user ID / book ID. Please retry!");
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
                        } else {
                            System.out.println("user/book not found. Please retry!");
                        }
                    } catch (NumberFormatException e){
                        System.out.println("Invalid input for user ID / book ID. Please retry!");
                    }
                }
            }

            private static void searchCatalog(String[] args){

            }

            private static void addUser(String[] args){

            }

            private static void booksBorrowedByUser(String[] args){


        }

        public static List<BookManager> getBooks(){
            return books;
        }

        private static BookManager findBook(String bookID){
            return books.stream().filter(
                book -> book.getBookID() == bookID
            ).findFirst().orElse(null);
        }

        public static List<UserManager> getUsers(){
                    return users;
                }

                private static UserManager findUser(String userID){
                    return getUsers().stream().filter(
                user -> user.getUserID() == userID
            ).findFirst().orElse(null);
        }

        

}
