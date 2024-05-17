package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.presentation.Views.AddProjectView;

public class AddProjectController {
    private static ProjectManager projectManager = new ProjectManager();
    private static AddProjectView addProject = new AddProjectView();

    public void createView() {
        addProject.getAddButton().setOnAction(e -> {
            projectManager.createProject(addProject.getProjectFromFields().getTitle(),
                    addProject.getProjectFromFields().getDescription(),
                    addProject.getProjectFromFields().getStart_date(),
                    addProject.getProjectFromFields().getEnd_date(),
                    addProject.getProjectFromFields().getCategory(),
                    addProject.getProjectFromFields().getType());
                    ShowBoxController.showProject(ShowBoxController.getProject());
            addProject.getStage().close();
        });

    }

    public AddProjectView getAddProject() {
        return addProject;
    }


}
