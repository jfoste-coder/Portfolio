import com.sun.net.httpserver.Authenticator;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for comparing performance between different StudentRoster implementations.
 * <p>
 * This class contains performance tests comparing different collection implementations
 * used in the StudentRoster class. Specifically, it includes tests comparing {@code ArrayList}
 * and {@code LinkedList} for various operations, and provides method stubs for tests comparing
 * {@code ArrayList} and {@code HashSet}, which students are expected to implement.
 * </p>
 */
public class StudentRosterTest {

    /**
     * The number of elements to be used in the performance tests.
     */
    private static final int ELEMENTS_COUNT = 100_000;

    /**
     * Tests the performance of adding elements between {@code ArrayList} and {@code HashSet}.
     * <p>
     * Expects {@code HashSet} to be faster than {@code ArrayList} for add operations.
     * </p>
     */
    @Test
    public void testAddArrayListVsHashSet() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<HashSet<Student>> hashSetRoster = StudentRoster.createHashSetRoster();

        long arrayListTime = measureAddToList(arrayListRoster.getStudents());
        long hashSetTime = measureAddToList(hashSetRoster.getStudents());

        System.out.println("ArrayList Add time: " + arrayListTime + " ns");
        System.out.println("HashSet Add time: " + hashSetRoster + " ns");

        assertTrue(hashSetTime < arrayListTime,
                "HashSet Add performance should be faster than ArrayList");
    }

    /**
     * Tests the performance of the {@code contains} operation between {@code ArrayList} and {@code HashSet}.
     * <p>
     * Expects {@code HashSet} to be faster than {@code ArrayList} for {@code contains} operations.
     * </p>
     */
    @Test
    public void testContainsArrayListVsHashSet() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<HashSet<Student>> hashSetRoster = StudentRoster.createHashSetRoster();

        long arrayListTime = measureContainsInList(arrayListRoster.getStudents());
        long hashSetTime = measureContainsInList(hashSetRoster.getStudents());

        System.out.println("ArrayList Contains time: " + arrayListTime + " ns");
        System.out.println("HashSet Contains time: " + hashSetRoster + " ns");

        assertTrue(hashSetTime < arrayListTime,
                "HashSet Contains performance should be faster than ArrayList");
    }

    /**
     * Tests the performance of removing elements between {@code ArrayList} and {@code HashSet}.
     * <p>
     * Expects {@code HashSet} to be faster than {@code ArrayList} for remove operations.
     * </p>
     */
    @Test
    public void testRemoveArrayListVsHashSet() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<HashSet<Student>> hashSetRoster = StudentRoster.createHashSetRoster();

        long arrayListTime = measureRemoveFromList(arrayListRoster.getStudents());
        long hashSetTime = measureRemoveFromList(hashSetRoster.getStudents());

        System.out.println("ArrayList remove time: " + arrayListTime + " ns");
        System.out.println("HashSet remove time: " + hashSetRoster + " ns");

        assertTrue(hashSetTime < arrayListTime,
                "HashSet Remove performance should be faster than ArrayList");
    }

    /**
     * Tests the performance of adding elements at the end between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects similar performance when adding at the end.
     * </p>
     */
    @Test
    public void testAddAtEndArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        long arrayListTime = measureAddAtEndList(arrayListRoster.getStudents());
        long linkedListTime = measureAddAtEndList(linkedListRoster.getStudents());

        System.out.println("ArrayList add at end time: " + arrayListTime + " ns");
        System.out.println("LinkedList add at end time: " + linkedListTime + " ns");

        long timeDifference = Math.abs(arrayListTime - linkedListTime);
        long acceptableDifference = arrayListTime / 2; // Allow 50% difference
        assertTrue(timeDifference < acceptableDifference,
                "Add at end performance should be similar between ArrayList and LinkedList");
    }

    /**
     * Tests the performance of adding elements at the beginning between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects {@code LinkedList} to be faster than {@code ArrayList} when adding at the beginning.
     * </p>
     */
    @Test
    public void testAddAtBeginningArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        long arrayListTime = measureAddAtBeginningList(arrayListRoster.getStudents());
        long linkedListTime = measureAddAtBeginningList(linkedListRoster.getStudents());

        System.out.println("ArrayList add at beginning time: " + arrayListTime + " ns");
        System.out.println("LinkedList add at beginning time: " + linkedListTime + " ns");

        assertTrue(linkedListTime < arrayListTime,
                "LinkedList should be faster than ArrayList when adding at the beginning");
    }

    /**
     * Tests the performance of random access between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects {@code ArrayList} to be faster than {@code LinkedList} for random access.
     * </p>
     */
    @Test
    public void testRandomAccessArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        populateCollection(arrayListRoster.getStudents());
        populateCollection(linkedListRoster.getStudents());

        long arrayListTime = measureRandomAccessList(arrayListRoster.getStudents());
        long linkedListTime = measureRandomAccessList(linkedListRoster.getStudents());

        System.out.println("ArrayList random access time: " + arrayListTime + " ns");
        System.out.println("LinkedList random access time: " + linkedListTime + " ns");

        assertTrue(arrayListTime < linkedListTime,
                "ArrayList should be faster than LinkedList for random access");
    }

    /**
     * Tests the performance of removing elements from the middle between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects {@code LinkedList} to be faster than {@code ArrayList} when removing from the middle.
     * </p>
     */
    @Test
    public void testRemoveFromMiddleArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        populateCollection(arrayListRoster.getStudents());
        populateCollection(linkedListRoster.getStudents());

        long arrayListTime = measureRemoveFromMiddleList(arrayListRoster.getStudents());
        long linkedListTime = measureRemoveFromMiddleList(linkedListRoster.getStudents());

        System.out.println("ArrayList remove from middle time: " + arrayListTime + " ns");
        System.out.println("LinkedList remove from middle time: " + linkedListTime + " ns");

        assertTrue(linkedListTime < arrayListTime,
                "LinkedList should be faster than ArrayList when removing from the middle");
    }

    /**
     * Tests the performance of iterating over elements between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects {@code ArrayList} to be faster or equal to {@code LinkedList} when iterating over elements.
     * </p>
     */
    @Test
    public void testIterationArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        populateCollection(arrayListRoster.getStudents());
        populateCollection(linkedListRoster.getStudents());

        long arrayListTime = measureIteration(arrayListRoster.getStudents());
        long linkedListTime = measureIteration(linkedListRoster.getStudents());

        System.out.println("ArrayList iteration time: " + arrayListTime + " ns");
        System.out.println("LinkedList iteration time: " + linkedListTime + " ns");

        assertTrue(arrayListTime <= linkedListTime,
                "ArrayList should be faster or equal to LinkedList when iterating over elements");
    }

    /**
     * Tests the performance of removing elements from the end between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects {@code ArrayList} to be faster or equal to {@code LinkedList} when removing from the end.
     * </p>
     */
    @Test
    public void testRemoveFromEndArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        populateCollection(arrayListRoster.getStudents());
        populateCollection(linkedListRoster.getStudents());

        long arrayListTime = measureRemoveFromEndList(arrayListRoster.getStudents());
        long linkedListTime = measureRemoveFromEndList(linkedListRoster.getStudents());

        System.out.println("ArrayList remove from end time: " + arrayListTime + " ns");
        System.out.println("LinkedList remove from end time: " + linkedListTime + " ns");

        assertTrue(arrayListTime <= linkedListTime,
                "ArrayList should be faster or equal to LinkedList when removing from the end");
    }

    /**
     * Tests the performance of adding elements in the middle between {@code ArrayList} and {@code LinkedList}.
     * <p>
     * Expects {@code LinkedList} to be faster than {@code ArrayList} when adding in the middle.
     * </p>
     */
    @Test
    public void testAddInMiddleArrayListVsLinkedList() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<LinkedList<Student>> linkedListRoster = StudentRoster.createLinkedListRoster();

        long arrayListTime = measureAddInMiddleList(arrayListRoster.getStudents());
        long linkedListTime = measureAddInMiddleList(linkedListRoster.getStudents());

        System.out.println("ArrayList add in middle time: " + arrayListTime + " ns");
        System.out.println("LinkedList add in middle time: " + linkedListTime + " ns");

        assertTrue(linkedListTime < arrayListTime,
                "LinkedList should be faster than ArrayList when adding in the middle");
    }

    /**
     * Tests the performance of iterating over elements between {@code ArrayList} and {@code HashSet}.
     * <p>
     * Expects {@code ArrayList} to be faster than {@code HashSet} when iterating over elements.
     * </p>
     */
    @Test
    public void testIterationArrayListVsHashSet() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<HashSet<Student>> hashSetRoster = StudentRoster.createHashSetRoster();

        long arrayListTime = measureIteration(arrayListRoster.getStudents());
        long hashSetTime = measureIteration(hashSetRoster.getStudents());

        System.out.println("ArrayList Iterate time: " + arrayListTime + " ns");
        System.out.println("HashSet Iterate time: " + hashSetRoster + " ns");

        assertTrue(hashSetTime > arrayListTime,
                "HashSet Iterate performance should be Slower than ArrayList");
    }

    /**
     * Tests the behavior when adding duplicate elements between {@code ArrayList} and {@code HashSet}.
     * <p>
     * Expects {@code HashSet} to prevent duplicates, while {@code ArrayList} allows them.
     * </p>
     */
    @Test
    public void testAddDuplicatesArrayListVsHashSet() {
        StudentRoster<ArrayList<Student>> arrayListRoster = StudentRoster.createArrayListRoster();
        StudentRoster<HashSet<Student>> hashSetRoster = StudentRoster.createHashSetRoster();

        boolean arrayListDuplicate = addDuplicate(arrayListRoster.getStudents());
        boolean hashSetDuplicate = addDuplicate(hashSetRoster.getStudents());

        System.out.println("ArrayList Status: " + arrayListDuplicate);
        System.out.println("HashSet Status: " + hashSetDuplicate);

        assertTrue(arrayListDuplicate && !hashSetDuplicate,
                "HashSet Iterate performance should be Slower than ArrayList");
    }

    // Helper methods

    private boolean addDuplicate(Collection<Student> students) {
        boolean success = false;
        success = students.add(new Student("Student" + 1, 1));
        success = students.add(new Student("Student" + 1, 1));
        return success;
    }

    private void populateCollection(Collection<Student> students) {
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            students.add(new Student("Student" + i, i));
        }
    }

    private long measureAddAtEndList(List<Student> students) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            students.add(new Student("Student" + i, i));
        }
        return System.nanoTime() - startTime;
    }

    private long measureAddAtBeginningList(List<Student> students) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            students.add(0, new Student("Student" + i, i));
        }
        return System.nanoTime() - startTime;
    }

    private long measureRandomAccessList(List<Student> students) {
        Random rand = new Random();
        int accesses = 100_000; // Number of random accesses
        long startTime = System.nanoTime();
        for (int i = 0; i < accesses; i++) {
            int index = rand.nextInt(students.size());
            students.get(index);
        }
        return System.nanoTime() - startTime;
    }

    private long measureRemoveFromMiddleList(List<Student> students) {
        int middle = students.size() / 2;
        long startTime = System.nanoTime();
        for (int i = middle; i >= 0; i--) {
            students.remove(i);
        }
        return System.nanoTime() - startTime;
    }

    private long measureIteration(Collection<Student> students) {
        long startTime = System.nanoTime();
        for (Student student : students) {
            // No operation, just iterate
        }
        return System.nanoTime() - startTime;
    }

    private long measureRemoveFromEndList(List<Student> students) {
        long startTime = System.nanoTime();
        for (int i = students.size() - 1; i >= 0; i--) {
            students.remove(i);
        }
        return System.nanoTime() - startTime;
    }

    private long measureRemoveFromList(Collection<Student> students) {
        long startTime = System.nanoTime();
        for (int i = 0; i < students.size() - 1; i++) {
            students.remove(i);
        }
        return System.nanoTime() - startTime;
    }

    private long measureContainsInList(Collection<Student> students) {
        long startTime = System.nanoTime();
        for (int i = 0; i < students.size() - 1; i++) {
            students.contains(new Student("Student" + i, i));
        }
        return System.nanoTime() - startTime;
    }

    private long measureAddToList(Collection<Student> students) {
        long startTime = System.nanoTime();
        for (int i = 0; i < students.size() - 1; i++) {
            students.add(new Student("Student" + i, i));
        }
        return System.nanoTime() - startTime;
    }

    private long measureAddInMiddleList(List<Student> students) {
        long startTime = System.nanoTime();
        for (int i = 0; i < ELEMENTS_COUNT; i++) {
            int middle = students.size() / 2;
            students.add(middle, new Student("Student" + i, i));
        }
        return System.nanoTime() - startTime;
    }
}
