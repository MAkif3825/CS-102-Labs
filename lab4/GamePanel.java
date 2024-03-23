package lab4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel{
    private GameFrame frame;
    private Ship ship;
    private ArrayList<InteractableDrawing> objects;
    private Timer t;
    private MouseMotionListener listener; 

    private int cursorX;
    private int cursorY;

    private int rand;

    private boolean isGameEnd;

    public GamePanel(GameFrame frame){
        this.isGameEnd = false;
        this.frame = frame;
        this.ship = new Ship(frame.getName());
        this.objects = new ArrayList<InteractableDrawing>();
        
        listener = new MouseListener();
        this.addMouseMotionListener(listener);

        ActionListener listener2 = new TimerListener();
        t = new Timer(50, listener2);
        t.start();

        this.cursorX = 0;
        this.cursorY = 0;

        this.updateTitle();
    }

    @Override
    public void paintComponent(Graphics g)
    {
        int width = this.getWidth();
        int height = this.getHeight();

        g.setColor(Color.BLUE);
        g.fillRect(0, 0, width, height);

        ship.draw(this.cursorX, this.cursorY, g);

        if ( objects.size() > 0 )
        {
            for (InteractableDrawing object : objects) {
                object.draw(g);
            }
        }
        
    }

    public void updateTitle(){
        int health = ship.getHealth();
        int score = ship.getScore();
        this.frame.setTitle("Life: " + health + " - Score: " + score);
    }

    public Dimension getPanelSize(){
        return this.getSize();
    }

    class MouseListener implements MouseMotionListener{
        @Override
        public void mouseMoved(MouseEvent e){
            cursorX = e.getX();
            cursorY = e.getY();
            repaint();
        }

        public void mouseDragged(MouseEvent e){
            cursorX = e.getX();
            cursorY = e.getY();
            repaint();
        }
    }

    class TimerListener implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e)
        {   
            checkEndAndFinish();
            if ( !isGameEnd )
            {
                moveAndDeleteObjects();

                rand = (int)(Math.random() * 100) % 3;
                if ( rand == 1 )
                {
                    generateRandomObjects();
                }
    
                repaint();
            }
        }
    }

    public void moveAndDeleteObjects(){
        int speed  = this.frame.getSpeed();
        boolean isExceed;

        for ( int i = 0; i < objects.size(); i++)
        {   InteractableDrawing object = objects.get(i);
            isExceed = object.moveLeft(speed);
            if ( object.intersects(ship) )
            {
                checkEndAndFinish();
                object.interact(ship);
                objects.remove(i);
                this.updateTitle();
            }
            else if ( isExceed )
            {
                objects.remove(i);
            }
        }
    }

    public void generateRandomObjects(){
        int number = 1;//(int)(Math.random() * 100) % 10;
        int xCoor = (this.getWidth());
        int yCoor = (int)(Math.random() * this.getHeight());

        for ( int i = 0; i < number; i++ )
        {
            rand = (int)(Math.random() * 100) % 2;
            if ( rand == 1 )
            {
                Apple apple = new Apple(xCoor, yCoor);
                objects.add(apple);
            }
            else if( rand == 0 )
            {
                Bomb bomb = new Bomb(xCoor, yCoor);
                objects.add(bomb);
            }
        }
    }

    public void checkEndAndFinish(){
        if ( this.ship.getHealth() == 0)
        {
            int choice;
            isGameEnd = true;
            this.t.stop();
            this.removeMouseMotionListener(listener);
            choice = JOptionPane.showConfirmDialog(frame,  "Score: " + ship.getScore() + ", do you want to play again?","Select an option",
                                        JOptionPane.YES_NO_CANCEL_OPTION);

            if ( choice == JOptionPane.YES_OPTION )
            {
                this.restart();
            }
            else if ( choice == JOptionPane.NO_OPTION )
            {
                System.exit(0);;
            }
        }
    }

    public void restart(){
    /* this.listener = null;
        this.t = null;
        this.objects = null;
        this.ship = null; */
        this.frame.restart();
    }
}
