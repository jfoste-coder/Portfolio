/*
* Names: Jeremy Foster
* netID: jfoste24
* G#: G01520841
* Lecture section: 004
* Lab section: 207
*/


import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;




/**
 * The StudentGrades class represents a student's grades for various
 * academic components, calculates weighted scores, and determines the final grade.
 */
public class StudentGrades {

    // Variables for storing grades
    private double participation;  // Participation grade
    private double midterm;        // Midterm grade
    private double finalExam;      // Final exam grade

    // Collections for storing grades of labs, exercises, projects, and readings
    private Collection<Double> labs;
    private Collection<Double> exercises;
    private Collection<Double> projects;

    private List<Double> readings;

    // Weights for different grade components
    private double participationWeight;
    private double readingsWeight;
    private double labsWeight;
    private double exercisesWeight;
    private double projectsWeight;
    private double midtermWeight;
    private double finalExamWeight;

    // Student details
    private String studentName;  // Student's name
    private String gNumber;      // Student's unique identifier (e.g., G-Number)

    /**
     * Constructor for the StudentGrades class.
     * 
     * @param name The name of the student.
     * @param gNumber The unique identifier for the student (e.g., G-Number).
     * @param weights An array of weights for each grade component.
     */
    public StudentGrades(String name, String gNumber, double[] weights) {
        this.studentName = name;
        this.gNumber = gNumber;
        this.readings = new ArrayList<>();
        this.labs = new ArrayList<>();
        this.exercises = new ArrayList<>();
        this.projects = new ArrayList<>();
        this.setWeights(weights); // Set the weights for grade components
    }

    // Getters and setters for grade components and student information

    // Getter for participation grade
    public double getParticipation() {
        return this.participation;
    }

    // Setter for participation grade
    public void setParticipation(double participation) {
        this.participation = participation;
    }

    // Getter for midterm grade
    public double getMidterm() {
        return this.midterm;
    }

    // Setter for midterm grade
    public void setMidterm(double midterm) {
        this.midterm = midterm;
    }

    // Getter for final exam grade
    public double getFinalExam() {
        return this.finalExam;
    }

    // Setter for final exam grade
    public void setFinalExam(double finalExam) {
        this.finalExam = finalExam;
    }

    // Getter for student name
    public String getStudentName() {
        return this.studentName;
    }

    // Setter for student name
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    // Getter for G-Number
    public String getGNumber() {
        return this.gNumber;
    }

    // Setter for G-Number
    public void setGNumber(String gNumber) {
        this.gNumber = gNumber;
    }

    // Methods to add scores to respective categories
    public void addReading(double d) {
        this.readings.add(d);
    }

    public void addLab(double d) {
        this.labs.add(d);
    }

    public void addExercise(double d) {
        this.exercises.add(d);
    }

    public void addProject(double d) {
        this.projects.add(d);
    }

    /**
     * Sets the weights for each grade component.
     * 
     * @param weights An array of weights for the components in the order:
     *                participation, readings, labs, exercises, projects, midterm, final exam.
     */
    public void setWeights(double[] weights) {
        this.participationWeight = weights[0];
        this.readingsWeight = weights[1];
        this.labsWeight = weights[2];
        this.exercisesWeight = weights[3];
        this.projectsWeight = weights[4];
        this.midtermWeight = weights[5];
        this.finalExamWeight = weights[6];
    }

    /**
     * Calculates the unweighted score for readings.
     * 
     * @return The unweighted average of reading scores after dropping the first 15 (if more than 15).
     */
    public double unweightedReadingsScore() {
        readings.sort(Comparator.naturalOrder());
        if (readings.size() < 16) {
            return 100; // Default score when there are fewer than 16 readings
        } else {
            double total = 0;
            double count = 0;
            for (int i = 15; i < readings.size(); i++) { // Skip the first 15 readings
                total += readings.get(i);
                count++;
            }
            return total / count; // Calculate the average
        }
    }

    // Similar calculation methods for labs, exercises, and projects
    public double unweightedLabsScore() {
        if (labs.isEmpty()) {
            return 100; // Default score when no labs are available
        } else {
            double total = 0;
            for (double labScore : labs) {
                total += labScore;
            }
            return total / labs.size();
        }
    }

    public double unweightedExercisesScore() {
        if (exercises.isEmpty()) {
            return 100; // Default score when no exercises are available
        } else {
            double total = 0;
            for (double exerciseScore : exercises) {
                total += exerciseScore;
            }
            return total / exercises.size();
        }
    }

    public double unweightedProjectsScore() {
        if (projects.isEmpty()) {
            return 100; // Default score when no projects are available
        } else {
            double total = 0;
            for (double projectScore : projects) {
                total += projectScore;
            }
            return total / projects.size();
        }
    }

    /**
     * Checks if the final exam score replaces the midterm score.
     * 
     * @return True if the final exam score is higher than the midterm score, false otherwise.
     */
    public boolean finalReplacesMidterm() {
        return midterm < finalExam;
    }

    /**
     * Checks if the final exam score is a passing grade.
     * 
     * @return True if the final exam score is greater than 60.0, false otherwise.
     */
    public boolean finalIsPassing() {
        return finalExam > 60.0;
    }

    /**
     * Calculates the total weighted score based on all components.
     * 
     * @return The total weighted score.
     */
    public double totalScore(){
        if(finalReplacesMidterm()){
            this.setMidterm(getFinalExam()); // Replace midterm score with final exam score if applicable
        }
        return  getParticipation() * participationWeight
        +       unweightedReadingsScore() * readingsWeight
        +       unweightedLabsScore() * labsWeight
        +       unweightedExercisesScore() * exercisesWeight
        +       unweightedProjectsScore() * projectsWeight
        +       getMidterm() * midtermWeight
        +       getFinalExam() * finalExamWeight;
    }

    /**
     * Determines the letter grade based on the total score.
     * 
     * @return The letter grade as a string.
     */
    public String letterGrade(){
        if (finalIsPassing() && totalScore() >= 98){
            return "A+";
        } else if (finalIsPassing() && totalScore() >= 92){
            return "A";
        } else if (finalIsPassing() && totalScore() >= 90){
            return "A-";
        } else if (finalIsPassing() && totalScore() >= 88){
            return "B+";
        } else if (finalIsPassing() && totalScore() >= 82){
            return "B";
        } else if (finalIsPassing() && totalScore() >= 80){
            return "B-";
        } else if (finalIsPassing() && totalScore() >= 78){
            return "C+";
        } else if (finalIsPassing() && totalScore() >= 72){
            return "C";
        } else if (finalIsPassing() && totalScore() >= 70){
            return "C-";
        } else if (finalIsPassing() && totalScore() >= 60){
            return "D";
        } else {
            return "F";
        }
    }

    /**
     * Overrides the toString() method to provide a detailed summary of the student's performance.
     * 
     * @return A string representation of the student's grades and final score.
     */
    @Override
    public String toString(){
		String rv = "Name: "+getStudentName()+"\n";
		rv += "G#: "+getGNumber()+"\n";
		rv += "Participation: "+getParticipation()+"\n";
		rv += "Readings: "+unweightedReadingsScore()+", "+readings+"\n";
		rv += "Labs: "+unweightedLabsScore()+", "+labs+"\n";
		rv += "Exercises: "+unweightedExercisesScore()+", "+exercises+"\n";
		rv += "Projects: "+unweightedProjectsScore()+", "+projects+"\n";
		rv += "Midterm: "+getMidterm()+"\n";
		rv += "Final Exam: "+getFinalExam()+"\n";
		rv += totalScore()+", "+letterGrade()+"\n";
		return rv;
	}



}
