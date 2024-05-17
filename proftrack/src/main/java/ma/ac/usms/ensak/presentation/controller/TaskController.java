package ma.ac.usms.ensak.presentation.controller;

import java.util.List;

import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.TasksView;

public class TaskController {
    private static TaskController Instance = new TaskController();
    private static TaskManager taskManager = new TaskManager();
    private static TasksView taskView = new TasksView();
    private static boolean isListDisplayed = false;
    private boolean isProjectDisplayed = false;

    private TaskController() {
    }

    public void createView() {
        

    }

    public static void showTasks() {
        taskView.getShowTask().setOnMouseClicked(e -> {
            if (!isListDisplayed) {
                List<Task> tasks = taskManager.listTasksByIdListToDo(ShowBoxController.getIdListSelected());
                for (Task t : tasks) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
                    Button button = new Button(t.getTitle());
                    button.setStyle(
                            "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");
                    

                    HBox hBox = new HBox(checkBox, button, new Label(t.getStart_date().toString()), new Label(t.getEnd_date().toString()));
                    hBox.setStyle("-fx-spacing: 5px; -fx-alignment: center-left;");
                    taskView.getListTask().getChildren().add(hBox);
                }
                isListDisplayed = true;
            } else {
                taskView.getListTask().getChildren().remove(1, taskView.getListTask().getChildren().size());
                isListDisplayed = false;
            }
        });
    }

    public static TasksView getTaskView() {
        return taskView;
    }

}
