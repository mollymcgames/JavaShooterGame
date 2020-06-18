/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Box extends GameObject{
    
   public Box(int x, int y){
        super(x, y);
        velocityX = 1;
        
   }

    public void tick() {
        x += velocityX;
        y += velocityY;
    }

    public void render(Graphics g) {
        g.setColor(Color.blue);
        g.fillRect(x, y, 32, 32);
    }

    public Rectangle getBounds() {
        return null;
    }
    
}
