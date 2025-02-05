import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

public class StudentRosterTest {

    @Test
    public void testComputeAverageGradeWithHeadRecursion() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("David", 004, 90d));
        sr.addStudent(new Student("Adriana", 007, 95d));
        sr.addStudent(new Student("Paula", 000, 100d));
        Result r = new Result();
        sr.computeAverageGradeWithHeadRecursion(r);
        assertEquals(95d, r.getValue().doubleValue(), 0.0001);
    }

    @Test
    public void testComputeAverageGradeWithTailRecursion() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("David", 004, 90d));
        sr.addStudent(new Student("Adriana", 007, 95d));
        sr.addStudent(new Student("Paula", 000, 100d));
        Result r = sr.computeAverageGradeWithTailRecursion();
        assertEquals(95d, r.getValue().doubleValue(), 0.0001);
    }

    @Test
    public void testComputeAverageGradeWithIterativeLoop() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("David", 004, 90d));
        sr.addStudent(new Student("Adriana", 007, 95d));
        sr.addStudent(new Student("Paula", 000, 100d));
        Result r = sr.computeAverageGradeWithIterativeLoop();
        assertEquals(95d, r.getValue().doubleValue(), 0.0001);
    }

    @Test
    public void testFindStudentByNameWithHeadRecursion_Found() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));
        
        SearchResult result = new SearchResult(null);
        sr.findStudentByNameWithHeadRecursion("Bob", result);

        assertTrue(result.isFound());
        assertEquals("Bob", result.getStudent().getName());
        assertEquals(002, result.getStudent().getId());
        assertEquals(90d, result.getStudent().getGrade().doubleValue(), 0.0001);
    }

    @Test
    public void testFindStudentByNameWithHeadRecursion_NotFound() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        
        SearchResult result = new SearchResult(null);
        sr.findStudentByNameWithHeadRecursion("Diana", result);

        assertNull(result.getStudent());
    }

    @Test
    public void testFindStudentByNameWithTailRecursion_Found() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));

        SearchResult result = sr.findStudentByNameWithTailRecursion("Bob");

        assertTrue(result.isFound());
        assertEquals("Bob", result.getStudent().getName());
        assertEquals(002, result.getStudent().getId());
        assertEquals(90d, result.getStudent().getGrade().doubleValue(), 0.0001);
    }

    @Test
    public void testFindStudentByNameWithTailRecursion_NotFound() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Charlie", 003, 88d));

        SearchResult result = sr.findStudentByNameWithTailRecursion("Diana");

        assertNull(result.getStudent());
    }

    @Test
    public void testFindStudentByNameWithIterativeLoop_Found() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));

        SearchResult result = sr.findStudentByNameWithIterativeLoop("Charlie");

        assertTrue(result.isFound());
        assertEquals("Charlie", result.getStudent().getName());
        assertEquals(003, result.getStudent().getId());
        assertEquals(88d, result.getStudent().getGrade().doubleValue(), 0.0001);
    }

    @Test
    public void testFindStudentByNameWithIterativeLoop_NotFound() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));

        SearchResult result = sr.findStudentByNameWithIterativeLoop("Diana");

        assertNull(result.getStudent());
    }

    @Test
    public void testSearchByNameNicely_Found() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));
        
        Student result = sr.searchByNameNicely("Bob");

        assertEquals("Bob", result.getName());
        assertEquals(002, result.getId());
        assertEquals(90d, result.getGrade().doubleValue(), 0.0001);
    }

    @Test
    public void testSearchByNameNicely_NotFound() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));
        
        Student result = sr.searchByNameNicely("Diana");

        assertNull(result);
    }

    @Test
    public void testSearchByNameNicely_CaseSensitive() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));
        
        Student result = sr.searchByNameNicely("bob"); // lowercase "bob"
        
        assertNull(result); // Expect null due to case sensitivity
    }

    @Test
    public void testSearchByNameNicely_SameNameDifferentId() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Bob", 004, 92d)); // Different ID but same name
        
        Student result = sr.searchByNameNicely("Bob");

        // Ensure the result is the first "Bob" student in the sorted list
        assertEquals("Bob", result.getName());
        assertEquals(002, result.getId());
        assertEquals(90d, result.getGrade().doubleValue(), 0.0001);
    }

    @Test
    public void testSearchByNameNicely_EmptySearchString() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        
        Student result = sr.searchByNameNicely("");

        assertNull(result); // No match expected for an empty search string
    }

    @Test
    public void testSearchByNameNicely_NullSearchString() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Alice", 001, 85d));
        
        // Assuming the method should handle null and return null if search string is null
        Student result = sr.searchByNameNicely(null);

        assertNull(result);
    }

    @Test
    public void testSearchByNameNicely_FailsWithoutSorting() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Charlie", 003, 88d));
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        
        // Attempt to find "Bob" without sorting the list first
        Student result = sr.searchByNameNicely("Bob");

        // This assertion should fail because the list is unsorted and binarySearch won't work correctly
        assertEquals("Bob", result.getName());
    }

    @Test
    public void testSearchByNameNicely_FailsWithoutSortingForSure() {
        StudentRoster<?> sr = StudentRoster.createVectorRoster();
        sr.addStudent(new Student("Zoe", 004, 78d));   // Placed last but lexically comes first
        sr.addStudent(new Student("Alice", 001, 85d));
        sr.addStudent(new Student("Bob", 002, 90d));
        sr.addStudent(new Student("Charlie", 003, 88d));
        
        // Attempt to find "Zoe" without sorting the list first
        Student result = sr.searchByNameNicely("Zoe");

        assertEquals("Zoe", result.getName());
    }
    
}
