package ma.ac.usms.ensak.presentation.controller;

import java.util.Date;
import java.util.List;

import com.google.gwt.dev.protobuf.DescriptorProtos;

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
import ma.ac.usms.ensak.persistance.impl.ListeToDoImpl;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;
import ma.ac.usms.ensak.presentation.Views.VBoxes.TodayBox;
import ma.ac.usms.ensak.util.Status;

public class TodayBoxController {
    private static TodayBox todayBox = new TodayBox();
    private boolean isListDisplayed = false;
    private boolean isProjectDisplayed = false;

    private static TaskManager taskManager = new TaskManager();
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static ProjectManager projectManager = new ProjectManager();

    public TodayBoxController() {
        todayBox.getAddButton().setOnMouseClicked(e -> {
            String task = todayBox.getAddTask().getText();
            taskManager.createTask(task, "description", new Date(), new Date(), Status.IN_PROGRESS,
                    "de445f0a-3cfe-4f8f-934c-33ab2c7d655a", false);
        });

        todayBox.getShowListOfToday().setOnMouseClicked(e -> {
            if (!isListDisplayed) {
                List<Task> tasks = taskManager.getTasksOfToday();
                for (Task t : tasks) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
                    Button button = new Button(t.getTitle());
                    button.setStyle(
                            "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");
                    // Get the ListToDo object by its ID
                    ListToDo listToDo = listToDoManager.searchListeToDoById(t.getId_ListToDo());

                    // Create a label with the title of the ListToDo
                    Label label = new Label(listToDo.getTitle());

                    HBox hBox = new HBox(checkBox, button, label);
                    hBox.setStyle("-fx-spacing: 5px; -fx-alignment: center-left;");
                    todayBox.getListToday().getChildren().add(hBox);
                }
                isListDisplayed = true;
            } else {
                todayBox.getListToday().getChildren().remove(1, todayBox.getListToday().getChildren().size());
                isListDisplayed = false;
            }
        });

        // all i did for showing the tasks of lists , iwant to di it for projects
        todayBox.getShowProjectOfToday().setOnMouseClicked(e -> {
            if (!isProjectDisplayed) {
                List<Task> tasks = taskManager.getTasksOfToday();
                for (Task t : tasks) {
                    CheckBox checkBox = new CheckBox();
                    checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
                    Button button = new Button(t.getTitle());
                    button.setStyle(
                            "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");
                    // Get the Project object by its ID
                    Project project = projectManager.searchProjectById(t.getId_Project());

                    // Create a label with the title of the ListToDo
                    Label label = new Label(project.getTitle());

                    HBox hBox = new HBox(checkBox, button, label);
                    hBox.setStyle("-fx-spacing: 5px; -fx-alignment: center-left;");
                    todayBox.getProjectToday().getChildren().add(hBox);
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
