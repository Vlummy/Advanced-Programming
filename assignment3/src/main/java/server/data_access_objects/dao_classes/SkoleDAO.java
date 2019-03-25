package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.CreateSQLiteDatabase;
import main.java.server.data_access_objects.dao_interfaces.SkoleDAOInterface;
import main.java.server.student_register_system.Skole;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class SkoleDAO implements SkoleDAOInterface {
    private Connection connection;

    public SkoleDAO(String databaseName) {
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect(databaseName);
        this.connection = createSQLiteDatabase.getConnection();
    }

    public Skole findSkole(Long id){

        return null;
    }

    public List<Skole> findAllSkole(){

        return null;
    }

    public void updateSkole(Long id, String karakter){

    }

    public void storeSkole (Long id){

    }

    public void storeAllSkole (Long id){

    }

    public void deleteSkole (Long id){

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
