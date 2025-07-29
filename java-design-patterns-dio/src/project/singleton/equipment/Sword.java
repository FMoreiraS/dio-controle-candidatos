package equipment;

public class Sword extends Weapon{
    static int power = 20;
    static int weight = 2;
    static int conservation = 30;
    
    public Sword() {
        super(power, conservation, weight);
    }

}
