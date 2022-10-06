package com.brunodrumond.hero;

import java.io.IOException;

public class Application {
    public static void main(String[] args) throws IOException{
        try {
            Game game = new Game();
            game.run();
        }
        catch (IOException e){
            e.printStackTrace();
        }
    }
}