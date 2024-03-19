package lab3;

public class SpreadBot extends Robot{
    public SpreadBot(boolean isAttackingToRed){
        this.isAttackingToRed = isAttackingToRed;
        initializeValues();
        this.code = "K" + super.getRoboNum();
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
        double health = Math.random() * 1 + 2;
        double attack = Math.random() * 1 / 2 + 0.5;
        double speed = Math.random() * 1 / 2 + 1;

        super.setValues(health, attack, speed);
    };
}
