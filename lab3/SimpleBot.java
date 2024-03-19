package lab3;

public class SimpleBot extends Robot{

    private String code;
    private boolean isAttackingToRed;

    public SimpleBot(boolean isAttackingToRed){
        this.isAttackingToRed = isAttackingToRed;
        initializeValues();
        code = "S" + super.getRoboNum();
    }

    public void attack(Simulation s){
        Robot target = s.getRandomTarget(isAttackingToRed);
        double damage = super.getAttack();
        target.getHitAndIsDesstroyed(damage);
    }

    public void initializeValues(){
        double health = Math.random() * 1 + 2;
        double attack = Math.random() * 1 + 1;
        double speed = Math.random() * 1 + 1;

        super.setValues(health, attack, speed);
    };
}
