package lab4;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MenuFrame extends JFrame {
    private final int WIDTH = 300;
    private final int HEIGHT = 400;

    private JFrame game;

    private JPanel namePanel;
    private JPanel speedPanel;
    private JTextField nameInput;
    private JTextField speedInput;
    private JButton startButton;

    public MenuFrame() {
        this.setLayout(new GridLayout(3, 1));
        namePanel = generateNamePanel("Name:");
        speedPanel = generateSpeedPanel("Speed:");
        startButton = generateButton("Start");

        this.add(namePanel);
        this.add(speedPanel);
        this.add(startButton);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle("Ship Game");
        this.setVisible(true);

        this.setSize(WIDTH, HEIGHT);
    }

    public JPanel generateNamePanel(String newLabel) {
        JPanel panel = new JPanel();
        JLabel label;

        panel.setLayout(new GridLayout(1, 2));

        label = new JLabel(newLabel);
        label.setHorizontalAlignment(JLabel.CENTER);

        nameInput = new JTextField();

        panel.add(label);
        panel.add(nameInput);

        return panel;
    }

    public JPanel generateSpeedPanel(String newLabel) {
        JPanel panel = new JPanel();
        JLabel label;

        panel.setLayout(new GridLayout(1, 2));

        label = new JLabel(newLabel);
        label.setHorizontalAlignment(JLabel.CENTER);

        speedInput = new JTextField();

        panel.add(label);
        panel.add(speedInput);

        return panel;
    }

    class ClickListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent event) {
            if ( checkValues() )
            {
                startTheGame();
            }
        }
    }

    public JButton generateButton(String text) {
        JButton button = new JButton(text);

        ActionListener listener = new ClickListener();

        button.addActionListener(listener);

        return button;
    }

    public void startTheGame(){
        int speed = Integer.parseInt(this.speedInput.getText());
        this.game = new GameFrame(this.nameInput.getText(), speed);

        this.setVisible(false);
    }

    public boolean checkValues() {
        String name = nameInput.getText();
        String speed = speedInput.getText();
        boolean isSpeedOk = true;
        boolean isNameOk = true;
        boolean result = true;
        String errorMessage = "";
        int errorCount = 0;

        if ( speed.length() == 0 )
        {
            isSpeedOk = false;
            errorMessage = "Speed cannot be empty!";
            errorCount++;
        }
        else
        {
            for(int i = 0; i < speed.length() && isSpeedOk; i++)
            {
                if ( !Character.isDigit(speed.charAt(i)) )
                {
                    isSpeedOk = false;
                    errorMessage = "Speed should be only numbers!";
                    errorCount++;
                }
            }
        }
        
        if ( name.length() == 0 )
        {
            isNameOk = false;
            if ( errorCount > 0)
            {
                errorMessage = errorMessage + "\n";
            }
            errorMessage = errorMessage + "Name cannot be empty!";
        }

        if ( !(isNameOk && isSpeedOk) )
        {
            System.out.println("Here");
            result = false;
            JOptionPane.showMessageDialog(this, errorMessage);
        }

        return result;
    }
}
