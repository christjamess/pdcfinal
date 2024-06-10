/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

/**
 *
 * @author madis
 */
public class VirtualPetLogic {

    public static Animal createPet(int pet, String petName) {
        switch (pet) {
            case 1:
                return new Cat(petName);
            case 2:
                return new Dog(petName);
            default:
                return null;
        }
    }
}
