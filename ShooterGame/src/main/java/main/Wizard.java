
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
        
        collision();
//        
//        if(handler.isUp()) velocityY = -5;
//        else if(!handler.isDown()) velocityY = 0;
//        if(handler.isDown()) velocityY = 5;
//        else if(!handler.isUp()) velocityY = 0;
//        if(handler.isRight()) velocityX = 5;
//        else if(!handler.isLeft()) velocityX = 0;
//        if(handler.isLeft()) velocityX = -5;
//        else if(!handler.isRight()) velocityX = 0;
          if(x < 0) x = 0;
          if(x > 10000 - 39) x = 10000 - 39;
          if(y < 0) y = 0;
          if(y > 10000 - 60) y = 10000 - 60;
    }
    
    private void collision(){
        for(int i = 0; i < handler.object.size(); i++){
            GameObject tempObject = handler.object.get(i);
            //use intersecting method
            if(tempObject.getId() == ID.Block){
                if(getBounds().intersects(tempObject.getBounds())){
                    x += velocityX * -1;
                    y += velocityY * -1;
                }
                }
        }}

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 48);
    }

    public Rectangle getBounds() {
        return new Rectangle(x, y, 32, 48);
    }
    
}
