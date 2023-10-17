/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioactiveplants;

/**
 * This abstract class serves as a parent class of plants.
 *
 * @author artur
 */
public abstract class Plant {

    private final String name;
    private int nutrients;
    private boolean living;

    /**
     * This constructs a plant with specified name and nutrients, and sets
     * living to true by default.
     *
     * @param name
     * @param nutrients
     */
    public Plant(String name, int nutrients) {
        this.name = name;
        this.nutrients = nutrients;
        this.living = true;
    }

    public int getNutrients() {
        return nutrients;
    }

    public void setNutrients(int nutrients) {
        this.nutrients = nutrients;
    }

    public void setLiving(boolean living) {
        this.living = living;
    }

    public boolean getLiving() {
        return this.living;
    }

    /**
     * This abstract method sets living to true or false in the accordance with
     * nutrients, override in the children classes.
     */
    public abstract void handleLiving();

    /**
     * This abstract method modifies nutrients in the accordance with radiation
     * given, override in the children classes.
     *
     * @param radiation
     */
    public abstract void reactToRadiation(Radiation radiation);

    /**
     * Returns a string representation of the object.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return this.name + ": nutrients(" + this.nutrients + "), alive(" + this.living + ")";
    }

}
