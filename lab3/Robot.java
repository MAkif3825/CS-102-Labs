package lab3;

public abstract class Robot implements Comparable<Robot>{
    private static int robotNum = 0;
    private double health;
    private double attack;
    private double speed;
    protected String code;
    protected boolean isAttackingToRed;

    public abstract void attack(Simulation s);
    public abstract void initializeValues();

    //Getters
    public double getHealth(){
        return this.health;
    }

    public double getAttack(){
        return this.attack;
    }

    public double getSpeed(){
        return this.speed;
    }

    public int getRoboNum(){
        return Robot.robotNum;
    }

    //Setter
    public void setValues(double health, double attack, double speed)
    {
        this.health = health;
        this.attack = attack;
        this.speed = speed;
        Robot.robotNum = Robot.robotNum + 1;
    }

    public int compareTo(Robot o)
    {
        int result = 0;
        if ( this.speed > o.getSpeed() )
        {
            result = -1;
        }
        else if ( this.speed < o.getSpeed() )
        {
            result = 1;
        }

        return result;
    }

    public boolean getHitAndIsDesstroyed(double damage){
        boolean isDestroyed = false;
        health = this.health - damage;

        if ( this.health <= 0 )
        {
            this.health = 0;
            isDestroyed = true;
        }

        System.out.println(this.code + " recieves " + String.format("%.3f", damage) + " -> " + 
                            " remaining health: " + String.format("%.3f", this.health));
        
        return isDestroyed;
    }

    public String toString(){
        String result = this.code;
        result = result + " Health: " + String.format("%.3f", this.health) +
                          " Attack: " + String.format("%.3f", this.attack) +
                          " Speed: "  + String.format("%.3f", this.speed) + "\n";
        return result;
    }
}
