package equipment;

public class IronShield extends Weapon{
    static int power = 10;
    static int weight = 8;
    static int conservation = 80;
    
    public IronShield() {
        super(power, conservation, weight);
    }
}
