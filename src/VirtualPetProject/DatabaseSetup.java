/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author madis
 */


import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DatabaseSetup {

    private static final String URL = "jdbc:derby:VirtualPetDB;create=true";
    private static final String USERNAME = "pdc"; // your DB username
    private static final String PASSWORD = "pdc"; // your DB password

    private static Connection connection;
    private static Statement statement;

    static {
        establishConnection();
        if (connection != null) {
            initializeDatabase();
        } else {
            System.err.println("Failed to establish database connection.");
        }
    }

    private static void establishConnection() {
        try {
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            statement = connection.createStatement();
            System.out.println("Connected to database: " + URL);
        } catch (SQLException ex) {
            System.err.println("Connection failed: " + ex.getMessage());
            ex.printStackTrace();
        }
    }
    
    public static Connection getConnection() {
        return connection;
    }

    private static void initializeDatabase() {
        if (!doesTableExist("PETS")) {
            try {
                statement.executeUpdate("CREATE TABLE PETS (" +
                        "NAME VARCHAR(50) NOT NULL, " +
                        "TYPE VARCHAR(10) NOT NULL, " +
                        "HUNGER INT, " +
                        "SOCIAL INT, " +
                        "BLADDER INT, " +
                        "HYGIENE INT, " +
                        "ENERGY INT, " +
                        "FUN INT)");
                System.out.println("Table PETS created successfully.");

                String insertQuery = "INSERT INTO PETS (NAME, TYPE, HUNGER, SOCIAL, BLADDER, HYGIENE, ENERGY, FUN) VALUES " +
                        "('Bronx', 'Dog', 70, 30, 40, 50, 90, 60), " +
                        "('Gizmo', 'Cat', 30, 20, 70, 80, 60, 55), " +
                        "('Belle', 'Cat', 60, 80, 50, 90, 70, 40), " +
                        "('Boogie', 'Dog', 50, 40, 50, 20, 60, 45)";
                statement.executeUpdate(insertQuery);
                System.out.println("Initial data inserted into PETS table.");
            } catch (SQLException ex) {
                System.err.println("Failed to initialize database: " + ex.getMessage());
                ex.printStackTrace();
            }
        } else {
            System.out.println("Table PETS already exists. Skipping creation.");
        }
    }

    private static boolean doesTableExist(String tableName) {
        try (ResultSet rs = connection.getMetaData().getTables(null, null, tableName.toUpperCase(), null)) {
            return rs.next();
        } catch (SQLException e) {
            System.err.println("Error checking if table exists: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }

    public static List<Animal> loadExistingPets() {
        List<Animal> pets = new ArrayList<>();
        try (ResultSet resultSet = statement.executeQuery("SELECT * FROM PETS")) {
            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                String type = resultSet.getString("TYPE");
                int hunger = resultSet.getInt("HUNGER");
                int social = resultSet.getInt("SOCIAL");
                int bladder = resultSet.getInt("BLADDER");
                int hygiene = resultSet.getInt("HYGIENE");
                int energy = resultSet.getInt("ENERGY");
                int fun = resultSet.getInt("FUN");

                Animal pet;
                if ("Dog".equals(type)) {
                    pet = new Dog(name);
                } else if ("Cat".equals(type)) {
                    pet = new Cat(name);
                } else {
                    throw new IllegalArgumentException("Invalid pet type: " + type);
                }

                pet.setAttributes(hunger, social, bladder, hygiene, energy, fun);
                pets.add(pet);
            }
        } catch (SQLException e) {
            System.err.println("Failed to load pets: " + e.getMessage());
            e.printStackTrace();
        }
        return pets;
    }

    public static void saveNewPet(Animal pet) {
        String selectQuery = "SELECT * FROM PETS WHERE NAME = ?";
        String updateQuery = "UPDATE PETS SET HUNGER = ?, SOCIAL = ?, BLADDER = ?, HYGIENE = ?, ENERGY = ?, FUN = ? WHERE NAME = ?";
        String insertQuery = "INSERT INTO PETS (NAME, TYPE, HUNGER, SOCIAL, BLADDER, HYGIENE, ENERGY, FUN) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";

        try (PreparedStatement selectStatement = connection.prepareStatement(selectQuery)) {
            selectStatement.setString(1, pet.getPetName());
            ResultSet result = selectStatement.executeQuery();

            if (result.next()) {
                try (PreparedStatement updateStatement = connection.prepareStatement(updateQuery)) {
                    updateStatement.setInt(1, pet.getHunger());
                    updateStatement.setInt(2, pet.getSocial());
                    updateStatement.setInt(3, pet.getBladder());
                    updateStatement.setInt(4, pet.getHygiene());
                    updateStatement.setInt(5, pet.getEnergy());
                    updateStatement.setInt(6, pet.getFun());
                    updateStatement.setString(7, pet.getPetName());
                    updateStatement.executeUpdate();
                }
            } else {
                try (PreparedStatement insertStatement = connection.prepareStatement(insertQuery)) {
                    insertStatement.setString(1, pet.getPetName());
                    insertStatement.setString(2, pet instanceof Dog ? "Dog" : "Cat");
                    insertStatement.setInt(3, pet.getHunger());
                    insertStatement.setInt(4, pet.getSocial());
                    insertStatement.setInt(5, pet.getBladder());
                    insertStatement.setInt(6, pet.getHygiene());
                    insertStatement.setInt(7, pet.getEnergy());
                    insertStatement.setInt(8, pet.getFun());
                    insertStatement.executeUpdate();
                }
            }
        } catch (SQLException e) {
            System.err.println("Failed to save pet: " + e.getMessage());
            e.printStackTrace();
        }
    }

    public void closeConnections() {
        if (connection != null) {
            try {
                connection.close();
                System.out.println("Database connection closed.");
            } catch (SQLException ex) {
                System.err.println("Failed to close connection: " + ex.getMessage());
                ex.printStackTrace();
            }
        }
    }
}
