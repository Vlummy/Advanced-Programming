package main.java.client.StudentListView;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;
import main.java.client.StudentView.StudentViewController;
import main.java.server.student_register_system.Student;

import java.io.IOException;

public class StudentListViewController {
    @FXML
    private ImageView backButton;

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, String> studentColumn;

    @FXML
    private TableColumn<Student, String> studentNumberColumn;

    public void initialize() {
        // Fill studentListView with students
        fillStudentListview();

        backButton.setOnMouseClicked(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.LandingScreenView));
        });

        studentTableView.setOnMouseClicked(event -> {
            getSingleStudentData(event);
        });

    }

    private void fillStudentListview() {
        studentColumn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        studentNumberColumn.setCellValueFactory(new PropertyValueFactory<>("nr"));
        studentTableView.setItems(getAllStudents());
    }

    private ObservableList<Student> getAllStudents() {
        ObservableList dummyData = FXCollections.observableArrayList();
        dummyData.addAll(new Student("0407", "Øyvind"), new Student("7365", "Roy H. Jensen"));
        return dummyData;
    }

    private void getSingleStudentData(MouseEvent event) {
        if(event.getClickCount() == 2) {
            // Hent student nummeret til student så vi kan hente alle data linket til studenten
            Student student = studentTableView.getSelectionModel().getSelectedItem();
            // Hent scene som viser en students data
            Stage stage = getPrimaryStage((Node) event.getSource());
            FXMLLoader fxmlLoader = new FXMLLoader(getClass().getClassLoader().getResource("main/resources/fxml/StudentView.fxml"));
            Parent parent = null;
            try {
                parent = fxmlLoader.load();
            } catch (IOException e) {
                e.printStackTrace();
            }
            stage.getScene().setRoot(parent);
            // Hent komtroller til denne Scene så vi kan laste inn korrekt data i denne scene
            StudentViewController studentViewController = fxmlLoader.getController();
            studentViewController.loadStudentData(student);
        }
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
