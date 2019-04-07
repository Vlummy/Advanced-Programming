package main.java.client.StudentView;

import javafx.beans.property.ReadOnlyStringWrapper;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;
import main.java.server.student_register_system.Karakter;
import main.java.server.student_register_system.Kurs;
import main.java.server.student_register_system.Student;

public class StudentViewController {
    @FXML
    private ImageView backButton;

    @FXML
    private Label yearLabel;

    @FXML
    private ListView<String> gradeListView;

    @FXML
    private ImageView arrowLeft;

    @FXML
    private ImageView arrowRight;

    @FXML
    private Label studentNameLabel;

    @FXML
    private Label schoolNameLabel;

    @FXML
    private Label startYearLabel;

    private Student student;

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.StudentListView));
        });

        arrowRight.setOnMouseClicked(event -> {
            getNextYear();
        });

        arrowLeft.setOnMouseClicked(event -> {
            getPreviousYear();
        });
    }

    public void loadStudentData(Student student) {
        // Bruk student.getStudentNo() for å hente relevant data, men for nå. Dummy data
        this.student = student;
        studentNameLabel.setText(student.getNavn());
        startYearLabel.setText("2017");
        yearLabel.setText("2019");
        schoolNameLabel.setText("University of Bergen");
        gradeListView.getItems().addAll(
                "Avansert Programmering [INFO233]: A",
                "Machine Learning [INFO284]: A"
        );

    }

    private void getNextYear() {
        // Oppdater tabell med karakterer fra nyere år
        System.out.println("Next year loaded");
    }

    private void getPreviousYear() {
        // Oppdater tabell med karakterer fra tidligere år
        System.out.println("Previous year loaded");
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
