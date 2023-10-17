/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioactiveplants;

import java.util.ArrayList;

/**
 * This abstract class serves as a parent class of radiations.
 *
 * @author artur
 */
public abstract class Radiation {

    /**
     * This abstract method modifies nutrients of the given Puffs instance,
     * override in the children classes.
     *
     * @param puffs
     */
    public abstract void affectPuffs(Puffs puffs);

    /**
     * This abstract method modifies nutrients of the given Deltatree instance,
     * override in the children classes.
     *
     * @param deltatree
     */
    public abstract void affectDeltatree(Deltatree deltatree);

    /**
     * This abstract method modifies nutrients of the given Parabush instance,
     * override in the children classes.
     *
     * @param parabush
     */
    public abstract void affectParabush(Parabush parabush);

    /**
     * This calculates the radiation on the next day based on the list of plants
     * provided; if the alpha's need is 3 or more greater than delta's need,
     * then the next day radiation will be alpha; if the delta's need is 3 or
     * more greater than alpha's need, then the next day radiation will be
     * delta; otherwise, no radiation.
     *
     * @param plants
     * @return
     */
    public static Radiation calculateNextDayRadiation(ArrayList<Plant> plants) {
        int nutrients = 0;
        for (Plant plant : plants) {
            nutrients += plant.getNutrients();
        }
        int alphaNeed = 10 - nutrients;
        int deltaNeed = 0;
        if (nutrients < 5) {
            deltaNeed = 4;
        } else if (nutrients >= 5 && nutrients <= 10) {
            deltaNeed = 1;
        }
        if (alphaNeed - deltaNeed >= 3) {
            return Alpha.getInstance();
        } else if (deltaNeed - alphaNeed >= 3) {
            return Delta.getInstance();
        } else {
            return NoRadiation.getInstance();
        }
    }
}
