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
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.persistance.impl.ListeToDoImpl;
import ma.ac.usms.ensak.presentation.Views.VBoxes.TodayBox;
import ma.ac.usms.ensak.util.Status;

public class TodayBoxController {
    private static TodayBox todayBox = new TodayBox();
    private boolean isListDisplayed = false;

    private static TaskManager taskManager = new TaskManager();
    private static ListToDoManager listToDoManager = new ListToDoManager();

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

    }

    public TodayBox getTodayBox() {
        return todayBox;
    }

}
