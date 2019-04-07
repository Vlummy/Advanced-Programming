package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.ConnectionManager;
import main.java.server.data_access_objects.dao_interfaces.KursDAOInterface;
import main.java.server.student_register_system.Kurs;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KursDAO implements KursDAOInterface {
    private Connection connection;

    public KursDAO(String databaseName) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(databaseName);
        this.connection = connectionManager.getConnection();
    }

    public Kurs findKurs(String kode){
        String sql = "SELECT kode, navn, skole FROM Kurs WHERE kode = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kode);

            ResultSet result = prepared.executeQuery();

            Kurs resultKurs = new Kurs(result.getString("kode"), result.getString("navn"), result.getString("skole"));
            return resultKurs;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Kurs> findAllKurs(){
        ArrayList<Kurs> resultList = new ArrayList();
        String sql = "SELECT kode, navn, skole FROM Kurs";

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)){

            while (result.next()){
                Kurs resultKurs = new Kurs(result.getString("kode"), result.getString("navn"), result.getString("skole"));
                resultList.add(resultKurs);
            }
            return resultList;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateKurs(Kurs kurs, String kode, String navn, String skole){
        String sql = "UPDATE Kurs SET kode = ?, navn = ?, skole = ? FROM Kurs WHERE kode = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kode);
            prepared.setString(2, navn);
            prepared.setString(3, skole);
            prepared.setString(4, kurs.getKode());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeKurs (Kurs kurs){
        String sql = "INSERT INTO Kurs(kode, navn, skole) VALUES(?,?,?)";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kurs.getKode());
            prepared.setString(2, kurs.getNavn());
            prepared.setString(3, kurs.getSkoleNavn());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeAllKurs (List<Kurs> kursList){
        for (Kurs kurs : kursList){
            storeKurs(kurs);
        }
    }

    public void deleteKurs (Kurs kurs){
        String sql = "DELETE FROM Kurs  WHERE kode = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kurs.getKode());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
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
