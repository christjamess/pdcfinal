/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package VirtualPetProject;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author madis
 */

 
public class DatabaseSetup {
    
    private static final String URL = "jdbc:derby:VirtualPetDB;create=true";
    private static final String USERNAME = "pdc"; //your DB username
    private static final String PASSWORD = "pdc"; //your DB password

    private static Connection conn;
    private static Statement statement;

    static {
        establishConnection();
        conn = getConnection();
        try {
            statement = conn.createStatement();
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        //initializeDatabase();
    }

    public static Connection getConnection() {
        return conn;
    }

    private static void establishConnection() {
        if (conn == null) {
            try {
                conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
                System.out.println(URL + " Connected Successfully...");
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

}
