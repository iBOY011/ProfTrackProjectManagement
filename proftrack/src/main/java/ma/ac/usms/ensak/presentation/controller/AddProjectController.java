/**
 * The AddProjectController class is responsible for controlling the addition of a new project.
 * It interacts with the ProjectManager and AddProjectView classes to handle user input and display appropriate alerts.
 */
package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.exception.AlertHandler;
import ma.ac.usms.ensak.exception.InputValidator;
import ma.ac.usms.ensak.metier.management.ProjectManager;
import ma.ac.usms.ensak.presentation.Views.AddProjectView;

public class AddProjectController {
    private static ProjectManager projectManager = new ProjectManager();
    private static AddProjectView addProject;

    /**
     * Creates an instance of the AddProjectView and sets the action for the add button.
     * When the add button is clicked, it validates the input fields and creates a new project using the ProjectManager.
     * If the project is created successfully, it displays a success alert and closes the add project view.
     * If an exception occurs during the creation of the project, it displays a failure alert.
     */
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

    /**
     * Returns the AddProjectView instance.
     * @return The AddProjectView instance.
     */
    public AddProjectView getAddProject() {
        return addProject;
    }
}
