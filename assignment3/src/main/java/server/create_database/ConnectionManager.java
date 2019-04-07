package main.java.server.create_database;

import main.java.server.data_access_objects.dao_classes.*;
import main.java.server.data_access_objects.dao_interfaces.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for managing a database creation
 * Author: Øyvind Johannessen, Roy H. Jenssen
 * Version: 1.0
 */
public class ConnectionManager implements ConnectionManagerInterface {

    public static void main(String[] args) {
        // Connect to an existing database or create a new database
        // ASSIGNMENT PART A
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect("student_register_database.db");

        // Create a tables
        connectionManager.executeStatement("CREATE TABLE Skole (navn TEXT PRIMARY KEY)");
        connectionManager.executeStatement("CREATE TABLE Kull (kode TEXT PRIMARY KEY, skole TEXT REFERENCES Skole(navn))");
        connectionManager.executeStatement("CREATE TABLE Student (studentNo INTEGER PRIMARY KEY, navn TEXT NOT NULL, kull TEXT REFERENCES Kull(kode))");
        connectionManager.executeStatement("CREATE TABLE Kurs (kode TEXT PRIMARY KEY, navn TEXT NOT NULL, skole TEXT REFERENCES Skole(navn))");
        connectionManager.executeStatement("CREATE TABLE Karakter (id INTEGER PRIMARY KEY, karakter TEXT NOT NULL, ar INTEGER NOT NULL, student TEXT REFERENCES Student(studentNo), kurs TEXT REFERENCES Kurs(kode))");

        // ASSIGNMENT PART B
        connectionManager.executeStatement("INSERT INTO Skole(navn) VALUES('Universitetet i Bergen')");
        connectionManager.executeStatement("INSERT INTO Kull(kode,skole) VALUES('2019V', 'Universitetet i Bergen')");
        connectionManager.executeStatement("INSERT INTO Kurs(kode, navn, skole) VALUES('INFO233', 'Avansert Programmering', 'Universitetet i Bergen')");
        connectionManager.executeStatement("INSERT INTO Student(navn, kull) VALUES('Per', '2019V')");
        connectionManager.executeStatement("INSERT INTO Student(navn, kull) VALUES('Kari', '2019V')");
        connectionManager.executeStatement("INSERT INTO Karakter(karakter, ar, student, kurs) VALUES('A', '2019', 'Per', 'INFO233')");
        connectionManager.executeStatement("INSERT INTO Karakter(karakter, ar, student, kurs) VALUES('A', '2019', 'Kari', 'INFO233')");


        // Close the connection
        connectionManager.closeConnection();

    }

    // Fields for this class
    private Connection connection = null;

    @Override
    public Connection connect(String databaseFileName) {
        String databasePath = "jdbc:sqlite:assignment3/src/main/resources/databases/" + databaseFileName;
        System.out.println(databasePath);
        try {
            connection = DriverManager.getConnection(databasePath);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(getConnection() != null) {
            System.out.println("Connected to " + databaseFileName);
            System.out.println("Connection Successful");
        }
        return getConnection();
    }

    @Override
    public void initDB(String databaseName){
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(databaseName);

        // Create a tables
        connectionManager.executeStatement("CREATE TABLE Skole (navn TEXT PRIMARY KEY)");
        connectionManager.executeStatement("CREATE TABLE Kull (kode TEXT PRIMARY KEY, skole TEXT REFERENCES Skole(navn))");
        connectionManager.executeStatement("CREATE TABLE Student (studentNo INTEGER PRIMARY KEY, navn TEXT NOT NULL, kull TEXT REFERENCES Kull(kode))");
        connectionManager.executeStatement("CREATE TABLE Kurs (kode TEXT PRIMARY KEY, navn TEXT NOT NULL, skole TEXT REFERENCES Skole(navn))");
        connectionManager.executeStatement("CREATE TABLE Karakter (id INTEGER PRIMARY KEY, karakter TEXT NOT NULL, ar INTEGER NOT NULL, student TEXT REFERENCES Student(studentNo), kurs TEXT REFERENCES Kurs(kode))");
    }

    @Override
    public void executeStatement(String SQLStatement) {
        Statement createStatement = null;
        try {
            createStatement = getConnection().createStatement();
            createStatement.executeUpdate(SQLStatement);
            createStatement.close();
            System.out.println("Table has been created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void closeConnection() {
        try {
            this.getConnection().close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Connection is closed");
    }

    /**
     * Returns the current connection
     * @return This connection
     */
    public Connection getConnection() {
        return connection;
    }
}
