package main.java.server.data_access_objects.dao_classes;

import main.java.server.create_database.CreateSQLiteDatabase;
import main.java.server.data_access_objects.dao_interfaces.StudentDAOInterface;
import main.java.server.student_register_system.Student;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class StudentDAO implements StudentDAOInterface {
    private Connection connection;

    public StudentDAO(String databaseName) {
        CreateSQLiteDatabase createSQLiteDatabase = new CreateSQLiteDatabase();
        createSQLiteDatabase.connect(databaseName);
        this.connection = createSQLiteDatabase.getConnection();
    }

    public Student findStudent(Long id){

        return null;
    }

    public List<Student> findAllStudent(){

        return null;
    }

    public void updateStudent(Long id, Integer ar, String karakter){

    }

    public void storeStudent (Long id){

    }

    public void storeAllStudent (Long id){

    }

    public void deleteStudent (Long id){

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
