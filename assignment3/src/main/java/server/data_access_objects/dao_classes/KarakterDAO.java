package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.CreateSQLiteDatabase;
import main.java.server.data_access_objects.dao_interfaces.KarakterDAOInterface;
import main.java.server.student_register_system.Karakter;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class KarakterDAO implements KarakterDAOInterface {
    private Connection connection;

    public KarakterDAO(String databaseName) {
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect(databaseName);
        this.connection = createSQLiteDatabase.getConnection();
    }

    public Karakter findKarakter(Long id){

        return null;
    }

    public List<Karakter> findAllKarakter(){

        return null;
    }

    public void updateKarakter (Long id, String karakter, Integer ar){

    }

    public void storeKarakter (Long id){

    }

    public void storeAllKarakter (Long id){

    }

    public void deleteKarakter (Long id){

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
