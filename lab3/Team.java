package lab3;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class Team {
    private ArrayList<Robot> robots;
    private int size;

    public Team(int size, boolean isAttackingToRed){
        this.robots = new ArrayList<Robot>();
        this.size = size;
        this.generateRobots(isAttackingToRed);
        this.sortRobots();
    }


    public void generateRobots(boolean isAttackingToRed)
    {
        Random rand = new Random();
        Robot robot;
        int num;
        for ( int i = 0; i < size; i++)
        {
            num = 0;//rand.nextInt(7);

            if ( num == 0)
            {
                robot = new SimpleBot(isAttackingToRed);
                this.robots.add(robot);
            }
            else if ( num == 1)
            {}
            else if ( num == 2)
            {}
            else if ( num == 3)
            {}
            else if ( num == 4)
            {}
            else
            {}

        }
    }

    public void sortRobots()
    {
        Collections.sort(robots);  
    }

    public Robot getRobot(int index){
        return this.robots.get(index);
    }

    public Robot getRandom()
    {
        int index = (int)(Math.random() * this.size);
        return this.getRobot(index);
    }

    public Robot getHighestHealth()
    {
        Robot target;
        int indexOfRobot = 0;
        for ( int i = 1; i < this.size; i++)
        {
            if ( this.robots.get(indexOfRobot).getHealth() < this.robots.get(i).getHealth() )
            {
                indexOfRobot = i;
            }
        }
        target = this.robots.get(indexOfRobot);
        return target;
    }

    public Robot getLowestHealth()
    {
        Robot target;
        int indexOfRobot = 0;
        for ( int i = 1; i < this.size; i++)
        {
            if ( this.robots.get(i).getHealth() < this.robots.get(indexOfRobot).getHealth() )
            {
                indexOfRobot = i;
            }
        }
        target = this.robots.get(indexOfRobot);
        return target;
    }

    public Robot getLowestSpeed()
    {
        Robot target = this.robots.get(size - 1);

        return target;
    }

    public Robot getLowestAttack()
    {
        Robot target;
        int indexOfRobot = 0;
        for ( int i = 1; i < this.size; i++)
        {
            if ( this.robots.get(i).getAttack() < this.robots.get(indexOfRobot).getAttack() )
            {
                indexOfRobot = i;
            }
        }
        target = this.robots.get(indexOfRobot);
        return target;
    }

    public Robot[] getLowestSpeed3()
    {
        Robot[] targets = new Robot[3];
        for ( int i = 0; i < 3; i++)
        {
            targets[i] = this.robots.get((this.size - 1) - i);
        }

        return targets;
    }

    /*
    public int getTeamSize(){
        return this.size;
    }
    */
}
