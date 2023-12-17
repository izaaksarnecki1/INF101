package Lab3.src.main.java.no.uib.inf101.terminal;

public interface Command {

    String run(String[] args);
    String getName();
}
