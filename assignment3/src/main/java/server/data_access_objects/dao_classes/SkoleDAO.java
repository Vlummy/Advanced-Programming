package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.CreateSQLiteDatabase;
import main.java.server.data_access_objects.dao_interfaces.SkoleDAOInterface;

import java.sql.Connection;
import java.sql.SQLException;

public class SkoleDAO implements SkoleDAOInterface {
    private Connection connection;

    public SkoleDAO(String databaseName) {
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect(databaseName);
        this.connection = createSQLiteDatabase.getConnection();
    }

    @Override
    public void closeConnection() {
        try {
            this.connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
