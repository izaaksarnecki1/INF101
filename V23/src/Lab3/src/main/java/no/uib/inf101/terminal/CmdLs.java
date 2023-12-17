package Lab3.src.main.java.no.uib.inf101.terminal;

import java.io.File;

public class CmdLs implements Command{

    Context context;
    @Override
    public String run(String[] args) {
        File cwd = this.context.getCwd();
        String s = "";
        for (File file : cwd.listFiles()) {
            s += file.getName();
            s += " ";
        }
        return s;
    }

    @Override
    public String getName() {
        return "ls";
    }

    @Override
    public setContext
}
