package ma.ac.usms.ensak.presentation.controller;

import java.util.Date;
import java.util.List;
import java.time.LocalDate;
import java.time.ZoneId;

import javafx.scene.Scene;
import javafx.stage.Stage;
import ma.ac.usms.ensak.metier.POJO.ListToDo;
import ma.ac.usms.ensak.metier.POJO.Project;
import ma.ac.usms.ensak.metier.management.ListToDoManager;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.AddTaskConfigurationView;
import ma.ac.usms.ensak.util.SharedData;
import ma.ac.usms.ensak.util.Status;

public class AddTaskConfigurationViewController {

    private AddTaskConfigurationView AddTaskConfigurationView;
    private String idProject = null;
    private String idList = null;
    private Date startDate;
    private Date endDate;

    public AddTaskConfigurationViewController() {
        AddTaskConfigurationView = new AddTaskConfigurationView();

        AddTaskConfigurationView.getCancelButton().setOnAction(e -> {
            Stage stage = (Stage) AddTaskConfigurationView.getCancelButton().getScene().getWindow();
            stage.close();
        });

        AddTaskConfigurationView.getSubmitButton().setOnAction(e -> {

            TodayBoxController todayBoxController = getSameTodayBoxController();
            TaskManager taskManager = new TaskManager();
            if (idProject == null) {
                taskManager.createTask(todayBoxController.getTodayBox().getAddTask().getText(),
                        AddTaskConfigurationView.getDescriptionTextField().getText(), startDate,
                        endDate, Status.IN_PROGRESS, idList, false);
            } else if (idList == null) {
                taskManager.createTask(todayBoxController.getTodayBox().getAddTask().getText(),
                        AddTaskConfigurationView.getDescriptionTextField().getText(), startDate,
                        endDate, Status.IN_PROGRESS, idProject, true);
            } else {
                taskManager.createTask(todayBoxController.getTodayBox().getAddTask().getText(),
                        AddTaskConfigurationView.getDescriptionTextField().getText(), startDate,
                        endDate, Status.IN_PROGRESS, idProject, idList);
            }

            // Close the window
            Stage stage = (Stage) AddTaskConfigurationView.getSubmitButton().getScene().getWindow();
            stage.close();
        });

        setProjectChoiceBoxItems();
        AddTaskConfigurationView.getProjectChoiceBox().setOnAction(e -> {
            // Set the list choice box items based on the selected project
            String selectedProject = AddTaskConfigurationView.getProjectChoiceBox().getValue();
            ProjectManager projectManager = new ProjectManager();
            List<Project> projects = projectManager.listProjects();
            for (Project p : projects) {
                if (p.getTitle().contentEquals(selectedProject)) {
                    idProject = p.getId();
                }
            }
        });

        setListChoiceBoxItems();
        AddTaskConfigurationView.getListChoiceBox().setOnAction(e -> {
            // Set the list choice box items based on the selected project
            String selectedList = AddTaskConfigurationView.getListChoiceBox().getValue();
            ListToDoManager listToDoManager = new ListToDoManager();
            List<ListToDo> lists = listToDoManager.listListToDo();
            for (ListToDo l : lists) {
                if (l.getTitle().contentEquals(selectedList)) {
                    idList = l.getId();
                }
            }
        });

        AddTaskConfigurationView.getStartDatePicker().setOnAction(e -> {
            // Set the start date

            LocalDate localDate = AddTaskConfigurationView.getStartDatePicker().getValue();
            startDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        });

        AddTaskConfigurationView.getEndDatePicker().setOnAction(e -> {
            // Set the end date
            LocalDate localDate = AddTaskConfigurationView.getEndDatePicker().getValue();
            endDate = Date.from(localDate.atStartOfDay(ZoneId.systemDefault()).toInstant());
        });

    }

    public void createView() {
        Stage stage = new Stage();
        stage.setScene(new Scene(AddTaskConfigurationView, 300, 300));
        stage.setTitle("Add Task Configuration");
        stage.setResizable(false);
        stage.show();
    }

    public void setProjectChoiceBoxItems() {
        ProjectManager projectManager = new ProjectManager();
        List<Project> projects = projectManager.listProjects();
        for (Project p : projects) {
            AddTaskConfigurationView.getProjectChoiceBox().getItems().add(p.getTitle());
        }
    }

    public void setListChoiceBoxItems() {
        ListToDoManager listToDoManager = new ListToDoManager();
        List<ListToDo> lists = listToDoManager.listListToDo();
        for (ListToDo l : lists) {
            AddTaskConfigurationView.getListChoiceBox().getItems().add(l.getTitle());
        }
    }

    public TodayBoxController getSameTodayBoxController() {
        TodayBoxController todayBoxController = SharedData.getInstance().getTodayBoxController();
        return todayBoxController;
    }

    public AddTaskConfigurationView getAddTaskConfigurationView() {
        return AddTaskConfigurationView;
    }

}
