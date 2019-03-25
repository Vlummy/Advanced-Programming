package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.CreateSQLiteDatabase;
import main.java.server.data_access_objects.dao_interfaces.KullDAOInterface;
import main.java.server.student_register_system.Kull;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class KullDAO implements KullDAOInterface {
    private Connection connection;

    public KullDAO(String databaseName) {
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect(databaseName);
        this.connection = createSQLiteDatabase.getConnection();
    }

    public Kull findKull(Long id){

        return null;
    }

    public List<Kull> findAllKull(){

        return null;
    }

    public void updateKull(Long id, String karakter){

    }

    public void storeKull (Long id){

    }

    public void storeAllKull (Long id){

    }

    public void deleteKull (Long id){

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
