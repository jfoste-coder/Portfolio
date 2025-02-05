/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The MediaFilter interface defines a filter that can be applied to media labels.
 * It includes a single method, `matches`, which checks if a given label meets certain
 * criteria. This interface is intended to be implemented by classes that specify
 * particular filtering rules for media items.
 */
public interface MediaFilter {

    /**
     * Determines if a specified label meets the filter criteria.
     * The method is generic and can work with various types, with the key
     * typically being a String and the value being a Media object.
     *
     * @param label the label containing a key and a media item (key is expected
     *              to be a String and value a Media object).
     * @param <K>   the type of the label's key.
     * @param <V>   the type of the label's value.
     * @return true if the label matches the filter criteria; false otherwise.
     */
    public <K, V> boolean matches(Label<String, Media> label);
}
