package com.brunodrumond.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

public class Wall {
    private int x_;
    private int y_;
    public Wall (int x, int y){
        x_ = x;
        y_ = y;
    }

    public int getX_() {
        return x_;
    }

    public int getY_() {
        return y_;
    }

    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#000000"));
        graphics.fillRectangle(new TerminalPosition(x_, y_), new TerminalSize(1, 1), ' ');
    }
}
