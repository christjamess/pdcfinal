/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package VirtualPetProject;


/**
 *
 * @author madis
 */
import java.util.List;

public class VirtualPetProjectCLI {

    public static void main(String[] args) {
        DatabaseSetup dbManager = new DatabaseSetup();
        List<Animal> existingPets = DatabaseSetup.loadExistingPets();

        UserInterface.displayWelcomeMessage();

        char choice;
        do {
            choice = UserInterface.getMainMenuChoice();
            switch (choice) {
                case '1':
                    PetInteraction.createNewPet();
                    break;
                case '2':
                    if (!existingPets.isEmpty()) {
                        int petChoice = UserInterface.displayPetSelectionMenu(existingPets);
                        if (petChoice >= 1 && petChoice <= existingPets.size()) {
                            PetInteraction.setPet(existingPets.get(petChoice - 1));
                        } else {
                            UserInterface.displayMessage("Invalid pet selection. Please try again.");
                        }
                    } else {
                        UserInterface.displayMessage("No pets available to load.");
                    }
                    break;
                case '3':
                    UserInterface.displayExitMenu();
                    return;
                default:
                    UserInterface.displayInvalidChoiceMessage();
            }
        } while (choice != '3');

        new DatabaseSetup().closeConnections();
        UserInterface.closeScanner();
    }
}
