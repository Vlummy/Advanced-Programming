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
import main.java.server.data_access_objects.DAOFactory;
import main.java.server.data_access_objects.SQLiteFactory;
import main.java.server.data_access_objects.dao_interfaces.KarakterDAOInterface;
import main.java.server.data_access_objects.dao_interfaces.KullDAOInterface;
import main.java.server.data_access_objects.dao_interfaces.KursDAOInterface;
import main.java.server.data_access_objects.dao_interfaces.StudentDAOInterface;
import main.java.server.student_register_system.Karakter;
import main.java.server.student_register_system.Kull;
import main.java.server.student_register_system.Kurs;
import main.java.server.student_register_system.Student;

import java.util.ArrayList;
import java.util.List;

public class StudentViewController {
    @FXML
    private ImageView backButton;

    @FXML
    private Label yearLabel;

    @FXML
    private ListView<String> gradeListView;

    @FXML
    private Label studentNameLabel;

    @FXML
    private Label schoolNameLabel;

    @FXML
    private Label startYearLabel;

    private Student student;

    //Database connection
    DAOFactory factory = new SQLiteFactory("student_register_database.db");
    StudentDAOInterface studentDAO = factory.getStudentDAO();
    KarakterDAOInterface karakterDAO = factory.getKarakterDAO();
    KursDAOInterface kursDAO = factory.getKursDAO();

    public void initialize() {
        backButton.setOnMouseClicked(event -> {
            Stage stage = getPrimaryStage((Node) event.getSource());
            stage.getScene().setRoot(FXMLFactory.loadFXML(FXMLFactory.FXMLDocumentName.StudentListView));
        });
    }

    public void loadStudentData(Student student) {
        this.student = student;
        List<Kurs> kursList = kursDAO.findAllKurs();
        List<Karakter> karakterList = karakterDAO.findAllKarakter();

        karakterList.removeIf(k -> k.getStudentID() != student.getStudentNo());

        List<String> stringList = new ArrayList();

        for (Karakter karakter : karakterList){
            String karakterVerdi = karakter.getVerdi();
            String courseVerdi = karakter.getCourseID();
            Kurs result = kursList.stream()
                                .filter(kurs -> courseVerdi.equals(kurs.getKode()))
                                .findAny()
                                .orElse(null);
            String kursNavn = result.getNavn();

            String builtString = kursNavn + " [" + courseVerdi + "]: " + karakterVerdi;
            stringList.add(builtString);
        }

        studentNameLabel.setText(student.getNavn());
        startYearLabel.setText(student.getKullKode());
        yearLabel.setText("2019");
        schoolNameLabel.setText("University of Bergen");
        gradeListView.getItems().addAll(stringList);

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
