package main.java.client.FXMLFactory;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

import java.io.IOException;

public class FXMLFactory {

    public enum FXMLDocumentName {
        CourseGradeTableView, LandingScreenView, StudentListView, StudentView, AddStudentView
    }

    public static Parent loadFXML(FXMLDocumentName fxmlDocumentName) {
        switch (fxmlDocumentName) {
            case LandingScreenView:
                return load("main/resources/fxml/LandingScreenView.fxml");
            case StudentView:
                return load("main/resources/fxml/StudentView.fxml");
            case StudentListView:
                return load("main/resources/fxml/StudentListView.fxml");
            case CourseGradeTableView:
                return load("main/resources/fxml/CourseGradeTableView.fxml");
            case AddStudentView:
                return load("main/resources/fxml/AddStudentView.fxml");

        }
        return null;
    }

    private static Parent load(String url) {
        Parent fxmlDoc = null;
        try {
            fxmlDoc = FXMLLoader.load(FXMLFactory.class.getClassLoader().getResource(url));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return fxmlDoc;
    }
}
