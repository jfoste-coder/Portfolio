/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/



/**
 * The Label class represents a key-value pair, where the value is required to be a type
 * that implements Comparable. This class allows comparison of Label objects based on their values.
 * It includes methods for retrieving the key and value, equality checking, and comparison.
 *
 * @param <K> the type of the key in the label.
 * @param <V> the type of the value in the label, which must implement Comparable.
 */
public class Label<K, V extends Comparable<V>> implements Comparable<Label<K, V>> {

    // Fields for storing the key and value of the label
    private final K key;     // The key associated with this label
    private final V value;   // The value associated with this label

    /**
     * Constructs a Label with the specified key and value.
     *
     * @param key   the key associated with the label.
     * @param value the value associated with the label, which must be comparable.
     */
    public Label(K key, V value) {
        this.key = key;   // Initialize key with the provided key
        this.value = value; // Initialize value with the provided value
    }

    /**
     * Gets the key of the label.
     *
     * @return the key of the label.
     */
    public final K getKey() {
        return this.key;
    }

    /**
     * Gets the value of the label.
     *
     * @return the value of the label.
     */
    public final V getValue() {
        return this.value;
    }

    /**
     * Checks if this label is equal to another object. Two labels are considered equal
     * if they have the same value.
     *
     * @param o the object to compare with.
     * @return true if the other object is a Label with an equal value, false otherwise.
     */
    @Override
    public boolean equals(Object o) {
        // Check if the other object is an instance of Label
        if (o instanceof Label) {
            // Typecast the object to Label for comparison
            Label otherLabel = (Label) o;
            // Return true if the values of both labels are equal
            return this.value.equals(otherLabel.value);
        }
        // Return false if the object is not a Label
        return false;
    }

    /**
     * Compares this label with another label based on their values.
     *
     * @param o the other Label object to compare with.
     * @return a negative integer, zero, or a positive integer as this label's value
     *         is less than, equal to, or greater than the specified label's value.
     */
    @Override
    public int compareTo(Label<K, V> o) {
        // Compare this label's value with the other label's value
        return value.compareTo(o.getValue());
    }
}
