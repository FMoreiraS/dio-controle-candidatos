package tictactoe;

import java.util.Scanner;
import java.util.concurrent.ThreadLocalRandom;

public class Main {
    private static Player p1 = null;
    private static Player p2 = null;
    private static Scanner scanner = new Scanner (System.in);
    public static void main(String[] args) {
        showMenu();
        defineFirstPlayer();

        while (true) {
            Board.showBoard();
            if (p1.getMovesNow()) {
                System.out.printf("É a sua vez, %s.\n", p1.getName());
                System.out.println("Indique a linha da posição desejada");
                int row = scanner.nextInt();
                System.out.println("Indique a coluna da posição desejada");
                int column = scanner.nextInt();
                Board.markSpace(row, column, SpaceMark.X);
                SpaceMark winnerMarker = Board.verifyVictory();
                if (winnerMarker.equals(SpaceMark.X)) {
                    Board.showBoard();
                    System.out.printf("%s venceu o jogo.\n", p1.getName());
                    break;
                } else if (Board.getMarkedSpaces() == 9 && winnerMarker.equals(SpaceMark.VOID)) {
                    System.out.println("O jogo empatou");
                }
                p1.setMovesNow(false);
                p2.setMovesNow(true);
            } else if (p2.getMovesNow()) {
                System.out.printf("É a sua vez, %s.\n", p2.getName());
                System.out.println("Indique a linha da posição desejada");
                int row = scanner.nextInt();
                System.out.println("Indique a coluna da posição desejada");
                int column = scanner.nextInt();
                Board.markSpace(row, column, SpaceMark.O);
                SpaceMark winnerMarker = Board.verifyVictory();
                if (winnerMarker.equals(SpaceMark.X)) {
                    Board.showBoard();
                    System.out.printf("%s venceu o jogo.\n", p2.getName());
                    break;
                } else if (Board.getMarkedSpaces() == 9 && winnerMarker.equals(SpaceMark.VOID)) {
                    System.out.println("O jogo empatou");
                }
                p2.setMovesNow(false);
                p1.setMovesNow(true);
            }
        }

        scanner.close();
    }

    private static void showMenu() {
        int option;
        while (true) {
            System.out.println("==== Java da velha ====");
            System.out.println("Escolha uma opção");
            System.out.println("1. Começar novo jogo");
            System.out.println("2. Sair");
            
            option = scanner.nextInt();
            if (option == 1) {
                scanner.nextLine();
                System.out.println("Qual o nome do jogador 1?");
                String p1Name = scanner.nextLine();
                p1 = new Player(p1Name);
                System.out.println("Qual o nome do jogador 2?");
                String p2Name = scanner.nextLine();
                p2 = new Player(p2Name);

                System.out.println("Novo jogo iniciado");
                System.out.printf("%s marcará com X e %s com O.\n", p1.getName(), p2.getName());
                p1.setMarker(SpaceMark.X);
                p2.setMarker(SpaceMark.O);
                Board.createNew();
                break;
            } else {
                System.exit(0);
            }
        }
    }

    private static void defineFirstPlayer() {
        int firstPlayer = ThreadLocalRandom.current().nextInt(1, 2);
        if (firstPlayer == 1) {
            System.out.printf("%s começa o jogo.\n", p1.getName());
            p1.setMovesNow(true);
        } else {
            System.out.printf("%s começa o jogo.\n", p2.getName());
            p2.setMovesNow(true);
        }
    }
}
