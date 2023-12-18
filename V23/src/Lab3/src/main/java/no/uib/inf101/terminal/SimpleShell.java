package Lab3.src.main.java.no.uib.inf101.terminal;

// UiB INF101 ShellLab - SimpleShell.java
//
// Dette er klassen vi skal forbedre i denne lab'en. Slik koden er
// allerede før du begynner på laben, støtter den tre kommandoer:
//
// - cd: Bytt til en annen mappe
// - ls: List opp filer i mappen
// - pwd: Vis sti til nåværende mappe
//
// Vi skal endre denne klassen slik at den
// - kan vises av Terminal.java
// - kan støtte ubegrenset mange kommandoer

import java.io.File;
import java.util.*;

public class SimpleShell implements CommandLineInterface{

  //////////////////////////////////////////////////////////////////////
  /// Instance variables ///////////////////////////////////////////////
  //////////////////////////////////////////////////////////////////////

  /** The prompt to show before each command */
  private final String prompt = "$ ";
  /** The context variable contains cwd and home directories etc. */
  private final Context context = new Context();
  /** A list of historic commands and their outputs */
  private final List<String> history = new ArrayList<>();
  /** The command currently being typed */
  private String currentCommand = "";

  private final HashMap<String, Command> allCommands = new HashMap<>();

  //////////////////////////////////////////////////////////////////////
  /// Public instance methods                                     //////
  /// (methods expected to be used by someone outside this class) //////
  //////////////////////////////////////////////////////////////////////

  /** Constructor for SimpleShell */
  public SimpleShell() {
    this.installCommand(new CmdLs());
    this.installCommand(new CmdPwd());
    this.installCommand(new CmdCd());
    this.installCommand(new CmdMan());
  }

  @Override
  public void keyPressed(char key) {
    if (key == '\n') {
      this.processCurrentCommandLine();
    } else if (key >= ' ' && key <= '~') {
      this.currentCommand += key;
    } else {
      // Some special key was pressed (e.g. shift, ctrl), we ignore it
    }
  }

  @Override
  public String getScreenContent() {
    String s = "";
    for (String line : this.history) {
      s += line;
    }
    s += this.prompt;
    s += this.currentCommand;
    return s;
  }

  public void installCommand(Command command) {
    command.setCommandContext(this.allCommands);
    command.setContext(this.context);
    this.allCommands.put(command.getName(), command);
  }
  //////////////////////////////////////////////////////////////////////
  /// Private methods                                ///////////////////
  /// (helper methods used internally in this class) ///////////////////
  //////////////////////////////////////////////////////////////////////

  private void processCurrentCommandLine() {
    String result = "";
    if (!this.currentCommand.isEmpty()) {
      String[] args = this.currentCommand.split(" ");
      String commandName = args[0];
      String[] commandArgs = new String[args.length - 1];
      System.arraycopy(args, 1, commandArgs, 0, commandArgs.length);
      result = this.executeCommand(commandName, commandArgs);
      if (!result.isEmpty() && result.charAt(result.length() - 1) != '\n') {
        result += '\n';
      }
    }
    this.history.add(this.prompt + this.currentCommand + "\n" + result);
    this.currentCommand = "";
  }

  /**
   * Execute a command with the given name and arguments. The command
   * name could be "ls", "cd", "pwd", etc., and the arguments are the
   * arguments to the command. For example for the command "cd foo", the
   * command name is "cd" and the argument comes in the array ["foo"].
   *
   * @param commandName  The name of the command to execute
   * @param args  The arguments to the command
   * @return  The output of the command
   */
  private String executeCommand(String commandName, String[] args) {
    if (this.allCommands.containsKey(commandName)) {
      return this.allCommands.get(commandName).run(args);
    } else {
      return "Command not found: \"" + commandName + "\"";
    }
  }
}
