package ma.ac.usms.ensak.presentation.controller;

import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.ShowBox;
import ma.ac.usms.ensak.util.Category;
import ma.ac.usms.ensak.util.ListItem;
import ma.ac.usms.ensak.exception.*;

/**
 * The ShowBoxController class is responsible for managing the display and
 * interaction
 * with the ShowBox view. It handles the logic for showing a list of items,
 * handling
 * item selection, and adding new lists.
 */
public class ShowBoxController {
    private static ListToDoManager listToDoManager = new ListToDoManager();
    private static ProjectManager projectManager = new ProjectManager();
    private static ShowBox showBox = new ShowBox();
    private static ArrayList<ListItem> listID = new ArrayList<>();
    private static ArrayList<ListItem> ProjectID = new ArrayList<>();
    private static String idListSelected = "";
    private static String idProjectSelected = "";
    private static Category category = null;

    public ShowBoxController() {

        if (showBox == null) {
            showBox = new ShowBox();
        }
        showBox.getToday().setOnMouseClicked(e -> {
            TodayBoxController todayBoxController1 = new TodayBoxController();
            VBox todayBox = todayBoxController1.getTodayBox();
            VBox tBox = HomeController.getTodayView().getTodayBox();
            tBox.getChildren().clear();
            tBox.getChildren().add(todayBox);
        });
        showList(showBox.getList());
        showProject(showBox.getProject());
    }

    /**
     * Displays a list of ListToDo items in the given VBox.
     * 
     * @param list
     */
    public static void showList(VBox list) {
        list.getChildren().clear();
        list.getChildren().add(showBox.createLabel("Lists", true));

        ObservableList<ListItem> items = FXCollections.observableArrayList();
        ListView<ListItem> listView = new ListView<>(items);
        // set class list-view
        listView.getStyleClass().add("list-view");

        listToDoManager.listListToDo().forEach(listToDo -> {
            ListItem listItem = new ListItem(listToDo.getId(), listToDo.getTitle());
            items.add(listItem);
            listID.add(listItem);
        });
        listView.setStyle("-fx-font-size: 15px; -fx-padding: 0; -fx-background-color: black;");
        listView.getStyleClass().add("list-view");
        list.getChildren().add(listView);
        ListContextMenu(listView, true);
        handleSelection(listView, true);
        addListButton();

    }

    /**
     * Displays a list of Project items in the given VBox.
     * 
     * @param list
     */
    public static void showProject(VBox list) {
        list.getChildren().clear();
        list.getChildren().add(showBox.createLabel("Projects", false));

        ObservableList<ListItem> items = FXCollections.observableArrayList();
        ListView<ListItem> listView = new ListView<>(items);

        projectManager.listProjects().forEach(project -> {
            if (!project.isArchived()) {
            ListItem listItem = new ListItem(project.getId(), project.getTitle());
            items.add(listItem);
            ProjectID.add(listItem);
            }
        });
        listView.setStyle("-fx-font-size: 15px; -fx-padding: 0; -fx-background-color: black;");
        list.getChildren().add(listView);
        ListContextMenu(listView, false);
        handleSelection(listView, false);
        addProjectButton();
        filterProject();
    }

    /**
     * Handles the selection of an item in the list view.
     * 
     * @param listView The list view to handle selection for.
     */
    public static void handleSelection(ListView<ListItem> listView, Boolean FLAG) {
        listView.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                if (event.getButton() == MouseButton.PRIMARY && event.getClickCount() == 1) {
                    // Left-clicked
                    ListItem item = listView.getSelectionModel().getSelectedItem();
                    if (item != null) {
                        DetailsController.DisableDocumentBox(FLAG);
                        DetailsController.DisableWorkSessionBox(FLAG);
                        if (FLAG) {
                            idListSelected = item.getId();
                            showListDescription();
                            VBox todayBox = HomeController.getTodayView().getTodayBox(); 
                            todayBox.getChildren().clear();
                            todayBox.getChildren().add(TaskController.getInstance().getTasksView());
                            TaskController.getInstance().showTasks(idListSelected);

                        } else {
                            idProjectSelected = item.getId();
                            DetailsController.showDocument(true, null);
                            DetailsController.showWorkSession();
                            showProjectDescription();
                            VBox todayBox = HomeController.getTodayView().getTodayBox();
                            todayBox.getChildren().clear();
                            todayBox.getChildren().add(TaskController.getInstance().getTasksView());
                            TaskController.getInstance().showProjectTasks(idProjectSelected);
                        }
                    }
                }
            }
        });
    }

    /*
     * Displays an alert with the ID of the selected item.
     * 
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

    public static void addListButton() {
        showBox.getListButton().setOnAction(e -> {
            AddListController addListController = new AddListController();
            addListController.createView();
        });
    }

    public static void addProjectButton() {
        showBox.getaddProjectButton().setOnAction(e -> {
            AddProjectController addProjectController = new AddProjectController();
            addProjectController.createView();
        });
    }

    public static void ListContextMenu(ListView<ListItem> listView, Boolean FLAG) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem deleteItem = new MenuItem("Delete");
        MenuItem archiveItem = null;

        // Event handler for delete item
        EventHandler<ActionEvent> deleteHandler = e -> {
            ListItem selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                if (FLAG) {
                    if (ConfirmationDialog.showConfirmationDialog("Are you sure you want to delete this list?")) {
                        listToDoManager.removeListToDo(selectedItem.getId());
                        showList(showBox.getList());
                        AlertHandler.showSuccessAlert("List deleted successfully");
                    }
                } else {
                    if (ConfirmationDialog.showConfirmationDialog("Are you sure you want to delete this Project?")) {
                    projectManager.removeProject(selectedItem.getId());
                    showProject(showBox.getProject());
                    AlertHandler.showSuccessAlert("Project deleted successfully");
                    }
                }
            }
        };

        // Event handler for archive item (only for projects)
        EventHandler<ActionEvent> archiveHandler = e -> {
            ListItem selectedItem = listView.getSelectionModel().getSelectedItem();
            if (selectedItem != null) {
                if (ConfirmationDialog.showConfirmationDialog("Are you sure you want to archive this project?")) {
                    try {
                        Project project = projectManager.searchProjectById(selectedItem.getId());
                        projectManager.archiveProject(project);
                        showProject(showBox.getProject());
                        AlertHandler.showSuccessAlert("Project archived successfully");
                    } catch (Exception ex) {
                        AlertHandler.showFailureAlert("Failed to archive project");
                    }
                }
            }
        };

        deleteItem.setOnAction(deleteHandler); // Set delete handler always

        // Add archive item only if FLAG is false (for projects)
        if (!FLAG) {
            archiveItem = new MenuItem("Archive");
            archiveItem.setOnAction(archiveHandler);
            contextMenu.getItems().add(archiveItem);
        }

        contextMenu.getItems().addAll(deleteItem);
        listView.setContextMenu(contextMenu); // Set context menu to the ListView
    }

    public static void filterProject() {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem category1 = new MenuItem(Category.ACADEMIC.toString());
        MenuItem category2 = new MenuItem(Category.RESEARCH.toString());
        MenuItem category3 = new MenuItem(Category.SUPERVISION.toString());
        MenuItem category4 = new MenuItem(Category.OTHER.toString());
        MenuItem category5 = new MenuItem("All");
        showBox.getFilterButton().setOnMouseClicked(e -> {
            contextMenu.getItems().addAll(category1, category2, category3, category4, category5);
            contextMenu.show(showBox.getFilterButton(), e.getScreenX(), e.getScreenY());
        });

        category1.setOnAction(e -> {
            category = Category.ACADEMIC;
            filterProjectByCategory(category);
        });

        category2.setOnAction(e -> {
            category = Category.RESEARCH;
            filterProjectByCategory(category);
        });

        category3.setOnAction(e -> {
            category = Category.SUPERVISION;
            filterProjectByCategory(category);
        });

        category4.setOnAction(e -> {
            category = Category.OTHER;
            filterProjectByCategory(category);
        });

        category5.setOnAction(e -> {
            showProject(showBox.getProject());
        });

    }

    public static void filterProjectByCategory(Category category) {
        showBox.getProject().getChildren().clear();
        showBox.getProject().getChildren().add(showBox.createLabel("Projects", false));
        ObservableList<ListItem> items = FXCollections.observableArrayList();
        ListView<ListItem> listView = new ListView<>(items);

        projectManager.listProjects().forEach(project -> {
            if (project.getCategory().equals(category) && !project.isArchived()) {
                ListItem listItem = new ListItem(project.getId(), project.getTitle());
                items.add(listItem);
                ProjectID.add(listItem);
            }
        });
        listView.setStyle("-fx-font-size: 15px; -fx-padding: 0; -fx-background-color: #04ECFF;");
        showBox.getProject().getChildren().add(listView);
        ListContextMenu(listView, false);
        handleSelection(listView, false);
        addProjectButton(); 
        filterProject();
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

    public static String getIdProjectSelected() {
        return idProjectSelected;
    }

    public static VBox getProject() {
        return showBox.getProject();
    }

    private static void showProjectDescription() {
        if (idProjectSelected != null) {
            DetailsController.showDetails(idProjectSelected, false, false);
        }
    }

    private static void showListDescription() {
        if (idListSelected != null) {
            DetailsController.showDetails(idListSelected, true, false);
        }
    }


}
