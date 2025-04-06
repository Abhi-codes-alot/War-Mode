package characters;

public class Mage extends GameCharacter {
    public Mage(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " casts a spell at " + target.getName());
        target.takeDamage(15);
    }
}