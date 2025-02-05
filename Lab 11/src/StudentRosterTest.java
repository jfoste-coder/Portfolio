import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;

/**
 * Test class for comparing performance between different StudentRoster
 * implementations for computing GPA.
 * 
 * Notice how much code duplication there is in the tests
 */
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

}
