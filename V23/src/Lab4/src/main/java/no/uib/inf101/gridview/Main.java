package Lab4.src.main.java.no.uib.inf101.gridview;

import Lab4.src.main.java.no.uib.inf101.colorgrid.CellPosition;
import Lab4.src.main.java.no.uib.inf101.colorgrid.ColorGrid;
import Lab4.src.main.java.no.uib.inf101.colorgrid.IColorGrid;

import java.awt.*;

public class Main {
  public static void main(String[] args) {
    // Opprett et rutenett med 3 rader og 4 kolonner
    IColorGrid grid = new ColorGrid(3, 4);
    System.out.println(grid.rows()); // forventer 3
    System.out.println(grid.cols()); // forventer 4

// Sjekk at standard-verdien er null
    System.out.println(grid.get(new CellPosition(1, 2))); // forventer null

// Sjekk at vi kan endre verdien på en gitt posisjon
    grid.set(new CellPosition(1, 2), Color.RED);
    System.out.println(grid.get(new CellPosition(1, 2))); // forventer rød
    System.out.println(grid.get(new CellPosition(2, 1))); // forventer null

  }
}
