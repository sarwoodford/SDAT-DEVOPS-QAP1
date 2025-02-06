package Library;

import java.util.List;
import java.util.ArrayList;
public class UserManager {
    private int userID;
    private String userName;
    private List<BookManager> borrowedBooks;

    public UserManager(int userID, String userName, List<BookManager> borrowedBooks){
        this.userID = userID;
        this.userName = userName;
        this.borrowedBooks = new ArrayList<>();
    }

    public int getUserID(){
        return userID;
    }

    public String getUserName(){
        return userName;
    }

    public List<BookManager> getBorrowedBooks(){
        return borrowedBooks;
    }

    public void setUserId(int userID){
        this.userID = userID;
    }

    public void setUserName(String userName){
        this.userName = userName;
    }

    public void setBorrowedBooks(List<BookManager> borrowedBooks){
        this.borrowedBooks = borrowedBooks;
    }

    public int booksBorrowedCount(){
        return borrowedBooks.size();
    }

    public boolean hasBorrowedBooks(BookManager book){
        return borrowedBooks.contains(book);
    }

}
