/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.*;

/**
 * Represents a roster of students backed by a {@link Collection}
 * implementation.
 * <p>
 * The {@code StudentRoster} class is a generic container that holds
 * {@link Student} objects
 * using a specified {@link Collection} implementation. It provides methods to
 * add students
 * to the roster and to retrieve the underlying collection of students.
 * </p>
 * <p>
 * This class includes static factory methods to create instances of
 * {@code StudentRoster}
 * using different collection types, such as {@link ArrayList},
 * {@link LinkedList}, {@link Vector},
 * {@link Stack}, {@link HashSet}, and {@link TreeSet}.
 * </p>
 *
 * @param <C> The type of {@link Collection} that holds the students.
 */
public class StudentRoster<C extends Collection<Student>> implements Comparator<Student> {

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
     * @throws UnsupportedOperationException if the underlying collection does not
     *                                       support the {@code add} operation
     * @throws ClassCastException            if the class of the specified student
     *                                       prevents it from being added
     * @throws NullPointerException          if the specified student is
     *                                       {@code null} and the collection does
     *                                       not permit {@code null} elements
     * @throws IllegalArgumentException      if some property of the student
     *                                       prevents it from being added
     */
    public void addStudent(Student student) {
        students.add(student);
        for (Student s : students) {

        }
        // students.
    }

    /**
     * Returns a string representation of this roster.
     * <p>
     * The string representation consists of the class name followed by the
     * collection of students.
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
     * The {@code ArrayList} maintains insertion order and allows duplicate
     * elements.
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
     * The {@code LinkedList} maintains insertion order and allows duplicate
     * elements.
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
        return new StudentRoster<>(new Vector<>());// solution
    }

    /**
     * Creates a {@code StudentRoster} backed by a {@link Stack}.
     * <p>
     * The {@code Stack} extends {@code Vector} and represents a last-in-first-out
     * (LIFO) stack.
     * It is thread-safe but considered legacy; for new implementations, consider
     * using {@code Deque}.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by a {@code Stack}
     */
    public static StudentRoster<Stack<Student>> createStackRoster() {
        return new StudentRoster<>(new Stack<>());// solution
    }

    /**
     * Creates a {@code StudentRoster} backed by a {@link HashSet}.
     * <p>
     * The {@code HashSet} stores unique elements only (no duplicates) and does not
     * maintain any order.
     * It provides constant-time performance for basic operations like {@code add},
     * {@code remove}, and {@code contains}.
     * </p>
     *
     * @return a new {@code StudentRoster} instance backed by a {@code HashSet}
     */
    public static StudentRoster<HashSet<Student>> createHashSetRoster() {
        return new StudentRoster<>(new HashSet<>()); // solution
    }

    /**
     * Computes the average grade of all students using head recursion.
     * <p>
     * This method calculates the average grade of all students in the roster by
     * initiating a recursive process where each recursive call processes one
     * student
     * before moving to the next. The cumulative grade is stored and updated in a
     * {@code Result} object. The recursion is controlled using an iterator, which
     * maintains the state of the traversal across each recursive call via
     * <b>arguments</b>.
     * </p>
     *
     * @param grade a {@code Result} object to store the cumulative grade of all
     *              students,
     *              which will hold the final average once the computation is
     *              complete.
     */
    public void computeAverageGradeWithHeadRecursion(Result grade) {
        // Start the recursion with an iterator over the students collection
        Iterator<Student> iterator = students.iterator();
        computeAverageGradeWithHeadRecursion(iterator, 0, grade);
    }

    /**
     * An overloaded method that computes the average grade of students using
     * head recursion.
     * <p>
     * This method performs head recursion by processing each student's grade before
     * making
     * the recursive call. For each student, the grade is added to the cumulative
     * total stored
     * in the {@code Result} object. The recursive calls continue until the base
     * case,
     * where no more students remain in the iterator.
     * </p>
     * <p>
     * After reaching the base case, the average grade is stored
     * in the {@code Result} object by dividing the cumulative grade total by the
     * count of students. Notice how we are using none of the recursive call
     * returns.
     * </p>
     *
     * @param iterator an iterator over the student collection, allowing the
     *                 traversal state
     *                 to be maintained across recursive calls.
     * @param count    the number of students processed so far, used to calculate
     *                 the average
     *                 once the base case is reached.
     * @param grade    a {@code Result} object to store the cumulative grade, which
     *                 will ultimately
     *                 hold the final average.
     */
    private void computeAverageGradeWithHeadRecursion(Iterator<Student> iterator, int count, Result grade) {
        // Recursive case: check if there are more students to process
        if (iterator.hasNext()) {
            // Retrieve the next student
            Student student = iterator.next();
            Number currentTotal = grade.getValue();

            // Add the student's grade to the cumulative grade
            grade.setValue(currentTotal.doubleValue() + student.getGrade().doubleValue());

            // Recursive call occurs after updating the cumulative grade (head recursion)
            computeAverageGradeWithHeadRecursion(iterator, count + 1, grade);
        } else {
            // Base case: if no more students, calculate the average grade
            if (count > 0) {
                grade.setValue(grade.getValue().doubleValue() / count);
            }
        }
    }

    /**
     * Computes the average grade of all students using recursive iteration with an
     * iterator.
     * <p>
     * This method computes the average grade of all students in the roster by
     * initializing an
     * iterator for the student collection and passing it to a recursive
     * method.
     * The overloaded method
     * (`computeAverageGradeWithTailRecursion(Iterator<Student>
     * iterator)`)
     * iteratively accumulates the total grade and count of students as it traverses
     * through
     * each student in the collection.
     * </p>
     * <p>
     * Upon reaching the base case, the recursive calls begin to unwind, and the
     * accumulated
     * values are returned back through the stack. The final average grade is
     * computed by
     * dividing the total grade by the student count, stored in a {@code Result}
     * object.
     * </p>
     *
     * @return a {@code Result} object containing the average grade of all students.
     */
    public Result computeAverageGradeWithTailRecursion() {
        Iterator<Student> iterator = students.iterator();
        Result[] rs = computeAverageGradeWithTailRecursion(iterator);
        Result grade = rs[0];
        Result count = rs[1];
        grade.setValue(grade.getValue().doubleValue() / count.getValue().doubleValue());
        return grade;
    }
    // Error: Duplicate method. Remember, overloading cares about the method name
    // and parameter list only!
    // private void computeAverageGradeWithTailRecursion() {

    // }

    /**
     * An overloaded version of {@code computeAverageGradeWithTailRecursion} that
     * demonstrates
     * method overloading by modifying the parameter list.
     * <p>
     * Method overloading in Java allows multiple methods with the same name within
     * the same class,
     * provided that each method has a unique parameter list. The uniqueness of the
     * parameter list
     * (types, order, or number of parameters) is the only requirement for
     * overloading;
     * Java does not require the return type or visibility to be the same.
     * </p>
     * <p>
     * In this example, the presence of a single {@code int} parameter ({@code yo})
     * distinguishes
     * this method from other {@code computeAverageGradeWithTailRecursion} methods
     * in the class,
     * even though it has a different visibility modifier ({@code protected}) and
     * return type
     * ({@code void}). This is a valid overload due to the unique parameter list,
     * allowing
     * flexibility in defining different versions of the same method to handle
     * different use cases.
     * </p>
     *
     * @param yo an integer parameter that differentiates this method’s parameter
     *           list from other
     *           {@code computeAverageGradeWithTailRecursion} methods, allowing it
     *           to be a unique overload.
     */
    protected void computeAverageGradeWithTailRecursion(int yo) {
        // Implementation
    }

    /**
     * Recursively computes the average grade of students using head recursion.
     *
     * @param iterator the iterator for the collection of students. This iterator is
     *                 used for
     *                 <b>head</b> recursion, preserving the iterator’s state across
     *                 recursive calls,
     *                 which are sequentially pushed onto the call stack. Each
     *                 recursive call processes
     *                 the next element in the collection, making progress toward
     *                 the base case.
     *                 <p>
     *                 In Java, a collection can be iterated with a <i>foreach</i>
     *                 loop:
     * 
     *                 <pre>{@code
     *for (Student s : students) {
     *    // process student s
     *                 }
     * }</pre>
     * 
     *                 This <i>foreach</i> loop is internally equivalent to using an
     *                 {@link java.util.Iterator}, as shown below:
     * 
     *                 <pre>{@code
     *Iterator<Student> iterator = students.iterator();
     *while (iterator.hasNext()) { // checks for remaining elements
     *  Student s = iterator.next(); // retrieves the next element
     *                 }
     * }</pre>
     * 
     *                 The iterator provides direct control over the traversal
     *                 state, which is especially useful
     *                 for recursion, as it allows passing the iterator’s position
     *                 across recursive calls.
     *
     * @return a {@code Result[]} array containing two {@code Result} objects:
     *         <ul>
     *         <li><b>grade</b>: Holds the cumulative sum of all grades, used to
     *         calculate the final average.</li>
     *         <li><b>count</b>: Tracks the total number of students processed,
     *         necessary to calculate the average.</li>
     *         </ul>
     *         <p>
     *         Upon reaching the base case, the recursive calls begin to "unwind"
     *         (i.e., pop off the call stack).
     *         This unwinding allows each recursive call to contribute to the
     *         accumulated values for the total
     *         grade and student count. While this is not a true "tail recursion"
     *         (Java lacks tail-call optimization),
     *         the approach effectively accumulates results through the call stack
     *         in a manner similar to tail-recursive
     *         accumulation. The use of an array to store multiple results
     *         simplifies the recursive return process.
     */
    private Result[] computeAverageGradeWithTailRecursion(Iterator<Student> iterator) {
        Student student = null;
        // recursive case:
        if (iterator.hasNext()) {
            // Retrieve the next student
            // student = iterator.next(); //2. Uncomment this line.
            // We must update the iterator before heading to the next recursion!
            Result[] rs = computeAverageGradeWithTailRecursion(iterator);
            Result grade = rs[0];
            Result count = rs[1];

            student = iterator.next(); // 1. Easter egg: test failing due to an StackOverflow error? Comment this line.
                                       // Go to 2.
            Number currentTotal = grade.getValue();

            // Add the student's grade to the cumulative grade
            grade.setValue(
                    currentTotal.doubleValue() + student.getGrade().doubleValue());
            // Add the student's to the cumulative count
            Number currentCount = count.getValue();
            count.setValue(currentCount.intValue() + 1);
            return rs;
        } else {
            Result grade = new Result();
            Result count = new Result();
            // Base case: if no more students, tails back
            return new Result[] { grade, count };
        }
    }

    /**
     * Computes the average grade of all students using an iterative loop.
     * <p>
     * This method calculates the average grade of all students in the roster by
     * iterating over the collection using a loop (e.g., for-loop, while-loop).
     * It returns a {@code Result} object containing the average grade.
     * </p>
     *
     * @return a {@code Result} object containing the average grade
     */
    public Result computeAverageGradeWithIterativeLoop() {
        Result avg = new Result();

        if (students.isEmpty()) {
            return avg;
        }

        for (Student s : students) {
            avg.setValue(avg.getValue().doubleValue() + s.getGrade().doubleValue());
        }

        avg.setValue(avg.getValue().doubleValue() / students.size());

        return avg;
    }

    /**
     * Finds a student in the roster using head recursion.
     *
     * @param name The name of the student to search for.
     * @param sr   A search result object to hold the found student, if any.
     */
    public void findStudentByNameWithHeadRecursion(String name, SearchResult sr) {
        Iterator<Student> iterator = students.iterator();
        findStudentByNameWithHeadRecursion(iterator, name, sr);
    }

    private void findStudentByNameWithHeadRecursion(Iterator<Student> iterator, String name, SearchResult sr) {
        if (iterator.hasNext()) {
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)) {
                sr.setStudent(student);
            } else {
                findStudentByNameWithHeadRecursion(iterator, name, sr);
            }
        }
    }

    /**
     * Finds a student in the roster by name using tail recursion.
     * <p>
     * This method uses a recursive approach to locate a student by name in the
     * roster,
     * specifically applying tail recursion to return the matching student. The
     * search is
     * case-insensitive and uses {@link String#equalsIgnoreCase(String)} to match
     * names.
     * </p>
     * <p>
     * <b>Implementation Guidance:</b>
     * This public method initializes an iterator over the roster's collection and
     * then
     * calls an overloaded, private version of this method to perform the actual
     * recursive search.
     * To complete this method:
     * <ul>
     * <li>Initialize an iterator for the student collection.</li>
     * <li>Call the overloaded method, passing the iterator and search name to begin
     * the recursive search.</li>
     * <li>The overloaded method will handle the recursive traversal heads on, returning a
     * {@code SearchResult}. The result contains the matching student if found, or {@code null} if no match exists.</li>
     * </ul>
     * </p>
     *
     * @param name The name of the student to search for.
     * @return A {@code SearchResult} containing the student if found; otherwise, a
     *         {@code SearchResult}
     *         with {@code null}.
     */
    public SearchResult findStudentByNameWithTailRecursion(String name) {
        Iterator<Student> iterator = students.iterator();
        return findStudentByNameWithTailRecursion(iterator, name);
    }

    /**
     * An overloaded method that performs the tail-recursive search for a student by
     * name.
     * <p>
     * This method is called by {@link #findStudentByNameWithTailRecursion(String)}
     * and performs
     * the recursive traversal over the collection of students using the provided
     * iterator. It
     * compares each student's name to the search name using
     * {@link String#equalsIgnoreCase(String)}
     * for case-insensitive matching, returning a matching {@link SearchResult} if
     * found.
     * </p>
     * <p>
     * <b>Implementation Guidance:</b>
     * Follow these steps to implement this method correctly:
     * <ul>
     * <li><b>Recursive Case:</b> Use {@code hasNext()} to check if there are more
     * students in the iterator.
     * If there are, retrieve the next student and compare their name to the search
     * name. If a match is found,
     * return a new {@link SearchResult} containing this student.</li>
     * <li>If the student's name does not match, make a recursive call, advancing
     * the iterator to the next
     * student, and continue the search.</li>
     * <li><b>Base Case:</b> If {@code hasNext()} returns {@code false}, meaning
     * there are no more students
     * to check, return a {@code SearchResult} with {@code null} to indicate no
     * match was found.</li>
     * </ul>
     * This setup ensures that either a matching student is found and returned or
     * the end of the list
     * is reached, in which case a {@code null} result indicates no match.
     * </p>
     *
     * @param iterator An iterator over the collection of students.
     * @param name     The name of the student to search for.
     * @return A {@code SearchResult} with the student if found; otherwise, a
     *         {@code SearchResult}
     *         with {@code null}.
     */
    private SearchResult findStudentByNameWithTailRecursion(Iterator<Student> iterator, String name) {
        SearchResult sr = new SearchResult(null);
        while(iterator.hasNext()){
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)){
                sr.setStudent(student);
            } else {
                findStudentByNameWithTailRecursion(iterator, name);
            }
        }
        return sr;
    }

    /**
     * Finds a student in the roster by name using an iterative loop.
     * <p>
     * This method uses an iterative approach to search for a student by name within
     * the roster.
     * Each student's name is compared to the search name using
     * {@link String#equalsIgnoreCase(String)}
     * for case-insensitive matching. If a matching student is found, it is
     * immediately returned
     * within a {@code SearchResult}. If the loop completes with no match, a
     * {@code SearchResult}
     * containing {@code null} is returned to indicate no match was found.
     * </p>
     * <p>
     * <b>Implementation Guidance:</b>
     * Use a standard `for-each` or `while` loop to iterate over the roster's
     * students:
     * <ul>
     * <li>Inside the loop, compare each student's name to the search name.</li>
     * <li>If a match is found, create and return a new {@code SearchResult} with
     * the found student.</li>
     * <li>If the loop completes without finding a match, return a
     * {@code SearchResult} with {@code null}.</li>
     * </ul>
     * </p>
     *
     * @param name The name of the student to search for.
     * @return A {@code SearchResult} containing the student if found. If no student
     *         matches the
     *         name, {@link SearchResult#isFound()} will return {@code false}.
     */
    public SearchResult findStudentByNameWithIterativeLoop(String name) {
        Iterator<Student> iterator = students.iterator();
        SearchResult sr = new SearchResult(null);
        while(iterator.hasNext()){
            Student student = iterator.next();
            if (student.getName().equalsIgnoreCase(name)){
                sr.setStudent(student);
            }
        }
        return sr;
    }

    public int compare(Student a, Student b) {
        int compareResult = 0;
        // int comparison
        // compareResult = a.getId() - b.getId();
        // if (compareResult != 0) {
        // return compareResult;
        // }

        // String comparison:
        if (a == null) {
            return -1;
        }

        if (b == null) {
            return 1;
        }

        if (a.getName() == null) {
            return -1;
        }

        if (b.getName() == null) {
            return 1;
        }

        compareResult = a.getName().compareTo(b.getName());

        if (compareResult != 0) {
            return compareResult;
        }

        // and so on =)

        return compareResult;
    }

    /**
     * Searches for a student by name in the roster using a <b>sorted list</b> and
     * binary search.
     * <p>
     * This method creates a {@link Student} object with the provided search string,
     * sorts the roster of students, and then performs a binary search to
     * efficiently
     * find a student matching the provided name. If the student is found, it is
     * returned;
     * otherwise, {@code null} is returned.
     * </p>
     *
     * @param searchString the name of the student to search for.
     *                     The search is case-sensitive, and the name is compared
     *                     using the {@link String#compareTo(String)} method.
     * 
     * @return the {@link Student} object if a student with the given name is found,
     *         or {@code null} if no student matches the search string.
     * 
     * @throws IllegalArgumentException if the name is {@code null} or empty.
     */
    public Student searchByNameNicely(String searchString) {
        Student query = new Student(searchString, 0, null);
        List<Student> ls = new ArrayList<>(students);

        Collections.sort(ls, this);
        int indexOfQuery = Collections.binarySearch(ls, query, this);
        // Collections.sort(ls, this);
        if (indexOfQuery < 0) {
            return null;
        }
        return ls.get(indexOfQuery);
    }

}
