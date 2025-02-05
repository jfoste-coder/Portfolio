/**
 * Represents the result of a student search operation within a roster.
 * <p>
 * The {@code SearchResult} class encapsulates the outcome of a search for a {@link Student}
 * by storing a single {@code Student} object if a match is found. It provides methods to
 * retrieve the found student, update the search result, and check if the search was successful.
 * </p>
 */
public class SearchResult {

    /**
     * The student found by the search, or {@code null} if no student matches the search criteria.
     */
    private Student student;

    /**
     * Constructs a new {@code SearchResult} with the specified student.
     * <p>
     * This constructor initializes the search result with a {@link Student} object
     * or with {@code null} if no match was found.
     * </p>
     *
     * @param student the student found by the search, or {@code null} if no match was found
     */
    public SearchResult(Student student) {
        this.student = student;
    }

    /**
     * Returns the student found by the search.
     * <p>
     * This method provides access to the student stored in this {@code SearchResult}.
     * If the search was unsuccessful, this method returns {@code null}.
     * </p>
     *
     * @return the {@link Student} object if found, or {@code null} if no match was found
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Sets the student found by the search.
     * <p>
     * This method updates the {@code SearchResult} with a new {@link Student} object
     * if a match is found, or {@code null} if no match is available.
     * </p>
     *
     * @param student the student to store in this result, or {@code null} if no match
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * Checks if a student was found in the search.
     * <p>
     * This method determines if the {@code SearchResult} contains a valid {@link Student}
     * object, indicating a successful match.
     * </p>
     *
     * @return {@code true} if a student was found, or {@code false} if no match was found
     */
    public boolean isFound() {
        return student != null;
    }
}
