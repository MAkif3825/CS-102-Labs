package lab3;

import java.util.ArrayList;

public class Simulation {
    private ArrayList<Team> teams;
    private Team redTeam;
    private Team blueTeam;

    public void initialize(int teamSize)
    {
        redTeam = new Team(teamSize, false);
        blueTeam = new Team(teamSize, false);
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
  

}
