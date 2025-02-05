/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The Music class is an abstract base class for music-related media items.
 * It extends the Media class by adding specific details relevant to music, 
 * including the artist, title, and release year.
 */
public abstract class Music extends Media{

    // Fields for storing music-specific details
    private final String artist, title;
    private final int year;

    /**
     * Gets the artist of the music item.
     *
     * @return the artist of the music.
     */
    public final String getArtist() {
        return this.artist;
    }

    /**
     * Gets the title of the music item.
     *
     * @return the title of the music.
     */
    public final String getTitle() {
        return this.title;
    }

    /**
     * Gets the release year of the music item.
     *
     * @return the year of release.
     */
    public final int getYear() {
        return this.year;
    }

    /**
     * Constructs a Music object with the specified format, ISBN, genre, artist, title, and release year.
     *
     * @param format the format of the music item (e.g., CD, Digital, Vinyl).
     * @param isbn   the ISBN identifier for the music item.
     * @param genre  the genre of the music item.
     * @param artist the artist of the music item.
     * @param title  the title of the music item.
     * @param year   the release year of the music item.
     */
    public Music(Format format, String isbn, String genre, String artist, String title, int year) {
        super(format, isbn, genre); // Call the superclass constructor to initialize common fields
        this.artist = artist;       // Initialize artist with the provided artist
        this.title = title;         // Initialize title with the provided title
        this.year = year;           // Initialize year with the provided release year
    }

    /**
     * Provides a string representation of the music item, including artist, year, title,
     * and details from the superclass's toString method.
     *
     * @return a string describing the music item.
     */
    @Override
    public String toString() {
        // Build and return a descriptive string for the music item
        return "Artist: " + this.artist + ", Year: " + this.year + ", Title: " + this.title + ", " + super.toString();
    }

    /**
     * Compares this music item with another media item based on artist, year, and title.
     * The comparison hierarchy is:
     * 1. Artist (alphabetical order)
     * 2. Year (ascending order)
     * 3. Title (alphabetical order)
     *
     * @param o the other Media object to compare with.
     * @return a negative integer, zero, or a positive integer as this music item is less than,
     *         equal to, or greater than the specified Media object.
     */
    @Override
    public int compareTo(Media o) {
        // Downcast Media object to Music for comparison
        Music otherMusic = (Music) o;

        // First compare artist alphabetically
        if (this.artist.compareTo(otherMusic.artist) != 0) {
            return this.artist.compareTo(otherMusic.artist);
        }
        // If artists are the same, compare by year
        else if (Integer.compare(this.year, otherMusic.year) != 0) {
            return Integer.compare(this.year, otherMusic.year);
        }
        // If both artist and year are the same, compare by title
        else {
            return this.title.compareTo(otherMusic.title);
        }
    }
}
