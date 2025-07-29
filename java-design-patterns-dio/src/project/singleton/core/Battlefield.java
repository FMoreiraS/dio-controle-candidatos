package core;

import characters.*;

public class Battlefield {
    private Warrior[] fighters;
    private boolean p1Moves;
    private boolean p2Moves;

    public void insertFighters(Warrior w1, Warrior w2) {
        fighters = new Warrior[]{w1, w2};
    }

    public void attack (Warrior attacker, Warrior defender) {
        int atk = NumberMaster.atkCalc(attacker.getPower());
        defender.setLife(defender.getLife() - atk);
    }

    // public void defense (Warrior defender, Warrior attacker) {
    //     int atk = NumberMaster.atkCalc(attacker.getPower());
    //     defender.setLife(defender.getLife() - atk);
    // }

    

}
