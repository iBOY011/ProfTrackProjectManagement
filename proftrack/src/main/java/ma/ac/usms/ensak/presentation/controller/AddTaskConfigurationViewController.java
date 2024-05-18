package ma.ac.usms.ensak.presentation.controller;

import java.util.Date;

import javafx.scene.Scene;
import javafx.stage.Stage;
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

    public AddTaskConfigurationViewController() {
        addTaskConfigurationView = new AddTaskConfigurationView();

        setupEventHandlers();
        ControllerUtils.setProjectChoiceBoxItems(addTaskConfigurationView.getProjectChoiceBox());
        ControllerUtils.setListChoiceBoxItems(addTaskConfigurationView.getListChoiceBox());
    }

    private void setupEventHandlers() {
        addTaskConfigurationView.getCancelButton().setOnAction(e -> {
            Stage stage = (Stage) addTaskConfigurationView.getCancelButton().getScene().getWindow();
            ControllerUtils.closeStage(stage);
        });

        addTaskConfigurationView.getSubmitButton().setOnAction(e -> handleTaskCreation());

        addTaskConfigurationView.getProjectChoiceBox().setOnAction(e -> {
            String selectedProject = addTaskConfigurationView.getProjectChoiceBox().getValue();
            idProject = ControllerUtils.getProjectIdByTitle(selectedProject);
        });

        addTaskConfigurationView.getListChoiceBox().setOnAction(e -> {
            String selectedList = addTaskConfigurationView.getListChoiceBox().getValue();
            idList = ControllerUtils.getListIdByTitle(selectedList);
        });

        addTaskConfigurationView.getStartDatePicker().setOnAction(e -> {
            startDate = ControllerUtils.convertToDate(addTaskConfigurationView.getStartDatePicker().getValue());
        });

        addTaskConfigurationView.getEndDatePicker().setOnAction(e -> {
            endDate = ControllerUtils.convertToDate(addTaskConfigurationView.getEndDatePicker().getValue());
        });
    }

    private void handleTaskCreation() {
        TodayBoxController todayBoxController = SharedData.getInstance().getTodayBoxController();
        TaskManager taskManager = new TaskManager();
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

        Stage stage = (Stage) addTaskConfigurationView.getSubmitButton().getScene().getWindow();
        ControllerUtils.closeStage(stage);
    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(addTaskConfigurationView, 350, 300));
        stage.setTitle("Add Task Configuration");
        stage.setResizable(false);
        stage.show();
    }

    public AddTaskConfigurationView getAddTaskConfigurationView() {
        return addTaskConfigurationView;
    }

    public void setIdProject(String idProject) {
        this.idProject = idProject;
    }

    public void setIdList(String idList) {
        this.idList = idList;
    }
}
