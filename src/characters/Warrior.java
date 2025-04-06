package characters;

import abilities.Defendable;

public class Warrior extends GameCharacter implements Defendable {
    public Warrior(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " swings a sword at " + target.getName());
        target.takeDamage(10);
    }

    @Override
    public void defend() {
        System.out.println(name + " raises a shield to defend.");
    }
}