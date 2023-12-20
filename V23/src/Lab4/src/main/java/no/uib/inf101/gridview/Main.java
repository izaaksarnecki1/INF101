package Lab4.src.main.java.no.uib.inf101.gridview;

import Lab4.src.main.java.no.uib.inf101.colorgrid.CellPosition;
import Lab4.src.main.java.no.uib.inf101.colorgrid.ColorGrid;
import Lab4.src.main.java.no.uib.inf101.colorgrid.IColorGrid;

import javax.swing.*;
import java.awt.*;

public class Main {
  public static void main(String[] args) {
    ColorGrid colorGrid = new ColorGrid(3, 4);
    colorGrid.set(new CellPosition(0,0), new Color(255,0,0));
    colorGrid.set(new CellPosition(0,3), new Color(0,0,255));
    colorGrid.set(new CellPosition(2,0), new Color(255, 255,0));
    colorGrid.set(new CellPosition(2,3), new Color(0,255,0));
    GridView gv = new GridView(colorGrid);
    JFrame jFrame = new JFrame();

    jFrame.setContentPane(gv);
    jFrame.setTitle("Color Grid");
    jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jFrame.pack();
    jFrame.setVisible(true);
  }
}
