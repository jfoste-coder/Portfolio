/**
 * Represents an immutable student with a name and an ID.
 * <p>
 * This class is immutable and thread-safe. It properly overrides the {@code equals()} and {@code hashCode()}
 * methods following best practices to ensure correct behavior when used in collections and for object comparisons.
 * The implementation adheres to the Liskov's Data Abstraction Mechanism and Substitution Principle (LSP), and follows guidelines from Joshua Bloch's
 * "Effective Java."
 * </p>
 */
public final class Student {
    /**
     * The name of the student.
     */
    private final String name;

    /**
     * The unique identifier of the student.
     */
    private final int id;

    /**
     * Constructs a new {@code Student} with the specified name and ID.
     *
     * @param name the name of the student
     * @param id   the unique identifier of the student
     */
    public Student(String name, int id) {
        this.name = name;
        this.id = id;
    }

    /**
     * Returns the name of this student.
     *
     * @return the student's name
     */
    public String getName() {
        return name;
    }

    /**
     * Returns the ID of this student.
     *
     * @return the student's ID
     */
    public int getId() {
        return id;
    }

    /**
     * Indicates whether some other object is "equal to" this one.
     * <p>
     * This implementation adheres to the contract specified in {@link Object#equals(Object)} and
     * considers two {@code Student} objects equal if they have the same {@code id} and {@code name}.
     * The method is implemented using nested {@code if} statements for clarity.
     * </p>
     * <p>
     * The method follows the Liskov Substitution Principle by invoking {@code super.equals(o)} and
     * uses instance-specific field comparisons.
     * </p>
     *
     * @param o the reference object with which to compare
     * @return {@code true} if this student is equal to the specified object; {@code false} otherwise
     */
    @Override
    public boolean equals(Object o) {
        // LSP: Check if super.equals(o) returns true (reference equality)
        if (super.equals(o)) {
            return true;
        }

        // Check if o is an instance of Student:
        if (!(o instanceof Student)) {
            return false;
        }

        // Note how the instanceof check is better than trying to catch a class cast exception when casting =)
        // In your public methods, if there is a way to check that an unchecked exception may occur, be defensive: prevent it from happening rather than coding some exception handling or propagation. 
        Student student = (Student) o;

        // Compare id fields
        if (id != student.id) {
            return false;
        }

        // Compare name fields
        if (name != null) {
            if (!name.equals(student.name)) {
                return false;
            }
        } else {
            if (student.name != null) {
                return false;
            }
        }

        // All checks passed; the objects are equal
        return true;
    }

    /**
     * Returns a hash code value for this student.
     * <p>
     * The hash code is computed based on the student's {@code id} and {@code name}, ensuring that equal
     * students have the same hash code, as required by the {@code hashCode()} contract.
     * </p>
     *
     * @return a hash code value for this student
     */
    @Override
    public int hashCode() {
        int result = 17; // Start with a non-zero constant
        result = 31 * result + id;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    /**
     * Returns a string representation of this student.
     *
     * @return a string representation of this student
     */
    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "'}";
    }
}
