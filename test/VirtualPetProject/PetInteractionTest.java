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

public class PetInteractionTest {

    private Animal testPet;

    @Before
    public void setUp() {
        testPet = new Dog("TestDog");
        PetInteraction.setPet(testPet);
    }

    @After
    public void tearDown() {
        testPet = null;
        PetInteraction.setPet(null);
    }

    @Test
    public void testCreateNewPet_ValidPet() {
        System.out.println("createNewPet - valid pet");

        // Simulate user input and file handling for a valid pet
        UserInterfaceTestDouble.setPetType(1); 
        UserInterfaceTestDouble.setPetName("Meow");
        FileHandlerTestDouble.setValidFilePath("./resources/cat.txt");

        PetInteraction.createNewPet();

        assertNotNull("Pet object should not be null", PetInteraction.getPet());
        assertTrue("Pet object should be an instance of Cat", PetInteraction.getPet() instanceof Cat);
    }

    @Test
    public void testCreateNewPet_InvalidPet() {
        System.out.println("createNewPet - invalid pet");

        // Simulate invalid pet selection
        UserInterfaceTestDouble.setPetType(10); // Invalid pet type
        FileHandlerTestDouble.setValidFilePath(null);

        PetInteraction.createNewPet();

        assertNull("Pet object should be null", PetInteraction.getPet());
    }

    @Test
    public void testSetPet() {
        System.out.println("setPet");

        PetInteraction.setPet(testPet);

        assertNotNull("Pet object should not be null", PetInteraction.getPet());
        assertEquals("TestDog", PetInteraction.getPet().getPetName());
    }

    @Test
    public void testHandleFeed() {
        System.out.println("handleFeed");

        testPet.setHunger(60);
        PetInteraction.handleFeed();

        assertTrue(testPet.getHunger() > 60);
    }

    @Test
    public void testHandleFeed_TooFull() {
        System.out.println("handleFeed - too full");

        testPet.setHunger(90);
        PetInteraction.handleFeed();

        assertEquals(90, testPet.getHunger());
    }

    @Test
    public void testHandleCuddle() {
        System.out.println("handleCuddle");

        testPet.setHunger(30);
        PetInteraction.handleCuddle();

        assertTrue(testPet.getSocial() > 30);
    }

    @Test
    public void testHandleCuddle_TooHungry() {
        System.out.println("handleCuddle - too hungry");

        testPet.setHunger(10);
        PetInteraction.handleCuddle();

        assertEquals(10, testPet.getSocial());
    }

    @Test
    public void testHandleToilet() {
        System.out.println("handleToilet");

        testPet.setBladder(40);
        PetInteraction.handleToilet();

        assertTrue(testPet.getBladder() > 40);
    }

    @Test
    public void testHandleToilet_NotNeeded() {
        System.out.println("handleToilet - not needed");

        testPet.setBladder(70);
        PetInteraction.handleToilet();

        assertEquals(70, testPet.getBladder());
    }

    @Test
    public void testHandleBath() {
        System.out.println("handleBath");

        testPet.setEnergy(60);
        PetInteraction.handleBath();

        assertTrue(testPet.getHygiene() > 50);
    }

    @Test
    public void testHandleBath_TooTired() {
        System.out.println("handleBath - too tired");

        testPet.setEnergy(40);
        PetInteraction.handleBath();

        assertEquals(40, testPet.getHygiene());
    }

    @Test
    public void testHandleSleep() {
        System.out.println("handleSleep");

        testPet.setEnergy(60);
        PetInteraction.handleSleep();

        assertTrue(testPet.getEnergy() > 60);
    }

    @Test
    public void testHandleSleep_FullOfEnergy() {
        System.out.println("handleSleep - full of energy");

        testPet.setEnergy(80);
        PetInteraction.handleSleep();

        assertEquals(80, testPet.getEnergy());
    }

    @Test
    public void testHandlePlay() {
        System.out.println("handlePlay");

        testPet.setEnergy(40);
        testPet.setHunger(40);
        PetInteraction.handlePlay();

        assertTrue(testPet.getFun() > 40);
    }

    @Test
    public void testHandlePlay_TooTired() {
        System.out.println("handlePlay - too tired");

        testPet.setEnergy(20);
        PetInteraction.handlePlay();

        assertEquals(20, testPet.getFun());
    }

    @Test
    public void testHandlePlay_TooHungry() {
        System.out.println("handlePlay - too hungry");

        testPet.setEnergy(40);
        testPet.setHunger(20);
        PetInteraction.handlePlay();

        assertEquals(20, testPet.getFun());
    }

    @Test
    public void testSaveAndExit() {
        System.out.println("saveAndExit");

        testPet.setPetName("Woof");
        PetInteraction.setPet(testPet);
        PetInteraction.saveAndExit();

        assertTrue(true); 
    }

    // Test double classes for UserInterface and FileHandler
    static class UserInterfaceTestDouble {
        private static int petType;
        private static String petName;

        public static void setPetType(int petType) {
            UserInterfaceTestDouble.petType = petType;
        }

        public static void setPetName(String petName) {
            UserInterfaceTestDouble.petName = petName;
        }

        public static int selectPet() {
            return petType;
        }

        public static String getPetName() {
            return petName;
        }

        public static void displayMessage(String message) {
            System.out.println("Mocked Display Message: " + message);
        }

        public static char getNeedChoice() {
            return '1'; 
        }

        public static void displayInvalidChoiceMessage() {
            System.out.println("Mocked Invalid Choice Message");
        }

        public static void displayExitMenu() {
            System.out.println("Mocked Exit Menu Display");
        }
    }

    static class FileHandlerTestDouble {
        private static String validFilePath;

        public static void setValidFilePath(String filePath) {
            FileHandlerTestDouble.validFilePath = filePath;
        }

        public static String getFilePath(int pet) {
            if (pet == 1) {
                return validFilePath;
            }
            return null;
        }

        public static void readFromFile(String filePath) {
            System.out.println("Mocked Reading from File: " + filePath);
        }
    }

    static class VirtualPetLogicTestDouble {
        public static Animal createPet(int petType, String petName) {
            if (petType == 1) {
                return new Cat(petName);
            }
            return null;
        }
    }
}


