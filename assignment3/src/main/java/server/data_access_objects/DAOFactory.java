package main.java.server.data_access_objects;

import main.java.server.data_access_objects.dao_interfaces.*;

public interface DAOFactory {
    KarakterDAOInterface getKarakterDAO();
    KullDAOInterface getKullDAO();
    KursDAOInterface getKursDAO();
    SkoleDAOInterface getSkoleDAO();
    StudentDAOInterface getStudentDAO();
}
