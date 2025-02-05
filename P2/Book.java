/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The Book class represents a media item of type "Book" and extends the Media class.
 * It includes specific details such as the title, author, and publisher.
 */
public class Book extends Media{

    // Fields for storing book-specific details
    private final String title, author, publisher;

    /**
     * Constructs a Book object with the specified format, ISBN, genre, author, title, and publisher.
     *
     * @param format    the format of the book (e.g., Hardcover, Paperback, Digital).
     * @param isbn      the unique ISBN identifier for the book.
     * @param genre     the genre of the book.
     * @param author    the author of the book.
     * @param title     the title of the book.
     * @param publisher the publisher of the book.
     */
    public Book(Format format, String isbn, String genre, String author, String title, String publisher){
        super(format, isbn, genre);
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    } 

    /**
     * Gets the title of the book.
     *
     * @return the title of the book.
     */
    public final String getTitle(){
        return this.title;
    }

    /**
     * Gets the author of the book.
     *
     * @return the author of the book.
     */
    public final String getAuthor(){
        return this.author;
    }

    /**
     * Gets the publisher of the book.
     *
     * @return the publisher of the book.
     */
    public final String getPublisher(){
        return this.publisher;
    }

    /**
     * Returns the type of this media item as "Book."
     *
     * @return a string representing the type, which is "Book."
     */
    @Override
    public String getType(){
        return "Book";
    }

    /**
     * Returns a string representation of the book, including the title, author, 
     * and a summary from the superclass's toString method.
     *
     * @return a string describing the book's title, author, and other details.
     */
    @Override
    public String toString(){
        return "Title: " + ", Author: " + ", " + super.toString();
    }

   /**
     * Compares this book with another media item. Comparison is based on the author 
     * (alphabetically), and if the authors are the same, on the title.
     *
     * @param o the other Media object to compare with.
     * @return a negative integer, zero, or a positive integer as this book is less than, 
     *         equal to, or greater than the specified Media object.
     */
    @Override
    public int compareTo(Media o){
        Book otherBook = (Book) o; // Cast the other Media object to a Book type

        // First compare authors alphabetically
        if (this.author.compareTo(otherBook.author) != 0){
            return this.author.compareTo(otherBook.author); // Return result if authors differ
        } else {
            // If authors are the same, compare by title
            return this.title.compareTo(otherBook.title);
        }
    }
}
