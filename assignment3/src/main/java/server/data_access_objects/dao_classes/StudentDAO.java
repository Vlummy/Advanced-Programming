package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.ConnectionManager;
import main.java.server.data_access_objects.dao_interfaces.StudentDAOInterface;
import main.java.server.student_register_system.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO implements StudentDAOInterface {
    private Connection connection;

    public StudentDAO(String databaseName) {
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.connect(databaseName);
        this.connection = connectionManager.getConnection();
    }

    public Student findStudent(Integer studentNo){
        String sql = "SELECT studentNo, navn, kull FROM Student WHERE studentNo = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setInt(1, studentNo);

            ResultSet result = prepared.executeQuery();

            Student resultStudent = new Student(result.getString("navn"), result.getString("kull"));
            return resultStudent;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public List<Student> findAllStudent(){
        ArrayList<Student> resultList = new ArrayList();
        String sql = "SELECT studentNo, navn, kull FROM Student";

        try (Statement statement = connection.createStatement();
             ResultSet result = statement.executeQuery(sql)){

            while (result.next()){
                Student resultStudent = new Student(result.getString("navn"), result.getString("kull"));
                resultList.add(resultStudent);
            }
            return resultList;

        } catch (SQLException e){
            System.out.println(e.getMessage());
            return null;
        }
    }

    public void updateStudent(Student student, String navn, String kull){
        String sql = "UPDATE Student SET navn = ?, kull = ? FROM Student WHERE studentNo = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, navn);
            prepared.setString(2, kull);
            prepared.setInt(3, student.getStudentNo());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeStudent (Student student){
        String sql = "INSERT INTO Student(navn, kull) VALUES(?,?)";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setString(1, student.getNavn());
            prepared.setString(2, student.getKullKode());
            prepared.executeUpdate();

        } catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    public void storeAllStudent (List<Student> studentList){
        for (Student student : studentList){
            storeStudent(student);
        }
    }

    public void deleteStudent (Student student){
        String sql = "DELETE FROM Student WHERE studentNo = ?";

        try (PreparedStatement prepared = connection.prepareStatement(sql)){
            prepared.setInt(1, student.getStudentNo());
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
