package characters;

public class Assassin extends GameCharacter {
    public Assassin(String name, int health) {
        super(name, health);
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " strikes from the shadows at " + target.getName());
        target.takeDamage(30);
    }
}