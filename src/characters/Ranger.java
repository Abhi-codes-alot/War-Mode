package characters;

public class Ranger extends Archer {
    public Ranger(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " fires a piercing arrow at " + target.getName());
        target.takeDamage(18);
    }
}