/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.ArrayList;
import java.util.List;


/**
 * The Album class represents a type of music media and extends the Music class.
 * It contains details specific to an album, including a list of tracks.
 */
public class Album extends Music {

    // List of tracks on the album, initialized as an ArrayList because additional add functionality is not required
    private List<String> trackList = new ArrayList<String>();

    /**
     * Constructs an Album object with the specified format, ISBN, genre, artist, title, release year, and track list.
     *
     * @param format    the format of the album (e.g., CD, Vinyl, Digital).
     * @param isbn      the unique ISBN identifier for the album.
     * @param genre     the genre of the album.
     * @param artist    the artist who created the album.
     * @param title     the title of the album.
     * @param year      the release year of the album.
     * @param trackList the list of track titles on the album.
     */
    public Album(Format format, String isbn, String genre, String artist, String title, int year, List<String> trackList) {
        super(format, isbn, genre, artist, title, year); // Call the superclass constructor to initialize common fields
        this.trackList = trackList; // Assign the provided track list to the field
    }

    /**
     * Gets the list of tracks on the album.
     *
     * @return a list of track titles as Strings.
     */
    public final List<String> getTrackList() {
        return this.trackList;
    }

    /**
     * Returns the type of this media item as "Album."
     *
     * @return a string representing the type, which is "Album."
     */
    @Override
    public String getType() {
        return "Albumn";
    }

    /**
     * Returns a string representation of the album, including details from the superclass's toString method
     * and the list of tracks.
     *
     * @return a string describing the album's details and its track list.
     */
    @Override
    public String toString() {
        // Append the list of tracks to the superclass's string representation for a complete album description
        return super.toString() + ", Tracks: " + trackList;
    }
}
