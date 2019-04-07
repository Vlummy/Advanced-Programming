package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.ConnectionManager;
import main.java.server.data_access_objects.dao_interfaces.KullDAOInterface;
import main.java.server.student_register_system.Kull;
import main.java.server.student_register_system.Skole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KullDAO implements KullDAOInterface {
    private Connection connection;

    public KullDAO(String databaseName) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(databaseName);
        this.connection = connectionManager.getConnection();
    }

    public Kull findKull(String kode){

        String sql = "SELECT kode, skole FROM Kull WHERE kode = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kode);

            ResultSet result = prepared.executeQuery();

            Kull resultKull = new Kull(result.getString("kode"), result.getString("skole"));
            return resultKull;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Kull> findAllKull(){
        ArrayList<Kull> resultList = new ArrayList();
        String sql = "SELECT kode, skole FROM Kull";

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)){

            while (result.next()){
                Kull resultKull = new Kull(result.getString("kode"), result.getString("skole"));
                resultList.add(resultKull);
            }
            return resultList;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateKull(Kull kull, String kode, String skole){

        String sql = "UPDATE Kull SET kode = ?, skole = ? FROM Kull WHERE kode = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kode);
            prepared.setString(2, skole);
            prepared.setString(3, kull.getKode());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeKull (Kull kull){
        String sql = "INSERT INTO Kull(kode, skole) VALUES(?,?)";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kull.getKode());
            prepared.setString(2, kull.getSkoleNavn());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeAllKull (List<Kull> kullList){
        for (Kull kull : kullList){
            storeKull(kull);
        }
    }

    public void deleteKull (Kull kull){
        String sql = "DELETE FROM Kull  WHERE kode = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, kull.getKode());
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
