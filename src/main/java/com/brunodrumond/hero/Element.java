package com.brunodrumond.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public abstract class Element {
    protected Position position;
    public Element (int x, int y){
        position = new Position(x, y);
    }

    public int getX_() {
        return position.getX();
    }

    public int getY_() {
        return position.getY();
    }

    public abstract void draw(TextGraphics graphics);
}
