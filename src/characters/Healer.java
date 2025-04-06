package characters;

public class Healer extends GameCharacter {
    public Healer(String name, int health) {
        super(name, health);
    }

    public void heal(GameCharacter target) {
        System.out.println(name + " heals " + target.getName());
        target.health += 20;
    }

    @Override
    public void attack(GameCharacter target) {
        System.out.println(name + " attacks with a healing staff at " + target.getName());
        target.takeDamage(5);
    }
}