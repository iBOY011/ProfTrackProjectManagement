/**
 * This class is responsible for controlling the Add Task Configuration view.
 * It handles the creation of tasks and manages the event handlers for the view's components.
 */
package ma.ac.usms.ensak.presentation.controller;

import java.util.Date;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.exception.AlertHandler;
import ma.ac.usms.ensak.exception.InputValidator;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;
import ma.ac.usms.ensak.util.SharedData;
import ma.ac.usms.ensak.util.Status;

public class AddTaskConfigurationViewController {

    private AddTaskConfigurationView addTaskConfigurationView;
    private String idProject = null;
    private String idList = null;
    private Date startDate;
    private Date endDate;

    /**
     * Constructs an instance of AddTaskConfigurationViewController.
     * It initializes the view and sets up the event handlers.
     */
    public AddTaskConfigurationViewController() {
        addTaskConfigurationView = new AddTaskConfigurationView();

        setupEventHandlers();
        ControllerUtils.setProjectChoiceBoxItems(addTaskConfigurationView.getProjectChoiceBox());
        ControllerUtils.setListChoiceBoxItems(addTaskConfigurationView.getListChoiceBox());
    }

    /**
     * Sets up the event handlers for the view's components.
     */
    private void setupEventHandlers() {
        // Cancel button event handler
        addTaskConfigurationView.getCancelButton().setOnAction(e -> {
            Stage stage = (Stage) addTaskConfigurationView.getCancelButton().getScene().getWindow();
            ControllerUtils.closeStage(stage);
        });

        // Submit button event handler
        addTaskConfigurationView.getSubmitButton().setOnAction(e -> handleTaskCreation());

        // Project choice box event handler
        addTaskConfigurationView.getProjectChoiceBox().setOnAction(e -> {
            String selectedProject = addTaskConfigurationView.getProjectChoiceBox().getValue();
            idProject = ControllerUtils.getProjectIdByTitle(selectedProject);
        });

        // List choice box event handler
        addTaskConfigurationView.getListChoiceBox().setOnAction(e -> {
            String selectedList = addTaskConfigurationView.getListChoiceBox().getValue();
            idList = ControllerUtils.getListIdByTitle(selectedList);
        });

        // Start date picker event handler
        addTaskConfigurationView.getStartDatePicker().setOnAction(e -> {
            startDate = ControllerUtils.convertToDate(addTaskConfigurationView.getStartDatePicker().getValue());
        });

        // End date picker event handler
        addTaskConfigurationView.getEndDatePicker().setOnAction(e -> {
            endDate = ControllerUtils.convertToDate(addTaskConfigurationView.getEndDatePicker().getValue());
        });
    }

    /**
     * Handles the creation of a task.
     * It validates the input fields and creates a new task using the TaskManager.
     * Shows success or failure alerts accordingly.
     */
    private void handleTaskCreation() {
        TodayBoxController todayBoxController = SharedData.getInstance().getTodayBoxController();
        TaskManager taskManager = new TaskManager();

        // Check if all fields are filled
        if (addTaskConfigurationView.getStartDatePicker().getValue() == null || addTaskConfigurationView.getEndDatePicker().getValue() == null) {
            AlertHandler.showFailureAlert("Please fill all fields");
            return;
        } else if (!InputValidator.isValidDate(startDate, endDate)) {
            AlertHandler.showFailureAlert("End date must be after start date");
            return;
        }

        // Create task based on selected project and list
        if (idProject == null) {
            taskManager.createTask(
                todayBoxController.getTodayBox().getAddTask().getText(),
                addTaskConfigurationView.getDescriptionTextField().getText(),
                startDate,
                endDate,
                Status.IN_PROGRESS,
                idList,
                false
            );
        } else if (idList == null) {
            taskManager.createTask(
                todayBoxController.getTodayBox().getAddTask().getText(),
                addTaskConfigurationView.getDescriptionTextField().getText(),
                startDate,
                endDate,
                Status.IN_PROGRESS,
                idProject,
                true
            );
        } else {
            taskManager.createTask(
                todayBoxController.getTodayBox().getAddTask().getText(),
                addTaskConfigurationView.getDescriptionTextField().getText(),
                startDate,
                endDate,
                Status.IN_PROGRESS,
                idProject,
                idList
            );
        }

        AlertHandler.showSuccessAlert("Task added successfully");

        Stage stage = (Stage) addTaskConfigurationView.getSubmitButton().getScene().getWindow();
        ControllerUtils.closeStage(stage);
    }

    /**
     * Creates and displays the Add Task Configuration view.
     */
    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(addTaskConfigurationView, 350, 300));
        stage.setTitle("Add Task Configuration");
        stage.setResizable(false);
        stage.show();
    }

    /**
     * Returns the AddTaskConfigurationView instance associated with this controller.
     * @return The AddTaskConfigurationView instance.
     */
    public AddTaskConfigurationView getAddTaskConfigurationView() {
        return addTaskConfigurationView;
    }

    /**
     * Sets the project ID for the task.
     * @param idProject The project ID.
     */
    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    /**
     * Sets the list ID for the task.
     * @param idList The list ID.
     */
    public void setIdList(String idList) {
        this.idList = idList;
    }
}
