/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;


/**
 * The MediaLibrary class represents a collection of media items labeled with unique names.
 * It allows adding new media items, filtering the collection based on specified criteria,
 * and sorting the collection.
 */
public class MediaLibrary {

    /** 
     * A list storing labeled media items in the library. Each item is represented as a
     * Label containing a String name and a Media object.
     */
    private final List<Label<String, Media>> library;

    /**
     * Constructs an empty MediaLibrary and initializes the library as a LinkedList.
     */
    public MediaLibrary() {
        this.library = new LinkedList<>(); // Initialize library as an empty LinkedList
    }

    /**
     * Adds a labeled media item to the library if it does not already exist.
     *
     * @param name  the name of the media item to be labeled.
     * @param media the media item to add to the library.
     * @throws MediaAlreadyInLibrary if a label with the same name and media item already exists.
     */
    public void add(String name, Media media) throws MediaAlreadyInLibrary {

        // Create a new Label object with the provided name and media
        Label<String, Media> newLabel = new Label<>(name, media);
        
        // Check if the library already contains this label
        if (this.library.contains(newLabel)) {

            // If the label exists, throw a MediaAlreadyInLibrary exception
            throw new MediaAlreadyInLibrary(name, media);
        } else {

            // If not, add the new label to the library
            this.library.add(newLabel);
        }
    }

    /**
     * Filters the media library based on a specified MediaFilter and returns the matching items.
     *
     * @param mediaFilter the filter used to determine matching media items.
     * @return a list of labels representing media items that match the filter criteria.
     */
    public List<Label<String, Media>> filter(MediaFilter mediaFilter) {

        // Create a new list to hold filtered media items
        List<Label<String, Media>> filteredLibrary = new ArrayList<>();
        
        // Iterate through each labeled item in the library
        for (Label<String, Media> label : library) {

            // Check if the current label matches the media filter
            if (label.equals(mediaFilter)) {

                // If it matches, add it to the filtered library list
                filteredLibrary.add(label);
            }
        }
        
        // Return the list of media items that match the filter
        return filteredLibrary;
    }

    /**
     * Sorts the media library in-place based on the ordering of the Label objects.
     * The ordering is defined by the Label class's Comparable implementation.
     */
    public void sort() {

        // Sort the library list using the ordering of Label objects
        Collections.sort(library);
    }
}
