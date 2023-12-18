package Lab3.src.main.java.no.uib.inf101.terminal;

public class CmdCd implements Command{

    Context context;

    @Override
    public String getManual() {
        return "Enters the given file/directory.";
    }

    @Override
    public String run(String[] args) {
        if (args.length == 0) {
            this.context.goToHome();
            return "";
        } else if (args.length > 1) {
            return "cd: too many arguments";
        }
        String path = args[0];
        if (this.context.goToPath(path)) {
            return "";
        } else {
            return "cd: no such file or directory: " + path;
        }
    }

    @Override
    public String getName() {
        return "cd";
    }

    @Override
    public void setContext(Context context) {
        this.context = context;
    }
}
