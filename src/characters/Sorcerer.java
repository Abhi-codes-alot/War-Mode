package characters;

public class Sorcerer extends Mage {
    public Sorcerer(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " conjures a fireball at " + target.getName());
        target.takeDamage(25);
    }
}