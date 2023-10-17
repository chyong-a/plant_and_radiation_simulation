/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package radioactiveplants;

/**
 * This class implements the abstract class radiation and overrides its methods.
 *
 * @author artur
 */
public class Alpha extends Radiation {

    private static Alpha instance;

    /**
     * Private constructor represents singleton design pattern.
     */
    private Alpha() {
    }

    /**
     * Returns instance of Alpha
     *
     * @return instance of Alpha
     */
    public static Alpha getInstance() {
        if (instance == null) {
            instance = new Alpha();
        }
        return instance;
    }

    /**
     * This modifies the nutrients of the given puffs by adding 2.
     *
     * @param puffs
     */
    @Override
    public void affectPuffs(Puffs puffs) {
        puffs.setNutrients(puffs.getNutrients() + 2);
    }

    /**
     * This modifies the nutrients of the given deltatree by subtracting 3.
     *
     * @param deltatree
     */
    @Override
    public void affectDeltatree(Deltatree deltatree) {
        deltatree.setNutrients(deltatree.getNutrients() - 3);
    }

    /**
     * This modifies the nutrients of the given parabush by adding 1.
     *
     * @param parabush
     */
    @Override
    public void affectParabush(Parabush parabush) {
        parabush.setNutrients(parabush.getNutrients() + 1);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return "~~~~~~Alpha radiation day~~~~~~";
    }
}
