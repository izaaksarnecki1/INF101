package Lab3.src.main.java.no.uib.inf101.terminal;

public class CmdEcho implements Command{
    @Override
    public String run(String[] args) {
        String ret = "";
        for (String s : args) {
            ret += s + " ";
        }
        return ret;
    }

    @Override
    public String getName() {
        return "echo";
    }
}
