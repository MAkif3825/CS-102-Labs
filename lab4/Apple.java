package lab4;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class Apple implements InteractableDrawing{
    private int xLoc;
    private int yLoc;

    private int width = 20;
    private int height = 20;

    private Rectangle apple;

    public Apple(int x, int y)
    {
        this.xLoc = x;
        this.yLoc = y;

        this.apple = new Rectangle(xLoc, yLoc, width, height);
    }

    @Override
    public boolean intersects(Ship s) {
        return this.apple.intersects(s.getRectangle());
    }

    @Override
    public void interact(Ship s) {
        s.increaseScore();
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
        g.setColor(Color.RED);
        this.apple.setRect(xLoc, yLoc, width, height);
        g.fillRect(xLoc, yLoc, 20, 20);
    }
    
}
