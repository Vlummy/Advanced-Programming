package main.java.server.create_database;

import java.sql.Connection;

/**
 * Interface for creating a databases.
 * Author: Øyvind Johannessen, Roy H. Jensen
 * Version: 1.0
 */
public interface ConnectionManagerInterface {
    /**
     * Creates a new databases. If databaseName already exists, a connection will be made
     * @param databaseName The name of the databases file
     */
    Connection connect(String databaseName);

    /**
     * Initiates a School database
     * This is a class simply made to initiate a DB with set values so we can show off using our DAO model to communicate with the database.
     * @param name The name of the database.
     */
    void initDB(String name);

    /**
     * Executes a statement in a database.
     * Use the connection returned from connect() method as parameter to specify which database to use
     * @param SQLStatement The sql code for the statement.
     */
    void executeStatement(String SQLStatement);

    /**
     * Closes the connection to the database
     */
    void closeConnection();
}
