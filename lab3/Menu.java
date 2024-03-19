package lab3;

import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int size;

        System.out.print("Team Size: ");
        while ( !in.hasNextInt() )
        {
            in.nextLine();
        }

        size = in.nextInt();

        if ( size <= 0)
        {
            System.out.println("Size should be positive. Please restart the game.");
        }
        else
        {  
            Simulation game = new Simulation(size);
            game.begin();
            while( game.isGameContinue() )
            {
                System.out.println("  ");
                game.playRound();
            }
            game.finishGame();
        }

        in.close();
    }
}
