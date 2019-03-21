package main.java.client.LandingScreenView;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;

public class LandingScreenViewController {
    @FXML
    private Button addStudentButton;

    @FXML
    private Button studentListButton;


    public void initialize() {

        addStudentButton.setOnAction(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.AddStudentView));
        });


        studentListButton.setOnAction(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.StudentListView));
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
