package main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.nio.Buffer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Game extends Canvas implements Runnable{
    
    private boolean isRunning = false;
    private Thread thread;
    private Handler handler;
    
    public Game(){
        new Window(1000, 563, "Shooter game", this);
        start();
        
        handler = new Handler();
        handler.addObject(new Box(100, 100));
    }
    
    private void start(){
        isRunning = true;
        thread = new Thread(this);
        thread.start();
        
    }
    
    private void stop(){
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException ex) {
        }
    }
    
    public void run(){
              
      this.requestFocus();
      long lastTime = System.nanoTime(); // get current time to the nanosecond
      double amountOfTicks = 60.0; // set the number of ticks 
      //divide 60 into 1e9 of nano seconds or about 1 second
      double nanoseconds = 1000000000 / amountOfTicks; 
      double delta = 0;
      long timer = System.currentTimeMillis(); // get current time
      int frames = 0; // set frame variable
      while(isRunning) {
      // get current time in nonoseconds durring current loop
       long now = System.nanoTime(); 
       delta += (now - lastTime) / nanoseconds; //add the amount of change 
       //since the last loop
       lastTime = now; // set lastTime to now to prepare for next loop
       while(delta >= 1) {
        tick();
        delta--;
       }
       if(isRunning){
            render();  // render visuals of the game
       frames++; //frame has passed
       }
       if(System.currentTimeMillis() - timer > 1000) { //if one second has passed
        timer += 1000;  // add a thousand to our timer for next time
        frames = 0;  // reset frame count for the next second
  
       }
      }
      stop(); // no longer running stop the thread
        
    }
    public void tick(){
        
        handler.tick();
    }
    private void render() {
        BufferStrategy b = this.getBufferStrategy();
        if (b == null){
            this.createBufferStrategy(3);
            return;
        }
        Graphics g = b.getDrawGraphics();
        //window colour
        g.setColor(Color.red);
        g.fillRect(0, 0, 1000, 563);
        
        handler.render(g);
        
        
        g.dispose();
        b.show();
        
        
    }
    
    public static void main(String[] args) {
        new Game();
    }
    
}
