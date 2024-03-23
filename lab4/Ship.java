package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;


public class Ship{
    private final int WIDTH = 70;
    private final int HEIGHT = 20;
    private final int INITIAL_HEALTH = 3;
    private final int INITIAL_SCORE = 0;

    private String name;
    private Color color = Color.YELLOW;

    private Rectangle ship; 

    private int locX;
    private int locY;
    private int health;
    private int score;

    public Ship(String name){
        this.name = name;
        locX = 0;
        locY = 0;
        ship = new Rectangle(locX, locY, WIDTH, HEIGHT);
        this.health = INITIAL_HEALTH;
        this.score = INITIAL_SCORE;
    }

    public void draw(int locX, int locY, Graphics g)
    {
        this.locX = locX - (WIDTH / 2);
        this.locY = locY - (HEIGHT / 2);
        ship.setRect(this.locX, this.locY, WIDTH, HEIGHT);
        g.setColor(this.color);
        g.fillRect(this.locX, this.locY, WIDTH, HEIGHT);
        g.setColor(Color.BLACK);
        g.drawString(name, locX - (WIDTH / 5) , locY);
    }

    public Rectangle getRectangle(){
        return this.ship;
    }

    public int getHealth(){
        return this.health;
    }

    public int getScore(){
        return this.score;
    }

    public void decraseHealth(){
        this.health--;
        
    }

    public void increaseScore(){
        this.score++;
    }
}
