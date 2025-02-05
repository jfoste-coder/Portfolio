package _1legacy;

import java.util.EventObject;

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
