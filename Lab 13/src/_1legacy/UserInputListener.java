package _1legacy;

import java.util.EventListener;

public interface UserInputListener extends EventListener{
    void userInputChanged(UserInputEvent event);
}
