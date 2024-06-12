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

public class DogTest {

    private Dog instance;

    public DogTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        instance = new Dog("TestDog");
    }

    @After
    public void tearDown() {
        instance = null;
    }

    @Test
    public void testFulfillHunger() {
        System.out.println("fulfillHunger");

        instance.setHunger(30);
        instance.setSocial(50);
        instance.setBladder(50);
        instance.setHygiene(50);
        instance.setEnergy(50);
        instance.setFun(50);

        instance.fulfillHunger();

        assertEquals(80, instance.getHunger());
        assertEquals(45, instance.getSocial());
        assertEquals(45, instance.getBladder());
        assertEquals(45, instance.getHygiene());
        assertEquals(45, instance.getEnergy());
        assertEquals(45, instance.getFun());
    }

    @Test
    public void testFulfillSocial() {
        System.out.println("fulfillSocial");

        instance.setHunger(50);
        instance.setSocial(30);
        instance.setBladder(50);
        instance.setHygiene(50);
        instance.setEnergy(50);
        instance.setFun(50);

        instance.fulfillSocial();

        assertEquals(45, instance.getHunger());
        assertEquals(80, instance.getSocial());
        assertEquals(45, instance.getBladder());
        assertEquals(45, instance.getHygiene());
        assertEquals(60, instance.getEnergy());
    }

    @Test
    public void testFulfillBladder() {
        System.out.println("fulfillBladder");

        instance.setHunger(50);
        instance.setSocial(50);
        instance.setBladder(30);
        instance.setHygiene(50);
        instance.setEnergy(50);
        instance.setFun(50);

        instance.fulfillBladder();

        assertEquals(45, instance.getHunger());
        assertEquals(45, instance.getSocial());
        assertEquals(80, instance.getBladder());
        assertEquals(30, instance.getHygiene());
        assertEquals(45, instance.getEnergy());
        assertEquals(45, instance.getFun());
    }

    @Test
    public void testFulfillHygiene() {
        System.out.println("fulfillHygiene");

        instance.setHunger(50);
        instance.setSocial(50);
        instance.setBladder(50);
        instance.setHygiene(30);
        instance.setEnergy(50);
        instance.setFun(50);

        instance.fulfillHygiene();

        assertEquals(45, instance.getHunger());
        assertEquals(45, instance.getSocial());
        assertEquals(45, instance.getBladder());
        assertEquals(80, instance.getHygiene());
        assertEquals(45, instance.getEnergy());
        assertEquals(45, instance.getFun());
    }

    @Test
    public void testFulfillEnergy() {
        System.out.println("fulfillEnergy");

        instance.setHunger(50);
        instance.setSocial(50);
        instance.setBladder(50);
        instance.setHygiene(50);
        instance.setEnergy(30);
        instance.setFun(50);

        instance.fulfillEnergy();

        assertEquals(45, instance.getHunger());
        assertEquals(45, instance.getSocial());
        assertEquals(40, instance.getBladder());
        assertEquals(45, instance.getHygiene());
        assertEquals(80, instance.getEnergy());
        assertEquals(40, instance.getFun());
    }

    @Test
    public void testFulfillFun() {
        System.out.println("fulfillFun");

        instance.setHunger(50);
        instance.setSocial(50);
        instance.setBladder(50);
        instance.setHygiene(50);
        instance.setEnergy(50);
        instance.setFun(30);

        instance.fulfillFun();

        assertEquals(45, instance.getHunger());
        assertEquals(60, instance.getSocial());
        assertEquals(45, instance.getBladder());
        assertEquals(45, instance.getHygiene());
        assertEquals(45, instance.getEnergy());
        assertEquals(80, instance.getFun());
    }
}

