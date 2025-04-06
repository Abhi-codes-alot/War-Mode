package characters;

public class Knight extends Warrior {
    public Knight(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " charges with a lance at " + target.getName());
        target.takeDamage(20);
    }

    @Override
    public void defend() {
        System.out.println(name + " uses a mounted shield to defend.");
    }
}