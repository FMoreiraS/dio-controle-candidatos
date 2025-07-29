package characters;

import equipment.IronShield;

public class Spearman extends Warrior{

    public Spearman (String name, int power, int defense, int speed) {
        super(name, power, defense, speed);
    }

    public Spearman(String name, int power, int defense, int speed, IronShield shield) {
        super(name, power, defense, speed, shield);
    }

}
