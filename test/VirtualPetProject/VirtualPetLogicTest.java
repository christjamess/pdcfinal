/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author madis
 */

public class VirtualPetLogicTest {

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void testCreatePet_Cat() {
        System.out.println("createPet - Cat");

        Animal pet = VirtualPetLogic.createPet(1, "Meow");
        assertNotNull("Pet object should not be null", pet);
        assertTrue("Pet object should be an instance of Cat", pet instanceof Cat);
        assertEquals("Meow", pet.getPetName());
    }

    @Test
    public void testCreatePet_Dog() {
        System.out.println("createPet - Dog");

        Animal pet = VirtualPetLogic.createPet(2, "Woof");
        assertNotNull("Pet object should not be null", pet);
        assertTrue("Pet object should be an instance of Dog", pet instanceof Dog);
        assertEquals("Woof", pet.getPetName());
    }

    @Test
    public void testCreatePet_InvalidPet() {
        System.out.println("createPet - Invalid");

        Animal pet = VirtualPetLogic.createPet(10, "InvalidPet");
        assertNull("Pet object should be null for invalid pet type", pet);
    }
}

