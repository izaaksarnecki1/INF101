package Lab4.src.main.java.no.uib.inf101.colorgrid;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class ColorGrid implements IColorGrid{
    private Integer row = null;
    private Integer col = null;
    private ArrayList<CellColor> grid;

    public ColorGrid(Integer row, Integer col) {
        this.grid = new ArrayList<CellColor>();
        this.row = row;
        this.col = col;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                grid.add(new CellColor(new CellPosition(r,c), null));
                int pos = r * col + c;
            }
        }
    }

    @Override
    public List<CellColor> getCells() {
        return this.grid;
    }

    @Override
    public int rows() {
        return this.row;
    }

    @Override
    public int cols() {
        return this.col;
    }

    @Override
    public Color get(CellPosition pos) {
        this.checkBounds(pos);
        return this.grid.get(pos.row()*this.col + pos.col()).color();
    }

    @Override
    public void set(CellPosition pos, Color color) {
        this.checkBounds(pos);
        grid.set(pos.row()*col + pos.col(), new CellColor(pos, color));
    }

    private void checkBounds(CellPosition pos) {
        if (pos.row() >= this.row || pos.col() < 0 ) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        } else if (pos.col() >= this.col || pos.row() < 0) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

    }
}
