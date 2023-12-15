package Lab2.main.pokemon;

import java.lang.Math;
import java.util.Random;

public class Pokemon implements IPokemon {

    String name;
    int healthPoints;
    int maxHealthPoints;
    int strength;
    Random random;

    public Pokemon(String name) {
        this.name = name;
        this.random = new Random();
        this.healthPoints = (int) Math.abs(Math.round(100 + 10 * random.nextGaussian()));
        this.maxHealthPoints = this.healthPoints;
        this.strength = (int) Math.abs(Math.round(20 + 10 * random.nextGaussian()));
    }


    public String getName() {
        return this.name;
    }

    @Override
    public int getStrength() {
        return this.strength;
    }

    @Override
    public int getCurrentHP() {
        return this.healthPoints;
    }

    @Override
    public int getMaxHP() {
        return this.maxHealthPoints;
    }

    public boolean isAlive() {
        return this.healthPoints > 0;
    }

    @Override
    public void attack(IPokemon target) {
        int damageInflicted = (int) (this.strength + this.strength / 2 * random.nextGaussian());
        System.out.println(this.name + " attacks " + target.getName());
        target.damage(damageInflicted);
        if (!target.isAlive()) {
            System.out.println(target.getName() + " is defeated by " + this.name);
        }
    }

    @Override
    public void damage(int damageTaken) {
        if (damageTaken > 0) {
            if (this.healthPoints - damageTaken > 0) {
                this.healthPoints -= damageTaken;
            } else this.healthPoints = 0;
        }
        System.out.println(this.name + " takes " + damageTaken + " damage and is left with "
                + this.healthPoints + "/" + this.maxHealthPoints + " HP");
    }

    @Override
    public String toString() {
        return this.name + " HP: (" + this.healthPoints + "/" + this.maxHealthPoints + ") STR: " + this.strength;
    }
}
