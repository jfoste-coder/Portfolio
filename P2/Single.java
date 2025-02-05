/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The Single class represents a type of music media and extends the Music class.
 * It specifically models a single music track, differentiating it from albums or compilations.
 */
public class Single extends Music {

    /**
     * Constructs a Single object with the specified format, ISBN, genre, artist, title, and release year.
     *
     * @param format the format of the single (e.g., Digital, Vinyl).
     * @param isbn   the unique ISBN identifier for the single.
     * @param genre  the genre of the single.
     * @param artist the artist who created the single.
     * @param title  the title of the single.
     * @param year   the release year of the single.
     */
    public Single(Format format, String isbn, String genre, String artist, String title, int year) {
        super(format, isbn, genre, artist, title, year); // Call the superclass constructor to initialize fields
    }

    /**
     * Returns the type of this media item as "Single."
     *
     * @return a string representing the type, which is "Single."
     */
    @Override
    public String getType() {
        return "Single";
    }
}
