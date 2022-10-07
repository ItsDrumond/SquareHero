package com.brunodrumond.hero;

import com.googlecode.lanterna.TerminalPosition;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextCharacter;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;

import java.io.IOException;

public class Arena {
    private int width_;
    private int height_;
    public Arena(int width, int height){
        width_ = width;
        height_ = height;
    }
    public void moveHero(Position position){
        hero.setPosition(position);
    }
    private Hero hero = new Hero(10, 10);
    public void processKey(KeyStroke key) throws IOException {

        if(key.getKeyType() == KeyType.ArrowUp){
            moveHero(hero.moveUp());
        }
        else if(key.getKeyType() == KeyType.ArrowDown){
            moveHero(hero.moveDown());
        }
        else if(key.getKeyType() == KeyType.ArrowLeft){
            moveHero(hero.moveLeft());
        }
        else if(key.getKeyType() == KeyType.ArrowRight){
            moveHero(hero.moveRight());
        }
    }
    public void draw(Screen screen){
        TextGraphics graphics = screen.newTextGraphics();
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width_, height_), ' ');
        hero.draw(screen);
    }
}
