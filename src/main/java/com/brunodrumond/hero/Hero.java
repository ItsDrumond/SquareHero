package com.brunodrumond.hero;

import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.screen.Screen;

public class Hero {
    public Hero(int x, int y){
        x_ = x;
        y_ = y;
    }
    private int x_;
    private int y_;

    public int getX() {
        return x_;
    }

    public int getY() {
        return y_;
    }

    public void setX(int x_) {
        this.x_ = x_;
    }

    public void setY(int y_) {
        this.y_ = y_;
    }
    public void draw(Screen screen){
        screen.setCharacter(x_, y_, TextCharacter.fromCharacter('X') [0]);
    }
}
