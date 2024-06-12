/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;


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
        setHunger(getHunger() + 50);
        setSocial(getSocial() - 5);
        setBladder(getBladder() - 5);
        setHygiene(getHygiene() - 5);
        setEnergy(getEnergy() - 5);
        setFun(getFun() - 5);
    }

    @Override
    public void fulfillSocial() {
        setHunger(getHunger() - 5);
        setSocial(getSocial() + 50);
        setBladder(getBladder() - 5);
        setHygiene(getHygiene() - 5);
        setEnergy(getEnergy() + 10);
    }

    @Override
    public void fulfillBladder() {
        setHunger(getHunger() - 5);
        setSocial(getSocial() - 5);
        setBladder(getBladder() + 50);
        setHygiene(getHygiene() - 20);
        setEnergy(getEnergy() - 5);
        setFun(getFun() - 5);
    }

    @Override
    public void fulfillHygiene() {
        setHunger(getHunger() - 5);
        setSocial(getSocial() - 5);
        setBladder(getBladder() - 5);
        setHygiene(getHygiene() + 50);
        setEnergy(getEnergy() - 5);
        setFun(getFun() - 5);
    }

    @Override
    public void fulfillEnergy() {
        setHunger(getHunger() - 5);
        setSocial(getSocial() - 5);
        setBladder(getBladder() - 10);
        setHygiene(getHygiene() - 5);
        setEnergy(getEnergy() + 50);
        setFun(getFun() - 10);
    }

    @Override
    public void fulfillFun() {
        setHunger(getHunger() - 5);
        setSocial(getSocial() + 10);
        setBladder(getBladder() - 5);
        setHygiene(getHygiene() - 5);
        setEnergy(getEnergy() - 5);
        setFun(getFun() + 50);
    }

}
