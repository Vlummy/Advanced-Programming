package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.ConnectionManager;
import main.java.server.data_access_objects.dao_interfaces.SkoleDAOInterface;
import main.java.server.student_register_system.Skole;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class SkoleDAO implements SkoleDAOInterface {
    private Connection connection;

    public SkoleDAO(String databaseName) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(databaseName);
        this.connection = connectionManager.getConnection();
    }

    public Skole findSkole(String name){
        String sql = "SELECT navn FROM Skole WHERE navn = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, name);

            ResultSet result = prepared.executeQuery();

            Skole resultSkole = new Skole(result.getString("navn"));
            return resultSkole;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Skole> findAllSkole(){
        ArrayList<Skole> resultList = new ArrayList();
        String sql = "SELECT navn FROM Skole";

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)){

            while (result.next()){
                Skole resultSkole = new Skole(result.getString("navn"));
                resultList.add(resultSkole);
            }
            return resultList;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateSkole(Skole skole, String name){
        String sql = "UPDATE Skole SET navn = ? FROM Skole WHERE navn = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, name);
            prepared.setString(2, skole.getName());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeSkole (Skole skole){
        String sql = "INSERT INTO Skole(navn) VALUES(?)";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, skole.getName());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeAllSkole (List<Skole> skoleList){
        for (Skole skole : skoleList){
            storeSkole(skole);
        }
    }

    public void deleteSkole (Skole skole){
        String sql = "DELETE FROM Skole WHERE navn = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, skole.getName());
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
