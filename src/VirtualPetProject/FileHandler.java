/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author madis
 */
public class FileHandler {
    
    public static String getFilePath(int pet) {
        switch (pet) {
            case 1:
                return "./resources/cat.txt";
            case 2:
                return "./resources/dog.txt";
            case 3:
                return "./resources/rabbit.txt";
            case 4:
                return "./resources/hamster.txt";
            case 5:
                return "./resources/horse.txt";
            default:
                return null;
        }
    }
    
     public static void readFromFile(String filePath) {
        try ( BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                UserInterface.displayMessage(line);
            }
        } catch (FileNotFoundException e) {
            UserInterface.displayMessage("File not found.");
        } catch (IOException e) {
            UserInterface.displayMessage("Error reading the file.");
        }
    }

}
