package main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable{
    public Game(){
        new Window(1000, 563, "Shooter game", this);
    }
    
    public void run(){
    }
    
    public static void main(String[] args) {
        new Game();
    }
    
}
