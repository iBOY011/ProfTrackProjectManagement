package ma.ac.usms.ensak.presentation.controller;

import java.util.Date;
import java.util.List;

import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;
import ma.ac.usms.ensak.presentation.Views.TodayView;
import ma.ac.usms.ensak.presentation.Views.VBoxes.TodayBox;
import ma.ac.usms.ensak.util.SharedData;
import ma.ac.usms.ensak.util.Status;

public class TodayBoxController {
    private TodayBox todayBox = new TodayBox();
    private boolean isListDisplayed = true;
    private boolean isProjectDisplayed = true;

    private static TaskManager taskManager = new TaskManager();
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static ProjectManager projectManager = new ProjectManager();

    public TodayBoxController() {

        // Add the TodayBox to the SharedData
        SharedData.getInstance().setTodayBoxController(this);
        
        todayBox.getShowListOfToday().setOnMouseClicked(e -> {
            if (!isListDisplayed) { 
                List<Task> tasks = taskManager.getTasksOfToday();
                for (Task t : tasks) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
                    checkBox.setOnAction(s -> {
                        t.setStatus(Status.DONE);
                        taskManager.updateTask(t);
                        checkBox.setDisable(true);
                    });
                    if (t.getStatus() == Status.DONE) {
                        checkBox.setSelected(true);
                        checkBox.setDisable(true);
                    }
                    Button button = new Button(t.getTitle());
                    button.setOnAction(s -> {
                        TaskController.showTaskDetails(t);
                        AddDocumentController.addDocTask(t);
                    });
                    button.setStyle(
                            "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px; -fx-text-fill: black; -fx-font-weight: bold; -fx-font-family: 'Arial';");

                    if (t.getId_ListToDo() != null) {
                        ListToDo listToDo = listToDoManager.searchListeToDoById(t.getId_ListToDo());
                        if (listToDo != null) {
                            Label label = new Label(listToDo.getTitle());
                            HBox hBox = new HBox(checkBox, button, label);
                            hBox.setStyle("-fx-spacing: 5px; -fx-alignment: center-left;");
                            todayBox.getListToday().getChildren().add(hBox);
                        }
                    }
                }
                isListDisplayed = true;
            } else {
                todayBox.getListToday().getChildren().remove(1, todayBox.getListToday().getChildren().size());
                isListDisplayed = false;
            }
        });

        todayBox.getShowProjectOfToday().setOnMouseClicked(e -> {
            if (!isProjectDisplayed) {
                List<Task> tasks = taskManager.getTasksOfToday();
                for (Task t : tasks) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
                    checkBox.setOnAction(s -> {
                        t.setStatus(Status.DONE);
                        taskManager.updateTask(t);
                        checkBox.setDisable(true);
                    });
                    if (t.getStatus() == Status.DONE) {
                        checkBox.setSelected(true);
                        checkBox.setDisable(true);
                    }
                    Button button = new Button(t.getTitle());
                    button.setOnAction(s -> {
                        TaskController.showTaskDetails(t);
                        AddDocumentController.addDocTask(t);
                    });
                    button.setStyle(
                            "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");

                    if (t.getId_project() != null) {
                        Project project = projectManager.searchProjectById(t.getId_project());
                        if (project != null) {
                            Label label = new Label(project.getTitle());
                            HBox hBox = new HBox(checkBox, button, label);
                            hBox.setStyle("-fx-spacing: 5px; -fx-alignment: center-left;");
                            todayBox.getProjectToday().getChildren().add(hBox);
                        }
                    }
                }
                isProjectDisplayed = true;
            } else {
                todayBox.getProjectToday().getChildren().remove(1, todayBox.getProjectToday().getChildren().size());
                isProjectDisplayed = false;
            }
        });

        todayBox.getInformationButton().setOnMouseClicked(e -> {
            AddTaskConfigurationViewController addTaskConfigurationViewController = new AddTaskConfigurationViewController();
            addTaskConfigurationViewController.createView();
        });
    }

    public TodayBox getTodayBox() {
        return todayBox;
    }
}
