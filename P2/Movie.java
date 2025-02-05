/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.List;
import java.util.ArrayList;


/**
 * The Movie class represents a media item of type "Movie" and extends the Media class.
 * It includes specific details such as the title, director, release year, and cast.
 */
public class Movie extends Media {

    // Fields representing movie-specific details
    private final String title;    // The title of the movie
    private final String director; // The director of the movie
    private final int year;        // The year the movie was released
    private List<String> cast = new ArrayList<String>(); // List of cast members

    /**
     * Constructs a Movie object with the specified format, ISBN, genre, title, director,
     * release year, and cast list.
     *
     * @param format    the format of the movie (e.g., DVD, Blu-ray, Digital).
     * @param isbn      the unique ISBN identifier for the movie.
     * @param genre     the genre of the movie.
     * @param title     the title of the movie.
     * @param director  the director of the movie.
     * @param year      the release year of the movie.
     * @param cast      the list of cast members in the movie.
     */
    public Movie(Format format, String isbn, String genre, String title, String director, int year, List cast) {
        super(format, isbn, genre); // Call the superclass constructor to initialize common fields
        this.title = title; // Initialize title field with the provided title
        this.director = director; // Initialize director field with the provided director
        this.year = year; // Initialize year field with the provided year
        this.cast = cast; // Initialize cast list with the provided cast members
    }

    /**
     * Gets the title of the movie.
     *
     * @return the title of the movie.
     */
    public final String getTitle() {
        return this.title;
    }

    /**
     * Gets the director of the movie.
     *
     * @return the director of the movie.
     */
    public final String getDirector() {
        return this.director;
    }

    /**
     * Gets the release year of the movie.
     *
     * @return the year of release.
     */
    public final int getYear() {
        return this.year;
    }

    /**
     * Gets the cast of the movie.
     *
     * @return a list of cast members as Strings.
     */
    public final List<String> getCast() {
        return this.cast;
    }

    /**
     * Returns the type of this media item as "Movie."
     *
     * @return a string representing the type, which is "Movie."
     */
    @Override
    public String getType() {
        return "Movie";
    }

    /**
     * Returns a string representation of the movie, including the title,
     * release year, and a summary from the superclass's toString method.
     *
     * @return a string describing the movie's title, year, and other details.
     */
    @Override
    public String toString() {

        // Concatenate title, year, and Media superclass information for a complete movie description
        return "Title: " + this.title + ", Year: " + this.year + ", " + super.toString();
    }

    /**
     * Compares this movie with another media item. Comparison is based on the title 
     * (alphabetically), and if the titles are the same, on the release year.
     *
     * @param o the other Media object to compare with.
     * @return a negative integer, zero, or a positive integer as this movie is less 
     *         than, equal to, or greater than the specified Media object.
     */
    @Override
    public int compareTo(Media o) {
        Movie otherMovie = (Movie) o; // Cast the other Media object to a Movie type

        // First compare titles alphabetically
        if (this.title.compareTo(otherMovie.title) != 0) {
            return this.title.compareTo(otherMovie.title); // Return result if titles differ
        } else {

            // If titles are identical, compare by release year
            return Integer.compare(this.year, otherMovie.year);
        }
    }
}
