package characters;

import equipment.*;

public abstract class Warrior {
    protected String name;
    protected int life = 100;
    protected int power;
    protected int defense;
    protected int speed;
    protected Weapon weapon;
    protected IronShield shield;

    protected Warrior (String name, int power, int defense, int speed) {
        this.name = name;
        //this.life = life;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        //this.weapon = weapon;
    }

    protected Warrior (String name, int power, int defense, int speed, IronShield shield) {
        this.name = name;
        this.power = power;
        this.defense = defense;
        this.speed = speed;
        this.shield = shield;
    }

    public void defineAtribute () {
        
    }

    public void setShield(IronShield shield) {
        this.shield = shield;
    }

    public int getLife() {
        return life;
    }

    public void setLife(int life) {
        this.life = life;
    }

    public String getName() {
        return name;
    }

    public int getPower() {
        return power;
    }

    public int getDefense() {
        return defense;
    }

    public int getSpeed() {
        return speed;
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public IronShield getShield() {
        return shield;
    }

    

}
