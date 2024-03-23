package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Bomb implements InteractableDrawing{
    private int xLoc;
    private int yLoc;

    private int width = 20;
    private int height = 20;

    private Rectangle bomb;

    public Bomb(int x, int y)
    {
        this.xLoc = x;
        this.yLoc = y;
        this.bomb = new Rectangle(xLoc, yLoc, width, height);
    }

    @Override
    public boolean intersects(Ship s) {
        return this.bomb.intersects(s.getRectangle());
    }

    @Override
    public void interact(Ship s) {
        s.decraseHealth();
    }

    @Override
    public boolean moveLeft(int speed) {
        boolean result = false;
        this.xLoc = this.xLoc - speed;
        
        if ( xLoc <= 0)
        {
            result = true;
        }

        return result;
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(Color.BLACK);
        this.bomb.setRect(xLoc, yLoc, width, height);
        g.fillRect(xLoc, yLoc, width, height);
    }
    
}
