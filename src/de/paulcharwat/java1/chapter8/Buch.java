package de.paulcharwat.java1.chapter8;

public class Buch {

    private final String autor;
    private final String titel;
    private final long isbn13;
    private final boolean hardcover;
    private boolean available;
    private int shelfNumber;
    private static int numberOfBooks;

    /**
     * Getter for numberOfBooks.
     * 
     * @return int
     */
    public static int getNumberOfBooks() {
        return numberOfBooks;
    }

    /**
     * Getter for autor.
     * 
     * @return String
     */
    public String getAutor() {
        return autor;
    }

    /**
     * Getter fot titel.
     * 
     * @return String
     */
    public String getTitel() {
        return titel;
    }

    /**
     * Getter for isbn13.
     * 
     * @return long
     */
    public long getIsbn13() {
        return isbn13;
    }

    /**
     * Getter for hardcover.
     * 
     * @return boolean
     */
    public boolean isHardcover() {
        return hardcover;
    }

    /**
     * Getter for available.
     * 
     * @return boolean
     */
    public boolean isAvailable() {
        return available;
    }

    /**
     * Setter for available.
     * 
     * @param available
     */
    public void setAvailable(boolean available) {
        this.available = available;
    }

    /**
     * Getter for shelfNumber.
     * 
     * @return int
     */
    public int getShelfNumber() {
        return shelfNumber;
    }

    /**
     * Setter for shelfNumber.
     * 
     * @param shelfNumber
     */
    public void setShelfNumber(int shelfNumber) {
        this.shelfNumber = shelfNumber;
    }

    public Buch(String autor, String titel, long isbn13, boolean hardcover) {
        this.autor = autor;
        this.titel = titel;
        this.isbn13 = isbn13;
        this.hardcover = hardcover;
        numberOfBooks++;
    }
}
