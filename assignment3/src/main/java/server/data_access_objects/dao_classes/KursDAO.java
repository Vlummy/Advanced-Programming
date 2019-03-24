package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.CreateSQLiteDatabase;
import main.java.server.data_access_objects.dao_interfaces.KursDAOInterface;
import main.java.server.student_register_system.Kurs;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class KursDAO implements KursDAOInterface {
    private Connection connection;

    public KursDAO(String databaseName) {
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect(databaseName);
        this.connection = createSQLiteDatabase.getConnection();
    }

    public Kurs findKurs(Long id){

        return null;
    }

    public List<Kurs> findAllKurs(){

        return null;
    }

    public void updateKurs(Long id, String karakter, String karakter2){

    }

    public void storeKurs (Long id){

    }

    public void storeAllKurs (Long id){

    }

    public void deleteKurs (Long id){

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
