/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioactiveplants;

/**
 * This class implements the abstract class plant and overrides its methods.
 *
 * @author artur
 */
public class Deltatree extends Plant {

    /**
     * This calls the parent constructor with specified name and nutrients.
     *
     * @param name
     * @param nutrients
     */
    public Deltatree(String name, int nutrients) {
        super(name, nutrients);
    }

    /**
     * This calls affectDeltatree method of the given radiation.
     *
     * @param radiation
     */
    @Override
    public void reactToRadiation(Radiation radiation) {
        radiation.affectDeltatree(this);
    }

    /**
     * This sets living to true if nutrients are greater than 0, otherwise,
     * false.
     */
    @Override
    public void handleLiving() {
        this.setLiving(this.getNutrients() > 0);
    }

}
