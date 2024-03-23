package lab3;

import java.util.ArrayList;
import java.util.Arrays;
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
            num = rand.nextInt(7);

            if ( num == 0)
            {
                robot = new SimpleBot(isAttackingToRed);
                this.robots.add(robot);
            }
            else if ( num == 1)
            {
                robot = new PredatorBot(isAttackingToRed);
                this.robots.add(robot);
            }
            else if ( num == 2)
            {
                robot = new DefenceBot(isAttackingToRed);
                this.robots.add(robot);
            }
            else if ( num == 3)
            {
                robot = new SpeedBot(isAttackingToRed);
                this.robots.add(robot);
            }
            else if ( num == 4)
            {
                robot = new SpreadBot(isAttackingToRed);
                this.robots.add(robot);
            }
            else
            {
                robot = new OneBot(isAttackingToRed);
                this.robots.add(robot);
            }

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
        if ( this.size >= 3 )
        {
            for ( int i = 0; i < 3; i++)
            {
                targets[i] = this.robots.get((this.size - 1) - i);
            }
        } 
        else
        {
            int i = 0;
            for ( ; i < this.size; i++)
            {
                targets[i] = this.robots.get(i);
            }
            targets = Arrays.copyOf(targets, i);
        }


        return targets;
    }

    public double getSpeedSum(){
        double speedSum = 0;
        for (Robot robot : robots) {
            speedSum = speedSum + robot.getSpeed();
        }

        return speedSum;
    }

    public int getTeamSize(){
        return this.size;
    }

    public int destroyRobotAndGiveIndex(Robot r)
    {
        int index = 0;
        boolean isIndexFound = false;

        for ( int i = 0; i < this.size && !isIndexFound; i++)
        {
            if ( r == this.robots.get(i) )
            {
                index = i;
                isIndexFound = true;
            }
        }

        System.out.println(r.code + " destroyed.");
        this.robots.remove(index);
        this.size = this.size - 1;
        return index;
    }

    public String toString(){
        String result = "";
        for (Robot robot : robots) {
            result = result + robot;
        }
        return result;
    }

    public void playWith(int index, Simulation s){
        this.robots.get(index).attack(s);
    }
}
