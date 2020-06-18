package main;
import java.awt.Graphics;import java.awt.Rectangle;
public abstract class GameObject {
    protected int x, y;
    protected int velocityX, velocityY; //speed in x and y direction 
//contructor for game object:
    public GameObject(int x, int y){
        this.x = x;
        this.y = y;
    }  //abstract class will need to be in player and enemy class.
    public abstract void tick();
    public abstract void render(Graphics g);
    //new intersect method 
    public abstract Rectangle getBounds();
    public void setX(int x){     //setter and getter methods
        this.x = x;
    }
    public void setY(int y){
        this.y = y;
    }
    public int getY(){
        return y;
    }
    public int getX(){
        return x;
    }

    public void setvelocityX(int velocityX){
        this.velocityX = velocityX;
    }
    public  void setvelocityY(int velocityY){
        this.velocityY = velocityY;
    }     //get the velocity x and y 
    public int getvelocityX(){
        return velocityX;
    }
    public int getvelocityY(){
        return velocityY;
    }
}