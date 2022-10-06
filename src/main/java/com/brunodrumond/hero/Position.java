package com.brunodrumond.hero;

public class Position {
    public Position (int x, int y){
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
}
