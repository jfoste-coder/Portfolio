package _3anonymous_classes;

import java.util.EventListener;
import java.util.EventObject;
import java.util.Scanner;

/**
 * The main application class that reads user input and triggers events.
 * It implements the UserInputListener interface directly.
 */
public class UserInputApp {

    UserInputListener userInput = new UserInputListener() {
        StringBuilder cumulativeInput = new StringBuilder();

        /**
         * Handles the user input event by printing out the cumulative input.
         *
         * @param event the user input event
         */
        public void userInputChanged(UserInputEvent event) {
            System.out.println("Cumulative Input: " + event.getUserInput());
        }
    };

    public class UserInputEvent extends EventObject{
        private final Object userInput;
        public UserInputEvent(Object source, Object userInput){
            super(source);
            this.userInput = userInput;
        }
        public Object getUserInput(){
            return userInput;
        }
    }

    public interface UserInputListener extends EventListener{
        void userInputChanged(UserInputEvent event);
    }

    StringBuilder cumulativeInput = new StringBuilder();



    

    /**
     * Handles the user input event by printing out the cumulative input.
     *
     * @param event the user input text
     */
    public void captureInput(String input) {
        if (cumulativeInput.length() > 0) {
            cumulativeInput.append(" ");
        }
        cumulativeInput.append(input);
        UserInputEvent event = new UserInputEvent(this, cumulativeInput.toString());
        userInput.userInputChanged(event);
    }

    /**
     * The render method reads input from the user and notifies itself as the
     * listener.
     */
    public void render() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter input (type ':q!' to quit):");
        while (true) {
            String input = scanner.nextLine();
            if (input.equals(":q!")) {
                System.out.println("Exiting.");
                break;
            }
            captureInput(input);
        }
        scanner.close();
    }
}