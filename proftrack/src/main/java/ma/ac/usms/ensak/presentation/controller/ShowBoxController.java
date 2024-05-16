package ma.ac.usms.ensak.presentation.controller;

import java.util.ArrayList;

import org.checkerframework.checker.units.qual.A;
import org.checkerframework.checker.units.qual.s;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.ShowBox;
import ma.ac.usms.ensak.util.ListItem;

/**
 * The ShowBoxController class is responsible for managing the display and interaction
 * with the ShowBox view. It handles the logic for showing a list of items, handling
 * item selection, and adding new lists.
 */
public class ShowBoxController {
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static ProjectManager projectManager = new ProjectManager();
    private static ShowBox showBox = new ShowBox();
    private static ArrayList<ListItem> listID = new ArrayList<>();
    private static ArrayList<ListItem> ProjectID = new ArrayList<>();
    private static String idListSelected;
    private static String idProjectSelected;

    public ShowBoxController() {
        if (showBox == null) {
            showBox = new ShowBox();
        }
        showList(showBox.getList());
        showProject(showBox.getProject());
        addButton();
    }

    /**
     * Displays a list of ListToDo items in the given VBox.
     * @param list
     */
    public static void showList(VBox list) {
        list.getChildren().clear();
        list.getChildren().add(showBox.createLabel("Lists"));

        ObservableList<ListItem> items = FXCollections.observableArrayList();
        ListView<ListItem> listView = new ListView<>(items);

        listToDoManager.listListToDo().forEach(listToDo -> {
            ListItem listItem = new ListItem(listToDo.getId(), listToDo.getTitle());
            items.add(listItem);
            listID.add(listItem);
        });
        listView.setStyle("-fx-font-size: 15px; -fx-padding: 0; -fx-background-color: #f4f4f4;");
        list.getChildren().add(listView);
        handleSelection(listView);
    }

    /**
     * Displays a list of Project items in the given VBox.
     * @param list
     */
    public static void showProject(VBox list) {
        list.getChildren().clear();
        list.getChildren().add(showBox.createLabel("Projects"));

        ObservableList<ListItem> items = FXCollections.observableArrayList();
        ListView<ListItem> listView = new ListView<>(items);

        projectManager.listProjects().forEach(project -> {
            ListItem listItem = new ListItem(project.getId(), project.getTitle());
            items.add(listItem);
            ProjectID.add(listItem);
        });
        listView.setStyle("-fx-font-size: 15px; -fx-padding: 0; -fx-background-color: #f4f4f4;");
        list.getChildren().add(listView);
        handleSelection(listView);
    }

    /**
     * Handles the selection of an item in the list view.
     * @param listView The list view to handle selection for.
     */
    public static void handleSelection(ListView<ListItem> listView) {
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                ListItem item = listView.getSelectionModel().getSelectedItem();
                if (item != null) {
                    showIDAlert(item.getId());
                    idListSelected = item.getId();
                }
            }
        });
    }
    

    /*
     * Displays an alert with the ID of the selected item.
     * @param id The ID of the selected item.
     */
    private static void showIDAlert(String id) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("Item ID");
        alert.setHeaderText("ID of Selected Item");
        alert.setContentText("ID: " + id);
        TaskManager taskManager = new TaskManager();
        taskManager.listTasksByIdListToDo(id).forEach(task -> {
            if (task != null) {
                alert.setContentText(alert.getContentText() + "\n" + task.getTitle());
            }
        });


        alert.showAndWait();
    }


    public static void addButton() {
        showBox.getButton().setOnAction(e -> {
            AddListController addListController = new AddListController();
            addListController.createView();
        });
    }

    public ShowBox getShowBox() {
        return showBox;
    }

    public void setShowBox(ShowBox showBox) {
        ShowBoxController.showBox = showBox;
    }

    public static VBox getList() {
        return showBox.getList();
    }

    public static ArrayList<ListItem> getListID() {
        return listID;
    }

    public static String getIdListSelected() {
        return idListSelected;
    }

}
