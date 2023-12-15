package Lab2.main;

import Lab2.main.pokemon.IPokemon;
import Lab2.main.pokemon.Pokemon;

public class Main {

    public static IPokemon pokemon1;
    public static IPokemon pokemon2;

    public static void run(IPokemon p1, IPokemon p2) {
        while (p1.isAlive() && p2.isAlive()) {
            p1.attack(p2);
            if (!p2.isAlive()) {
                break;
            }
            p2.attack(p1);
        }
    }

    public static void main(String[] args) {
        // Have two pokemon fight until one is defeated

        pokemon1 = new Pokemon("Pikachu");
        pokemon2 = new Pokemon("Oddish");
        System.out.println(pokemon1.toString());
        System.out.println(pokemon2.toString());

        run(pokemon1, pokemon2);

    }
}

