package LibrarySystem.src.main.java.Library;

import java.util.Date;

public class BookManager {
    private String bookID;
    private String bookTitle;
    private Date borrowDate;
    private Date returnDate;
    private int availableCopies;
    private boolean isAvailable;

    public BookManager(String bookID, String bookTitle, Date borrowDate, Date returnDate, int availableCopies, boolean isAvailable){
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.availableCopies = availableCopies;
        this.isAvailable = true;
    }

    public String getBookID(){
        return bookID;
    }

    public String getBookTitle(){
        return bookTitle;
    }

    public Date getBorrowDate(){
        return borrowDate;
    }

    public Date getReturnDate(){
        return returnDate;
    }

    public int getAvailableCopies(){
        return availableCopies;
    }

    public boolean getIsAvailable(){
        return isAvailable;
    }

    public void setBookID(String bookID){
        this.bookID = bookID;
    }

    public void setBookTitle(String bookTitle){
        this.bookTitle = bookTitle;
    }

    public void setBorrowDate(Date borrowDate){
        this.borrowDate = borrowDate;
    }

    public void setReturnDate(Date returnDate){
        this.returnDate = returnDate;
    }

    public void setAvailableCopies(int availableCopies){
        this.availableCopies = availableCopies;
    }

    public void setIsAvailable(boolean isAvailable){
        this.isAvailable = isAvailable;
    }
}


