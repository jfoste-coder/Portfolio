/**
 * Part of taskmanager package
 */
package taskmanager;


/**
 * @author Jeremy Foster
 * @version 1.0.0
 */

/**
 * Start of Task class
 */
public class Task {

    //fields
    private int id;
    private String title;
    private String description;

    /**
     * constructor for task class
     * @param id
     * @param title
     * @param description
     * takes three paramteres to create task object
     */
    public Task(int id, String title, String description) {
        this.id = id;
        this.title = title;
        this.description = description;
    }

    // Getters
    /**
     * method to return id
     * 
     * @return id value
     */
    public int getID(){return id;}
    /**
     * method to return title
     * 
     * @return title value
     */
    public String getTitle(){return title;}
    /**
     * method to return description
     * 
     * @return desctiption
     */
    public String getDesc(){return description;}

    // setters
    /**
     * method to set id
     * 
     * @param id value
     */
    public void setID(int id){this.id = id;}
    /**
     * method to set title
     * 
     * @param title value
     */
    public void setTitle(String title){this.title = title;}
    /**
     * method to set description
     * 
     * @param description value
     */
    public void setDesc(String desc){this.description = desc;}

    



    @Override
    public String toString() {
        return "Task #" + id + ": " + title + "\nDescription: " + description + "\n" ;
    }
}
