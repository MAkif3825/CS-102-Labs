package lab4;

import java.awt.Color;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{
    private final int WIDTH = 800;
    private final int HEIGHT = 800;

    private JPanel gamePanel;
    
    private String shipName;
    private int speed; 

    public GameFrame(String name, int speed){

        this.speed = speed;
        this.shipName = name;

        this.gamePanel = new GamePanel(this);
        this.add(gamePanel);

        this.setSize(WIDTH, HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    public int getSpeed(){
        return this.speed;
    }

    public String getName(){
        return this.shipName;
    }

    public void restart(){
        this.remove(gamePanel);
        this.gamePanel = new GamePanel(this);
        this.add(gamePanel);

        this.revalidate();
        this.repaint();
    }
}
