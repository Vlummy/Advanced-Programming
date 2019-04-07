package main.java.server.data_access_objects;

import main.java.server.create_database.ConnectionManager;
import main.java.server.data_access_objects.dao_interfaces.*;
import main.java.server.student_register_system.*;

import java.util.ArrayList;

public class DAOMain {
    public static void main(String[] args) {
        //THIS INSTANTIATION OF ConnectionManager is only necessary to build the database, not relevant for assignment D other than preparation.
        ConnectionManager connectionManager = new ConnectionManager();
        connectionManager.initDB("student_register_database.db");

        // ASSIGNMENT PART D
        //USING DAOFactory to instantiate DAOs to use with java object model to store into database.
        DAOFactory factory = new SQLiteFactory("student_register_database.db");

        KarakterDAOInterface karakterDAO = factory.getKarakterDAO();
        KullDAOInterface kullDAO = factory.getKullDAO();
        KursDAOInterface kursDAO = factory.getKursDAO();
        SkoleDAOInterface skoleDAO = factory.getSkoleDAO();
        StudentDAOInterface studentDAO = factory.getStudentDAO();

        skoleDAO.storeSkole(new Skole("Universitetet i Bergen"));
        kullDAO.storeKull(new Kull("2019V", "Universitetet i Bergen"));
        kursDAO.storeKurs(new Kurs("INFO233", "Avansert Programmering", "Universitetet i Bergen"));

        ArrayList<Student> studentList = new ArrayList();
        studentList.add(new Student(1, "Per", "2019V"));
        studentList.add(new Student(2, "Kari", "2019V"));

        studentDAO.storeAllStudent(studentList);

        karakterDAO.storeKarakter(new Karakter("A", 1, "INFO233", 2019));
        karakterDAO.storeKarakter(new Karakter("A", 2, "INFO233", 2019));
    }
}
