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
import main.java.server.data_access_objects.DAOFactory;
import main.java.server.data_access_objects.SQLiteFactory;
import main.java.server.data_access_objects.dao_interfaces.KullDAOInterface;
import main.java.server.data_access_objects.dao_interfaces.StudentDAOInterface;
import main.java.server.student_register_system.Kull;
import main.java.server.student_register_system.Student;

import java.io.IOException;
import java.util.List;

public class StudentListViewController {
    @FXML
    private ImageView backButton;

    @FXML
    private TableView<Student> studentTableView;

    @FXML
    private TableColumn<Student, String> studentColumn;

    @FXML
    private TableColumn<Student, String> studentNumberColumn;

    @FXML
    private ImageView arrowLeft;

    @FXML
    private ImageView arrowRight;

    @FXML
    private Label kullLabel;

    @FXML
    private Label schoolNameLabel;

    //Database connection
    DAOFactory factory = new SQLiteFactory("student_register_database.db");
    StudentDAOInterface studentDAO = factory.getStudentDAO();
    KullDAOInterface kullDAO = factory.getKullDAO();

    //Grabbing the available courses.
    List<Kull> kullList = kullDAO.findAllKull();
    Integer currentKullIndex = 0;
    Integer endKullIndex = kullList.size() -1;
    Kull currentKull = kullList.get(0);

    public void initialize() {
        // Fill studentListView with students
        fillStudentListview(currentKull);

        backButton.setOnMouseClicked(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.LandingScreenView));
        });

        studentTableView.setOnMouseClicked(event -> {
            getSingleStudentData(event);
        });


        arrowRight.setOnMouseClicked(event -> {
            getNextKull();
        });

        arrowLeft.setOnMouseClicked(event -> {
            getPreviousKull();
        });
        schoolNameLabel.setText("University of Bergen");

    }

    private void fillStudentListview(Kull kull) {
        studentColumn.setCellValueFactory(new PropertyValueFactory<>("navn"));
        studentNumberColumn.setCellValueFactory(new PropertyValueFactory<>("studentNo"));

        studentTableView.setItems(getAllStudents(kull));
        kullLabel.setText(kull.getKode());
    }

    private ObservableList<Student> getAllStudents(Kull kull) {
        List<Student> studentList = studentDAO.findAllStudent();
        studentList.removeIf(s -> !s.getKullKode().equals(kull.getKode()));
        return FXCollections.observableArrayList(studentList);

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

    private void getNextKull() {
        if (currentKullIndex < endKullIndex){
            currentKullIndex++;
            currentKull = kullList.get(currentKullIndex);
            fillStudentListview(currentKull);
        }
    }

    private void getPreviousKull() {
        if (currentKullIndex > 0){
            currentKullIndex--;
            currentKull = kullList.get(currentKullIndex);
            fillStudentListview(currentKull);
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
