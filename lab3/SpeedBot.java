package lab3;

public class SpeedBot extends Robot{
    public SpeedBot(boolean isAttackingToRed){
        this.isAttackingToRed = isAttackingToRed;
        initializeValues();
        this.code = "X" + super.getRoboNum();
    }

    public void attack(Simulation s){
        //TODO
        boolean isDestroyed;
        Robot target = s.getRandomTarget(isAttackingToRed);
        double damage = super.getAttack();
        System.out.println(this.code + " attacks " + target.code);
        isDestroyed = target.getHitAndIsDesstroyed(damage);

        if ( isDestroyed )
        {
            s.removeRobot(target);
        }
    }

    public void initializeValues(){
        double health = Math.random() * 1 + 1;
        double attack = Math.random() * 1 + 1;
        double speed = Math.random() * 1 + 3;

        super.setValues(health, attack, speed);
    };
}
