package LibrarySystem.src.main.java.Library;

import java.util.List;
import java.util.ArrayList;

public class UserManager {
    private String userID;
    private String userName;
    private List<BookManager> borrowedBooks;

    /**
     * UserManager constructor
     * 
     * @param userID
     * @param userName
     * @param borrowedBooks
     */
    public UserManager(String userID, String userName, List<BookManager> borrowedBooks) {
        this.userID = userID;
        this.userName = userName;
        this.borrowedBooks = new ArrayList<>();
    }

    /**
     * get user id
     * 
     * @return userID
     */
    public String getUserID() {
        return userID;
    }

    /**
     * get user name
     * 
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * list of books borrowed by users
     * 
     * @return borrowedBooks
     */
    public List<BookManager> getBorrowedBooks() {
        return borrowedBooks;
    }

    /**
     * set user ID
     * 
     * @param userID
     */
    public void setUserId(String userID) {
        this.userID = userID;
    }

    /**
     * set user name
     * 
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
    }

    /**
     * set books borrowed by user
     * 
     * @param borrowedBooks
     */
    public void setBorrowedBooks(List<BookManager> borrowedBooks) {
        this.borrowedBooks = borrowedBooks;
    }

    /**
     * method to track books borrowed by user to verify they
     * dont exceed their borrowing limit (3)
     * 
     * @return
     */
    public int booksBorrowedCount() {
        return borrowedBooks.size();
    }

    /**
     * checks if user has borrowed a specifc book
     * 
     * @param book
     * @return boolean
     */
    public boolean hasBorrowedBooks(BookManager book) {
        return borrowedBooks.contains(book);
    }

}
