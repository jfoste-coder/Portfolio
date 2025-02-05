import java.util.*;

/**
 * Represents a roster of students backed by a {@link Collection} implementation.
 * <p>
 * The {@code StudentRoster} class is a generic container that holds {@link Student} objects
 * using a specified {@link Collection} implementation. It provides methods to add students
 * to the roster and to retrieve the underlying collection of students.
 * </p>
 * <p>
 * This class includes static factory methods to create instances of {@code StudentRoster}
 * using different collection types, such as {@link ArrayList}, {@link LinkedList}, {@link Vector},
 * {@link Stack}, {@link HashSet}, and {@link TreeSet}.
 * </p>
 *
 * @param <C> The type of {@link Collection} that holds the students.
 */
public class StudentRoster<C extends Collection<Student>> {

    /**
     * The collection of students in the roster.
     */
    private C students;

    /**
     * Constructs a new {@code StudentRoster} with the specified collection.
     *
     * @param students the collection that will back this roster
     */
    public StudentRoster(C students) {
        this.students = students;
    }

    /**
     * Returns the collection of students in this roster.
     *
     * @return the collection of students
     */
    public C getStudents() {
        return students;
    }

    /**
     * Adds a student to this roster.
     *
     * @param student the student to add
     * @throws UnsupportedOperationException if the underlying collection does not support the {@code add} operation
     * @throws ClassCastException            if the class of the specified student prevents it from being added
     * @throws NullPointerException          if the specified student is {@code null} and the collection does not permit {@code null} elements
     * @throws IllegalArgumentException      if some property of the student prevents it from being added
     */
    public void addStudent(Student student) {
        students.add(student);
    }

    /**
     * Returns a string representation of this roster.
     * <p>
     * The string representation consists of the class name followed by the collection of students.
     * </p>
     *
     * @return a string representation of this roster
     */
    @Override
    public String toString() {
        return "StudentRoster{students=" + students + "}";
    }

    /**
     * Creates a {@code StudentRoster} backed by an {@link ArrayList}.
     * <p>
     * The {@code ArrayList} maintains insertion order and allows duplicate elements.
     * This is suitable when you need fast random access and frequent iterations.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by an {@code ArrayList}
     */
    public static StudentRoster<ArrayList<Student>> createArrayListRoster() {
        return new StudentRoster<>(new ArrayList<>());
    }

    /**
     * Creates a {@code StudentRoster} backed by a {@link LinkedList}.
     * <p>
     * The {@code LinkedList} maintains insertion order and allows duplicate elements.
     * It is efficient for insertions and deletions at both ends of the list.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by a {@code LinkedList}
     */
    public static StudentRoster<LinkedList<Student>> createLinkedListRoster() {
        return new StudentRoster<>(new LinkedList<>());
    }

    /**
     * Creates a {@code StudentRoster} backed by a {@link Vector}.
     * <p>
     * The {@code Vector} is a synchronized (thread-safe) resizable array.
     * It maintains insertion order and allows duplicate elements.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by a {@code Vector}
     */
    public static StudentRoster<Vector<Student>> createVectorRoster() {
        return new StudentRoster<>(new Vector<>());
    }

    /**
     * Creates a {@code StudentRoster} backed by a {@link Stack}.
     * <p>
     * The {@code Stack} extends {@code Vector} and represents a last-in-first-out (LIFO) stack.
     * It is thread-safe but considered legacy; for new implementations, consider using {@code Deque}.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by a {@code Stack}
     */
    public static StudentRoster<Stack<Student>> createStackRoster() {
        return new StudentRoster<>(new Stack<>());
    }

    /**
     * Creates a {@code StudentRoster} backed by a {@link HashSet}.
     * <p>
     * The {@code HashSet} stores unique elements only (no duplicates) and does not maintain any order.
     * It provides constant-time performance for basic operations like {@code add}, {@code remove}, and {@code contains}.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by a {@code HashSet}
     */
    public static StudentRoster<HashSet<Student>> createHashSetRoster() {
        return new StudentRoster<>(new HashSet<>());
    }

}
