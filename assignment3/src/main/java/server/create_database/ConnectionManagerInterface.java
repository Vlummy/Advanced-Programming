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
