package game;

import characters.*;
import exceptions.CharacterNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Game game = new Game();

        // Player 1's Characters
        GameCharacter knight = new Knight("Arthur", 100);
        GameCharacter healer1 = new Healer("Florence", 70);
        GameCharacter ranger = new Ranger("Robin", 90);

        // Player 2's Characters
        GameCharacter mage = new Mage("Merlin", 80);
        GameCharacter healer2 = new Healer("Tom", 70);
        GameCharacter assassin = new Assassin("Ezio", 60);

        game.addCharacter(knight);
        game.addCharacter(healer1);
        game.addCharacter(ranger);
        game.addCharacter(mage);
        game.addCharacter(healer2);
        game.addCharacter(assassin);

        game.addPlayer("Player1");
        game.addPlayer("Player2");

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the 1v1 Turn-Based Game!");
        System.out.println("Instructions:");
        System.out.println("1. Each player has 3 characters: one attacker, one healer, and one ranged attacker.");
        System.out.println("2. Player 1: Arthur (Knight), Florence (Healer), and Robin (Ranger).");
        System.out.println("3. Player 2: Merlin (Mage), Tom (Healer), and Ezio (Assassin).");
        System.out.println("4. Players take turns to either attack or heal.");
        System.out.println("5. To attack, choose '1' and enter the attacker's name and target's name.");
        System.out.println("6. To heal, choose '2' and enter the healer's name and the target's name.");
        System.out.println("7. The game ends when all characters of one player are defeated.");
        System.out.println("Let's start the game!");

        while (true) {
            System.out.println(game.getCurrentPlayer() + "'s turn. Choose an action:");
            System.out.println("1. Attack");
            System.out.println("2. Heal");

            int action = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            if (action == 1) {
                System.out.println("Enter attacker name:");
                String attackerName = scanner.nextLine();
                System.out.println("Enter target name:");
                String targetName = scanner.nextLine();
                game.playTurn(attackerName, targetName);
            } else if (action == 2) {
                System.out.println("Enter healer name:");
                String healerName = scanner.nextLine();
                System.out.println("Enter target name:");
                String targetName = scanner.nextLine();
                try {
                    GameCharacter healerCharacter = game.getCharacter(healerName);
                    if (healerCharacter instanceof Healer) {
                        ((Healer) healerCharacter).heal(game.getCharacter(targetName));
                        game.nextTurn();
                    } else {
                        System.out.println(healerName + " is not a healer.");
                    }
                } catch (CharacterNotFoundException e) {
                    System.out.println(e.getMessage());
                }
            }

            game.displayHealth(); // Display health status after each turn

            if (game.isGameOver()) {
                System.out.println(game.getWinningTeam());
                break;
            }
        }

        scanner.close();
    }
}