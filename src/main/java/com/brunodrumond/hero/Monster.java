package com.brunodrumond.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;

import java.util.List;
import java.util.Random;

public class Monster extends Element{

    private Random random = new Random();
    public Monster(int x, int y){
        super(x,y);
    }

    public void move(List<Wall> walls, Position hero){
        Position p = position;
        if (random.nextBoolean()){
            if (random.nextBoolean()){ // vertical
                if (random.nextBoolean()){ // up
                    p = new Position(position.getX(), position.getY() - 1);
                }
                else{ // down
                    p = new Position(position.getX(), position.getY() + 1);
                }
            }
            else{
                if (random.nextBoolean()){ // left
                    p = new Position(position.getX() - 1, position.getY());
                }
                else{ // right
                    p = new Position(position.getX() + 1, position.getY());
                }
            }
        }
        else{
            int dx = hero.getX() - position.getX();
            int dy = hero.getY() - position.getY();
            if (Math.abs(dx) > Math.abs(dy) && dx != 0){
                p.setX(p.getX()+(dx/Math.abs(dx)));
            }
            else if(dy != 0){
                p.setY(p.getY()+(dy/Math.abs(dy)));
            }
        }

        boolean canMonsterMove = true;
        for (Wall wall : walls){
            if (wall.getPosition().equals(p)){
                canMonsterMove = false;
                break;
            }
        }
        if (canMonsterMove){
            position = p;
        }
    }
    @Override
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#FF0000"));
        graphics.fillRectangle(new TerminalPosition(position.getX(), position.getY()), new TerminalSize(1, 1), ' ');
    }
}