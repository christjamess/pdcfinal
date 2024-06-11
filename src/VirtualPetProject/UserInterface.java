/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;



/**
 *
 * @author madis
 */
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class UserInterface {

    private static final Scanner scanner = new Scanner(System.in);

    public static void displayWelcomeMessage() {
        System.out.println("Welcome to V-Pet!");
    }

    public static char getMainMenuChoice() {
        System.out.println("\nWould you like to:");
        System.out.println("1. Create a new pet");
        System.out.println("2. Load a saved pet");
        System.out.println("3. Exit");
        return scanner.next().charAt(0);
    }

    public static void displayInvalidChoiceMessage() {
        System.out.println("Invalid choice. Please try again.");
    }

    public static int selectPet() {
        int pet;
        System.out.println("Select your animal below:");
        System.out.println("1. Cat\n2. Dog\n");
        while (true) {
            try {
                pet = scanner.nextInt();
                if (pet < 1 || pet > 2) {
                    System.out.println("Invalid pet selection. Please try again:");
                } else {
                    break;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine();
            }
        }
        return pet;
    }

    public static String getPetName() {
        System.out.println("Say hello to your new friend! What would you like to name them?");
        scanner.nextLine();
        return scanner.nextLine();
    }

    public static void displayMessage(String message) {
        System.out.println(message);
    }

    public static char getNeedChoice() {
        System.out.println("Select a need to fulfill or press 'n' to create a new pet:\nSelect 'x' to save and exit.");
        System.out.println("1. Feed\n2. Cuddle\n3. Toilet\n4. Bath\n5. Sleep\n6. Play");
        return scanner.next().charAt(0);
    }

    public static int getUserIntChoice(int min, int max) {
        int choice = 0;
        boolean valid = false;

        while (!valid) {
            try {
                choice = scanner.nextInt();
                if (choice >= min && choice <= max) {
                    valid = true;
                } else {
                    System.out.println("Invalid choice. Please enter a number between " + min + " and " + max + ".");
                }
            } catch (InputMismatchException e) {
                scanner.nextLine(); // Clear the invalid input
                System.out.println("Invalid input. Please enter a valid integer.");
            }
        }
        return choice;
    }

    public static int displayPetSelectionMenu(List<Animal> existingPets) {
        System.out.println("Select a pet to play with:");
        int index = 1;
        for (Animal pet : existingPets) {
            System.out.println(index + ". " + pet.getPetName() + " (" + pet.getClass().getSimpleName() + ")");
            index++;
        }
        return getUserIntChoice(1, existingPets.size());
    }

    public static void displayExitMenu() {
        System.out.println("Exiting V-Pet. Goodbye!");
        System.exit(0);
    }

    public static void closeScanner() {
        scanner.close();
    }
}
