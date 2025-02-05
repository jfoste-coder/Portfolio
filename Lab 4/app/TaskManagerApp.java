/**
 * part of the app package
 * 
 */
package app;

/**
 * import taskmanager package and classes
 */

/**
 * @author Jeremy Foster
 * @version 1.0.0
 */

import taskmanager.Task;
import taskmanager.TaskList;


/**
 * start of TaskManagerApp class
 */
public class TaskManagerApp{




    public static void main(String[] args){

        if (args.length < 1){
            System.out.println("");
            return;
        }

        int taskListSize = Integer.parseInt(args[0]);

        TaskList taskList = new TaskList(taskListSize);

        Task T1 = new Task(Integer.parseInt(args[1]), args[2], args[3]);
        Task T2 = new Task(2, "task two", "this is task two");

        taskList.addTask(T1);
        taskList.addTask(T2);

        taskList.displayAllTasks();

        

    }



}
