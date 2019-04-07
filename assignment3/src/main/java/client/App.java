package main.java.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;
import main.java.server.data_access_objects.dao_classes.*;
import main.java.server.data_access_objects.dao_interfaces.*;

public class App extends Application {
    private Stage primarystage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primarystage = primaryStage;
        primaryStage.setScene(new Scene(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.LandingScreenView)));
        primaryStage.setTitle("Student Register System");
        primaryStage.show();
    }

    public static void main (String[] args) {
        SkoleDAOInterface skoleDAO = new SkoleDAO("student_register_database.db");
        StudentDAOInterface studentDAO = new StudentDAO("student_register_database.db");
        KursDAOInterface kursDAO = new KursDAO("student_register_database.db");
        KullDAOInterface kullDAO = new KullDAO("student_register_database.db");
        KarakterDAOInterface karakterDAO = new KarakterDAO("student_register_database.db");




        launch(args);
    }
}
