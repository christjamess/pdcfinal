/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madis
 */

public class AnimalTest {

    private Animal instance;

    public AnimalTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Dog("TestPet");
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setAttributes method, of class Animal.
     */
    @Test
    public void testSetAttributes() {
        System.out.println("setAttributes");
        int hunger = 30;
        int social = 40;
        int bladder = 50;
        int hygiene = 60;
        int energy = 70;
        int fun = 80;
        instance.setAttributes(hunger, social, bladder, hygiene, energy, fun);
        assertEquals(hunger, instance.getHunger());
        assertEquals(social, instance.getSocial());
        assertEquals(bladder, instance.getBladder());
        assertEquals(hygiene, instance.getHygiene());
        assertEquals(energy, instance.getEnergy());
        assertEquals(fun, instance.getFun());
    }

    /**
     * Test of getPetName method, of class Animal.
     */
    @Test
    public void testGetPetName() {
        System.out.println("getPetName");
        String expResult = "TestPet";
        String result = instance.getPetName();
        assertEquals(expResult, result);
    }

    /**
     * Test of getHunger method, of class Animal.
     */
    @Test
    public void testGetHunger() {
        System.out.println("getHunger");
        int expResult = 50; // Initial value set in the constructor
        int result = instance.getHunger();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHunger method, of class Animal.
     */
    @Test
    public void testSetHunger() {
        System.out.println("setHunger");
        int hunger = 30;
        instance.setHunger(hunger);
        assertEquals(hunger, instance.getHunger());
    }

    /**
     * Test of getSocial method, of class Animal.
     */
    @Test
    public void testGetSocial() {
        System.out.println("getSocial");
        int expResult = 50; // Initial value set in the constructor
        int result = instance.getSocial();
        assertEquals(expResult, result);
    }

    /**
     * Test of setSocial method, of class Animal.
     */
    @Test
    public void testSetSocial() {
        System.out.println("setSocial");
        int social = 60;
        instance.setSocial(social);
        assertEquals(social, instance.getSocial());
    }

    /**
     * Test of getBladder method, of class Animal.
     */
    @Test
    public void testGetBladder() {
        System.out.println("getBladder");
        int expResult = 50; // Initial value set in the constructor
        int result = instance.getBladder();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBladder method, of class Animal.
     */
    @Test
    public void testSetBladder() {
        System.out.println("setBladder");
        int bladder = 40;
        instance.setBladder(bladder);
        assertEquals(bladder, instance.getBladder());
    }

    /**
     * Test of getHygiene method, of class Animal.
     */
    @Test
    public void testGetHygiene() {
        System.out.println("getHygiene");
        int expResult = 50; // Initial value set in the constructor
        int result = instance.getHygiene();
        assertEquals(expResult, result);
    }

    /**
     * Test of setHygiene method, of class Animal.
     */
    @Test
    public void testSetHygiene() {
        System.out.println("setHygiene");
        int hygiene = 70;
        instance.setHygiene(hygiene);
        assertEquals(hygiene, instance.getHygiene());
    }

    /**
     * Test of getEnergy method, of class Animal.
     */
    @Test
    public void testGetEnergy() {
        System.out.println("getEnergy");
        int expResult = 50; // Initial value set in the constructor
        int result = instance.getEnergy();
        assertEquals(expResult, result);
    }

    /**
     * Test of setEnergy method, of class Animal.
     */
    @Test
    public void testSetEnergy() {
        System.out.println("setEnergy");
        int energy = 90;
        instance.setEnergy(energy);
        assertEquals(energy, instance.getEnergy());
    }

    /**
     * Test of getFun method, of class Animal.
     */
    @Test
    public void testGetFun() {
        System.out.println("getFun");
        int expResult = 50; // Initial value set in the constructor
        int result = instance.getFun();
        assertEquals(expResult, result);
    }

    /**
     * Test of setFun method, of class Animal.
     */
    @Test
    public void testSetFun() {
        System.out.println("setFun");
        int fun = 80;
        instance.setFun(fun);
        assertEquals(fun, instance.getFun());
    }

    /**
     * Test of displayNeeds method, of class Animal.
     */
    @Test
    public void testDisplayNeeds() {
        System.out.println("displayNeeds");
        String expResult = "TestPet's Needs:\n Hunger: 50\n Social: 50\n Bladder: 50\n Hygiene: 50\n Energy: 50\n Fun: 50\n";
        String result = instance.displayNeeds();
        assertEquals(expResult, result);
    }
    
    public class AnimalImpl extends Animal {

        public AnimalImpl() {
            super("");
        }

        @Override
        public void fulfillHunger() {
        }

        @Override
        public void fulfillSocial() {
        }

        @Override
        public void fulfillBladder() {
        }

        @Override
        public void fulfillHygiene() {
        }

        @Override
        public void fulfillEnergy() {
        }

        @Override
        public void fulfillFun() {
        }

    }
    
}
