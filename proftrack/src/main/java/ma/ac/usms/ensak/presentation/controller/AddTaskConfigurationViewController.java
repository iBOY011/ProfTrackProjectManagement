package ma.ac.usms.ensak.presentation.controller;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;

public class AddTaskConfigurationViewController {

    private AddTaskConfigurationView AddTaskConfigurationView;

    public AddTaskConfigurationViewController() {
        AddTaskConfigurationView = new AddTaskConfigurationView();

    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(AddTaskConfigurationView, 300, 300));
        stage.setTitle("Add Task Configuration");
        stage.setResizable(false);
        stage.show();
    }
}
