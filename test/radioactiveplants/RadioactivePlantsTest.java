/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package radioactiveplants;

import java.util.ArrayList;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

/**
 *
 * @author artur
 */
public class RadioactivePlantsTest {

    @Test
    public void plant_basicMethods_successful() {
        Puffs puffs = new Puffs("Puffs", 6);
        Deltatree deltatree = new Deltatree("Deltatree", 6);
        Parabush parabush = new Parabush("Parabush", 6);
        assertNotNull(puffs);
        assertNotNull(deltatree);
        assertNotNull(parabush);
        assertEquals(puffs.getNutrients(), 6);
        assertEquals(deltatree.getNutrients(), 6);
        assertEquals(parabush.getNutrients(), 6);
        assertEquals(puffs.getLiving(), true);
        assertEquals(deltatree.getLiving(), true);
        assertEquals(parabush.getLiving(), true);
        puffs.setNutrients(8);
        deltatree.setNutrients(8);
        parabush.setNutrients(8);
        puffs.setLiving(false);
        deltatree.setLiving(false);
        parabush.setLiving(false);
        assertEquals(puffs.getNutrients(), 8);
        assertEquals(deltatree.getNutrients(), 8);
        assertEquals(parabush.getNutrients(), 8);
        assertEquals(puffs.getLiving(), false);
        assertEquals(deltatree.getLiving(), false);
        assertEquals(parabush.getLiving(), false);
    }

    @Test
    public void handleLiving_nutrientsGood_setLivingTrue() {
        Puffs puffs = new Puffs("Puffs", 6);
        Deltatree deltatree = new Deltatree("Deltatree", 6);
        Parabush parabush = new Parabush("Parabush", 6);
        puffs.handleLiving();
        deltatree.handleLiving();
        parabush.handleLiving();
        assertEquals(puffs.getLiving(), true);
        assertEquals(deltatree.getLiving(), true);
        assertEquals(parabush.getLiving(), true);
    }

    @Test
    public void handleLiving_nutrientsNotGood_setLivingFalse() {
        Puffs puffs = new Puffs("Puffs", 0);
        Deltatree deltatree = new Deltatree("Deltatree", 0);
        Parabush parabush = new Parabush("Parabush", -2);
        puffs.handleLiving();
        deltatree.handleLiving();
        parabush.handleLiving();
        assertEquals(puffs.getLiving(), false);
        assertEquals(deltatree.getLiving(), false);
        assertEquals(parabush.getLiving(), false);
        puffs.setNutrients(15);
        puffs.handleLiving();
        assertEquals(puffs.getLiving(), false);
    }

    @Test
    public void reactToAlpha_livingPlants_changeNutrients() {
        Radiation radiation = Alpha.getInstance();
        Puffs puffs = new Puffs("Puffs", 6);
        Deltatree deltatree = new Deltatree("Deltatree", 6);
        Parabush parabush = new Parabush("Parabush", 6);
        puffs.reactToRadiation(radiation);
        deltatree.reactToRadiation(radiation);
        parabush.reactToRadiation(radiation);
        assertEquals(puffs.getNutrients(), 8);
        assertEquals(deltatree.getNutrients(), 3);
        assertEquals(parabush.getNutrients(), 7);
    }

    @Test
    public void reactToDelta_livingPlants_changeNutrients() {
        Radiation radiation = Delta.getInstance();
        Puffs puffs = new Puffs("Puffs", 6);
        Deltatree deltatree = new Deltatree("Deltatree", 6);
        Parabush parabush = new Parabush("Parabush", 6);
        puffs.reactToRadiation(radiation);
        deltatree.reactToRadiation(radiation);
        parabush.reactToRadiation(radiation);
        assertEquals(puffs.getNutrients(), 4);
        assertEquals(deltatree.getNutrients(), 10);
        assertEquals(parabush.getNutrients(), 7);
    }

    @Test
    public void reactToNoRadiation_livingPlants_changeNutrients() {
        Radiation radiation = NoRadiation.getInstance();
        Puffs puffs = new Puffs("Puffs", 6);
        Deltatree deltatree = new Deltatree("Deltatree", 6);
        Parabush parabush = new Parabush("Parabush", 6);
        puffs.reactToRadiation(radiation);
        deltatree.reactToRadiation(radiation);
        parabush.reactToRadiation(radiation);
        assertEquals(puffs.getNutrients(), 5);
        assertEquals(deltatree.getNutrients(), 5);
        assertEquals(parabush.getNutrients(), 5);
    }

    @Test
    public void calculateNextDayRadiation_alphaNeedIs3orMoreGreaterThanDeltaNeed_nextDayIsAlpha() {
        Puffs puffs = new Puffs("Puffs", 1);
        Deltatree deltatree = new Deltatree("Deltatree", 1);
        Parabush parabush = new Parabush("Parabush", 1);
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(puffs);
        plants.add(deltatree);
        plants.add(parabush);
        Radiation radiation = Radiation.calculateNextDayRadiation(plants);
        assertTrue(radiation instanceof Alpha);
    }

    @Test
    public void calculateNextDayRadiation_deltaNeedIs3orMoreGreaterThanAlphaNeed_nextDayIsDelta() {
        Puffs puffs = new Puffs("Puffs", 5);
        Deltatree deltatree = new Deltatree("Deltatree", 5);
        Parabush parabush = new Parabush("Parabush", 5);
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(puffs);
        plants.add(deltatree);
        plants.add(parabush);
        Radiation radiation = Radiation.calculateNextDayRadiation(plants);
        assertTrue(radiation instanceof Delta);
    }

    @Test
    public void calculateNextDayRadiation_alphaAndDeltaNeedsAreEqual_nextDayIsNoRadiation() {
        Puffs puffs = new Puffs("Puffs", 3);
        Deltatree deltatree = new Deltatree("Deltatree", 3);
        Parabush parabush = new Parabush("Parabush", 3);
        ArrayList<Plant> plants = new ArrayList<>();
        plants.add(puffs);
        plants.add(deltatree);
        plants.add(parabush);
        Radiation radiation = Radiation.calculateNextDayRadiation(plants);
        assertTrue(radiation instanceof NoRadiation);
    }
}
