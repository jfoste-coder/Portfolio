/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The SearchFilter class implements the MediaFilter interface, enabling the filtering
 * of media items based on a search term. It checks if the search term is present
 * in either the label's key or its media value's string representation.
 */
public class SearchFilter implements MediaFilter{

    /** 
     * The term to search for within media labels. This term is used in matching 
     * against label keys and media values.
     */
    private final String searchTerm;

    /**
     * Constructs a SearchFilter with the specified search term.
     *
     * @param searchTerm the term used to match against label keys and media values.
     */
    public SearchFilter(String searchTerm){
        this.searchTerm = searchTerm;// Initialize the search term for use in filtering
    }

    /**
     * Checks if the specified label matches the filter criteria.
     * A label matches if the search term is found within the label's key
     * or within the string representation of the label's media value.
     *
     * @param label the Label containing a key and media value to test for a match.
     * @param <K>   the type of the label key (expected to be String in this implementation).
     * @param <V>   the type of the label value (expected to be Media in this implementation).
     * @return true if the search term is present in the label's key or value; false otherwise.
     */
    @Override
    public <K, V> boolean matches(Label<String, Media> label){

        /**
         * Check if the search term is contained in the label's key
         * Check if the search term is contained in the string representation of the label's value
         * Return true if either the key or value contains the search term
         */
        return label.getKey().contains(searchTerm) || label.getValue().toString().contains(searchTerm);
    }


}
