package main.java.client.StudentListView;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class StudentListViewController {
    @FXML
    ListView<Label> studentListView; // Clickable label so that we can view a new window with student data.

    public void initialize() {

    }
}
