package characters;

public class Archer extends GameCharacter {
    public Archer(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " shoots an arrow at " + target.getName());
        target.takeDamage(12);
    }
}