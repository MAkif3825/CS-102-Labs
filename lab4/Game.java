package lab4;

import javax.swing.JFrame;

public class Game {
    public static void main(String[] args) {
        JFrame menu = new MenuFrame();

        menu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        menu.setTitle("Ship Game");
        menu.setVisible(true);
    }
}
