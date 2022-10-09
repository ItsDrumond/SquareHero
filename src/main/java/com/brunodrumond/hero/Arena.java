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
import java.util.*;

public class Arena {
    private int width_;
    private int height_;
    private List<Wall> walls;
    private List<Coin> coins;
    private List<Monster> monsters;
    private Hero hero = new Hero(10, 10);
    public Arena(int width, int height){
        width_ = width;
        height_ = height;
        this.walls = createWalls();
        this.coins = createCoins(7);
        this.monsters = createMonsters(7);
    }
    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<>();
        for (int c = 0; c < width_; c++) {
            walls.add(new Wall(c, 0));
            walls.add(new Wall(c, height_- 1));
        }
        for (int r = 1; r < height_ - 1; r++) {
            walls.add(new Wall(0, r));
            walls.add(new Wall(width_ - 1, r));
        }
        return walls;
    }

    public boolean canHeroMove(Position position){
        for (Wall wall : walls){
            if(wall.getPosition().equals(position)){
                return false;
            }
        }
        for (Coin coin : coins){
            if(coin.getPosition().equals(position)){
                coins.remove(coin);
                break;
            }
        }
        return true;
    }

    public void moveHero(Position position){
        if (canHeroMove(position)){
            hero.setPosition(position);
            for (Monster monster : monsters){
                monster.move(walls, position);
            }
        }
    }
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
    public void draw(TextGraphics graphics){
        graphics.setBackgroundColor(TextColor.Factory.fromString("#336699"));
        graphics.fillRectangle(new TerminalPosition(0, 0), new TerminalSize(width_, height_), ' ');
        hero.draw(graphics);
        for (Wall wall : walls)
            wall.draw(graphics);
        for (Coin coin : coins)
            coin.draw(graphics);
        for (Monster monster : monsters)
            monster.draw(graphics);
    }
    private List<Coin> createCoins(int number) {
        Random random = new Random();
        ArrayList<Coin> coins = new ArrayList<>();
        for (int i = 0; i < number; i++){
            Position position_1 = new Position(random.nextInt(width_ - 2) + 1, random.nextInt(height_ - 2) + 1);
            if (position_1.equals(hero.getPosition())){
                i--;
                continue;
            }
            for(Coin c: coins){
                if(position_1.equals(c.getPosition())){
                    i--;
                    continue;
                }
            }
            coins.add(new Coin(random.nextInt(width_ - 2) + 1, random.nextInt(height_ - 2) + 1));
        }
        return coins;
    }

    private List<Monster> createMonsters(int number) {
        Random random = new Random();
        ArrayList<Monster> monsters = new ArrayList<>();
        for (int i = 0; i < number; i++){
            Position position_1 = new Position(random.nextInt(width_ - 2) + 1, random.nextInt(height_ - 2) + 1);
            if (position_1.equals(hero.getPosition())){
                i--;
                continue;
            }
            for(Monster c: monsters){
                if(position_1.equals(c.getPosition())){
                    i--;
                    continue;
                }
            }
            monsters.add(new Monster(random.nextInt(width_ - 2) + 1, random.nextInt(height_ - 2) + 1));
        }
        return monsters;
    }
    public boolean verifyMonsterCollision(){
        for (Monster monster : monsters){
            if(monster.getPosition().equals(hero.getPosition())){
                return true;
            }
        }
        return false;
    }
}
