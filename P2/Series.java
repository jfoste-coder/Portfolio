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
 * The Series class represents a media item of type "Series" and extends the Media class.
 * It includes specific details such as the title, cast, and episodes.
 */
public class Series extends Media{

    // Fields for storing series-specific details
    private final String title; // The title of the series
    private List<String> cast = new ArrayList<String>(); // List of cast members
    private List<String> episodes = new ArrayList<String>(); // List of episodes

    /**
     * Constructs a Series object with the specified format, ISBN, genre, title, cast, and episodes.
     *
     * @param format   the format of the series (e.g., DVD, Digital).
     * @param isbn     the unique ISBN identifier for the series.
     * @param genre    the genre of the series.
     * @param title    the title of the series.
     * @param cast     the list of cast members in the series.
     * @param episodes the list of episode titles in the series.
     */
    public Series(Format format, String isbn, String genre, String title, List cast, List episodes){
        super(format, isbn, genre); // Call the superclass constructor to initialize common fields
        this.title = title; // Initialize title with the provided title
        this.cast = cast; // Initialize cast list with the provided cast members
        this.episodes = episodes; // Initialize episodes list with the provided episodes
    }

    /**
     * Gets the title of the series.
     *
     * @return the title of the series.
     */
    public final String getTitle(){
        return this.title;
    }

    /**
     * Gets the cast of the series.
     *
     * @return a list of cast members as Strings.
     */
    public final List<String> getCast(){
        return this.cast;
    }

    /**
     * Gets the episodes of the series.
     *
     * @return a list of episode titles as Strings.
     */
    public final List<String> getEpisodes(){
        return this.episodes;
    }

    /**
     * Returns the type of this media item as "Series."
     *
     * @return a string representing the type, which is "Series."
     */
    @Override
    public String getType(){
        return "Series";
    }

    /**
     * Returns a string representation of the series, including the title and details
     * from the superclass's toString method.
     *
     * @return a string describing the series' title and other details.
     */
    @Override
    public String toString(){
        return "Title: " + this.title + ", " + super.toString();
    }

    /**
     * Compares this series with another media item based on the title.
     * 
     * @param o the other Media object to compare with.
     * @return a negative integer, zero, or a positive integer as this series is less than, 
     *         equal to, or greater than the specified Media object.
     */
    @Override
    public int compareTo(Media o){

        //Down cast Media to Series
        Series otherSeries = (Series) o;

        // Compare the titles of the two series alphabetically
        return this.title.compareTo(otherSeries.title);
        
    }




}
