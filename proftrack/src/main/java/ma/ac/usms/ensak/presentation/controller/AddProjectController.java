package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.presentation.Views.AddProjectView;

public class AddProjectController {
    private static ProjectManager projectManager = new ProjectManager();
    private static AddProjectView addProject = new AddProjectView();

    public void createView() {
<<<<<<< HEAD
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
=======
    };
>>>>>>> 8eb33131d7394f68a52ea828e4b77d5f98d8c34f

    public AddProjectView getAddProject() {
        return addProject;
    }


}
