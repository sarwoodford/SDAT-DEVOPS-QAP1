package Library;


public class LibraryInterface {
    private static LibraryManager libraryManager = new LibraryManager();

    public static void main(String [] args){

        // initializeUsers();
        // initializeBooks();
        
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

            }

            private static void borrowBook(String[] args){

            }

            private static void returnBook(String[] args){

            }

            private static void searchCatalog(String[] args){

            }

            private static void addUser(String[] args){

            }

            private static void booksBorrowedByUser(String[] args){


        }

}
