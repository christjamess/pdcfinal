/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

/**
 *
 * @author madis
 */
public class PetInteraction {

    private static Animal petObject;

    public static void createNewPet() {
        int petType = UserInterface.selectPet();
        String filePath = FileHandler.getFilePath(petType);
        if (filePath == null) {
            UserInterface.displayMessage("Invalid pet selection.");
            return;
        }
        FileHandler.readFromFile(filePath);
        String petName = UserInterface.getPetName();
        petObject = VirtualPetLogic.createPet(petType, petName);
        if (petObject == null) {
            UserInterface.displayMessage("Invalid pet selection.");
            return;
        }
        interactWithPet(petObject);
    }

    public static void setPet(Animal pet) {
        petObject = pet;
        UserInterface.displayMessage("Selected pet: " + pet.getPetName() + " (" + pet.getClass().getSimpleName() + ")");
        interactWithPet(pet);
    }

    public static void interactWithPet(Animal petObject) {
        char choice;
        do {
            System.out.println(petObject.displayNeeds());
            choice = UserInterface.getNeedChoice();
            if (Character.isDigit(choice)) {
                int need = Character.getNumericValue(choice);
                switch (need) {
                    case 1:
                        handleFeed();
                        break;
                    case 2:
                        handleCuddle();
                        break;
                    case 3:
                        handleToilet();
                        break;
                    case 4:
                        handleBath();
                        break;
                    case 5:
                        handleSleep();
                        break;
                    case 6:
                        handlePlay();
                        break;
                    default:
                        UserInterface.displayInvalidChoiceMessage();
                        break;
                }
            } else if (choice == 'n') {
                createNewPet();
                return;
            } else if (choice == 'x') {
                saveAndExit();
            } else {
                UserInterface.displayInvalidChoiceMessage();
            }
        } while (choice != 'x');
    }

    private static void handleFeed() {
        if (petObject.getHunger() > 80) {
            System.out.println(petObject.getPetName() + " is too full! Try a different interaction.");
        } else {
            petObject.fulfillHunger();
            System.out.println("Great! You fed " + petObject.getPetName() + ".");
        }
    }

    private static void handleCuddle() {
        if (petObject.getHunger() < 20) {
            System.out.println(petObject.getPetName() + " is too hungry to interact! Try a different interaction.");
        } else {
            petObject.fulfillSocial();
            System.out.println("Great! You cuddled with " + petObject.getPetName() + ".");
        }
    }

    private static void handleToilet() {
        if (petObject.getBladder() > 50) {
            System.out.println(petObject.getPetName() + " doesn't need the toilet right now! Try a different interaction.");
        } else {
            petObject.fulfillBladder();
            System.out.println("Great! " + petObject.getPetName() + " went to the toilet.");
        }
    }

    private static void handleBath() {
        if (petObject.getEnergy() < 50) {  
            System.out.println(petObject.getPetName() + " is too tired to bathe! Try a different interaction.");
        } else {
            petObject.fulfillHygiene();
            System.out.println("Great! You bathed " + petObject.getPetName() + ".");
        }
    }

    private static void handleSleep() {
        if (petObject.getEnergy() > 70) {
            System.out.println(petObject.getPetName() + " is full of energy! Try a different interaction.");
        } else {
            petObject.fulfillEnergy();
            System.out.println("Great! " + petObject.getPetName() + " slept.");
        }
    }

    private static void handlePlay() {
        if (petObject.getEnergy() < 30) {
            System.out.println(petObject.getPetName() + " is too tired to play! Try a different interaction.");
        } else if (petObject.getHunger() < 30) {  
            System.out.println(petObject.getPetName() + " is too hungry to play! Try a different interaction.");
        } else {
            petObject.fulfillFun();
            System.out.println("Great! You played with " + petObject.getPetName() + ".");
        }
    }

    private static void saveAndExit() {
        DatabaseSetup.saveNewPet(petObject);
        UserInterface.displayExitMenu();
    }
}
