import java.util.Scanner;
import characters.*;
import core.NumberMaster;
import core.WarriorCreator;
import equipment.*;

public class Main {
    private static Warrior[] fighters;
    private static boolean p1Moves;
    private static boolean p2Moves;

    private static Warrior p1 = fighters[0];
    private static Warrior p2 = fighters[1];

    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        showMenu();
        

        while (true) {
            showState();
            int option;
            boolean p1IsDefending;
            if (p1Moves) {
                System.out.printf("O que %s fará agora?");
                System.out.println("1. Atacar");
                System.out.println("2. Defender");
                System.out.println("3. Esquivar");
                option = scanner.nextInt();
                if (option == 1) {
                    attack(p1, p2);
                } else if (option == 2) {
                    
                }
            }
        }
    }

    public static void showMenu() {
        System.out.println("O vento sopra no campo de batalha...");
        int option = 0;
        while (true) {
            System.out.println("1. Começar.");
            System.out.println("2. Sair.");
            option = scanner.nextInt();
            //scanner.nextLine();
            if (option == 1) {
                System.out.println("Vais lutar contra quem?");
                System.out.println("1. Contra a máquina");
                System.out.println("2. Contra outro");
                option = scanner.nextInt();
                if (option == 1) {
                    Warrior player1 = WarriorCreator.createPlayer();
                    Warrior com = WarriorCreator.createComputer();
                    insertFighters(player1, com);
                    break;
                }
                else {
                    Warrior player1 = WarriorCreator.createPlayer();
                    Warrior player2 = WarriorCreator.createPlayer();
                    insertFighters(player1, player2);
                    break;
                }
            } else if (option == 2) {
                System.exit(0);
            } else {
                System.out.println("Opção inválida");
            }
        }
    }

    public static void insertFighters(Warrior w1, Warrior w2) {
        fighters = new Warrior[]{w1, w2};
    }

    public static void attack (Warrior attacker, Warrior defender) {
        int atk = NumberMaster.atkCalc(attacker.getPower());
        defender.setLife(defender.getLife() - atk);
    }

    public static void defense (Warrior defender, Warrior attacker) {
        int defense = defender.getDefense();
        int atk = attacker.getPower();
        if ((!defender.getShield().equals(null))) {
			defense += (defender.getShield().getConservation() / 2);
		}
        int receivedDamage = NumberMaster.defCalc(defense, atk);
        defender.setLife(defender.getLife() - receivedDamage);
    }

    public static void showState() {
        System.out.printf("%s : %d HP\n", fighters[0].getName(), fighters[0].getLife());
        System.out.printf("%s : %d HP\n", fighters[1].getName(), fighters[1].getLife());
    }

    private static boolean isFasterPlayer(Warrior p1, Warrior p2) {
        if (p1.getSpeed() > p2.getSpeed()) {
            return true;
        } else if (p1.getSpeed() < p2.getSpeed()) {
            return false;
        } else {
            return NumberMaster.obtainRandom(1, 2) == 1;
        }
    }
}
