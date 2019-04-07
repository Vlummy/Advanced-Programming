package main.java.server.data_access_objects;

import main.java.server.data_access_objects.dao_classes.*;
import main.java.server.data_access_objects.dao_interfaces.*;

public class SQLiteFactory implements DAOFactory {

    private String databaseName = null;
    private KarakterDAOInterface karakterDAO;
    private KullDAOInterface kullDAO;
    private KursDAOInterface kursDAO;
    private SkoleDAOInterface skoleDAO;
    private StudentDAOInterface studentDAO;

    public SQLiteFactory(String databaseName) {

        this.databaseName = databaseName;
    }

    @Override
    public KarakterDAOInterface getKarakterDAO() {
        return this.karakterDAO = new KarakterDAO(databaseName);
    }

    @Override
    public KullDAOInterface getKullDAO() {
        return this.kullDAO = new KullDAO(databaseName);
    }

    @Override
    public KursDAOInterface getKursDAO() {
        return this.kursDAO = new KursDAO(databaseName);
    }

    @Override
    public SkoleDAOInterface getSkoleDAO() {
        return this.skoleDAO = new SkoleDAO(databaseName);
    }

    @Override
    public StudentDAOInterface getStudentDAO() {
        return this.studentDAO = new StudentDAO(databaseName);
    }
}
