package LibrarySystem.src.test.java.Library;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import LibrarySystem.src.main.java.Library.LibraryManager;
import LibrarySystem.src.main.java.Library.BookManager;
import LibrarySystem.src.main.java.Library.UserManager;

public class LibraryTests {

    @Test
    public void testAddingABook() {
        LibraryManager libraryManager = new LibraryManager();
        BookManager book1 = new BookManager("B1", "Harry Potter", null, null, 3, true);
        BookManager book2 = new BookManager("B2", "Hunger Games", null, null, 1, true);
        libraryManager.addBook(book1);
        libraryManager.addBook(book2);

        Assertions.assertTrue(libraryManager.searchCatalog().size() == 2, "size should be 2");

    }

    @Test
    public void returnABookYouDidntBorrow() {
        LibraryManager libraryManager = new LibraryManager();
        BookManager book1 = new BookManager("B1", "Harry Potter", null, null, 3, true);
        UserManager user1 = new UserManager("U1", "John Doe", null);

        libraryManager.addBook(book1);
        libraryManager.addUser(user1);

        boolean result = libraryManager.returnBook(user1, book1);

        Assertions.assertFalse(result, "you cant return a book you didnt borrow");

    }

    @Test
    public void testUserBorrowingLimit() {
        LibraryManager libraryManager = new LibraryManager();
        BookManager book1 = new BookManager("B1", "Harry Potter", null, null, 3, true);
        BookManager book2 = new BookManager("B2", "Hunger Games", null, null, 3, true);
        BookManager book3 = new BookManager("B3", "Bible", null, null, 3, true);
        BookManager book4 = new BookManager("B4", "Dictionary", null, null, 3, true);

        libraryManager.addBook(book1);
        libraryManager.addBook(book2);
        libraryManager.addBook(book3);
        libraryManager.addBook(book4);

        UserManager user1 = new UserManager("U1", "John Doe", null);

        libraryManager.addUser(user1);

        boolean result1 = libraryManager.borrowBook(user1, book1);
        boolean result2 = libraryManager.borrowBook(user1, book2);
        boolean result3 = libraryManager.borrowBook(user1, book3);
        boolean result4 = libraryManager.borrowBook(user1, book4);

        Assertions.assertTrue(result1, "User can borrow one book");
        Assertions.assertTrue(result2, "User can borrow two books");
        Assertions.assertTrue(result3, "User can borrow three books");
        Assertions.assertFalse(result4, "User cant borrow four books");

        Assertions.assertEquals(3, user1.booksBorrowedCount(), "User should have borrowed exactly 3 books.");

    }
}
