package main.java.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;

public class App extends Application {
    private Stage primarystage;

    @Override
    public void start(Stage primaryStage) throws Exception {
        this.primarystage = primaryStage;
        primaryStage.setScene(new Scene(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.LandingScreenView)));
        primaryStage.setTitle("Student Register System");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
