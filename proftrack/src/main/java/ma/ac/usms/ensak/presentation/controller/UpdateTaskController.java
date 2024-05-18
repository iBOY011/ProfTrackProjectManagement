package ma.ac.usms.ensak.presentation.controller;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.presentation.Views.UpdateTaskView;
import ma.ac.usms.ensak.metier.POJO.Task;
import ma.ac.usms.ensak.metier.management.TaskManager;

public class UpdateTaskController {
    private UpdateTaskView updateTaskView;
    private static final UpdateTaskController instance = new UpdateTaskController();

    private UpdateTaskController() {
        updateTaskView = new UpdateTaskView();
    }

    public static UpdateTaskController getInstance() {
        return instance;
    }

    public void createView() {
        updateTaskView = new UpdateTaskView();
        Stage stage = new Stage();
        stage.setScene(new Scene(updateTaskView, 600, 400));
        stage.setTitle("Update Task");
        stage.show();
    }

    public UpdateTaskView getUpdateTaskView() {
        return updateTaskView;
    }

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
