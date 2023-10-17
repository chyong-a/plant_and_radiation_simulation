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
public class Delta extends Radiation {

    private static Delta instance;

    /**
     * Private constructor represents singleton design pattern.
     */
    private Delta() {
    }

    /**
     * Returns instance of Delta
     *
     * @return instance of Delta
     */
    public static Delta getInstance() {
        if (instance == null) {
            instance = new Delta();
        }
        return instance;
    }

    /**
     * This modifies the nutrients of the given puffs by subtracting 2.
     *
     * @param puffs
     */
    @Override
    public void affectPuffs(Puffs puffs) {
        puffs.setNutrients(puffs.getNutrients() - 2);
    }

    /**
     * This modifies the nutrients of the given deltatree by adding 4.
     *
     * @param deltatree
     */
    @Override
    public void affectDeltatree(Deltatree deltatree) {
        deltatree.setNutrients(deltatree.getNutrients() + 4);
    }

    /**
     * This modifies the nutrients of the given puffs by adding 1.
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
        return "~~~~~~Delta radiation day~~~~~~";
    }

}
