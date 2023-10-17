/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioactiveplants;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * This class serves as a client between the radiation and plant classes and
 * simulates the environment.
 *
 * @author artur
 */
public class Simulation {

    private int numberOfDays;
    private ArrayList<Plant> plants;

    /**
     * This constructs a plant with a specified filename; It reads out the data
     * from the file.
     *
     * @param filename
     * @throws FileNotFoundException
     */
    public Simulation(String filename) throws FileNotFoundException {
        this.plants = new ArrayList<>();
        File file = new File(filename);
        Pattern namePattern = Pattern.compile("\\S+");
        Pattern typePattern = Pattern.compile("[pdb]");
        Pattern nutrientsPattern = Pattern.compile("[-]?\\d+");
        try (Scanner sc = new Scanner(file)) {
            while (sc.hasNextLine()) {
                int numberOfPlants = sc.nextInt();
                for (int i = 0; i < numberOfPlants; i++) {
                    String name = sc.next(namePattern);
                    String type = sc.next(typePattern);
                    int nutrients = Integer.parseInt(sc.next(nutrientsPattern));
                    switch (type) {
                        case "p" ->
                            this.plants.add(new Puffs(name, nutrients));
                        case "d" ->
                            this.plants.add(new Deltatree(name, nutrients));
                        case "b" ->
                            this.plants.add(new Parabush(name, nutrients));
                    }
                }
                this.numberOfDays = sc.nextInt();
            }
        }
    }

    /**
     * This simulates the environment.
     */
    public void simulate() {
        ArrayList<Plant> plantsToRemove = new ArrayList<>();
        handleInitialDeadPlants(plantsToRemove);
        Radiation radiation = NoRadiation.getInstance();
        for (int i = 0; i < this.numberOfDays; i++) {
            handleOneDay(radiation, plantsToRemove, i);
            radiation = Radiation.calculateNextDayRadiation(plants);
        }
    }

    /**
     * This handles the plants which are not alive initially.
     *
     * @param plantsToRemove
     */
    private void handleInitialDeadPlants(ArrayList<Plant> plantsToRemove) {
        System.out.println("Let's start our simulation with getting rid of the dead plants!\n");
        for (Plant plant : plants) {
            if (!plant.getLiving()) {
                plantsToRemove.add(plant);
                System.out.println(plant + " could not survive in such harsh environment.\n");
            }
        }
        if (plantsToRemove.isEmpty()) {
            System.out.println("All the plants are alive!\n");
        }
        plants.removeAll(plantsToRemove);
        plantsToRemove.clear();
    }

    /**
     * This handles one day of the simulation.
     *
     * @param radiation
     * @param plantsToRemove
     * @param day
     */
    private void handleOneDay(Radiation radiation, ArrayList<Plant> plantsToRemove, int day) {
        System.out.println(String.format("-------Day #%d starting-------", day + 1));
        System.out.println(radiation);
        for (Plant plant : plants) {
            plant.reactToRadiation(radiation);
            plant.handleLiving();
            if (!plant.getLiving()) {
                plantsToRemove.add(plant);
                System.out.println(plant + " could not survive in such harsh environment.");
            } else {
                System.out.println(plant);
            }
        }
        plants.removeAll(plantsToRemove);
        System.out.println(String.format("-------Day #%d finished-------\n", day + 1));
    }

}
