package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

import java.awt.*;

public class Grid {

    private int cols;
    private int rows;
    private int cellSize = 20;
    private int PADDING = 10;

    public Grid(int col, int row) {
        this.cols = col;
        this.rows = row;
    }

    public void init() {
        Rectangle rectangle = new Rectangle(PADDING, PADDING, getWidth(), getHeight());
        rectangle.setColor(Color.BLACK);
        rectangle.draw();

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                int getX = PADDING + j * cellSize;
                int getY = PADDING + i * cellSize;
                Rectangle rectangleInt = new Rectangle(getX, getY, cellSize, cellSize);
                rectangleInt.setColor(Color.BLACK);
                rectangleInt.draw();
            }
        }
    }

    public int getWidth() {
        return cols * cellSize;
    }

    public int getHeight() {
        return rows * cellSize;
    }

    public int getCellSize() {
        return cellSize;
    }

    public int getPADDING() {
        return PADDING;
    }

    public int getCols() {
        return cols;
    }

    public int getRows() {
        return rows;
    }


}
