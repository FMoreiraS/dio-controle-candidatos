package core;

import java.util.concurrent.ThreadLocalRandom;

import characters.Warrior;

public class NumberMaster {

	private static NumberMaster instance = new NumberMaster();
	
	private NumberMaster() {
		super();
	}
	
	public static NumberMaster getInstancia() {
		return instance;
	}
    
	public static int obtainRandom(int min, int max) {
		return ThreadLocalRandom.current().nextInt(min, max);
	}

	public static int rollDice (int diceQuantity, int numberSides) {
		System.out.println("Rolamento de dado!");
		int result = 0;
		while (result == 0) {
			if (diceQuantity == 1) {
				if (numberSides == 6) {
					result = obtainRandom(1, 6);
					break;
				} else if (numberSides == 20) {
					result += obtainRandom(1, 20);
					break;
				}
			} else if (diceQuantity == 2) {
				if (numberSides == 6) {
					result += obtainRandom(1, 6);
					result += obtainRandom(1, 6);
					break;
				} else if (numberSides == 20) {
					result += obtainRandom(1, 20);
					result += obtainRandom(1, 20);
					break;
				}
			} else {
				System.out.println("");
			}
		}
		return result;
	}
	public static int atkCalc(int power) {
		int successRate = rollDice(1, 20);
		int attack = 0;
		if (successRate <= 2) {
			attack = 0;
			System.out.println("Erraste o ataque!");
		} else if (successRate < 19) {
			attack = power;
			System.out.println("Ataque bem-sucedido");
		} else {
			attack = power * 2;
			System.out.println("Acerto crítico!");
		}
		return attack;
	}
	
	public static int defCalc(int defense, int enemyAtk) {
		int successRate = rollDice(1, 20);
		int receivedDamage = 0;
		if (successRate <= 2) {
			receivedDamage = enemyAtk;
			System.out.println("Defesa mal-sucedida!");
		} else if (successRate < 19) {
			receivedDamage = enemyAtk - defense;
			System.out.println("Defesa bem-sucedida");
		} else {
			receivedDamage = 0;
			System.out.println("Esquivaste do ataque!");
		}
		return receivedDamage;
	}
	
	public static int dodgeCalc(int speed, int enemyAtk) {
		int successRate = rollDice(1, 20) + speed;
		int receivedDamage = 0;
		if (successRate <= 10) {
			receivedDamage = enemyAtk;
			System.out.println("Esquiva mal-sucedida!");
		} else {
			receivedDamage = 0;
			System.out.println("Esquivaste do ataque!");
		}
		return receivedDamage;
	}
}
