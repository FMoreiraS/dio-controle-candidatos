package characters;

import equipment.IronShield;

public class Axeman extends Warrior{


    public Axeman (String name, int power, int defense, int speed) {
        super(name, power, defense, speed);
    }

    public Axeman(String name, int power, int defense, int speed, IronShield shield) {
        super(name, power, defense, speed, shield);
    }
}
