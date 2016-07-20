package net.mwdata.animalrace.animals;

/**
 * Created by dstinard on 6/30/2016.
 */
public class Guppy extends Animal {

    public Guppy() {
        this.name = "Guppy";
        this.species = "guppy";
        this.waterSpeed = 5.4f;
        this.mesaSpeed = 40000f;
        this.forestSpeed = 1f;
    }

    public Guppy(String name) {
        this.name = name;
        this.species = "guppy";
        this.waterSpeed = 5.6f;
        this.mesaSpeed = 1;
        this.forestSpeed = 1.109f;
    }

}
