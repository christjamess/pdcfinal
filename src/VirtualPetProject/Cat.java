/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

/**
 *
 * @author madis
 */
public class Cat extends Animal {

    public Cat(String petName) {
        super(petName);
    }

    @Override
    public void fulfillHunger() {
        setHunger(getHunger() + 5);
        setSocial(getSocial() + 10);
        setBladder(getBladder() - 5);
        setEnergy(getEnergy() + 5);
        setFun(getFun() + 10);
    }

    @Override
    public void fulfillSocial() {
        setSocial(getSocial() + 30);
        setHunger(getHunger() - 10);
        setEnergy(getEnergy() + 10);
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
        setEnergy(getEnergy() - 20);
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
        setFun(getFun() + 30);
        setEnergy(getEnergy() - 10);
        setHunger(getHunger() - 10);
        setHygiene(getHygiene() - 10);
    }

}
