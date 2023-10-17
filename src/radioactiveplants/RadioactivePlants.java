package radioactiveplants;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * This class is an entry class.
 *
 * @author artur
 */
public class RadioactivePlants {

    public static void main(String[] args) {
        try {
            Scanner in = new Scanner(System.in);
            System.out.println("Please, provide the file path");
            String filepath = in.nextLine();
            Simulation simulation = new Simulation(filepath);
            simulation.simulate();
        } catch (FileNotFoundException ex) {
            System.err.println("File not found!");
        } catch (InputMismatchException ex) {
            System.err.println("Data in the wrong format was provided!");
        }
    }
}
