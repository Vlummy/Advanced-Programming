package main.java.client.AddStudentView;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;

public class AddStudentViewController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField studentNumberField;

    @FXML
    private ImageView addStudentButton;

    @FXML
    private ImageView backButton;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.LandingScreenView));
        });

        addStudentButton.setOnMouseClicked(event -> {
            String name = nameField.getText();
            String nr = studentNumberField.getText();
            // Use StudentDAO to add new student to database...
            System.out.println("Student " + name + " added to database with student number " + nr);
        });
    }

    /**
     * Returns the primary stage from given node
     * @param node
     * @return PrimaryStage
     */
    private Stage getPrimaryStage(Node node) {
        return (Stage) node.getScene().getWindow();
    }
}
