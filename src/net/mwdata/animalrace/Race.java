package net.mwdata.animalrace;

import net.mwdata.animalrace.animals.Animal;
import net.mwdata.animalrace.terrains.BaseTerrain;

/**
 * Created by dstinard on 6/30/2016.
 */
public class Race {

    // distance per section of the race
    public final static float METERS_PER_TERRAIN = 10.0f;

    public Animal[] racers;
    public BaseTerrain[] terrains;
    public float courseDistance;
    public int courseTime = 0; // in seconds

    // flag to determine if the race should continue
    public boolean stop = false;

    public Race(Animal[] contestants, BaseTerrain[] raceCourseTerrains) {
        this.racers = contestants;
        this.terrains = raceCourseTerrains;
        this.courseDistance = METERS_PER_TERRAIN * this.terrains.length;
    }

    public void runRace() {
        setupRace();
        if (racers.length == 0 || terrains.length == 0) {
            throw new IllegalArgumentException("Add some racers or terrains first!");
        }

        // Main Loop!!!
        /* While loops will continue as long as the expression in the parentheses
            evaluates to true.
            Expression is not stop.
                if stop == true, !stop == false;
                if stop == false, !stop == true;
            In other words, the following while loop will continue as long as
            !stop == true. Therefore the while loop will continue as long as
            stop == false.
         */
        while (!stop) {
            // move racers
            moveRacers();

            // check if there is a winner
            if (raceIsWon()) {
                declareWinner();
                stop = true;
            } else {
                raceReport();
            }

            // increment time
            courseTime++; // add one second
        }
    }

    public void raceReport() {
        // mod == division remainder
        /*
            0 % 5 = 0;
            1 % 5 = 1;  1 / 5 = 0 r1

            13 % 4;  13 / 4 = 3 r1; 13 & 4 = 1;
            9 % 6; 9 / 6 = 1 r3; 9 % 6 = 3;

         */
        if (courseTime % 5 == 0) {
            System.out.println();
            System.out.println("Race report! We are " + courseTime +
                    " seconds into the race!");

            for (int i = 0; i < racers.length; i++ ) {

            }

            // for each Animal (which we are giving a variable name of "racer") in the
            // collection racers, do the following things between the {}.
            for (Animal racer : racers) {
                System.out.println(racer.name + " the " + racer.species +
                        " has travelled " + racer.reportableDistance() + " meters.");
            }

            System.out.println("The leader is " + findCurrentLeader().name
                    + "!");
        }

    }

    public void declareWinner() {
        Animal winner = findCurrentLeader();

//        String myString = "The winner is %s the %s with a time of %s seconds " +
//                "and a distance of %s meters!";
//        String.format(myString, winner.name, winner.species, courseTime,
//                winner.reportableDistance());

        System.out.println("The winner is " + winner.name + " the " +
                winner.species + " with a time of " + courseTime
                + " seconds and a distance of " + winner.reportableDistance() +
                "meters!");
    }

    public Animal findCurrentLeader() {
        Animal winner = racers[0];

        // For each Animal in racers.
        for (Animal racer : racers) {
            if (racer.distance > winner.distance) {
                winner = racer;
            }
        }

        return winner;
    }

    public boolean raceIsWon() {
        boolean isWon = false;
        for (Animal racer : racers) {
            if (racer.distance >= courseDistance) {
                isWon = true;
            }
        }
        return isWon;
    }

    public void moveRacers() {
        /* for each animal, determine what terrain they are in and
            add the amount they moved this turn to their total
            distance
         */
        for (Animal racer : racers) {
            float distanceInTerrainUnits = racer.distance / METERS_PER_TERRAIN; //3.6
            int indexOfTerrain = (int)distanceInTerrainUnits; // 3
            BaseTerrain currentTerrain = terrains[indexOfTerrain];
            float distanceToAdd = racer.distanceThisTick(currentTerrain);
            racer.distance = racer.distance + distanceToAdd;
        }
    }

    public void setupRace() {
        courseTime = 0;
        // racers is an Animal[]
        for (int i=0; i < racers.length; i++) {
            racers[i].distance = 0;
        }
        stop = false;
    }

}
