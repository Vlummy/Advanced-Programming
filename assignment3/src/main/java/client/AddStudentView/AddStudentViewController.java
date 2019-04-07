package main.java.client.AddStudentView;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import main.java.client.FXMLFactory.FXMLFactory;
import main.java.server.data_access_objects.DAOFactory;
import main.java.server.data_access_objects.SQLiteFactory;
import main.java.server.data_access_objects.dao_classes.StudentDAO;
import main.java.server.data_access_objects.dao_interfaces.KullDAOInterface;
import main.java.server.data_access_objects.dao_interfaces.StudentDAOInterface;
import main.java.server.student_register_system.Kull;
import main.java.server.student_register_system.Student;

public class AddStudentViewController {
    @FXML
    private TextField nameField;

    @FXML
    private TextField studentNumberField;

    @FXML
    private TextField kullField;

    @FXML
    private ImageView addStudentButton;

    @FXML
    private ImageView backButton;

    //Database connection
    DAOFactory factory = new SQLiteFactory("student_register_database.db");
    StudentDAOInterface studentDAO = factory.getStudentDAO();
    KullDAOInterface kullDAO = factory.getKullDAO();

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.LandingScreenView));
        });

        addStudentButton.setOnMouseClicked(event -> {
            String name = nameField.getText();
            Integer nr = Integer.parseInt(studentNumberField.getText());
            String kull = kullField.getText();
            // Use StudentDAO to add new student to database...
            if (studentDAO.findStudent(nr) == null){
                studentDAO.storeStudent(new Student(nr, name, kull));
            } else {
                studentDAO.updateStudent(new Student(nr, name, kull), nr, name, kull);
            }

            if (kullDAO.findKull(kull) == null){
                kullDAO.storeKull(new Kull(kull, "Universitetet i Bergen"));
            }

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
