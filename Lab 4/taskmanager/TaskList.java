/**
 * Part of taskmanager package
 */
package taskmanager;

/**
 * @author Jeremy Foster
 * @version 1.0.0
 */



/**
 * Start of Task List class
 */
public class TaskList{


    /**
     * fields
     */
    private Task[] tasks;
    private int size;

    /**
     * constructor
     */
    public TaskList(int items){
        tasks = new Task[items];
        size = 0;
    }


    /**
     * method to add task
     * 
     * takes in a task object and adds it to the array of tasks
     * 
     * @param Task object
     */
    public void addTask(Task task){

        // if the
        if(size < tasks.length){
            tasks[size++] = task;
        }
        else{
            System.out.println("Cannot add more tasks");
        }

    }

    /**
     * methos to display all tasks
     * 
     * this method reads and prints all tasks in task array
     * 
     * @return Task[]
     */
    public Task[] displayAllTasks(){

        // creates a new array
        Task[] displayTasks = new Task[size];

        // copies tasks form old array
        System.arraycopy(tasks, 0, displayTasks, 0, size);

        // prints tasks
        for (int i = 0; i < displayTasks.length; i++) {
            System.out.println(displayTasks[i].toString());
        }
        return displayTasks;
    }













}