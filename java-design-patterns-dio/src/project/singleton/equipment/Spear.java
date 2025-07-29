package equipment;

public class Spear extends Weapon{
    static int power = 25;
    static int weight = 4;
    static int conservation = 20;
    
    public Spear() {
        super(power, conservation, weight);
    }
}
