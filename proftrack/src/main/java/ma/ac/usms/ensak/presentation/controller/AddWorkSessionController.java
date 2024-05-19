package ma.ac.usms.ensak.presentation.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.presentation.Views.AddWorkSessionView;

public class AddWorkSessionController {
    private static final AddWorkSessionController instance = new AddWorkSessionController();
    private AddWorkSessionView workSessionView;

    public void addWorkSession(Task task) {
        
    }

    public void createView() {
        workSessionView = new AddWorkSessionView();
        Stage stage = new Stage();
        stage.setScene(new Scene(workSessionView.getRoot(), 620, 200));
        stage.getScene().getStylesheets().add("/Css/AddWorkSession.css");
        stage.setTitle("Add Work Session");
        stage.show();
    }

    public static AddWorkSessionController getInstance() {
        return instance;
    }

}
