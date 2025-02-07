package LibrarySystem.src.main.java.Library;

import java.util.Date;

public class BookManager {
    private String bookID;
    private String bookTitle;
    private Date borrowDate;
    private Date returnDate;
    private int availableCopies;
    private boolean isAvailable;

    /**
     * constuctor for BookManager
     * 
     * @param bookID
     * @param bookTitle
     * @param borrowDate
     * @param returnDate
     * @param availableCopies
     * @param isAvailable
     */
    public BookManager(String bookID, String bookTitle, Date borrowDate, Date returnDate, int availableCopies,
            boolean isAvailable) {
        this.bookID = bookID;
        this.bookTitle = bookTitle;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        this.availableCopies = availableCopies;
        this.isAvailable = true;
    }

    /**
     * get bookID
     * 
     * @return bookID
     */
    public String getBookID() {
        return bookID;
    }

    /**
     * get book title
     * 
     * @return bookTitle
     */
    public String getBookTitle() {
        return bookTitle;
    }

    /**
     * get borrow date
     * 
     * @return borrowDate
     */
    public Date getBorrowDate() {
        return borrowDate;
    }

    /**
     * get return date
     * 
     * @return return date
     */
    public Date getReturnDate() {
        return returnDate;
    }

    /**
     * get available copies
     * 
     * @return availableCopies
     */
    public int getAvailableCopies() {
        return availableCopies;
    }

    /**
     * get is available (availability status)
     * 
     * @return isAvailable
     */
    public boolean getIsAvailable() {
        return isAvailable;
    }

    /**
     * set book ID
     * 
     * @param bookID
     */
    public void setBookID(String bookID) {
        this.bookID = bookID;
    }

    /**
     * set book title
     * 
     * @param bookTitle
     */
    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    /**
     * set borrow date
     * 
     * @param borrowDate
     */
    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    /**
     * set return date
     * 
     * @param returnDate
     */
    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    /**
     * set available copies
     * 
     * @param availableCopies
     */
    public void setAvailableCopies(int availableCopies) {
        this.availableCopies = availableCopies;
    }

    /**
     * set is available (availability status)
     * 
     * @param isAvailable
     */
    public void setIsAvailable(boolean isAvailable) {
        this.isAvailable = isAvailable;
    }
}
