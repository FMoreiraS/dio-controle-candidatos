package core;

import characters.*;
import equipment.*;
import java.util.Scanner;

public class WarriorCreator {
    static Scanner scanner = new Scanner(System.in);
    private static WarriorCreator instance = new WarriorCreator();
	
	private WarriorCreator() {
		super();
	}
	
	public static WarriorCreator getInstancia() {
		return instance;
	}

    public static Warrior createPlayer() {
        Warrior warrior = null;
        int option;
        String answer;
        IronShield optionalShield = null;

        System.out.println("Qual o teu nome?");
        String name = scanner.next();
        System.out.println("Agora serão definidos teus atributos.");
        System.out.println("Um dado de 20 faces lançado uma vez define a força, e o mesmo é feito para a defesa.");
        System.out.println("Um dado de 6 faces lançado duas vezes define a velocidade.");
        int power = NumberMaster.rollDice(1, 20);
        int defense = NumberMaster.rollDice(1, 20);
        int speed = NumberMaster.rollDice(2, 6);
        System.out.println("Resultado:");
        System.out.printf("Força: %d\nDefesa: %d\nVelocidade: %d \n", power, defense, speed);
        while (true) {
            System.out.println("Escolhe uma arma.");
            System.out.println("1. Espada");
            System.out.println("2. Lança");
            System.out.println("3. Machado");
            option = scanner.nextInt();
            System.out.println("Queres também um escudo? (S/N)");
            answer = scanner.next();
            if (answer.equals("S") || answer.equals("s")) {
                optionalShield = new IronShield();
            }
            if (option == 1) {
                //Sword sword = new Sword();
                warrior = new Swordsman(name, power, defense, speed, optionalShield);
                break;
            } else if (option == 2) {
                //Spear spear = new Spear();
                warrior = new Spearman(name, power, defense, speed, optionalShield);
                break;
            } else if (option == 3) {
                //Axe axe = new Axe();
                warrior = new Axeman(name, power, defense, speed, optionalShield);
                break;
            } else {
                System.out.println("Opção inválida");
            }
        }
        return warrior;
    }

    public static Warrior createComputer() {
        Warrior warrior = null;
        String comName = "Unknown";
        int weapon = NumberMaster.obtainRandom(1, 3);
        int power = NumberMaster.rollDice(2, 20);
        int defense = NumberMaster.rollDice(2, 20);
        int speed = NumberMaster.rollDice(2, 6);
        IronShield optionalShield = null;
        
        if (weapon == 1) {
            comName.concat(" Swordsman");
            warrior = new Swordsman(comName, power, defense, speed, optionalShield);
        } else if (weapon == 2) {
            comName.concat(" Spearman");
            warrior = new Spearman(comName, power, defense, speed, optionalShield);
        } else {
            comName.concat(" Axeman");
            warrior = new Axeman(comName, power, defense, speed, optionalShield);
        }

        return warrior;
    }
}
