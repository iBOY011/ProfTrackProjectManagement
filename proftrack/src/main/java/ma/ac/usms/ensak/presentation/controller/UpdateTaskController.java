package ma.ac.usms.ensak.presentation.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.presentation.Views.UpdateTaskView;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.TaskManager;

/**
 * The controller class for updating a task.
 */
public class UpdateTaskController {
    private UpdateTaskView updateTaskView;
    private static final UpdateTaskController instance = new UpdateTaskController();

    /**
     * Private constructor to enforce singleton pattern.
     */
    private UpdateTaskController() {
        updateTaskView = new UpdateTaskView();
    }

    /**
     * Get the instance of the UpdateTaskController.
     * @return The instance of the UpdateTaskController.
     */
    public static UpdateTaskController getInstance() {
        return instance;
    }

    /**
     * Create and display the update task view.
     */
    public void createView() {
        updateTaskView = new UpdateTaskView();
        Stage stage = new Stage();
        stage.setScene(new Scene(updateTaskView, 600, 400));
        stage.setTitle("Update Task");
        stage.show();
    }

    /**
     * Get the update task view.
     * @return The update task view.
     */
    public UpdateTaskView getUpdateTaskView() {
        return updateTaskView;
    }

    /**
     * Update the show with the given task and list flag.
     * @param task The task to update.
     * @param isList Flag indicating if the task belongs to a list.
     */
    public void updateShow(Task task, boolean isList) {
        createView();
        updateTaskView.getTitleInput().setText(task.getTitle());
        updateTaskView.getDescriptionInput().setText(task.getDescription());
        updateTaskView.getStartDatePicker().setValue(ControllerUtils.convertToLocalDate(task.getStart_date()));
        updateTaskView.getEndDatePicker().setValue(ControllerUtils.convertToLocalDate(task.getEnd_date()));
        updateTaskView.getStatusComboBox().setValue(task.getStatus());
        updateTaskView.getUpdateButton().setOnAction((EventHandler<ActionEvent>) new EventHandler<javafx.event.ActionEvent>() {
            @Override
            public void handle(javafx.event.ActionEvent event) {
                update(task, isList);
            }
        });
    }

    /**
     * Update the task with the given values and perform necessary actions.
     * @param t The task to update.
     * @param isList Flag indicating if the task belongs to a list.
     */
    private void update(Task t, boolean isList) {
        t.setTitle(updateTaskView.getTitleInput().getText());
        t.setDescription(updateTaskView.getDescriptionInput().getText());
        t.setStart_date(ControllerUtils.convertToDate(updateTaskView.getStartDatePicker().getValue()));
        t.setEnd_date(ControllerUtils.convertToDate(updateTaskView.getEndDatePicker().getValue()));
        t.setStatus(updateTaskView.getStatusComboBox().getValue());
        TaskManager taskManager = new TaskManager();
        taskManager.updateTask(t);
        ControllerUtils.closeStage((Stage) updateTaskView.getScene().getWindow());
        if (isList) {
                TaskController.getInstance().showTasks(t.getId_ListToDo());
            } else {
                TaskController.getInstance().showProjectTasks(t.getId_project());
            }
    }
}
