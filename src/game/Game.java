package game;

import characters.GameCharacter;
import exceptions.CharacterNotFoundException;
import exceptions.InvalidActionException;

import java.util.*;

public class Game {
    private Map<String, GameCharacter> characters;
    private List<String> players;
    private int currentTurn;

    public Game() {
        characters = new HashMap<>();
        players = new ArrayList<>();
        currentTurn = 0;
    }

    public void addCharacter(GameCharacter character) {
        characters.put(character.getName(), character);
    }

    public void addPlayer(String playerName) {
        players.add(playerName);
    }

    public GameCharacter getCharacter(String name) throws CharacterNotFoundException {
        if (!characters.containsKey(name)) {
            throw new CharacterNotFoundException("Character " + name + " not found.");
        }
        return characters.get(name);
    }

    public void attack(String attackerName, String targetName) throws CharacterNotFoundException, InvalidActionException {
        GameCharacter attacker = getCharacter(attackerName);
        GameCharacter target = getCharacter(targetName);

        if (attacker.getHealth() <= 0) {
            throw new InvalidActionException(attackerName + " is unable to attack as they are defeated.");
        }

        attacker.attack(target);

        if (target.getHealth() <= 0) {
            System.out.println(targetName + " has been defeated by " + attackerName + "!");
        }
    }

    public void nextTurn() {
        currentTurn = (currentTurn + 1) % players.size();
    }

    public String getCurrentPlayer() {
        return players.get(currentTurn);
    }

    public void playTurn(String attackerName, String targetName) {
        try {
            attack(attackerName, targetName);
            nextTurn();
        } catch (CharacterNotFoundException | InvalidActionException e) {
            System.out.println(e.getMessage());
        }
    }

    public boolean isGameOver() {
        boolean player1Alive = characters.get("Arthur").getHealth() > 0 || characters.get("Florence").getHealth() > 0 || characters.get("Robin").getHealth() > 0;
        boolean player2Alive = characters.get("Merlin").getHealth() > 0 || characters.get("Ezio").getHealth() > 0 || characters.get("Ezio").getHealth() > 0;

        return !player1Alive || !player2Alive;
    }

    public String getWinningTeam() {
        boolean player1Alive = characters.get("Arthur").getHealth() > 0 || characters.get("Florence").getHealth() > 0 || characters.get("Robin").getHealth() > 0;
        boolean player2Alive = characters.get("Merlin").getHealth() > 0 || characters.get("Ezio").getHealth() > 0 || characters.get("Ezio").getHealth() > 0;

        if (player1Alive) {
            return "Player 1 wins!";
        } else {
            return "Player 2 wins!";
        }
    }

    public void displayHealth() {
        System.out.println("Current Health Status:");
        for (GameCharacter character : characters.values()) {
            System.out.println(character.getName() + ": " + character.getHealth() + " HP");
        }
    }
}