package Lab3.src.main.java.no.uib.inf101.terminal;

import java.util.HashMap;
import java.util.Map;

public interface Command {
    String getManual();
    String run(String[] args);
    String getName();
    default void setContext(Context context) { /* do nothing */ };

    default void setCommandContext(HashMap<String, Command> allCommands) {
        /* Do nothing */
    };

}
