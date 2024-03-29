package com.brunodrumond.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.screen.Screen;

public class Hero extends Element {
    public Hero(int x, int y){
        super(x,y);
    }
    @Override
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FFFFFF"));
        graphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(1, 1), ' ');
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public Position moveUp(){
        return new Position(position.getX(), position.getY()-1);
    }

    public Position moveDown(){
        return new Position(position.getX(), position.getY()+1);
    }

    public Position moveLeft(){
        return new Position(position.getX()-1, position.getY());
    }

    public Position moveRight(){
        return new Position(position.getX()+1, position.getY());
    }
}
