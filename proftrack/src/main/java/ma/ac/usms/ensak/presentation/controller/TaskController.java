package ma.ac.usms.ensak.presentation.controller;

import java.util.List;

import org.checkerframework.checker.units.qual.s;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.ListView;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseButton;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.POJO.WorkSession;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.metier.management.WorkSessionManager;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;
import ma.ac.usms.ensak.presentation.Views.TasksView;
import ma.ac.usms.ensak.util.ListItem;
import ma.ac.usms.ensak.util.Status;

public class TaskController {
    private static final TaskController instance = new TaskController();
    private final TaskManager taskManager = new TaskManager();
    private final TasksView tasksView = new TasksView();

    private TaskController() {
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

        List<Task> tasks = taskManager.listTasksByIdListToDo(listId);
        tasks.forEach(task -> tasksView.getListTask().getChildren().add(createTaskItem(task, true)));

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

        List<Task> tasks = taskManager.listTasksByIdProject(projectId);
        tasks.forEach(task -> tasksView.getListTask().getChildren().add(createTaskItem(task, false)));

        WorkSessionManager workSessionManager = new WorkSessionManager();
        List<WorkSession> workSessions = workSessionManager.listWorkSessionsByIdProject(projectId);
        workSessions.forEach(ws -> tasksView.getListWorkSession().getChildren().add(createWorkSessionItem(ws)));

        tasksView.getInformationButton().setOnAction(e -> addTaskToProject(projectId));
    }

    private void setupTasksViewHeader(String headerText) {
        tasksView.getHeaderLabel().setText(headerText);
    }

    private HBox createTaskItem(Task task, Boolean isList) {
        CheckBox checkBox = new CheckBox();
        checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
        checkBox.setOnAction(e -> {
            task.setStatus(Status.DONE);
            taskManager.updateTask(task);
            if (isList) {
                showTasks(task.getId_ListToDo());
            } else {
                showProjectTasks(task.getId_project());

            }
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

    private HBox createWorkSessionItem(WorkSession workSession) {
        CheckBox checkBox = new CheckBox();
        checkBox.setStyle("-fx-cursor: hand; -fx-font-size: 14px;");
        Button button = new Button(workSession.getDateDebut().toString() + " - " + workSession.getDateFin().toString());
        button.setStyle(
                "-fx-background-color: transparent; -fx-border-color: transparent; -fx-cursor: hand; -fx-font-size: 10px;");
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

        // Event handler for archive item (only for projects)
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

    private TaskManager getTaskManager() {
        return taskManager;
    }

    public static void showTaskDetails(Task task) {
        DetailsController.showDetails(task.getId(), false, true);
        DetailsController.showDocument(false, task);

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
}
