package main.java.client;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class App extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        BorderPane mainLayout = new BorderPane();
        Scene scene = new Scene(mainLayout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("UIB Cources");
        primaryStage.show();



    }

    public static void main (String[] args) {
        launch(args);
    }
}
