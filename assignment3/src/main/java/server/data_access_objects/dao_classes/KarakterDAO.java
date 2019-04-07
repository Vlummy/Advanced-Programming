package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.ConnectionManager;
import main.java.server.data_access_objects.dao_interfaces.KarakterDAOInterface;
import main.java.server.student_register_system.Karakter;
import main.java.server.student_register_system.Kurs;
import main.java.server.student_register_system.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class KarakterDAO implements KarakterDAOInterface {
    private Connection connection;

    public KarakterDAO(String databaseName) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(databaseName);
        this.connection = connectionManager.getConnection();
    }

    public Karakter findKarakter(Student student, Kurs kurs, Integer ar){
        Integer studentNo = student.getStudentNo();
        String courseNo = kurs.getKode();

        String sql = "SELECT karakter, ar, student, kurs FROM Karakter WHERE student = ? AND kurs = ? AND ar = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setInt(1, studentNo);
            prepared.setString(2, courseNo);
            prepared.setInt(3, ar);

            ResultSet result = prepared.executeQuery();

            Karakter resultKarakter = new Karakter(result.getString("karakter"), result.getInt("student"), result.getString("kurs"), result.getInt("ar"));
            return resultKarakter;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Karakter> findAllKarakter(){
        ArrayList<Karakter> resultList = new ArrayList();
        String sql = "SELECT karakter, ar, student, kurs FROM Karakter";

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)){

            while (result.next()){
                Karakter resultKarakter = new Karakter(result.getString("karakter"), result.getInt("student"), result.getString("kurs"), result.getInt("ar"));
                resultList.add(resultKarakter);
            }
            return resultList;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateKarakter (Karakter karakter, String verdi, Student student, Kurs course, Integer ar){
        Integer studentNo = student.getStudentNo();
        String courseNo = course.getKode();

        String sql = "UPDATE Karakter SET karakter = ?, ar = ?, student = ?, kurs = ? FROM Karakter WHERE student = ? AND kurs = ? AND ar = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, verdi);
            prepared.setInt(2, studentNo);
            prepared.setString(3, courseNo);
            prepared.setInt(4, ar);
            prepared.setInt(5, karakter.getStudentID());
            prepared.setString(6, karakter.getCourseID());
            prepared.setInt(7, karakter.getAr());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeKarakter (Karakter karakter){
        String sql = "INSERT INTO Karakter(karakter, ar, student, kurs) VALUES(?,?,?,?)";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, karakter.getVerdi());
            prepared.setInt(2, karakter.getStudentID());
            prepared.setString(3, karakter.getCourseID());
            prepared.setInt(4, karakter.getAr());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeAllKarakter (List<Karakter> karakterList){
        for (Karakter karakter : karakterList){
            storeKarakter(karakter);
        }
    }

    public void deleteKarakter (Karakter karakter){
        String sql = "DELETE FROM Karakter  WHERE student = ? AND kurs = ? AND ar = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setInt(1, karakter.getStudentID());
            prepared.setString(2, karakter.getCourseID());
            prepared.setInt(3, karakter.getAr());
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
