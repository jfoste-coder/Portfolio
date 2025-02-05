/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The MediaAlreadyInLibrary exception is thrown when an attempt is made to add
 * a media item to a library that already contains it. This exception holds
 * additional information about the name and media item involved in the conflict.
 */
public class MediaAlreadyInLibrary extends Exception {

    // Fields to store details about the media item already in the library
    private final String name;   // The name of the media item causing the exception
    private final Media media;   // The media item causing the exception

    /**
     * Constructs a MediaAlreadyInLibrary exception with the specified media name and item.
     *
     * @param name  the name of the media item already in the library.
     * @param media the media item already in the library.
     */
    public MediaAlreadyInLibrary(String name, Media media) {
        super("Media already in library"); // Pass a default message to the superclass constructor
        this.name = name;    // Initialize the name field with the provided name
        this.media = media;  // Initialize the media field with the provided media item
    }

    /**
     * Gets the name of the media item causing the exception.
     *
     * @return the name of the media item already in the library.
     */
    public final String getName() {
        return this.name;
    }

    /**
     * Gets the media item causing the exception.
     *
     * @return the media item already in the library.
     */
    public final Media getMedia() {
        return this.media;
    }
}
