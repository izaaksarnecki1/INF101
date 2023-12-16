package Lab3.src.main.java.no.uib.inf101.terminal;

// UiB INF101 ShellLab - Main.java
// Dette er filen som inneholder main-metoden.

import no.uib.inf101.terminal.EchoShell;

public class Main {

  public static void main(String[] args) {
    // Create a new shell
    CommandLineInterface shell = new EchoShell();

    // Run the shell in the terminal GUI
    Terminal gui = new Terminal(shell);
    gui.run();
  }
}