package lab3;

public class OneBot extends Robot{
    public OneBot(boolean isAttackingToRed){
        this.isAttackingToRed = isAttackingToRed;
        initializeValues();
        this.code = "O" + super.getRoboNum();
    }

    public void attack(Simulation s){
        boolean isDestroyed;
        Robot target = s.getLowestHealth(isAttackingToRed);
        double damage = super.getAttack();
        System.out.println(this.code + " attacks " + target.code);
        isDestroyed = target.getHitAndIsDesstroyed(damage);

        if ( isDestroyed )
        {
            s.removeRobot(target);
        }
    }

    public void initializeValues(){
        double health = Math.random() * 1 / 2 + 0.5;
        double attack = Math.random() * 1 + 4;
        double speed = Math.random() * 1 / 2 + 0.5;

        super.setValues(health, attack, speed);
    };
}
