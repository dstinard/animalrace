package net.mwdata.animalrace;

import net.mwdata.animalrace.animals.*;
import net.mwdata.animalrace.terrains.*;

public class Main {

    public static void main(String[] args) {

        Animal[] animals = new Animal[] {
            new Guppy(),
            new Guppy("Fred"),
            new Sparrow ("Flappy Bird")
        };

        Forest forest1 = new Forest();
        forest1.length = 10f;

        Water water1 = new Water();
        water1.length = 8.5f;

        BaseTerrain[] sections = new BaseTerrain[] {
            forest1,
            new Forest(),
            water1,
            new Water(),
            new Mesa(),
            new Mesa(),
            new Water(),
            new Water(),
            new Forest()
        };

        Race superRace = new Race(animals, sections);
        superRace.runRace();

    }
}
