/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.util.InputMismatchException;

/**
 *
 * @author madis
 */
public class Dog extends Animal {

    public Dog(String petName) {
        super(petName);
    }

    @Override
    public void fulfillHunger() {
        setHunger(getHunger() + 30);
        setSocial(getSocial() + 5);
        setBladder(getBladder() - 10);
        setEnergy(getEnergy() + 10);
        setFun(getFun() + 5);
    }

    @Override
    public void fulfillSocial() {
        setSocial(getSocial() + 40);
        setHunger(getHunger() - 5);
        setEnergy(getEnergy() + 15);
        setFun(getFun() + 20);
    }

    @Override
    public void fulfillBladder() {
        setBladder(getBladder() + 40);
        setHygiene(getHygiene() - 20);
    }

    @Override
    public void fulfillHygiene() {
        setHygiene(getHygiene() + 40);
    }

    @Override
    public void fulfillEnergy() {
        setEnergy(getEnergy() + 40);
        setHunger(getHunger() - 20);
        setSocial(getSocial() - 15);
        setBladder(getBladder() - 20);
        setFun(getFun() - 10);

    }

    @Override
    public void fulfillFun() {
        setFun(getFun() + 40);
        setEnergy(getEnergy() - 20);
        setHunger(getHunger() - 20);
        setHygiene(getHygiene() - 20);
    }
}
