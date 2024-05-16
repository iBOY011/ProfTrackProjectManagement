package ma.ac.usms.ensak.presentation.controller;

import ma.ac.usms.ensak.metier.management.TaskManager;
import ma.ac.usms.ensak.presentation.Views.VBoxes.DetailsBox;
import ma.ac.usms.ensak.metier.POJO.Task;;

public class DetailsController {
    private static TaskManager taskManager = new TaskManager();
    private static DetailsBox detailsBox = new DetailsBox();

    public DetailsController() {

    }

    public DetailsBox getDetailsBox() {
        return detailsBox;
    }

    public void showDetails(String idTask) {
        Task task = taskManager.searchTaskById(idTask);
        detailsBox.getDescriptionArea().setText(task.getDescription());
    }
}
