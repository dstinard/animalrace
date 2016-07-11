package net.mwdata.animalrace.animals;

import net.mwdata.animalrace.terrains.BaseTerrain;

/**
 * Created by dstinard on 6/21/2016.
 */
abstract public class Animal {
    // animal details
    public String species; //defaults to null
    public String name;

    // speeds in different terrains (meters / second)
    public float waterSpeed;
    public float mesaSpeed;
    public float forestSpeed;

    // race progress
    public float distance = 0;

    // constructor
    public Animal(String name, String species) {
        this.name = name;
        this.species = species;
    }

    public Animal() {
        name = "John Doe";
        species = "blob";
        waterSpeed = 2;
        mesaSpeed = 2;
        forestSpeed = 2;
    }

    // methods
    public float distanceThisTick(BaseTerrain terrain) {
        if (terrain.type == BaseTerrain.TerrainType.MESA) {
            return mesaSpeed;
        } else if (terrain.type == BaseTerrain.TerrainType.WATER) {
            return waterSpeed;
        } else if (terrain.type == BaseTerrain.TerrainType.FOREST) {
            return forestSpeed;
        } else {
            throw new IllegalArgumentException("Unknown terrain type");
        }
    }

    public String reportableDistance() {
        return String.format("%.2f", distance);
    }
}
