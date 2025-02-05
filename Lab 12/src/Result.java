/**
 * Represents a numerical result.
 *
 * <p>This class encapsulates a {@link Number} object, providing methods to set and retrieve its value.</p>
 */
public class Result {
    private Number value;

    /**
     * Constructs a new {@code Result} with an initial value of zero.
     */
    public Result() {
        value = 0.0d;
    }

    /**
     * Constructs a new {@code Result} with the specified numerical value.
     *
     * @param value the initial value of this {@code Result}
     */
    public Result(Number value) {
        this.value = value;
    }

    /**
     * Sets the numerical value of this {@code Result}.
     *
     * @param value the new value to set
     */
    public void setValue(Number value) {
        this.value = value;
    }

    /**
     * Returns the numerical value of this {@code Result}.
     *
     * @return the current value
     */
    public Number getValue() {
        return value;
    }
}

