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
public class NoRadiation extends Radiation {

    private static NoRadiation instance;

    /**
     * Private constructor represents singleton design pattern.
     */
    private NoRadiation() {
    }

    /**
     * Returns instance of NoRadiation
     *
     * @return instance of NoRadiation
     */
    public static NoRadiation getInstance() {
        if (instance == null) {
            instance = new NoRadiation();
        }
        return instance;
    }

    /**
     * This modifies the nutrients of the given puffs by subtracting 1.
     *
     * @param puffs
     */
    @Override
    public void affectPuffs(Puffs puffs) {
        puffs.setNutrients(puffs.getNutrients() - 1);
    }

    /**
     * This modifies the nutrients of the given puffs by subtracting 1.
     *
     * @param deltatree
     */
    @Override
    public void affectDeltatree(Deltatree deltatree) {
        deltatree.setNutrients(deltatree.getNutrients() - 1);
    }

    /**
     * This modifies the nutrients of the given puffs by subtracting 1.
     *
     * @param parabush
     */
    @Override
    public void affectParabush(Parabush parabush) {
        parabush.setNutrients(parabush.getNutrients() - 1);
    }

    /**
     * Returns a string representation of the object.
     *
     * @return the string itself.
     */
    @Override
    public String toString() {
        return "~~~~~~No radiation day~~~~~~";
    }
}
