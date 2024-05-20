/**
 * The TaskController class is responsible for managing tasks in the application.
 * It handles the creation, display, and manipulation of tasks.
 */
package ma.ac.usms.ensak.presentation.controller;

import java.util.List;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;
import ma.ac.usms.ensak.presentation.Views.TasksView;
import ma.ac.usms.ensak.util.Status;
import ma.ac.usms.ensak.exception.*;


public class TaskController {
    private static final TaskController instance = new TaskController();
    private final TaskManager taskManager = new TaskManager();
    private TasksView tasksView = new TasksView();
    private List<Task> tasks;
    private String status = "All";

    private TaskController() {
        tasksView.getFilterComboBox().setOnAction(e -> filterTasksByStatus(tasksView.getListTask().getChildren().contains(tasksView.getShowTask())));
    }

    public static TaskController getInstance() {
        return instance;
    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(tasksView, 600, 400));
        stage.setTitle("Tasks");
        stage.show();
    }

    public void showTasks(String listId) {
        ListToDoManager listToDoManager = new ListToDoManager();
        ListToDo list = listToDoManager.searchListeToDoById(listId);

        setupTasksViewHeader(list.getTitle() + " List:");
        tasksView.setVisibleListWorkSession(false);
        tasksView.getListTask().getChildren().clear();
        tasksView.getShowTask().setText("Tasks:");
        tasksView.getListTask().getChildren().add(tasksView.getShowTask());

        tasks = taskManager.listTasksByIdListToDo(listId);
        filterTasksByStatus(true);

        tasksView.getInformationButton().setOnAction(e -> addTaskToList(listId));
    }

    public void showProjectTasks(String projectId) {
        ProjectManager projectManager = new ProjectManager();
        Project project = projectManager.searchProjectById(projectId);

        setupTasksViewHeader(project.getTitle() + " Project:");
        tasksView.setVisibleListWorkSession(true);
        tasksView.getListTask().getChildren().clear();
        tasksView.getListWorkSession().getChildren().clear();
        tasksView.getShowWorkSession().setText("Work Sessions:");
        tasksView.getShowTask().setText("Tasks:");
        tasksView.getListTask().getChildren().add(tasksView.getShowTask());

        tasks = taskManager.listTasksByIdProject(projectId);
        filterTasksByStatus(false);

        tasksView.getInformationButton().setOnAction(e -> addTaskToProject(projectId));
    }

    private void setupTasksViewHeader(String headerText) {
        tasksView.getHeaderLabel().setText(headerText);
    }

    private HBox createTaskItem(Task task, Boolean isList) {
        CheckBox checkBox = new CheckBox();
        checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
        checkBox.setOnAction(e -> {
            try {
                task.setStatus(Status.DONE);
                taskManager.updateTask(task);
                AlertHandler.showSuccessAlert(AlertHandler.getFinishedTaskSentence());
            } catch (Exception h) {
                AlertHandler.showFailureAlert("Task not finished");
            }
            filterTasksByStatus(isList);
        });
        if (task.getStatus() == Status.DONE) {
            checkBox.setSelected(true);
            checkBox.setDisable(true);

        }
        Button button = new Button(task.getTitle());
        button.setOnAction(e -> {
            showTaskDetails(task);
            AddDocumentController.addDocTask(task);
        });
        button.setStyle(
                "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");
        ListContextMenu(button, task, isList, checkBox);
        HBox hBox = new HBox(checkBox, button);
        hBox.setStyle("-fx-spacing: 10px; -fx-alignment: center-left;");
        return hBox;
    }

    private void addTaskToProject(String projectId) {
        AddTaskConfigurationViewController addTaskController = new AddTaskConfigurationViewController();
        addTaskController.createView();
        AddTaskConfigurationView addTaskView = addTaskController.getAddTaskConfigurationView();
        addTaskView.setIdProject(projectId);
        disableChoiceBoxes(addTaskView);

        addTaskView.getSubmitButton().setOnAction(e -> {
            try {
                if (!InputValidator.isValidDate(ControllerUtils.convertToDate(addTaskView.getStartDatePicker().getValue()), ControllerUtils.convertToDate(addTaskView.getEndDatePicker().getValue()))){
                    return;
                } else if (addTaskView.getDescriptionTextField().getText().isEmpty()){
                    AlertHandler.showFailureAlert("Please fill all fields");
                    return;
                }
            } catch (NullPointerException ex) {
                AlertHandler.showFailureAlert("Please enter a valid date.");
                return;
            }
            taskManager.createTask(
                    tasksView.getAddTask().getText(),
                    addTaskView.getDescriptionTextField().getText(),
                    ControllerUtils.convertToDate(addTaskView.getStartDatePicker().getValue()),
                    ControllerUtils.convertToDate(addTaskView.getEndDatePicker().getValue()),
                    Status.IN_PROGRESS,
                    projectId,
                    true);
            closeAddTaskView(addTaskView);
            showProjectTasks(projectId);
        });
    }

    private void addTaskToList(String listId) {
        AddTaskConfigurationViewController addTaskController = new AddTaskConfigurationViewController();
        addTaskController.createView();
        AddTaskConfigurationView addTaskView = addTaskController.getAddTaskConfigurationView();
        addTaskView.setIdList(listId);
        disableChoiceBoxes(addTaskView);

        addTaskView.getSubmitButton().setOnAction(e -> {
            try {
                if (!InputValidator.isValidDate(ControllerUtils.convertToDate(addTaskView.getStartDatePicker().getValue()), ControllerUtils.convertToDate(addTaskView.getEndDatePicker().getValue()))){
                    return;
                } else if (addTaskView.getDescriptionTextField().getText().isEmpty()){
                    AlertHandler.showFailureAlert("Please fill all fields");
                    return;
                }
            } catch (NullPointerException ex) {
                AlertHandler.showFailureAlert("Please enter a valid date.");
                return;
            }
            taskManager.createTask(
                    tasksView.getAddTask().getText(),
                    addTaskView.getDescriptionTextField().getText(),
                    ControllerUtils.convertToDate(addTaskView.getStartDatePicker().getValue()),
                    ControllerUtils.convertToDate(addTaskView.getEndDatePicker().getValue()),
                    Status.IN_PROGRESS,
                    listId,
                    false);
            closeAddTaskView(addTaskView);
            showTasks(listId);
        });
    }


     public static void ListContextMenu(Button b, Task t, Boolean isList, CheckBox checkBox) {
        ContextMenu contextMenu = new ContextMenu();
        MenuItem UpdateItem = new MenuItem("Update");
        MenuItem deleteItem = new MenuItem("Delete");

        // Event handler for delete item
        EventHandler<ActionEvent> deleteHandler = e -> {
            TaskManager taskManager = new TaskManager();
            taskManager.removeTask(t.getId());
            if (isList) {
                TaskController.getInstance().showTasks(t.getId_ListToDo());
            } else {
                TaskController.getInstance().showProjectTasks(t.getId_project());
            }
        };

        EventHandler<ActionEvent> updateHandler = e -> {
            UpdateTaskController.getInstance().updateShow(t, isList);
        };

        deleteItem.setOnAction(deleteHandler);
        UpdateItem.setOnAction(updateHandler);

        contextMenu.getItems().addAll(UpdateItem, deleteItem);

        b.setOnMouseClicked(e -> {
            if (e.getButton() == MouseButton.SECONDARY) {
                contextMenu.show(b, e.getScreenX(), e.getScreenY());
            }
        });
    }

    public static void showTaskDetails(Task task) {
        DetailsController.showDetails(task.getId(), false, true);
        DetailsController.showDocument(false, task);
        DetailsController.DisableWorkSessionBox(true);

    }

    private void disableChoiceBoxes(AddTaskConfigurationView addTaskView) {
        addTaskView.getProjectChoiceBox().setDisable(true);
        addTaskView.getListChoiceBox().setDisable(true);
    }

    private void closeAddTaskView(AddTaskConfigurationView addTaskView) {
        Stage stage = (Stage) addTaskView.getSubmitButton().getScene().getWindow();
        ControllerUtils.closeStage(stage);
    }

    public TasksView getTasksView() {
        return tasksView;
    }

    public void filterTasksByStatus(Boolean isList) {
        status = tasksView.getFilterComboBox().getValue();
        tasksView.getListTask().getChildren().clear();
        tasksView.getListTask().getChildren().add(tasksView.getShowTask());

        tasks.forEach(task -> {
            if (status.equals("All") || 
                (status.equals("Completed") && task.getStatus() == Status.DONE) || 
                (status.equals("Uncompleted") && (task.getStatus() == Status.IN_PROGRESS || task.getStatus() == Status.TODO))) {
                tasksView.getListTask().getChildren().add(createTaskItem(task, isList));
            }
        });
    }
}
