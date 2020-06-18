
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Wizard extends GameObject {
    Handler handler;
    
    public Wizard(int x, int y, ID id, Handler handler){
        super(x, y, id);
        this.handler = handler;
    }

    public void tick() {
        x += velocityX;
        y += velocityY;
          if(x < 0) x = 0;
          if(x > Game.W - 39) x = Game.W - 39;
          if(y < 0) y = 0;
          if(y > Game.H - 60) y = Game.H - 60;
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 48);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
    
}
