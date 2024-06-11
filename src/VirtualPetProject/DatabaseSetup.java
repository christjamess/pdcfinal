/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.ResultSet;
import java.sql.PreparedStatement;

/**
 *
 * @author madis
 */
public class DatabaseSetup {

    private static final String URL = "jdbc:derby:VirtualPetDB;create=true";
    private static final String USERNAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password

    private static Connection connection;
    private static Statement statement;

    static {
        establishConnection();
        connection = getConnection();
        try {
            statement = connection.createStatement();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        initializeDatabase();
    }

    public static Connection getConnection() {
        return connection;
    }

    private static void establishConnection() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println(URL + " Connected successfully");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (connection != null) {
            try {
                connection.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void initializeDatabase() {
        try {
            statement.addBatch("CREATE TABLE PETS (NAME VARCHAR(30) NOT NULL, TYPE VARCHAR(5) NOT NULL, HUNGRY INT, SOCIAL INT, BLADDER INT, HYGIENE INT, ENERGY INT, FUN INT)");
            statement.addBatch("INSERT INTO PETS VALUES ('Gizmo', 'Cat','30','20','70','80','60', '55'),\n"
                    + "('Belle', 'Cat', '60', '80', '50', '90', '70', '40'),\n"
                    + "('Minnie', 'Cat', '40', '50', '20', '25', '75, 30'),\n"
                    + "('Boogie','Dog', '50', '40', '50', '20', '60', '45'),\n"
                    + "('Bronx', 'Dog', '70', '30', '40', '50', '90', '60'),\n");
            statement.executeBatch();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static List<Animal> loadExistingPets() {
        List<Animal> pets = new ArrayList<>();
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM PETS");
            while (result.next()) {
                String name = result.getString("NAME");
                String type = result.getString("TYPE");
                int hunger = result.getInt("HUNGER");
                int social = result.getInt("SOCIAL");
                int bladder = result.getInt("BLADDER");
                int hygiene = result.getInt("HYGIENE");
                int energy = result.getInt("ENERGY");
                int fun = result.getInt("FUN");

                Animal pet;
                if (null == type) {
                    throw new IllegalArgumentException("Invalid pet type: " + type);
                } else {
                    switch (type) {
                        case "Dog":
                            pet = new Dog(name);
                            break;
                        case "Cat":
                            pet = new Cat(name);
                            break;
                        default:
                            throw new IllegalArgumentException("Invalid pet type: " + type);
                    }
                }

                if (pet instanceof Cat) {
                    ((Cat) pet).setAttributes(hunger, social, bladder, hygiene, energy, fun);
                    pets.add(pet);
                } else if (pet instanceof Dog) {
                    ((Dog) pet).setAttributes(hunger, social, bladder, hygiene, energy, fun);
                    pets.add(pet);
                }
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return pets;
    }

    public static void saveNewPet(Animal pet) {
        try {
            ResultSet result = statement.executeQuery("SELECT * FROM PETS WHERE NAME = '" + pet.getPetName() + "'");
            if (result.next()) {
                try ( PreparedStatement updateStatement = connection.prepareStatement(
                        "UPDATE PETS SET HUNGER = ?, SOCIAL = ?, BLADDER = ?, HYGIENE = ?, ENERGY = ?, FUN = ? WHERE NAME = ?")) {
                    updateStatement.setInt(1, pet.getHunger());
                    updateStatement.setInt(2, pet.getSocial());
                    updateStatement.setInt(3, pet.getBladder());
                    updateStatement.setInt(4, pet.getHygiene());
                    updateStatement.setInt(5, pet.getEnergy());
                    updateStatement.setInt(6, pet.getFun());
                    updateStatement.setString(7, pet.getPetName());
                }
            } else {
                try ( PreparedStatement insertStatement = connection.prepareStatement(""
                        + "INSERT INTO PET VALUES (?, ?, ?, ?, ?, ?, ?, ?")) {
                    insertStatement.setString(1, pet.getPetName());
                    if (pet instanceof Cat) {
                        insertStatement.setString(2, "Cat");
                    } else if (pet instanceof Dog) {
                        insertStatement.setString(2, "Dog");
                    } else {
                        throw new IllegalArgumentException("Invalid Pet Type.");
                    }
                    insertStatement.setInt(3, pet.getHunger());
                    insertStatement.setInt(4, pet.getSocial());
                    insertStatement.setInt(5, pet.getBladder());
                    insertStatement.setInt(6, pet.getHygiene());
                    insertStatement.setInt(7, pet.getEnergy());
                    insertStatement.setInt(8, pet.getFun());

                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

}
