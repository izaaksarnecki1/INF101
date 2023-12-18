package Lab3.src.main.java.no.uib.inf101.terminal;

public class CmdPwd implements Command{

    Context context;

    @Override
    public String getManual() {
        return "Prints the current working directory to the terminal.";
    }

    @Override
    public String run(String[] args) {
        return this.context.getCwd().getAbsolutePath();
    }

    @Override
    public String getName() {
        return "pwd";
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}
