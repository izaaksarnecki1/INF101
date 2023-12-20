package Lab4.src.main.java.no.uib.inf101.gridview;

import Lab4.src.main.java.no.uib.inf101.colorgrid.CellColor;
import Lab4.src.main.java.no.uib.inf101.colorgrid.CellColorCollection;
import Lab4.src.main.java.no.uib.inf101.colorgrid.CellPosition;
import Lab4.src.main.java.no.uib.inf101.colorgrid.IColorGrid;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

public class GridView extends JPanel {
    private static final double OUTERMARGIN = 30;
    private static final Color MARGINCOLOR = Color.LIGHT_GRAY;
    IColorGrid colorGrid;

    public GridView(IColorGrid colorGrid) {
        this.colorGrid = colorGrid;
        int width = 400;
        int height = 300;
        this.setPreferredSize(new Dimension(width, height));
    }

    @Override
    public void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        Graphics2D graphics2D = (Graphics2D) graphics;
        drawGrid(graphics2D);
    }

    private void drawGrid(Graphics2D graphics2D) {
        double margin = OUTERMARGIN;
        double x = OUTERMARGIN;
        double y = OUTERMARGIN;
        double width = this.getWidth() - 2 * margin;
        double height = this.getHeight() - 2 * margin;
        Rectangle2D bg = new Rectangle2D.Double(x, y, width, height);
        graphics2D.setColor(MARGINCOLOR);
        graphics2D.fill(bg);

        CellPositionToPixelConverter cpx = new CellPositionToPixelConverter(bg, this.colorGrid, OUTERMARGIN);
        drawCells(graphics2D, this.colorGrid, cpx);
    }

    private static void drawCells(Graphics2D g2d, CellColorCollection ccc, CellPositionToPixelConverter cpx) {
        for (CellColor cell : ccc.getCells()) {
            CellPosition cp = new CellPosition(cell.cellPosition().row(), cell.cellPosition().col());
            if (cell.color() == null) {
                g2d.setColor(Color.DARK_GRAY);
                g2d.fill(cpx.getBoundsForCell(cp));
            } else {
                g2d.setColor(cell.color());
                g2d.fill(cpx.getBoundsForCell(cp));
            }
        }
    }
}
