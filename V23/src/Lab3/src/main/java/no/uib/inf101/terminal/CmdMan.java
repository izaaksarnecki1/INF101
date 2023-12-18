package Lab3.src.main.java.no.uib.inf101.terminal;

import java.util.HashMap;

public class CmdMan implements Command{
    HashMap<String, Command> allCommands;

    @Override
    public String getManual() {
        return "Returns the manual of command.";
    }

    @Override
    public String run(String[] args) {
        if (args.length == 0) {
          return "No argument provided";
        } else if (!this.allCommands.containsKey(args[0])) {
            return "'" + args[0] + "' command not found";
        } else return this.allCommands.get(args[0]).getManual();
    }

    @Override
    public String getName() {
        return "man";
    }

    @Override
    public void setCommandContext(HashMap<String, Command> allCommands) {
        this.allCommands = allCommands;
    }
}
