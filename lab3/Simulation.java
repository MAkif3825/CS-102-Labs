package lab3;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Team> teams;
    private Team redTeam;
    private Team blueTeam;
    private int indexOfFirst;
    private int indexOfSecond;
    private Team firsTeam;
    private Team secondTeam;
    
    public Simulation(int teamSize){
        initialize(teamSize);
    }

    public void initialize(int teamSize)
    {
        redTeam = new Team(teamSize, false);
        blueTeam = new Team(teamSize, true);
        teams = new ArrayList<Team>();
        
        teams.add(blueTeam);
        teams.add(redTeam);
    }

    public Robot getRandomTarget(boolean isRedTeam) {
        Robot target;

        if ( isRedTeam )
        {
            target = this.redTeam.getRandom();
        }
        else
        {
            target = this.blueTeam.getRandom();
        }

        return target;
    }

    public Robot getHighestHealth(boolean isRedTeam) {
        Robot target;

        if ( isRedTeam )
        {
            target = this.redTeam.getHighestHealth();
        }
        else
        {
            target = this.blueTeam.getHighestHealth();
        }

        return target;
    }

    public Robot getLowestHealth(boolean isRedTeam) {
        Robot target;

        if ( isRedTeam )
        {
            target = this.redTeam.getLowestHealth();
        }
        else
        {
            target = this.blueTeam.getLowestHealth();
        }

        return target;
    }

    public Robot getLowestSpeed(boolean isRedTeam) {
        Robot target;

        if ( isRedTeam )
        {
            target = this.redTeam.getLowestSpeed();
        }
        else
        {
            target = this.blueTeam.getLowestSpeed();
        }

        return target;
    }

    public Robot getLowestAttack(boolean isRedTeam) {
        Robot target;

        if ( isRedTeam )
        {
            target = this.redTeam.getLowestAttack();
        }
        else
        {
            target = this.blueTeam.getLowestAttack();
        }

        return target;
    }

    public Robot[] getLowestSpeed3(boolean isRedTeam){
        Robot[] targets;

        if ( isRedTeam )
        {
            targets = this.redTeam.getLowestSpeed3();
        }
        else
        {
            targets = this.blueTeam.getLowestSpeed3();
        }

        return targets;        
    }
  
    public void removeRobot(Robot r)
    {
        int index;

        if ( r.isAttackingToRed )
        {
            index = this.blueTeam.destroyRobotAndGiveIndex(r);
            if ( this.firsTeam == blueTeam)
            {
                if ( this.indexOfFirst <= index )
                {
                    this.indexOfFirst -= 1;
                }
            }
            else
            {
                if ( this.indexOfSecond <= index )
                {
                    this.indexOfSecond -= 1;
                }
            }
        }
        else
        {
            index = this.redTeam.destroyRobotAndGiveIndex(r);
            if ( this.firsTeam == redTeam)
            {
                if ( this.indexOfFirst <= index )
                {
                    this.indexOfFirst -= 1;
                }
            }
            else
            {
                if ( this.indexOfSecond <= index )
                {
                    this.indexOfSecond -= 1;
                }
            }
        }
    }

    public void begin(){
        double speedSumOfRed = this.redTeam.getSpeedSum();
        double speedSumOfBlue = this.blueTeam.getSpeedSum();

        System.out.println("\nRed Team:\n" + redTeam);
        System.out.println("Blue Team:\n" + blueTeam);


        System.out.println("Speed sum of Red: " + String.format("%.3f", speedSumOfRed));
        System.out.println("Speed sum of Blue: " + String.format("%.3f", speedSumOfBlue) + "\n");

        if ( speedSumOfBlue > speedSumOfRed )
        {
            this.firsTeam = this.blueTeam;
            this.secondTeam = this.redTeam;
            System.out.print("Blue");
        }
        else
        {
            this.firsTeam = this.redTeam;
            this.secondTeam = this.blueTeam;
            System.out.print("Red");
        }

        System.out.println(" starts first.");

        this.indexOfSecond = 0;
        this.indexOfFirst = 0;
    }

    public void playRound(){
        //System.out.println(indexOfFirst);
        //System.out.println(indexOfSecond);

        if ( indexOfFirst >= firsTeam.getTeamSize() - 1)
        {
            indexOfFirst = 0;
        }
        firsTeam.playWith(indexOfFirst, this);
        indexOfFirst++;


        if ( isGameContinue() )
        {
            if ( indexOfSecond >= secondTeam.getTeamSize() - 1)
            {
                indexOfSecond = 0;
            }
            secondTeam.playWith(indexOfSecond, this);
            indexOfSecond++;
        }

    }
    
    public boolean isGameContinue(){
        boolean isGameContinue = true;
        for ( int i = 0; i < this.teams.size(); i++)
        {
            if ( this.teams.get(i).getTeamSize() == 0 )
            {
                isGameContinue = false;
            }
        }

        return isGameContinue;
    }

    public void finishGame(){
        Team winner;
        if ( this.firsTeam.getTeamSize() > 0 && this.secondTeam.getTeamSize() == 0)
        {
            winner = this.firsTeam;
        }
        else if ( this.secondTeam.getTeamSize() > 0 && this.firsTeam.getTeamSize() == 0 )
        {
            winner = this.secondTeam;
        }
        else
        {
            System.out.println("Error occurred.");
            winner = this.blueTeam;
        }

        if ( winner == blueTeam )
        {
            System.out.println("\nBlue team wins, remaining robots:\n" + blueTeam);
        }
        else
        {
            System.out.println("\nRed team wins, remaining robots:\n" + redTeam);
        }

    }
}
