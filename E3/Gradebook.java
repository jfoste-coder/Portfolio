/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;


/**
 * A Gradebook class that manages a collection of StudentGrades and provides functionality
 * to calculate average grades, find the minimum and maximum grades, and determine the median.
 * This class implements the Comparator interface to compare StudentGrades objects.
 */
public class Gradebook implements Comparator<StudentGrades>{

	private Collection<StudentGrades> grades;

	public Gradebook(){
		this.grades = new ArrayList<StudentGrades>();
	}

	public void addGrade(StudentGrades sg){
		grades.add(sg);
	}

	/**
     * Calculates the average score of all students in the gradebook.
     *
     * @return the average score as a double.
     */
    public double average() {
        double total = 0; // Accumulator for the total score.
        double count = 0; // Counter for the number of students.

        // Iterate through each student's grades to calculate the total score and count.
        for (StudentGrades student : grades) {
            total += student.totalScore();
            count++;
        }

        // Calculate and return the average score.
        return total / count;
    }

    /**
     * Finds the student with the minimum total score.
     *
     * @return the StudentGrades object with the minimum total score.
     */
    public StudentGrades min() {
        StudentGrades min = null; // Variable to store the student with the minimum score.
        Iterator<StudentGrades> iterator = grades.iterator();

        // Initialize min to the first student if the collection is not empty.
        if (iterator.hasNext()) {
            min = iterator.next();
        }

        // Compare the scores of all students to find the minimum.
        while (iterator.hasNext()) {
            StudentGrades current = iterator.next();
            if (compare(current, min) < 0) {
                min = current;
            }
        }

        return min;
    }

    /**
     * Finds the student with the maximum total score.
     *
     * @return the StudentGrades object with the maximum total score.
     */
    public StudentGrades max() {
        StudentGrades max = null; // Variable to store the student with the maximum score.
        Iterator<StudentGrades> iterator = grades.iterator();

        // Initialize max to the first student if the collection is not empty.
        if (iterator.hasNext()) {
            max = iterator.next();
        }

        // Compare the scores of all students to find the maximum.
        while (iterator.hasNext()) {
            StudentGrades current = iterator.next();
            if (compare(current, max) > 0) {
                max = current;
            }
        }

        return max;
    }

    /**
     * Finds the median student based on total scores.
     * The median is the middle value when all scores are sorted.
     *
     * @return the StudentGrades object representing the median.
     */
    public StudentGrades median() {
        // Convert the collection of grades into a list and sort it using this comparator.
        ArrayList<StudentGrades> gradeList = new ArrayList<>(this.grades);
        Collections.sort(gradeList, this);

        // Return the middle element of the sorted list.
        return gradeList.get((gradeList.size() - 1) / 2);
    }

	@Override
	public int compare(StudentGrades left, StudentGrades right){
		return (int)(left.totalScore()-right.totalScore());
	}

	//provided
	@Override
	public String toString(){
		String rv = "Grades: [ ";
		for(StudentGrades sg : grades){
			rv += "("+sg.getStudentName()+": "+sg.letterGrade()+"), ";
		}
		rv += "]\n";
		rv += "Max: "+max()+", Median: "+median()+", Average: "+average()+", Min: "+min();
		return rv;
	}

}