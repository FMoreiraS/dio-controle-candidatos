package characters;

import equipment.IronShield;
import equipment.Sword;

public class Swordsman extends Warrior{
    Sword weapon = new Sword();

    public Swordsman(String name, int power, int defense, int speed) {
        super(name, power, defense, speed);
    }
    
    public Swordsman(String name, int power, int defense, int speed, IronShield shield) {
        super(name, power, defense, speed, shield);
    }

}