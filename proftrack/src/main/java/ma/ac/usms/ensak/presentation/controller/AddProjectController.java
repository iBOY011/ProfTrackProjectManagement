package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.exception.AlertHandler;
import ma.ac.usms.ensak.exception.InputValidator;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.presentation.Views.AddProjectView;

public class AddProjectController {
    private static ProjectManager projectManager = new ProjectManager();
    private static AddProjectView addProject;

    public void createView() {
        addProject = new AddProjectView();
        addProject.getAddButton().setOnAction(e -> {
            if (addProject.getProjectFromFields() == null) {
                AlertHandler.showFailureAlert("Please fill all fields");
                return;
            }
            try {
                projectManager.createProject(addProject.getProjectFromFields().getTitle(),
                        addProject.getProjectFromFields().getDescription(),
                        addProject.getProjectFromFields().getStart_date(),
                        addProject.getProjectFromFields().getEnd_date(),
                        addProject.getProjectFromFields().getCategory(),
                        addProject.getProjectFromFields().getType());
                ShowBoxController.showProject(ShowBoxController.getProject());
                AlertHandler.showSuccessAlert("Project added successfully");
                addProject.getStage().close();
            } catch (Exception ex) {
                AlertHandler.showFailureAlert("Project not added");
                return;
            }
        });

    }

    public AddProjectView getAddProject() {
        return addProject;
    }


}
