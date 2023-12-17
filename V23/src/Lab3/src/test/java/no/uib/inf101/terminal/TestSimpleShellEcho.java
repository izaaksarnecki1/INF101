package Lab3.src.test.java.no.uib.inf101.terminal;

import Lab3.src.main.java.no.uib.inf101.terminal.CmdEcho;
import Lab3.src.main.java.no.uib.inf101.terminal.SimpleShell;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class TestSimpleShellEcho {

  @Test
  public void testEchoInSimpleShell() {
    SimpleShell shell = new SimpleShell();
    shell.installCommand(new CmdEcho());

    shell.keyPressed('e');
    shell.keyPressed('c');
    shell.keyPressed('h');
    shell.keyPressed('o');
    shell.keyPressed(' ');
    shell.keyPressed('f');
    shell.keyPressed('o');
    shell.keyPressed('o');
    shell.keyPressed(' ');
    shell.keyPressed('b');
    shell.keyPressed('a');
    shell.keyPressed('r');
    shell.keyPressed('\n');

    String expected = "$ echo foo bar\nfoo bar \n$ ";
    assertEquals(expected, shell.getScreenContent());
  }
}
