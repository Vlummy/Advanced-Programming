package main.java.server.create_database;

import main.java.server.data_access_objects.DAOFactory;
import main.java.server.data_access_objects.SQLiteFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Class for managing a database creation
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version: 1.0
 */
public class CreateSQLiteDatabase implements CreateDatabaseInterface {

    public static void main(String[] args) {
        // Connect to an existing database or create a new database
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect("student_register_database.db");

        // Create a tables
        createSQLiteDatabase.createTable("CREATE TABLE Skole (navn text PRIMARY KEY)");
        createSQLiteDatabase.createTable("CREATE TABLE Kull (kode text PRIMARY KEY, skole text REFERENCES Skole(navn))");
        createSQLiteDatabase.createTable("CREATE TABLE Student (nr text PRIMARY KEY, navn text NOT NULL, kull text REFERENCES Kull(kode))");
        createSQLiteDatabase.createTable("CREATE TABLE Karakter (id integer PRIMARY KEY, karakter text NOT NULL, ar integer NOT NULL, student text REFERENCES Student(nr))");
        createSQLiteDatabase.createTable("CREATE TABLE Kurs (kode text PRIMARY KEY, navn text NOT NULL, skole text REFERENCES Skole(navn), karakter integer REFERENCES Karakter(id))");

        // Close the connection
        createSQLiteDatabase.closeConnection();
    }

    // Fields for this class
    private Connection connection = null;

    @Override
    public Connection connect(String databaseFileName) {
        String databasePath = "jdbc:sqlite:src/main/resources/databases/" + databaseFileName;
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
    public void createTable(String SQLStatement) {
        Statement createStatement = null;
        try {
            createStatement = getConnection().createStatement();
            createStatement.executeUpdate(SQLStatement);
            createStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Table has been created");
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
