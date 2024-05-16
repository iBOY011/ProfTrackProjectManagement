package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.presentation.Views.AddProjectView;

public class AddProjectController {
    private static ProjectManager projectManager = new ProjectManager();
    private static AddProjectView addProject = new AddProjectView();

    public void createView() {
        addProject.getAddButton().setOnAction(e -> {
            projectManager.addProject(addProject.getProjectFromFields());
            addProject.close();
        });

    }

}
