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

    private TaskController() {
    }

    public void createView() {

    }

    public static void showTasks() {
        ListToDoManager listToDoManager = new ListToDoManager();
        ListToDo list = listToDoManager.searchListeToDoById(ShowBoxController.getIdListSelected());
        taskView.getHeaderLabel().setText(list.getTitle() + " List:");
        taskView.setVisibleListWorkSession(false);
        taskView.getListTask().getChildren().clear();
        taskView.getShowTask().setText("Tasks:");
        taskView.getListTask().getChildren().add(taskView.getShowTask());
        List<Task> tasks = taskManager.listTasksByIdListToDo(ShowBoxController.getIdListSelected());
        for (Task t : tasks) {
            CheckBox checkBox = new CheckBox();
            checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
            Button button = new Button(t.getTitle());
            button.setStyle(
                    "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");

            HBox hBox = new HBox(checkBox, button);
            hBox.setStyle("-fx-spacing: 10px; -fx-alignment: center-left;");
            taskView.getListTask().getChildren().add(hBox);
        }
    }

    public static TasksView getTaskView() {
        return taskView;
    }

}
