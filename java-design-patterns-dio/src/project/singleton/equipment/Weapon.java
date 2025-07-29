package equipment;

public abstract class Weapon {
    protected int power;
    protected int conservation;
    protected int weight;

    public Weapon(int power, int conservation, int weight) {
        this.power = power;
        this.conservation = conservation;
        this.weight = weight;
    }

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public int getConservation() {
        return conservation;
    }

    public void setConservation(int conservation) {
        this.conservation = conservation;
    }

    
}
