package org.codeforall.iorns;

import org.academiadecodigo.simplegraphics.graphics.Color;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;
import org.academiadecodigo.simplegraphics.keyboard.Keyboard;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEvent;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardEventType;
import org.academiadecodigo.simplegraphics.keyboard.KeyboardHandler;

import java.util.ArrayList;
import java.util.List;

public class Player implements KeyboardHandler {

    Grid grid = new Grid(20, 25);

    private Rectangle player;
    private List<Rectangle> paintRectangle = new ArrayList<>();

    public Player() {
        player = new Rectangle(grid.getPADDING(), grid.getPADDING(), grid.getCellSize(), grid.getCellSize());
        player.setColor(Color.BLUE);
        player.fill();
    }

    public void paint() {
        Rectangle rectangle = new Rectangle(player.getX(), player.getY(), player.getWidth(), player.getHeight());
        paintRectangle.add(rectangle);
        rectangle.fill();
    }

    public void delete() {
        for (Rectangle painted : paintRectangle) {
            if (painted.getX() == player.getX() && painted.getY() == player.getY() &&
                    painted.getWidth() == player.getWidth() && painted.getHeight() == player.getHeight()) {
                paintRectangle.remove(painted);
                painted.draw();
                break;
            }
        }
    }

    public boolean isPainted() {
        for (Rectangle paintedRect : paintRectangle) {
            if (paintedRect.getX() == player.getX() && paintedRect.getY() == player.getY() &&
                    paintedRect.getWidth() == player.getWidth() && paintedRect.getHeight() == player.getHeight()) {
                return true;
            }
        }
        return false;
    }

    public void init() {

        Keyboard kb = new Keyboard(this);

        KeyboardEvent right = new KeyboardEvent();
        right.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        right.setKey(KeyboardEvent.KEY_RIGHT);

        kb.addEventListener(right);

        KeyboardEvent left = new KeyboardEvent();
        left.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        left.setKey(KeyboardEvent.KEY_LEFT);

        kb.addEventListener(left);

        KeyboardEvent up = new KeyboardEvent();
        up.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        up.setKey(KeyboardEvent.KEY_UP);

        kb.addEventListener(up);

        KeyboardEvent down = new KeyboardEvent();
        down.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        down.setKey(KeyboardEvent.KEY_DOWN);

        kb.addEventListener(down);

        KeyboardEvent space = new KeyboardEvent();
        space.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        space.setKey(KeyboardEvent.KEY_SPACE);

        kb.addEventListener(space);

        KeyboardEvent save = new KeyboardEvent();
        save.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        save.setKey(KeyboardEvent.KEY_S);

        kb.addEventListener(save);

        KeyboardEvent load = new KeyboardEvent();
        load.setKeyboardEventType(KeyboardEventType.KEY_PRESSED);
        load.setKey(KeyboardEvent.KEY_L);

        kb.addEventListener(load);
    }


    @Override
    public void keyPressed(KeyboardEvent keyboardEvent) {

        switch (keyboardEvent.getKey()) {
            case KeyboardEvent.KEY_RIGHT:
                if (player.getX() <= grid.getWidth() - grid.getCellSize())
                    player.translate(20, 0);
                break;

            case KeyboardEvent.KEY_LEFT:
                if (player.getX() >= grid.getCols())
                    player.translate(-20, 0);
                break;

            case KeyboardEvent.KEY_UP:
                if (player.getY() >= grid.getRows())
                    player.translate(0, -20);
                break;

            case KeyboardEvent.KEY_DOWN:
                if (player.getY() <= grid.getHeight() - grid.getCellSize())
                    player.translate(0, 20);
                break;

            case KeyboardEvent.KEY_SPACE:
                if (isPainted()) {
                    delete();
                } else {
                    paint();
                }
                break;

        }
    }


    @Override
    public void keyReleased(KeyboardEvent keyboardEvent) {

    }
}
