/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The Media class is an abstract base class representing a general media item.
 * It provides fields for common attributes such as ISBN, genre, and format, and defines
 * abstract methods that subclasses must implement. The class also includes methods
 * for comparison, equality checking, and string representation.
 */
public abstract class Media implements Comparable<Media> {

    // Fields for storing media-specific details
    private final String isbn;     // The ISBN identifier for the media
    private final String genre;    // The genre of the media
    private final Format format;   // The format of the media (e.g., Digital, Hardcover)

    /**
     * Constructs a Media object with the specified format, ISBN, and genre.
     *
     * @param format the format of the media (e.g., DVD, Blu-ray, Hardcover).
     * @param isbn   the ISBN identifier for the media.
     * @param genre  the genre of the media.
     */
    public Media(Format format, String isbn, String genre) {
        this.format = format;  // Initialize format with the provided format
        this.isbn = isbn;      // Initialize ISBN with the provided ISBN
        this.genre = genre;    // Initialize genre with the provided genre
    }

    /**
     * Gets the ISBN of the media.
     *
     * @return the ISBN of the media.
     */
    public final String getISBN() {
        return this.isbn;
    }

    /**
     * Gets the genre of the media.
     *
     * @return the genre of the media.
     */
    public final String getGenre() {
        return this.genre;
    }

    /**
     * Gets the format of the media.
     *
     * @return the format of the media.
     */
    public final Format getFormat() {
        return this.format;
    }

    /**
     * Abstract method to get the specific type of the media.
     * Must be implemented by subclasses to return a type (e.g., Book, Movie).
     *
     * @return a string representing the specific media type.
     */
    public abstract String getType();

    /**
     * Compares this media object with another object for equality.
     * Two media objects are considered equal if they have the same ISBN.
     *
     * @param o the object to compare with.
     * @return true if the other object is a Media instance with the same ISBN, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // Check if the object is the same as the current instance
        if (o == this) {
            return true;
        }

        // Return false if the object is not an instance of Media
        if (!(o instanceof Media)) {
            return false;
        }

        // Typecast the object to Media to allow comparison
        Media otherMedia = (Media) o;

        // Compare the ISBN of both Media objects and return true if they match
        return this.getISBN().compareTo(otherMedia.getISBN()) == 0;
    }

    /**
     * Provides a string representation of the media, including its type, ISBN, genre, and format.
     *
     * @return a string describing the media's type, ISBN, genre, and format.
     */
    @Override
    public String toString() {
        // Concatenate type, ISBN, genre, and format to create a descriptive string
        return "Type: " + this.getType() + ", ISBN: " + this.getISBN() + ", Genre: " + this.getGenre() + ", Format: " + this.getFormat();
    }
}
