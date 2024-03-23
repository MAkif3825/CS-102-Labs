package lab4;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class GameFrame extends JFrame{


    private JPanel gamePanel;
    
    private String shipName;
    private int speed; 

    public GameFrame(String name, int speed){

        this.speed = speed;
        this.shipName = name;

        this.gamePanel = new GamePanel(this);
        this.add(gamePanel);


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
