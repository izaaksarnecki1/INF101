package Lab4.src.main.java.no.uib.inf101.gridview;

import Lab4.src.main.java.no.uib.inf101.colorgrid.CellColor;
import Lab4.src.main.java.no.uib.inf101.colorgrid.CellPosition;
import Lab4.src.main.java.no.uib.inf101.colorgrid.GridDimension;

import java.awt.geom.Rectangle2D;

public class CellPositionToPixelConverter {

    final private Rectangle2D box;
    final private GridDimension gridDimension;
    final private double margin;

    public CellPositionToPixelConverter(Rectangle2D box,
                                        GridDimension gridDimension,
                                        double margin) {
        this.box = box;
        this.gridDimension = gridDimension;
        this.margin = margin;
    }


    public Rectangle2D getBoundsForCell(CellPosition cellPosition) {
        double x = box.getX();
        double y = box.getY();
        double boxWidth = box.getWidth();
        double boxHeight = box.getHeight();
        double col = cellPosition.col();
        double row = cellPosition.row();
        double cols = gridDimension.cols();
        double rows = gridDimension.rows();

        double cellWidth = (boxWidth - (this.margin * (cols + 1))) / cols;
        double cellHeight = (boxHeight - (this.margin * (rows + 1))) / rows;

        double cellX = x + (this.margin * (col + 1)) + (cellWidth * col);
        double cellY = y + (this.margin * (row + 1)) + (cellHeight * row);
        return new Rectangle2D.Double(cellX, cellY, cellWidth, cellHeight);
    }

}
